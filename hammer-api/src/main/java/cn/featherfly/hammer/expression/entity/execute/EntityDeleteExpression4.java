
package cn.featherfly.hammer.expression.entity.execute;

import cn.featherfly.hammer.config.dsl.DeleteConditionConfig;
import cn.featherfly.hammer.config.dsl.DeleteConfig;
import cn.featherfly.hammer.expression.ConfigureExpression;
import cn.featherfly.hammer.expression.entity.EntityWhereExpression4;

/**
 * The Interface EntityDeleteExpression4.
 *
 * @author zhongj
 * @param <E1> the generic type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityDeleteExpression4<E1, E2, E3, E4,
    C extends EntityExecutableConditionGroupExpression4<E1, E2, E3, E4, C, L, DeleteConditionConfig>,
    L extends EntityExecutableConditionGroupLogicExpression4<E1, E2, E3, E4, C, L, DeleteConditionConfig>>
    extends EntityWhereExpression4<E1, E2, E3, E4, C, L>,
    ConfigureExpression<EntityDeleteExpression4<E1, E2, E3, E4, C, L>, DeleteConfig, DeleteConditionConfig> {
}
