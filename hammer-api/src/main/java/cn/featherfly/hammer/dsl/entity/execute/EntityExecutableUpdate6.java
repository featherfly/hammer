
package cn.featherfly.hammer.dsl.entity.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.expression.entity.execute.EntityExecutableUpdateExpression6;

/**
 * entity executable update.
 *
 * @author zhongj
 * @param <E>  the update type
 * @param <J1> the join type 1
 * @param <J2> the join type 2
 * @param <J3> the join type 3
 * @param <J4> the join type 4
 * @param <J5> the join type 5
 */
public interface EntityExecutableUpdate6<E, J1, J2, J3, J4, J5>
    extends EntityPropertyExecutableUpdate6<E, J1, J2, J3, J4, J5>,
    EntityExecutableUpdateExpression6<E, J1, J2, J3, J4, J5, EntityExecutableUpdate6<E, J1, J2, J3, J4, J5>,
        EntityExecutableConditionGroup6<E, J1, J2, J3, J4, J5, UpdateConditionConfig>,
        EntityExecutableConditionGroupLogic6<E, J1, J2, J3, J4, J5, UpdateConditionConfig>> {
}
