
package cn.featherfly.hammer.expression.entity.execute;

import cn.featherfly.hammer.config.dsl.ExecutableConditionConfig;
import cn.featherfly.hammer.expression.condition.ConditionConfigureExpression;
import cn.featherfly.hammer.expression.entity.EntityConditionGroupExpression5;

/**
 * entity executable condition group expression,.
 *
 * @author zhongj
 */
public interface EntityExecutableConditionGroupExpression5<E1, E2, E3, E4, E5,
    C extends EntityExecutableConditionGroupExpression5<E1, E2, E3, E4, E5, C, L, C2>,
    L extends EntityExecutableConditionGroupLogicExpression5<E1, E2, E3, E4, E5, C, L, C2>,
    C2 extends ExecutableConditionConfig<C2>>
    extends EntityConditionGroupExpression5<E1, E2, E3, E4, E5, C, L>, ConditionConfigureExpression<C, C2> {
}
