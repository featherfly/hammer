
package cn.featherfly.hammer.expression.condition.nl;

import java.util.function.Predicate;

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.AliasField;
import cn.featherfly.common.repository.Field;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * not like expression3.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface NotLikeExpression3<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends NotLikeExpression2<C, L>, NotLikeSupplierExpression3<C, L> {
    /**
     * not like value.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L nl3(Field field, String value) {
        return nl3(field.name(), value);
    }

    /**
     * not like value.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nl3(Field field, String value, IgnoreStrategy ignoreStrategy) {
        return nl3(field.name(), value, ignoreStrategy);
    }

    /**
     * not like value.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nl3(Field field, String value, Predicate<String> ignoreStrategy) {
        return nl3(field.name(), value, ignoreStrategy);
    }

    /**
     * not like value.
     *
     * @param field         the field
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L nl3(Field field, String value, MatchStrategy matchStrategy) {
        return nl3(field.name(), value, matchStrategy);
    }

    /**
     * not like value.
     *
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nl3(Field field, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return nl3(field.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * not like value.
     *
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nl3(Field field, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return nl3(field.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * not like value.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default L nl3(String name, String value) {
        return nl3(name, value, MatchStrategy.AUTO);
    }

    /**
     * not like value.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nl3(String name, String value, IgnoreStrategy ignoreStrategy) {
        return nl3(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not like value.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nl3(String name, String value, Predicate<String> ignoreStrategy) {
        return nl3(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not like value.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L nl3(String name, String value, MatchStrategy matchStrategy);

    /**
     * not like value.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nl3(String name, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return nl3(name, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * not like value.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nl3(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);

    /**
     * not like value.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L nl3(AliasField field, String value) {
        return nl3(field.getAliasOrName(), value);
    }

    /**
     * not like value.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nl3(AliasField field, String value, IgnoreStrategy ignoreStrategy) {
        return nl3(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * not like value.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nl3(AliasField field, String value, Predicate<String> ignoreStrategy) {
        return nl3(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * not like value.
     *
     * @param field         the field
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L nl3(AliasField field, String value, MatchStrategy matchStrategy) {
        return nl3(field.getAliasOrName(), value, matchStrategy);
    }

    /**
     * not like value.
     *
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nl3(AliasField field, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return nl3(field.getAliasOrName(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * not like value.
     *
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nl3(AliasField field, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return nl3(field.getAliasOrName(), value, matchStrategy, ignoreStrategy);
    }
}