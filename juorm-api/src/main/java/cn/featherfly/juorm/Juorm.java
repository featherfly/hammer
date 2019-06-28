
package cn.featherfly.juorm;

import cn.featherfly.juorm.dsl.execute.Delete;
import cn.featherfly.juorm.dsl.execute.ExecutableExecutableUpdate;
import cn.featherfly.juorm.dsl.execute.Update;
import cn.featherfly.juorm.dsl.query.QueryEntity;

/**
 * <p>
 * Juorm
 * </p>
 *
 * @author zhongj
 */
public interface Juorm {
    /**
     * save entity
     *
     * @param <E>
     *            generic type
     * @param entity
     *            entity to save
     * @return effect data row num
     */
    <E> int save(E entity);

    /**
     * update entity, update all values
     *
     * @param <E>
     *            generic type
     * @param entity
     *            entity to update
     * @return effect data row num
     */
    <E> int update(E entity);

    /**
     * merge entity, update values ignore null or empty(string, list, map) value
     *
     * @param <E>
     *            generic type
     * @param entity
     *            entity to merge
     * @return effect data row num
     */
    <E> int merge(E entity);

    /**
     * delete entity
     *
     * @param <E>
     *            generic type
     * @param entity
     *            entity to delete
     * @return effect data row num
     */
    <E> int delete(E entity);

    /**
     * create QueryData for entityType
     *
     * @param <E>
     *            generic type
     * @param entityType
     *            query for entityType
     * @return
     */
    <E> QueryEntity query(Class<E> entityType);

    /**
     * create update for entityType
     *
     * @param <E>
     *            generic type
     * @param entityType
     *            update for entityType
     * @return
     */
    <E, U extends ExecutableExecutableUpdate<U>> Update<U> update(
            Class<E> entityType);

    /**
     * create delete for entityType
     *
     * @param <E>
     *            generic type
     * @param entityType
     *            update for entityType
     * @return
     */
    <E> Delete delete(Class<E> entityType);

}
