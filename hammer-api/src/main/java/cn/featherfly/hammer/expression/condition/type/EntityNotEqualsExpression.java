
package cn.featherfly.hammer.expression.condition.type;

import java.util.function.Consumer;
import java.util.function.Predicate;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableSupplier;
import cn.featherfly.common.operator.QueryOperator.QueryPolicy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityNotEqualsExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityNotEqualsExpression<E, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * not equals. 不等于.
     *
     * @param <R>      the generic type
     * @param consumer the consumer
     * @return LogicExpression
     */
    <R> L ne(Consumer<EntityEqualsExpression<E, C, L>> consumer);

    /**
     * not equals. 不等于.
     *
     * @param <R>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default <R> L ne(SerializableFunction<E, R> name, R value) {
        return ne(name, value, QueryPolicy.AUTO);
    }

    /**
     * not equals. 不等于.
     *
     * @param <R>          the generic type
     * @param name         参数名称
     * @param value        参数值
     * @param ignorePolicy the ignore policy
     * @return LogicExpression
     */
    default <R> L ne(SerializableFunction<E, R> name, R value, Predicate<Object> ignorePolicy) {
        return ne(name, value, QueryPolicy.AUTO, ignorePolicy);
    }

    /**
     * not equals. 不等于.
     *
     * @param <R>         the generic type
     * @param name        参数名称
     * @param value       参数值
     * @param queryPolicy the query policy
     * @return LogicExpression
     */
    <R> L ne(SerializableFunction<E, R> name, R value, QueryPolicy queryPolicy);

    /**
     * not equals. 不等于.
     *
     * @param <R>          the generic type
     * @param name         参数名称
     * @param value        参数值
     * @param queryPolicy  the query policy
     * @param ignorePolicy the ignore policy
     * @return LogicExpression
     */
    <R> L ne(SerializableFunction<E, R> name, R value, QueryPolicy queryPolicy, Predicate<Object> ignorePolicy);

    /**
     * not equals. 不等于.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    default <R> L ne(SerializableSupplier<R> property) {
        return ne(property, QueryPolicy.AUTO);
    }

    /**
     * not equals. 不等于.
     *
     * @param <R>          the generic type
     * @param property     对象属性
     * @param ignorePolicy the ignore policy
     * @return LogicExpression
     */
    default <R> L ne(SerializableSupplier<R> property, Predicate<Object> ignorePolicy) {
        return ne(property, QueryPolicy.AUTO, ignorePolicy);
    }

    /**
     * not equals. 不等于.
     *
     * @param <R>         the generic type
     * @param property    对象属性
     * @param queryPolicy the query policy
     * @return LogicExpression
     */
    <R> L ne(SerializableSupplier<R> property, QueryPolicy queryPolicy);

    /**
     * not equals. 不等于.
     *
     * @param <R>          the generic type
     * @param property     对象属性
     * @param queryPolicy  the query policy
     * @param ignorePolicy the ignore policy
     * @return LogicExpression
     */
    <R> L ne(SerializableSupplier<R> property, QueryPolicy queryPolicy, Predicate<Object> ignorePolicy);

    /**
     * not equals.不等于.
     *
     * @param <T>        the generic type
     * @param <R>        the generic type
     * @param repository the repository
     * @param property   the property
     * @param value      参数值
     * @return LogicExpression
     */
    <T, R> L ne(SerializableFunction<E, T> repository, SerializableFunction<T, R> property, R value);

    /**
     * not equals.不等于.
     *
     * @param <R>        the generic type
     * @param <V>        the value type
     * @param repository the repository
     * @param property   对象属性
     * @return LogicExpression
     */
    <R, V> L ne(SerializableSupplier<R> repository, SerializableFunction<R, V> property);
}