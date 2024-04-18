
package cn.featherfly.hammer.expression.entity.execute;

import cn.featherfly.hammer.config.dsl.DeleteConditionConfig;
import cn.featherfly.hammer.config.dsl.DeleteConfig;
import cn.featherfly.hammer.expression.ConfigureExpression;
import cn.featherfly.hammer.expression.entity.EntityWhereExpression6;

/**
 * The Interface EntityDeleteExpression.
 *
 * @author zhongj
 * @param <E1> the generic type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <E5> the generic type
 * @param <E6> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityDeleteExpression6<E1, E2, E3, E4, E5, E6,
    C extends EntityExecutableConditionGroupExpression6<E1, E2, E3, E4, E5, E6, C, L, DeleteConditionConfig>,
    L extends EntityExecutableConditionGroupLogicExpression6<E1, E2, E3, E4, E5, E6, C, L, DeleteConditionConfig>>
    extends EntityWhereExpression6<E1, E2, E3, E4, E5, E6, C, L>,
    ConfigureExpression<EntityDeleteExpression6<E1, E2, E3, E4, E5, E6, C, L>, DeleteConfig, DeleteConditionConfig> {
}
