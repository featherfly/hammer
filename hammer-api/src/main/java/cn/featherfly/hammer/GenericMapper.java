
package cn.featherfly.hammer;

import java.io.Serializable;
import java.util.List;

import cn.featherfly.common.repository.IgnorePolicy;
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
public interface GenericMapper<E, ID extends Serializable> {

    /**
     * save entity.
     *
     * @param entity entity to save
     * @return saved entity
     */
    E save(E entity);

    /**
     * save entities.
     *
     * @param entities entity array to save
     * @return saved entity
     */
    int save(@SuppressWarnings("unchecked") E... entities);

    /**
     * save entities.
     *
     * @param entities entity list to save
     * @return saved entity
     */
    int save(List<E> entities);

    /**
     * update entity, update all values. equal invoke method
     * {@link #update(Object, IgnorePolicy)} with params (entity,
     * IgnorePolicy.NONE)
     *
     * @param entity entity to update
     * @return updated entity
     */
    E update(E entity);

    /**
     * update all values for each entity in entity array. equal invoke method
     * {@link #update(List, IgnorePolicy)} with params (entity,
     * IgnorePolicy.NONE)
     *
     * @param entities entity array to update
     * @return updated entity
     */
    int update(@SuppressWarnings("unchecked") E... entities);

    /**
     * update all values for each entity in entity list. equal invoke method
     * {@link #update(List, IgnorePolicy)} with params (entity,
     * IgnorePolicy.NONE)
     *
     * @param entities entity list to update
     * @return updated entity
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
     * @return updated entity
     */
    E update(E entity, IgnorePolicy ignorePolicy);

    /**
     * update values with ignorePolicy for each entity in entity list.
     *
     * @param entities     entity list to update
     * @param ignorePolicy ignore value to update policy
     * @return updated entity
     */
    int update(List<E> entities, IgnorePolicy ignorePolicy);

    /**
     * merge entity, update values ignore null or empty(string, list, map)
     * value.
     *
     * @param entity entity to merge
     * @return updated entity
     */
    E merge(E entity);

    /**
     * update values ignore null or empty(string, array, collectoin, map) value
     * for each entity in entity array. equal invoke method
     * {@link #update(Object, IgnorePolicy)} with params (entity,
     * IgnorePolicy.EMPTY)
     *
     * @param entities entity array to merge
     * @return updated entity
     */
    int merge(@SuppressWarnings("unchecked") E... entities);

    /**
     * update values ignore null or empty(string, array, collectoin, map) value
     * for each entity in entity list. equal invoke method
     * {@link #update(Object, IgnorePolicy)} with params (entity,
     * IgnorePolicy.EMPTY)
     *
     * @param entities entity list to merge
     * @return updated entity
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
