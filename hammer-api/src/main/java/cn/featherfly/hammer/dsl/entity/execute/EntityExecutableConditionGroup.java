
package cn.featherfly.hammer.dsl.entity.execute;

import cn.featherfly.hammer.config.dsl.ExecutableConditionConfig;
import cn.featherfly.hammer.expression.entity.execute.EntityExecutableConditionGroupExpression;

/**
 * entity executable condition group.
 *
 * @author zhongj
 */
public interface EntityExecutableConditionGroup<E, C extends ExecutableConditionConfig<C>>
        extends EntityExecutableConditionGroupExpression<E, EntityExecutableConditionGroup<E, C>,
                EntityExecutableConditionGroupLogic<E, C>, C> {
}
