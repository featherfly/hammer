
package cn.featherfly.hammer.dsl.entity.execute;

import cn.featherfly.hammer.config.dsl.DeleteConditionConfig;
import cn.featherfly.hammer.dsl.entity.EntityOnExpression4;
import cn.featherfly.hammer.expression.entity.execute.EntityDeleteExpression4;

/**
 * EntityDelete4.
 *
 * @author zhongj
 * @param <E1> the generic type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 */
public interface EntityDelete4<E1, E2, E3, E4> extends
    EntityDeleteExpression4<E1, E2, E3, E4, EntityExecutableConditionGroup4<E1, E2, E3, E4, DeleteConditionConfig>,
        EntityExecutableConditionGroupLogic4<E1, E2, E3, E4, DeleteConditionConfig>> {
    /**
     * Join.
     *
     * @param <R>      the generic type
     * @param joinType the join type
     * @return the entity on expression4
     */
    <R> EntityOnExpression4<E1, E2, E3, E4, R, EntityDelete5<E1, E2, E3, E4, R>> join(Class<R> joinType);
}
