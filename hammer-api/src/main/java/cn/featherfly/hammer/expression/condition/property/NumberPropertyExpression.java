
package cn.featherfly.hammer.expression.condition.property;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * number property expression..
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface NumberPropertyExpression<N extends Number, C extends ConditionExpression,
        L extends LogicExpression<C, L>>
        extends PropertyBetweenExpression<C, L, N>, PropertyNotBetweenExpression<C, L, N> //
        , PropertyEqualsExpression<C, L, N>, PropertyNotEqualsExpression<C, L, N> //
        , PropertyInExpression<C, L, N>, PropertyNotInExpression<C, L, N> //
        , PropertyLessEqualsExpression<C, L, N>, PropertyLessThanExpression<C, L, N> //
        , PropertyGreatEqualsExpression<C, L, N>, PropertyGreatThanExpression<C, L, N> //
        , PropertyIsNullExpression<C, L>, PropertyIsNotNullExpression<C, L> {

}