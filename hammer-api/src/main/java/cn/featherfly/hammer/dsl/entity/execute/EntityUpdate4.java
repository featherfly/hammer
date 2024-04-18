
package cn.featherfly.hammer.dsl.entity.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.dsl.entity.EntityOnExpression4;
import cn.featherfly.hammer.expression.entity.execute.EntityUpdateExpression;

/**
 * EntityUpdate.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <J1> the join type 1
 * @param <J2> the join type 2
 * @param <J3> the join type 3
 */
public interface EntityUpdate4<E, J1, J2, J3> extends
    EntityUpdateExpression<E, EntityExecutableUpdate4<E, J1, J2, J3>,
        EntityExecutableConditionGroup4<E, J1, J2, J3, UpdateConditionConfig>,
        EntityExecutableConditionGroupLogic4<E, J1, J2, J3, UpdateConditionConfig>> {
    /**
     * Join.
     *
     * @param <J>      the generic type
     * @param joinType the join type
     * @return the entity on expression1
     */
    <J> EntityOnExpression4<E, J1, J2, J3, J, EntityUpdate5<E, J1, J2, J3, J>> join(Class<J> joinType);
}
