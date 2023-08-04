
package cn.featherfly.hammer.dsl.execute;

import cn.featherfly.hammer.expression.entity.EntityConditionGroupExpression;

/**
 * entity executable condition group expression,.
 *
 * @author zhongj
 */
public interface EntityExecutableConditionGroupExpression<E> extends
        EntityConditionGroupExpression<E, EntityExecutableConditionGroupExpression<E>, EntityExecutableConditionGroupLogicExpression<E>> {
}
