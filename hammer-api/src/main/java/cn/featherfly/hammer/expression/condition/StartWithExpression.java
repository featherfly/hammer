
package cn.featherfly.hammer.expression.condition;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.Field;

/**
 * StartWithExpression .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface StartWithExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * start with value. 以value开始.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default L sw(Field name, String value) {
        return sw(name.name(), value);
    }

    /**
     * start with value. 以value开始.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L sw(Field name, String value, Predicate<String> ignoreStrategy) {
        return sw(name.name(), value, ignoreStrategy);
    }

    /**
     * start with value. 以value开始.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the query strategy
     * @return the l
     */
    default L sw(Field name, String value, MatchStrategy matchStrategy) {
        return sw(name.name(), value, matchStrategy);
    }

    /**
     * start with value. 以value开始.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    default L sw(Field name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return sw(name.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * start with value. 以value开始.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default L sw(String name, String value) {
        return sw(name, value, MatchStrategy.AUTO);
    }

    /**
     * start with value. 以value开始.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L sw(String name, String value, Predicate<String> ignoreStrategy) {
        return sw(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * start with value. 以value开始.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return the l
     */
    L sw(String name, String value, MatchStrategy matchStrategy);

    /**
     * start with value. 以value开始.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    L sw(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);

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
    L sw(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);

}