/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntityNotBetweenCompatibleExpression.java
 * @Package cn.featherfly.hammer.expression.entity.compatible.condition.nba
 * @author: zhongj
 * @date: 2025-12-11 01:25:11
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.compatible.condition.nba;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.nba.NotBetweenExpression;
import cn.featherfly.hammer.expression.entity.condition.nba.EntityNotBetweenExpression;

/**
 * The Interface EntityNotBetweenCompatibleExpression.
 *
 * @author zhongj
 * @param <T> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityNotBetweenCompatibleExpression<T, C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends EntityNotBetweenExpression<T, C, L>, NotBetweenExpression<C, L> {

}