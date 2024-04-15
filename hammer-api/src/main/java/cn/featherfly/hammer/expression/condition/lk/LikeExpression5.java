
package cn.featherfly.hammer.expression.condition.lk;

import java.util.function.Predicate;

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.AliasField;
import cn.featherfly.common.repository.Field;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * like expression5.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface LikeExpression5<C extends ConditionExpression, L extends LogicExpression<C, L>> {
    /**
     * like value.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default L lk5(Field field, String value) {
        return lk5(field.name(), value);
    }

    /**
     * like value.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lk5(Field field, String value, IgnoreStrategy ignoreStrategy) {
        return lk5(field.name(), value, ignoreStrategy);
    }

    /**
     * like value.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lk5(Field field, String value, Predicate<String> ignoreStrategy) {
        return lk5(field.name(), value, ignoreStrategy);
    }

    /**
     * like value.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L lk5(Field field, String value, MatchStrategy matchStrategy) {
        return lk5(field.name(), value, matchStrategy);
    }

    /**
     * like value.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lk5(Field field, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return lk5(field.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * like value.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lk5(Field field, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return lk5(field.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * like value.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L lk5(AliasField field, String value) {
        return lk5(field.getAliasOrName(), value);
    }

    /**
     * like value.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lk5(AliasField field, String value, IgnoreStrategy ignoreStrategy) {
        return lk5(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * like value.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lk5(AliasField field, String value, Predicate<String> ignoreStrategy) {
        return lk5(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * like value.
     *
     * @param field         the field
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L lk5(AliasField field, String value, MatchStrategy matchStrategy) {
        return lk5(field.getAliasOrName(), value, matchStrategy);
    }

    /**
     * like value.
     *
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lk5(AliasField field, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return lk5(field.getAliasOrName(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * like value.
     *
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lk5(AliasField field, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return lk5(field.getAliasOrName(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * like value.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default L lk5(String name, String value) {
        return lk5(name, value, MatchStrategy.AUTO);
    }

    /**
     * like value.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lk5(String name, String value, IgnoreStrategy ignoreStrategy) {
        return lk5(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * like value.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lk5(String name, String value, Predicate<String> ignoreStrategy) {
        return lk5(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * like value.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L lk5(String name, String value, MatchStrategy matchStrategy);

    /**
     * like value.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lk5(String name, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return lk5(name, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * like value.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lk5(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);
}