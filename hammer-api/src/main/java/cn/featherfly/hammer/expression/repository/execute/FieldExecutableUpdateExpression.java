
package cn.featherfly.hammer.expression.repository.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.expression.execute.Executor;
import cn.featherfly.hammer.expression.repository.RepositoryWhereExpression;

/**
 * The Interface FieldExecutableUpdateExpression.
 *
 * @author zhongj
 * @param <U> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <V> the value type
 * @param <N> the number value type
 */
public interface FieldExecutableUpdateExpression<U extends FieldExecutableUpdateExpression<U, C, L>,
    C extends ExecutableConditionGroupExpression<C, L, UpdateConditionConfig>,
    L extends ExecutableConditionGroupLogicExpression<C, L, UpdateConditionConfig>>
    extends RepositoryWhereExpression<C, L>, RepositoryFieldUpdateExpression<U, C, L>, Executor {

}
