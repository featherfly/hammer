
package cn.featherfly.hammer.expression.execute;

import java.util.function.Consumer;
import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;

/**
 * SetUpdateExpression.
 *
 * @author zhongj
 * @param <U> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface UpdateSetExpression<U extends ExecutableUpdateSetExpression<U, C, L>,
        C extends ExecutableConditionGroupExpression<C, L, UpdateConditionConfig>,
        L extends ExecutableConditionGroupLogicExpression<C, L, UpdateConditionConfig>> {

    /**
     * set value for property.
     *
     * @param name  property name
     * @param value property value
     * @return Update
     */
    U set(String name, Object value);

    /**
     * set value for property.
     *
     * @param name           property name
     * @param value          property value
     * @param ignoreStrategy the ignore strategy
     * @return Update
     */
    U set(String name, Object value, Predicate<Object> ignoreStrategy);

    /**
     * set value for property.
     *
     * @param name           property name
     * @param value          property value
     * @param ignoreStrategy the ignore strategy
     * @return Update
     */
    default U set(String name, Object value, IgnoreStrategy ignoreStrategy) {
        return set(name, value, (Predicate<Object>) ignoreStrategy);
    }

    /**
     * increase value for property.
     *
     * @param <N>   number type
     * @param name  property name
     * @param value property value
     * @return Update
     */
    <N extends Number> U increase(String name, N value);

    /**
     * increase value for property.
     *
     * @param <N>            number type
     * @param name           property name
     * @param value          property value
     * @param ignoreStrategy the ignore strategy
     * @return Update
     */
    <N extends Number> U increase(String name, N value, Predicate<N> ignoreStrategy);

    /**
     * increase value for property.
     *
     * @param <N>            number type
     * @param name           property name
     * @param value          property value
     * @param ignoreStrategy the ignore strategy
     * @return Update
     */
    default <N extends Number> U increase(String name, N value, IgnoreStrategy ignoreStrategy) {
        return increase(name, value, ignoreStrategy::test);
    }

    /**
     * set value for property.
     *
     * @param <T>   the generic type
     * @param <R>   the generic type
     * @param name  property name
     * @param value property value
     * @return Update
     */
    <T, R> U set(SerializableFunction<T, R> name, R value);

    /**
     * set value for property.
     *
     * @param <T>            the generic type
     * @param <R>            the generic type
     * @param name           property name
     * @param value          property value
     * @param ignoreStrategy the ignore strategy
     * @return Update
     */
    <T, R> U set(SerializableFunction<T, R> name, R value, Predicate<R> ignoreStrategy);

    /**
     * set value for property.
     *
     * @param <T>            the generic type
     * @param <R>            the generic type
     * @param name           property name
     * @param value          property value
     * @param ignoreStrategy the ignore strategy
     * @return Update
     */
    default <T, R> U set(SerializableFunction<T, R> name, R value, IgnoreStrategy ignoreStrategy) {
        return set(name, value, ignoreStrategy::test);
    }

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
     * @param <R>            the generic type
     * @param property       object property
     * @param ignoreStrategy the ignore strategy
     * @return Update
     */
    <R> U set(SerializableSupplier<R> property, Predicate<R> ignoreStrategy);

    /**
     * set value for property.
     *
     * @param <R>            the generic type
     * @param property       object property
     * @param ignoreStrategy the ignore strategy
     * @return Update
     */
    default <R> U set(SerializableSupplier<R> property, IgnoreStrategy ignoreStrategy) {
        return set(property, ignoreStrategy::test);
    }

    /**
     * Sets the.
     *
     * @param consumer the consumer
     * @return the u
     */
    U set(Consumer<U> consumer);

    /**
     * increase value for property.
     *
     * @param <T>   the generic type
     * @param <R>   the generic number type
     * @param name  property name
     * @param value property value
     * @return Update
     */
    <T, R extends Number> U increase(SerializableFunction<T, R> name, R value);

    /**
     * increase value for property.
     *
     * @param <T>            the generic type
     * @param <N>            the generic number type
     * @param name           property name
     * @param value          property value
     * @param ignoreStrategy the ignore strategy
     * @return Update
     */
    <T, N extends Number> U increase(SerializableFunction<T, N> name, N value, Predicate<N> ignoreStrategy);

    /**
     * increase value for property.
     *
     * @param <T>            the generic type
     * @param <N>            the generic number type
     * @param name           property name
     * @param value          property value
     * @param ignoreStrategy the ignore strategy
     * @return Update
     */
    default <T, N extends Number> U increase(SerializableFunction<T, N> name, N value, IgnoreStrategy ignoreStrategy) {
        return increase(name, value, ignoreStrategy::test);
    }

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
     * @param <N>            number type
     * @param property       object property
     * @param ignoreStrategy the ignore strategy
     * @return Update
     */
    <N extends Number> U increase(SerializableSupplier<N> property, Predicate<N> ignoreStrategy);

    /**
     * increase value for property.
     *
     * @param <N>            number type
     * @param property       object property
     * @param ignoreStrategy the ignore strategy
     * @return Update
     */
    default <N extends Number> U increase(SerializableSupplier<N> property, IgnoreStrategy ignoreStrategy) {
        return increase(property, ignoreStrategy::test);
    }
}
