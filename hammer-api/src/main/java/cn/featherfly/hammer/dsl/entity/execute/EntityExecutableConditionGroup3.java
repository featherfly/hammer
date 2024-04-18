
package cn.featherfly.hammer.dsl.entity.execute;

import cn.featherfly.hammer.config.dsl.ExecutableConditionConfig;
import cn.featherfly.hammer.expression.entity.execute.EntityExecutableConditionGroupExpression3;

/**
 * entity executable condition group.
 *
 * @author zhongj
 * @param <E1> the generic type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <C>  the generic type
 */
public interface EntityExecutableConditionGroup3<E1, E2, E3, C extends ExecutableConditionConfig<C>>
    extends EntityExecutableConditionGroupExpression3<E1, E2, E3, EntityExecutableConditionGroup3<E1, E2, E3, C>,
        EntityExecutableConditionGroupLogic3<E1, E2, E3, C>, C> {
}
