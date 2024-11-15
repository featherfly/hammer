
package cn.featherfly.hammer.sqldb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

import javax.annotation.Nonnull;

import cn.featherfly.common.bean.BeanDescriptor;
import cn.featherfly.common.bean.BeanProperty;
import cn.featherfly.common.bean.PropertyAccessorFactory;
import cn.featherfly.common.db.Table;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.lang.ArrayUtils;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.common.repository.ParamedExecutionExecutorEx;
import cn.featherfly.common.repository.Repository;
import cn.featherfly.hammer.config.HammerConfig;
import cn.featherfly.hammer.dsl.entity.execute.EntityDelete;
import cn.featherfly.hammer.dsl.entity.execute.EntityUpdate;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryFetch;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryDelete;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryUpdate;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryFetch;
import cn.featherfly.hammer.sqldb.dsl.execute.SqlDeleter;
import cn.featherfly.hammer.sqldb.dsl.execute.SqlUpdater;
import cn.featherfly.hammer.sqldb.dsl.query.SqlQuery;
import cn.featherfly.hammer.sqldb.dsl.repository.query.RepositorySqlQueryFetch;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.sqldb.jdbc.JdbcExecutor;
import cn.featherfly.hammer.sqldb.jdbc.SimpleSqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.operate.DeleteOperate;
import cn.featherfly.hammer.sqldb.jdbc.operate.GetOperate;
import cn.featherfly.hammer.sqldb.jdbc.operate.InsertOperate;
import cn.featherfly.hammer.sqldb.jdbc.operate.MergeOperate;
import cn.featherfly.hammer.sqldb.jdbc.operate.UpdateFetchOperate;
import cn.featherfly.hammer.sqldb.jdbc.operate.UpdateOperate;
import cn.featherfly.hammer.sqldb.jdbc.operate.UpsertOperate;
import cn.featherfly.hammer.sqldb.tpl.SqlDbTemplateEngine;
import cn.featherfly.hammer.sqldb.tpl.SqlTplExecutor;
import cn.featherfly.hammer.sqldb.tpl.freemarker.SqldbFreemarkerTemplateEngine;
import cn.featherfly.hammer.sqldb.tpl.freemarker.SqldbFreemarkerTemplateProcessEnv;
import cn.featherfly.hammer.sqldb.tpl.transverter.FuzzyQueryTransverter;
import cn.featherfly.hammer.tpl.ArrayParamedExecutionExecutorEx;
import cn.featherfly.hammer.tpl.MapParamedExecutionExecutorEx;
import cn.featherfly.hammer.tpl.TplConfigFactory;
import cn.featherfly.hammer.tpl.TplExecuteId;
import cn.featherfly.hammer.tpl.TplExecuteIdBuilder;
import cn.featherfly.hammer.tpl.TplExecuteIdBuilderImpl;
import cn.featherfly.hammer.tpl.TplExecutor;
import cn.featherfly.hammer.tpl.TransverterManager;
import cn.featherfly.hammer.tpl.directive.TemplateDirective;
import cn.featherfly.hammer.tpl.method.TemplateMethod;
import cn.featherfly.validation.metadata.ConstraintViolation;
import freemarker.template.TemplateModelException;

/**
 * SqldbHammerImpl.
 *
 * @author zhongj
 */
public class SqldbHammerImpl implements SqldbHammer {

    private final Jdbc jdbc;

    private final JdbcExecutor jdbcExecutor;

    private final JdbcMappingFactory mappingFactory;

    private final HammerConfig hammerConfig;

    private final SqlTplExecutor sqlTplExecutor;

    private final Map<Class<?>, InsertOperate<?>> insertOperates = new HashMap<>();

    private final Map<Class<?>, UpdateOperate<?>> updateOperates = new HashMap<>();

    private final Map<Class<?>, UpdateFetchOperate<?>> updateFetchOperates = new HashMap<>();

    private final Map<Class<?>, UpsertOperate<?>> upsertOperates = new HashMap<>();

    private final Map<Class<?>, GetOperate<?>> getOperates = new HashMap<>();

    private final Map<Class<?>, DeleteOperate<?>> deleteOperates = new HashMap<>();

    private final Map<Class<?>, MergeOperate<?>> mergeOperates = new HashMap<>();

    private final SqlQuery query;

    private final SqlUpdater updater;

