
package cn.featherfly.hammer.sqldb;

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

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.lang.ArrayUtils;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.repository.mapping.ClassMapping;
import cn.featherfly.common.structure.page.Page;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.hammer.dsl.execute.Delete;
import cn.featherfly.hammer.dsl.execute.Update;
import cn.featherfly.hammer.dsl.query.QueryEntity;
import cn.featherfly.hammer.dsl.query.TypeQueryEntity;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.sqldb.jdbc.dsl.execute.SqlDeleter;
import cn.featherfly.hammer.sqldb.jdbc.dsl.execute.SqlUpdater;
import cn.featherfly.hammer.sqldb.jdbc.dsl.query.SqlQuery;
import cn.featherfly.hammer.sqldb.jdbc.operate.DeleteOperate;
import cn.featherfly.hammer.sqldb.jdbc.operate.GetOperate;
import cn.featherfly.hammer.sqldb.jdbc.operate.InsertOperate;
import cn.featherfly.hammer.sqldb.jdbc.operate.MergeOperate;
import cn.featherfly.hammer.sqldb.jdbc.operate.UpdateOperate;
import cn.featherfly.hammer.sqldb.tpl.SqlDbTemplateEngine;
import cn.featherfly.hammer.sqldb.tpl.SqlTplExecutor;
import cn.featherfly.hammer.sqldb.tpl.freemarker.SqldbFreemarkerTemplateEngine;
import cn.featherfly.hammer.tpl.TplConfigFactory;
import cn.featherfly.hammer.tpl.TplConfigFactoryImpl;
import cn.featherfly.hammer.tpl.TplExecuteId;

/**
 * <p>
 * SqldbHammerImpl
 * </p>
 * .
 *
 * @author zhongj
 */
public class SqldbHammerImpl implements SqldbHammer {

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
     * Instantiates a new hammer jdbc impl.
     *
     * @param jdbc           the jdbc
     * @param mappingFactory the mapping factory
     */
    public SqldbHammerImpl(Jdbc jdbc, JdbcMappingFactory mappingFactory) {
        this(jdbc, mappingFactory, new TplConfigFactoryImpl());
    }

    /**
     * Instantiates a new hammer jdbc impl.
     *
     * @param jdbc           the jdbc
     * @param mappingFactory the mapping factory
     * @param configFactory  the config factory
     */
    public SqldbHammerImpl(Jdbc jdbc, JdbcMappingFactory mappingFactory, TplConfigFactory configFactory) {
        this(jdbc, mappingFactory, configFactory, new SqldbFreemarkerTemplateEngine(configFactory));
    }

    /**
     * Instantiates a new hammer jdbc impl.
     *
     * @param jdbc           the jdbc
     * @param mappingFactory the mapping factory
     * @param configFactory  the config factory
     * @param templateEngine the template engine
     */
    public SqldbHammerImpl(Jdbc jdbc, JdbcMappingFactory mappingFactory, TplConfigFactory configFactory,
            @SuppressWarnings("rawtypes") SqlDbTemplateEngine templateEngine) {
        // this(jdbc, mappingFactory, configFactory, Validation.buildDefaultValidatorFactory().getValidator());
        this(jdbc, mappingFactory, configFactory, templateEngine, Validation.byProvider(HibernateValidator.class)
                .configure().failFast(false).buildValidatorFactory().getValidator());
    }

