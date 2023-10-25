
package cn.featherfly.hammer.dsl.entity.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.expression.entity.execute.EntityPropertyExecutableUpdateExpression;

/**
 * entity property executable update.
 *
 * @author zhongj
 */
public interface EntityPropertyExecutableUpdate<E> extends
        EntityPropertyExecutableUpdateExpression<E, EntityExecutableUpdate<E>,
                EntityExecutableConditionGroup<E, UpdateConditionConfig>,
                EntityExecutableConditionGroupLogic<E, UpdateConditionConfig>> {
}
