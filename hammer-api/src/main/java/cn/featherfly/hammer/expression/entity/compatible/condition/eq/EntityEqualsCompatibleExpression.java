/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntityEqualsCompatibleExpression.java
 * @Package cn.featherfly.hammer.expression.entity.compatible.condition.eq
 * @author: zhongj
 * @date: 2025-12-11 01:23:11
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.compatible.condition.eq;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.eq.EqualsExpression;
import cn.featherfly.hammer.expression.entity.condition.eq.EntityEqualsExpressionBase;

/**
 * The Interface EntityEqualsCompatibleExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityEqualsCompatibleExpression<E, C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends EntityEqualsExpressionBase<E, C, L>, EqualsExpression<C, L> {

}