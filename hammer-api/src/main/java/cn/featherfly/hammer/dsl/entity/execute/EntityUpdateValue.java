
package cn.featherfly.hammer.dsl.entity.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.expression.entity.execute.EntityUpdateValueExpression;

/**
 * EntityUpdateValue.
 *
 * @author zhongj
 */
public interface EntityUpdateValue<E, T> extends
        EntityUpdateValueExpression<E, T, EntityExecutableUpdate<E>,
                EntityExecutableConditionGroup<E, UpdateConditionConfig>,
                EntityExecutableConditionGroupLogic<E, UpdateConditionConfig>> {

}
