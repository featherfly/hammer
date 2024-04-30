
package cn.featherfly.hammer.expression.repository.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;

/**
 * repository executable update expression3.
 *
 * @author zhongj
 * @param <U> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryExecutableUpdateExpression3<U extends RepositoryExecutableUpdateExpression3<U, C, L>,
    C extends RepositoryExecutableConditionsGroupExpression3<C, L, UpdateConditionConfig>,
    L extends RepositoryExecutableConditionsGroupLogicExpression3<C, L, UpdateConditionConfig>>
    extends RepositoryUpdateExpression<U, C, L>, RepositoryFieldExecutableUpdateExpression3<U, C, L>,
    RepositoryExecutableUpdateSetExpression3<U, C, L> {

}
