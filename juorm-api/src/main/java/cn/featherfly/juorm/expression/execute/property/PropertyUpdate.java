
package cn.featherfly.juorm.expression.execute.property;

import cn.featherfly.juorm.expression.condition.ConditionGroupExpression;
import cn.featherfly.juorm.expression.condition.LogicGroupExpression;
import cn.featherfly.juorm.expression.execute.IUpdate;

/**
 * <p>
 * Update
 * </p>
 *
 * @author zhongj
 */
public interface PropertyUpdate<U extends PropertyExecutableUpdate<U, C, L>,
        C extends ConditionGroupExpression<C, L>,
        L extends LogicGroupExpression<C, L>> extends IUpdate {

    <V extends UpdateValue<U, C, L, Object>> V property(String name);

    <V extends UpdateNumberValue<U, C, L, Number>> V propertyNumber(
            String name);
}
