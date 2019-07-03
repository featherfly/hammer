
package cn.featherfly.juorm.dsl.execute.property;

import cn.featherfly.juorm.dsl.execute.ExecutableConditionGroupExpression;
import cn.featherfly.juorm.dsl.execute.ExecutableConditionGroupLogicExpression;

/**
 * <p>
 * update value
 * </p>
 *
 * @author zhongj
 */
public interface UpdateValue<U extends PropertyExecutableUpdate<U>, T> extends
        cn.featherfly.juorm.expression.execute.property.UpdateValue<U, ExecutableConditionGroupExpression, ExecutableConditionGroupLogicExpression, T> {
}
