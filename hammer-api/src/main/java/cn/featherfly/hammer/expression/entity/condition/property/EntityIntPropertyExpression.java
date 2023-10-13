
/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntityNumberExpression.java
 * @Package cn.featherfly.hammer.expression.condition.type.property
 * @Description: EntityNumberExpression
 * @author: zhongj
 * @date: 2022-11-28 14:16:28
 * @Copyright: 2022 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.condition.property;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.property.NumberPropertyExpression;

/**
 * The Interface EntityIntPropertyExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
//ENHANCE 后续加入IntExpression<C,L>
public interface EntityIntPropertyExpression<E, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends NumberPropertyExpression<Integer, C, L> {

}