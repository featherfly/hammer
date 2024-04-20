
package cn.featherfly.hammer.expression.repository.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;

/**
 * ExecutableUpdateExpression.
 *
 * @author zhongj
 */
public interface ExecutableUpdateExpression<U extends ExecutableUpdateExpression<U, C, L>,
    C extends ExecutableConditionGroupExpression<C, L, UpdateConditionConfig>,
    L extends ExecutableConditionGroupLogicExpression<C, L, UpdateConditionConfig>>
    extends RepositoryUpdateExpression<U, C, L>, FieldExecutableUpdateExpression<U, C, L>,
    ExecutableUpdateSetExpression<U, C, L> {

}
