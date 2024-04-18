
package cn.featherfly.hammer.dsl.entity.execute;

import cn.featherfly.hammer.config.dsl.ExecutableConditionConfig;
import cn.featherfly.hammer.expression.entity.execute.EntityExecutableConditionGroupExpression6;

/**
 * entity executable condition group.
 *
 * @author zhongj
 * @param <E1> the generic type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <E5> the generic type
 * @param <E6> the generic type
 * @param <C>  the generic type
 */
public interface EntityExecutableConditionGroup6<E1, E2, E3, E4, E5, E6, C extends ExecutableConditionConfig<C>> extends
    EntityExecutableConditionGroupExpression6<E1, E2, E3, E4, E5, E6,
        EntityExecutableConditionGroup6<E1, E2, E3, E4, E5, E6, C>,
        EntityExecutableConditionGroupLogic6<E1, E2, E3, E4, E5, E6, C>, C> {
}
