
package cn.featherfly.hammer.sqldb;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

import javax.annotation.Nonnull;
import javax.validation.ConstraintViolation;

import com.speedment.common.tuple.Tuple2;
import com.speedment.common.tuple.Tuple3;
import com.speedment.common.tuple.Tuple4;
import com.speedment.common.tuple.Tuple5;
import com.speedment.common.tuple.Tuple6;

import cn.featherfly.common.bean.BeanDescriptor;
import cn.featherfly.common.bean.BeanProperty;
import cn.featherfly.common.db.Table;
import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.lang.ArrayUtils;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.common.repository.Repository;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.hammer.config.HammerConfig;
import cn.featherfly.hammer.dsl.entity.execute.EntityDelete;
import cn.featherfly.hammer.dsl.entity.execute.EntityUpdate;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryFetch;
import cn.featherfly.hammer.dsl.execute.Delete;
import cn.featherfly.hammer.dsl.execute.Update;
import cn.featherfly.hammer.dsl.query.QueryEntity;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.sqldb.jdbc.SimpleSqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.execute.SqlDeleter;
import cn.featherfly.hammer.sqldb.jdbc.dsl.execute.SqlUpdater;
import cn.featherfly.hammer.sqldb.jdbc.dsl.query.SqlQuery;
import cn.featherfly.hammer.sqldb.jdbc.operate.DeleteOperate;
import cn.featherfly.hammer.sqldb.jdbc.operate.GetOperate;
import cn.featherfly.hammer.sqldb.jdbc.operate.InsertOperate;
import cn.featherfly.hammer.sqldb.jdbc.operate.MergeOperate;
import cn.featherfly.hammer.sqldb.jdbc.operate.UpdateOperate;
import cn.featherfly.hammer.sqldb.jdbc.operate.UpsertOperate;
import cn.featherfly.hammer.sqldb.tpl.SqlDbTemplateEngine;
import cn.featherfly.hammer.sqldb.tpl.SqlTplExecutor;
import cn.featherfly.hammer.sqldb.tpl.freemarker.SqldbFreemarkerTemplateEngine;
import cn.featherfly.hammer.sqldb.tpl.transverter.FuzzyQueryTransverter;
import cn.featherfly.hammer.tpl.TplConfigFactory;
import cn.featherfly.hammer.tpl.TplExecuteId;
import cn.featherfly.hammer.tpl.TransverterManager;

/**
 * SqldbHammerImpl.
 *
 * @author zhongj
 */
public class SqldbHammerImpl implements SqldbHammer {

    /** The jdbc. */
    private Jdbc jdbc;

    /** The mapping factory. */
    private JdbcMappingFactory mappingFactory;

    private HammerConfig hammerConfig;

    /** The sql tpl executor. */
    private SqlTplExecutor sqlTplExecutor;

    /** The insert operates. */
    private Map<Class<?>, InsertOperate<?>> insertOperates = new HashMap<>();

    /** The update operates. */
    private Map<Class<?>, UpdateOperate<?>> updateOperates = new HashMap<>();

    /** The update operates. */
    private Map<Class<?>, UpsertOperate<?>> upsertOperates = new HashMap<>();

    /** The get operates. */
    private Map<Class<?>, GetOperate<?>> getOperates = new HashMap<>();

    /** The delete operates. */
    private Map<Class<?>, DeleteOperate<?>> deleteOperates = new HashMap<>();

    /** The merge operates. */
    private Map<Class<?>, MergeOperate<?>> mergeOperates = new HashMap<>();

    /**
     * Instantiates a new hammer jdbc impl.
     *
     * @param jdbc           the jdbc
     * @param mappingFactory the mapping factory
     * @param configFactory  the config factory
     */
    public SqldbHammerImpl(Jdbc jdbc, JdbcMappingFactory mappingFactory, TplConfigFactory configFactory,
            HammerConfig hammerConfig) {
        this(jdbc, mappingFactory, configFactory, new SqldbFreemarkerTemplateEngine(configFactory), hammerConfig);
    }

    //    /**
    //     * Instantiates a new sqldb hammer impl.
    //     *
    //     * @param jdbc               the jdbc
    //     * @param mappingFactory     the mapping factory
    //     * @param configFactory      the config factory
    //     * @param transverterManager the transverter manager
    //     */
    //    public SqldbHammerImpl(Jdbc jdbc, JdbcMappingFactory mappingFactory, TplConfigFactory configFactory,
    //            TransverterManager transverterManager) {
    //        this(jdbc, mappingFactory, configFactory, new SqldbFreemarkerTemplateEngine(configFactory),
    //                new SimpleSqlPageFactory(), new TransverterManager(), Validation.byProvider(HibernateValidator.class)
    //                        .configure().failFast(false).buildValidatorFactory().getValidator());
    //    }

    /**
     * Instantiates a new hammer jdbc impl.
     *
     * @param jdbc           the jdbc
     * @param mappingFactory the mapping factory
     * @param configFactory  the config factory
     * @param templateEngine the template engine
     */
    public SqldbHammerImpl(Jdbc jdbc, JdbcMappingFactory mappingFactory, TplConfigFactory configFactory,
            @SuppressWarnings("rawtypes") SqlDbTemplateEngine templateEngine, HammerConfig hammerConfig) {
        // this(jdbc, mappingFactory, configFactory, Validation.buildDefaultValidatorFactory().getValidator());
        this(jdbc, mappingFactory, configFactory, templateEngine, new SimpleSqlPageFactory(), hammerConfig);
    }

