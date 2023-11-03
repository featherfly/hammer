
package cn.featherfly.hammer.dsl.entity.execute;

import cn.featherfly.hammer.config.dsl.ExecutableConditionConfig;
import cn.featherfly.hammer.expression.entity.execute.EntityExecutableConditionGroupExpression5;

/**
 * entity executable condition group.
 *
 * @author zhongj
 */
public interface EntityExecutableConditionGroup5<E1, E2, E3, E4, E5, C extends ExecutableConditionConfig<C>> extends
    EntityExecutableConditionGroupExpression5<E1, E2, E3, E4, E5,
        EntityExecutableConditionGroup5<E1, E2, E3, E4, E5, C>,
        EntityExecutableConditionGroupLogic5<E1, E2, E3, E4, E5, C>, C> {
}
