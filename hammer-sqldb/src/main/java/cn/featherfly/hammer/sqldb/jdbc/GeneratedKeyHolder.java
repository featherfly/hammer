
/*
 * All rights Reserved, Designed By zhongj
 * @Title: GeneratedKeyHolder.java
 * @Package cn.featherfly.hammer.sqldb.jdbc
 * @Description: GeneratedKeyHolder
 * @author: zhongj
 * @date: 2021-12-03 21:23:03
 * @Copyright: 2021 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc;

import java.util.List;

import cn.featherfly.common.lang.reflect.Type;

/**
 * GeneratedKeyHolder.
 *
 * @author zhongj
 * @param <T> the generic type
 */
public interface GeneratedKeyHolder<T> {

    /**
     * Accept key.
     *
     * @param key the key
     * @param row the row
     */
    void acceptKey(T key, int row);

    /**
     * Accept key.
     *
     * @param keys the keys
     */
    void acceptKey(List<T> keys);

    /**
     * Gets the type.
     *
     * @return the type
     */
    Type<T> getType();
}
