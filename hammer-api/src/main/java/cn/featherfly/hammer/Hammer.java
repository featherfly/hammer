
package cn.featherfly.hammer;

import java.io.Serializable;
import java.util.List;

import cn.featherfly.hammer.dsl.execute.Delete;
import cn.featherfly.hammer.dsl.execute.Update;
import cn.featherfly.hammer.dsl.query.QueryEntity;
import cn.featherfly.hammer.dsl.query.TypeQueryEntity;
import cn.featherfly.hammer.tpl.TplExecutor;

/**
 * <p>
 * Hammer
 * </p>
 *
 * @author zhongj
 */
public interface Hammer extends TplExecutor {

    enum IgnorePolicy {
        /**
         * not ignore
         */
        NONE,
        /**
         * ignore null
         */
        NULL,
        /**
         * ignore null and empty (String Array Collection Map size = 0)
         */
        EMPTY
    }

    /**
     * save entity
     *
     * @param <E>    generic type
     * @param entity entity to save
     * @return effect data row num
     */
    <E> int save(E entity);

    /**
     * batch save entity list
     *
     * @param <E>      generic type
     * @param entities entity array to save
     * @return effect data row num
     */
    <E> int save(@SuppressWarnings("unchecked") E... entities);

    /**
     * batch save entity list
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
     * update entity, update values with ignorePolicy
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
     * delete entity by id
     *
     * @param <E>    generic type
     * @param entity entity to delete
     * @return effect data row num
     */
    <E> int delete(E entity);

    /**
     * delete entity by id
     *
     * @param <E>        generic type
     * @param id         entity id
     * @param entityType entity type
     * @return effect data row num
     */
    <E> int delete(Serializable id, Class<E> entityType);

    /**
     * delete each entity in entity list
     *
     * @param <E>      generic type
     * @param entities entity array to delete
     * @return effect data row num
     */
    <E> int delete(@SuppressWarnings("unchecked") E... entities);

    /**
     * delete each entity in entity list
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
     * get entity by id.
     *
     * @param <E>    entity generic type
     * @param entity entity with id value
     * @return entity
     */
    <E> E get(E entity);

    /**
     * create QueryEntity for repository
     *
     * @param repository repository name
     * @return QueryEntity
     */
    QueryEntity query(String repository);

    /**
     * create QueryEntity for entityType
     *
     * @param <E>        entity generic type
     * @param entityType query for entityType
     * @return QueryEntity
     */
    <E> TypeQueryEntity query(Class<E> entityType);

    /**
     * create update for repository
     *
     * @param repository repository name
     * @return Update
     */
    Update update(String repository);

    /**
     * create update for entityType
     *
     * @param <E>        entity generic type
     * @param entityType update for entityType
     * @return Update
     */
    <E> Update update(Class<E> entityType);

    /**
     * create delete for repository
     *
     * @param repository repository name
     * @return Delete
     */
    Delete delete(String repository);

    /**
     * create delete for entityType
     *
     * @param <E>        entity generic type
     * @param entityType update for entityType
     * @return Delete
     */
    <E> Delete delete(Class<E> entityType);
}
