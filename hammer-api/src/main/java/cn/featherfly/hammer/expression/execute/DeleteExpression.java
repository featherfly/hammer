
package cn.featherfly.hammer.expression.execute;

import cn.featherfly.hammer.config.dsl.DeleteConditionConfig;
import cn.featherfly.hammer.config.dsl.DeleteConfig;
import cn.featherfly.hammer.expression.ConfigureExpression;
import cn.featherfly.hammer.expression.WhereExpression;

/**
 * DeleteExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface DeleteExpression<C extends ExecutableConditionGroupExpression<C, L, DeleteConditionConfig>,
        L extends ExecutableConditionGroupLogicExpression<C, L, DeleteConditionConfig>> extends WhereExpression<C, L>,
        ConfigureExpression<DeleteExpression<C, L>, DeleteConfig, DeleteConditionConfig> {
}
