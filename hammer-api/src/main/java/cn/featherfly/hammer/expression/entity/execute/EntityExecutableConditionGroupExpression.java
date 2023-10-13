
package cn.featherfly.hammer.expression.entity.execute;

import cn.featherfly.hammer.config.dsl.ExecutableConditionConfig;
import cn.featherfly.hammer.expression.condition.ConditionConfigureExpression;
import cn.featherfly.hammer.expression.entity.EntityConditionGroupExpression;

/**
 * entity executable condition group expression,.
 *
 * @author zhongj
 */
public interface EntityExecutableConditionGroupExpression<E,
        C extends EntityExecutableConditionGroupExpression<E, C, L, C2>,
        L extends EntityExecutableConditionGroupLogicExpression<E, C, L, C2>, C2 extends ExecutableConditionConfig<C2>>
        extends EntityConditionGroupExpression<E, C, L>, ConditionConfigureExpression<C, C2> {
}
