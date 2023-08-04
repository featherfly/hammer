
package cn.featherfly.hammer.expression.entity.condition.sw;

import java.util.function.Predicate;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.StringSupplier;
import cn.featherfly.common.operator.QueryOperator.QueryPolicy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityStartWithExpressionBase4.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityStartWithExpressionBase4<E, E2, E3, E4, C extends ConditionExpression,
        L extends LogicExpression<C, L>> extends EntityStartWithExpressionBase3<E, E2, E3, C, L> {

    /**
     * start with value. 以value开始.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default L sw4(SerializableFunction<E4, String> name, String value) {
        return sw4(name, value, QueryPolicy.AUTO);
    }

    /**
     * start with value. 以value开始.
     *
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L sw4(SerializableFunction<E4, String> name, String value, Predicate<String> ignoreStrategy) {
        return sw4(name, value, QueryPolicy.AUTO, ignoreStrategy);
    }

    /**
     * start with value. 以value开始.
     *
     * @param name        the name
     * @param value       the value
     * @param queryPolicy the query policy
     * @return LogicExpression
     */
    L sw4(SerializableFunction<E4, String> name, String value, QueryPolicy queryPolicy);

    /**
     * start with value. 以value开始.
     *
     * @param name         the name
     * @param value        the value
     * @param queryPolicy  the query policy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L sw4(SerializableFunction<E4, String> name, String value, QueryPolicy queryPolicy,
            Predicate<String> ignoreStrategy);

    /**
     * start with value. 以value开始.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    default L sw4(StringSupplier property) {
        return sw4(property, QueryPolicy.AUTO);
    }

    /**
     * start with value. 以value开始.
     *
     * @param property     对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L sw4(StringSupplier property, Predicate<String> ignoreStrategy) {
        return sw4(property, QueryPolicy.AUTO, ignoreStrategy);
    }

    /**
     * start with value. 以value开始.
     *
     * @param property    the property
     * @param queryPolicy the query policy
     * @return LogicExpression
     */
    L sw4(StringSupplier property, QueryPolicy queryPolicy);

    /**
     * start with value. 以value开始.
     *
     * @param property     the property
     * @param queryPolicy  the query policy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L sw4(StringSupplier property, QueryPolicy queryPolicy, Predicate<String> ignoreStrategy);

    // 嵌套属性使用property(U1::getU2).property(U2:getV).sw(v)来设置
    //    /**
    //     * start with value. 以value开始.
    //     *
    //     * @param <R>                 the generic type
    //     * @param fetchEntity         the fetch entity
    //     * @param fetchEntityProperty the fetch entity property
    //     * @param value               参数值
    //     * @return LogicExpression
    //     */
    //    <R> L sw4(SerializableFunction<E4, R> fetchEntity, SerializableFunction<R, String> fetchEntityProperty,
    //            String value);
    //
    //    /**
    //     * start with value. 以value开始.
    //     *
    //     * @param <R>                 the generic type
    //     * @param fetchEntityValue    the fetch entity value
    //     * @param fetchEntityProperty the fetch entity property
    //     * @return LogicExpression
    //     */
    //    <R> L sw4(SerializableSupplier4<R> fetchEntityValue, SerializableFunction<R, String> fetchEntityProperty);

}