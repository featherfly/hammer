
package cn.featherfly.hammer.expression.condition;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableSupplier;
import cn.featherfly.common.repository.operate.QueryOperator.QueryPolicy;

/**
 * NotEqualsExpressoin .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface NotEqualsExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * not equals. 不等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default L ne(String name, Object value) {
        return ne(name, value, QueryPolicy.AUTO);
    }

    /**
     * not equals. 不等于.
     *
     * @param name        参数名称
     * @param value       参数值
     * @param queryPolicy the query policy
     * @return LogicExpression
     */
    L ne(String name, Object value, QueryPolicy queryPolicy);

    /**
     * not equals. 不等于.
     *
     * @param <T>   the generic type
     * @param <R>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default <T, R> L ne(SerializableFunction<T, R> name, R value) {
        return ne(name, value, QueryPolicy.AUTO);
    }

    /**
     * not equals. 不等于.
     *
     * @param <T>         the generic type
     * @param <R>         the generic type
     * @param name        参数名称
     * @param value       参数值
     * @param queryPolicy the query policy
     * @return LogicExpression
     */
    <T, R> L ne(SerializableFunction<T, R> name, R value, QueryPolicy queryPolicy);

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
     * @param <R>         the generic type
     * @param property    对象属性
     * @param queryPolicy the query policy
     * @return LogicExpression
     */
    <R> L ne(SerializableSupplier<R> property, QueryPolicy queryPolicy);
}