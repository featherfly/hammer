
package cn.featherfly.hammer.expression.entity.condition.lk;

import java.util.function.Predicate;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableStringSupplier;
import cn.featherfly.common.operator.QueryOperator.QueryPolicy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityLikeExpressionBase6.
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
public interface EntityLikeExpressionBase6<E, E2, E3, E4, E5, E6, C extends ConditionExpression,
        L extends LogicExpression<C, L>> extends EntityLikeExpressionBase5<E, E2, E3, E4, E5, C, L> {

    /**
     * like value.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default L lk6(SerializableFunction<E6, String> name, String value) {
        return lk6(name, value, QueryPolicy.AUTO);
    }

    /**
     * like value.
     *
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lk6(SerializableFunction<E6, String> name, String value, Predicate<String> ignoreStrategy) {
        return lk6(name, value, QueryPolicy.AUTO, ignoreStrategy);
    }

    /**
     * like value.
     *
     * @param name        the name
     * @param value       the value
     * @param queryPolicy the query policy
     * @return LogicExpression
     */
    L lk6(SerializableFunction<E6, String> name, String value, QueryPolicy queryPolicy);

    /**
     * like value.
     *
     * @param name         the name
     * @param value        the value
     * @param queryPolicy  the query policy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lk6(SerializableFunction<E6, String> name, String value, QueryPolicy queryPolicy,
            Predicate<String> ignoreStrategy);

    /**
     * like value.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    default L lk6(SerializableStringSupplier property) {
        return lk6(property, QueryPolicy.AUTO);
    }

    /**
     * like value.
     *
     * @param property     对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lk6(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return lk6(property, QueryPolicy.AUTO, ignoreStrategy);
    }

    /**
     * like value.
     *
     * @param property    the property
     * @param queryPolicy the query policy
     * @return LogicExpression
     */
    L lk6(SerializableStringSupplier property, QueryPolicy queryPolicy);

    /**
     * like value.
     *
     * @param property     the property
     * @param queryPolicy  the query policy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lk6(SerializableStringSupplier property, QueryPolicy queryPolicy, Predicate<String> ignoreStrategy);

    //  嵌套属性使用property(U1::getU2).property(U2:getV).lk(v)来设置
    //    /**
    //     * like value.
    //     *
    //     * @param <R>                 the generic type
    //     * @param fetchEntity         the fetch entity
    //     * @param fetchEntityProperty the fetch entity property
    //     * @param value               参数值
    //     * @return LogicExpression
    //     */
    //    <R> L lk6(SerializableFunction<E6, R> fetchEntity, SerializableFunction<R, String> fetchEntityProperty,
    //            String value);
    //
    //    /**
    //     * like value.
    //     *
    //     * @param <R>                 the generic type
    //     * @param fetchEntityValue    the fetch entity value
    //     * @param fetchEntityProperty the fetch entity property
    //     * @return LogicExpression
    //     */
    //    <R> L lk6(SerializableSupplier6<R> fetchEntityValue, SerializableFunction<R, String> fetchEntityProperty);

}