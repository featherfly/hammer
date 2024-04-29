
package cn.featherfly.hammer.expression.repository.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.expression.execute.Executor;
import cn.featherfly.hammer.expression.repository.RepositoryWhereExpression;

/**
 * SetExecutableUpdateExpression.
 *
 * @author zhongj
 */
public interface ExecutableUpdateSetExpression<U extends ExecutableUpdateSetExpression<U, C, L>,
        C extends RepositoryExecutableConditionsGroupExpression<C, L, UpdateConditionConfig>,
        L extends RepositoryExecutableConditionsGroupLogicExpression<C, L, UpdateConditionConfig>>
        extends RepositoryWhereExpression<C, L>, RepositoryUpdateSetExpression<U, C, L>, Executor {
}
