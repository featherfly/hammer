/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntityGreatEqualsCompatibleExpression.java
 * @Package cn.featherfly.hammer.expression.entity.compatible.condition.ge
 * @author: zhongj
 * @date: 2025-12-11 01:23:11
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.compatible.condition.ge;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.ge.GreatEqualsExpression;
import cn.featherfly.hammer.expression.entity.condition.ge.EntityGreatEqualsExpression;

/**
 * The Interface EntityGreatEqualsCompatibleExpression.
 *
 * @author zhongj
 * @param <T> the comparable type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityGreatEqualsCompatibleExpression<T, C extends ConditionExpression,
    L extends LogicExpression<C, L>> extends EntityGreatEqualsExpression<T, C, L>, GreatEqualsExpression<C, L> {
}