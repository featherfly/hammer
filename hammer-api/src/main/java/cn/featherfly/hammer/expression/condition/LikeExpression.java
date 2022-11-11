
package cn.featherfly.hammer.expression.condition;

import cn.featherfly.common.lang.function.ReturnStringFunction;
import cn.featherfly.common.lang.function.StringSupplier;
import cn.featherfly.common.operator.QueryOperator.QueryPolicy;

/**
 * LikeExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface LikeExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * like value.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default L lk(String name, String value) {
        return lk(name, value, QueryPolicy.AUTO);
    }

    /**
     * like value.
     *
     * @param name        参数名称
     * @param value       参数值
     * @param queryPolicy the query policy
     * @return LogicExpression
     */
    L lk(String name, String value, QueryPolicy queryPolicy);

    /**
     * like value.
     *
     * @param <T>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default <T> L lk(ReturnStringFunction<T> name, String value) {
        return lk(name, value, QueryPolicy.AUTO);
    }

    /**
     * Lk.
     *
     * @param <T>         the generic type
     * @param name        the name 参数名称
     * @param value       the value
     * @param queryPolicy the query policy
     * @return the l
     */
    <T> L lk(ReturnStringFunction<T> name, String value, QueryPolicy queryPolicy);

    /**
     * like value.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    default L lk(StringSupplier property) {
        return lk(property, QueryPolicy.AUTO);
    }

    /**
     * Lk.
     *
     * @param property    the property 对象属性
     * @param queryPolicy the query policy
     * @return the l
     */
    L lk(StringSupplier property, QueryPolicy queryPolicy);
}