
package cn.featherfly.hammer.dsl.execute;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableFunction2;
import cn.featherfly.hammer.expression.execute.EntityPropertyUpdateExpression;

/**
 * entity property update.
 *
 * @author zhongj
 */
public interface EntityPropertyUpdate<E> extends
        EntityPropertyUpdateExpression<E, EntityExecutableUpdate<E>, EntityExecutableConditionGroupExpression<E>, EntityExecutableConditionGroupLogicExpression<E>> {

    /**
     * {@inheritDoc}
     */
    @Override
    <R> EntityUpdateValue<E, R> property(SerializableFunction<E, R> name);

    /**
     * {@inheritDoc}
     */
    @Override
    <R extends Number> EntityUpdateNumberValue<E, R> property(SerializableFunction2<E, R> name);
}
