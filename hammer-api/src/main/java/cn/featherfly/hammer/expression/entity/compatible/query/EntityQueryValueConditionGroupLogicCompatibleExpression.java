/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntityQueryConditionGroupLogicCompatibleExpression.java
 * @Package cn.featherfly.hammer.expression.entity.compatible.query
 * @author: zhongj
 * @date: 2025-12-11 01:27:11
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.compatible.query;

import cn.featherfly.data.query.QueryCountExecutor;
import cn.featherfly.data.query.QueryLimitSetter;
import cn.featherfly.hammer.expression.condition.ValueLogicExpression;
import cn.featherfly.hammer.expression.entity.compatible.EntityConditionGroupLogicCompatibleExpression;
import cn.featherfly.hammer.expression.entity.query.EntityQueryValueLimitExecutor;
import cn.featherfly.hammer.expression.query.Queryable;

/**
 * The Interface EntityQueryConditionGroupLogicCompatibleExpression.
 *
 * @author zhongj
 * @param <E1> first filterable entity type
 * @param <V> the value type
 * @param <C> condition expression
 * @param <L> logic expression
 * @param <S> sort expression
 */
public interface EntityQueryValueConditionGroupLogicCompatibleExpression<E1, V,
    C extends EntityQueryValueConditionGroupCompatibleExpression<E1, V, C, L, S>,
    L extends EntityQueryValueConditionGroupLogicCompatibleExpression<E1, V, C, L, S>,
    S extends EntityQueryValueSortCompatibleExpression<E1, V>>
    extends EntityConditionGroupLogicCompatibleExpression<E1, C, L>, ValueLogicExpression<C, L>, Queryable<S>,
    QueryLimitSetter<EntityQueryValueLimitExecutor<E1, V>>, EntityQueryValueLimitExecutor<E1, V>, QueryCountExecutor {

}
