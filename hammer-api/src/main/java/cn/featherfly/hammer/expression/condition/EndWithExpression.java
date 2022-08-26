
package cn.featherfly.hammer.expression.condition;

import cn.featherfly.common.lang.function.ReturnStringFunction;
import cn.featherfly.common.lang.function.StringSupplier;
import cn.featherfly.common.operator.QueryOperator.QueryPolicy;

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
    default <T> L ew(ReturnStringFunction<T> name, String value) {
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
    <T> L ew(ReturnStringFunction<T> name, String value, QueryPolicy queryPolicy);

    /**
     * end with value. 以value结尾.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    default L ew(StringSupplier property) {
        return ew(property, QueryPolicy.AUTO);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param property    the property
     * @param queryPolicy the query policy
     * @return the l
     */
    L ew(StringSupplier property, QueryPolicy queryPolicy);
}