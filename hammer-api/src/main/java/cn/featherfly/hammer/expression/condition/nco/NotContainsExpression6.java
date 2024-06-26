
package cn.featherfly.hammer.expression.condition.nco;

import java.util.function.Predicate;

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.AliasField;
import cn.featherfly.common.repository.Field;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * not contains expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface NotContainsExpression6<C extends ConditionExpression, L extends LogicExpression<C, L>> {

    /**
     * not contains value. 不包含value.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default L nco6(String name, String value) {
        return nco6(name, value, MatchStrategy.AUTO);
    }

    /**
     * not contains value. 不包含value.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nco6(String name, String value, IgnoreStrategy ignoreStrategy) {
        return nco6(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not contains value. 不包含value.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nco6(String name, String value, Predicate<String> ignoreStrategy) {
        return nco6(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not contains value. 不包含value.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L nco6(String name, String value, MatchStrategy matchStrategy);

    /**
     * not contains value. 不包含value.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nco6(String name, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return nco6(name, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * not contains value. 不包含value.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nco6(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * not contains value. 不包含value.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L nco6(Field field, String value) {
        return nco6(field.name(), value);
    }

    /**
     * not contains value. 不包含value.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nco6(Field field, String value, IgnoreStrategy ignoreStrategy) {
        return nco6(field.name(), value, ignoreStrategy);
    }

    /**
     * not contains value. 不包含value.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nco6(Field field, String value, Predicate<String> ignoreStrategy) {
        return nco6(field.name(), value, ignoreStrategy);
    }

    /**
     * not contains value. 不包含value.
     *
     * @param field         the field
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L nco6(Field field, String value, MatchStrategy matchStrategy) {
        return nco6(field.name(), value, matchStrategy);
    }

    /**
     * not contains value. 不包含value.
     *
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nco6(Field field, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return nco6(field.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * not contains value. 不包含value.
     *
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nco6(Field field, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return nco6(field.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * not contains value. 不包含value.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L nco6(AliasField field, String value) {
        return nco6(field.getAliasOrName(), value);
    }

    /**
     * not contains value. 不包含value.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nco6(AliasField field, String value, IgnoreStrategy ignoreStrategy) {
        return nco6(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * not contains value. 不包含value.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nco6(AliasField field, String value, Predicate<String> ignoreStrategy) {
        return nco6(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * not contains value. 不包含value.
     *
     * @param field         the field
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L nco6(AliasField field, String value, MatchStrategy matchStrategy) {
        return nco6(field.getAliasOrName(), value, matchStrategy);
    }

    /**
     * not contains value. 不包含value.
     *
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nco6(AliasField field, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return nco6(field.getAliasOrName(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * not contains value. 不包含value.
     *
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nco6(AliasField field, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return nco6(field.getAliasOrName(), value, matchStrategy, ignoreStrategy);
    }
}