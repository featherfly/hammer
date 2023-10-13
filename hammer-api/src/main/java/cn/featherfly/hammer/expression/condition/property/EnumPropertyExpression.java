
package cn.featherfly.hammer.expression.condition.property;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * Enum property expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EnumPropertyExpression<E extends Enum<E>, C extends ConditionExpression,
        L extends LogicExpression<C, L>>
        extends PropertyEqualsExpression<C, L, E>, PropertyNotEqualsExpression<C, L, E>, PropertyInExpression<C, L, E>,
        PropertyNotInExpression<C, L, E>, PropertyIsNullExpression<C, L>, PropertyIsNotNullExpression<C, L> {

}