
package cn.featherfly.hammer.dsl.entity.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.expression.entity.execute.EntityExecutableUpdateExpression2;

/**
 * entity executable update.
 *
 * @author zhongj
 * @param <E>  the update type
 * @param <J1> the join type 1
 */
public interface EntityExecutableUpdate2<E, J1> extends EntityPropertyExecutableUpdate2<E, J1>,
    EntityExecutableUpdateExpression2<E, J1, EntityExecutableUpdate2<E, J1>,
        EntityExecutableConditionGroup2<E, J1, UpdateConditionConfig>,
        EntityExecutableConditionGroupLogic2<E, J1, UpdateConditionConfig>> {
}
