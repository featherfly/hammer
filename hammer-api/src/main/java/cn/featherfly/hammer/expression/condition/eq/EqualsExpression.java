
package cn.featherfly.hammer.expression.condition.eq;

import java.io.Serializable;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

import cn.featherfly.common.function.CharPredicate;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.AliasField;
import cn.featherfly.common.repository.Field;
import cn.featherfly.common.repository.FieldAware;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * equals expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EqualsExpression<C extends ConditionExpression, L extends LogicExpression<C, L>> {
    /**
     * equals. 等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L eq(String name, Field value);

    /**
     * equals. 等于.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L eq(Field field, Field value) {
        return eq(field.name(), value);
    }

    /**
     * equals. 等于.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L eq(AliasField field, Field value) {
        return eq(field.getAliasOrName(), value);
    }

    /**
     * equals. 等于.
     *
     * @param <F>   the generic type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default <F extends Field> L eq(String name, FieldAware<F> value) {
        return eq(name, value.field());
    }

    /**
     * equals. 等于.
     *
     * @param <F>   the generic type
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <F extends Field> L eq(Field field, FieldAware<F> value) {
        return eq(field, value.field());
    }

    /**
     * equals. 等于.
     *
     * @param <F>   the generic type
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <F extends Field> L eq(AliasField field, FieldAware<F> value) {
        return eq(field, value.field());
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * equals. 等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L eq(String name, boolean value);

    /**
     * equals. 等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L eq(String name, char value);

    /**
     * equals. 等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq(String name, char value, CharPredicate ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L eq(String name, int value);

    /**
     * equals. 等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq(String name, int value, IntPredicate ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L eq(String name, long value);

    /**
     * equals. 等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq(String name, long value, LongPredicate ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L eq(String name, double value);

    /**
     * equals. 等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq(String name, double value, DoublePredicate ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default L eq(String name, String value) {
        return eq(name, value, MatchStrategy.AUTO);
    }

    /**
     * equals. 等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(String name, String value, IgnoreStrategy ignoreStrategy) {
        return eq(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(String name, String value, Predicate<String> ignoreStrategy) {
        return eq(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L eq(String name, String value, MatchStrategy matchStrategy);

    /**
     * equals. 等于.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(String name, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return eq(name, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * equals. 等于.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param <R>   the generic type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <R extends Serializable> L eq(String name, R value);

    /**
     * equals. 等于.
     *
     * @param <R>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R extends Serializable> L eq(String name, R value, IgnoreStrategy ignoreStrategy) {
        return eq(name, value, (Predicate<R>) ignoreStrategy::test);
    }

    /**
     * equals. 等于.
     *
     * @param <R>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R extends Serializable> L eq(String name, R value, Predicate<R> ignoreStrategy);

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * equals. 等于.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L eq(Field field, String value) {
        return eq(field.name(), value);
    }

    /**
     * equals. 等于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(Field field, String value, IgnoreStrategy ignoreStrategy) {
        return eq(field.name(), value, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(Field field, String value, Predicate<String> ignoreStrategy) {
        return eq(field.name(), value, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param field         the field
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L eq(Field field, String value, MatchStrategy matchStrategy) {
        return eq(field.name(), value, matchStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(Field field, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return eq(field.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(Field field, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return eq(field.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param <R>   the generic type
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <R extends Serializable> L eq(Field field, R value) {
        return eq(field.name(), value);
    }

    /**
     * equals. 等于.
     *
     * @param <R>            the generic type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R extends Serializable> L eq(Field field, R value, IgnoreStrategy ignoreStrategy) {
        return eq(field.name(), value, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param <R>            the generic type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R extends Serializable> L eq(Field field, R value, Predicate<R> ignoreStrategy) {
        return eq(field.name(), value, ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * equals. 等于.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L eq(AliasField field, String value) {
        return eq(field.getAliasOrName(), value);
    }

    /**
     * equals. 等于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(AliasField field, String value, IgnoreStrategy ignoreStrategy) {
        return eq(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(AliasField field, String value, Predicate<String> ignoreStrategy) {
        return eq(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param field         the field
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L eq(AliasField field, String value, MatchStrategy matchStrategy) {
        return eq(field.getAliasOrName(), value, matchStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(AliasField field, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return eq(field.getAliasOrName(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(AliasField field, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return eq(field.getAliasOrName(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param <R>   the generic type
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <R extends Serializable> L eq(AliasField field, R value) {
        return eq(field.getAliasOrName(), value);
    }

    /**
     * equals. 等于.
     *
     * @param <R>            the generic type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R extends Serializable> L eq(AliasField field, R value, IgnoreStrategy ignoreStrategy) {
        return eq(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param <R>            the generic type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R extends Serializable> L eq(AliasField field, R value, Predicate<R> ignoreStrategy) {
        return eq(field.getAliasOrName(), value, ignoreStrategy);
    }
}