    /**
     * Instantiates a new hammer jdbc impl.
     *
     * @param jdbc           the jdbc
     * @param mappingFactory the mapping factory
     * @param configFactory  the config factory
     * @param templateEngine the template processor
     * @param validator      the validator
     */
    public SqldbHammerImpl(Jdbc jdbc, JdbcMappingFactory mappingFactory, TplConfigFactory configFactory,
            @SuppressWarnings("rawtypes") SqlDbTemplateEngine templateEngine, Validator validator) {
        this.jdbc = jdbc;
        this.mappingFactory = mappingFactory;
        this.validator = validator;
        sqlTplExecutor = new SqlTplExecutor(configFactory, templateEngine, jdbc, mappingFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int save(E entity) {
        if (entity == null) {
            return 0;
        }
        InsertOperate<E> insert = getInsert(entity);
        validate(entity);
        return insert.execute(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int save(@SuppressWarnings("unchecked") E... entities) {
        return save(ArrayUtils.toList(entities));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int save(List<E> entities) {
        if (Lang.isEmpty(entities)) {
            return 0;
        }
        InsertOperate<E> insert = null;
        if (jdbc.getDialect().isInsertBatch() && jdbc.getDialect().isAutoGenerateKeyBatch()) {
            for (E entity : entities) {
                if (insert == null) {
                    insert = getInsert(entity);
                }
                validate(entity);
            }
            return insert.executeBatch(entities);
        } else {
            int size = 0;
            if (Lang.isNotEmpty(entities)) {
                for (E e : entities) {
                    size += save(e);
                }
            }
            return size;
        }
    }

    private <E> InsertOperate<E> getInsert(E entity) {
        @SuppressWarnings("unchecked")
        InsertOperate<E> insert = (InsertOperate<E>) insertOperates.get(entity.getClass());
        if (insert == null) {
            @SuppressWarnings("unchecked")
            ClassMapping<E> mapping = (ClassMapping<E>) mappingFactory.getClassMapping(entity.getClass());
            insert = new InsertOperate<>(jdbc, mapping, mappingFactory.getMetadata());
            insertOperates.put(entity.getClass(), insert);
        }
        return insert;
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
        UpdateOperate<E> update = (UpdateOperate<E>) updateOperates.get(entity.getClass());
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
    public <E> int update(@SuppressWarnings("unchecked") E... entities) {
        int size = 0;
        if (Lang.isNotEmpty(entities)) {
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
    public <E> int update(List<E> entities) {
        int size = 0;
        if (Lang.isNotEmpty(entities)) {
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
        if (Lang.isNotEmpty(entities)) {
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
        MergeOperate<E> update = (MergeOperate<E>) mergeOperates.get(entity.getClass());
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
    public <E> int merge(@SuppressWarnings("unchecked") E... entities) {
        int size = 0;
        if (Lang.isNotEmpty(entities)) {
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
    public <E> int merge(List<E> entities) {
        int size = 0;
        if (Lang.isNotEmpty(entities)) {
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
    public <E> int delete(Serializable id, Class<E> entityType) {
        if (id == null || entityType == null) {
            return 0;
        }
        @SuppressWarnings("unchecked")
        DeleteOperate<E> delete = (DeleteOperate<E>) deleteOperates.get(entityType);
        if (delete == null) {
            ClassMapping<E> mapping = mappingFactory.getClassMapping(entityType);
            delete = new DeleteOperate<>(jdbc, mapping, mappingFactory.getMetadata());
            deleteOperates.put(entityType, delete);
        }
        return delete.delete(id);
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
        DeleteOperate<E> delete = (DeleteOperate<E>) deleteOperates.get(entity.getClass());
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
    public <E> int delete(@SuppressWarnings("unchecked") E... entities) {
        int size = 0;
        // TODO 后续加入DeleteBatchOperate优化为sql批量删除
        if (Lang.isNotEmpty(entities)) {
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
    public <E> int delete(List<E> entities) {
        // TODO 后续加入DeleteBatchOperate优化为sql批量删除
        int size = 0;
        if (Lang.isNotEmpty(entities)) {
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
    public Update update(String repository) {
        SqlUpdater updater = new SqlUpdater(jdbc, mappingFactory);
        return updater.update(repository);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Delete delete(String repository) {
        SqlDeleter deleter = new SqlDeleter(jdbc, mappingFactory);
        return deleter.delete(repository);
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
            if (Lang.isNotEmpty(cons)) {
                StringBuilder errorMessage = new StringBuilder();
                for (ConstraintViolation<E> constraintViolation : cons) {
                    errorMessage.append(constraintViolation.getMessage()).append(",");
                }
                throw new SqldbHammerException(errorMessage.toString());
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
    public Integer numberInt(String tplExecuteId, Map<String, Object> params) {
        return sqlTplExecutor.numberInt(tplExecuteId, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long numberLong(String tplExecuteId, Map<String, Object> params) {
        return sqlTplExecutor.numberLong(tplExecuteId, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal numberBigDecimal(String tplExecuteId, Map<String, Object> params) {
        return sqlTplExecutor.numberBigDecimal(tplExecuteId, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double numberDouble(String tplExecuteId, Map<String, Object> params) {
        return sqlTplExecutor.numberDouble(tplExecuteId, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String string(String tplExecuteId, Map<String, Object> params) {
        return sqlTplExecutor.string(tplExecuteId, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E value(TplExecuteId tplExecuteId, Class<E> valueType, Map<String, Object> params) {
        return sqlTplExecutor.value(tplExecuteId, valueType, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> N number(TplExecuteId tplExecuteId, Class<N> numberType, Map<String, Object> params) {
        return sqlTplExecutor.number(tplExecuteId, numberType, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int intValue(String tplExecuteId, Map<String, Object> params) {
        return sqlTplExecutor.intValue(tplExecuteId, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int intValue(TplExecuteId tplExecuteId, Map<String, Object> params) {
        return sqlTplExecutor.intValue(tplExecuteId, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long longValue(String tplExecuteId, Map<String, Object> params) {
        return sqlTplExecutor.longValue(tplExecuteId, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long longValue(TplExecuteId tplExecuteId, Map<String, Object> params) {
        return sqlTplExecutor.longValue(tplExecuteId, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double doubleValue(String tplExecuteId, Map<String, Object> params) {
        return sqlTplExecutor.doubleValue(tplExecuteId, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double doubleValue(TplExecuteId tplExecuteId, Map<String, Object> params) {
        return sqlTplExecutor.doubleValue(tplExecuteId, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer numberInt(TplExecuteId tplExecuteId, Map<String, Object> params) {
        return sqlTplExecutor.numberInt(tplExecuteId, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long numberLong(TplExecuteId tplExecuteId, Map<String, Object> params) {
        return sqlTplExecutor.numberLong(tplExecuteId, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal numberBigDecimal(TplExecuteId tplExecuteId, Map<String, Object> params) {
        return sqlTplExecutor.numberBigDecimal(tplExecuteId, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double numberDouble(TplExecuteId tplExecuteId, Map<String, Object> params) {
        return sqlTplExecutor.numberDouble(tplExecuteId, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String string(TplExecuteId tplExecuteId, Map<String, Object> params) {
        return sqlTplExecutor.string(tplExecuteId, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int execute(String tplExecuteId, Map<String, Object> params) {
        return sqlTplExecutor.execute(tplExecuteId, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int execute(TplExecuteId tplExecuteId, Map<String, Object> params) {
        return sqlTplExecutor.execute(tplExecuteId, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Jdbc getJdbc() {
        return jdbc;
    }
}
