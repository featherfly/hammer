
package cn.featherfly.hammer.expression.entity.condition.eq;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableSupplier5;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
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
public interface EntityEqualsExpressionBase5<E, E2, E3, E4, E5, C extends ConditionExpression,
        L extends LogicExpression<C, L>> extends EntityEqualsExpressionBase4<E, E2, E3, E4, C, L> {

    //    /**
    //     * equals. 等于.
    //     *
    //     * @param consumer the consumer
    //     * @return LogicExpression
    //     */
    //    L eq5(Consumer<EntityEqualsExpressionBase2<E, C, L>> consumer);

    /**
     * equals. 等于.
     *
     * @param <R>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default <R> L eq5(SerializableFunction<E5, R> name, R value) {
        return eq5(name, value, MatchStrategy.AUTO);
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
    default <R> L eq5(SerializableFunction<E5, R> name, R value, Predicate<R> ignoreStrategy) {
        return eq5(name, value, MatchStrategy.AUTO, ignoreStrategy);
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
    <R> L eq5(SerializableFunction<E5, R> name, R value, MatchStrategy queryPolicy);

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
    <R> L eq5(SerializableFunction<E5, R> name, R value, MatchStrategy queryPolicy, Predicate<R> ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    default <R> L eq5(SerializableSupplier5<R> property) {
        return eq5(property, MatchStrategy.AUTO);
    }

    /**
     * equals. 等于.
     *
     * @param <R>          the generic type
     * @param property     对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R> L eq5(SerializableSupplier5<R> property, Predicate<R> ignoreStrategy) {
        return eq5(property, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param <R>         the generic type
     * @param property    对象属性
     * @param queryPolicy the query policy
     * @return LogicExpression
     */
    <R> L eq5(SerializableSupplier5<R> property, MatchStrategy queryPolicy);

    /**
     * equals. 等于.
     *
     * @param <R>          the generic type
     * @param property     对象属性
     * @param queryPolicy  the query policy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L eq5(SerializableSupplier5<R> property, MatchStrategy queryPolicy, Predicate<R> ignoreStrategy);

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
    //    <T, V> L eq5(SerializableFunction<E5, T> fetchEntity, SerializableFunction<T, V> fetchEntityProperty, V value);
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
    //    <T, V> L eq5(SerializableSupplier5<T> fetchEntityValue, SerializableFunction<T, V> fetchEntityProperty);
}