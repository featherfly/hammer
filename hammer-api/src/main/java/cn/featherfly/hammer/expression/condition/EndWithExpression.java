
package cn.featherfly.hammer.expression.condition;

import cn.featherfly.common.lang.function.SerializableToStringFunction;
import cn.featherfly.common.lang.function.SerializableStringSupplier;
import cn.featherfly.common.operator.QueryOperator.QueryPolicy;
import cn.featherfly.common.repository.Field;

/**
 * EndWithExpression .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EndWithExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * end with value. 以value结尾.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default L ew(Field name, String value) {
        return ew(name, value, QueryPolicy.AUTO);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param name        the name
     * @param value       the value
     * @param queryPolicy the query policy
     * @return the l
     */
    default L ew(Field name, String value, QueryPolicy queryPolicy) {
        return ew(name.name(), value, QueryPolicy.AUTO);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default L ew(String name, String value) {
        return ew(name, value, QueryPolicy.AUTO);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param name        the name
     * @param value       the value
     * @param queryPolicy the query policy
     * @return the l
     */
    L ew(String name, String value, QueryPolicy queryPolicy);

    /**
     * end with value. 以value结尾.
     *
     * @param <T>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default <T> L ew(SerializableToStringFunction<T> name, String value) {
        return ew(name, value, QueryPolicy.AUTO);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param <T>         the generic type
     * @param name        the name
     * @param value       the value
     * @param queryPolicy the query policy
     * @return the l
     */
    <T> L ew(SerializableToStringFunction<T> name, String value, QueryPolicy queryPolicy);

    /**
     * end with value. 以value结尾.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    default L ew(SerializableStringSupplier property) {
        return ew(property, QueryPolicy.AUTO);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param property    the property
     * @param queryPolicy the query policy
     * @return the l
     */
    L ew(SerializableStringSupplier property, QueryPolicy queryPolicy);
}