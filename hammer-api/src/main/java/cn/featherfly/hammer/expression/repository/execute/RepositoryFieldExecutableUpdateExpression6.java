
package cn.featherfly.hammer.expression.repository.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.expression.execute.Executor;
import cn.featherfly.hammer.expression.repository.RepositoryWhereExpression6;

/**
 * repository field executable update expression6.
 *
 * @author zhongj
 * @param <U> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryFieldExecutableUpdateExpression6<
    U extends RepositoryFieldExecutableUpdateExpression6<U, C, L>,
    C extends RepositoryExecutableConditionsGroupExpression6<C, L, UpdateConditionConfig>,
    L extends RepositoryExecutableConditionsGroupLogicExpression6<C, L, UpdateConditionConfig>>
    extends RepositoryWhereExpression6<C, L>, RepositoryFieldUpdateExpression<U, C, L>, Executor {

}
