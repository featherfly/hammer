
package cn.featherfly.hammer.expression.condition.ew;

import java.util.function.Predicate;

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.AliasField;
import cn.featherfly.common.repository.Field;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * end with expression5.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EndWithExpression5<C extends ConditionExpression, L extends LogicExpression<C, L>> {

    /**
     * end with value. 以value结尾.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default L ew5(String name, String value) {
        return ew5(name, value, MatchStrategy.AUTO);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ew5(String name, String value, IgnoreStrategy ignoreStrategy) {
        return ew5(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ew5(String name, String value, Predicate<String> ignoreStrategy) {
        return ew5(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L ew5(String name, String value, MatchStrategy matchStrategy);

    /**
     * end with value. 以value结尾.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ew5(String name, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return ew5(name, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ew5(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * end with value. 以value结尾.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L ew5(Field field, String value) {
        return ew5(field.name(), value);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ew5(Field field, String value, IgnoreStrategy ignoreStrategy) {
        return ew5(field.name(), value, ignoreStrategy);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ew5(Field field, String value, Predicate<String> ignoreStrategy) {
        return ew5(field.name(), value, ignoreStrategy);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param field         the field
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L ew5(Field field, String value, MatchStrategy matchStrategy) {
        return ew5(field.name(), value, matchStrategy);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ew5(Field field, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return ew5(field.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ew5(Field field, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return ew5(field.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L ew5(AliasField field, String value) {
        return ew5(field.getAliasOrName(), value);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ew5(AliasField field, String value, IgnoreStrategy ignoreStrategy) {
        return ew5(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ew5(AliasField field, String value, Predicate<String> ignoreStrategy) {
        return ew5(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param field         the field
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L ew5(AliasField field, String value, MatchStrategy matchStrategy) {
        return ew5(field.getAliasOrName(), value, matchStrategy);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ew5(AliasField field, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return ew5(field.getAliasOrName(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ew5(AliasField field, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return ew5(field.getAliasOrName(), value, matchStrategy, ignoreStrategy);
    }
}