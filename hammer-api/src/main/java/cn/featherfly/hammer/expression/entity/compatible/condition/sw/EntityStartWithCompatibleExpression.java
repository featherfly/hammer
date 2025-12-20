/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntityStartWithCompatibleExpression.java
 * @Package cn.featherfly.hammer.expression.entity.compatible.condition.sw
 * @author: zhongj
 * @date: 2025-12-11 01:26:11
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.compatible.condition.sw;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.sw.StartWithExpression;
import cn.featherfly.hammer.expression.entity.condition.sw.EntityStartWithExpression;

/**
 * entity start with compatible expression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityStartWithCompatibleExpression<E, C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends EntityStartWithExpression<E, C, L>, StartWithExpression<C, L> {

}