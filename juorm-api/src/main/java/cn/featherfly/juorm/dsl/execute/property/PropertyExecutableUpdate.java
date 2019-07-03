
package cn.featherfly.juorm.dsl.execute.property;

import cn.featherfly.juorm.dsl.execute.ExecutableConditionGroupExpression;
import cn.featherfly.juorm.dsl.execute.ExecutableConditionGroupLogicExpression;

/**
 * <p>
 * Updator
 * </p>
 *
 * @author zhongj
 */
public interface PropertyExecutableUpdate<U extends PropertyExecutableUpdate<U>>
        extends
        cn.featherfly.juorm.expression.execute.property.PropertyExecutableUpdate<U, ExecutableConditionGroupExpression, ExecutableConditionGroupLogicExpression>,
        PropertyUpdate<U> {
}
