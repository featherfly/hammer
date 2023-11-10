
package cn.featherfly.hammer.expression.condition.newv;

import java.util.function.Predicate;

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.AliasField;
import cn.featherfly.common.repository.Field;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * not end with expression3.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface NotEndWithExpression3<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends NotEndWithExpression2<C, L>, NotEndWithSupplierExpression3<C, L> {

    /**
     * not end with value. 不以value结尾.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default L new3(String name, String value) {
        return new3(name, value, MatchStrategy.AUTO);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L new3(String name, String value, IgnoreStrategy ignoreStrategy) {
        return new3(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L new3(String name, String value, Predicate<String> ignoreStrategy) {
        return new3(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L new3(String name, String value, MatchStrategy matchStrategy);

    /**
     * not end with value. 不以value结尾.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L new3(String name, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return new3(name, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
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
    L new3(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * not end with value. 不以value结尾.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L new3(Field field, String value) {
        return new3(field.name(), value);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L new3(Field field, String value, IgnoreStrategy ignoreStrategy) {
        return new3(field.name(), value, ignoreStrategy);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L new3(Field field, String value, Predicate<String> ignoreStrategy) {
        return new3(field.name(), value, ignoreStrategy);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param field         the field
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L new3(Field field, String value, MatchStrategy matchStrategy) {
        return new3(field.name(), value, matchStrategy);
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
    default L new3(Field field, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return new3(field.name(), value, matchStrategy, ignoreStrategy);
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
    default L new3(Field field, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return new3(field.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L new3(AliasField field, String value) {
        return new3(field.getAliasOrName(), value);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L new3(AliasField field, String value, IgnoreStrategy ignoreStrategy) {
        return new3(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L new3(AliasField field, String value, Predicate<String> ignoreStrategy) {
        return new3(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param field         the field
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L new3(AliasField field, String value, MatchStrategy matchStrategy) {
        return new3(field.getAliasOrName(), value, matchStrategy);
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
    default L new3(AliasField field, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return new3(field.getAliasOrName(), value, matchStrategy, ignoreStrategy);
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
    default L new3(AliasField field, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return new3(field.getAliasOrName(), value, matchStrategy, ignoreStrategy);
    }
}