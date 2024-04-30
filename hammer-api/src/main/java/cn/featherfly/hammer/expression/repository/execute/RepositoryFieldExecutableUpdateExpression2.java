
package cn.featherfly.hammer.expression.repository.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.expression.execute.Executor;
import cn.featherfly.hammer.expression.repository.RepositoryWhereExpression2;

/**
 * repository field executable update expression2.
 *
 * @author zhongj
 * @param <U> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryFieldExecutableUpdateExpression2<
    U extends RepositoryFieldExecutableUpdateExpression2<U, C, L>,
    C extends RepositoryExecutableConditionsGroupExpression2<C, L, UpdateConditionConfig>,
    L extends RepositoryExecutableConditionsGroupLogicExpression2<C, L, UpdateConditionConfig>>
    extends RepositoryWhereExpression2<C, L>, RepositoryFieldUpdateExpression<U, C, L>, Executor {

}