    private final SqlDeleter deleter;

    private final PropertyAccessorFactory propertyAccessorFactory;

    private SqldbHammerImpl(Builder builder) {
        jdbc = builder.jdbc;
        mappingFactory = builder.mappingFactory;
        hammerConfig = builder.hammerConfig;
        propertyAccessorFactory = builder.propertyAccessorFactory;

        jdbcExecutor = new JdbcExecutor(jdbc, propertyAccessorFactory, builder.sqlPageFacotry);
        sqlTplExecutor = new SqlTplExecutor(hammerConfig, builder.configFactory, builder.templateEngine, jdbc,
            mappingFactory, builder.sqlPageFacotry, builder.transverterManager);
        query = new SqlQuery(jdbc, mappingFactory, sqlTplExecutor.getSqlPageFactory(), hammerConfig);
        updater = new SqlUpdater(jdbc, mappingFactory, hammerConfig.getDslConfig().getUpdateConfig());
        deleter = new SqlDeleter(jdbc, mappingFactory, hammerConfig.getDslConfig().getDeleteConfig());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int save(E entity) {
        if (entity == null) {
            return 0;
        }
        InsertOperate<E> insert = insertOperate(entity);
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
    public <E> int[] save(List<E> entities) {
        return save(entities, hammerConfig.getEntityConfig().getInsert().getBatchSize());
    }

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
                insert = insertOperate(entity);
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
        return saveOrUpdate(entity, (e) -> {
            @SuppressWarnings("unchecked")
            GetOperate<E> get = (GetOperate<E>) getOperate(e.getClass());
            List<Serializable> ids = get.getIds(e);
            if (ids.size() == 1) {
                Serializable id = ids.get(0);
                // FIXME 当前的逻辑在手动设置id值的时候会有问题
                if (id == null) {
                    return false;
                } else {
                    return true;
                }
            } else if (ids.size() > 1) {
                boolean insertable = false;
                for (Serializable id : ids) {
                    if (id == null) { // 只要有一个id为空，则表示需要插入数据
                        insertable = true;
                    }
                }
                if (insertable) {
                    return false;
                } else {
                    return true;
                }
            } else {
                throw new SqldbHammerException("no pk mapping");
            }
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int saveOrUpdate(E entity, Predicate<E> updatable) {
        if (entity == null) {
            return 0;
        }
        if (jdbc.getDialect().supportUpsert()) {
            UpsertOperate<E> upsert = upsertOperate(entity);
            return upsert.execute(entity);
        } else {
            if (updatable.test(entity)) {
                return update(entity);
            } else {
                return save(entity);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int update(E entity) {
        if (entity == null) {
            return 0;
        }
        UpdateOperate<E> update = updateOperate(entity);
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
        return update(entities, hammerConfig.getEntityConfig().getUpdate().getBatchSize());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int[] update(E[] entities, int batchSize) {
        if (Lang.isEmpty(entities)) {
            return ArrayUtils.EMPTY_INT_ARRAY;
        }
        return update(Lang.list(entities), batchSize);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> int[] update(List<E> entities) {
        if (Lang.isEmpty(entities)) {
            return ArrayUtils.EMPTY_INT_ARRAY;
        }
        return update(entities, hammerConfig.getEntityConfig().getUpdate().getBatchSize());
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
            UpdateOperate<E> update = updateOperate(type);
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
        if (Lang.isEmpty(entities)) {
            return ArrayUtils.EMPTY_INT_ARRAY;
        }

        // ENHANCE 后续来改为批量更新
        int results[] = new int[entities.size()];
        for (int i = 0; i < entities.size(); i++) {
            results[i] = update(entities.get(i), ignoreStrategy);
        }
        return results;
    }

    /**
     * Merge.
     *
     * @param <E> the element type
     * @param entity the entity
     * @param onlyNull the only null
     * @return the int
     */
    private <E> int merge(E entity, boolean onlyNull) {
        if (entity == null) {
            return 0;
        }
        MergeOperate<E> merge = mergeOperate(entity);
        validate(entity);
        return merge.execute(entity, onlyNull);
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
        DeleteOperate<E> delete = deleteOperate(entityType);
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
        DeleteOperate<E> delete = deleteOperate(entityType);
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
        DeleteOperate<E> delete = deleteOperate(entityType);
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
        DeleteOperate<E> delete = deleteOperate(entity);
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
        DeleteOperate<E> delete = deleteOperate(entities);
        if (delete == null) {
            return ArrayUtils.EMPTY_INT_ARRAY;
        }
        return delete.executeBatch(entities);
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
    public <E> E updateFetch(Serializable id, Class<E> type, UnaryOperator<E> updateOperator) {
        if (Lang.isEmpty(id)) {
            return null;
        }
        return updateFetchOperate(type).execute(id, updateOperator);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E updateFetch(E entity, UnaryOperator<E> updateOperator) {
        if (entity == null) {
            return null;
        }
        return updateFetchOperate(entity).execute(entity, updateOperator);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryFetch query(String repository) {
        return query.find(repository);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryFetch query(Repository repository) {
        return query.find(repository);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositorySqlQueryFetch query(Table table) {
        return query.find(table);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> EntityQueryFetch<E> query(Class<E> entityType) {
        return query.find(entityType);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> EntityUpdate<E> update(Class<E> entityType) {
        return updater.update(entityType);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryUpdate update(String repository) {
        return updater.update(repository);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryUpdate update(Repository repository) {
        return updater.update(repository);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryUpdate update(Table table) {
        return updater.update(table);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryDelete delete(String repository) {
        return deleter.delete(repository);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryDelete delete(Repository repository) {
        return deleter.delete(repository);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryDelete delete(Table table) {
        return deleter.delete(table);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> EntityDelete<E> delete(Class<E> entityType) {
        return deleter.delete(entityType);
    }

    /**
     * Validate.
     *
     * @param <E> the element type
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

    @SuppressWarnings("unchecked")
    private <E> MergeOperate<E> mergeOperate(E entity) {
        return mergeOperate((Class<E>) entity.getClass());
    }

    @SuppressWarnings("unchecked")
    private <E> MergeOperate<E> mergeOperate(final Class<E> entityType) {
        return (MergeOperate<E>) mergeOperates.computeIfAbsent(entityType,
            type -> new MergeOperate<E>(jdbc, mappingFactory.getClassMapping(entityType),
                mappingFactory.getSqlTypeMappingManager(), mappingFactory.getMetadata()));
    }

    @SuppressWarnings("unchecked")
    private <E> UpdateOperate<E> updateOperate(E entity) {
        return updateOperate((Class<E>) entity.getClass());
    }

    @SuppressWarnings("unchecked")
    private <E> UpdateOperate<E> updateOperate(final Class<E> entityType) {
        return (UpdateOperate<E>) updateOperates.computeIfAbsent(entityType,
            type -> new UpdateOperate<E>(jdbc, mappingFactory.getClassMapping(entityType),
                mappingFactory.getSqlTypeMappingManager(), mappingFactory.getMetadata()));
    }

    @SuppressWarnings("unchecked")
    private <E> UpdateFetchOperate<E> updateFetchOperate(E entity) {
        return updateFetchOperate((Class<E>) entity.getClass());
    }

    @SuppressWarnings("unchecked")
    private <E> UpdateFetchOperate<E> updateFetchOperate(final Class<E> entityType) {
        return (UpdateFetchOperate<E>) updateFetchOperates.computeIfAbsent(entityType,
            type -> new UpdateFetchOperate<>(jdbc, mappingFactory.getClassMapping(entityType),
                mappingFactory.getSqlTypeMappingManager(), mappingFactory.getMetadata(), getOperate(entityType),
                updateOperate(entityType), key -> {
                    // IMPLSOON 后续来从配置创建锁并进行加锁操作
                }, key -> {
                    // IMPLSOON 后续来从配置创建锁并进行解锁操作
                }));
    }

    @SuppressWarnings("unchecked")
    private <E> InsertOperate<E> insertOperate(E entity) {
        return insertOperate((Class<E>) entity.getClass());
    }

    @SuppressWarnings("unchecked")
    private <E> InsertOperate<E> insertOperate(final Class<E> entityType) {
        return (InsertOperate<E>) insertOperates.computeIfAbsent(entityType,
            type -> new InsertOperate<>(jdbc, mappingFactory.getClassMapping(entityType),
                mappingFactory.getSqlTypeMappingManager(), mappingFactory.getMetadata()));
    }

    @SuppressWarnings("unchecked")
    private <E> UpsertOperate<E> upsertOperate(E entity) {
        return upsertOperate((Class<E>) entity.getClass());
    }

    @SuppressWarnings("unchecked")
    private <E> UpsertOperate<E> upsertOperate(final Class<E> entityType) {
        return (UpsertOperate<E>) upsertOperates.computeIfAbsent(entityType,
            type -> new UpsertOperate<>(jdbc, mappingFactory.getClassMapping(entityType),
                mappingFactory.getSqlTypeMappingManager(), mappingFactory.getMetadata()));
    }

    private <E> DeleteOperate<E> deleteOperate(Collection<E> entities) {
        E e = Lang.ifNotNullFirst(entities);
        if (e == null) {
            return null;
        }
        return deleteOperate(e);
    }

    @SuppressWarnings("unchecked")
    private <E> DeleteOperate<E> deleteOperate(E entity) {
        return deleteOperate((Class<E>) entity.getClass());
    }

    @SuppressWarnings("unchecked")
    private <E> DeleteOperate<E> deleteOperate(final Class<E> entityType) {
        return (DeleteOperate<E>) deleteOperates.computeIfAbsent(entityType,
            type -> new DeleteOperate<>(jdbc, mappingFactory.getClassMapping(entityType),
                mappingFactory.getSqlTypeMappingManager(), mappingFactory.getMetadata()));
    }

    @SuppressWarnings("unchecked")
    private <E> GetOperate<E> getOperate(final Class<E> entityType) {
        return (GetOperate<E>) getOperates.computeIfAbsent(entityType,
            type -> new GetOperate<E>(jdbc, mappingFactory.getClassMapping(entityType),
                mappingFactory.getSqlTypeMappingManager(), mappingFactory.getMetadata(),
                propertyAccessorFactory.create(entityType)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ParamedExecutionExecutorEx dml(String execution, Map<String, Serializable> params) {
        return new MapParamedExecutionExecutorEx<>(jdbcExecutor, execution, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ParamedExecutionExecutorEx dml(String execution, Serializable... params) {
        return new ArrayParamedExecutionExecutorEx<>(jdbcExecutor, execution, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TplExecutor template() {
        return sqlTplExecutor;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ParamedExecutionExecutorEx template(String templateId, Map<String, Serializable> params) {
        return template(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(templateId), params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ParamedExecutionExecutorEx template(String templateId, Serializable... params) {
        return template(hammerConfig.getTemplateConfig().getTplExecuteIdParser().parse(templateId), params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ParamedExecutionExecutorEx template(Function<TplExecuteIdBuilder, TplExecuteId> tplExecuteIdBuilder,
        Map<String, Serializable> params) {
        return template(tplExecuteIdBuilder
            .apply(new TplExecuteIdBuilderImpl(hammerConfig.getTemplateConfig().getTplExecuteIdParser())), params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ParamedExecutionExecutorEx template(Function<TplExecuteIdBuilder, TplExecuteId> tplExecuteIdBuilder,
        Serializable... params) {
        return template(tplExecuteIdBuilder
            .apply(new TplExecuteIdBuilderImpl(hammerConfig.getTemplateConfig().getTplExecuteIdParser())), params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ParamedExecutionExecutorEx template(TplExecuteId tplExecuteId, Map<String, Serializable> params) {
        return new MapParamedExecutionExecutorEx<>(sqlTplExecutor, tplExecuteId, params);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ParamedExecutionExecutorEx template(TplExecuteId tplExecuteId, Serializable... params) {
        return new ArrayParamedExecutionExecutorEx<>(sqlTplExecutor, tplExecuteId, params);
    }

    // ****************************************************************************************************************
    //	builder
    // ****************************************************************************************************************

    /**
     * Builder.
     *
     * @return the builder
     */
    public static Builder builder() {
        return builder();
    }

    /**
     * Builder.
     *
     * @param jdbc the jdbc
     * @param mappingFactory the mapping factory
     * @param configFactory the config factory
     * @param propertyAccessorFactory the property accessor factory
     * @param hammerConfig the hammer config
     * @return the builder
     */
    public static Builder builder(Jdbc jdbc, JdbcMappingFactory mappingFactory, TplConfigFactory configFactory,
        PropertyAccessorFactory propertyAccessorFactory, HammerConfig hammerConfig) {
        return new Builder(jdbc, mappingFactory, configFactory, propertyAccessorFactory, hammerConfig);
    }

    /**
     * The Class Builder.
     *
     * @author zhongj
     */
    public static final class Builder {
        private Jdbc jdbc;
        private JdbcMappingFactory mappingFactory;
        private TplConfigFactory configFactory;
        private SqlDbTemplateEngine<? extends TemplateDirective, ? extends TemplateMethod> templateEngine;
        private SqlPageFactory sqlPageFacotry;
        private TransverterManager transverterManager;
        private PropertyAccessorFactory propertyAccessorFactory;
        private HammerConfig hammerConfig;

        private Builder() {

        }

        private Builder(Jdbc jdbc, JdbcMappingFactory mappingFactory, TplConfigFactory configFactory,
            PropertyAccessorFactory propertyAccessorFactory, HammerConfig hammerConfig) {
            this.jdbc = jdbc;
            this.mappingFactory = mappingFactory;
            this.configFactory = configFactory;
            this.propertyAccessorFactory = propertyAccessorFactory;
            this.hammerConfig = hammerConfig;
        }

        /**
         * Sets the jdbc.
         *
         * @param jdbc the jdbc
         * @return the builder
         */
        public Builder setJdbc(Jdbc jdbc) {
            this.jdbc = jdbc;
            return this;
        }

        /**
         * Sets the mapping factory.
         *
         * @param mappingFactory the mapping factory
         * @return the builder
         */
        public Builder setMappingFactory(JdbcMappingFactory mappingFactory) {
            this.mappingFactory = mappingFactory;
            return this;
        }

        /**
         * Sets the hammer config.
         *
         * @param hammerConfig the hammer config
         * @return the builder
         */
        public Builder setHammerConfig(HammerConfig hammerConfig) {
            this.hammerConfig = hammerConfig;
            return this;
        }

        /**
         * Sets the property accessor factory.
         *
         * @param propertyAccessorFactory the property accessor factory
         * @return the builder
         */
        public Builder setPropertyAccessorFactory(PropertyAccessorFactory propertyAccessorFactory) {
            this.propertyAccessorFactory = propertyAccessorFactory;
            return this;
        }

        /**
         * Sets the config factory.
         *
         * @param configFactory the config factory
         * @return the builder
         */
        public Builder setConfigFactory(TplConfigFactory configFactory) {
            this.configFactory = configFactory;
            return this;
        }

        /**
         * Sets the template engine.
         *
         * @param templateEngine the template engine
         * @return the builder
         */
        public Builder setTemplateEngine(
            SqlDbTemplateEngine<? extends TemplateDirective, ? extends TemplateMethod> templateEngine) {
            this.templateEngine = templateEngine;
            return this;
        }

        /**
         * Sets the sql page facotry.
         *
         * @param sqlPageFacotry the sql page facotry
         * @return the builder
         */
        public Builder setSqlPageFacotry(SqlPageFactory sqlPageFacotry) {
            this.sqlPageFacotry = sqlPageFacotry;
            return this;
        }

        /**
         * Sets the transverter manager.
         *
         * @param transverterManager the transverter manager
         * @return the builder
         */
        public Builder setTransverterManager(TransverterManager transverterManager) {
            this.transverterManager = transverterManager;
            return this;
        }

        /**
         * Builds the.
         *
         * @return the sqldb hammer impl
         * @throws TemplateModelException
         */
        public SqldbHammerImpl build() {
            if (templateEngine == null) {
                SqldbFreemarkerTemplateProcessEnv sharedTemplateProcessEnv = new SqldbFreemarkerTemplateProcessEnv(
                    true);
                sharedTemplateProcessEnv.setConfigFactory(configFactory);
                sharedTemplateProcessEnv.setMappingFactory(mappingFactory);
                sharedTemplateProcessEnv.setTemplateConfig(hammerConfig.getTemplateConfig());

                templateEngine = new SqldbFreemarkerTemplateEngine(configFactory, hammerConfig.getTemplateConfig(),
                    sharedTemplateProcessEnv.createDirectives(), sharedTemplateProcessEnv.createMethods());
            }
            if (sqlPageFacotry == null) {
                sqlPageFacotry = new SimpleSqlPageFactory();
            }
            if (transverterManager == null) {
                transverterManager = new TransverterManager(new FuzzyQueryTransverter());
            }
            return new SqldbHammerImpl(this);
        }
    }
}
