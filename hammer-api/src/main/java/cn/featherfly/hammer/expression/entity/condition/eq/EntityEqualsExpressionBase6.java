
package cn.featherfly.hammer.expression.entity.condition.eq;

import java.util.function.Predicate;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableSupplier6;
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
public interface EntityEqualsExpressionBase6<E, E2, E3, E4, E5, E6, C extends ConditionExpression,
        L extends LogicExpression<C, L>> extends EntityEqualsExpressionBase5<E, E2, E3, E4, E5, C, L> {

    //    /**
    //     * equals. 等于.
    //     *
    //     * @param consumer the consumer
    //     * @return LogicExpression
    //     */
    //    L eq6(Consumer<EntityEqualsExpressionBase2<E, C, L>> consumer);

    /**
     * equals. 等于.
     *
     * @param <R>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default <R> L eq6(SerializableFunction<E6, R> name, R value) {
        return eq6(name, value, QueryPolicy.AUTO);
    }

    /**
     * equals. 等于.
     *
     * @param <R>          the generic type
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R> L eq6(SerializableFunction<E6, R> name, R value, Predicate<R> ignoreStrategy) {
        return eq6(name, value, QueryPolicy.AUTO, ignoreStrategy);
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
    <R> L eq6(SerializableFunction<E6, R> name, R value, QueryPolicy queryPolicy);

    /**
     * equals. 等于.
     *
     * @param <R>          the generic type
     * @param name         参数名称
     * @param value        参数值
     * @param queryPolicy  the query policy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L eq6(SerializableFunction<E6, R> name, R value, QueryPolicy queryPolicy, Predicate<R> ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    default <R> L eq6(SerializableSupplier6<R> property) {
        return eq6(property, QueryPolicy.AUTO);
    }

    /**
     * equals. 等于.
     *
     * @param <R>          the generic type
     * @param property     对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R> L eq6(SerializableSupplier6<R> property, Predicate<R> ignoreStrategy) {
        return eq6(property, QueryPolicy.AUTO, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param <R>         the generic type
     * @param property    对象属性
     * @param queryPolicy the query policy
     * @return LogicExpression
     */
    <R> L eq6(SerializableSupplier6<R> property, QueryPolicy queryPolicy);

    /**
     * equals. 等于.
     *
     * @param <R>          the generic type
     * @param property     对象属性
     * @param queryPolicy  the query policy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L eq6(SerializableSupplier6<R> property, QueryPolicy queryPolicy, Predicate<R> ignoreStrategy);

    //    /**
    //     * equals. 等于.
    //     *
    //     * @param <T>                 the generic type
    //     * @param <V>                 the value type
    //     * @param fetchEntity         the fetch entity
    //     * @param fetchEntityProperty the fetch entity property
    //     * @param value               参数值
    //     * @return LogicExpression
    //     */
    //    <T, V> L eq6(SerializableFunction<E6, T> fetchEntity, SerializableFunction<T, V> fetchEntityProperty, V value);
    //
    //    /**
    //     * equals. 等于.
    //     *
    //     * @param <T>                 the generic type
    //     * @param <V>                 the value type
    //     * @param fetchEntityValue    the fetch entity value
    //     * @param fetchEntityProperty the fetch entity property
    //     * @return LogicExpression
    //     */
    //    <T, V> L eq6(SerializableSupplier6<T> fetchEntityValue, SerializableFunction<T, V> fetchEntityProperty);
}