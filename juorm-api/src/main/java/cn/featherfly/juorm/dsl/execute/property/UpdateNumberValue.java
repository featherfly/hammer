
package cn.featherfly.juorm.dsl.execute.property;

import cn.featherfly.juorm.dsl.execute.ExecutableConditionGroupExpression;
import cn.featherfly.juorm.dsl.execute.ExecutableConditionGroupLogicExpression;

/**
 * <p>
 * update number value
 * </p>
 *
 * @author zhongj
 */
public interface UpdateNumberValue<U extends PropertyExecutableUpdate<U>,
        T extends Number> extends UpdateValue<U, T>,
        cn.featherfly.juorm.expression.execute.property.UpdateNumberValue<U, ExecutableConditionGroupExpression, ExecutableConditionGroupLogicExpression, T> {
}
