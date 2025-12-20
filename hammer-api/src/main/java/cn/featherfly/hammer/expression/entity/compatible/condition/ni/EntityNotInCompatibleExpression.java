/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntityNotInCompatibleExpression.java
 * @Package cn.featherfly.hammer.expression.entity.compatible.condition.ni
 * @author: zhongj
 * @date: 2025-12-11 01:26:11
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.compatible.condition.ni;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.ni.NotInExpression;
import cn.featherfly.hammer.expression.entity.condition.ni.EntityNotInExpression;

/**
 * The Interface EntityNotInCompatibleExpression.
 *
 * @author zhongj
 * @param <T> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityNotInCompatibleExpression<T, C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends EntityNotInExpression<T, C, L>, NotInExpression<C, L> {

}