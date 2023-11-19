
package cn.featherfly.hammer.expression.condition.sw;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.AliasField;
import cn.featherfly.common.repository.Field;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * start with expression.
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
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L sw(Field field, String value) {
        return sw(field.name(), value);
    }

    /**
     * start with value. 以value开始.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L sw(Field field, String value, IgnoreStrategy ignoreStrategy) {
        return sw(field.name(), value, ignoreStrategy);
    }

    /**
     * start with value. 以value开始.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L sw(Field field, String value, Predicate<String> ignoreStrategy) {
        return sw(field.name(), value, ignoreStrategy);
    }

    /**
     * start with value. 以value开始.
     *
     * @param field         the field
     * @param value         the value
     * @param matchStrategy the query strategy
     * @return LogicExpression
     */
    default L sw(Field field, String value, MatchStrategy matchStrategy) {
        return sw(field.name(), value, matchStrategy);
    }

    /**
     * start with value. 以value开始.
     *
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L sw(Field field, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return sw(field.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * start with value. 以value开始.
     *
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L sw(Field field, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return sw(field.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * start with value. 以value开始.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L sw(AliasField field, String value) {
        return sw(field.getAliasOrName(), value);
    }

    /**
     * start with value. 以value开始.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L sw(AliasField field, String value, IgnoreStrategy ignoreStrategy) {
        return sw(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * start with value. 以value开始.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L sw(AliasField field, String value, Predicate<String> ignoreStrategy) {
        return sw(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * start with value. 以value开始.
     *
     * @param field         the field
     * @param value         the value
     * @param matchStrategy the query strategy
     * @return LogicExpression
     */
    default L sw(AliasField field, String value, MatchStrategy matchStrategy) {
        return sw(field.getAliasOrName(), value, matchStrategy);
    }

    /**
     * start with value. 以value开始.
     *
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L sw(AliasField field, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return sw(field.getAliasOrName(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * start with value. 以value开始.
     *
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L sw(AliasField field, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return sw(field.getAliasOrName(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * start with value. 以value开始.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default L sw(String name, String value) {
        return sw(name, value, MatchStrategy.AUTO);
    }

    /**
     * start with value. 以value开始.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L sw(String name, String value, IgnoreStrategy ignoreStrategy) {
        return sw(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * start with value. 以value开始.
     *
     * @param name           the name
     * @param value          the value
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
     * @return LogicExpression
     */
    L sw(String name, String value, MatchStrategy matchStrategy);

    /**
     * start with value. 以value开始.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L sw(String name, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return sw(name, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * start with value. 以value开始.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L sw(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);

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
     * @return LogicExpression
     */
    L sw(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy);

    /**
     * start with value. 以value开始.
     *
     * @param propertyValue  the property value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L sw(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return sw(propertyValue, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * start with value. 以value开始.
     *
     * @param propertyValue  the property value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L sw(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);
}