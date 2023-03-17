
package cn.featherfly.hammer.expression.condition.type;

import java.util.function.Consumer;
import java.util.function.Predicate;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableSupplier;
import cn.featherfly.common.operator.QueryOperator.QueryPolicy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityEqualsExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityEqualsExpression<E, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * equals. 等于.
     *
     * @param <R>      the generic type
     * @param consumer the consumer
     * @return LogicExpression
     */
    <R> L eq(Consumer<EntityEqualsExpression<E, C, L>> consumer);

    /**
     * equals. 等于.
     *
     * @param <R>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default <R> L eq(SerializableFunction<E, R> name, R value) {
        return eq(name, value, QueryPolicy.AUTO);
    }

    /**
     * equals. 等于.
     *
     * @param <R>          the generic type
     * @param name         参数名称
     * @param value        参数值
     * @param ignorePolicy the ignore policy
     * @return LogicExpression
     */
    default <R> L eq(SerializableFunction<E, R> name, R value, Predicate<Object> ignorePolicy) {
        return eq(name, value, QueryPolicy.AUTO, ignorePolicy);
    }

    /**
     * equals. 等于.
     *
     * @param <R>         the generic type
     * @param name        参数名称
     * @param value       参数值
     * @param queryPolicy the query policy
     * @return LogicExpression
     */
    <R> L eq(SerializableFunction<E, R> name, R value, QueryPolicy queryPolicy);

    /**
     * equals. 等于.
     *
     * @param <R>          the generic type
     * @param name         参数名称
     * @param value        参数值
     * @param queryPolicy  the query policy
     * @param ignorePolicy the ignore policy
     * @return LogicExpression
     */
    <R> L eq(SerializableFunction<E, R> name, R value, QueryPolicy queryPolicy, Predicate<Object> ignorePolicy);

    /**
     * equals. 等于.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    default <R> L eq(SerializableSupplier<R> property) {
        return eq(property, QueryPolicy.AUTO);
    }

    /**
     * equals. 等于.
     *
     * @param <R>          the generic type
     * @param property     对象属性
     * @param ignorePolicy the ignore policy
     * @return LogicExpression
     */
    default <R> L eq(SerializableSupplier<R> property, Predicate<Object> ignorePolicy) {
        return eq(property, QueryPolicy.AUTO, ignorePolicy);
    }

    /**
     * equals. 等于.
     *
     * @param <R>         the generic type
     * @param property    对象属性
     * @param queryPolicy the query policy
     * @return LogicExpression
     */
    <R> L eq(SerializableSupplier<R> property, QueryPolicy queryPolicy);

    /**
     * equals. 等于.
     *
     * @param <R>          the generic type
     * @param property     对象属性
     * @param queryPolicy  the query policy
     * @param ignorePolicy the ignore policy
     * @return LogicExpression
     */
    <R> L eq(SerializableSupplier<R> property, QueryPolicy queryPolicy, Predicate<Object> ignorePolicy);

    /**
     * equals. 等于.
     *
     * @param <T>        the generic type
     * @param <V>        the value type
     * @param repository the repository
     * @param property   the property
     * @param value      参数值
     * @return LogicExpression
     */
    <T, V> L eq(SerializableFunction<E, T> repository, SerializableFunction<T, V> property, V value);

    /**
     * equals. 等于.
     *
     * @param <T>        the generic type
     * @param <V>        the value type
     * @param repository the repository
     * @param property   对象属性
     * @return LogicExpression
     */
    <T, V> L eq(SerializableSupplier<T> repository, SerializableFunction<T, V> property);
}