    /**
     * Instantiates a new hammer jdbc impl.
     *
     * @param jdbc           the jdbc
     * @param mappingFactory the mapping factory
     * @param configFactory  the config factory
     * @param templateEngine the template processor
     * @param sqlPageFacotry the sql page facotry
     * @param validator      the validator
     */
    public SqldbHammerImpl(Jdbc jdbc, JdbcMappingFactory mappingFactory, TplConfigFactory configFactory,
            @SuppressWarnings("rawtypes") SqlDbTemplateEngine templateEngine, SqlPageFactory sqlPageFacotry,
            HammerConfig hammerConfig) {
        this(jdbc, mappingFactory, configFactory, templateEngine, sqlPageFacotry,
                new TransverterManager(new FuzzyQueryTransverter()), hammerConfig);
    }

    //    /**
    //     * Instantiates a new hammer jdbc impl.
    //     *
    //     * @param jdbc               the jdbc
    //     * @param mappingFactory     the mapping factory
    //     * @param configFactory      the config factory
    //     * @param templateEngine     the template processor
    //     * @param sqlPageFacotry     the sql page facotry
    //     * @param transverterManager the transverter manager
    //     */
    //    public SqldbHammerImpl(Jdbc jdbc, JdbcMappingFactory mappingFactory, TplConfigFactory configFactory,
    //            @SuppressWarnings("rawtypes") SqlDbTemplateEngine templateEngine, SqlPageFactory sqlPageFacotry,
    //            TransverterManager transverterManager) {
    //        this(jdbc, mappingFactory, configFactory, templateEngine, sqlPageFacotry, transverterManager,
    //                Validation.byProvider(HibernateValidator.class).configure().failFast(false).buildValidatorFactory()
    //                        .getValidator());
    //    }

