
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
public interface EnumExpression<C extends ConditionExpression,
        L extends LogicExpression<C, L>>
        extends PropertyEqualsExpression<C, L, Enum<?>>,
        PropertyNotEqualsExpression<C, L, Enum<?>>,
        PropertyInExpression<C, L, Enum<?>>,
        PropertyNotInExpression<C, L, Enum<?>>, PropertyIsNullExpression<C, L>,
        PropertyIsNotNullExpression<C, L> {
}