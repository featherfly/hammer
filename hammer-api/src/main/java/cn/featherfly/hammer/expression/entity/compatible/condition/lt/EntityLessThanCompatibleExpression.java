/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntityLessThanCompatibleExpression.java
 * @Package cn.featherfly.hammer.expression.entity.compatible.condition.lt
 * @author: zhongj
 * @date: 2025-12-11 01:25:11
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.compatible.condition.lt;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.lt.LessThanExpression;
import cn.featherfly.hammer.expression.entity.condition.lt.EntityLessThanExpression;

/**
 * The Interface EntityLessThanCompatibleExpression.
 *
 * @author zhongj
 * @param <T> the comparable type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityLessThanCompatibleExpression<T, C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends EntityLessThanExpression<T, C, L>, LessThanExpression<C, L> {
}