
package cn.featherfly.hammer.expression.condition.property;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * Type property expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface TypePropertyExpression<T, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends PropertyBetweenExpression<C, L, T>, PropertyNotBetweenExpression<C, L, T> //
        , PropertyEqualsExpression<C, L, T>, PropertyNotEqualsExpression<C, L, T>, PropertyInExpression<C, L, T>,
        PropertyNotInExpression<C, L, T>, PropertyLessEqualsExpression<C, L, T>, PropertyLessThanExpression<C, L, T>,
        PropertyGreatEqualsExpression<C, L, T>, PropertyGreatThanExpression<C, L, T>, PropertyStartWithExpression<C, L>,
        PropertyContainsExpression<C, L>, PropertyEndWithExpression<C, L>, PropertyLikeExpression<C, L>,
        PropertyIsNullExpression<C, L>, PropertyIsNotNullExpression<C, L> {
}