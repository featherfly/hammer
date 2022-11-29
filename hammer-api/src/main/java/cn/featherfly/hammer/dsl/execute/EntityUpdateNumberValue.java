
package cn.featherfly.hammer.dsl.execute;

import cn.featherfly.hammer.expression.execute.EntityUpdateNumberValueExpression;

/**
 * EntityUpdateNumberValue.
 *
 * @author zhongj
 */
public interface EntityUpdateNumberValue<E, T extends Number> extends EntityUpdateValue<E, T>,
        EntityUpdateNumberValueExpression<E, T, EntityExecutableUpdate<E>, EntityExecutableConditionGroupExpression<E>, EntityExecutableConditionGroupLogicExpression<E>> {

}
