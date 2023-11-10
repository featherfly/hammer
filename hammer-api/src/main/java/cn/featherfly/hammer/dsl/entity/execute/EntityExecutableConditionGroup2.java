
package cn.featherfly.hammer.dsl.entity.execute;

import cn.featherfly.hammer.config.dsl.ExecutableConditionConfig;
import cn.featherfly.hammer.expression.entity.execute.EntityExecutableConditionGroupExpression2;

/**
 * entity executable condition group.
 *
 * @author zhongj
 */
public interface EntityExecutableConditionGroup2<E1, E2, C extends ExecutableConditionConfig<C>>
    extends EntityExecutableConditionGroupExpression2<E1, E2, EntityExecutableConditionGroup2<E1, E2, C>,
        EntityExecutableConditionGroupLogic2<E1, E2, C>, C> {
}
