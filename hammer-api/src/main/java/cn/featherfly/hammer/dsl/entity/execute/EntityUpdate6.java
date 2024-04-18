
package cn.featherfly.hammer.dsl.entity.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
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
 * @param <J5> the join type 5
 */
public interface EntityUpdate6<E, J1, J2, J3, J4, J5> extends
    EntityUpdateExpression<E, EntityExecutableUpdate6<E, J1, J2, J3, J4, J5>,
        EntityExecutableConditionGroup6<E, J1, J2, J3, J4, J5, UpdateConditionConfig>,
        EntityExecutableConditionGroupLogic6<E, J1, J2, J3, J4, J5, UpdateConditionConfig>> {
}
