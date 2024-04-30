
package cn.featherfly.hammer.expression.repository.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.expression.execute.Executor;
import cn.featherfly.hammer.expression.repository.RepositoryWhereExpression;

/**
 * repository executable update set expression.
 *
 * @author zhongj
 * @param <U> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryExecutableUpdateSetExpression<U extends RepositoryExecutableUpdateSetExpression<U, C, L>,
    C extends RepositoryExecutableConditionsGroupExpression<C, L, UpdateConditionConfig>,
    L extends RepositoryExecutableConditionsGroupLogicExpression<C, L, UpdateConditionConfig>>
    extends RepositoryWhereExpression<C, L>, RepositoryUpdateSetExpression<U, C, L>, Executor {
}
