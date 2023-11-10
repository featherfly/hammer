
package cn.featherfly.hammer.expression.entity.execute;

import cn.featherfly.hammer.config.dsl.ExecutableConditionConfig;
import cn.featherfly.hammer.expression.condition.ConditionConfigureExpression;
import cn.featherfly.hammer.expression.entity.EntityConditionGroupExpression4;

/**
 * entity executable condition group expression,.
 *
 * @author zhongj
 */
public interface EntityExecutableConditionGroupExpression4<E1, E2, E3, E4,
    C extends EntityExecutableConditionGroupExpression4<E1, E2, E3, E4, C, L, C2>,
    L extends EntityExecutableConditionGroupLogicExpression4<E1, E2, E3, E4, C, L, C2>,
    C2 extends ExecutableConditionConfig<C2>>
    extends EntityConditionGroupExpression4<E1, E2, E3, E4, C, L>, ConditionConfigureExpression<C, C2> {
}
