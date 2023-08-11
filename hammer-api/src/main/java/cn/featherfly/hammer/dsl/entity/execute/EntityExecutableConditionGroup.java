
package cn.featherfly.hammer.dsl.entity.execute;

import cn.featherfly.hammer.expression.entity.execute.EntityExecutableConditionGroupExpression;

/**
 * entity executable condition group.
 *
 * @author zhongj
 */
public interface EntityExecutableConditionGroup<E> extends EntityExecutableConditionGroupExpression<E,
        EntityExecutableConditionGroup<E>, EntityExecutableConditionGroupLogic<E>> {
}
