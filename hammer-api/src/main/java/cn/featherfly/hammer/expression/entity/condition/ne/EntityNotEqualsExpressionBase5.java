
package cn.featherfly.hammer.expression.entity.condition.ne;

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
public interface EntityNotEqualsExpressionBase5<E, E2, E3, E4, E5, C extends ConditionExpression,
        L extends LogicExpression<C, L>> extends EntityNotEqualsExpressionBase4<E, E2, E3, E4, C, L> {

    //    /**
    //     * equals. 等于.
    //     *
    //     * @param consumer the consumer
    //     * @return LogicExpression
    //     */
    //    L ne5(Consumer<EntityEqualsExpressionBase2<E, C, L>> consumer);

    /**
     * equals. 等于.
     *
     * @param <R>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default <R> L ne5(SerializableFunction<E5, R> name, R value) {
        return ne5(name, value, MatchStrategy.AUTO);
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
    default <R> L ne5(SerializableFunction<E5, R> name, R value, Predicate<R> ignoreStrategy) {
        return ne5(name, value, MatchStrategy.AUTO, ignoreStrategy);
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
    <R> L ne5(SerializableFunction<E5, R> name, R value, MatchStrategy matchStrategy);

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
    <R> L ne5(SerializableFunction<E5, R> name, R value, MatchStrategy matchStrategy, Predicate<R> ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    default <R> L ne5(SerializableSupplier5<R> property) {
        return ne5(property, MatchStrategy.AUTO);
    }

    /**
     * equals. 等于.
     *
     * @param <R>          the generic type
     * @param property     对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R> L ne5(SerializableSupplier5<R> property, Predicate<R> ignoreStrategy) {
        return ne5(property, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param <R>         the generic type
     * @param property    对象属性
     * @param queryPolicy the query policy
     * @return LogicExpression
     */
    <R> L ne5(SerializableSupplier5<R> property, MatchStrategy matchStrategy);

    /**
     * equals. 等于.
     *
     * @param <R>          the generic type
     * @param property     对象属性
     * @param queryPolicy  the query policy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L ne5(SerializableSupplier5<R> property, MatchStrategy matchStrategy, Predicate<R> ignoreStrategy);

    //    嵌套属性使用property(U1::getU2).property(U2:getV).ne(v)来设置
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
    //    <T, V> L ne5(SerializableFunction<E5, T> fetchEntity, SerializableFunction<T, V> fetchEntityProperty, V value);
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
    //    <T, V> L ne5(SerializableSupplier5<T> fetchEntityValue, SerializableFunction<T, V> fetchEntityProperty);
}