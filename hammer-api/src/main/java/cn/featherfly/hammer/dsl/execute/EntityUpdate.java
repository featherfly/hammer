
package cn.featherfly.hammer.dsl.execute;

import cn.featherfly.hammer.expression.entity.execute.EntityUpdateExpression;

/**
 * EntityUpdate.
 *
 * @author zhongj
 */
public interface EntityUpdate<E> extends
        EntityUpdateExpression<E, EntityExecutableUpdate<E>, EntityExecutableConditionGroupExpression<E>, EntityExecutableConditionGroupLogicExpression<E>> {

}
