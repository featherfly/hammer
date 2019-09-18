
package cn.featherfly.juorm.rdb.jdbc;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.hibernate.validator.HibernateValidator;

import cn.featherfly.common.lang.LangUtils;
import cn.featherfly.common.structure.page.Page;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.juorm.Juorm;
import cn.featherfly.juorm.dsl.execute.Delete;
import cn.featherfly.juorm.dsl.execute.Update;
import cn.featherfly.juorm.dsl.query.QueryEntity;
import cn.featherfly.juorm.dsl.query.TypeQueryEntity;
import cn.featherfly.juorm.mapping.ClassMapping;
import cn.featherfly.juorm.rdb.jdbc.dsl.execute.SqlDeleter;
import cn.featherfly.juorm.rdb.jdbc.dsl.execute.SqlUpdater;
import cn.featherfly.juorm.rdb.jdbc.dsl.query.SqlQuery;
import cn.featherfly.juorm.rdb.jdbc.mapping.JdbcMappingFactory;
import cn.featherfly.juorm.rdb.jdbc.operate.DeleteOperate;
import cn.featherfly.juorm.rdb.jdbc.operate.GetOperate;
import cn.featherfly.juorm.rdb.jdbc.operate.InsertOperate;
import cn.featherfly.juorm.rdb.jdbc.operate.MergeOperate;
import cn.featherfly.juorm.rdb.jdbc.operate.UpdateOperate;
import cn.featherfly.juorm.rdb.tpl.SqlTplExecutor;
import cn.featherfly.juorm.tpl.FreemarkerTemplateProcessor;
import cn.featherfly.juorm.tpl.TemplateProcessor;
import cn.featherfly.juorm.tpl.TplConfigFactory;
import cn.featherfly.juorm.tpl.TplConfigFactoryImpl;
import cn.featherfly.juorm.tpl.TplExecuteId;

/**
 * <p>
 * JuormSqlImpl
 * </p>
 * .
 *
 * @author zhongj
 */
public class JuormJdbcImpl implements Juorm {

    private Jdbc jdbc;

    private JdbcMappingFactory mappingFactory;

    private Validator validator;

    private SqlTplExecutor sqlTplExecutor;

    private Map<Class<?>, InsertOperate<?>> insertOperates = new HashMap<>();
    private Map<Class<?>, UpdateOperate<?>> updateOperates = new HashMap<>();
    private Map<Class<?>, GetOperate<?>> getOperates = new HashMap<>();
    private Map<Class<?>, DeleteOperate<?>> deleteOperates = new HashMap<>();
    private Map<Class<?>, MergeOperate<?>> mergeOperates = new HashMap<>();

    /**
     * Instantiates a new juorm jdbc impl.
     *
     * @param jdbc           the jdbc
     * @param mappingFactory the mapping factory
     */
    public JuormJdbcImpl(Jdbc jdbc, JdbcMappingFactory mappingFactory) {
        this(jdbc, mappingFactory, new TplConfigFactoryImpl());
    }

    /**
     * Instantiates a new juorm jdbc impl.
     *
     * @param jdbc           the jdbc
     * @param mappingFactory the mapping factory
     * @param configFactory  the config factory
     */
    public JuormJdbcImpl(Jdbc jdbc, JdbcMappingFactory mappingFactory, TplConfigFactory configFactory) {
        this(jdbc, mappingFactory, configFactory, new FreemarkerTemplateProcessor(configFactory));
    }

    /**
     * Instantiates a new juorm jdbc impl.
     *
     * @param jdbc              the jdbc
     * @param mappingFactory    the mapping factory
     * @param configFactory     the config factory
     * @param templateProcessor the template processor
     */
    public JuormJdbcImpl(Jdbc jdbc, JdbcMappingFactory mappingFactory, TplConfigFactory configFactory,
            @SuppressWarnings("rawtypes") TemplateProcessor templateProcessor) {
        // this(jdbc, mappingFactory, configFactory,
        // Validation.buildDefaultValidatorFactory().getValidator());
        this(jdbc, mappingFactory, configFactory, templateProcessor, Validation.byProvider(HibernateValidator.class)
                .configure().failFast(false).buildValidatorFactory().getValidator());
    }

