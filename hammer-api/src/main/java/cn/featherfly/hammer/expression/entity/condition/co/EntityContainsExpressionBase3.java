
package cn.featherfly.hammer.expression.entity.condition.co;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityContainsExpressionBase3.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityContainsExpressionBase3<E, E2, E3, C extends ConditionExpression,
        L extends LogicExpression<C, L>> extends EntityContainsExpressionBase2<E, E2, C, L> {

    /**
     * contains value. 包含value.
     *
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    default L co3(SerializableFunction<E3, String> name, String value) {
        return co3(name, value, MatchStrategy.AUTO);
    }

    /**
     * contains value. 包含value.
     *
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L co3(SerializableFunction<E3, String> name, String value, Predicate<String> ignoreStrategy) {
        return co3(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * contains value. 包含value.
     *
     * @param name        the name
     * @param value       the value
     * @param queryPolicy the query policy
     * @return LogicExpression
     */
    L co3(SerializableFunction<E3, String> name, String value, MatchStrategy matchStrategy);

    /**
     * contains value. 包含value.
     *
     * @param name         the name
     * @param value        the value
     * @param queryPolicy  the query policy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L co3(SerializableFunction<E3, String> name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);

    /**
     * contains value. 包含value.
     *
     * @param property  bean property
     * @return LogicExpression
     */
    default L co3(SerializableStringSupplier property) {
        return co3(property, MatchStrategy.AUTO);
    }

    /**
     * contains value. 包含value.
     *
     * @param property  bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L co3(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return co3(property, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * contains value. 包含value.
     *
     * @param property    the property
     * @param queryPolicy the query policy
     * @return LogicExpression
     */
    L co3(SerializableStringSupplier property, MatchStrategy matchStrategy);

    /**
     * contains value. 包含value.
     *
     * @param property     the property
     * @param queryPolicy  the query policy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L co3(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);

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
    //    <R> L co3(SerializableFunction<E3, R> fetchEntity, SerializableFunction<R, String> fetchEntityProperty,
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
    //    <R> L co3(SerializableSupplier3<R> fetchEntityValue, SerializableFunction<R, String> fetchEntityProperty);
}