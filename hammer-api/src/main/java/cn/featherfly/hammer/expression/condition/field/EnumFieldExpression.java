
package cn.featherfly.hammer.expression.condition.field;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * Enum field expression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EnumFieldExpression<E extends Enum<E>, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends FieldEqualsExpression<C, L, E>, FieldNotEqualsExpression<C, L, E>, FieldInExpression<C, L, E>,
        FieldNotInExpression<C, L, E>, FieldIsNullExpression<C, L>, FieldIsNotNullExpression<C, L> {

}