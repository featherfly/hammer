
package cn.featherfly.hammer;

import java.io.Serializable;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.lang.ArrayUtils;
import cn.featherfly.common.lang.AssertIllegalArgument;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.operator.LogicOperator;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.common.repository.Repository;
import cn.featherfly.hammer.dsl.entity.execute.EntityDelete;
import cn.featherfly.hammer.dsl.entity.execute.EntityUpdate;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroup;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroupLogic;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryFetch;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryDelete;
import cn.featherfly.hammer.dsl.repository.execute.RepositoryUpdate;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryFetch;
import cn.featherfly.hammer.tpl.TplExecutor;

/**
 * Hammer.
 *
 * @author zhongj
 */
public interface Hammer extends TplExecutor {

    /**
     * save entity.
     *
     * @param <E>    generic type
     * @param entity entity to save
     * @return effect data row num
     */
    <E> int save(E entity);

    /**
     * batch save entity array.
     *
     * @param <E>      generic type
     * @param entities entity array to save
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
     * @param <E>       generic type
     * @param entities  entity array to save
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
     * @param <E>      generic type
     * @param entities entity list to save
     * @return effect data row num
     */
    default <E> int[] save(List<E> entities) {
        if (Lang.isEmpty(entities)) {
            return ArrayUtils.EMPTY_INT_ARRAY;
        } else {
            return save(entities, entities.size());
        }
    }

    /**
     * batch save entity list.
     *
     * @param <E>       generic type
     * @param entities  entity list to save
     * @param batchSize the batch size
     * @return effect data row num
     */
    <E> int[] save(List<E> entities, int batchSize);

    /**
     * update entity, update all values. equal invoke method {@link #update(Object, IgnoreStrategy)} with params
     * (entity, IgnoreStrategy.NONE)
     *
     * @param <E>    generic type
     * @param entity entity to update
     * @return effect data row num
     */
    <E> int update(E entity);

    /**
     * update entity, update values with ignoreStrategy.
     *
     * @param <E>            generic type
     * @param entity         entity to update
     * @param ignoreStrategy ignore value to update strategy
     * @return effect data row num
     */
    <E> int update(E entity, IgnoreStrategy ignoreStrategy);

    /**
     * query type with id and lock, then update and fetch.
     * <p>
     * sql database will use select for udpate to lock row where pk = id.
     * </p>
     *
     * @param <E>            entity type
     * @param id             entity id
     * @param type           entity type
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
     * @param <E>            entity type
     * @param entity         the entity with id value
     * @param updateOperator the update operator
     * @return updated entity
     */
    <E> E updateFetch(E entity, UnaryOperator<E> updateOperator);

    /**
     * update all values for each entity in entity array. equal invoke method {@link #update(List, IgnoreStrategy)} with
     * params (entity, IgnoreStrategy.NONE)
     *
     * @param <E>      generic type
     * @param entities entity array to update
     * @return effect data row num
     */
    <E> int[] update(@SuppressWarnings("unchecked") E... entities);

    /**
     * update all values for each entity in entity list. equal invoke method {@link #update(List, IgnoreStrategy)} with
     * params (entity, IgnoreStrategy.NONE)
     *
     * @param <E>      generic type
     * @param entities entity list to update
     * @return effect data row num
     */
    <E> int[] update(List<E> entities);

    /**
     * update all values for each entity in entity list. equal invoke method {@link #update(List, IgnoreStrategy)} with
     * params (entity, IgnoreStrategy.NONE)
     *
     * @param <E>       generic type
     * @param entities  entity list to update
     * @param batchSize the batch size
     * @return effect data row num
     */
    <E> int[] update(List<E> entities, int batchSize);

    /**
     * update values with ignoreStrategy for each entity in entity list.
     *
     * @param <E>            generic type
     * @param entities       entity list to update
     * @param ignoreStrategy ignore value to update strategy
     * @return effect data row num
     */
    <E> int[] update(List<E> entities, IgnoreStrategy ignoreStrategy);

    /**
     * update values ignore null or empty(string, array, collectoin, map) value. equal invoke method
     * {@link #update(Object, IgnoreStrategy)} with params (entity, IgnoreStrategy.EMPTY)
     *
     * @param <E>    generic type
     * @param entity entity to merge
     * @return effect data row num
     */
    <E> int merge(E entity);

    /**
     * update values ignore null or empty(string, array, collectoin, map) value for each entity in entity array. equal
     * invoke method {@link #update(Object, IgnoreStrategy)} with params (entity, IgnoreStrategy.EMPTY)
     *
     * @param <E>      generic type
     * @param entities entity array to merge
     * @return effect data row num
     */
    <E> int[] merge(@SuppressWarnings("unchecked") E... entities);

    /**
     * update values ignore null or empty(string, array, collectoin, map) value for each entity in entity list. equal
     * invoke method {@link #update(List, IgnoreStrategy)} with params (entity, IgnoreStrategy.EMPTY)
     *
     * @param <E>      generic type
     * @param entities entity list to merge
     * @return effect data row num
     */
    <E> int[] merge(List<E> entities);

