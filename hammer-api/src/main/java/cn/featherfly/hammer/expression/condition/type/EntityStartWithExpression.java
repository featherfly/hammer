
package cn.featherfly.hammer.expression.condition.type;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableSupplier;
import cn.featherfly.common.lang.function.StringSupplier;
import cn.featherfly.common.operator.QueryOperator.QueryPolicy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityStartWithExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityStartWithExpression<E, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * start with value. 以value开始.
     *
     * @param <T>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default L sw(SerializableFunction<E, String> name, String value) {
        return sw(name, value, QueryPolicy.AUTO);
    }

    /**
     * start with value. 以value开始.
     *
     * @param <T>         the generic type
     * @param name        the name
     * @param value       the value
     * @param queryPolicy the query policy
     * @return the l
     */
    L sw(SerializableFunction<E, String> name, String value, QueryPolicy queryPolicy);

    /**
     * start with value. 以value开始.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    default L sw(StringSupplier property) {
        return sw(property, QueryPolicy.AUTO);
    }

    /**
     * start with value. 以value开始.
     *
     * @param property    the property
     * @param queryPolicy the query policy
     * @return the l
     */
    L sw(StringSupplier property, QueryPolicy queryPolicy);

    /**
     * 以value开始.
     *
     * @param <T>        the generic type
     * @param <R>        the generic type
     * @param repository the repository
     * @param property   the property
     * @param value      参数值
     * @return LogicExpression
     */
    <R> L sw(SerializableFunction<E, R> repository, SerializableFunction<R, String> property, String value);

    /**
     * 以value开始.
     *
     * @param <T>        the generic type
     * @param <R>        the generic type
     * @param repository the repository
     * @param property   对象属性
     * @return LogicExpression
     */
    <R> L sw(SerializableSupplier<R> repository, SerializableFunction<R, String> property);
}