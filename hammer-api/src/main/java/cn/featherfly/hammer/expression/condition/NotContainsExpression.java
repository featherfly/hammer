
package cn.featherfly.hammer.expression.condition;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.Field;
import cn.featherfly.common.repository.IgnoreStrategy;

/**
 * ContainsExpression .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface NotContainsExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends StringNotContainsExpression<C, L> {

    /**
     * not contains value. 不包含value.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default L nco(Field name, String value) {
        return nco(name.name(), value);
    }

    /**
     * not contains value. 不包含value.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nco(Field name, String value, IgnoreStrategy ignoreStrategy) {
        return nco(name.name(), value, ignoreStrategy);
    }

    /**
     * not contains value. 不包含value.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nco(Field name, String value, Predicate<String> ignoreStrategy) {
        return nco(name.name(), value, ignoreStrategy);
    }

    /**
     * not contains value. 不包含value.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return the l
     */
    default L nco(Field name, String value, MatchStrategy matchStrategy) {
        return nco(name.name(), value, matchStrategy);
    }

    /**
     * not contains value. 不包含value.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    default L nco(Field name, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return nco(name.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * not contains value. 不包含value.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    default L nco(Field name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return nco(name.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * not contains value. 不包含value.
     *
     * @param <T>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default <T> L nco(SerializableToStringFunction<T> name, String value) {
        return nco(name, value, MatchStrategy.AUTO);
    }

    /**
     * not contains value. 不包含value.
     *
     * @param <T>            the generic type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L nco(SerializableToStringFunction<T> name, String value, IgnoreStrategy ignoreStrategy) {
        return nco(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not contains value. 不包含value.
     *
     * @param <T>            the generic type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L nco(SerializableToStringFunction<T> name, String value, Predicate<String> ignoreStrategy) {
        return nco(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not contains value. 不包含value.
     *
     * @param <T>           the generic type
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return the l
     */
    <T> L nco(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy);

    /**
     * not contains value. 不包含value.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    <T> L nco(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy,
            IgnoreStrategy ignoreStrategy);

    /**
     * not contains value. 不包含value.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    <T> L nco(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy);

    /**
     * not contains value. 不包含value.
     *
     * @param propertyValue the property value
     * @return LogicExpression
     */
    default L nco(SerializableStringSupplier propertyValue) {
        return nco(propertyValue, MatchStrategy.AUTO);
    }

    /**
     * not contains value. 不包含value.
     *
     * @param propertyValue  the property value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nco(SerializableStringSupplier propertyValue, IgnoreStrategy ignoreStrategy) {
        return nco(propertyValue, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not contains value. 不包含value.
     *
     * @param propertyValue  the property value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nco(SerializableStringSupplier propertyValue, Predicate<String> ignoreStrategy) {
        return nco(propertyValue, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not contains value. 不包含value.
     *
     * @param propertyValue the property value
     * @param matchStrategy the match strategy
     * @return the l
     */
    L nco(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy);

    /**
     * not contains value. 不包含value.
     *
     * @param propertyValue  the property value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    L nco(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy);

    /**
     * not contains value. 不包含value.
     *
     * @param propertyValue  the property value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    L nco(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);
}