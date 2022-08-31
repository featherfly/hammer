
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

import cn.featherfly.common.lang.reflect.Type;

/**
 * GeneratedKeyHolder.
 *
 * @author zhongj
 */
public interface GeneratedKeyHolder<T> {

    void acceptKey(T key, int row);

    Type<T> getType();
}
