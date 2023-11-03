
package cn.featherfly.hammer.expression.condition.newv;

import java.util.function.Predicate;

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.AliasField;
import cn.featherfly.common.repository.Field;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * not end with expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface NotEndWithExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends NotEndWithSupplierExpression<C, L> {

    /**
     * not end with value. 不以value结尾.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default L newv(String name, String value) {
        return newv(name, value, MatchStrategy.AUTO);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L newv(String name, String value, IgnoreStrategy ignoreStrategy) {
        return newv(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L newv(String name, String value, Predicate<String> ignoreStrategy) {
        return newv(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L newv(String name, String value, MatchStrategy matchStrategy);

    /**
     * not end with value. 不以value结尾.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L newv(String name, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return newv(name, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L newv(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * not end with value. 不以value结尾.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L newv(Field field, String value) {
        return newv(field.name(), value);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L newv(Field field, String value, IgnoreStrategy ignoreStrategy) {
        return newv(field.name(), value, ignoreStrategy);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L newv(Field field, String value, Predicate<String> ignoreStrategy) {
        return newv(field.name(), value, ignoreStrategy);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param field         the field
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L newv(Field field, String value, MatchStrategy matchStrategy) {
        return newv(field.name(), value, matchStrategy);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L newv(Field field, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return newv(field.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L newv(Field field, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return newv(field.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L newv(AliasField field, String value) {
        return newv(field.getAliasOrName(), value);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L newv(AliasField field, String value, IgnoreStrategy ignoreStrategy) {
        return newv(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L newv(AliasField field, String value, Predicate<String> ignoreStrategy) {
        return newv(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param field         the field
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L newv(AliasField field, String value, MatchStrategy matchStrategy) {
        return newv(field.getAliasOrName(), value, matchStrategy);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L newv(AliasField field, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return newv(field.getAliasOrName(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L newv(AliasField field, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return newv(field.getAliasOrName(), value, matchStrategy, ignoreStrategy);
    }
}