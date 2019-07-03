
package cn.featherfly.juorm.expression.condition;

import cn.featherfly.juorm.expression.condition.property.DateExpression;
import cn.featherfly.juorm.expression.condition.property.EnumExpression;
import cn.featherfly.juorm.expression.condition.property.NumberExpression;
import cn.featherfly.juorm.expression.condition.property.ObjectExpression;
import cn.featherfly.juorm.expression.condition.property.StringExpression;

/**
 * <p>
 * condition expression
 * </p>
 *
 * @author zhongj
 */
public interface ConditionGroupExpression<
        C extends ConditionGroupExpression<C, L>,
        L extends LogicExpression<C, L>> extends ConditionsExpression<C, L> {

    ObjectExpression<C, L> property(String name);

    StringExpression<C, L> propertyString(String name);

    NumberExpression<C, L> propertyNumber(String name);

    DateExpression<C, L> propertyDate(String name);

    EnumExpression<C, L> propertyEnum(String name);

    /**
     * <p>
     * 在当前内部开启一个新的条件逻辑组
     * </p>
     *
     * @return 新条件逻辑组
     */
    C group();
}
