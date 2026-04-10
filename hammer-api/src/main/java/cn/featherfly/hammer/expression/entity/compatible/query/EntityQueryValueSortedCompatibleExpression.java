/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntityQuerySortedCompatibleExpression.java
 * @Package cn.featherfly.hammer.expression.entity.compatible.query
 * @author: zhongj
 * @date: 2025-12-11 01:28:11
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.compatible.query;

import cn.featherfly.data.query.QueryLimitExecutor;
import cn.featherfly.data.query.QueryLimitSetter;
import cn.featherfly.hammer.expression.entity.query.EntityQueryValueLimitExecutor;
import cn.featherfly.hammer.expression.entity.query.sort.EntitySortedCompatibleExpression;
import cn.featherfly.hammer.expression.query.sort.SortedExpression;

/**
 * The Interface EntityQueryValueSortedCompatibleExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <V> the value type
 */
public interface EntityQueryValueSortedCompatibleExpression<E, V>
    extends EntitySortedCompatibleExpression<E, EntityQueryValueSortedCompatibleExpression<E, V>>,
    SortedExpression<EntityQueryValueSortedCompatibleExpression<E, V>>,
    QueryLimitSetter<EntityQueryValueLimitExecutor<E, V>>, QueryLimitExecutor<E> {

}
