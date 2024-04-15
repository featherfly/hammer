
package cn.featherfly.hammer.expression.condition.co;

import java.util.function.Predicate;

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.AliasField;
import cn.featherfly.common.repository.Field;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface ContainsExpression3.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface ContainsExpression3<C extends ConditionExpression, L extends LogicExpression<C, L>> {

    /**
     * contains value. 包含value.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default L co3(String name, String value) {
        return co3(name, value, MatchStrategy.AUTO);
    }

    /**
     * contains value. 包含value.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L co3(String name, String value, IgnoreStrategy ignoreStrategy) {
        return co3(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * contains value. 包含value.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L co3(String name, String value, Predicate<String> ignoreStrategy) {
        return co3(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * contains value. 包含value.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L co3(String name, String value, MatchStrategy matchStrategy);

    /**
     * contains value. 包含value.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L co3(String name, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return co3(name, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * contains value. 包含value.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L co3(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);

    /**
     * contains value. 包含value.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default L co3(Field field, String value) {
        return co3(field.name(), value);
    }

    /**
     * contains value. 包含value.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L co3(Field field, String value, IgnoreStrategy ignoreStrategy) {
        return co3(field.name(), value, ignoreStrategy);
    }

    /**
     * contains value. 包含value.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L co3(Field field, String value, Predicate<String> ignoreStrategy) {
        return co3(field.name(), value, ignoreStrategy);
    }

    /**
     * contains value. 包含value.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L co3(Field field, String value, MatchStrategy matchStrategy) {
        return co3(field.name(), value, matchStrategy);
    }

    /**
     * contains value. 包含value.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L co3(Field field, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return co3(field.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * contains value. 包含value.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L co3(Field field, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return co3(field.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * contains value. 包含value.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L co3(AliasField field, String value) {
        return co3(field.getAliasOrName(), value);
    }

    /**
     * contains value. 包含value.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L co3(AliasField field, String value, IgnoreStrategy ignoreStrategy) {
        return co3(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * contains value. 包含value.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L co3(AliasField field, String value, Predicate<String> ignoreStrategy) {
        return co3(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * contains value. 包含value.
     *
     * @param field         the field
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L co3(AliasField field, String value, MatchStrategy matchStrategy) {
        return co3(field.getAliasOrName(), value, matchStrategy);
    }

    /**
     * contains value. 包含value.
     *
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L co3(AliasField field, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return co3(field.getAliasOrName(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * contains value. 包含value.
     *
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L co3(AliasField field, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return co3(field.getAliasOrName(), value, matchStrategy, ignoreStrategy);
    }
}