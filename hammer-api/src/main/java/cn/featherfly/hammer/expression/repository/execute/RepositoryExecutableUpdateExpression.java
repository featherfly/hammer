
package cn.featherfly.hammer.expression.repository.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;

/**
 * ExecutableUpdateExpression.
 *
 * @author zhongj
 * @param <U> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryExecutableUpdateExpression<U extends RepositoryExecutableUpdateExpression<U, C, L>,
    C extends RepositoryExecutableConditionsGroupExpression<C, L, UpdateConditionConfig>,
    L extends RepositoryExecutableConditionsGroupLogicExpression<C, L, UpdateConditionConfig>>
    extends RepositoryUpdateExpression<U, C, L>, RepositoryFieldExecutableUpdateExpression<U, C, L>,
    RepositoryExecutableUpdateSetExpression<U, C, L> {
}
