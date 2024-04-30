
package cn.featherfly.hammer.expression.repository.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;

/**
 * repository executable update expression6.
 *
 * @author zhongj
 * @param <U> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryExecutableUpdateExpression6<U extends RepositoryExecutableUpdateExpression6<U, C, L>,
    C extends RepositoryExecutableConditionsGroupExpression6<C, L, UpdateConditionConfig>,
    L extends RepositoryExecutableConditionsGroupLogicExpression6<C, L, UpdateConditionConfig>>
    extends RepositoryUpdateExpression<U, C, L>, RepositoryFieldExecutableUpdateExpression6<U, C, L>,
    RepositoryExecutableUpdateSetExpression6<U, C, L> {

}
