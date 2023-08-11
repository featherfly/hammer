
package cn.featherfly.hammer.expression.condition;

import cn.featherfly.common.lang.function.SerializableToStringFunction;
import cn.featherfly.common.lang.function.SerializableStringSupplier;
import cn.featherfly.common.operator.QueryOperator.QueryPolicy;

/**
 * StartWithExpression .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface StartWithExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * start with value. 以value开始.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default L sw(String name, String value) {
        return sw(name, value, QueryPolicy.AUTO);
    }

    /**
     * start with value. 以value开始.
     *
     * @param name        the name
     * @param value       the value
     * @param queryPolicy the query policy
     * @return the l
     */
    L sw(String name, String value, QueryPolicy queryPolicy);

    /**
     * start with value. 以value开始.
     *
     * @param <T>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default <T> L sw(SerializableToStringFunction<T> name, String value) {
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
    <T> L sw(SerializableToStringFunction<T> name, String value, QueryPolicy queryPolicy);

    /**
     * start with value. 以value开始.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    default L sw(SerializableStringSupplier property) {
        return sw(property, QueryPolicy.AUTO);
    }

    /**
     * start with value. 以value开始.
     *
     * @param property    the property
     * @param queryPolicy the query policy
     * @return the l
     */
    L sw(SerializableStringSupplier property, QueryPolicy queryPolicy);

}