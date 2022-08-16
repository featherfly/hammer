
package cn.featherfly.hammer;

import java.io.Serializable;
import java.util.List;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableSupplier;
import cn.featherfly.common.repository.IgnorePolicy;
import cn.featherfly.common.repository.operate.LogicOperator;
import cn.featherfly.hammer.dsl.execute.Delete;
import cn.featherfly.hammer.dsl.execute.Update;
import cn.featherfly.hammer.dsl.query.TypeQueryEntity;

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
     * save entities.
     *
     * @param entities entity array to save
     * @return effect data row num
     */
    int save(@SuppressWarnings("unchecked") E... entities);

    /**
     * save entities.
     *
     * @param entities entity list to save
     * @return effect data row num
     */
    int save(List<E> entities);

    /**
     * update entity, update all values. equal invoke method
     * {@link #update(Object, IgnorePolicy)} with params (entity,
     * IgnorePolicy.NONE)
     *
     * @param entity entity to update
     * @return effect data row num
     */
    int update(E entity);

    /**
     * update all values for each entity in entity array. equal invoke method
     * {@link #update(List, IgnorePolicy)} with params (entity,
     * IgnorePolicy.NONE)
     *
     * @param entities entity array to update
     * @return effect data row num
     */
    int update(@SuppressWarnings("unchecked") E... entities);

    /**
     * update all values for each entity in entity list. equal invoke method
     * {@link #update(List, IgnorePolicy)} with params (entity,
     * IgnorePolicy.NONE)
     *
     * @param entities entity list to update
     * @return effect data row num
     */
    int update(List<E> entities);

    /**
     * /** merge entity, update values ignore null or empty(string, array,
     * collectoin, map) value. equal invoke method
     * {@link #update(Object, IgnorePolicy)} with params (entity,
     * IgnorePolicy.EMPTY)
     *
     * @param entity       entity to update
     * @param ignorePolicy ignore value to update policy
     * @return effect data row num
     */
    int update(E entity, IgnorePolicy ignorePolicy);

    /**
     * update values with ignorePolicy for each entity in entity list.
     *
     * @param entities     entity list to update
     * @param ignorePolicy ignore value to update policy
     * @return effect data row num
     */
    int update(List<E> entities, IgnorePolicy ignorePolicy);

    /**
     * merge entity, update values ignore null or empty(string, list, map)
     * value.
     *
     * @param entity entity to merge
     * @return effect data row num
     */
    int merge(E entity);

    /**
     * update values ignore null or empty(string, array, collectoin, map) value
     * for each entity in entity array. equal invoke method
     * {@link #update(Object, IgnorePolicy)} with params (entity,
     * IgnorePolicy.EMPTY)
     *
     * @param entities entity array to merge
     * @return effect data row num
     */
    int merge(@SuppressWarnings("unchecked") E... entities);

    /**
     * update values ignore null or empty(string, array, collectoin, map) value
     * for each entity in entity list. equal invoke method
     * {@link #update(Object, IgnorePolicy)} with params (entity,
     * IgnorePolicy.EMPTY)
     *
     * @param entities entity list to merge
     * @return effect data row num
     */
    int merge(List<E> entities);

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
    int delete(@SuppressWarnings("unchecked") E... entities);

    /**
     * delete each entity in entity list.
     *
     * @param entities entity list to delete
     * @return effect data row num
     */
    int delete(List<E> entities);

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
    int deleteIds(@SuppressWarnings("unchecked") ID... ids);

    /**
     * delete each entity in entity id list.
     *
     * @param ids entity id list
     * @return effect data row num
     */
    int deleteIds(List<ID> ids);

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
     * @return the list
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
     * @return the list
     */
    List<E> queryList(SerializableSupplier<?>... propertyValues);

    /**
     * Query list by propertyValues.
     *
     * @param operator       the operator
     * @param propertyValues the property values
     * @return the list
     */
    List<E> queryList(LogicOperator operator, SerializableSupplier<?>... propertyValues);

    /**
     * create QueryData for entityType.
     *
     * @return QueryEntity
     */
    TypeQueryEntity query();

    /**
     * create update for entityType.
     *
     * @return Update
     */
    Update update();

    /**
     * create delete for entityType.
     *
     * @return Delete
     */
    Delete delete();

}
