
package cn.featherfly.hammer.expression.entity.execute;

import cn.featherfly.hammer.config.dsl.ExecutableConditionConfig;
import cn.featherfly.hammer.expression.entity.EntityConditionGroupLogicExpression4;
import cn.featherfly.hammer.expression.execute.Executor;

/**
 * entity executable condition group logic expression,.
 *
 * @author zhongj
 */
public interface EntityExecutableConditionGroupLogicExpression4<E1, E2, E3, E4,
    C extends EntityExecutableConditionGroupExpression4<E1, E2, E3, E4, C, L, C2>,
    L extends EntityExecutableConditionGroupLogicExpression4<E1, E2, E3, E4, C, L, C2>,
    C2 extends ExecutableConditionConfig<C2>>
    extends Executor, EntityConditionGroupLogicExpression4<E1, E2, E3, E4, C, L> {

}
