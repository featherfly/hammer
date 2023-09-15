
package cn.featherfly.hammer.expression.execute;

import java.util.function.BooleanSupplier;
import java.util.function.Consumer;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableSupplier;

/**
 * SetUpdateExpression.
 *
 * @author zhongj
 * @param <U> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface UpdateSetExpression<U extends ExecutableUpdateSetExpression<U, C, L>,
        C extends ExecutableConditionGroupExpression<C, L>, L extends ExecutableConditionGroupLogicExpression<C, L>> {

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
     * @param setable the setable
     * @param name    property name
     * @param value   property value
     * @return Update
     */
    U set(BooleanSupplier setable, String name, Object value);

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
     * @param <N>     number type
     * @param setable the setable
     * @param name    property name
     * @param value   property value
     * @return Update
     */
    <N extends Number> U increase(BooleanSupplier setable, String name, N value);

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
     * @param <T>     the generic type
     * @param <R>     the generic type
     * @param setable the setable
     * @param name    property name
     * @param value   property value
     * @return Update
     */
    <T, R> U set(BooleanSupplier setable, SerializableFunction<T, R> name, R value);

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
     * @param property object property
     * @return Update
     */
    <R> U set(BooleanSupplier setable, SerializableSupplier<R> property);

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
     * @param <T>     the generic type
     * @param <R>     the generic number type
     * @param setable the setable
     * @param name    property name
     * @param value   property value
     * @return Update
     */
    <T, R extends Number> U increase(BooleanSupplier setable, SerializableFunction<T, R> name, R value);

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
     * @param <N>      number type
     * @param setable  the setable
     * @param property object property
     * @return Update
     */
    <N extends Number> U increase(BooleanSupplier setable, SerializableSupplier<N> property);
}
