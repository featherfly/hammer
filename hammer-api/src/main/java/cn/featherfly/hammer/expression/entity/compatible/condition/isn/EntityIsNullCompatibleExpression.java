/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntityIsNullCompatibleExpression.java
 * @Package cn.featherfly.hammer.expression.entity.compatible.condition.isn
 * @author: zhongj
 * @date: 2025-12-11 01:24:11
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.compatible.condition.isn;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.isn.IsNullExpression;
import cn.featherfly.hammer.expression.entity.condition.isn.EntityIsNullExpression;

/**
 * The Interface EntityIsNullCompatibleExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityIsNullCompatibleExpression<E, C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends EntityIsNullExpression<E, C, L>, IsNullExpression<C, L> {
}