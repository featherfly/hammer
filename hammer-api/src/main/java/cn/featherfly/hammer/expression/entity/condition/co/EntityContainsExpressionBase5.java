
package cn.featherfly.hammer.expression.entity.condition.co;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
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
public interface EntityContainsExpressionBase5<E, E2, E3, E4, E5, C extends ConditionExpression,
        L extends LogicExpression<C, L>> extends EntityContainsExpressionBase4<E, E2, E3, E4, C, L> {

    /**
     * contains value. 包含value.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default L co5(SerializableFunction<E5, String> name, String value) {
        return co5(name, value, MatchStrategy.AUTO);
    }

    /**
     * contains value. 包含value.
     *
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L co5(SerializableFunction<E5, String> name, String value, Predicate<String> ignoreStrategy) {
        return co5(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * contains value. 包含value.
     *
     * @param name        the name
     * @param value       the value
     * @param queryPolicy the query policy
     * @return LogicExpression
     */
    L co5(SerializableFunction<E5, String> name, String value, MatchStrategy matchStrategy);

    /**
     * contains value. 包含value.
     *
     * @param name         the name
     * @param value        the value
     * @param queryPolicy  the query policy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L co5(SerializableFunction<E5, String> name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);

    /**
     * contains value. 包含value.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    default L co5(SerializableStringSupplier property) {
        return co5(property, MatchStrategy.AUTO);
    }

    /**
     * contains value. 包含value.
     *
     * @param property     对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L co5(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return co5(property, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * contains value. 包含value.
     *
     * @param property    the property
     * @param queryPolicy the query policy
     * @return LogicExpression
     */
    L co5(SerializableStringSupplier property, MatchStrategy matchStrategy);

    /**
     * contains value. 包含value.
     *
     * @param property     the property
     * @param queryPolicy  the query policy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L co5(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);

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
    //    <R> L co5(SerializableFunction<E5, R> fetchEntity, SerializableFunction<R, String> fetchEntityProperty,
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
    //    <R> L co5(SerializableSupplier5<R> fetchEntityValue, SerializableFunction<R, String> fetchEntityProperty);

}