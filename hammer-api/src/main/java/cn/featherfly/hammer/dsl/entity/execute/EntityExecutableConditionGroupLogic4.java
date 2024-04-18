
package cn.featherfly.hammer.dsl.entity.execute;

import cn.featherfly.hammer.config.dsl.ExecutableConditionConfig;
import cn.featherfly.hammer.expression.entity.execute.EntityExecutableConditionGroupLogicExpression4;
import cn.featherfly.hammer.expression.execute.Executor;

/**
 * entity executable condition group logic.
 *
 * @author zhongj
 * @param <E1> the generic type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <C>  the generic type
 */
public interface EntityExecutableConditionGroupLogic4<E1, E2, E3, E4, C extends ExecutableConditionConfig<C>>
    extends Executor,
    EntityExecutableConditionGroupLogicExpression4<E1, E2, E3, E4, EntityExecutableConditionGroup4<E1, E2, E3, E4, C>,
        EntityExecutableConditionGroupLogic4<E1, E2, E3, E4, C>, C> {

}
