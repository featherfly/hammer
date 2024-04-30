
package cn.featherfly.hammer.expression.repository.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;

/**
 * repository executable update expression4.
 *
 * @author zhongj
 * @param <U> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryExecutableUpdateExpression4<U extends RepositoryExecutableUpdateExpression4<U, C, L>,
    C extends RepositoryExecutableConditionsGroupExpression4<C, L, UpdateConditionConfig>,
    L extends RepositoryExecutableConditionsGroupLogicExpression4<C, L, UpdateConditionConfig>>
    extends RepositoryUpdateExpression<U, C, L>, RepositoryFieldExecutableUpdateExpression4<U, C, L>,
    RepositoryExecutableUpdateSetExpression4<U, C, L> {

}
