
package cn.featherfly.hammer.expression.condition;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.Field;
import cn.featherfly.common.repository.IgnoreStrategy;

/**
 * StartWithExpression .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface NotStartWithExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends StringNotStartWithExpression<C, L> {

    /**
     * not start with value. 不以value开始.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default L nsw(Field name, String value) {
        return nsw(name.name(), value);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nsw(Field name, String value, IgnoreStrategy ignoreStrategy) {
        return nsw(name.name(), value, ignoreStrategy);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nsw(Field name, String value, Predicate<String> ignoreStrategy) {
        return nsw(name.name(), value, ignoreStrategy);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the query strategy
     * @return the l
     */
    default L nsw(Field name, String value, MatchStrategy matchStrategy) {
        return nsw(name.name(), value, matchStrategy);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    default L nsw(Field name, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return nsw(name.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    default L nsw(Field name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return nsw(name.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param <T>          the generic type
     * @param propertyName the property name
     * @param value        参数值
     * @return LogicExpression
     */
    default <T> L nsw(SerializableToStringFunction<T> propertyName, String value) {
        return nsw(propertyName, value, MatchStrategy.AUTO);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param <T>            the generic type
     * @param propertyName   the property name
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L nsw(SerializableToStringFunction<T> propertyName, String value, IgnoreStrategy ignoreStrategy) {
        return nsw(propertyName, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param <T>            the generic type
     * @param propertyName   the property name
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L nsw(SerializableToStringFunction<T> propertyName, String value, Predicate<String> ignoreStrategy) {
        return nsw(propertyName, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param <T>           the generic type
     * @param propertyName  the property name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return the l
     */
    <T> L nsw(SerializableToStringFunction<T> propertyName, String value, MatchStrategy matchStrategy);

    /**
     * not start with value. 不以value开始.
     *
     * @param <T>            the generic type
     * @param propertyName   the property name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    <T> L nsw(SerializableToStringFunction<T> propertyName, String value, MatchStrategy matchStrategy,
            IgnoreStrategy ignoreStrategy);

    /**
     * not start with value. 不以value开始.
     *
     * @param <T>            the generic type
     * @param propertyName   the property name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    <T> L nsw(SerializableToStringFunction<T> propertyName, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy);

    /**
     * not start with value. 不以value开始.
     *
     * @param propertyValue the property value
     * @return LogicExpression
     */
    default L nsw(SerializableStringSupplier propertyValue) {
        return nsw(propertyValue, MatchStrategy.AUTO);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param propertyValue  the property value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nsw(SerializableStringSupplier propertyValue, IgnoreStrategy ignoreStrategy) {
        return nsw(propertyValue, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param propertyValue  the property value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nsw(SerializableStringSupplier propertyValue, Predicate<String> ignoreStrategy) {
        return nsw(propertyValue, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param propertyValue the property value
     * @param matchStrategy the match strategy
     * @return the l
     */
    L nsw(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy);

    /**
     * not start with value. 不以value开始.
     *
     * @param propertyValue  the property value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    L nsw(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy);

    /**
     * not start with value. 不以value开始.
     *
     * @param propertyValue  the property value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    L nsw(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);

}