/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntityInCompatibleExpression.java
 * @Package cn.featherfly.hammer.expression.entity.compatible.condition.in
 * @author: zhongj
 * @date: 2025-12-11 01:24:11
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.compatible.condition.in;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.in.InExpression;
import cn.featherfly.hammer.expression.entity.condition.in.EntityInExpression;

/**
 * The Interface EntityInCompatibleExpression.
 *
 * @author zhongj
 * @param <T> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityInCompatibleExpression<T, C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends EntityInExpression<T, C, L>, InExpression<C, L> {

}