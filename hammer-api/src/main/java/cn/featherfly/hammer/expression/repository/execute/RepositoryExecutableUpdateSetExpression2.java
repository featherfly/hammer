
package cn.featherfly.hammer.expression.repository.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.expression.execute.Executor;
import cn.featherfly.hammer.expression.repository.RepositoryWhereExpression2;

/**
 * repository executable update set expression2.
 *
 * @author zhongj
 * @param <U> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryExecutableUpdateSetExpression2<U extends RepositoryExecutableUpdateSetExpression2<U, C, L>,
    C extends RepositoryExecutableConditionsGroupExpression2<C, L, UpdateConditionConfig>,
    L extends RepositoryExecutableConditionsGroupLogicExpression2<C, L, UpdateConditionConfig>>
    extends RepositoryWhereExpression2<C, L>, RepositoryUpdateSetExpression<U, C, L>, Executor {
}
