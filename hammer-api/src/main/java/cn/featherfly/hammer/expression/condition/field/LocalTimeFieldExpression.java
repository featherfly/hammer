
package cn.featherfly.hammer.expression.condition.field;

import java.time.LocalTime;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * LocalTime field expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface LocalTimeFieldExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends FieldBetweenExpression<C, L, LocalTime>, FieldNotBetweenExpression<C, L, LocalTime> //
    , FieldEqualsExpression<C, L, LocalTime>, FieldNotEqualsExpression<C, L, LocalTime>,
    FieldInExpression<C, L, LocalTime>, FieldNotInExpression<C, L, LocalTime>,
    FieldLessEqualsExpression<C, L, LocalTime>, FiledLessThanExpression<C, L, LocalTime>,
    FieldGreatEqualsExpression<C, L, LocalTime>, FieldGreatThanExpression<C, L, LocalTime>, FieldIsNullExpression<C, L>,
    FieldIsNotNullExpression<C, L>, FieldExpression {

}