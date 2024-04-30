
package cn.featherfly.hammer.dsl.entity.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.expression.entity.execute.EntityExecutableUpdateExpression5;

/**
 * entity executable update.
 *
 * @author zhongj
 * @param <E>  the update type
 * @param <J1> the join type 1
 * @param <J2> the join type 2
 * @param <J3> the join type 3
 * @param <J4> the join type 4
 */
public interface EntityExecutableUpdate5<E, J1, J2, J3, J4> extends
    EntityExecutableUpdateExpression5<E, J1, J2, J3, J4, EntityExecutableUpdate5<E, J1, J2, J3, J4>,
        EntityExecutableConditionGroup5<E, J1, J2, J3, J4, UpdateConditionConfig>,
        EntityExecutableConditionGroupLogic5<E, J1, J2, J3, J4, UpdateConditionConfig>> {
}
