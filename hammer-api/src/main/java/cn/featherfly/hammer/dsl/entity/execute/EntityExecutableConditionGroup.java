
package cn.featherfly.hammer.dsl.entity.execute;

import cn.featherfly.hammer.config.dsl.ExecutableConditionConfig;
import cn.featherfly.hammer.expression.entity.execute.EntityExecutableConditionGroupExpression;

/**
 * entity executable condition group.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 */
public interface EntityExecutableConditionGroup<E, C extends ExecutableConditionConfig<C>>
    extends EntityExecutableConditionGroupExpression<E, EntityExecutableConditionGroup<E, C>,
        EntityExecutableConditionGroupLogic<E, C>, C> {
}
