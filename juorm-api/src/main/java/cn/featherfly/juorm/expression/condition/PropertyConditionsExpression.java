
package cn.featherfly.juorm.expression.condition;

import cn.featherfly.juorm.expression.condition.property.DateExpression;
import cn.featherfly.juorm.expression.condition.property.EnumExpression;
import cn.featherfly.juorm.expression.condition.property.NumberExpression;
import cn.featherfly.juorm.expression.condition.property.ObjectExpression;
import cn.featherfly.juorm.expression.condition.property.StringExpression;

/**
 * <p>
 * PropertyConditionExpression
 * </p>
 *
 * @author zhongj
 */
public interface PropertyConditionsExpression<C extends ConditionsExpression<C, L>, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    ObjectExpression<C, L> property(String name);

    StringExpression<C, L> propertyString(String name);

    NumberExpression<C, L> propertyNumber(String name);

    DateExpression<C, L> propertyDate(String name);

    EnumExpression<C, L> propertyEnum(String name);
}
