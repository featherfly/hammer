
package cn.featherfly.hammer.expression.condition.newv;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.AliasField;
import cn.featherfly.common.repository.Field;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * muliti not end with expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface MulitiNotEndWithExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends ConditionExpression {

    /**
     * not end with value. 不以value结尾.
     *
     * @param index the index
     * @param name field name
     * @param value the value
     * @return LogicExpression
     */
    default L newv(int index, String name, String value) {
        return newv(index, name, value, MatchStrategy.AUTO);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param index the index
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L newv(int index, String name, String value, MatchStrategy matchStrategy);

    /**
     * not end with value. 不以value结尾.
     *
     * @param index the index
     * @param name field name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L newv(int index, String name, String value, Predicate<String> ignoreStrategy) {
        return newv(index, name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param index the index
     * @param name field name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L newv(int index, String name, String value, IgnoreStrategy ignoreStrategy) {
        return newv(index, name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param index the index
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    default L newv(int index, String name, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return newv(index, name, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param index the index
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L newv(int index, String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);

    /**
     * not end with value. 不以value结尾.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L newv(int index, Field field, String value) {
        return newv(index, field.name(), value);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L newv(int index, Field field, String value, MatchStrategy matchStrategy) {
        return newv(index, field.name(), value, matchStrategy);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L newv(int index, Field field, String value, IgnoreStrategy ignoreStrategy) {
        return newv(index, field.name(), value, ignoreStrategy);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L newv(int index, Field field, String value, Predicate<String> ignoreStrategy) {
        return newv(index, field.name(), value, ignoreStrategy);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L newv(int index, Field field, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return newv(index, field.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L newv(int index, Field field, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return newv(index, field.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L newv(int index, AliasField field, String value) {
        return newv(index, field.getAliasOrName(), value);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L newv(int index, AliasField field, String value, MatchStrategy matchStrategy) {
        return newv(index, field.getAliasOrName(), value, matchStrategy);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L newv(int index, AliasField field, String value, IgnoreStrategy ignoreStrategy) {
        return newv(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L newv(int index, AliasField field, String value, Predicate<String> ignoreStrategy) {
        return newv(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L newv(int index, AliasField field, String value, MatchStrategy matchStrategy,
        IgnoreStrategy ignoreStrategy) {
        return newv(index, field.getAliasOrName(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L newv(int index, AliasField field, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return newv(index, field.getAliasOrName(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param <E> the element type
     * @param index the index
     * @param name field name
     * @param value the value
     * @return LogicExpression
     */
    default <E> L newv(int index, SerializableFunction<E, String> name, String value) {
        return newv(index, name, value, MatchStrategy.AUTO);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param <E> the element type
     * @param index the index
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    <E> L newv(int index, SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy);

    /**
     * not end with value. 不以value结尾.
     *
     * @param <E> the element type
     * @param index the index
     * @param name field name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E> L newv(int index, SerializableFunction<E, String> name, String value, IgnoreStrategy ignoreStrategy) {
        return newv(index, name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param <E> the element type
     * @param index the index
     * @param name field name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E> L newv(int index, SerializableFunction<E, String> name, String value,
        Predicate<String> ignoreStrategy) {
        return newv(index, name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param <E> the element type
     * @param index the index
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E> L newv(int index, SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy,
        IgnoreStrategy ignoreStrategy) {
        return newv(index, name, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param <E> the element type
     * @param index the index
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L newv(int index, SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy);

    /**
     * not end with value. 不以value结尾.
     *
     * @param index the index
     * @param property bean property
     * @return LogicExpression
     */
    default L newv(int index, SerializableStringSupplier property) {
        return newv(index, property, MatchStrategy.AUTO);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param index the index
     * @param property the property
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L newv(int index, SerializableStringSupplier property, MatchStrategy matchStrategy);

    /**
     * not end with value. 不以value结尾.
     *
     * @param index the index
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L newv(int index, SerializableStringSupplier property, IgnoreStrategy ignoreStrategy) {
        return newv(index, property, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param index the index
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L newv(int index, SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return newv(index, property, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param index the index
     * @param property the property
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L newv(int index, SerializableStringSupplier property, MatchStrategy matchStrategy,
        IgnoreStrategy ignoreStrategy) {
        return newv(index, property, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * not end with value. 不以value结尾.
     *
     * @param index the index
     * @param property the property
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L newv(int index, SerializableStringSupplier property, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy);
}