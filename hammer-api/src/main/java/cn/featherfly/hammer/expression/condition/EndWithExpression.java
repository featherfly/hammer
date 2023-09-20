
package cn.featherfly.hammer.expression.condition;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.Field;
import cn.featherfly.common.repository.IgnoreStrategy;

/**
 * EndWithExpression .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EndWithExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends StringEndWithExpression<C, L> {

    /**
     * end with value. 以value结尾.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default L ew(Field name, String value) {
        return ew(name.name(), value);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ew(Field name, String value, IgnoreStrategy ignoreStrategy) {
        return ew(name.name(), value, ignoreStrategy);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ew(Field name, String value, Predicate<String> ignoreStrategy) {
        return ew(name.name(), value, ignoreStrategy);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return the l
     */
    default L ew(Field name, String value, MatchStrategy matchStrategy) {
        return ew(name.name(), value, matchStrategy);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    default L ew(Field name, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return ew(name.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    default L ew(Field name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return ew(name.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param <T>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default <T> L ew(SerializableToStringFunction<T> name, String value) {
        return ew(name, value, MatchStrategy.AUTO);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param <T>            the generic type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ew(SerializableToStringFunction<T> name, String value, IgnoreStrategy ignoreStrategy) {
        return ew(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param <T>            the generic type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ew(SerializableToStringFunction<T> name, String value, Predicate<String> ignoreStrategy) {
        return ew(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param <T>           the generic type
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return the l
     */
    <T> L ew(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy);

    /**
     * end with value. 以value结尾.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    <T> L ew(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy,
            IgnoreStrategy ignoreStrategy);

    /**
     * end with value. 以value结尾.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    <T> L ew(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy);

    /**
     * end with value. 以value结尾.
     *
     * @param propertyValue the property value
     * @return LogicExpression
     */
    default L ew(SerializableStringSupplier propertyValue) {
        return ew(propertyValue, MatchStrategy.AUTO);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param propertyValue  the property value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ew(SerializableStringSupplier propertyValue, IgnoreStrategy ignoreStrategy) {
        return ew(propertyValue, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param propertyValue  the property value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ew(SerializableStringSupplier propertyValue, Predicate<String> ignoreStrategy) {
        return ew(propertyValue, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param propertyValue the property value
     * @param matchStrategy the match strategy
     * @return the l
     */
    L ew(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy);

    /**
     * end with value. 以value结尾.
     *
     * @param propertyValue  the property value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    L ew(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy);

    /**
     * end with value. 以value结尾.
     *
     * @param propertyValue  the property value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    L ew(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);
}