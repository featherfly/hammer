
package cn.featherfly.hammer.dsl.entity.execute;

import cn.featherfly.hammer.expression.entity.execute.EntityExecutableUpdateExpression;

/**
 * entity executable update.
 *
 * @author zhongj
 */
public interface EntityExecutableUpdate<E> extends EntityPropertyExecutableUpdate<E>,
        EntityExecutableUpdateExpression<E, EntityExecutableUpdate<E>, EntityExecutableConditionGroup<E>, EntityExecutableConditionGroupLogic<E>> {
}
