
package cn.featherfly.juorm.dsl.execute.property;

import cn.featherfly.juorm.dsl.execute.ExecutableConditionGroupExpression;
import cn.featherfly.juorm.dsl.execute.ExecutableConditionGroupLogicExpression;

/**
 * <p>
 * Update
 * </p>
 *
 * @author zhongj
 */
public interface PropertyUpdate<U extends PropertyExecutableUpdate<U>> extends
        cn.featherfly.juorm.expression.execute.property.PropertyUpdate<U, ExecutableConditionGroupExpression, ExecutableConditionGroupLogicExpression> {

}
