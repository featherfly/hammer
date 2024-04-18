
package cn.featherfly.hammer.dsl.entity.execute;

import cn.featherfly.hammer.config.dsl.DeleteConditionConfig;
import cn.featherfly.hammer.dsl.entity.EntityOnExpression5;
import cn.featherfly.hammer.expression.entity.execute.EntityDeleteExpression5;

/**
 * EntityDelete5.
 *
 * @author zhongj
 * @param <E1> the generic type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <E5> the generic type
 */
public interface EntityDelete5<E1, E2, E3, E4, E5> extends
    EntityDeleteExpression5<E1, E2, E3, E4, E5,
        EntityExecutableConditionGroup5<E1, E2, E3, E4, E5, DeleteConditionConfig>,
        EntityExecutableConditionGroupLogic5<E1, E2, E3, E4, E5, DeleteConditionConfig>> {
    /**
     * Join.
     *
     * @param <R>      the generic type
     * @param joinType the join type
     * @return the entity on expression5
     */
    <R> EntityOnExpression5<E1, E2, E3, E4, E5, R, EntityDelete6<E1, E2, E3, E4, E5, R>> join(Class<R> joinType);
}