    /**
     * save or update entity.
     *
     * @param <E>    generic type
     * @param entity entity to save
     * @return effect data row num
     */
    <E> int saveOrUpdate(E entity);

    /**
     * save or update entity.
     *
     * @param <E>       generic type
     * @param entity    entity to save
     * @param updatable the updatable
     * @return effect data row num
     */
    <E> int saveOrUpdate(E entity, Predicate<E> updatable);

    /**
     * delete entity by id.
     *
     * @param <E>    generic type
     * @param entity entity to delete
     * @return effect data row num
     */
    <E> int delete(E entity);

    /**
     * delete entity by id.
     *
     * @param <E>        generic type
     * @param id         entity id
     * @param entityType entity type
     * @return effect data row num
     */
    <E> int delete(Serializable id, Class<E> entityType);

    /**
     * delete entity by id array.
     *
     * @param <E>        generic type
     * @param ids        the ids
     * @param entityType entity type
     * @return effect data row num
     */
    <E> int[] delete(Serializable[] ids, Class<E> entityType);

    /**
     * delete entity by id list.
     *
     * @param <E>        generic type
     * @param <ID>       the generic type
     * @param ids        the ids
     * @param entityType entity type
     * @return effect data row num
     */
    <E, ID extends Serializable> int[] delete(List<ID> ids, Class<E> entityType);

    /**
     * delete each entity in entity list.
     *
     * @param <E>      generic type
     * @param entities entity array to delete
     * @return effect data row num
     */
    default <E> int[] delete(@SuppressWarnings("unchecked") E... entities) {
        return delete(ArrayUtils.toList(entities));
    }

    /**
     * delete each entity in entity list.
     *
     * @param <E>      generic type
     * @param entities entity list to delete
     * @return effect data row num
     */
    <E> int[] delete(List<E> entities);

    /**
     * get entity by id.
     *
     * @param <E>  entity type
     * @param id   entity id
     * @param type entity type
     * @return entity
     */
    <E> E get(Serializable id, Class<E> type);

    /**
     * get entity by id and fetch property entity.
     *
     * @param <E>           entity type
     * @param <R>           the generic type
     * @param id            entity id
     * @param type          entity type
     * @param fetchProperty the fetch property
     * @return entity
     */
    <E, R> E get(Serializable id, Class<E> type, SerializableFunction<E, R> fetchProperty);

    /**
     * get entity list by id array.
     *
     * @param <E>  entity type
     * @param type entity type
     * @param ids  id array
     * @return entity
     */
    <E> List<E> get(Class<E> type, Serializable... ids);

    /**
     * get entity list by id list.
     *
     * @param <E>  entity type
     * @param type entity type
     * @param ids  id list
     * @return entity
     */
    <E> List<E> get(Class<E> type, List<Serializable> ids);

    /**
     * get entity by id.
     *
     * @param <E>    entity generic type
     * @param entity entity with id value
     * @return entity
     */
    <E> E get(E entity);

    /**
     * load entity by id, the same logic with get(entity).
     *
     * @param <E>    entity generic type
     * @param entity entity with id value
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
        return queryLogic.single();
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
        return queryLogic.list();
    }

    /**
     * create QueryEntity for repository.
     *
     * @param repository repository name
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

    //    /**
    //     * create QueryEntity for type.
    //     *
    //     * @param <E>  entity generic type
    //     * @param type query for type
    //     * @return TypeQueryEntity
    //     */
    //    <E> TypeQueryEntity queryType(Class<E> type);

    /**
     * create EntityQueryEntity for entityType. entity type must be a entity object, otherwise throws HammerException
     *
     * @param <E>        entity generic type
     * @param entityType query for entity type
     * @return EntityQueryEntity
     */
    <E> EntityQueryFetch<E> query(Class<E> entityType);

    /**
     * create update for repository.
     *
     * @param repository repository name
     * @return Update
     */
    RepositoryUpdate update(String repository);

    /**
     * create update for repository.
     *
     * @param repository repository name
     * @return Update
     */
    RepositoryUpdate update(Repository repository);

    /**
     * create update for entityType.
     *
     * @param <E>        entity generic type
     * @param entityType update for entityType
     * @return Update
     */
    <E> EntityUpdate<E> update(Class<E> entityType);

    /**
     * create delete for repository.
     *
     * @param repository repository name
     * @return Delete
     */
    RepositoryDelete delete(String repository);

    /**
     * create delete for repository.
     *
     * @param repository repository name
     * @return Delete
     */
    RepositoryDelete delete(Repository repository);

    /**
     * create delete for entityType.
     *
     * @param <E>        entity generic type
     * @param entityType update for entityType
     * @return Delete
     */
    <E> EntityDelete<E> delete(Class<E> entityType);
}
