
package cn.featherfly.hammer.expression.condition.property;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * String property expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface StringPropertyExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends PropertyBetweenExpression<C, L, String>, PropertyNotBetweenExpression<C, L, String> //
        , PropertyEqualsExpression<C, L, String>, PropertyNotEqualsExpression<C, L, String>,
        PropertyInExpression<C, L, String>, PropertyNotInExpression<C, L, String>,
        PropertyLessEqualsExpression<C, L, String>, PropertyLessThanExpression<C, L, String>,
        PropertyGreatEqualsExpression<C, L, String>, PropertyGreatThanExpression<C, L, String>,
        PropertyStartWithExpression<C, L>, PropertyNotStartWithExpression<C, L>//
        , PropertyContainsExpression<C, L>, PropertyNotContainsExpression<C, L>//
        , PropertyEndWithExpression<C, L>, PropertyNotEndWithExpression<C, L>//
        , PropertyLikeExpression<C, L>, PropertyNotLikeExpression<C, L>//
        , PropertyIsNullExpression<C, L>, PropertyIsNotNullExpression<C, L> {
}