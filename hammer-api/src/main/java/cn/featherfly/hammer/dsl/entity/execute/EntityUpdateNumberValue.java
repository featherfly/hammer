
package cn.featherfly.hammer.dsl.entity.execute;

import cn.featherfly.hammer.expression.entity.execute.EntityUpdateNumberValueExpression;

/**
 * EntityUpdateNumberValue.
 *
 * @author zhongj
 */
public interface EntityUpdateNumberValue<E, T extends Number> extends EntityUpdateValue<E, T>,
        EntityUpdateNumberValueExpression<E, T, EntityExecutableUpdate<E>, EntityExecutableConditionGroup<E>, EntityExecutableConditionGroupLogic<E>> {

}
