
package cn.featherfly.hammer.dsl.entity.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.dsl.entity.EntityOnExpression5;
import cn.featherfly.hammer.expression.entity.execute.EntityUpdateExpression;

/**
 * EntityUpdate.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <J1> the join type 1
 * @param <J2> the join type 2
 * @param <J3> the join type 3
 * @param <J4> the join type 4
 */
public interface EntityUpdate5<E, J1, J2, J3, J4> extends
    EntityUpdateExpression<E, EntityExecutableUpdate5<E, J1, J2, J3, J4>,
        EntityExecutableConditionGroup5<E, J1, J2, J3, J4, UpdateConditionConfig>,
        EntityExecutableConditionGroupLogic5<E, J1, J2, J3, J4, UpdateConditionConfig>> {
    /**
     * Join.
     *
     * @param <J>      the generic type
     * @param joinType the join type
     * @return the entity on expression1
     */
    <J> EntityOnExpression5<E, J1, J2, J3, J4, J, EntityUpdate6<E, J1, J2, J3, J4, J>> join(Class<J> joinType);
}
