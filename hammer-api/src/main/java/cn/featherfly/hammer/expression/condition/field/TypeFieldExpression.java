
package cn.featherfly.hammer.expression.condition.field;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * Type field expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface TypeFieldExpression<T, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends FieldBetweenExpression<C, L, T>, FieldNotBetweenExpression<C, L, T> //
        , FieldEqualsExpression<C, L, T>, FieldNotEqualsExpression<C, L, T>, FieldInExpression<C, L, T>,
        FieldNotInExpression<C, L, T>, FieldLessEqualsExpression<C, L, T>, FiledLessThanExpression<C, L, T>,
        FieldGreatEqualsExpression<C, L, T>, FieldGreatThanExpression<C, L, T>, FieldStartWithExpression<C, L>,
        FieldContainsExpression<C, L>, FieldEndWithExpression<C, L>, FieldLikeExpression<C, L>,
        FieldIsNullExpression<C, L>, FieldIsNotNullExpression<C, L> {
}