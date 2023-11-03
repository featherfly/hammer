
package cn.featherfly.hammer.dsl.entity.execute;

import cn.featherfly.hammer.config.dsl.ExecutableConditionConfig;
import cn.featherfly.hammer.expression.entity.execute.EntityExecutableConditionGroupExpression4;

/**
 * entity executable condition group.
 *
 * @author zhongj
 */
public interface EntityExecutableConditionGroup4<E1, E2, E3, E4, C extends ExecutableConditionConfig<C>> extends
    EntityExecutableConditionGroupExpression4<E1, E2, E3, E4, EntityExecutableConditionGroup4<E1, E2, E3, E4, C>,
        EntityExecutableConditionGroupLogic4<E1, E2, E3, E4, C>, C> {
}
