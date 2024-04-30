
package cn.featherfly.hammer.expression.repository.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.expression.execute.Executor;
import cn.featherfly.hammer.expression.repository.RepositoryWhereExpression3;

/**
 * repository field executable update expression3.
 *
 * @author zhongj
 * @param <U> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryFieldExecutableUpdateExpression3<
    U extends RepositoryFieldExecutableUpdateExpression3<U, C, L>,
    C extends RepositoryExecutableConditionsGroupExpression3<C, L, UpdateConditionConfig>,
    L extends RepositoryExecutableConditionsGroupLogicExpression3<C, L, UpdateConditionConfig>>
    extends RepositoryWhereExpression3<C, L>, RepositoryFieldUpdateExpression<U, C, L>, Executor {

}
