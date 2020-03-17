
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
public interface ObjectExpression<C extends ConditionExpression,
        L extends LogicExpression<C, L>>
        extends PropertyEqualsExpression<C, L, Object>,
        PropertyNotEqualsExpression<C, L, Object>,
        PropertyInExpression<C, L, Object>,
        PropertyNotInExpression<C, L, Object>,
        PropertyLessEqualsExpressoin<C, L, Object>,
        PropertyLessThanExpressoin<C, L, Object>,
        PropertyGreatEqualsExpressoin<C, L, Object>,
        PropertyGreatThanExpressoin<C, L, Object>,
        PropertyStartWithExpression<C, L>, PropertyContainsExpression<C, L>,
        PropertyEndWithExpression<C, L>, PropertyIsNullExpression<C, L>,
        PropertyIsNotNullExpression<C, L> {
}