
package cn.featherfly.hammer;

import java.io.Serializable;
import java.util.List;
import java.util.function.UnaryOperator;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.operator.LogicOperator;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.dsl.entity.execute.EntityDelete;
import cn.featherfly.hammer.dsl.entity.execute.EntityUpdate;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryFetch;

/**
 * GenericHammer .
 *
 * @author zhongj
 * @param <E>  generic entity type
 * @param <ID> the generic type
 */
public interface GenericHammer<E, ID extends Serializable> {

    /**
     * save entity.
     *
     * @param entity entity to save
     * @return effect data row num
     */
    int save(E entity);

    /**
     * batch save entity array.
     *
     * @param entities entity array to save
     * @return effect data row num
     */
    int[] save(@SuppressWarnings("unchecked") E... entities);

    /**
     * batch save entity array.
     *
     * @param entities  entity array to save
     * @param batchSize the batch size
     * @return effect data row num
     */
    int[] save(E[] entities, int batchSize);

    /**
     * batch save entity list.
     *
     * @param entities entity list to save
     * @return effect data row num
     */
    int[] save(List<E> entities);

    /**
     * batch save entity list.
     *
     * @param entities  entity list to save
     * @param batchSize the batch size
     * @return effect data row num
     */
    int[] save(List<E> entities, int batchSize);

    /**
     * update entity, update all values. equal invoke method {@link #update(Object, IgnoreStrategy)} with params
     * (entity, IgnoreStrategy.NONE)
     *
     * @param entity entity to update
     * @return effect data row num
     */
    int update(E entity);

    /**
     * query entity type with id and lock, then update and fetch.
     *
     * @param id             entity id
     * @param updateOperator the update operator
     * @return effect data row num
     */
    E updateFetch(Serializable id, UnaryOperator<E> updateOperator);

    /**
     * query entity type with id and lock, then update and fetch.
     *
     * @param entity         the entity with id value
     * @param updateOperator the update operator
     * @return effect data row num
     */
    E updateFetch(E entity, UnaryOperator<E> updateOperator);

    /**
     * update all values for each entity in entity array. equal invoke method {@link #update(List, IgnoreStrategy)} with
     * params (entity, IgnoreStrategy.NONE)
     *
     * @param entities entity array to update
     * @return effect data row num
     */
    int[] update(@SuppressWarnings("unchecked") E... entities);

    /**
     * update all values for each entity in entity list. equal invoke method {@link #update(List, IgnoreStrategy)} with
     * params (entity, IgnoreStrategy.NONE)
     *
     * @param entities entity list to update
     * @return effect data row num
     */
    int[] update(List<E> entities);

    /**
     * update all values for each entity in entity list. equal invoke method {@link #update(List, IgnoreStrategy)} with
     * params (entity, IgnoreStrategy.NONE)
     *
     * @param entities  entity list to update
     * @param batchSize the batch size
     * @return effect data row num
     */
    int[] update(List<E> entities, int batchSize);

    /**
     * /** merge entity, update values ignore null or empty(string, array, collectoin, map) value. equal invoke method
     * {@link #update(Object, IgnoreStrategy)} with params (entity, IgnoreStrategy.EMPTY)
     *
     * @param entity         entity to update
     * @param ignoreStrategy ignore value to update strategy
     * @return effect data row num
     */
    int update(E entity, IgnoreStrategy ignoreStrategy);

    /**
     * update values with ignoreStrategy for each entity in entity list.
     *
     * @param entities       entity list to update
     * @param ignoreStrategy ignore value to update strategy
     * @return effect data row num
     */
    int[] update(List<E> entities, IgnoreStrategy ignoreStrategy);

    /**
     * merge entity, update values ignore null or empty(string, list, map) value.
     *
     * @param entity entity to merge
     * @return effect data row num
     */
    int merge(E entity);

    /**
     * update values ignore null or empty(string, array, collectoin, map) value for each entity in entity array. equal
     * invoke method {@link #update(Object, IgnoreStrategy)} with params (entity, IgnoreStrategy.EMPTY)
     *
     * @param entities entity array to merge
     * @return effect data row num
     */
    int[] merge(@SuppressWarnings("unchecked") E... entities);

    /**
     * update values ignore null or empty(string, array, collectoin, map) value for each entity in entity list. equal
     * invoke method {@link #update(Object, IgnoreStrategy)} with params (entity, IgnoreStrategy.EMPTY)
     *
     * @param entities entity list to merge
     * @return effect data row num
     */
    int[] merge(List<E> entities);

    /**
     * delete entity.
     *
     * @param entity entity to delete
     * @return effect data row num
     */
    int delete(E entity);

    /**
     * delete each entity in entity list.
     *
     * @param entities entity array to delete
     * @return effect data row num
     */
    int[] delete(@SuppressWarnings("unchecked") E... entities);

    /**
     * delete each entity in entity list.
     *
     * @param entities entity list to delete
     * @return effect data row num
     */
    int[] delete(List<E> entities);

    /**
     * delete entity.
     *
     * @param id entity id
     * @return effect data row num
     */
    int delete(ID id);

    /**
     * delete each entity in entity id array.
     *
     * @param ids entity id array
     * @return effect data row num
     */
    int[] deleteIds(@SuppressWarnings("unchecked") ID... ids);

    /**
     * delete each entity in entity id list.
     *
     * @param ids entity id list
     * @return effect data row num
     */
    int[] deleteIds(List<ID> ids);

    /**
     * get entity by id.
     *
     * @param id entity id
     * @return entity
     */
    E get(ID id);

    /**
     * get entity by id and fetch property entity.
     *
     * @param <R>           the generic type
     * @param id            entity id
     * @param fetchProperty the fetch property
     * @return entity
     */
    <R> E get(Serializable id, SerializableFunction<E, R> fetchProperty);

    /**
     * get entity list by id array.
     *
     * @param ids the id array
     * @return entity
     */
    List<E> get(@SuppressWarnings("unchecked") ID... ids);

    /**
     * get entity list by id list.
     *
     * @param ids the id list
     * @return LogicExpressionist
     */
    List<E> get(List<ID> ids);

    /**
     * get entity by id.
     *
     * @param entity entity with id value
     * @return entity
     */
    E load(E entity);

    /**
     * Query single by propertyValues.
     *
     * @param propertyValues the property values
     * @return the e
     */
    E querySingle(SerializableSupplier<?>... propertyValues);

    /**
     * Query list by propertyValues.
     *
     * @param propertyValues the property values
     * @return LogicExpressionist
     */
    List<E> queryList(SerializableSupplier<?>... propertyValues);

    /**
     * Query list by propertyValues.
     *
     * @param operator       the operator
     * @param propertyValues the property values
     * @return LogicExpressionist
     */
    List<E> queryList(LogicOperator operator, SerializableSupplier<?>... propertyValues);

    /**
     * create QueryData for entityType.
     *
     * @return QueryEntity
     */
    EntityQueryFetch<E> query();

    /**
     * create update for entityType.
     *
     * @return Update
     */
    EntityUpdate<E> update();

    /**
     * create delete for entityType.
     *
     * @return Delete
     */
    EntityDelete<E> delete();

}
