
package cn.featherfly.hammer.expression.condition.type;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableSupplier;
import cn.featherfly.common.operator.QueryOperator.QueryPolicy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityEqualsExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityEqualsExpression<E, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * equals. 等于.
     *
     * @param <T>   the generic type
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
     * @param <T>         the generic type
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
     * @param <R>         the generic type
     * @param property    对象属性
     * @param queryPolicy the query policy
     * @return LogicExpression
     */
    <R> L eq(SerializableSupplier<R> property, QueryPolicy queryPolicy);

    /**
     * equals. 等于.
     *
     * @param <O>        the generic type
     * @param <T>        the generic type
     * @param <R>        the generic type
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
     * @param <R>        the generic type
     * @param repository the repository
     * @param property   对象属性
     * @return LogicExpression
     */
    <T, V> L eq(SerializableSupplier<T> repository, SerializableFunction<T, V> property);
}