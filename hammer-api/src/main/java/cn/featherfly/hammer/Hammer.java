
package cn.featherfly.hammer;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.lang.ArrayUtils;
import cn.featherfly.common.lang.AssertIllegalArgument;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.operator.LogicOperator;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.common.repository.ParamedExecutionExecutor;
import cn.featherfly.common.repository.Repository;
import cn.featherfly.hammer.dsl.entity.execute.EntityDelete;
import cn.featherfly.hammer.dsl.entity.execute.EntityUpdate;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroup;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroupLogic;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryFetch;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryDelete;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryUpdate;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryFetch;
import cn.featherfly.hammer.tpl.TplExecuteId;
import cn.featherfly.hammer.tpl.TplExecuteIdBuilder;
import cn.featherfly.hammer.tpl.TplExecutor;

/**
 * Hammer.
 *
 * @author zhongj
 */
public interface Hammer {

    /**
     * save entity.
     *
     * @param <E>    the element type
     * @param entity the entity
     * @return effect data row num
     */
    <E> int save(E entity);

    /**
     * batch save entity array.
     *
     * @param <E>      the element type
     * @param entities the entities
     * @return effect data row num
     */
    default <E> int[] save(@SuppressWarnings("unchecked") E... entities) {
        if (Lang.isEmpty(entities)) {
            return ArrayUtils.EMPTY_INT_ARRAY;
        } else {
            return save(ArrayUtils.toList(entities));
        }
    }

    /**
     * batch save entity array.
     *
     * @param <E>       the element type
     * @param entities  the entities
     * @param batchSize the batch size
     * @return effect data row num
     */
    default <E> int[] save(E[] entities, int batchSize) {
        if (Lang.isEmpty(entities)) {
            return ArrayUtils.EMPTY_INT_ARRAY;
        } else {
            return save(ArrayUtils.toList(entities), batchSize);
        }
    }

    /**
     * batch save entity list.
     *
     * @param <E>      the element type
     * @param entities the entities
     * @return effect data row num
     */
    <E> int[] save(List<E> entities);

    /**
     * batch save entity list.
     *
     * @param <E>       the element type
     * @param entities  the entities
     * @param batchSize the batch size
     * @return effect data row num
     */
    <E> int[] save(List<E> entities, int batchSize);

    /**
     * update entity, update all values. equal invoke method {@link #update(Object, IgnoreStrategy)} with params
     * (entity, IgnoreStrategy.NONE)
     *
     * @param <E>    the element type
     * @param entity the entity
     * @return effect data row num
     */
    <E> int update(E entity);

    /**
     * update entity, update values with ignoreStrategy.
     *
     * @param <E>            the element type
     * @param entity         the entity
     * @param ignoreStrategy the ignore strategy
     * @return effect data row num
     */
    <E> int update(E entity, IgnoreStrategy ignoreStrategy);

    /**
     * query type with id and lock, then update and fetch.
     * <p>
     * sql database will use select for udpate to lock row where pk = id.
     * </p>
     *
     * @param <E>            the element type
     * @param id             the id
     * @param type           the type
     * @param updateOperator the update operator
     * @return updated entity
     */
    <E> E updateFetch(Serializable id, Class<E> type, UnaryOperator<E> updateOperator);

    /**
     * query entity type with id and lock, then update and fetch.
     * <p>
     * sql database will use select for udpate to lock row where pk = id.
     * </p>
     *
     * @param <E>            the element type
     * @param entity         the entity
     * @param updateOperator the update operator
     * @return updated entity
     */
    <E> E updateFetch(E entity, UnaryOperator<E> updateOperator);

    /**
     * update all values for each entity in entity array. equal invoke method {@link #update(List, IgnoreStrategy)} with
     * params (entity, IgnoreStrategy.NONE)
     *
     * @param <E>      the element type
     * @param entities the entities
     * @return effect data row num
     */
    <E> int[] update(@SuppressWarnings("unchecked") E... entities);

    /**
     * update all values for each entity in entity list. equal invoke method {@link #update(List, IgnoreStrategy)} with
     * params (entity, IgnoreStrategy.NONE)
     *
     * @param <E>      the element type
     * @param entities the entities
     * @return effect data row num
     */
    <E> int[] update(List<E> entities);

    /**
     * update all values for each entity in entity list. equal invoke method {@link #update(List, IgnoreStrategy)} with
     * params (entity, IgnoreStrategy.NONE)
     *
     * @param <E>       the element type
     * @param entities  the entities
     * @param batchSize the batch size
     * @return effect data row num
     */
    <E> int[] update(List<E> entities, int batchSize);

    /**
     * update values with ignoreStrategy for each entity in entity list.
     *
     * @param <E>            the element type
     * @param entities       the entities
     * @param ignoreStrategy the ignore strategy
     * @return effect data row num
     */
    <E> int[] update(List<E> entities, IgnoreStrategy ignoreStrategy);

    /**
     * update values ignore null or empty(string, array, collectoin, map) value. equal invoke method
     * {@link #update(Object, IgnoreStrategy)} with params (entity, IgnoreStrategy.EMPTY)
     *
     * @param <E>    the element type
     * @param entity the entity
     * @return effect data row num
     */
    <E> int merge(E entity);

