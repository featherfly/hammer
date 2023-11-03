
package cn.featherfly.hammer.expression.execute;

import cn.featherfly.hammer.config.dsl.ExecutableConditionConfig;
import cn.featherfly.hammer.expression.condition.ConditionConfigureExpression;
import cn.featherfly.hammer.expression.repository.condition.RepositoryConditionsGroupExpression;

/**
 * executable condition group expression,.
 *
 * @author zhongj
 */
public interface ExecutableConditionGroupExpression<C extends ExecutableConditionGroupExpression<C, L, C2>,
        L extends ExecutableConditionGroupLogicExpression<C, L, C2>, C2 extends ExecutableConditionConfig<C2>>
        extends RepositoryConditionsGroupExpression<C, L>, ConditionConfigureExpression<C, C2> {
}
