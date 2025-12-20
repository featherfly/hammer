/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntityNotEndWithCompatibleExpression.java
 * @Package cn.featherfly.hammer.expression.entity.compatible.condition.newv
 * @author: zhongj
 * @date: 2025-12-11 01:26:11
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.compatible.condition.newv;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.newv.NotEndWithExpression;
import cn.featherfly.hammer.expression.entity.condition.newv.EntityNotEndWithExpression;

/**
 * entity not end with compatible expression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityNotEndWithCompatibleExpression<E, C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends EntityNotEndWithExpression<E, C, L>, NotEndWithExpression<C, L> {

}