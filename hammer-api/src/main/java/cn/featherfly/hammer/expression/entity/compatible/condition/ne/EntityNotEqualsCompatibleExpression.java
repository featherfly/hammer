/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntityNotEqualsCompatibleExpression.java
 * @Package cn.featherfly.hammer.expression.entity.compatible.condition.ne
 * @author: zhongj
 * @date: 2025-12-11 01:25:11
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.compatible.condition.ne;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.ne.NotEqualsExpression;
import cn.featherfly.hammer.expression.entity.condition.ne.EntityNotEqualsExpression;

/**
 * The Interface EntityNotEqualsCompatibleExpression.
 *
 * @author zhongj
 * @param <T> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityNotEqualsCompatibleExpression<T, C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends EntityNotEqualsExpression<T, C, L>, NotEqualsExpression<C, L> {

}