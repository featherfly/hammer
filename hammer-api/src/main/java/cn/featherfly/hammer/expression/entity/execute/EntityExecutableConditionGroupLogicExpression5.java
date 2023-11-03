
package cn.featherfly.hammer.expression.entity.execute;

import cn.featherfly.hammer.config.dsl.ExecutableConditionConfig;
import cn.featherfly.hammer.expression.entity.EntityConditionGroupLogicExpression5;
import cn.featherfly.hammer.expression.execute.Executor;

/**
 * entity executable condition group logic expression,.
 *
 * @author zhongj
 */
public interface EntityExecutableConditionGroupLogicExpression5<E1, E2, E3, E4, E5,
    C extends EntityExecutableConditionGroupExpression5<E1, E2, E3, E4, E5, C, L, C2>,
    L extends EntityExecutableConditionGroupLogicExpression5<E1, E2, E3, E4, E5, C, L, C2>,
    C2 extends ExecutableConditionConfig<C2>>
    extends Executor, EntityConditionGroupLogicExpression5<E1, E2, E3, E4, E5, C, L> {

}
