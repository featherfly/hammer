
package cn.featherfly.hammer.expression.entity.execute;

import java.io.Serializable;
import java.util.function.Consumer;
import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableNumberSupplier;
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * EntityUpdateSetExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <U> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityUpdateSetExpression<E, U, C extends ConditionExpression, L extends LogicExpression<C, L>> {

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
     * @param <R> the generic type
     * @param property the property
     * @param value property value
     * @return Update
     */
    <R extends Serializable> U set(SerializableFunction<E, R> property, R value);

    /**
     * set value for property.
     *
     * @param <R> the generic type
     * @param property the property
     * @param value property value
     * @param ignoreStrategy the ignore strategy
     * @return Update
     */
    <R extends Serializable> U set(SerializableFunction<E, R> property, R value, Predicate<R> ignoreStrategy);

    /**
     * set value for property.
     *
     * @param <R> the generic type
     * @param property the property
     * @param value property value
     * @param ignoreStrategy the ignore strategy
     * @return Update
     */
    default <R extends Serializable> U set(SerializableFunction<E, R> property, R value,
        IgnoreStrategy ignoreStrategy) {
        return set(property, value, ignoreStrategy::test);
    }

    /**
     * set value for property.
     *
     * @param <R> the generic type
     * @param <O> the generic type
     * @param property the property
     * @param nestedProperty the nested property
     * @param value property value
     * @return Update
     */
    <R, O extends Serializable> U set(SerializableFunction<E, R> property, SerializableFunction<R, O> nestedProperty,
        O value);

    /**
     * set value for property.
     *
     * @param <R> the generic type
     * @param <O> the generic type
     * @param property the property
     * @param nestedProperty the nested property
     * @param value property value
     * @param ignoreStrategy the ignore strategy
     * @return Update
     */
    <R, O extends Serializable> U set(SerializableFunction<E, R> property, SerializableFunction<R, O> nestedProperty,
        O value, Predicate<O> ignoreStrategy);

    /**
     * set value for property.
     *
     * @param <R> the generic type
     * @param <O> the generic type
     * @param property the property
     * @param nestedProperty the nested property
     * @param value property value
     * @param ignoreStrategy the ignore strategy
     * @return Update
     */
    default <R, O extends Serializable> U set(SerializableFunction<E, R> property,
        SerializableFunction<R, O> nestedProperty, O value, IgnoreStrategy ignoreStrategy) {
        return set(property, nestedProperty, value, ignoreStrategy::test);
    }

    /**
     * set value for property.
     *
     * @param <R> the generic type
     * @param property object property
     * @return Update
     */
    <R extends Serializable> U set(SerializableSupplier<R> property);

    /**
     * set value for property.
     *
     * @param <R> the generic type
     * @param property the property
     * @param ignoreStrategy the ignore strategy
     * @return the u
     */
    <R extends Serializable> U set(SerializableSupplier<R> property, Predicate<R> ignoreStrategy);

    /**
     * set value for property.
     *
     * @param <R> the generic type
     * @param property the property
     * @param ignoreStrategy the ignore strategy
     * @return the u
     */
    default <R extends Serializable> U set(SerializableSupplier<R> property, IgnoreStrategy ignoreStrategy) {
        return set(property, ignoreStrategy::test);
    }

    /**
     * set value for property.
     *
     * @param <R> the generic type
     * @param <O> the generic type
     * @param property object property
     * @param nestedProperty the nested property
     * @return Update
     */
    <R, O extends Serializable> U set(SerializableSupplier<R> property, SerializableFunction<R, O> nestedProperty);

    /**
     * set value for property.
     *
     * @param <R> the generic type
     * @param <O> the generic type
     * @param property object property
     * @param nestedProperty the nested property
     * @param ignoreStrategy the ignore strategy
     * @return Update
     */
    <R, O extends Serializable> U set(SerializableSupplier<R> property, SerializableFunction<R, O> nestedProperty,
        Predicate<O> ignoreStrategy);

    /**
     * set value for property.
     *
     * @param <R> the generic type
     * @param <O> the generic type
     * @param property object property
     * @param nestedProperty the nested property
     * @param ignoreStrategy the ignore strategy
     * @return Update
     */
    default <R, O extends Serializable> U set(SerializableSupplier<R> property,
        SerializableFunction<R, O> nestedProperty, IgnoreStrategy ignoreStrategy) {
        return set(property, nestedProperty, ignoreStrategy::test);
    }

    /**
     * increase value for property.
     *
     * @param <N> the generic number type
     * @param property the property name
     * @param value property value
     * @return Update
     */
    <N extends Number> U increase(SerializableFunction<E, N> property, N value);

    /**
     * increase value for property.
     *
     * @param <N> the generic number type
     * @param property the property name
     * @param value property value
     * @param ignoreStrategy the ignore strategy
     * @return Update
     */
    <N extends Number> U increase(SerializableFunction<E, N> property, N value, Predicate<N> ignoreStrategy);

    /**
     * increase value for property.
     *
     * @param <N> the generic number type
     * @param property the property name
     * @param value property value
     * @param ignoreStrategy the ignore strategy
     * @return Update
     */
    default <N extends Number> U increase(SerializableFunction<E, N> property, N value, IgnoreStrategy ignoreStrategy) {
        return increase(property, value, ignoreStrategy::test);
    }

    /**
     * increase value for property.
     *
     * @param <R> the generic type
     * @param <N> the generic type
     * @param property the property
     * @param nestedProperty the nested property
     * @param value property value
     * @return Update
     */
    <R, N extends Number> U increase(SerializableFunction<E, R> property, SerializableFunction<R, N> nestedProperty,
        N value);

    /**
     * increase value for property.
     *
     * @param <R> the generic type
     * @param <N> the generic type
     * @param property the property
     * @param nestedProperty the nested property
     * @param value property value
     * @param ignoreStrategy the ignore strategy
     * @return Update
     */
    <R, N extends Number> U increase(SerializableFunction<E, R> property, SerializableFunction<R, N> nestedProperty,
        N value, Predicate<N> ignoreStrategy);

    /**
     * increase value for property.
     *
     * @param <R> the generic type
     * @param <N> the generic type
     * @param property the property
     * @param nestedProperty the nested property
     * @param value property value
     * @param ignoreStrategy the ignore strategy
     * @return Update
     */
    default <R, N extends Number> U increase(SerializableFunction<E, R> property,
        SerializableFunction<R, N> nestedProperty, N value, IgnoreStrategy ignoreStrategy) {
        return increase(property, nestedProperty, value, ignoreStrategy::test);
    }

    /**
     * increase value for property.
     *
     * @param <N> number type
     * @param property object property
     * @return Update
     */
    <N extends Number> U increase(SerializableNumberSupplier<N> property);

    /**
     * increase value for property.
     *
     * @param <N> number type
     * @param property object property
     * @param ignoreStrategy the ignore strategy
     * @return Update
     */
    <N extends Number> U increase(SerializableNumberSupplier<N> property, Predicate<N> ignoreStrategy);

    /**
     * increase value for property.
     *
     * @param <N> number type
     * @param property object property
     * @param ignoreStrategy the ignore strategy
     * @return Update
     */
    default <N extends Number> U increase(SerializableNumberSupplier<N> property, IgnoreStrategy ignoreStrategy) {
        return increase(property, ignoreStrategy::test);
    }

    /**
     * increase value for property.
     *
     * @param <R> the generic type
     * @param <N> the generic type
     * @param property object property
     * @param nestedProperty the nested property
     * @return Update
     */
    <R, N extends Number> U increase(SerializableSupplier<R> property, SerializableFunction<R, N> nestedProperty);

    /**
     * increase value for property.
     *
     * @param <R> the generic type
     * @param <N> the generic type
     * @param property object property
     * @param nestedProperty the nested property
     * @param ignoreStrategy the ignore strategy
     * @return Update
     */
    <R, N extends Number> U increase(SerializableSupplier<R> property, SerializableFunction<R, N> nestedProperty,
        Predicate<N> ignoreStrategy);

    /**
     * increase value for property.
     *
     * @param <R> the generic type
     * @param <N> the generic type
     * @param property object property
     * @param nestedProperty the nested property
     * @param ignoreStrategy the ignore strategy
     * @return Update
     */
    default <R, N extends Number> U increase(SerializableSupplier<R> property,
        SerializableFunction<R, N> nestedProperty, IgnoreStrategy ignoreStrategy) {
        return increase(property, nestedProperty, ignoreStrategy::test);
    }
}
