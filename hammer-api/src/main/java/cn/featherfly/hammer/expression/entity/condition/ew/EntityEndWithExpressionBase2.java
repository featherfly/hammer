
package cn.featherfly.hammer.expression.entity.condition.ew;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityEndWithExpressionBase2.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityEndWithExpressionBase2<E, E2, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends EntityEndWithExpression<E, C, L> {

    /**
     * end with value. 以value结尾.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default L ew2(SerializableFunction<E2, String> name, String value) {
        return ew2(name, value, MatchStrategy.AUTO);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ew2(SerializableFunction<E2, String> name, String value, Predicate<String> ignoreStrategy) {
        return ew2(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param name        the name
     * @param value       the value
     * @param queryPolicy the query policy
     * @return LogicExpression
     */
    L ew2(SerializableFunction<E2, String> name, String value, MatchStrategy matchStrategy);

    /**
     * end with value. 以value结尾.
     *
     * @param name         the name
     * @param value        the value
     * @param queryPolicy  the query policy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ew2(SerializableFunction<E2, String> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy);

    /**
     * end with value. 以value结尾.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    default L ew2(SerializableStringSupplier property) {
        return ew2(property, MatchStrategy.AUTO);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param property     对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ew2(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return ew2(property, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param property    the property
     * @param queryPolicy the query policy
     * @return LogicExpression
     */
    L ew2(SerializableStringSupplier property, MatchStrategy matchStrategy);

    /**
     * end with value. 以value结尾.
     *
     * @param property     the property
     * @param queryPolicy  the query policy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ew2(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);

    //  嵌套属性使用property(U1::getU2).property(U2:getV).ew(v)来设置
    //    /**
    //     * end with value. 以value结尾.
    //     *
    //     * @param <R>                 the generic type
    //     * @param fetchEntity         the fetch entity
    //     * @param fetchEntityProperty the fetch entity property
    //     * @param value               参数值
    //     * @return LogicExpression
    //     */
    //    <R> L ew2(SerializableFunction<E2, R> fetchEntity, SerializableFunction<R, String> fetchEntityProperty,
    //            String value);
    //
    //    /**
    //     * end with value. 以value结尾.
    //     *
    //     * @param <R>                 the generic type
    //     * @param fetchEntityValue    the fetch entity value
    //     * @param fetchEntityProperty the fetch entity property
    //     * @return LogicExpression
    //     */
    //    <R> L ew2(SerializableSupplier2<R> fetchEntityValue, SerializableFunction<R, String> fetchEntityProperty);
}