
package cn.featherfly.hammer.expression.repository.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.expression.execute.Executor;
import cn.featherfly.hammer.expression.repository.RepositoryWhereExpression5;

/**
 * repository executable update set expression5.
 *
 * @author zhongj
 * @param <U> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryExecutableUpdateSetExpression5<U extends RepositoryExecutableUpdateSetExpression5<U, C, L>,
    C extends RepositoryExecutableConditionsGroupExpression5<C, L, UpdateConditionConfig>,
    L extends RepositoryExecutableConditionsGroupLogicExpression5<C, L, UpdateConditionConfig>>
    extends RepositoryWhereExpression5<C, L>, RepositoryUpdateSetExpression<U, C, L>, Executor {
}
