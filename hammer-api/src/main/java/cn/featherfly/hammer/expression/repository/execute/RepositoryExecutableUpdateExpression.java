
package cn.featherfly.hammer.expression.repository.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;

/**
 * ExecutableUpdateExpression.
 *
 * @author zhongj
 */
public interface RepositoryExecutableUpdateExpression<U extends RepositoryExecutableUpdateExpression<U, C, L>,
    C extends RepositoryExecutableConditionsGroupExpression<C, L, UpdateConditionConfig>,
    L extends RepositoryExecutableConditionsGroupLogicExpression<C, L, UpdateConditionConfig>>
    extends RepositoryUpdateExpression<U, C, L>, FieldExecutableUpdateExpression<U, C, L>,
    ExecutableUpdateSetExpression<U, C, L> {

}
