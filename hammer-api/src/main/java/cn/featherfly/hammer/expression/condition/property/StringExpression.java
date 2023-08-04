
package cn.featherfly.hammer.expression.condition.property;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * StringExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface StringExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends PropertyEqualsExpression<C, L, String>, PropertyNotEqualsExpression<C, L, String>,
        PropertyInExpression<C, L, String>, PropertyNotInExpression<C, L, String>,
        PropertyLessEqualsExpression<C, L, String>, PropertyLessThanExpression<C, L, String>,
        PropertyGreatEqualsExpression<C, L, String>, PropertyGreatThanExpression<C, L, String>,
        PropertyStartWithExpression<C, L>, PropertyContainsExpression<C, L>, PropertyEndWithExpression<C, L>,
        PropertyLikeExpression<C, L>, PropertyIsNullExpression<C, L>, PropertyIsNotNullExpression<C, L> {
}