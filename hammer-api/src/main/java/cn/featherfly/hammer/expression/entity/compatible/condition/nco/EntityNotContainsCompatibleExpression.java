/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntityNotContainsCompatibleExpression.java
 * @Package cn.featherfly.hammer.expression.entity.compatible.condition.nco
 * @author: zhongj
 * @date: 2025-12-11 01:25:11
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.compatible.condition.nco;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.nco.NotContainsExpression;
import cn.featherfly.hammer.expression.entity.condition.nco.EntityNotContainsExpression;

/**
 * entity not contains compatible expression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityNotContainsCompatibleExpression<E, C extends ConditionExpression,
    L extends LogicExpression<C, L>> extends EntityNotContainsExpression<E, C, L>, NotContainsExpression<C, L> {

}