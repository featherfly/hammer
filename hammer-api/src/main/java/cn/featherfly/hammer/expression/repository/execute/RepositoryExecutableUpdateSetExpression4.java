
package cn.featherfly.hammer.expression.repository.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.expression.execute.Executor;
import cn.featherfly.hammer.expression.repository.RepositoryWhereExpression4;

/**
 * repository executable update set expression4.
 *
 * @author zhongj
 * @param <U> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryExecutableUpdateSetExpression4<U extends RepositoryExecutableUpdateSetExpression4<U, C, L>,
    C extends RepositoryExecutableConditionsGroupExpression4<C, L, UpdateConditionConfig>,
    L extends RepositoryExecutableConditionsGroupLogicExpression4<C, L, UpdateConditionConfig>>
    extends RepositoryWhereExpression4<C, L>, RepositoryUpdateSetExpression<U, C, L>, Executor {
}
