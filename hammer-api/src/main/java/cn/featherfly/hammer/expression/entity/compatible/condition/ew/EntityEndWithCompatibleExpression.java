/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntityEndWithCompatibleExpression.java
 * @Package cn.featherfly.hammer.expression.entity.compatible.condition.ew
 * @author: zhongj
 * @date: 2025-12-11 01:23:11
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.compatible.condition.ew;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.ew.EndWithExpression;
import cn.featherfly.hammer.expression.entity.condition.ew.EntityEndWithExpression;

/**
 * entity end with compatible expression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityEndWithCompatibleExpression<E, C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends EntityEndWithExpression<E, C, L>, EndWithExpression<C, L> {

}