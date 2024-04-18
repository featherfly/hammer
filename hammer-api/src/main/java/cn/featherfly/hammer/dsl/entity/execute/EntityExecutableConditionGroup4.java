
package cn.featherfly.hammer.dsl.entity.execute;

import cn.featherfly.hammer.config.dsl.ExecutableConditionConfig;
import cn.featherfly.hammer.expression.entity.execute.EntityExecutableConditionGroupExpression4;

/**
 * entity executable condition group.
 *
 * @author zhongj
 * @param <E1> the generic type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <C>  the generic type
 */
public interface EntityExecutableConditionGroup4<E1, E2, E3, E4, C extends ExecutableConditionConfig<C>> extends
    EntityExecutableConditionGroupExpression4<E1, E2, E3, E4, EntityExecutableConditionGroup4<E1, E2, E3, E4, C>,
        EntityExecutableConditionGroupLogic4<E1, E2, E3, E4, C>, C> {
}
