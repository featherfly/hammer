
package cn.featherfly.hammer.dsl.execute;

import cn.featherfly.hammer.config.dsl.ExecutableConditionConfig;
import cn.featherfly.hammer.expression.execute.ExecutableConditionGroupExpression;

/**
 * executable condition group,.
 *
 * @author zhongj
 */
public interface ExecutableConditionGroup<C extends ExecutableConditionConfig<C>>
        extends ExecutableConditionGroupExpression<ExecutableConditionGroup<C>, ExecutableConditionGroupLogic<C>, C> {
}
