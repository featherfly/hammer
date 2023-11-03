
package cn.featherfly.hammer.dsl.entity.execute;

import cn.featherfly.hammer.config.dsl.ExecutableConditionConfig;
import cn.featherfly.hammer.expression.entity.execute.EntityExecutableConditionGroupLogicExpression2;
import cn.featherfly.hammer.expression.execute.Executor;

/**
 * entity executable condition group logic.
 *
 * @author zhongj
 */
public interface EntityExecutableConditionGroupLogic2<E1, E2, C extends ExecutableConditionConfig<C>>
    extends Executor, EntityExecutableConditionGroupLogicExpression2<E1, E2, EntityExecutableConditionGroup2<E1, E2, C>,
        EntityExecutableConditionGroupLogic2<E1, E2, C>, C> {

}
