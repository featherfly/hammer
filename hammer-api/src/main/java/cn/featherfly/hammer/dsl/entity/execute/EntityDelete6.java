
package cn.featherfly.hammer.dsl.entity.execute;

import cn.featherfly.hammer.config.dsl.DeleteConditionConfig;
import cn.featherfly.hammer.expression.entity.execute.EntityDeleteExpression6;

/**
 * EntityDelete6.
 *
 * @author zhongj
 * @param <E1> the generic type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <E5> the generic type
 * @param <E6> the generic type
 */
public interface EntityDelete6<E1, E2, E3, E4, E5, E6> extends
    EntityDeleteExpression6<E1, E2, E3, E4, E5, E6,
        EntityExecutableConditionGroup6<E1, E2, E3, E4, E5, E6, DeleteConditionConfig>,
        EntityExecutableConditionGroupLogic6<E1, E2, E3, E4, E5, E6, DeleteConditionConfig>> {
}
