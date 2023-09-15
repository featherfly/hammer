
package cn.featherfly.hammer.expression.entity.execute;

import java.util.function.BooleanSupplier;
import java.util.function.Consumer;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableSupplier;

/**
 * EntityUpdateSetExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <U> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityUpdateSetExpression<E, U extends EntityUpdateSetExecutableExpression<E, U, C, L>,
        C extends EntityExecutableConditionGroupExpression<E, C, L>,
        L extends EntityExecutableConditionGroupLogicExpression<E, C, L>> {

    /**
     * Sets the.
     *
     * @param consumer the consumer
     * @return the u
     */
    U set(Consumer<EntityUpdateSetExpression<E, U, C, L>> consumer);

    /**
     * set value for property.
     *
     * @param <R>      the generic type
     * @param property the property
     * @param value    property value
     * @return Update
     */
    <R> U set(SerializableFunction<E, R> property, R value);

    /**
     * set value for property.
     *
     * @param <R>      the generic type
     * @param setable  the setable
     * @param property the property
     * @param value    property value
     * @return Update
     */
    <R> U set(BooleanSupplier setable, SerializableFunction<E, R> property, R value);

    /**
     * set value for property.
     *
     * @param <R>            the generic type
     * @param <O>            the generic type
     * @param property       the property
     * @param nestedProperty the nested property
     * @param value          property value
     * @return Update
     */
    <R, O> U set(SerializableFunction<E, R> property, SerializableFunction<R, O> nestedProperty, O value);

    /**
     * set value for property.
     *
     * @param <R>            the generic type
     * @param <O>            the generic type
     * @param setable        the setable
     * @param property       the property
     * @param nestedProperty the nested property
     * @param value          property value
     * @return Update
     */
    <R, O> U set(BooleanSupplier setable, SerializableFunction<E, R> property,
            SerializableFunction<R, O> nestedProperty, O value);

    /**
     * set value for property.
     *
     * @param <R>      the generic type
     * @param property object property
     * @return Update
     */
    <R> U set(SerializableSupplier<R> property);

    /**
     * set value for property.
     *
     * @param <R>      the generic type
     * @param setable  the setable
     * @param property the property
     * @return the u
     */
    <R> U set(BooleanSupplier setable, SerializableSupplier<R> property);

    /**
     * set value for property.
     *
     * @param <R>            the generic type
     * @param <O>            the generic type
     * @param property       object property
     * @param nestedProperty the nested property
     * @return Update
     */
    <R, O> U set(SerializableSupplier<R> property, SerializableFunction<R, O> nestedProperty);

    /**
     * set value for property.
     *
     * @param <R>            the generic type
     * @param <O>            the generic type
     * @param setable        the setable
     * @param property       object property
     * @param nestedProperty the nested property
     * @return Update
     */
    <R, O> U set(BooleanSupplier setable, SerializableSupplier<R> property, SerializableFunction<R, O> nestedProperty);

    /**
     * increase value for property.
     *
     * @param <R>      the generic number type
     * @param property the property name
     * @param value    property value
     * @return Update
     */
    <R extends Number> U increase(SerializableFunction<E, R> property, R value);

    /**
     * increase value for property.
     *
     * @param <R>          the generic number type
     * @param increaseable the increaseable
     * @param property     the property name
     * @param value        property value
     * @return Update
     */
    <R extends Number> U increase(BooleanSupplier increaseable, SerializableFunction<E, R> property, R value);

    /**
     * increase value for property.
     *
     * @param <N>      number type
     * @param property object property
     * @return Update
     */
    <N extends Number> U increase(SerializableSupplier<N> property);

    /**
     * increase value for property.
     *
     * @param <N>          number type
     * @param increaseable the increaseable
     * @param property     object property
     * @return Update
     */
    <N extends Number> U increase(BooleanSupplier increaseable, SerializableSupplier<N> property);
}
