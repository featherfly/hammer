
package cn.featherfly.hammer.expression.condition.field;

import java.util.Date;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * Date field expression.
 *
 * @author zhongj
 * @param <D> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface DateFieldExpression<D extends Date, C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends FieldBetweenExpression<C, L, D>, FieldNotBetweenExpression<C, L, D> //
    , FieldEqualsExpression<C, L, D>, FieldNotEqualsExpression<C, L, D>, FieldInExpression<C, L, D>,
    FieldNotInExpression<C, L, D>, FieldLessEqualsExpression<C, L, D>, FiledLessThanExpression<C, L, D>,
    FieldGreatEqualsExpression<C, L, D>, FieldGreatThanExpression<C, L, D>, FieldIsNullExpression<C, L>,
    FieldIsNotNullExpression<C, L>, FieldExpression {

}