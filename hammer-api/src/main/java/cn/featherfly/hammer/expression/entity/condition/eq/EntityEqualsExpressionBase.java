
package cn.featherfly.hammer.expression.entity.condition.eq;

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
public interface EntityEqualsExpressionBase<E, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    // 和 <R> L eq(Consumer<Tuple2<EqualsEntityExpression<E>, EqualsEntityExpression<E2>>> equalsEntityExpressions)冲突了
    //    /**
    //     * equals. 等于.
    //     *
    //     * @param consumer the consumer
    //     * @return LogicExpression
    //     */
    //    L eq(Consumer<EntityEqualsExpression<E, C, L>> consumer);

    //    L eq();

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
     * @param <R>            the generic type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R> L eq(SerializableFunction<E, R> name, R value, Predicate<R> ignoreStrategy) {
        return eq(name, value, QueryPolicy.AUTO, ignoreStrategy);
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
     * @param <R>            the generic type
     * @param name           参数名称
     * @param value          参数值
     * @param queryPolicy    the query policy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L eq(SerializableFunction<E, R> name, R value, QueryPolicy queryPolicy, Predicate<R> ignoreStrategy);

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
     * @param <R>            the generic type
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R> L eq(SerializableSupplier<R> property, Predicate<R> ignoreStrategy) {
        return eq(property, QueryPolicy.AUTO, ignoreStrategy);
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
     * @param <R>            the generic type
     * @param property       对象属性
     * @param queryPolicy    the query policy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L eq(SerializableSupplier<R> property, QueryPolicy queryPolicy, Predicate<R> ignoreStrategy);

    //    嵌套属性使用property(U1::getU2).property(U2:getV).eq(v)来设置
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
    //    <T, V> L eq(SerializableFunction<E, T> fetchEntity, SerializableFunction<T, V> fetchEntityProperty, V value);
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
    //    <T, V> L eq(SerializableSupplier<T> fetchEntityValue, SerializableFunction<T, V> fetchEntityProperty);
}