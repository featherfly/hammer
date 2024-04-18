
package cn.featherfly.hammer.dsl.entity.execute;

import cn.featherfly.hammer.config.dsl.DeleteConditionConfig;
import cn.featherfly.hammer.dsl.entity.EntityOnExpression2;
import cn.featherfly.hammer.expression.entity.execute.EntityDeleteExpression2;

/**
 * EntityDelete2.
 *
 * @author zhongj
 * @param <E1> the generic type
 * @param <E2> the generic type
 */
public interface EntityDelete2<E1, E2>
    extends EntityDeleteExpression2<E1, E2, EntityExecutableConditionGroup2<E1, E2, DeleteConditionConfig>,
        EntityExecutableConditionGroupLogic2<E1, E2, DeleteConditionConfig>> {
    /**
     * Join.
     *
     * @param <J>      the generic type
     * @param joinType the join type
     * @return the entity on expression2
     */
    <J> EntityOnExpression2<E1, E2, J, EntityDelete3<E1, E2, J>> join(Class<J> joinType);
}
