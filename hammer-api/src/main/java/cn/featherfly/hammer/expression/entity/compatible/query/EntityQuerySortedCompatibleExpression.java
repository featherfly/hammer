/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntityQuerySortedCompatibleExpression.java
 * @Package cn.featherfly.hammer.expression.entity.compatible.query
 * @author: zhongj
 * @date: 2025-12-11 01:28:11
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.compatible.query;

import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionLimit;
import cn.featherfly.hammer.expression.entity.query.EntityQueryLimitExecutor;
import cn.featherfly.hammer.expression.entity.query.sort.EntitySortedCompatibleExpression;
import cn.featherfly.hammer.expression.query.sort.SortedExpression;

/**
 * The Interface EntityQuerySortedCompatibleExpression.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface EntityQuerySortedCompatibleExpression<E>
    extends EntitySortedCompatibleExpression<E, EntityQuerySortedCompatibleExpression<E>>,
    SortedExpression<EntityQuerySortedCompatibleExpression<E>>, EntityQueryConditionLimit<EntityQueryLimitExecutor<E>>,
    EntityQueryLimitExecutor<E> {

}
