
package cn.featherfly.hammer.expression.repository.condition.sw;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.sw.StartWithExpression;

/**
 * repository start with expression .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryStartWithExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends StartWithExpression<C, L> {

    /**
     * start with value. 以value开始.
     *
     * @param <T>          the generic type
     * @param propertyName the property name
     * @param value        参数值
     * @return LogicExpression
     */
    default <T> L sw(SerializableToStringFunction<T> propertyName, String value) {
        return sw(propertyName, value, MatchStrategy.AUTO);
    }

    /**
     * start with value. 以value开始.
     *
     * @param <T>            the generic type
     * @param propertyName   the property name
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L sw(SerializableToStringFunction<T> propertyName, String value, IgnoreStrategy ignoreStrategy) {
        return sw(propertyName, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * start with value. 以value开始.
     *
     * @param <T>            the generic type
     * @param propertyName   the property name
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L sw(SerializableToStringFunction<T> propertyName, String value, Predicate<String> ignoreStrategy) {
        return sw(propertyName, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * start with value. 以value开始.
     *
     * @param <T>           the generic type
     * @param propertyName  the property name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return the l
     */
    <T> L sw(SerializableToStringFunction<T> propertyName, String value, MatchStrategy matchStrategy);

    /**
     * start with value. 以value开始.
     *
     * @param <T>            the generic type
     * @param propertyName   the property name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    <T> L sw(SerializableToStringFunction<T> propertyName, String value, MatchStrategy matchStrategy,
            IgnoreStrategy ignoreStrategy);

    /**
     * start with value. 以value开始.
     *
     * @param <T>            the generic type
     * @param propertyName   the property name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    <T> L sw(SerializableToStringFunction<T> propertyName, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy);

    /**
     * start with value. 以value开始.
     *
     * @param propertyValue the property value
     * @return LogicExpression
     */
    default L sw(SerializableStringSupplier propertyValue) {
        return sw(propertyValue, MatchStrategy.AUTO);
    }

    /**
     * start with value. 以value开始.
     *
     * @param propertyValue  the property value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L sw(SerializableStringSupplier propertyValue, IgnoreStrategy ignoreStrategy) {
        return sw(propertyValue, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * start with value. 以value开始.
     *
     * @param propertyValue  the property value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L sw(SerializableStringSupplier propertyValue, Predicate<String> ignoreStrategy) {
        return sw(propertyValue, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * start with value. 以value开始.
     *
     * @param propertyValue the property value
     * @param matchStrategy the match strategy
     * @return the l
     */
    L sw(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy);

    /**
     * start with value. 以value开始.
     *
     * @param propertyValue  the property value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    L sw(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy);

    /**
     * start with value. 以value开始.
     *
     * @param propertyValue  the property value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    L sw(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);

}