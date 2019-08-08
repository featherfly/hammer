
package cn.featherfly.juorm.rdb.jdbc;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.hibernate.validator.HibernateValidator;

import cn.featherfly.common.lang.LangUtils;
import cn.featherfly.common.lang.StringUtils;
import cn.featherfly.common.structure.page.Page;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.juorm.Juorm;
import cn.featherfly.juorm.dsl.execute.Delete;
import cn.featherfly.juorm.dsl.execute.Update;
import cn.featherfly.juorm.dsl.query.QueryEntity;
import cn.featherfly.juorm.expression.SimpleRepository;
import cn.featherfly.juorm.rdb.jdbc.dsl.execute.SqlDeleter;
import cn.featherfly.juorm.rdb.jdbc.dsl.execute.SqlUpdater;
import cn.featherfly.juorm.rdb.jdbc.dsl.query.SqlQuery;
import cn.featherfly.juorm.rdb.jdbc.mapping.ClassMapping;
import cn.featherfly.juorm.rdb.jdbc.mapping.MappingFactory;
import cn.featherfly.juorm.rdb.jdbc.operate.DeleteOperate;
import cn.featherfly.juorm.rdb.jdbc.operate.GetOperate;
import cn.featherfly.juorm.rdb.jdbc.operate.InsertOperate;
import cn.featherfly.juorm.rdb.jdbc.operate.MergeOperate;
import cn.featherfly.juorm.rdb.jdbc.operate.UpdateOperate;
import cn.featherfly.juorm.rdb.tpl.SqlTplExecutor;
import cn.featherfly.juorm.tpl.TplConfigFactory;
import cn.featherfly.juorm.tpl.TplConfigFactoryImpl;

/**
 * <p>
 * JuormSqlImpl
 * </p>
 *
 * @author zhongj
 */
public class JuormJdbcImpl implements Juorm {

    private Jdbc jdbc;

    private MappingFactory mappingFactory;

    private Validator validator;

    private SqlTplExecutor sqlTplExecutor;

    private Map<Class<?>, InsertOperate<?>> insertOperates = new HashMap<>();
    private Map<Class<?>, UpdateOperate<?>> updateOperates = new HashMap<>();
    private Map<Class<?>, GetOperate<?>> getOperates = new HashMap<>();
    private Map<Class<?>, DeleteOperate<?>> deleteOperates = new HashMap<>();
    private Map<Class<?>, MergeOperate<?>> mergeOperates = new HashMap<>();

    /**
     * @param jdbc
     * @param mappingFactory
     */
    public JuormJdbcImpl(Jdbc jdbc, MappingFactory mappingFactory) {
        this(jdbc, mappingFactory, new TplConfigFactoryImpl());
    }

    /**
     * @param jdbc
     * @param mappingFactory
     * @param configFactory
     */
    public JuormJdbcImpl(Jdbc jdbc, MappingFactory mappingFactory,
            TplConfigFactory configFactory) {
        // this(jdbc, mappingFactory, configFactory,
        // Validation.buildDefaultValidatorFactory().getValidator());
        this(jdbc, mappingFactory, configFactory,
                Validation.byProvider(HibernateValidator.class).configure()
                        .failFast(false).buildValidatorFactory()
                        .getValidator());
    }

