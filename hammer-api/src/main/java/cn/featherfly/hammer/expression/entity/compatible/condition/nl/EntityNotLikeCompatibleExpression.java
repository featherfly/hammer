/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntityNotLikeCompatibleExpression.java
 * @Package cn.featherfly.hammer.expression.entity.compatible.condition.nl
 * @author: zhongj
 * @date: 2025-12-11 01:26:11
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.compatible.condition.nl;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.nl.NotLikeExpression;
import cn.featherfly.hammer.expression.entity.condition.nl.EntityNotLikeExpression;

/**
 * entity not like compatible expression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityNotLikeCompatibleExpression<E, C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends EntityNotLikeExpression<E, C, L>, NotLikeExpression<C, L> {

}