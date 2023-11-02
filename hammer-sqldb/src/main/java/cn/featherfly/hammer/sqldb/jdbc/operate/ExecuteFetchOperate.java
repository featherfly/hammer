package cn.featherfly.hammer.sqldb.jdbc.operate;

import java.io.Serializable;
import java.util.function.UnaryOperator;

/**
 * execute fetch operate.
 *
 * @author zhongj
 * @param <T> entity type
 * @since 0.7.0
 */
public interface ExecuteFetchOperate<T> extends ComplexExecuteOperate<T> {

    /**
     * query id of type and lock, then update and fetch. enable lock.
     * <p>
     * sql database will use select for udpate to lock row where pk = id.
     * </p>
     *
     * @param id                entity id for query entity
     * @param setEntityOperator the set entity operator
     * @return updated entity
     */
    default T execute(Serializable id, UnaryOperator<T> setEntityOperator) {
        return execute(id, setEntityOperator, true);
    }

    /**
     * query id of type and lock, then update and fetch.
     * <p>
     * sql database will use select for udpate to lock row where pk = id.
     * </p>
     *
     * @param id             entity id for query entity
     * @param updateOperator the update operator
     * @param enableLock     the enable lock
     * @return updated entity
     */
    T execute(Serializable id, UnaryOperator<T> updateOperator, boolean enableLock);

    /**
     * query id of entity and lock, then update and fetch. enable lock.
     * <p>
     * sql database will use select for udpate to lock row where pk = id.
     * </p>
     *
     * @param entity            the entity with id value for query entity
     * @param setEntityOperator the set entity operator
     * @return updated entity
     */
    default T execute(T entity, UnaryOperator<T> setEntityOperator) {
        return execute(entity, setEntityOperator, true);
    }

    /**
     * query id of entity and lock, then update and fetch.
     * <p>
     * sql database will use select for udpate to lock row where pk = id.
     * </p>
     *
     * @param entity            the entity with id value for query entity
     * @param setEntityOperator the set entity operator
     * @param enableLock        the enable lock
     * @return updated entity
     */
    T execute(T entity, UnaryOperator<T> setEntityOperator, boolean enableLock);
}
