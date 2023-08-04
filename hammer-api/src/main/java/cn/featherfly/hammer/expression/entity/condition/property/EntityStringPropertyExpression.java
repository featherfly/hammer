
/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntityStringExpression.java
 * @Package cn.featherfly.hammer.expression.condition.type.property
 * @Description: EntityStringExpression
 * @author: zhongj
 * @date: 2022-11-28 14:16:28
 * @Copyright: 2022 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.condition.property;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.property.StringExpression;

/**
 * EntityStringExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityStringPropertyExpression<E, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends StringExpression<C, L> {

}
