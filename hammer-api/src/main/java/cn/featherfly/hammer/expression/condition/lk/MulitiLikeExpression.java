
package cn.featherfly.hammer.expression.condition.lk;

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
 * muliti like expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface MulitiLikeExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends ConditionExpression {

    /**
     * like value.
     *
     * @param index the index
     * @param name field name
     * @param value the value
     * @return LogicExpression
     */
    default L lk(int index, String name, String value) {
        return lk(index, name, value, MatchStrategy.AUTO);
    }

    /**
     * like value.
     *
     * @param index the index
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L lk(int index, String name, String value, MatchStrategy matchStrategy);

    /**
     * like value.
     *
     * @param index the index
     * @param name field name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lk(int index, String name, String value, Predicate<String> ignoreStrategy) {
        return lk(index, name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * like value.
     *
     * @param index the index
     * @param name field name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lk(int index, String name, String value, IgnoreStrategy ignoreStrategy) {
        return lk(index, name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * like value.
     *
     * @param index the index
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    default L lk(int index, String name, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return lk(index, name, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * like value.
     *
     * @param index the index
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lk(int index, String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);

    /**
     * like value.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L lk(int index, Field field, String value) {
        return lk(index, field.name(), value);
    }

    /**
     * like value.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L lk(int index, Field field, String value, MatchStrategy matchStrategy) {
        return lk(index, field.name(), value, matchStrategy);
    }

    /**
     * like value.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lk(int index, Field field, String value, IgnoreStrategy ignoreStrategy) {
        return lk(index, field.name(), value, ignoreStrategy);
    }

    /**
     * like value.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lk(int index, Field field, String value, Predicate<String> ignoreStrategy) {
        return lk(index, field.name(), value, ignoreStrategy);
    }

    /**
     * like value.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lk(int index, Field field, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return lk(index, field.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * like value.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lk(int index, Field field, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return lk(index, field.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * like value.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L lk(int index, AliasField field, String value) {
        return lk(index, field.getAliasOrName(), value);
    }

    /**
     * like value.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L lk(int index, AliasField field, String value, MatchStrategy matchStrategy) {
        return lk(index, field.getAliasOrName(), value, matchStrategy);
    }

    /**
     * like value.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lk(int index, AliasField field, String value, IgnoreStrategy ignoreStrategy) {
        return lk(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * like value.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lk(int index, AliasField field, String value, Predicate<String> ignoreStrategy) {
        return lk(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * like value.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lk(int index, AliasField field, String value, MatchStrategy matchStrategy,
        IgnoreStrategy ignoreStrategy) {
        return lk(index, field.getAliasOrName(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * like value.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lk(int index, AliasField field, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return lk(index, field.getAliasOrName(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * like value.
     *
     * @param <E> the element type
     * @param index the index
     * @param name field name
     * @param value the value
     * @return LogicExpression
     */
    default <E> L lk(int index, SerializableFunction<E, String> name, String value) {
        return lk(index, name, value, MatchStrategy.AUTO);
    }

    /**
     * like value.
     *
     * @param <E> the element type
     * @param index the index
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    <E> L lk(int index, SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy);

    /**
     * like value.
     *
     * @param <E> the element type
     * @param index the index
     * @param name field name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E> L lk(int index, SerializableFunction<E, String> name, String value, IgnoreStrategy ignoreStrategy) {
        return lk(index, name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * like value.
     *
     * @param <E> the element type
     * @param index the index
     * @param name field name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E> L lk(int index, SerializableFunction<E, String> name, String value, Predicate<String> ignoreStrategy) {
        return lk(index, name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * like value.
     *
     * @param <E> the element type
     * @param index the index
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E> L lk(int index, SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy,
        IgnoreStrategy ignoreStrategy) {
        return lk(index, name, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * like value.
     *
     * @param <E> the element type
     * @param index the index
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L lk(int index, SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy);

    /**
     * like value.
     *
     * @param index the index
     * @param property bean property
     * @return LogicExpression
     */
    default L lk(int index, SerializableStringSupplier property) {
        return lk(index, property, MatchStrategy.AUTO);
    }

    /**
     * like value.
     *
     * @param index the index
     * @param property the property
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L lk(int index, SerializableStringSupplier property, MatchStrategy matchStrategy);

    /**
     * like value.
     *
     * @param index the index
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lk(int index, SerializableStringSupplier property, IgnoreStrategy ignoreStrategy) {
        return lk(index, property, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * like value.
     *
     * @param index the index
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lk(int index, SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return lk(index, property, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * like value.
     *
     * @param index the index
     * @param property the property
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lk(int index, SerializableStringSupplier property, MatchStrategy matchStrategy,
        IgnoreStrategy ignoreStrategy) {
        return lk(index, property, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * like value.
     *
     * @param index the index
     * @param property the property
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lk(int index, SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);
}