package cn.featherfly.hammer.sqldb.jdbc.operate;

import java.io.Serializable;

/**
 * query operate.
 *
 * @author zhongj
 * @version 0.6.1
 * @since 0.6.1
 * @param <T> 对象类型
 */
public interface QueryOperate<T> {

    /**
     * query by value
     *
     * @param value value
     * @return the entity
     */
    T execute(final Serializable value);
}