    /**
     * update values ignore null or empty(string, array, collectoin, map) value for each entity in entity array. equal
     * invoke method {@link #update(Object, IgnoreStrategy)} with params (entity, IgnoreStrategy.EMPTY)
     *
     * @param <E>      the element type
     * @param entities the entities
     * @return effect data row num
     */
    <E> int[] merge(@SuppressWarnings("unchecked") E... entities);

    /**
     * update values ignore null or empty(string, array, collectoin, map) value for each entity in entity list. equal
     * invoke method {@link #update(List, IgnoreStrategy)} with params (entity, IgnoreStrategy.EMPTY)
     *
     * @param <E>      the element type
     * @param entities the entities
     * @return effect data row num
     */
    <E> int[] merge(List<E> entities);

    /**
     * save or update entity.
     *
     * @param <E>    the element type
     * @param entity the entity
     * @return effect data row num
     */
    <E> int saveOrUpdate(E entity);

    /**
     * save or update entity.
     *
     * @param <E>       the element type
     * @param entity    the entity
     * @param updatable the updatable
     * @return effect data row num
     */
    <E> int saveOrUpdate(E entity, Predicate<E> updatable);

    /**
     * delete entity by id.
     *
     * @param <E>    the element type
     * @param entity the entity
     * @return effect data row num
     */
    <E> int delete(E entity);

    /**
     * delete entity by id.
     *
     * @param <E>        the element type
     * @param id         the id
     * @param entityType the entity type
     * @return effect data row num
     */
    <E> int delete(Serializable id, Class<E> entityType);

    /**
     * delete entity by id array.
     *
     * @param <E>        the element type
     * @param ids        the ids
     * @param entityType the entity type
     * @return effect data row num
     */
    <E> int[] delete(Serializable[] ids, Class<E> entityType);

    /**
     * delete entity by id list.
     *
     * @param <E>        the element type
     * @param <I>        the generic type
     * @param ids        the ids
     * @param entityType the entity type
     * @return effect data row num
     */
    <E, I extends Serializable> int[] delete(List<I> ids, Class<E> entityType);

    /**
     * delete each entity in entity list.
     *
     * @param <E>      the element type
     * @param entities the entities
     * @return effect data row num
     */
    default <E> int[] delete(@SuppressWarnings("unchecked") E... entities) {
        return delete(ArrayUtils.toList(entities));
    }

    /**
     * delete each entity in entity list.
     *
     * @param <E>      the element type
     * @param entities the entities
     * @return effect data row num
     */
    <E> int[] delete(List<E> entities);

    /**
     * get entity by id.
     *
     * @param <E>  the element type
     * @param id   the id
     * @param type the type
     * @return entity
     */
    <E> E get(Serializable id, Class<E> type);

    /**
     * get entity by id and fetch property entity.
     *
     * @param <E>           the element type
     * @param <R>           the generic type
     * @param id            the id
     * @param type          the type
     * @param fetchProperty the fetch property
     * @return entity
     */
    <E, R> E get(Serializable id, Class<E> type, SerializableFunction<E, R> fetchProperty);

    /**
     * get entity list by id array.
     *
     * @param <E>  the element type
     * @param type the type
     * @param ids  the ids
     * @return entity
     */
    <E> List<E> get(Class<E> type, Serializable... ids);

    /**
     * get entity list by id list.
     *
     * @param <E>  the element type
     * @param type the type
     * @param ids  the ids
     * @return entity
     */
    <E> List<E> get(Class<E> type, List<Serializable> ids);

    /**
     * get entity by id.
     *
     * @param <E>    the element type
     * @param entity the entity
     * @return entity
     */
    <E> E get(E entity);

    /**
     * load entity by id, the same logic with get(entity).
     *
     * @param <E>    the element type
     * @param entity the entity
     * @return entity
     */
    default <E> E load(E entity) {
        return get(entity);
    }

    //    <E> E getBy(Class<E> type, Map<String, Object> propertyValueMap);
    //
    //    <E> E getBy(Class<E> type, Map<SerializableFunction<E, ?>, ?> propertyValueMap);

    /**
     * Query single by propertyValues.
     *
     * @param <E>            the element type
     * @param type           the type
     * @param propertyValues the property values
     * @return the e
     */
    default <E> E querySingle(Class<E> type, SerializableSupplier<?>... propertyValues) {
        AssertIllegalArgument.isNotEmpty(propertyValues, "propertyValues");
        EntityQueryConditionGroup<E> queryCondition = query(type).where();
        EntityQueryConditionGroupLogic<E> queryLogic = null;
        for (int i = 0; i < propertyValues.length; i++) {
            @SuppressWarnings("unchecked")
            SerializableSupplier<Serializable> propertyValue = (SerializableSupplier<Serializable>) propertyValues[i];
            if (i == 0) {
                queryLogic = queryCondition.eq(propertyValue);
            } else {
                queryLogic = queryLogic.and().eq(propertyValue);
            }
        }
        return queryLogic == null ? null : queryLogic.single();
    }

