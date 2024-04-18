
package cn.featherfly.hammer.expression.condition.field;

import java.time.LocalDate;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * LocalDate field expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface LocalDateFieldExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends FieldBetweenExpression<C, L, LocalDate>, FieldNotBetweenExpression<C, L, LocalDate> //
    , FieldEqualsExpression<C, L, LocalDate>, FieldNotEqualsExpression<C, L, LocalDate>,
    FieldInExpression<C, L, LocalDate>, FieldNotInExpression<C, L, LocalDate>,
    FieldLessEqualsExpression<C, L, LocalDate>, FiledLessThanExpression<C, L, LocalDate>,
    FieldGreatEqualsExpression<C, L, LocalDate>, FieldGreatThanExpression<C, L, LocalDate>, FieldIsNullExpression<C, L>,
    FieldIsNotNullExpression<C, L>, FieldExpression {

}