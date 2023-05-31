
package cn.featherfly.hammer.expression.condition;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableSupplier;
import cn.featherfly.common.operator.QueryOperator.QueryPolicy;
import cn.featherfly.common.repository.Field;

/**
 * EqualsExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EqualsExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * equals. 等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default L eq(Field name, Object value) {
        return eq(name, value, QueryPolicy.AUTO);
    }

    /**
     * equals. 等于.
     *
     * @param name        参数名称
     * @param value       参数值
     * @param queryPolicy the query policy
     * @return LogicExpression
     */
    default L eq(Field name, Object value, QueryPolicy queryPolicy) {
        return eq(name.name(), value, QueryPolicy.AUTO);
    }

    /**
     * equals. 等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default L eq(String name, Object value) {
        return eq(name, value, QueryPolicy.AUTO);
    }

    /**
     * equals. 等于.
     *
     * @param name        参数名称
     * @param value       参数值
     * @param queryPolicy the query policy
     * @return LogicExpression
     */
    L eq(String name, Object value, QueryPolicy queryPolicy);

    /**
     * equals. 等于.
     *
     * @param <T>   the generic type
     * @param <R>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default <T, R> L eq(SerializableFunction<T, R> name, R value) {
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
    <T, R> L eq(SerializableFunction<T, R> name, R value, QueryPolicy queryPolicy);

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
}