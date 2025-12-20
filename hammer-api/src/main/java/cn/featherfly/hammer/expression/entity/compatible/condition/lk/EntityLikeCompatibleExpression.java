/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntityLikeCompatibleExpression.java
 * @Package cn.featherfly.hammer.expression.entity.compatible.condition.lk
 * @author: zhongj
 * @date: 2025-12-11 01:24:11
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.compatible.condition.lk;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.lk.LikeExpression;
import cn.featherfly.hammer.expression.entity.condition.lk.EntityLikeExpression;

/**
 * entity like compatible expression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityLikeCompatibleExpression<E, C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends EntityLikeExpression<E, C, L>, LikeExpression<C, L> {

}