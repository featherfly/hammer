
package cn.featherfly.hammer.dsl.entity.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.expression.entity.execute.EntityExecutableUpdateExpression;

/**
 * entity executable update.
 *
 * @author zhongj
 */
public interface EntityExecutableUpdate<E> extends
    EntityExecutableUpdateExpression<E, EntityExecutableUpdate<E>,
        EntityExecutableConditionGroup<E, UpdateConditionConfig>,
        EntityExecutableConditionGroupLogic<E, UpdateConditionConfig>> {
}
