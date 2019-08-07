
package cn.featherfly.juorm;

import java.util.List;

import cn.featherfly.juorm.Juorm.IgnorePolicy;
import cn.featherfly.juorm.dsl.execute.Delete;
import cn.featherfly.juorm.dsl.execute.Update;
import cn.featherfly.juorm.dsl.query.QueryEntity;

/**
 * <p>
 * GenericJuorm
 * </p>
 *
 * @param <E> generic entity type
 * @author zhongj
 */
public interface GenericJuorm<E> {
    /**
     * save entity
     *
     * @param entity entity to save
     * @return effect data row num
     */
    int save(E entity);

    /**
     * save entities
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
     * merge entity, update values ignore null or empty(string, list, map) value
     *
     * @param entity entity to merge
     * @return effect data row num
     */
    int merge(E entity);

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
     * delete entity
     *
     * @param entity entity to delete
     * @return effect data row num
     */
    int delete(E entity);

    /**
     * delete each entity in entity list
     *
     * @param entities entity list to delete
     * @return effect data row num
     */
    int delete(List<E> entities);

    /**
     * create QueryData for entityType
     *
     * @return QueryEntity
     */
    QueryEntity query();

    /**
     * create update for entityType
     *
     * @return Update
     */
    Update update();

    /**
     * create delete for entityType
     *
     * @return Delete
     */
    Delete delete();

}
