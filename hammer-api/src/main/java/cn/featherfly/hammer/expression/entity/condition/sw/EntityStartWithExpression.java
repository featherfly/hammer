
package cn.featherfly.hammer.expression.entity.condition.sw;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityStartWithExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityStartWithExpression<E, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    //    /**
    //     * start with value. 以value开始.
    //     *
    //     * @param consumer the consumer
    //     * @return LogicExpression
    //     */
    //    L sw(Consumer<EntityStartWithExpression<E, C, L>> consumer);

    /**
     * start with value. 以value开始.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default L sw(SerializableFunction<E, String> name, String value) {
        return sw(name, value, MatchStrategy.AUTO);
    }

    /**
     * start with value. 以value开始.
     *
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L sw(SerializableFunction<E, String> name, String value, Predicate<String> ignoreStrategy) {
        return sw(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * start with value. 以value开始.
     *
     * @param name        the name
     * @param value       the value
     * @param queryPolicy the query policy
     * @return the l
     */
    L sw(SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy);

    /**
     * start with value. 以value开始.
     *
     * @param name         the name
     * @param value        the value
     * @param queryPolicy  the query policy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    L sw(SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);

    /**
     * start with value. 以value开始.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    default L sw(SerializableStringSupplier property) {
        return sw(property, MatchStrategy.AUTO);
    }

    /**
     * start with value. 以value开始.
     *
     * @param property     对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L sw(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return sw(property, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * start with value. 以value开始.
     *
     * @param property    the property
     * @param queryPolicy the query policy
     * @return the l
     */
    L sw(SerializableStringSupplier property, MatchStrategy matchStrategy);

    /**
     * start with value. 以value开始.
     *
     * @param property     the property
     * @param queryPolicy  the query policy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    L sw(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);

    //  嵌套属性使用property(U1::getU2).property(U2:getV).sw(v)来设置
    //    /**
    //     * 以value开始.
    //     *
    //     * @param <R>        the generic type
    //     * @param repository the repository
    //     * @param property   the property
    //     * @param value      参数值
    //     * @return LogicExpression
    //     */
    //    <R> L sw(SerializableFunction<E, R> repository, SerializableFunction<R, String> property, String value);
    //
    //    /**
    //     * 以value开始.
    //     *
    //     * @param <R>        the generic type
    //     * @param repository the repository
    //     * @param property   对象属性
    //     * @return LogicExpression
    //     */
    //    <R> L sw(SerializableSupplier<R> repository, SerializableFunction<R, String> property);
}