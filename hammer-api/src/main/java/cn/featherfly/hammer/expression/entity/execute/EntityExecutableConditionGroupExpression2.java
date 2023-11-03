
package cn.featherfly.hammer.expression.entity.execute;

import cn.featherfly.hammer.config.dsl.ExecutableConditionConfig;
import cn.featherfly.hammer.expression.condition.ConditionConfigureExpression;
import cn.featherfly.hammer.expression.entity.EntityConditionGroupExpression2;

/**
 * entity executable condition group expression,.
 *
 * @author zhongj
 */
public interface EntityExecutableConditionGroupExpression2<E1, E2,
    C extends EntityExecutableConditionGroupExpression2<E1, E2, C, L, C2>,
    L extends EntityExecutableConditionGroupLogicExpression2<E1, E2, C, L, C2>,
    C2 extends ExecutableConditionConfig<C2>>
    extends EntityConditionGroupExpression2<E1, E2, C, L>, ConditionConfigureExpression<C, C2> {
}
