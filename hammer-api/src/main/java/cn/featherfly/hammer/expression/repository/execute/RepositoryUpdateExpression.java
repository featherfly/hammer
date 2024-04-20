
package cn.featherfly.hammer.expression.repository.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.config.dsl.UpdateConfig;
import cn.featherfly.hammer.expression.ConfigureExpression;

/**
 * RepositoryUpdateExpression.
 *
 * @author zhongj
 * @param <U> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <V> the value type
 * @param <N> the number value type
 */
public interface RepositoryUpdateExpression<U extends ExecutableUpdateExpression<U, C, L>,
    C extends ExecutableConditionGroupExpression<C, L, UpdateConditionConfig>,
    L extends ExecutableConditionGroupLogicExpression<C, L, UpdateConditionConfig>>
    extends RepositoryFieldUpdateExpression<U, C, L>, RepositoryUpdateSetExpression<U, C, L>,
    ConfigureExpression<RepositoryUpdateExpression<U, C, L>, UpdateConfig, UpdateConditionConfig> {

}
