
package cn.featherfly.hammer.dsl.entity.execute;

import cn.featherfly.hammer.config.dsl.ExecutableConditionConfig;
import cn.featherfly.hammer.expression.entity.execute.EntityExecutableConditionGroupLogicExpression3;
import cn.featherfly.hammer.expression.execute.Executor;

/**
 * entity executable condition group logic.
 *
 * @author zhongj
 * @param <E1> the generic type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <C>  the generic type
 */
public interface EntityExecutableConditionGroupLogic3<E1, E2, E3, C extends ExecutableConditionConfig<C>>
    extends Executor, EntityExecutableConditionGroupLogicExpression3<E1, E2, E3,
        EntityExecutableConditionGroup3<E1, E2, E3, C>, EntityExecutableConditionGroupLogic3<E1, E2, E3, C>, C> {

}
