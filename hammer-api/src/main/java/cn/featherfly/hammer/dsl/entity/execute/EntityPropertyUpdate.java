
package cn.featherfly.hammer.dsl.entity.execute;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableToNumberFunction;
import cn.featherfly.hammer.expression.entity.execute.EntityPropertyUpdateExpression;

/**
 * entity property update.
 *
 * @author zhongj
 */
public interface EntityPropertyUpdate<E> extends EntityPropertyUpdateExpression<E, EntityExecutableUpdate<E>,
        EntityExecutableConditionGroup<E>, EntityExecutableConditionGroupLogic<E>> {

    /**
     * {@inheritDoc}
     */
    @Override
    <R> EntityUpdateValue<E, R> property(SerializableFunction<E, R> name);

    /**
     * {@inheritDoc}
     */
    @Override
    <R extends Number> EntityUpdateNumberValue<E, R> property(SerializableToNumberFunction<E, R> name);
}
