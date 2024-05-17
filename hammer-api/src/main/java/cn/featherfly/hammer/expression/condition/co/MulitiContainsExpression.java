
package cn.featherfly.hammer.expression.condition.co;

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
 * muliti contains expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface MulitiContainsExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends ConditionExpression {

    /**
     * contains value. 包含value.
     *
     * @param index the index
     * @param name field name
     * @param value the value
     * @return LogicExpression
     */
    default L co(int index, String name, String value) {
        return co(index, name, value, MatchStrategy.AUTO);
    }

    /**
     * contains value. 包含value.
     *
     * @param index the index
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L co(int index, String name, String value, MatchStrategy matchStrategy);

    /**
     * contains value. 包含value.
     *
     * @param index the index
     * @param name field name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L co(int index, String name, String value, Predicate<String> ignoreStrategy) {
        return co(index, name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * contains value. 包含value.
     *
     * @param index the index
     * @param name field name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L co(int index, String name, String value, IgnoreStrategy ignoreStrategy) {
        return co(index, name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * contains value. 包含value.
     *
     * @param index the index
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    default L co(int index, String name, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return co(index, name, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * contains value. 包含value.
     *
     * @param index the index
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L co(int index, String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);

    /**
     * contains value. 包含value.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L co(int index, Field field, String value) {
        return co(index, field.name(), value);
    }

    /**
     * contains value. 包含value.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L co(int index, Field field, String value, MatchStrategy matchStrategy) {
        return co(index, field.name(), value, matchStrategy);
    }

    /**
     * contains value. 包含value.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L co(int index, Field field, String value, IgnoreStrategy ignoreStrategy) {
        return co(index, field.name(), value, ignoreStrategy);
    }

    /**
     * contains value. 包含value.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L co(int index, Field field, String value, Predicate<String> ignoreStrategy) {
        return co(index, field.name(), value, ignoreStrategy);
    }

    /**
     * contains value. 包含value.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L co(int index, Field field, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return co(index, field.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * contains value. 包含value.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L co(int index, Field field, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return co(index, field.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * contains value. 包含value.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L co(int index, AliasField field, String value) {
        return co(index, field.getAliasOrName(), value);
    }

    /**
     * contains value. 包含value.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L co(int index, AliasField field, String value, MatchStrategy matchStrategy) {
        return co(index, field.getAliasOrName(), value, matchStrategy);
    }

    /**
     * contains value. 包含value.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L co(int index, AliasField field, String value, IgnoreStrategy ignoreStrategy) {
        return co(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * contains value. 包含value.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L co(int index, AliasField field, String value, Predicate<String> ignoreStrategy) {
        return co(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * contains value. 包含value.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L co(int index, AliasField field, String value, MatchStrategy matchStrategy,
        IgnoreStrategy ignoreStrategy) {
        return co(index, field.getAliasOrName(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * contains value. 包含value.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L co(int index, AliasField field, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return co(index, field.getAliasOrName(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * contains value. 包含value.
     *
     * @param <E> the element type
     * @param index the index
     * @param name field name
     * @param value the value
     * @return LogicExpression
     */
    default <E> L co(int index, SerializableFunction<E, String> name, String value) {
        return co(index, name, value, MatchStrategy.AUTO);
    }

    /**
     * contains value. 包含value.
     *
     * @param <E> the element type
     * @param index the index
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    <E> L co(int index, SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy);

    /**
     * contains value. 包含value.
     *
     * @param <E> the element type
     * @param index the index
     * @param name field name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E> L co(int index, SerializableFunction<E, String> name, String value, IgnoreStrategy ignoreStrategy) {
        return co(index, name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * contains value. 包含value.
     *
     * @param <E> the element type
     * @param index the index
     * @param name field name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E> L co(int index, SerializableFunction<E, String> name, String value, Predicate<String> ignoreStrategy) {
        return co(index, name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * contains value. 包含value.
     *
     * @param <E> the element type
     * @param index the index
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E> L co(int index, SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy,
        IgnoreStrategy ignoreStrategy) {
        return co(index, name, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * contains value. 包含value.
     *
     * @param <E> the element type
     * @param index the index
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L co(int index, SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy);

    /**
     * contains value. 包含value.
     *
     * @param index the index
     * @param property bean property
     * @return LogicExpression
     */
    default L co(int index, SerializableStringSupplier property) {
        return co(index, property, MatchStrategy.AUTO);
    }

    /**
     * contains value. 包含value.
     *
     * @param index the index
     * @param property the property
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L co(int index, SerializableStringSupplier property, MatchStrategy matchStrategy);

    /**
     * contains value. 包含value.
     *
     * @param index the index
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L co(int index, SerializableStringSupplier property, IgnoreStrategy ignoreStrategy) {
        return co(index, property, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * contains value. 包含value.
     *
     * @param index the index
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L co(int index, SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return co(index, property, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * contains value. 包含value.
     *
     * @param index the index
     * @param property the property
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L co(int index, SerializableStringSupplier property, MatchStrategy matchStrategy,
        IgnoreStrategy ignoreStrategy) {
        return co(index, property, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * contains value. 包含value.
     *
     * @param index the index
     * @param property the property
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L co(int index, SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);
}