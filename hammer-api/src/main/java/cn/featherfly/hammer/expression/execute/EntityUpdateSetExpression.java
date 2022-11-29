
package cn.featherfly.hammer.expression.execute;

import java.util.function.Consumer;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableSupplier;
import cn.featherfly.hammer.expression.EntityConditionGroupExpression;
import cn.featherfly.hammer.expression.EntityConditionGroupLogicExpression;

/**
 * EntityUpdateSetExpression.
 *
 * @author zhongj
 * @param <U> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityUpdateSetExpression<E, U extends EntityUpdateSetExecutableExpression<E, U, C, L>,
        C extends EntityConditionGroupExpression<E, C, L>, L extends EntityConditionGroupLogicExpression<E, C, L>> {

    /**
     * set value for property.
     *
     * @param <T>   the generic type
     * @param <R>   the generic type
     * @param name  property name
     * @param value property value
     * @return Update
     */
    <R> U set(SerializableFunction<E, R> name, R value);

    /**
     * set value for property.
     *
     * @param <R>      the generic type
     * @param property object property
     * @return Update
     */
    <R> U set(SerializableSupplier<R> property);

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
    <R extends Number> U increase(SerializableFunction<E, R> name, R value);

    /**
     * increase value for property.
     *
     * @param <N>      number type
     * @param property object property
     * @return Update
     */
    <N extends Number> U increase(SerializableSupplier<N> property);
}
