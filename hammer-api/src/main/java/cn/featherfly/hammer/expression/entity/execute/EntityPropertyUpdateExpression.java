
package cn.featherfly.hammer.expression.entity.execute;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableToNumberFunction;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * EntityPropertyUpdateExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <U> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityPropertyUpdateExpression<E, U, C extends ConditionExpression, L extends LogicExpression<C, L>> {

    /**
     * Property.
     *
     * @param <R>      the generic type
     * @param property the property
     * @return the entity update value expression
     */
    <R> EntityUpdateValueExpression<R, U, C, L> property(SerializableFunction<E, R> property);

    /**
     * Property.
     *
     * @param <R>            the generic type
     * @param <O>            the generic type
     * @param property       the property
     * @param nestedProperty the nested property
     * @return the entity update value expression
     */
    <R, O> EntityUpdateValueExpression<O, U, C, L> property(SerializableFunction<E, R> property,
        SerializableFunction<R, O> nestedProperty);

    /**
     * Property.
     *
     * @param <R>      the generic type
     * @param property the property
     * @return the entity update number value expression
     */
    <R extends Number> EntityUpdateNumberValueExpression<R, U, C, L> property(
        SerializableToNumberFunction<E, R> property);
}
