
package cn.featherfly.hammer.expression.condition.field;

import java.time.LocalDateTime;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * LocalDateTime field expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface LocalDateTimeFieldExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends FieldBetweenExpression<C, L, LocalDateTime>, FieldNotBetweenExpression<C, L, LocalDateTime> //
    , FieldEqualsExpression<C, L, LocalDateTime>, FieldNotEqualsExpression<C, L, LocalDateTime>,
    FieldInExpression<C, L, LocalDateTime>, FieldNotInExpression<C, L, LocalDateTime>,
    FieldLessEqualsExpression<C, L, LocalDateTime>, FiledLessThanExpression<C, L, LocalDateTime>,
    FieldGreatEqualsExpression<C, L, LocalDateTime>, FieldGreatThanExpression<C, L, LocalDateTime>,
    FieldIsNullExpression<C, L>, FieldIsNotNullExpression<C, L>, FieldExpression {

}