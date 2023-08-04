
package cn.featherfly.hammer.dsl.execute;

import cn.featherfly.hammer.expression.entity.execute.EntityUpdateValueExpression;

/**
 * EntityUpdateValue.
 *
 * @author zhongj
 */
public interface EntityUpdateValue<E, T> extends
        EntityUpdateValueExpression<E, T, EntityExecutableUpdate<E>, EntityExecutableConditionGroupExpression<E>, EntityExecutableConditionGroupLogicExpression<E>> {

}
