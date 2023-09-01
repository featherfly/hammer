
package cn.featherfly.hammer.expression.entity.condition.sw;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityStartWithExpressionBase6.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <E5> the generic type
 * @param <E6> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityStartWithExpressionBase6<E, E2, E3, E4, E5, E6, C extends ConditionExpression,
        L extends LogicExpression<C, L>> extends EntityStartWithExpressionBase5<E, E2, E3, E4, E5, C, L> {

    /**
     * start with value. 以value开始.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default L sw6(SerializableFunction<E6, String> name, String value) {
        return sw6(name, value, MatchStrategy.AUTO);
    }

    /**
     * start with value. 以value开始.
     *
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L sw6(SerializableFunction<E6, String> name, String value, Predicate<String> ignoreStrategy) {
        return sw6(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * start with value. 以value开始.
     *
     * @param name        the name
     * @param value       the value
     * @param queryPolicy the query policy
     * @return LogicExpression
     */
    L sw6(SerializableFunction<E6, String> name, String value, MatchStrategy queryPolicy);

    /**
     * start with value. 以value开始.
     *
     * @param name         the name
     * @param value        the value
     * @param queryPolicy  the query policy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L sw6(SerializableFunction<E6, String> name, String value, MatchStrategy queryPolicy,
            Predicate<String> ignoreStrategy);

    /**
     * start with value. 以value开始.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    default L sw6(SerializableStringSupplier property) {
        return sw6(property, MatchStrategy.AUTO);
    }

    /**
     * start with value. 以value开始.
     *
     * @param property     对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L sw6(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return sw6(property, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * start with value. 以value开始.
     *
     * @param property    the property
     * @param queryPolicy the query policy
     * @return LogicExpression
     */
    L sw6(SerializableStringSupplier property, MatchStrategy queryPolicy);

    /**
     * start with value. 以value开始.
     *
     * @param property     the property
     * @param queryPolicy  the query policy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L sw6(SerializableStringSupplier property, MatchStrategy queryPolicy, Predicate<String> ignoreStrategy);

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
    //    <R> L sw6(SerializableFunction<E6, R> fetchEntity, SerializableFunction<R, String> fetchEntityProperty,
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
    //    <R> L sw6(SerializableSupplier6<R> fetchEntityValue, SerializableFunction<R, String> fetchEntityProperty);

}