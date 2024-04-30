
package cn.featherfly.hammer.expression.repository.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;

/**
 * repository executable update expression5.
 *
 * @author zhongj
 * @param <U> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryExecutableUpdateExpression5<U extends RepositoryExecutableUpdateExpression5<U, C, L>,
    C extends RepositoryExecutableConditionsGroupExpression5<C, L, UpdateConditionConfig>,
    L extends RepositoryExecutableConditionsGroupLogicExpression5<C, L, UpdateConditionConfig>>
    extends RepositoryUpdateExpression<U, C, L>, RepositoryFieldExecutableUpdateExpression5<U, C, L>,
    RepositoryExecutableUpdateSetExpression5<U, C, L> {

}
