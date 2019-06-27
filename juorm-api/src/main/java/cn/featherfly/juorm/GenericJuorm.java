
package cn.featherfly.juorm;

import cn.featherfly.juorm.dsl.execute.Delete;
import cn.featherfly.juorm.dsl.execute.Update;
import cn.featherfly.juorm.dsl.query.QueryData;

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
     * @param <E>    generic type
     * @param entity entity to save
     * @return effect data row num
     */
    int save(E entity);

    /**
     * update entity, update all values
     *
     * @param <E>    generic type
     * @param entity entity to update
     * @return effect data row num
     */
    int update(E entity);

    /**
     * merge entity, update values ignore null or empty(string, list, map) value
     *
     * @param <E>    generic type
     * @param entity entity to merge
     * @return effect data row num
     */
    int merge(E entity);

    /**
     * delete entity
     *
     * @param <E>    generic type
     * @param entity entity to delete
     * @return effect data row num
     */
    int delete(E entity);

    /**
     * create QueryData for entityType
     *
     * @param <E>        generic type
     * @param entityType query for entityType
     * @return
     */
    QueryData query();

    /**
     * create update for entityType
     *
     * @param entityType update for entityType
     * @return
     */
    Update update();

    /**
     * create delete for entityType
     *
     * @param <E>        generic type
     * @param entityType update for entityType
     * @return
     */
    Delete delete();

}
