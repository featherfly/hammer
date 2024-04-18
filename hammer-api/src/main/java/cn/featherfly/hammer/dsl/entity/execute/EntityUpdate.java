
package cn.featherfly.hammer.dsl.entity.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.dsl.entity.EntityOnExpression1;
import cn.featherfly.hammer.expression.entity.execute.EntityUpdateExpression;

/**
 * EntityUpdate.
 *
 * @author zhongj
 */
public interface EntityUpdate<E> extends
    EntityUpdateExpression<E, EntityExecutableUpdate<E>, EntityExecutableConditionGroup<E, UpdateConditionConfig>,
        EntityExecutableConditionGroupLogic<E, UpdateConditionConfig>> {

    /**
     * Join.
     *
     * @param <J>      the generic type
     * @param joinType the join type
     * @return the entity on expression1
     */
    <J> EntityOnExpression1<E, J, EntityUpdate2<E, J>> join(Class<J> joinType);
}
