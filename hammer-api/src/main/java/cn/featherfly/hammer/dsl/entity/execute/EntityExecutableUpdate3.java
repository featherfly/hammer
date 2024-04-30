
package cn.featherfly.hammer.dsl.entity.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.expression.entity.execute.EntityExecutableUpdateExpression3;

/**
 * entity executable update.
 *
 * @author zhongj
 * @param <E>  the update type
 * @param <J1> the join type 1
 * @param <J2> the join type 2
 */
public interface EntityExecutableUpdate3<E, J1, J2> extends
    EntityExecutableUpdateExpression3<E, J1, J2, EntityExecutableUpdate3<E, J1, J2>,
        EntityExecutableConditionGroup3<E, J1, J2, UpdateConditionConfig>,
        EntityExecutableConditionGroupLogic3<E, J1, J2, UpdateConditionConfig>> {
}
