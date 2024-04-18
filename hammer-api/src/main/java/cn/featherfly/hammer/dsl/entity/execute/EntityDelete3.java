
package cn.featherfly.hammer.dsl.entity.execute;

import cn.featherfly.hammer.config.dsl.DeleteConditionConfig;
import cn.featherfly.hammer.dsl.entity.EntityOnExpression3;
import cn.featherfly.hammer.expression.entity.execute.EntityDeleteExpression3;

/**
 * EntityDelete3.
 *
 * @author zhongj
 * @param <E1> the generic type
 * @param <E2> the generic type
 * @param <E3> the generic type
 */
public interface EntityDelete3<E1, E2, E3>
    extends EntityDeleteExpression3<E1, E2, E3, EntityExecutableConditionGroup3<E1, E2, E3, DeleteConditionConfig>,
        EntityExecutableConditionGroupLogic3<E1, E2, E3, DeleteConditionConfig>> {
    /**
     * Join.
     *
     * @param <R>      the generic type
     * @param joinType the join type
     * @return the entity on expression3
     */
    <R> EntityOnExpression3<E1, E2, E3, R, EntityDelete4<E1, E2, E3, R>> join(Class<R> joinType);
}
