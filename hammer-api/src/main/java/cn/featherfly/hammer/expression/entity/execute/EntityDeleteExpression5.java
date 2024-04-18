
package cn.featherfly.hammer.expression.entity.execute;

import cn.featherfly.hammer.config.dsl.DeleteConditionConfig;
import cn.featherfly.hammer.config.dsl.DeleteConfig;
import cn.featherfly.hammer.expression.ConfigureExpression;
import cn.featherfly.hammer.expression.entity.EntityWhereExpression5;

/**
 * The Interface EntityDeleteExpression5.
 *
 * @author zhongj
 * @param <E1> the generic type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <E5> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityDeleteExpression5<E1, E2, E3, E4, E5,
    C extends EntityExecutableConditionGroupExpression5<E1, E2, E3, E4, E5, C, L, DeleteConditionConfig>,
    L extends EntityExecutableConditionGroupLogicExpression5<E1, E2, E3, E4, E5, C, L, DeleteConditionConfig>>
    extends EntityWhereExpression5<E1, E2, E3, E4, E5, C, L>,
    ConfigureExpression<EntityDeleteExpression5<E1, E2, E3, E4, E5, C, L>, DeleteConfig, DeleteConditionConfig> {
}
