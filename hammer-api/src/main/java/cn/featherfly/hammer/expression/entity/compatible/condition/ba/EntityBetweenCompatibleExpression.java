/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntityBetweenCompatibleExpression.java
 * @Package cn.featherfly.hammer.expression.entity.compatible.condition.ba
 * @author: zhongj
 * @date: 2025-12-11 01:23:11
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.compatible.condition.ba;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.ba.BetweenExpression;
import cn.featherfly.hammer.expression.entity.condition.ba.EntityBetweenExpression;

/**
 * The Interface EntityBetweenCompatibleExpression.
 *
 * @author zhongj
 * @param <T> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityBetweenCompatibleExpression<T, C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends EntityBetweenExpression<T, C, L>, BetweenExpression<C, L> {

}