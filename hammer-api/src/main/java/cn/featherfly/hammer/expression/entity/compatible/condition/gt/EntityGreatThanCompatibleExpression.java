/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntityGreatThanCompatibleExpression.java
 * @Package cn.featherfly.hammer.expression.entity.compatible.condition.gt
 * @author: zhongj
 * @date: 2025-12-11 01:24:11
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.compatible.condition.gt;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.gt.GreatThanExpression;
import cn.featherfly.hammer.expression.entity.condition.gt.EntityGreatThanExpression;

/**
 * The Interface EntityGreatThanCompatibleExpression.
 *
 * @author zhongj
 * @param <T> the comparable type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityGreatThanCompatibleExpression<T, C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends EntityGreatThanExpression<T, C, L>, GreatThanExpression<C, L> {
}