
package cn.featherfly.juorm.expression.condition.property;

import cn.featherfly.juorm.expression.condition.ConditionExpression;
import cn.featherfly.juorm.expression.condition.LogicExpression;

/**
 * <p>
 * EqualsExpressoin
 * </p>
 *
 * @author zhongj
 */
public interface NumberExpression<C extends ConditionExpression,
        L extends LogicExpression<C, L>>
        extends PropertyEqualsExpression<C, L, Number>,
        PropertyNotEqualsExpression<C, L, Number>,
        PropertyInExpression<C, L, Number>,
        PropertyNotInExpression<C, L, Number>,
        PropertyLessEqualsExpressoin<C, L, Number>,
        PropertyLessThanExpressoin<C, L, Number>,
        PropertyGreatEqualsExpressoin<C, L, Number>,
        PropertyGreatThanExpressoin<C, L, Number>,
        PropertyIsNullExpression<C, L>, PropertyIsNotNullExpression<C, L> {

}