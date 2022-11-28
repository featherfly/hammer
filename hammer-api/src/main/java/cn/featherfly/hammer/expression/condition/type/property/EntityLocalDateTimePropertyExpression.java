
/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntityLocalDateTimeExpression.java
 * @Package cn.featherfly.hammer.expression.condition.type.property
 * @Description: EntityLocalDateTimeExpression
 * @author: zhongj
 * @date: 2022-11-28 14:16:28
 * @Copyright: 2022 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.condition.type.property;

import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.property.LocalDateTimeExpression;
import cn.featherfly.hammer.expression.condition.type.EntityConditionsExpression;

/**
 * EntityLocalDateTimeExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityLocalDateTimePropertyExpression<E, C extends EntityConditionsExpression<E, C, L>,
        L extends LogicExpression<C, L>> extends LocalDateTimeExpression<C, L> {

}
