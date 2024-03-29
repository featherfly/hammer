
package cn.featherfly.hammer;

import java.io.Serializable;
import java.util.List;

import cn.featherfly.common.lang.AssertIllegalArgument;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.lang.function.SerializableSupplier;
import cn.featherfly.common.repository.IgnorePolicy;
import cn.featherfly.common.repository.operate.LogicOperator;
import cn.featherfly.hammer.dsl.execute.Delete;
import cn.featherfly.hammer.dsl.execute.Update;
import cn.featherfly.hammer.dsl.query.QueryEntity;
import cn.featherfly.hammer.dsl.query.TypeQueryConditionGroupExpression;
import cn.featherfly.hammer.dsl.query.TypeQueryConditionGroupLogicExpression;
import cn.featherfly.hammer.dsl.query.TypeQueryEntity;
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
     * batch save entity list.
     *
     * @param <E>      generic type
     * @param entities entity array to save
     * @return effect data row num
     */
    <E> int save(@SuppressWarnings("unchecked") E... entities);

    /**
     * batch save entity list.
     *
     * @param <E>      generic type
     * @param entities entity list to save
     * @return effect data row num
     */
    <E> int save(List<E> entities);

    /**
     * update entity, update all values. equal invoke method
     * {@link #update(Object, IgnorePolicy)} with params (entity,
     * IgnorePolicy.NONE)
     *
     * @param <E>    generic type
     * @param entity entity to update
     * @return effect data row num
     */
    <E> int update(E entity);

    /**
     * update all values for each entity in entity array. equal invoke method
     * {@link #update(List, IgnorePolicy)} with params (entity,
     * IgnorePolicy.NONE)
     *
     * @param <E>      generic type
     * @param entities entity array to update
     * @return effect data row num
     */
    <E> int update(@SuppressWarnings("unchecked") E... entities);

    /**
     * update all values for each entity in entity list. equal invoke method
     * {@link #update(List, IgnorePolicy)} with params (entity,
     * IgnorePolicy.NONE)
     *
     * @param <E>      generic type
     * @param entities entity list to update
     * @return effect data row num
     */
    <E> int update(List<E> entities);

    /**
     * update entity, update values with ignorePolicy.
     *
     * @param <E>          generic type
     * @param entity       entity to update
     * @param ignorePolicy ignore value to update policy
     * @return effect data row num
     */
    <E> int update(E entity, IgnorePolicy ignorePolicy);

    /**
     * update values with ignorePolicy for each entity in entity list.
     *
     * @param <E>          generic type
     * @param entities     entity list to update
     * @param ignorePolicy ignore value to update policy
     * @return effect data row num
     */
    <E> int update(List<E> entities, IgnorePolicy ignorePolicy);

    /**
     * update values ignore null or empty(string, array, collectoin, map) value.
     * equal invoke method {@link #update(Object, IgnorePolicy)} with params
     * (entity, IgnorePolicy.EMPTY)
     *
     * @param <E>    generic type
     * @param entity entity to merge
     * @return effect data row num
     */
    <E> int merge(E entity);

    /**
     * update values ignore null or empty(string, array, collectoin, map) value
     * for each entity in entity array. equal invoke method
     * {@link #update(Object, IgnorePolicy)} with params (entity,
     * IgnorePolicy.EMPTY)
     *
     * @param <E>      generic type
     * @param entities entity array to merge
     * @return effect data row num
     */
    <E> int merge(@SuppressWarnings("unchecked") E... entities);

    /**
     * update values ignore null or empty(string, array, collectoin, map) value
     * for each entity in entity list. equal invoke method
     * {@link #update(Object, IgnorePolicy)} with params (entity,
     * IgnorePolicy.EMPTY)
     *
     * @param <E>      generic type
     * @param entities entity list to merge
     * @return effect data row num
     */
    <E> int merge(List<E> entities);

    /**
     * save or update entity.
     *
     * @param <E>    generic type
     * @param entity entity to save
     * @return effect data row num
     */
    <E> int saveOrUpdate(E entity);

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
    <E> int delete(Serializable[] ids, Class<E> entityType);

    /**
     * delete entity by id list.
     *
     * @param <E>        generic type
     * @param <ID>       the generic type
     * @param ids        the ids
     * @param entityType entity type
     * @return effect data row num
     */
    <E, ID extends Serializable> int delete(List<ID> ids, Class<E> entityType);

    /**
     * delete each entity in entity list.
     *
     * @param <E>      generic type
     * @param entities entity array to delete
     * @return effect data row num
     */
    <E> int delete(@SuppressWarnings("unchecked") E... entities);

    /**
     * delete each entity in entity list.
     *
     * @param <E>      generic type
     * @param entities entity list to delete
     * @return effect data row num
     */
    <E> int delete(List<E> entities);

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

        TypeQueryConditionGroupExpression queryCondition = query(type).where();
        TypeQueryConditionGroupLogicExpression queryLogic = null;
        for (int i = 0; i < propertyValues.length; i++) {
            SerializableSupplier<?> propertyValue = propertyValues[i];
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
     * @return the list
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
     * @return the list
     */
    default <E> List<E> queryList(Class<E> type, LogicOperator operator, SerializableSupplier<?>... propertyValues) {
        if (Lang.isEmpty(propertyValues)) {
            return query(type).list();
        }
        AssertIllegalArgument.isNotNull(operator, "operator");

        TypeQueryConditionGroupExpression queryCondition = query(type).where();
        TypeQueryConditionGroupLogicExpression queryLogic = null;
        for (int i = 0; i < propertyValues.length; i++) {
            SerializableSupplier<?> propertyValue = propertyValues[i];
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
    QueryEntity query(String repository);

    /**
     * create QueryEntity for entityType.
     *
     * @param <E>        entity generic type
     * @param entityType query for entityType
     * @return QueryEntity
     */
    <E> TypeQueryEntity query(Class<E> entityType);

    /**
     * create update for repository.
     *
     * @param repository repository name
     * @return Update
     */
    Update update(String repository);

    /**
     * create update for entityType.
     *
     * @param <E>        entity generic type
     * @param entityType update for entityType
     * @return Update
     */
    <E> Update update(Class<E> entityType);

    /**
     * create delete for repository.
     *
     * @param repository repository name
     * @return Delete
     */
    Delete delete(String repository);

    /**
     * create delete for entityType.
     *
     * @param <E>        entity generic type
     * @param entityType update for entityType
     * @return Delete
     */
    <E> Delete delete(Class<E> entityType);
}
