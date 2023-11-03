
package cn.featherfly.hammer.expression.condition.nl;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.AliasField;
import cn.featherfly.common.repository.Field;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * muliti not like expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface MulitiNotLikeExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * not like value.
     *
     * @param index the index
     * @param name  field name
     * @param value the value
     * @return LogicExpression
     */
    default L nl(int index, String name, String value) {
        return nl(index, name, value, MatchStrategy.AUTO);
    }

    /**
     * not like value.
     *
     * @param index         the index
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L nl(int index, String name, String value, MatchStrategy matchStrategy);

    /**
     * not like value.
     *
     * @param index          the index
     * @param name           field name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nl(int index, String name, String value, Predicate<String> ignoreStrategy) {
        return nl(index, name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not like value.
     *
     * @param index          the index
     * @param name           field name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nl(int index, String name, String value, IgnoreStrategy ignoreStrategy) {
        return nl(index, name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not like value.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    default L nl(int index, String name, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return nl(index, name, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * not like value.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nl(int index, String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);

    /**
     * not like value.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L nl(int index, Field field, String value) {
        return nl(index, field.name(), value);
    }

    /**
     * not like value.
     *
     * @param index         the index
     * @param field         the field
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L nl(int index, Field field, String value, MatchStrategy matchStrategy) {
        return nl(index, field.name(), value, matchStrategy);
    }

    /**
     * not like value.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nl(int index, Field field, String value, IgnoreStrategy ignoreStrategy) {
        return nl(index, field.name(), value, ignoreStrategy);
    }

    /**
     * not like value.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nl(int index, Field field, String value, Predicate<String> ignoreStrategy) {
        return nl(index, field.name(), value, ignoreStrategy);
    }

    /**
     * not like value.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nl(int index, Field field, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return nl(index, field.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * not like value.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nl(int index, Field field, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return nl(index, field.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * not like value.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L nl(int index, AliasField field, String value) {
        return nl(index, field.getAliasOrName(), value);
    }

    /**
     * not like value.
     *
     * @param index         the index
     * @param field         the field
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L nl(int index, AliasField field, String value, MatchStrategy matchStrategy) {
        return nl(index, field.getAliasOrName(), value, matchStrategy);
    }

    /**
     * not like value.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nl(int index, AliasField field, String value, IgnoreStrategy ignoreStrategy) {
        return nl(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * not like value.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nl(int index, AliasField field, String value, Predicate<String> ignoreStrategy) {
        return nl(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * not like value.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nl(int index, AliasField field, String value, MatchStrategy matchStrategy,
            IgnoreStrategy ignoreStrategy) {
        return nl(index, field.getAliasOrName(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * not like value.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nl(int index, AliasField field, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        return nl(index, field.getAliasOrName(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * not like value.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  field name
     * @param value the value
     * @return LogicExpression
     */
    default <E> L nl(int index, SerializableFunction<E, String> name, String value) {
        return nl(index, name, value, MatchStrategy.AUTO);
    }

    /**
     * not like value.
     *
     * @param <E>           the element type
     * @param index         the index
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    <E> L nl(int index, SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy);

    /**
     * not like value.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           field name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E> L nl(int index, SerializableFunction<E, String> name, String value, IgnoreStrategy ignoreStrategy) {
        return nl(index, name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not like value.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           field name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E> L nl(int index, SerializableFunction<E, String> name, String value, Predicate<String> ignoreStrategy) {
        return nl(index, name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not like value.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E> L nl(int index, SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy,
            IgnoreStrategy ignoreStrategy) {
        return nl(index, name, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * not like value.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L nl(int index, SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy);

    /**
     * not like value.
     *
     * @param index    the index
     * @param property bean property
     * @return LogicExpression
     */
    default L nl(int index, SerializableSupplier<String> property) {
        return nl(index, property, MatchStrategy.AUTO);
    }

    /**
     * not like value.
     *
     * @param index         the index
     * @param property      the property
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L nl(int index, SerializableSupplier<String> property, MatchStrategy matchStrategy);

    /**
     * not like value.
     *
     * @param index          the index
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nl(int index, SerializableSupplier<String> property, IgnoreStrategy ignoreStrategy) {
        return nl(index, property, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not like value.
     *
     * @param index          the index
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nl(int index, SerializableSupplier<String> property, Predicate<String> ignoreStrategy) {
        return nl(index, property, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not like value.
     *
     * @param index          the index
     * @param property       the property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nl(int index, SerializableSupplier<String> property, MatchStrategy matchStrategy,
            IgnoreStrategy ignoreStrategy) {
        return nl(index, property, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * not like value.
     *
     * @param index          the index
     * @param property       the property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nl(int index, SerializableSupplier<String> property, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy);
}