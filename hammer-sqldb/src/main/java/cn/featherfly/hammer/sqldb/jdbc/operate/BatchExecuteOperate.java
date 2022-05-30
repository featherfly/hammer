package cn.featherfly.hammer.sqldb.jdbc.operate;

import java.util.List;

import cn.featherfly.common.lang.ArrayUtils;

/**
 * batch execute operate.
 *
 * @author zhongj
 * @version 0.6.1
 * @since 0.6.1
 * @param <T> 对象类型
 */
public interface BatchExecuteOperate<T> {

    /**
     * Execute batch.
     *
     * @param entities the entities
     * @return the execute success row num
     */
    default int executeBatch(@SuppressWarnings("unchecked") final T... entities) {
        return executeBatch(ArrayUtils.toList(entities));
    }

    /**
     * Execute batch.
     *
     * @param entities the entity
     * @return the execute success row num
     */
    default int executeBatch(final List<T> entities) {
        return executeBatch(entities, entities.size());
    }

    /**
     * Execute batch.
     *
     * @param entities  the entity
     * @param batchSize the batch size
     * @return the execute success row num
     */
    int executeBatch(final List<T> entities, int batchSize);
}
