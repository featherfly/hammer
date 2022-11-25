
/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntityEnumExpression.java
 * @Package cn.featherfly.hammer.expression.condition.type.property
 * @Description: EntityEnumExpression
 * @author: zhongj
 * @date: 2022-11-28 14:16:28
 * @Copyright: 2022 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.condition.type.property;

import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.property.EnumExpression;
import cn.featherfly.hammer.expression.condition.type.EntityConditionsExpression;

/**
 * EntityEnumExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <D> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityEnumPropertyExpression<E, EN extends Enum<EN>, C extends EntityConditionsExpression<E, C, L>,
        L extends LogicExpression<C, L>> extends EnumExpression<EN, C, L> {

}
