
package cn.featherfly.hammer.dsl.entity.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.dsl.entity.EntityOnExpression3;
import cn.featherfly.hammer.expression.entity.execute.EntityUpdateExpression;

/**
 * EntityUpdate.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <J1> the join type 1
 * @param <J2> the join type 2
 */
public interface EntityUpdate3<E, J1, J2> extends
    EntityUpdateExpression<E, EntityExecutableUpdate3<E, J1, J2>,
        EntityExecutableConditionGroup3<E, J1, J2, UpdateConditionConfig>,
        EntityExecutableConditionGroupLogic3<E, J1, J2, UpdateConditionConfig>> {
    /**
     * Join.
     *
     * @param <J>      the generic type
     * @param joinType the join type
     * @return the entity on expression1
     */
    <J> EntityOnExpression3<E, J1, J2, J, EntityUpdate4<E, J1, J2, J>> join(Class<J> joinType);
}
