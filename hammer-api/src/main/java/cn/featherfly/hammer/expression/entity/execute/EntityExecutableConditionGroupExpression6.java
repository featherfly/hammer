
package cn.featherfly.hammer.expression.entity.execute;

import cn.featherfly.hammer.config.dsl.ExecutableConditionConfig;
import cn.featherfly.hammer.expression.condition.ConditionConfigureExpression;
import cn.featherfly.hammer.expression.entity.EntityConditionGroupExpression6;

/**
 * entity executable condition group expression,.
 *
 * @author zhongj
 */
public interface EntityExecutableConditionGroupExpression6<E1, E2, E3, E4, E5, E6,
    C extends EntityExecutableConditionGroupExpression6<E1, E2, E3, E4, E5, E6, C, L, C2>,
    L extends EntityExecutableConditionGroupLogicExpression6<E1, E2, E3, E4, E5, E6, C, L, C2>,
    C2 extends ExecutableConditionConfig<C2>>
    extends EntityConditionGroupExpression6<E1, E2, E3, E4, E5, E6, C, L>, ConditionConfigureExpression<C, C2> {
}
