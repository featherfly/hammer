/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntityQueryConditionGroupCompatibleExpression.java
 * @Package cn.featherfly.hammer.expression.entity.compatible.query
 * @author: zhongj
 * @date: 2025-12-11 01:27:11
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.compatible.query;

import cn.featherfly.hammer.config.dsl.QueryConditionConfig;
import cn.featherfly.hammer.expression.condition.ConditionConfigureExpression;
import cn.featherfly.hammer.expression.entity.compatible.EntityConditionGroupCompatibleExpression;

/**
 * The Interface EntityQueryConditionGroupCompatibleExpression.
 *
 * @author zhongj
 * @param <E1> first filterable entity type
 * @param <V> the value type
 * @param <C> condition expression
 * @param <L> logic expression
 * @param <S> sort expression
 */
public interface EntityQueryValueConditionGroupCompatibleExpression<E1, V,
    C extends EntityQueryValueConditionGroupCompatibleExpression<E1, V, C, L, S>,
    L extends EntityQueryValueConditionGroupLogicCompatibleExpression<E1, V, C, L, S>,
    S extends EntityQueryValueSortCompatibleExpression<E1, V>>
    extends EntityConditionGroupCompatibleExpression<E1, C, L>, ConditionConfigureExpression<C, QueryConditionConfig> {
}
