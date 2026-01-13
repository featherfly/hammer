/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntityNotStartWithCompatibleExpression.java
 * @Package cn.featherfly.hammer.expression.entity.compatible.condition.nsw
 * @author: zhongj
 * @date: 2025-12-11 01:26:11
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.compatible.condition.nsw;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.nsw.NotStartWithExpression;
import cn.featherfly.hammer.expression.entity.condition.nsw.EntityNotStartWithExpression;

/**
 * The Interface EntityNotStartWithCompatibleExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityNotStartWithCompatibleExpression<E, C extends ConditionExpression,
    L extends LogicExpression<C, L>> extends EntityNotStartWithExpression<E, C, L>, NotStartWithExpression<C, L> {

}