    /**
     * Instantiates a new hammer jdbc impl.
     *
     * @param jdbc               the jdbc
     * @param mappingFactory     the mapping factory
     * @param configFactory      the config factory
     * @param templateEngine     the template processor
     * @param sqlPageFacotry     the sql page facotry
     * @param transverterManager the transverter manager
     * @param validator          the validator
     */
    public SqldbHammerImpl(Jdbc jdbc, JdbcMappingFactory mappingFactory, TplConfigFactory configFactory,
            @SuppressWarnings("rawtypes") SqlDbTemplateEngine templateEngine, SqlPageFactory sqlPageFacotry,
            TransverterManager transverterManager, HammerConfig hammerConfig) {
        this.jdbc = jdbc;
        this.mappingFactory = mappingFactory;
        this.hammerConfig = hammerConfig;
        sqlTplExecutor = new SqlTplExecutor(configFactory, templateEngine, jdbc, mappingFactory, sqlPageFacotry,
                transverterManager);
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

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <E> int[] save(@SuppressWarnings("unchecked") E... entities) {
    //        return save(ArrayUtils.toList(entities));
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <E> int[] save(E[] entities, int batchSize) {
    //        return save(ArrayUtils.toList(entities), batchSize);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <E> int[] save(List<E> entities) {
    //        if (Lang.isEmpty(entities)) {
    //            return ArrayUtils.EMPTY_INT_ARRAY;
    //        }
    //        InsertOperate<E> insert = null;
    //        for (E entity : entities) {
    //            if (insert == null) {
    //                insert = getInsert(entity);
    //            }
    //            validate(entity);
    //        }
    //        return insert.executeBatch(entities);
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int[] save(List<E> entities, int batchSize) {
        if (Lang.isEmpty(entities)) {
            return ArrayUtils.EMPTY_INT_ARRAY;
        }
        InsertOperate<E> insert = null;
        for (E entity : entities) {
            if (insert == null) {
                insert = getInsert(entity);
            }
            validate(entity);
        }
        if (insert == null) {
            return ArrayUtils.EMPTY_INT_ARRAY;
        }
        return insert.executeBatch(entities, batchSize);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int saveOrUpdate(E entity) {
        if (entity == null) {
            return 0;
        }
        if (jdbc.getDialect().supportUpsert()) {
            UpsertOperate<E> upsert = getUpsert(entity);
            return upsert.execute(entity);
        } else {
            @SuppressWarnings("unchecked")
            GetOperate<E> get = (GetOperate<E>) getOperate(entity.getClass());
            List<Serializable> ids = get.getIds(entity);
            if (ids.size() == 1) {
                Serializable id = ids.get(0);
                // FIXME 当前的逻辑在手动设置id值的时候会有问题
                if (id == null) {
                    return save(entity);
                } else {
                    return update(entity);
                }
            } else if (ids.size() > 1) {
                boolean insertable = false;
                for (Serializable id : ids) {
                    if (id == null) { // 只要有一个id为空，则表示需要插入数据
                        insertable = true;
                    }
                }
                if (insertable) {
                    return save(entity);
                } else {
                    return update(entity);
                }
            } else {
                throw new SqldbHammerException("no pk mapping");
            }
        }
    }

    private <E> InsertOperate<E> getInsert(E entity) {
        @SuppressWarnings("unchecked")
        InsertOperate<E> insert = (InsertOperate<E>) insertOperates.get(entity.getClass());
        if (insert == null) {
            @SuppressWarnings("unchecked")
            JdbcClassMapping<E> mapping = mappingFactory.getClassMapping((Class<E>) entity.getClass());
            insert = new InsertOperate<>(jdbc, mapping, mappingFactory.getSqlTypeMappingManager(),
                    mappingFactory.getMetadata());
            insertOperates.put(entity.getClass(), insert);
        }
        return insert;
    }

    private <E> UpsertOperate<E> getUpsert(E entity) {
        @SuppressWarnings("unchecked")
        UpsertOperate<E> upsert = (UpsertOperate<E>) upsertOperates.get(entity.getClass());
        if (upsert == null) {
            @SuppressWarnings("unchecked")
            JdbcClassMapping<E> mapping = (JdbcClassMapping<E>) mappingFactory.getClassMapping(entity.getClass());
            upsert = new UpsertOperate<>(jdbc, mapping, mappingFactory.getSqlTypeMappingManager(),
                    mappingFactory.getMetadata());
            upsertOperates.put(entity.getClass(), upsert);
        }
        return upsert;
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
            JdbcClassMapping<E> mapping = (JdbcClassMapping<E>) mappingFactory.getClassMapping(entity.getClass());
            update = new UpdateOperate<>(jdbc, mapping, mappingFactory.getSqlTypeMappingManager(),
                    mappingFactory.getMetadata());
            updateOperates.put(entity.getClass(), update);
        }
        validate(entity);
        return update.execute(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int update(E entity, IgnoreStrategy ignoreStrategy) {
        switch (ignoreStrategy) {
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
    public <E> int[] update(@SuppressWarnings("unchecked") E... entities) {
        if (Lang.isNotEmpty(entities)) {
            int results[] = new int[entities.length];
            for (int i = 0; i < entities.length; i++) {
                results[i] = update(entities[i]);
            }
            return results;
        } else {
            return ArrayUtils.EMPTY_INT_ARRAY;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int[] update(List<E> entities) {
        return update(entities, entities.size());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int[] update(List<E> entities, int batchSize) {
        if (Lang.isEmpty(entities)) {
            return ArrayUtils.EMPTY_INT_ARRAY;
        } else {
            @SuppressWarnings("unchecked")
            Class<E> type = (Class<E>) entities.get(0).getClass();
            @SuppressWarnings("unchecked")
            UpdateOperate<E> update = (UpdateOperate<E>) updateOperates.get(type);
            if (update == null) {
                JdbcClassMapping<E> mapping = mappingFactory.getClassMapping(type);
                update = new UpdateOperate<>(jdbc, mapping, mappingFactory.getSqlTypeMappingManager(),
                        mappingFactory.getMetadata());
                updateOperates.put(type, update);
            }
            for (E entity : entities) {
                validate(entity);
            }
            return update.executeBatch(entities, batchSize);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int[] update(List<E> entities, IgnoreStrategy ignoreStrategy) {
        if (Lang.isNotEmpty(entities)) {
            int results[] = new int[entities.size()];
            for (int i = 0; i < entities.size(); i++) {
                results[i] = update(entities.get(i), ignoreStrategy);
            }
            return results;
        } else {
            return ArrayUtils.EMPTY_INT_ARRAY;
        }
    }

    /**
     * Merge.
     *
     * @param <E>      the element type
     * @param entity   the entity
     * @param onlyNull the only null
     * @return the int
     */
    private <E> int merge(E entity, boolean onlyNull) {
        if (entity == null) {
            return 0;
        }
        @SuppressWarnings("unchecked")
        MergeOperate<E> update = (MergeOperate<E>) mergeOperates.get(entity.getClass());
        if (update == null) {
            @SuppressWarnings("unchecked")
            JdbcClassMapping<E> mapping = (JdbcClassMapping<E>) mappingFactory.getClassMapping(entity.getClass());
            update = new MergeOperate<>(jdbc, mapping, mappingFactory.getSqlTypeMappingManager(),
                    mappingFactory.getMetadata());
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
    public <E> int[] merge(@SuppressWarnings("unchecked") E... entities) {
        int results[] = new int[entities.length];
        for (int i = 0; i < entities.length; i++) {
            results[i] = merge(entities[i]);
        }
        return results;
        //        int size = 0;
        //        if (Lang.isNotEmpty(entities)) {
        //            for (E e : entities) {
        //                size += merge(e);
        //            }
        //        }
        //        return size;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int[] merge(List<E> entities) {
        int results[] = new int[entities.size()];
        for (int i = 0; i < entities.size(); i++) {
            results[i] = merge(entities.get(i));
        }
        return results;
        //        int size = 0;
        //        if (Lang.isNotEmpty(entities)) {
        //            for (E e : entities) {
        //                size += merge(e);
        //            }
        //        }
        //        return size;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int delete(Serializable id, @Nonnull Class<E> entityType) {
        if (id == null || entityType == null) {
            return 0;
        }
        DeleteOperate<E> delete = getDelete(entityType);
        return delete.delete(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int[] delete(Serializable[] ids, @Nonnull Class<E> entityType) {
        if (Lang.isEmpty(ids)) {
            return ArrayUtils.EMPTY_INT_ARRAY;
        }
        DeleteOperate<E> delete = getDelete(entityType);
        return delete.deleteBatch(ids);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E, ID extends Serializable> int[] delete(List<ID> ids, @Nonnull Class<E> entityType) {
        if (Lang.isEmpty(ids)) {
            return ArrayUtils.EMPTY_INT_ARRAY;
        }
        DeleteOperate<E> delete = getDelete(entityType);
        return delete.deleteBatch(ids);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int delete(E entity) {
        if (entity == null) {
            return 0;
        }
        DeleteOperate<E> delete = getDelete(entity);
        return delete.execute(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int[] delete(List<E> entities) {
        if (Lang.isEmpty(entities)) {
            return ArrayUtils.EMPTY_INT_ARRAY;
        }
        DeleteOperate<E> delete = getDelete(entities);
        if (delete == null) {
            return ArrayUtils.EMPTY_INT_ARRAY;
        }
        return delete.executeBatch(entities);
    }

    private <E> DeleteOperate<E> getDelete(Collection<E> entities) {
        E e = Lang.pickFirst(entities);
        if (e == null) {
            return null;
        }
        return getDelete(e);
    }

    @SuppressWarnings("unchecked")
    private <E> DeleteOperate<E> getDelete(E entity) {
        return getDelete((Class<E>) entity.getClass());
    }

    private <E> DeleteOperate<E> getDelete(Class<E> entityType) {
        @SuppressWarnings("unchecked")
        DeleteOperate<E> delete = (DeleteOperate<E>) deleteOperates.get(entityType);
        if (delete == null) {
            JdbcClassMapping<E> mapping = mappingFactory.getClassMapping(entityType);
            delete = new DeleteOperate<>(jdbc, mapping, mappingFactory.getSqlTypeMappingManager(),
                    mappingFactory.getMetadata());
            deleteOperates.put(entityType, delete);
        }
        return delete;
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
        return get.execute(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> get(Class<E> type, Serializable... ids) {
        List<E> list = new ArrayList<>();
        if (Lang.isEmpty(ids)) {
            return list;
        }
        for (Serializable id : ids) {
            // ENHANCE 后续优化为支持一条sql获取多个的实现
            list.add(get(id, type));
        }
        return list;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> get(Class<E> type, List<Serializable> ids) {
        List<E> list = new ArrayList<>();
        if (Lang.isEmpty(ids)) {
            return list;
        }
        for (Serializable id : ids) {
            // TODO 后续优化为支持一条sql获取多个的实现
            list.add(get(id, type));
        }
        return list;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E, R> E get(Serializable id, Class<E> type, SerializableFunction<E, R> fetchProperty) {
        E entity = get(id, type);
        if (entity == null) {
            return null;
        }
        // ENHANCE 后续再来优化，先用两次查询实现
        // TODO 只实现了多对一或者一对一的获取，没有实现一对多的获取
        BeanProperty<E, R> bp = BeanDescriptor.getBeanDescriptor(type).getBeanProperty(fetchProperty);
        R fetchObj = get(bp.getValue(entity));
        bp.setValue(entity, fetchObj);
        return entity;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E get(E entity) {
        return _get(entity, false);
    }

    private <E> E _get(Serializable id, Class<E> type, boolean forUpdate) {
        if (id == null || type == null) {
            return null;
        }
        GetOperate<E> get = getOperate(type);
        return get.get(id, forUpdate);
    }

    private <E> E _get(E entity, boolean forUpdate) {
        if (entity == null) {
            return null;
        }
        @SuppressWarnings("unchecked")
        GetOperate<E> get = (GetOperate<E>) getOperate(entity.getClass());
        return get.get(entity, forUpdate);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E getLockUpdate(Serializable id, Class<E> type, Function<E, E> updateFunction) {
        E e = _get(id, type, true);
        E result = updateFunction.apply(e);
        update(result);
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E getLockUpdate(E entity, Function<E, E> updateFunction) {
        E e = _get(entity, true);
        E result = updateFunction.apply(e);
        update(result);
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryEntity query(String repository) {
        SqlQuery query = new SqlQuery(jdbc, mappingFactory, sqlTplExecutor.getSqlPageFactory(),
                hammerConfig.getDslConfig().getQueryConfig());
        return query.find(repository);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryEntity query(Repository repository) {
        SqlQuery query = new SqlQuery(jdbc, mappingFactory, sqlTplExecutor.getSqlPageFactory(),
                hammerConfig.getDslConfig().getQueryConfig());
        return query.find(repository);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryEntity query(Table table) {
        SqlQuery query = new SqlQuery(jdbc, mappingFactory, sqlTplExecutor.getSqlPageFactory(),
                hammerConfig.getDslConfig().getQueryConfig());
        return query.find(table);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> EntityQueryFetch<E> query(Class<E> entityType) {
        SqlQuery query = new SqlQuery(jdbc, mappingFactory, sqlTplExecutor.getSqlPageFactory(),
                hammerConfig.getDslConfig().getQueryConfig());
        return query.find(entityType);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> EntityUpdate<E> update(Class<E> entityType) {
        SqlUpdater updater = new SqlUpdater(jdbc, mappingFactory, hammerConfig.getDslConfig().getUpdateConfig());
        return updater.update(entityType);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Update update(String repository) {
        SqlUpdater updater = new SqlUpdater(jdbc, mappingFactory, hammerConfig.getDslConfig().getUpdateConfig());
        return updater.update(repository);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Update update(Repository repository) {
        SqlUpdater updater = new SqlUpdater(jdbc, mappingFactory, hammerConfig.getDslConfig().getUpdateConfig());
        return updater.update(repository);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Update update(Table table) {
        SqlUpdater updater = new SqlUpdater(jdbc, mappingFactory, hammerConfig.getDslConfig().getUpdateConfig());
        return updater.update(table);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Delete delete(String repository) {
        SqlDeleter deleter = new SqlDeleter(jdbc, mappingFactory, hammerConfig.getDslConfig().getDeleteConfig());
        return deleter.delete(repository);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Delete delete(Repository repository) {
        SqlDeleter deleter = new SqlDeleter(jdbc, mappingFactory, hammerConfig.getDslConfig().getDeleteConfig());
        return deleter.delete(repository);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Delete delete(Table table) {
        SqlDeleter deleter = new SqlDeleter(jdbc, mappingFactory, hammerConfig.getDslConfig().getDeleteConfig());
        return deleter.delete(table);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> EntityDelete<E> delete(Class<E> entityType) {
        SqlDeleter deleter = new SqlDeleter(jdbc, mappingFactory, hammerConfig.getDslConfig().getDeleteConfig());
        return deleter.delete(entityType);
    }

    /**
     * Validate.
     *
     * @param <E>    the element type
     * @param entity the entity
     */
    private <E> void validate(E entity) {
        if (hammerConfig.getValidator() != null) {
            Set<ConstraintViolation<E>> cons = hammerConfig.getValidator().validate(entity);
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
            JdbcClassMapping<E> mapping = mappingFactory.getClassMapping(entityType);
            get = new GetOperate<>(jdbc, mapping, mappingFactory.getSqlTypeMappingManager(),
                    mappingFactory.getMetadata());
            getOperates.put(entityType, get);
        }
        return get;
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
    public <E> PaginationResults<E> pagination(String tplExecuteId, Class<E> entityType, Map<String, Object> params,
            int offset, int limit) {
        return sqlTplExecutor.pagination(tplExecuteId, entityType, params, offset, limit);
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
    public <E> E single(String tplExecuteId, Class<E> entityType, Map<String, Object> params) {
        return sqlTplExecutor.single(tplExecuteId, entityType, params);
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
    public <R1, R2> Tuple2<R1, R2> single(String tplExecuteId, Class<R1> elementType1, Class<R2> elementType2,
            Map<String, Object> params) {
        return sqlTplExecutor.single(tplExecuteId, elementType1, elementType2, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2> Tuple2<R1, R2> single(TplExecuteId tplExecuteId, Class<R1> elementType1, Class<R2> elementType2,
            Map<String, Object> params) {
        return sqlTplExecutor.single(tplExecuteId, elementType1, elementType2, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2> Tuple2<R1, R2> single(String tplExecuteId, Class<R1> elementType1, Class<R2> elementType2,
            Tuple2<String, String> prefixes, Map<String, Object> params) {
        return sqlTplExecutor.single(tplExecuteId, elementType1, elementType2, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2> Tuple2<R1, R2> single(TplExecuteId tplExecuteId, Class<R1> elementType1, Class<R2> elementType2,
            Tuple2<String, String> prefixes, Map<String, Object> params) {
        return sqlTplExecutor.single(tplExecuteId, elementType1, elementType2, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3> Tuple3<R1, R2, R3> single(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Class<R3> entityType3, Map<String, Object> params) {
        return sqlTplExecutor.single(tplExecuteId, entityType1, entityType2, entityType3, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3> Tuple3<R1, R2, R3> single(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Map<String, Object> params) {
        return sqlTplExecutor.single(tplExecuteId, entityType1, entityType2, entityType3, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3> Tuple3<R1, R2, R3> single(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Class<R3> entityType3, Tuple3<String, String, String> prefixes, Map<String, Object> params) {
        return sqlTplExecutor.single(tplExecuteId, entityType1, entityType2, entityType3, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3> Tuple3<R1, R2, R3> single(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Tuple3<String, String, String> prefixes,
            Map<String, Object> params) {
        return sqlTplExecutor.single(tplExecuteId, entityType1, entityType2, entityType3, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4> Tuple4<R1, R2, R3, R4> single(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Map<String, Object> params) {
        return sqlTplExecutor.single(tplExecuteId, entityType1, entityType2, entityType3, entityType4, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4> Tuple4<R1, R2, R3, R4> single(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Map<String, Object> params) {
        return sqlTplExecutor.single(tplExecuteId, entityType1, entityType2, entityType3, entityType4, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4> Tuple4<R1, R2, R3, R4> single(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Tuple4<String, String, String, String> prefixes, Map<String, Object> params) {
        return sqlTplExecutor.single(tplExecuteId, entityType1, entityType2, entityType3, entityType4, prefixes,
                params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4> Tuple4<R1, R2, R3, R4> single(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Tuple4<String, String, String, String> prefixes, Map<String, Object> params) {
        return sqlTplExecutor.single(tplExecuteId, entityType1, entityType2, entityType3, entityType4, prefixes,
                params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5> Tuple5<R1, R2, R3, R4, R5> single(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
            Tuple5<String, String, String, String, String> prefixes, Map<String, Object> params) {
        return sqlTplExecutor.single(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5,
                prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5> Tuple5<R1, R2, R3, R4, R5> single(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
            Tuple5<String, String, String, String, String> prefixes, Map<String, Object> params) {
        return sqlTplExecutor.single(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5,
                prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5> Tuple5<R1, R2, R3, R4, R5> single(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
            Map<String, Object> params) {
        return sqlTplExecutor.single(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5,
                params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5> Tuple5<R1, R2, R3, R4, R5> single(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
            Map<String, Object> params) {
        return sqlTplExecutor.single(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5,
                params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5, R6> Tuple6<R1, R2, R3, R4, R5, R6> single(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
            Class<R6> entityType6, Map<String, Object> params) {
        return sqlTplExecutor.single(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5,
                entityType6, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5, R6> Tuple6<R1, R2, R3, R4, R5, R6> single(TplExecuteId tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Class<R5> entityType5, Class<R6> entityType6, Map<String, Object> params) {
        return sqlTplExecutor.single(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5,
                entityType6, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5, R6> Tuple6<R1, R2, R3, R4, R5, R6> single(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
            Class<R6> entityType6, Tuple6<String, String, String, String, String, String> prefixes,
            Map<String, Object> params) {
        return sqlTplExecutor.single(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5,
                entityType6, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5, R6> Tuple6<R1, R2, R3, R4, R5, R6> single(TplExecuteId tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Class<R5> entityType5, Class<R6> entityType6,
            Tuple6<String, String, String, String, String, String> prefixes, Map<String, Object> params) {
        return sqlTplExecutor.single(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5,
                entityType6, prefixes, params);
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
    public <E> PaginationResults<E> pagination(TplExecuteId tplExecuteId, Class<E> entityType,
            Map<String, Object> params, int offset, int limit) {
        return sqlTplExecutor.pagination(tplExecuteId, entityType, params, offset, limit);
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
    public <R1, R2> List<Tuple2<R1, R2>> list(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Map<String, Object> params) {
        return sqlTplExecutor.list(tplExecuteId, entityType1, entityType2, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2> List<Tuple2<R1, R2>> list(TplExecuteId tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Map<String, Object> params) {
        return sqlTplExecutor.list(tplExecuteId, entityType1, entityType2, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2> List<Tuple2<R1, R2>> list(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Map<String, Object> params, int offset, int limit) {
        return sqlTplExecutor.list(tplExecuteId, entityType1, entityType2, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2> List<Tuple2<R1, R2>> list(TplExecuteId tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Map<String, Object> params, int offset, int limit) {
        return sqlTplExecutor.list(tplExecuteId, entityType1, entityType2, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2> List<Tuple2<R1, R2>> list(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Tuple2<String, String> prefixes, Map<String, Object> params) {
        return sqlTplExecutor.list(tplExecuteId, entityType1, entityType2, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2> List<Tuple2<R1, R2>> list(TplExecuteId tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Tuple2<String, String> prefixes, Map<String, Object> params) {
        return sqlTplExecutor.list(tplExecuteId, entityType1, entityType2, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2> List<Tuple2<R1, R2>> list(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Tuple2<String, String> prefixes, Map<String, Object> params, int offset, int limit) {
        return sqlTplExecutor.list(tplExecuteId, entityType1, entityType2, prefixes, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2> List<Tuple2<R1, R2>> list(TplExecuteId tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Tuple2<String, String> prefixes, Map<String, Object> params, int offset, int limit) {
        return sqlTplExecutor.list(tplExecuteId, entityType1, entityType2, prefixes, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3> List<Tuple3<R1, R2, R3>> list(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Class<R3> entityType3, Map<String, Object> params) {
        return sqlTplExecutor.list(tplExecuteId, entityType1, entityType2, entityType3, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3> List<Tuple3<R1, R2, R3>> list(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Map<String, Object> params) {
        return sqlTplExecutor.list(tplExecuteId, entityType1, entityType2, entityType3, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3> List<Tuple3<R1, R2, R3>> list(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Class<R3> entityType3, Map<String, Object> param, int offset, int limits) {
        return sqlTplExecutor.list(tplExecuteId, entityType1, entityType2, entityType3, param, offset, limits);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3> List<Tuple3<R1, R2, R3>> list(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Map<String, Object> params, int offset, int limit) {
        return sqlTplExecutor.list(tplExecuteId, entityType1, entityType2, entityType3, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3> List<Tuple3<R1, R2, R3>> list(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Class<R3> entityType3, Tuple3<String, String, String> prefixes, Map<String, Object> params) {
        return sqlTplExecutor.list(tplExecuteId, entityType1, entityType2, entityType3, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3> List<Tuple3<R1, R2, R3>> list(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Tuple3<String, String, String> prefixes,
            Map<String, Object> params) {
        return sqlTplExecutor.list(tplExecuteId, entityType1, entityType2, entityType3, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3> List<Tuple3<R1, R2, R3>> list(String tplExecuteId, Class<R1> entityType1, Class<R2> entityType2,
            Class<R3> entityType3, Tuple3<String, String, String> prefixes, Map<String, Object> params, int offset,
            int limit) {
        return sqlTplExecutor.list(tplExecuteId, entityType1, entityType2, entityType3, prefixes, params, offset,
                limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3> List<Tuple3<R1, R2, R3>> list(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Tuple3<String, String, String> prefixes,
            Map<String, Object> params, int offset, int limit) {
        return sqlTplExecutor.list(tplExecuteId, entityType1, entityType2, entityType3, prefixes, params, offset,
                limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4> List<Tuple4<R1, R2, R3, R4>> list(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Map<String, Object> params) {
        return sqlTplExecutor.list(tplExecuteId, entityType1, entityType2, entityType3, entityType4, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4> List<Tuple4<R1, R2, R3, R4>> list(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Map<String, Object> params) {
        return sqlTplExecutor.list(tplExecuteId, entityType1, entityType2, entityType3, entityType4, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4> List<Tuple4<R1, R2, R3, R4>> list(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Map<String, Object> params, int offset,
            int limit) {
        return sqlTplExecutor.list(tplExecuteId, entityType1, entityType2, entityType3, entityType4, params, offset,
                limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4> List<Tuple4<R1, R2, R3, R4>> list(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Map<String, Object> params, int offset,
            int limit) {
        return sqlTplExecutor.list(tplExecuteId, entityType1, entityType2, entityType3, entityType4, params, offset,
                limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4> List<Tuple4<R1, R2, R3, R4>> list(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Tuple4<String, String, String, String> prefixes, Map<String, Object> params) {
        return sqlTplExecutor.list(tplExecuteId, entityType1, entityType2, entityType3, entityType4, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4> List<Tuple4<R1, R2, R3, R4>> list(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Tuple4<String, String, String, String> prefixes, Map<String, Object> params) {
        return sqlTplExecutor.list(tplExecuteId, entityType1, entityType2, entityType3, entityType4, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4> List<Tuple4<R1, R2, R3, R4>> list(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Tuple4<String, String, String, String> prefixes, Map<String, Object> params, int offset, int limit) {
        return sqlTplExecutor.list(tplExecuteId, entityType1, entityType2, entityType3, entityType4, prefixes, params,
                offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4> List<Tuple4<R1, R2, R3, R4>> list(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Tuple4<String, String, String, String> prefixes, Map<String, Object> params, int offset, int limit) {
        return sqlTplExecutor.list(tplExecuteId, entityType1, entityType2, entityType3, entityType4, prefixes, params,
                offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5> List<Tuple5<R1, R2, R3, R4, R5>> list(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
            Map<String, Object> params) {
        return sqlTplExecutor.list(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5,
                params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5> List<Tuple5<R1, R2, R3, R4, R5>> list(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
            Map<String, Object> params) {
        return sqlTplExecutor.list(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5,
                params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5> List<Tuple5<R1, R2, R3, R4, R5>> list(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
            Map<String, Object> params, int offset, int limit) {
        return sqlTplExecutor.list(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5,
                params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5> List<Tuple5<R1, R2, R3, R4, R5>> list(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
            Map<String, Object> params, int offset, int limit) {
        return sqlTplExecutor.list(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5,
                params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5> List<Tuple5<R1, R2, R3, R4, R5>> list(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
            Tuple5<String, String, String, String, String> prefixes, Map<String, Object> params) {
        return sqlTplExecutor.list(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5,
                prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5> List<Tuple5<R1, R2, R3, R4, R5>> list(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
            Tuple5<String, String, String, String, String> prefixes, Map<String, Object> params) {
        return sqlTplExecutor.list(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5,
                prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5> List<Tuple5<R1, R2, R3, R4, R5>> list(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
            Tuple5<String, String, String, String, String> prefixes, Map<String, Object> params, int offset,
            int limit) {
        return sqlTplExecutor.list(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5,
                prefixes, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5> List<Tuple5<R1, R2, R3, R4, R5>> list(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4, Class<R5> entityType5,
            Tuple5<String, String, String, String, String> prefixes, Map<String, Object> params, int offset,
            int limit) {
        return sqlTplExecutor.list(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5,
                prefixes, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5, R6> List<Tuple6<R1, R2, R3, R4, R5, R6>> list(String tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Class<R5> entityType5, Class<R6> entityType6, Map<String, Object> params) {
        return sqlTplExecutor.list(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5,
                entityType6, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5, R6> List<Tuple6<R1, R2, R3, R4, R5, R6>> list(String tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Class<R5> entityType5, Class<R6> entityType6, Map<String, Object> params, int offset, int limit) {
        return sqlTplExecutor.list(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5,
                entityType6, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5, R6> List<Tuple6<R1, R2, R3, R4, R5, R6>> list(TplExecuteId tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Class<R5> entityType5, Class<R6> entityType6, Map<String, Object> params) {
        return sqlTplExecutor.list(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5,
                entityType6, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5, R6> List<Tuple6<R1, R2, R3, R4, R5, R6>> list(TplExecuteId tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Class<R5> entityType5, Class<R6> entityType6, Map<String, Object> params, int offset, int limit) {
        return sqlTplExecutor.list(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5,
                entityType6, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5, R6> List<Tuple6<R1, R2, R3, R4, R5, R6>> list(String tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Class<R5> entityType5, Class<R6> entityType6,
            Tuple6<String, String, String, String, String, String> prefixes, Map<String, Object> params) {
        return sqlTplExecutor.list(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5,
                entityType6, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5, R6> List<Tuple6<R1, R2, R3, R4, R5, R6>> list(String tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Class<R5> entityType5, Class<R6> entityType6,
            Tuple6<String, String, String, String, String, String> prefixes, Map<String, Object> params, int offset,
            int limit) {
        return sqlTplExecutor.list(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5,
                entityType6, prefixes, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5, R6> List<Tuple6<R1, R2, R3, R4, R5, R6>> list(TplExecuteId tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Class<R5> entityType5, Class<R6> entityType6,
            Tuple6<String, String, String, String, String, String> prefixes, Map<String, Object> params) {
        return sqlTplExecutor.list(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5,
                entityType6, prefixes, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5, R6> List<Tuple6<R1, R2, R3, R4, R5, R6>> list(TplExecuteId tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Class<R5> entityType5, Class<R6> entityType6,
            Tuple6<String, String, String, String, String, String> prefixes, Map<String, Object> params, int offset,
            int limit) {
        return sqlTplExecutor.list(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5,
                entityType6, prefixes, params, offset, limit);
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
    public <R1, R2> PaginationResults<Tuple2<R1, R2>> pagination(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Map<String, Object> params, int offset, int limit) {
        return sqlTplExecutor.pagination(tplExecuteId, entityType1, entityType2, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2> PaginationResults<Tuple2<R1, R2>> pagination(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Map<String, Object> params, int offset, int limit) {
        return sqlTplExecutor.pagination(tplExecuteId, entityType1, entityType2, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2> PaginationResults<Tuple2<R1, R2>> pagination(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Tuple2<String, String> prefixes, Map<String, Object> params, int offset, int limit) {
        return sqlTplExecutor.pagination(tplExecuteId, entityType1, entityType2, prefixes, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2> PaginationResults<Tuple2<R1, R2>> pagination(TplExecuteId tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Tuple2<String, String> prefixes, Map<String, Object> params, int offset, int limit) {
        return sqlTplExecutor.pagination(tplExecuteId, entityType1, entityType2, prefixes, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3> PaginationResults<Tuple3<R1, R2, R3>> pagination(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Map<String, Object> param, int offset, int limits) {
        return sqlTplExecutor.pagination(tplExecuteId, entityType1, entityType2, entityType3, param, offset, limits);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3> PaginationResults<Tuple3<R1, R2, R3>> pagination(TplExecuteId tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Map<String, Object> params, int offset,
            int limit) {
        return sqlTplExecutor.pagination(tplExecuteId, entityType1, entityType2, entityType3, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3> PaginationResults<Tuple3<R1, R2, R3>> pagination(String tplExecuteId, Class<R1> entityType1,
            Class<R2> entityType2, Class<R3> entityType3, Tuple3<String, String, String> prefixes,
            Map<String, Object> params, int offset, int limit) {
        return sqlTplExecutor.pagination(tplExecuteId, entityType1, entityType2, entityType3, prefixes, params, offset,
                limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3> PaginationResults<Tuple3<R1, R2, R3>> pagination(TplExecuteId tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3,
            Tuple3<String, String, String> prefixes, Map<String, Object> params, int offset, int limit) {
        return sqlTplExecutor.pagination(tplExecuteId, entityType1, entityType2, entityType3, prefixes, params, offset,
                limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4> PaginationResults<Tuple4<R1, R2, R3, R4>> pagination(String tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Map<String, Object> params, int offset, int limit) {
        return sqlTplExecutor.pagination(tplExecuteId, entityType1, entityType2, entityType3, entityType4, params,
                offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4> PaginationResults<Tuple4<R1, R2, R3, R4>> pagination(TplExecuteId tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Map<String, Object> params, int offset, int limit) {
        return sqlTplExecutor.pagination(tplExecuteId, entityType1, entityType2, entityType3, entityType4, params,
                offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4> PaginationResults<Tuple4<R1, R2, R3, R4>> pagination(String tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Tuple4<String, String, String, String> prefixes, Map<String, Object> params, int offset, int limit) {
        return sqlTplExecutor.pagination(tplExecuteId, entityType1, entityType2, entityType3, entityType4, prefixes,
                params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4> PaginationResults<Tuple4<R1, R2, R3, R4>> pagination(TplExecuteId tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Tuple4<String, String, String, String> prefixes, Map<String, Object> params, int offset, int limit) {
        return sqlTplExecutor.pagination(tplExecuteId, entityType1, entityType2, entityType3, entityType4, prefixes,
                params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5> PaginationResults<Tuple5<R1, R2, R3, R4, R5>> pagination(String tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Class<R5> entityType5, Map<String, Object> params, int offset, int limit) {
        return sqlTplExecutor.pagination(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5,
                params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5> PaginationResults<Tuple5<R1, R2, R3, R4, R5>> pagination(TplExecuteId tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Class<R5> entityType5, Map<String, Object> params, int offset, int limit) {
        return sqlTplExecutor.pagination(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5,
                params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5> PaginationResults<Tuple5<R1, R2, R3, R4, R5>> pagination(String tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Class<R5> entityType5, Tuple5<String, String, String, String, String> prefixes, Map<String, Object> params,
            int offset, int limit) {
        return sqlTplExecutor.pagination(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5,
                prefixes, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5> PaginationResults<Tuple5<R1, R2, R3, R4, R5>> pagination(TplExecuteId tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Class<R5> entityType5, Tuple5<String, String, String, String, String> prefixes, Map<String, Object> params,
            int offset, int limit) {
        return sqlTplExecutor.pagination(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5,
                prefixes, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5, R6> PaginationResults<Tuple6<R1, R2, R3, R4, R5, R6>> pagination(String tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Class<R5> entityType5, Class<R6> entityType6, Map<String, Object> params, int offset, int limit) {
        return sqlTplExecutor.pagination(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5,
                entityType6, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5, R6> PaginationResults<Tuple6<R1, R2, R3, R4, R5, R6>> pagination(
            TplExecuteId tplExecuteId, Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3,
            Class<R4> entityType4, Class<R5> entityType5, Class<R6> entityType6, Map<String, Object> params, int offset,
            int limit) {
        return sqlTplExecutor.pagination(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5,
                entityType6, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5, R6> PaginationResults<Tuple6<R1, R2, R3, R4, R5, R6>> pagination(String tplExecuteId,
            Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3, Class<R4> entityType4,
            Class<R5> entityType5, Class<R6> entityType6,
            Tuple6<String, String, String, String, String, String> prefixes, Map<String, Object> params, int offset,
            int limit) {
        return sqlTplExecutor.pagination(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5,
                entityType6, prefixes, params, offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R1, R2, R3, R4, R5, R6> PaginationResults<Tuple6<R1, R2, R3, R4, R5, R6>> pagination(
            TplExecuteId tplExecuteId, Class<R1> entityType1, Class<R2> entityType2, Class<R3> entityType3,
            Class<R4> entityType4, Class<R5> entityType5, Class<R6> entityType6,
            Tuple6<String, String, String, String, String, String> prefixes, Map<String, Object> params, int offset,
            int limit) {
        return sqlTplExecutor.pagination(tplExecuteId, entityType1, entityType2, entityType3, entityType4, entityType5,
                entityType6, prefixes, params, offset, limit);
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

    /**
     * {@inheritDoc}
     */
    @Override
    public JdbcMappingFactory getMappingFactory() {
        return mappingFactory;
    }
}
