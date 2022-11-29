
package cn.featherfly.hammer.dsl.execute;

import cn.featherfly.hammer.expression.execute.EntityPropertyExecutableUpdateExpression;

/**
 * entity property executable update.
 *
 * @author zhongj
 */
public interface EntityPropertyExecutableUpdate<E> extends
        EntityPropertyExecutableUpdateExpression<E, EntityExecutableUpdate<E>, EntityExecutableConditionGroupExpression<E>, EntityExecutableConditionGroupLogicExpression<E>> {
}
