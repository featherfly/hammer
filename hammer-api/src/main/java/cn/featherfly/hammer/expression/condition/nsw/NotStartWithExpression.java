
package cn.featherfly.hammer.expression.condition.nsw;

import java.util.function.Predicate;

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.AliasField;
import cn.featherfly.common.repository.Field;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * not start with expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface NotStartWithExpression<C extends ConditionExpression, L extends LogicExpression<C, L>> {

    /**
     * not start with value. 不以value开始.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L nsw(Field field, String value) {
        return nsw(field.name(), value);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nsw(Field field, String value, IgnoreStrategy ignoreStrategy) {
        return nsw(field.name(), value, ignoreStrategy);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nsw(Field field, String value, Predicate<String> ignoreStrategy) {
        return nsw(field.name(), value, ignoreStrategy);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param field         the field
     * @param value         the value
     * @param matchStrategy the query strategy
     * @return LogicExpression
     */
    default L nsw(Field field, String value, MatchStrategy matchStrategy) {
        return nsw(field.name(), value, matchStrategy);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nsw(Field field, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return nsw(field.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nsw(Field field, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return nsw(field.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default L nsw(String name, String value) {
        return nsw(name, value, MatchStrategy.AUTO);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nsw(String name, String value, IgnoreStrategy ignoreStrategy) {
        return nsw(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nsw(String name, String value, Predicate<String> ignoreStrategy) {
        return nsw(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L nsw(String name, String value, MatchStrategy matchStrategy);

    /**
     * not start with value. 不以value开始.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nsw(String name, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return nsw(name, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nsw(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);

    /**
     * not start with value. 不以value开始.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L nsw(AliasField field, String value) {
        return nsw(field.getAliasOrName(), value);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nsw(AliasField field, String value, IgnoreStrategy ignoreStrategy) {
        return nsw(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nsw(AliasField field, String value, Predicate<String> ignoreStrategy) {
        return nsw(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param field         the field
     * @param value         the value
     * @param matchStrategy the query strategy
     * @return LogicExpression
     */
    default L nsw(AliasField field, String value, MatchStrategy matchStrategy) {
        return nsw(field.getAliasOrName(), value, matchStrategy);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nsw(AliasField field, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return nsw(field.getAliasOrName(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nsw(AliasField field, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return nsw(field.getAliasOrName(), value, matchStrategy, ignoreStrategy);
    }
}