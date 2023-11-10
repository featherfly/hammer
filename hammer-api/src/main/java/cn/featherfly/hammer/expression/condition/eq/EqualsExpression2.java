
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
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * equals expression2.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EqualsExpression2<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends EqualsExpression<C, L>, EqualsSupplierExpression2<C, L> {
    /**
     * equals. 等于.
     *
     * @param <R>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq2(String name, boolean value);

    /**
     * equals. 等于.
     *
     * @param <R>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq2(String name, char value);

    /**
     * equals. 等于.
     *
     * @param <R>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq2(String name, char value, CharPredicate ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param <R>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq2(String name, int value);

    /**
     * equals. 等于.
     *
     * @param <R>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq2(String name, int value, IntPredicate ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param <R>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq2(String name, long value);

    /**
     * equals. 等于.
     *
     * @param <R>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq2(String name, long value, LongPredicate ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param <R>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq2(String name, double value);

    /**
     * equals. 等于.
     *
     * @param <R>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq2(String name, double value, DoublePredicate ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default L eq2(String name, String value) {
        return eq2(name, value, MatchStrategy.AUTO);
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
    default L eq2(String name, String value, IgnoreStrategy ignoreStrategy) {
        return eq2(name, value, MatchStrategy.AUTO, ignoreStrategy);
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
    default L eq2(String name, String value, Predicate<String> ignoreStrategy) {
        return eq2(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L eq2(String name, String value, MatchStrategy matchStrategy);

    /**
     * equals. 等于.
     *
     * @param <R>            the generic type
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq2(String name, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return eq2(name, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * equals. 等于.
     *
     * @param <R>            the generic type
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq2(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <R extends Serializable> L eq2(String name, R value);

    /**
     * equals. 等于.
     *
     * @param <R>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R extends Serializable> L eq2(String name, R value, IgnoreStrategy ignoreStrategy) {
        return eq2(name, value, (Predicate<R>) ignoreStrategy::test);
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
    <R extends Serializable> L eq2(String name, R value, Predicate<R> ignoreStrategy);
    // ----------------------------------------------------------------------------------------------------------------

    /**
     * equals. 等于.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L eq2(Field field, String value) {
        return eq2(field.name(), value);
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
    default L eq2(Field field, String value, IgnoreStrategy ignoreStrategy) {
        return eq2(field.name(), value, ignoreStrategy);
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
    default L eq2(Field field, String value, Predicate<String> ignoreStrategy) {
        return eq2(field.name(), value, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param field         the field
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L eq2(Field field, String value, MatchStrategy matchStrategy) {
        return eq2(field.name(), value, matchStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param <R>            the generic type
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq2(Field field, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return eq2(field.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param <R>            the generic type
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq2(Field field, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return eq2(field.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <R extends Serializable> L eq2(Field field, R value) {
        return eq2(field.name(), value);
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
    default <R extends Serializable> L eq2(Field field, R value, IgnoreStrategy ignoreStrategy) {
        return eq2(field.name(), value, ignoreStrategy);
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
    default <R extends Serializable> L eq2(Field field, R value, Predicate<R> ignoreStrategy) {
        return eq2(field.name(), value, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L eq2(AliasField field, String value) {
        return eq2(field.getAliasOrName(), value);
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
    default L eq2(AliasField field, String value, IgnoreStrategy ignoreStrategy) {
        return eq2(field.getAliasOrName(), value, ignoreStrategy);
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
    default L eq2(AliasField field, String value, Predicate<String> ignoreStrategy) {
        return eq2(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param field         the field
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L eq2(AliasField field, String value, MatchStrategy matchStrategy) {
        return eq2(field.getAliasOrName(), value, matchStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param <R>            the generic type
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq2(AliasField field, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return eq2(field.getAliasOrName(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param <R>            the generic type
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq2(AliasField field, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return eq2(field.getAliasOrName(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * equals. 等于.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <R extends Serializable> L eq2(AliasField field, R value) {
        return eq2(field.getAliasOrName(), value);
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
    default <R extends Serializable> L eq2(AliasField field, R value, IgnoreStrategy ignoreStrategy) {
        return eq2(field.getAliasOrName(), value, ignoreStrategy);
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
    default <R extends Serializable> L eq2(AliasField field, R value, Predicate<R> ignoreStrategy) {
        return eq2(field.getAliasOrName(), value, ignoreStrategy);
    }
}