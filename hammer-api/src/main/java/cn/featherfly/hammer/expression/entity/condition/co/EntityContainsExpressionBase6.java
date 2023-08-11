
package cn.featherfly.hammer.expression.entity.condition.co;

import java.util.function.Predicate;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableStringSupplier;
import cn.featherfly.common.operator.QueryOperator.QueryPolicy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityContainsExpressionBase5.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <E5> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityContainsExpressionBase6<E, E2, E3, E4, E5, E6, C extends ConditionExpression,
        L extends LogicExpression<C, L>> extends EntityContainsExpressionBase5<E, E2, E3, E4, E5, C, L> {

    /**
     * contains value. 包含value.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default L co6(SerializableFunction<E6, String> name, String value) {
        return co6(name, value, QueryPolicy.AUTO);
    }

    /**
     * contains value. 包含value.
     *
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L co6(SerializableFunction<E6, String> name, String value, Predicate<String> ignoreStrategy) {
        return co6(name, value, QueryPolicy.AUTO, ignoreStrategy);
    }

    /**
     * contains value. 包含value.
     *
     * @param name        the name
     * @param value       the value
     * @param queryPolicy the query policy
     * @return LogicExpression
     */
    L co6(SerializableFunction<E6, String> name, String value, QueryPolicy queryPolicy);

    /**
     * contains value. 包含value.
     *
     * @param name         the name
     * @param value        the value
     * @param queryPolicy  the query policy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L co6(SerializableFunction<E6, String> name, String value, QueryPolicy queryPolicy, Predicate<String> ignoreStrategy);

    /**
     * contains value. 包含value.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    default L co6(SerializableStringSupplier property) {
        return co6(property, QueryPolicy.AUTO);
    }

    /**
     * contains value. 包含value.
     *
     * @param property     对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L co6(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return co6(property, QueryPolicy.AUTO, ignoreStrategy);
    }

    /**
     * contains value. 包含value.
     *
     * @param property    the property
     * @param queryPolicy the query policy
     * @return LogicExpression
     */
    L co6(SerializableStringSupplier property, QueryPolicy queryPolicy);

    /**
     * contains value. 包含value.
     *
     * @param property     the property
     * @param queryPolicy  the query policy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L co6(SerializableStringSupplier property, QueryPolicy queryPolicy, Predicate<String> ignoreStrategy);

    // 嵌套属性使用property(U1::getU2).property(U2:getV).co(v)来设置
    //    /**
    //     * contains value. 包含value.
    //     *
    //     * @param <R>                 the generic type
    //     * @param fetchEntity         the fetch entity
    //     * @param fetchEntityProperty the fetch entity property
    //     * @param value               参数值
    //     * @return LogicExpression
    //     */
    //    <R> L co6(SerializableFunction<E6, R> fetchEntity, SerializableFunction<R, String> fetchEntityProperty,
    //            String value);
    //
    //    /**
    //     * contains value. 包含value.
    //     *
    //     * @param <R>                 the generic type
    //     * @param fetchEntityValue    the fetch entity value
    //     * @param fetchEntityProperty the fetch entity property
    //     * @return LogicExpression
    //     */
    //    <R> L co6(SerializableSupplier6<R> fetchEntityValue, SerializableFunction<R, String> fetchEntityProperty);

}