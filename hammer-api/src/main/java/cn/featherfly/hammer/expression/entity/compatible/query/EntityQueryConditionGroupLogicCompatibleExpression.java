/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntityQueryConditionGroupLogicCompatibleExpression.java
 * @Package cn.featherfly.hammer.expression.entity.compatible.query
 * @author: zhongj
 * @date: 2025-12-11 01:27:11
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.compatible.query;

import cn.featherfly.hammer.expression.entity.compatible.EntityConditionGroupLogicCompatibleExpression;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionLimit;
import cn.featherfly.hammer.expression.entity.query.EntityQueryLimitExecutor;
import cn.featherfly.hammer.expression.query.QueryCountExecutor;
import cn.featherfly.hammer.expression.query.Queryable;

/**
 * The Interface EntityQueryConditionGroupLogicCompatibleExpression.
 *
 * @author zhongj
 * @param <E1> first filterable entity type
 * @param <C> condition expression
 * @param <L> logic expression
 * @param <S> sort expression
 */
public interface EntityQueryConditionGroupLogicCompatibleExpression<E1,
    C extends EntityQueryConditionGroupCompatibleExpression<E1, C, L, S>,
    L extends EntityQueryConditionGroupLogicCompatibleExpression<E1, C, L, S>,
    S extends EntityQuerySortCompatibleExpression<E1>>
    extends EntityConditionGroupLogicCompatibleExpression<E1, C, L>, Queryable<S>,
    EntityQueryConditionLimit<EntityQueryLimitExecutor<E1>>, EntityQueryLimitExecutor<E1>, QueryCountExecutor {

}
