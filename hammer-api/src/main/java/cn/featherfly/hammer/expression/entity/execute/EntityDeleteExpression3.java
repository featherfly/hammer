
package cn.featherfly.hammer.expression.entity.execute;

import cn.featherfly.hammer.config.dsl.DeleteConditionConfig;
import cn.featherfly.hammer.config.dsl.DeleteConfig;
import cn.featherfly.hammer.expression.ConfigureExpression;
import cn.featherfly.hammer.expression.entity.EntityWhereExpression3;

/**
 * The Interface EntityDeleteExpression3.
 *
 * @author zhongj
 * @param <E1> the generic type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityDeleteExpression3<E1, E2, E3,
    C extends EntityExecutableConditionGroupExpression3<E1, E2, E3, C, L, DeleteConditionConfig>,
    L extends EntityExecutableConditionGroupLogicExpression3<E1, E2, E3, C, L, DeleteConditionConfig>>
    extends EntityWhereExpression3<E1, E2, E3, C, L>,
    ConfigureExpression<EntityDeleteExpression3<E1, E2, E3, C, L>, DeleteConfig, DeleteConditionConfig> {
}
