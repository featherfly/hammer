
package cn.featherfly.hammer.dsl.entity.execute;

import cn.featherfly.hammer.config.dsl.ExecutableConditionConfig;
import cn.featherfly.hammer.expression.entity.execute.EntityExecutableConditionGroupLogicExpression6;
import cn.featherfly.hammer.expression.execute.Executor;

/**
 * entity executable condition group logic.
 *
 * @author zhongj
 */
public interface EntityExecutableConditionGroupLogic6<E1, E2, E3, E4, E5, E6, C extends ExecutableConditionConfig<C>>
    extends Executor,
    EntityExecutableConditionGroupLogicExpression6<E1, E2, E3, E4, E5, E6,
        EntityExecutableConditionGroup6<E1, E2, E3, E4, E5, E6, C>,
        EntityExecutableConditionGroupLogic6<E1, E2, E3, E4, E5, E6, C>, C> {

}
