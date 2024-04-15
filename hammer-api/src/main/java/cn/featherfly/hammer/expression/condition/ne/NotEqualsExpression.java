
package cn.featherfly.hammer.expression.condition.ne;

import java.io.Serializable;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

import cn.featherfly.common.function.CharPredicate;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.AliasField;
import cn.featherfly.common.repository.Field;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * not equals expression .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface NotEqualsExpression<C extends ConditionExpression, L extends LogicExpression<C, L>> {

    /**
     * not equals. 不等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L ne(String name, boolean value);

    /**
     * not equals. 不等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L ne(String name, char value);

    /**
     * not equals. 不等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne(String name, char value, CharPredicate ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L ne(String name, int value);

    /**
     * not equals. 不等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne(String name, int value, IntPredicate ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L ne(String name, long value);

    /**
     * not equals. 不等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne(String name, long value, LongPredicate ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L ne(String name, double value);

    /**
     * not equals. 不等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne(String name, double value, DoublePredicate ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default L ne(String name, String value) {
        return ne(name, value, MatchStrategy.AUTO);
    }

    /**
     * not equals. 不等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne(String name, String value, IgnoreStrategy ignoreStrategy) {
        return ne(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne(String name, String value, Predicate<String> ignoreStrategy) {
        return ne(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the query policy
     * @return LogicExpression
     */
    L ne(String name, String value, MatchStrategy matchStrategy);

    /**
     * not equals. 不等于.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne(String name, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return ne(name, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * not equals. 不等于.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <R extends Serializable> L ne(String name, R value);

    /**
     * not equals. 不等于.
     *
     * @param <R>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R extends Serializable> L ne(String name, R value, IgnoreStrategy ignoreStrategy) {
        return ne(name, value, (Predicate<R>) ignoreStrategy::test);
    }

    /**
     * not equals. 不等于.
     *
     * @param <R>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R extends Serializable> L ne(String name, R value, Predicate<R> ignoreStrategy);

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * not equals. 不等于.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <R extends Serializable> L ne(Field field, R value) {
        return ne(field.name(), value);
    }

    /**
     * not equals. 不等于.
     *
     * @param <R>            the generic type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R extends Serializable> L ne(Field field, R value, IgnoreStrategy ignoreStrategy) {
        return ne(field.name(), value, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param <R>            the generic type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R extends Serializable> L ne(Field field, R value, Predicate<R> ignoreStrategy) {
        return ne(field.name(), value, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L ne(Field field, String value) {
        return ne(field.name(), value);
    }

    /**
     * not equals. 不等于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne(Field field, String value, IgnoreStrategy ignoreStrategy) {
        return ne(field.name(), value, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne(Field field, String value, Predicate<String> ignoreStrategy) {
        return ne(field.name(), value, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param field         the field
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L ne(Field field, String value, MatchStrategy matchStrategy) {
        return ne(field.name(), value, matchStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne(Field field, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return ne(field.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne(Field field, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return ne(field.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <R extends Serializable> L ne(AliasField field, R value) {
        return ne(field.getAliasOrName(), value);
    }

    /**
     * not equals. 不等于.
     *
     * @param <R>            the generic type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R extends Serializable> L ne(AliasField field, R value, IgnoreStrategy ignoreStrategy) {
        return ne(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param <R>            the generic type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R extends Serializable> L ne(AliasField field, R value, Predicate<R> ignoreStrategy) {
        return ne(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L ne(AliasField field, String value) {
        return ne(field.getAliasOrName(), value);
    }

    /**
     * not equals. 不等于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne(AliasField field, String value, IgnoreStrategy ignoreStrategy) {
        return ne(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne(AliasField field, String value, Predicate<String> ignoreStrategy) {
        return ne(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param field         the field
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L ne(AliasField field, String value, MatchStrategy matchStrategy) {
        return ne(field.getAliasOrName(), value, matchStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne(AliasField field, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return ne(field.getAliasOrName(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne(AliasField field, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return ne(field.getAliasOrName(), value, matchStrategy, ignoreStrategy);
    }
}