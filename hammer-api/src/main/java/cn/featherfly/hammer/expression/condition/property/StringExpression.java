
package cn.featherfly.hammer.expression.condition.property;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * <p>
 * EqualsExpressoin
 * </p>
 *
 * @author zhongj
 */
public interface StringExpression<C extends ConditionExpression,
        L extends LogicExpression<C, L>>
        extends PropertyEqualsExpression<C, L, String>,
        PropertyNotEqualsExpression<C, L, String>,
        PropertyInExpression<C, L, String>,
        PropertyNotInExpression<C, L, String>,
        PropertyLessEqualsExpressoin<C, L, String>,
        PropertyLessThanExpressoin<C, L, String>,
        PropertyGreatEqualsExpressoin<C, L, String>,
        PropertyGreatThanExpressoin<C, L, String>,
        PropertyStartWithExpression<C, L>, PropertyContainsExpression<C, L>,
        PropertyEndWithExpression<C, L>, PropertyIsNullExpression<C, L>,
        PropertyIsNotNullExpression<C, L> {
}