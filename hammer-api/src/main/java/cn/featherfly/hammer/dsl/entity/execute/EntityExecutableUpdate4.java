
package cn.featherfly.hammer.dsl.entity.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.expression.entity.execute.EntityExecutableUpdateExpression4;

/**
 * entity executable update.
 *
 * @author zhongj
 * @param <E>  the update type
 * @param <J1> the join type 1
 * @param <J2> the join type 2
 * @param <J3> the join type 3
 */
public interface EntityExecutableUpdate4<E, J1, J2, J3> extends EntityPropertyExecutableUpdate4<E, J1, J2, J3>,
    EntityExecutableUpdateExpression4<E, J1, J2, J3, EntityExecutableUpdate4<E, J1, J2, J3>,
        EntityExecutableConditionGroup4<E, J1, J2, J3, UpdateConditionConfig>,
        EntityExecutableConditionGroupLogic4<E, J1, J2, J3, UpdateConditionConfig>> {
}
