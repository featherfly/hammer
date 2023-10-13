
package cn.featherfly.hammer.expression.entity.execute;

import cn.featherfly.hammer.config.dsl.DeleteConditionConfig;
import cn.featherfly.hammer.config.dsl.DeleteConfig;
import cn.featherfly.hammer.expression.ConfigureExpression;
import cn.featherfly.hammer.expression.entity.EntityWhereExpression;

/**
 * The Interface EntityDeleteExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityDeleteExpression<E,
        C extends EntityExecutableConditionGroupExpression<E, C, L, DeleteConditionConfig>,
        L extends EntityExecutableConditionGroupLogicExpression<E, C, L, DeleteConditionConfig>>
        extends EntityWhereExpression<E, C, L>,
        ConfigureExpression<EntityDeleteExpression<E, C, L>, DeleteConfig, DeleteConditionConfig> {
}
