
package cn.featherfly.hammer.expression.execute;

import cn.featherfly.hammer.config.dsl.ExecutableConditionConfig;
import cn.featherfly.hammer.expression.ConditionGroupExpression;
import cn.featherfly.hammer.expression.condition.ConditionConfigureExpression;

/**
 * executable condition group expression,.
 *
 * @author zhongj
 */
public interface ExecutableConditionGroupExpression<C extends ExecutableConditionGroupExpression<C, L, C2>,
        L extends ExecutableConditionGroupLogicExpression<C, L, C2>, C2 extends ExecutableConditionConfig<C2>>
        extends ConditionGroupExpression<C, L>, ConditionConfigureExpression<C, C2> {
}
