/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntityQuerySortCompatibleExpression.java
 * @Package cn.featherfly.hammer.expression.entity.compatible.query
 * @author: zhongj
 * @date: 2025-12-11 01:28:11
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.compatible.query;

import cn.featherfly.hammer.expression.entity.query.sort.EntitySortExpression;
import cn.featherfly.hammer.expression.query.sort.SortExpression;

/**
 * The Interface EntityQuerySortCompatibleExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <V> the value type
 */
public interface EntityQueryValueSortCompatibleExpression<E, V>
    extends EntitySortExpression<E, EntityQuerySortedCompatibleExpression<E>>,
    SortExpression<EntityQueryValueSortedCompatibleExpression<E, V>> {

}
