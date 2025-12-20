/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntityLessEqualsCompatibleExpression.java
 * @Package cn.featherfly.hammer.expression.entity.compatible.condition.le
 * @author: zhongj
 * @date: 2025-12-11 01:24:11
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.compatible.condition.le;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.le.LessEqualsExpression;
import cn.featherfly.hammer.expression.entity.condition.le.EntityLessEqualsExpression;

/**
 * The Interface EntityLessEqualsCompatibleExpression.
 *
 * @author zhongj
 * @param <T> the comparable type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityLessEqualsCompatibleExpression<T, C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends EntityLessEqualsExpression<T, C, L>, LessEqualsExpression<C, L> {
}