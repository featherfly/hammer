
package cn.featherfly.hammer.dsl.entity.execute;

import cn.featherfly.hammer.config.dsl.ExecutableConditionConfig;
import cn.featherfly.hammer.expression.entity.execute.EntityExecutableConditionGroupLogicExpression;

/**
 * entity executable condition group logic.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 */
public interface EntityExecutableConditionGroupLogic<E, C extends ExecutableConditionConfig<C>>
    extends EntityExecutableConditionGroupLogicExpression<E, EntityExecutableConditionGroup<E, C>,
        EntityExecutableConditionGroupLogic<E, C>, C> {

}
