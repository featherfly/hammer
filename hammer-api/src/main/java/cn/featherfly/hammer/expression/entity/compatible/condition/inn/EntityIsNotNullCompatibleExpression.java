/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntityIsNotNullCompatibleExpression.java
 * @Package cn.featherfly.hammer.expression.entity.compatible.condition.inn
 * @author: zhongj
 * @date: 2025-12-11 01:37:11
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.compatible.condition.inn;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.inn.IsNotNullExpression;
import cn.featherfly.hammer.expression.entity.condition.inn.EntityIsNotNullExpression;

/**
 * The Interface EntityIsNotNullCompatibleExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityIsNotNullCompatibleExpression<E, C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends EntityIsNotNullExpression<E, C, L>, IsNotNullExpression<C, L> {
}