    /**
     * Query list by propertyValues.
     *
     * @param <E>            the element type
     * @param type           the type
     * @param propertyValues the property values
     * @return LogicExpressionist
     */
    default <E> List<E> queryList(Class<E> type, SerializableSupplier<?>... propertyValues) {
        return queryList(type, LogicOperator.AND, propertyValues);
    }

    /**
     * Query list by propertyValues.
     *
     * @param <E>            the element type
     * @param type           the type
     * @param operator       the operator
     * @param propertyValues the property values
     * @return LogicExpressionist
     */
    default <E> List<E> queryList(Class<E> type, LogicOperator operator, SerializableSupplier<?>... propertyValues) {
        if (Lang.isEmpty(propertyValues)) {
            return query(type).list();
        }
        AssertIllegalArgument.isNotNull(operator, "operator");

        EntityQueryConditionGroup<E> queryCondition = query(type).where();
        EntityQueryConditionGroupLogic<E> queryLogic = null;
        for (int i = 0; i < propertyValues.length; i++) {
            @SuppressWarnings("unchecked")
            SerializableSupplier<Serializable> propertyValue = (SerializableSupplier<Serializable>) propertyValues[i];
            if (i == 0) {
                queryLogic = queryCondition.eq(propertyValue);
            } else {
                if (operator == LogicOperator.AND) {
                    queryLogic = queryLogic.and().eq(propertyValue);
                } else {
                    queryLogic = queryLogic.or().eq(propertyValue);
                }
            }
        }
        return queryLogic == null ? null : queryLogic.list();
    }

    /**
     * create QueryEntity for repository.
     *
     * @param repository the repository
     * @return QueryEntity
     */
    RepositoryQueryFetch query(String repository);

    /**
     * create QueryEntity for repository.
     *
     * @param repository the repository
     * @return the query entity
     */
    RepositoryQueryFetch query(Repository repository);

    /**
     * create EntityQueryEntity for entityType. entity type must be a entity object, otherwise throws HammerException
     *
     * @param <E>        the element type
     * @param entityType the entity type
     * @return EntityQueryEntity
     */
    <E> EntityQueryFetch<E> query(Class<E> entityType);

    /**
     * create update for repository.
     *
     * @param repository the repository
     * @return Update
     */
    RepositoryUpdate update(String repository);

    /**
     * create update for repository.
     *
     * @param repository the repository
     * @return Update
     */
    RepositoryUpdate update(Repository repository);

    /**
     * create update for entityType.
     *
     * @param <E>        the element type
     * @param entityType the entity type
     * @return Update
     */
    <E> EntityUpdate<E> update(Class<E> entityType);

    /**
     * create delete for repository.
     *
     * @param repository the repository
     * @return Delete
     */
    RepositoryDelete delete(String repository);

    /**
     * create delete for repository.
     *
     * @param repository the repository
     * @return Delete
     */
    RepositoryDelete delete(Repository repository);

    /**
     * create delete for entityType.
     *
     * @param <E>        the element type
     * @param entityType the entity type
     * @return Delete
     */
    <E> EntityDelete<E> delete(Class<E> entityType);

    /**
     * Execution.
     *
     * @param dml    the execution
     * @param params the params
     * @return the paramed execution executor
     */
    ParamedExecutionExecutor dml(String dml, Map<String, Object> params);

    /**
     * Execution.
     *
     * @param dml    the execution
     * @param params the params
     * @return the paramed execution executor
     */
    ParamedExecutionExecutor dml(String dml, Object... params);

    /**
     * Template.
     *
     * @return the tpl executor
     */
    TplExecutor template();

    /**
     * Template.
     *
     * @param tplExecuteId the tpl execute id
     * @param params       the params
     * @return the paramed execution executor
     */
    ParamedExecutionExecutor template(String tplExecuteId, Map<String, Object> params);

    /**
     * Template.
     *
     * @param tplExecuteId the tpl execute id
     * @param params       the params
     * @return the paramed execution executor
     */
    ParamedExecutionExecutor template(String tplExecuteId, Object... params);

    /**
     * Template.
     *
     * @param tplExecuteIdBuilder the tpl execute id builder
     * @param params              the params
     * @return the paramed execution executor
     */
    ParamedExecutionExecutor template(Function<TplExecuteIdBuilder, TplExecuteId> tplExecuteIdBuilder,
            Map<String, Object> params);

    /**
     * Template.
     *
     * @param tplExecuteIdBuilder the tpl execute id builder
     * @param params              the params
     * @return the paramed execution executor
     */
    ParamedExecutionExecutor template(Function<TplExecuteIdBuilder, TplExecuteId> tplExecuteIdBuilder,
            Object... params);

    /**
     * Template.
     *
     * @param tplExecuteId the tpl execute id
     * @param params       the params
     * @return the paramed execution executor
     */
    ParamedExecutionExecutor template(TplExecuteId tplExecuteId, Map<String, Object> params);

    /**
     * Template.
     *
     * @param tplExecuteId the tpl execute id
     * @param params       the params
     * @return the paramed execution executor
     */
    ParamedExecutionExecutor template(TplExecuteId tplExecuteId, Object... params);
}