    /**
     * @param jdbc
     * @param mappingFactory
     * @param configFactory
     * @param validator
     */
    public JuormJdbcImpl(Jdbc jdbc, MappingFactory mappingFactory,
            TplConfigFactory configFactory, Validator validator) {
        this.jdbc = jdbc;
        this.mappingFactory = mappingFactory;
        this.validator = validator;
        sqlTplExecutor = new SqlTplExecutor(configFactory, jdbc,
                mappingFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int save(E entity) {
        if (entity == null) {
            return 0;
        }
        @SuppressWarnings("unchecked")
        InsertOperate<E> insert = (InsertOperate<E>) insertOperates.get(entity);
        if (insert == null) {
            @SuppressWarnings("unchecked")
            ClassMapping<E> mapping = (ClassMapping<E>) mappingFactory
                    .getClassMapping(entity.getClass());
            insert = new InsertOperate<>(jdbc, mapping);
            insertOperates.put(entity.getClass(), insert);
        }
        validate(entity);
        return insert.execute(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int save(List<E> entities) {
        // TODO 后续加入InsertBatchOperate优化为sql批量插入
        int size = 0;
        if (LangUtils.isNotEmpty(entities)) {
            for (E e : entities) {
                size += save(e);
            }
        }
        return size;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int update(E entity) {
        if (entity == null) {
            return 0;
        }
        @SuppressWarnings("unchecked")
        UpdateOperate<E> update = (UpdateOperate<E>) updateOperates.get(entity);
        if (update == null) {
            @SuppressWarnings("unchecked")
            ClassMapping<E> mapping = (ClassMapping<E>) mappingFactory
                    .getClassMapping(entity.getClass());
            update = new UpdateOperate<>(jdbc, mapping);
            updateOperates.put(entity.getClass(), update);
        }
        validate(entity);
        return update.execute(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int update(List<E> entities) {
        int size = 0;
        if (LangUtils.isNotEmpty(entities)) {
            for (E e : entities) {
                size += update(e);
            }
        }
        return size;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int update(E entity, IgnorePolicy ignorePolicy) {
        switch (ignorePolicy) {
        case EMPTY:
            return merge(entity);
        case NULL:
            return merge(entity, true);
        default:
            return update(entity);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int update(List<E> entities, IgnorePolicy ignorePolicy) {
        int size = 0;
        if (LangUtils.isNotEmpty(entities)) {
            for (E e : entities) {
                size += update(e, ignorePolicy);
            }
        }
        return size;
    }

    private <E> int merge(E entity, boolean onlyNull) {
        if (entity == null) {
            return 0;
        }
        @SuppressWarnings("unchecked")
        MergeOperate<E> update = (MergeOperate<E>) mergeOperates.get(entity);
        if (update == null) {
            @SuppressWarnings("unchecked")
            ClassMapping<E> mapping = (ClassMapping<E>) mappingFactory
                    .getClassMapping(entity.getClass());
            update = new MergeOperate<>(jdbc, mapping);
            mergeOperates.put(entity.getClass(), update);
        }
        validate(entity);
        return update.execute(entity, onlyNull);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int merge(E entity) {
        return merge(entity, false);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int merge(List<E> entities) {
        int size = 0;
        if (LangUtils.isNotEmpty(entities)) {
            for (E e : entities) {
                size += merge(e);
            }
        }
        return size;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int delete(E entity) {
        if (entity == null) {
            return 0;
        }
        @SuppressWarnings("unchecked")
        DeleteOperate<E> delete = (DeleteOperate<E>) deleteOperates.get(entity);
        if (delete == null) {
            @SuppressWarnings("unchecked")
            ClassMapping<E> mapping = (ClassMapping<E>) mappingFactory
                    .getClassMapping(entity.getClass());
            delete = new DeleteOperate<>(jdbc, mapping);
            deleteOperates.put(entity.getClass(), delete);
        }
        return delete.execute(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int delete(List<E> entities) {
        // TODO 后续加入DeleteBatchOperate优化为sql批量删除
        int size = 0;
        if (LangUtils.isNotEmpty(entities)) {
            for (E e : entities) {
                size += delete(e);
            }
        }
        return size;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E get(Serializable id, Class<E> type) {
        if (id == null || type == null) {
            return null;
        }
        GetOperate<E> get = getOperate(type);
        return get.get(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E get(E entity) {
        if (entity == null) {
            return null;
        }
        @SuppressWarnings("unchecked")
        GetOperate<E> get = (GetOperate<E>) getOperate(entity.getClass());
        return get.get(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> QueryEntity query(Class<E> entityType) {
        SqlQuery query = new SqlQuery(jdbc);
        ClassMapping<E> mapping = mappingFactory.getClassMapping(entityType);
        // TODO 后续把mapping传递下去，可以直接使用属性和字段都能进行操作，并且做一定的验证操作，验证属性（字段）存在与否
        return query.find(new SimpleRepository(mapping.getTableName(),
                StringUtils.substring(mapping.getTableName(), 0, 1)
                        .toLowerCase()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> Update update(Class<E> entityType) {
        SqlUpdater updater = new SqlUpdater(jdbc);
        ClassMapping<E> mapping = mappingFactory.getClassMapping(entityType);
        return updater.update(mapping.getTableName());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> Delete delete(Class<E> entityType) {
        SqlDeleter deleter = new SqlDeleter(jdbc);
        ClassMapping<E> mapping = mappingFactory.getClassMapping(entityType);
        return deleter.delete(mapping.getTableName());
    }

    private <E> void validate(E entity) {
        if (validator != null) {
            Set<ConstraintViolation<E>> cons = validator.validate(entity);
            if (LangUtils.isNotEmpty(cons)) {
                StringBuilder errorMessage = new StringBuilder();
                for (ConstraintViolation<E> constraintViolation : cons) {
                    errorMessage.append(constraintViolation.getMessage())
                            .append(",");
                }
                throw new JuormJdbcException(errorMessage.toString());
            }
        }
    }

    private <E> GetOperate<E> getOperate(Class<E> entityType) {
        @SuppressWarnings("unchecked")
        GetOperate<E> get = (GetOperate<E>) getOperates.get(entityType);
        if (get == null) {
            ClassMapping<E> mapping = mappingFactory
                    .getClassMapping(entityType);
            get = new GetOperate<>(jdbc, mapping);
            getOperates.put(entityType.getClass(), get);
        }
        return get;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E single(String sqlFullId, Class<E> entityType,
            Map<String, Object> params) {
        return sqlTplExecutor.single(sqlFullId, entityType, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(String sqlFullId, Class<E> entityType,
            Map<String, Object> params) {
        return sqlTplExecutor.list(sqlFullId, entityType, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(String sqlFullId, Class<E> entityType,
            Map<String, Object> params, int offset, int limit) {
        return sqlTplExecutor.list(sqlFullId, entityType, params, offset,
                limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(String sqlFullId, Class<E> entityType,
            Map<String, Object> params, Page page) {
        return sqlTplExecutor.list(sqlFullId, entityType, params, page);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> PaginationResults<E> pagination(String sqlFullId,
            Class<E> entityType, Map<String, Object> params, int offset,
            int limit) {
        return sqlTplExecutor.pagination(sqlFullId, entityType, params, offset,
                limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> PaginationResults<E> pagination(String sqlFullId,
            Class<E> entityType, Map<String, Object> params, Page page) {
        return sqlTplExecutor.pagination(sqlFullId, entityType, params, page);
    }
}
