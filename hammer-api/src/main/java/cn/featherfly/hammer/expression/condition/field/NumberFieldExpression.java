
package cn.featherfly.hammer.expression.condition.field;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * Number field expression..
 *
 * @author zhongj
 * @param <N> the number type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface NumberFieldExpression<N extends Number, C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends FieldBetweenExpression<C, L, N>, FieldNotBetweenExpression<C, L, N> //
    , FieldEqualsExpression<C, L, N>, FieldNotEqualsExpression<C, L, N> //
    , FieldInExpression<C, L, N>, FieldNotInExpression<C, L, N> //
    , FieldLessEqualsExpression<C, L, N>, FiledLessThanExpression<C, L, N> //
    , FieldGreatEqualsExpression<C, L, N>, FieldGreatThanExpression<C, L, N> //
    , FieldIsNullExpression<C, L>, FieldIsNotNullExpression<C, L>, FieldExpression {

}