    /**
     * Instantiates a new juorm jdbc impl.
     *
     * @param jdbc              the jdbc
     * @param mappingFactory    the mapping factory
     * @param configFactory     the config factory
     * @param templateProcessor the template processor
     * @param validator         the validator
     */
    public JuormJdbcImpl(Jdbc jdbc, JdbcMappingFactory mappingFactory, TplConfigFactory configFactory,
            @SuppressWarnings("rawtypes") TemplateProcessor templateProcessor, Validator validator) {
        this.jdbc = jdbc;
        this.mappingFactory = mappingFactory;
        this.validator = validator;
        sqlTplExecutor = new SqlTplExecutor(configFactory, templateProcessor, jdbc, mappingFactory);
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
            ClassMapping<E> mapping = (ClassMapping<E>) mappingFactory.getClassMapping(entity.getClass());
            insert = new InsertOperate<>(jdbc, mapping, mappingFactory.getMetadata());
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
            ClassMapping<E> mapping = (ClassMapping<E>) mappingFactory.getClassMapping(entity.getClass());
            update = new UpdateOperate<>(jdbc, mapping, mappingFactory.getMetadata());
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
            ClassMapping<E> mapping = (ClassMapping<E>) mappingFactory.getClassMapping(entity.getClass());
            update = new MergeOperate<>(jdbc, mapping, mappingFactory.getMetadata());
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
            ClassMapping<E> mapping = (ClassMapping<E>) mappingFactory.getClassMapping(entity.getClass());
            delete = new DeleteOperate<>(jdbc, mapping, mappingFactory.getMetadata());
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
    public QueryEntity query(String repository) {
        SqlQuery query = new SqlQuery(jdbc, mappingFactory);
        return query.find(repository);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> TypeQueryEntity query(Class<E> entityType) {
        SqlQuery query = new SqlQuery(jdbc, mappingFactory);
        return query.find(entityType);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> Update update(Class<E> entityType) {
        SqlUpdater updater = new SqlUpdater(jdbc, mappingFactory);
        return updater.update(entityType);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> Delete delete(Class<E> entityType) {
        SqlDeleter deleter = new SqlDeleter(jdbc, mappingFactory);
        return deleter.delete(entityType);
    }

    private <E> void validate(E entity) {
        if (validator != null) {
            Set<ConstraintViolation<E>> cons = validator.validate(entity);
            if (LangUtils.isNotEmpty(cons)) {
                StringBuilder errorMessage = new StringBuilder();
                for (ConstraintViolation<E> constraintViolation : cons) {
                    errorMessage.append(constraintViolation.getMessage()).append(",");
                }
                throw new JuormJdbcException(errorMessage.toString());
            }
        }
    }

    /**
     * Gets the operate.
     *
     * @param <E>        the element type
     * @param entityType the entity type
     * @return the operate
     */
    private <E> GetOperate<E> getOperate(Class<E> entityType) {
        @SuppressWarnings("unchecked")
        GetOperate<E> get = (GetOperate<E>) getOperates.get(entityType);
        if (get == null) {
            ClassMapping<E> mapping = mappingFactory.getClassMapping(entityType);
            get = new GetOperate<>(jdbc, mapping, mappingFactory.getMetadata());
            getOperates.put(entityType.getClass(), get);
        }
        return get;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E single(String tplExecuteId, Class<E> entityType, Map<String, Object> params) {
        return sqlTplExecutor.single(tplExecuteId, entityType, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(String tplExecuteId, Class<E> entityType, Map<String, Object> params) {
        return sqlTplExecutor.list(tplExecuteId, entityType, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(String tplExecuteId, Class<E> entityType, Map<String, Object> params, int offset,
            int limit) {
        return sqlTplExecutor.list(tplExecuteId, entityType, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(String tplExecuteId, Class<E> entityType, Map<String, Object> params, Page page) {
        return sqlTplExecutor.list(tplExecuteId, entityType, params, page);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> PaginationResults<E> pagination(String tplExecuteId, Class<E> entityType, Map<String, Object> params,
            int offset, int limit) {
        return sqlTplExecutor.pagination(tplExecuteId, entityType, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> PaginationResults<E> pagination(String tplExecuteId, Class<E> entityType, Map<String, Object> params,
            Page page) {
        return sqlTplExecutor.pagination(tplExecuteId, entityType, params, page);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E single(TplExecuteId tplExecuteId, Class<E> entityType, Map<String, Object> params) {
        return sqlTplExecutor.single(tplExecuteId, entityType, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(TplExecuteId tplExecuteId, Class<E> entityType, Map<String, Object> params) {
        return sqlTplExecutor.list(tplExecuteId, entityType, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(TplExecuteId tplExecuteId, Class<E> entityType, Map<String, Object> params, int offset,
            int limit) {
        return sqlTplExecutor.list(tplExecuteId, entityType, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(TplExecuteId tplExecuteId, Class<E> entityType, Map<String, Object> params, Page page) {
        return sqlTplExecutor.list(tplExecuteId, entityType, params, page);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> PaginationResults<E> pagination(TplExecuteId tplExecuteId, Class<E> entityType,
            Map<String, Object> params, int offset, int limit) {
        return sqlTplExecutor.pagination(tplExecuteId, entityType, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> PaginationResults<E> pagination(TplExecuteId tplExecuteId, Class<E> entityType,
            Map<String, Object> params, Page page) {
        return sqlTplExecutor.pagination(tplExecuteId, entityType, params, page);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Object> single(String tplExecuteId, Map<String, Object> params) {
        return sqlTplExecutor.single(tplExecuteId, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Object> single(TplExecuteId tplExecuteId, Map<String, Object> params) {
        return sqlTplExecutor.single(tplExecuteId, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Object>> list(String tplExecuteId, Map<String, Object> params) {
        return sqlTplExecutor.list(tplExecuteId, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Object>> list(TplExecuteId tplExecuteId, Map<String, Object> params) {
        return sqlTplExecutor.list(tplExecuteId, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Object>> list(String tplExecuteId, Map<String, Object> params, int offset, int limit) {
        return sqlTplExecutor.list(tplExecuteId, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Object>> list(TplExecuteId tplExecuteId, Map<String, Object> params, int offset,
            int limit) {
        return sqlTplExecutor.list(tplExecuteId, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Object>> list(String tplExecuteId, Map<String, Object> params, Page page) {
        return sqlTplExecutor.list(tplExecuteId, params, page);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Object>> list(TplExecuteId tplExecuteId, Map<String, Object> params, Page page) {
        return sqlTplExecutor.list(tplExecuteId, params, page);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PaginationResults<Map<String, Object>> pagination(String tplExecuteId, Map<String, Object> params,
            int offset, int limit) {
        return sqlTplExecutor.pagination(tplExecuteId, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PaginationResults<Map<String, Object>> pagination(TplExecuteId tplExecuteId, Map<String, Object> params,
            int offset, int limit) {
        return sqlTplExecutor.pagination(tplExecuteId, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PaginationResults<Map<String, Object>> pagination(String tplExecuteId, Map<String, Object> params,
            Page page) {
        return sqlTplExecutor.pagination(tplExecuteId, params, page);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PaginationResults<Map<String, Object>> pagination(TplExecuteId tplExecuteId, Map<String, Object> params,
            Page page) {
        return sqlTplExecutor.pagination(tplExecuteId, params, page);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E value(String tplExecuteId, Class<E> valueType, Map<String, Object> params) {
        return sqlTplExecutor.value(tplExecuteId, valueType, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> N number(String tplExecuteId, Class<N> numberType, Map<String, Object> params) {
        return sqlTplExecutor.number(tplExecuteId, numberType, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer intValue(String tplExecuteId, Map<String, Object> params) {
        return sqlTplExecutor.intValue(tplExecuteId, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long longValue(String tplExecuteId, Map<String, Object> params) {
        return sqlTplExecutor.longValue(tplExecuteId, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal bigDecimalValue(String tplExecuteId, Map<String, Object> params) {
        return sqlTplExecutor.bigDecimalValue(tplExecuteId, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double doubleValue(String tplExecuteId, Map<String, Object> params) {
        return sqlTplExecutor.doubleValue(tplExecuteId, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String stringValue(String tplExecuteId, Map<String, Object> params) {
        return sqlTplExecutor.stringValue(tplExecuteId, params);
    }
}
