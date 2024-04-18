
package cn.featherfly.hammer.dsl.entity.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.expression.entity.execute.EntityPropertyExecutableUpdateExpression3;

/**
 * entity property executable update.
 *
 * @author zhongj
 * @param <E>  the update type
 * @param <J1> the join type 1
 * @param <J2> the join type 2
 */
public interface EntityPropertyExecutableUpdate3<E, J1, J2> extends
    EntityPropertyExecutableUpdateExpression3<E, J1, J2, EntityExecutableUpdate3<E, J1, J2>,
        EntityExecutableConditionGroup3<E, J1, J2, UpdateConditionConfig>,
        EntityExecutableConditionGroupLogic3<E, J1, J2, UpdateConditionConfig>> {
}
