
package cn.featherfly.hammer.expression.condition.sw;

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
 * muliti start with expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface MulitiStartWithExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * start with value. 以value开始.
     *
     * @param index the index
     * @param name  field name
     * @param value the value
     * @return LogicExpression
     */
    default L sw(int index, String name, String value) {
        return sw(index, name, value, MatchStrategy.AUTO);
    }

    /**
     * start with value. 以value开始.
     *
     * @param index         the index
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L sw(int index, String name, String value, MatchStrategy matchStrategy);

    /**
     * start with value. 以value开始.
     *
     * @param index          the index
     * @param name           field name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L sw(int index, String name, String value, Predicate<String> ignoreStrategy) {
        return sw(index, name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * start with value. 以value开始.
     *
     * @param index          the index
     * @param name           field name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L sw(int index, String name, String value, IgnoreStrategy ignoreStrategy) {
        return sw(index, name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * start with value. 以value开始.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    default L sw(int index, String name, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return sw(index, name, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * start with value. 以value开始.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L sw(int index, String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);

    /**
     * start with value. 以value开始.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L sw(int index, Field field, String value) {
        return sw(index, field.name(), value);
    }

    /**
     * start with value. 以value开始.
     *
     * @param index         the index
     * @param field         the field
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L sw(int index, Field field, String value, MatchStrategy matchStrategy) {
        return sw(index, field.name(), value, matchStrategy);
    }

    /**
     * start with value. 以value开始.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L sw(int index, Field field, String value, IgnoreStrategy ignoreStrategy) {
        return sw(index, field.name(), value, ignoreStrategy);
    }

    /**
     * start with value. 以value开始.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L sw(int index, Field field, String value, Predicate<String> ignoreStrategy) {
        return sw(index, field.name(), value, ignoreStrategy);
    }

    /**
     * start with value. 以value开始.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L sw(int index, Field field, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return sw(index, field.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * start with value. 以value开始.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L sw(int index, Field field, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return sw(index, field.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * start with value. 以value开始.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L sw(int index, AliasField field, String value) {
        return sw(index, field.getAliasOrName(), value);
    }

    /**
     * start with value. 以value开始.
     *
     * @param index         the index
     * @param field         the field
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L sw(int index, AliasField field, String value, MatchStrategy matchStrategy) {
        return sw(index, field.getAliasOrName(), value, matchStrategy);
    }

    /**
     * start with value. 以value开始.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L sw(int index, AliasField field, String value, IgnoreStrategy ignoreStrategy) {
        return sw(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * start with value. 以value开始.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L sw(int index, AliasField field, String value, Predicate<String> ignoreStrategy) {
        return sw(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * start with value. 以value开始.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L sw(int index, AliasField field, String value, MatchStrategy matchStrategy,
            IgnoreStrategy ignoreStrategy) {
        return sw(index, field.getAliasOrName(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * start with value. 以value开始.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L sw(int index, AliasField field, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        return sw(index, field.getAliasOrName(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * start with value. 以value开始.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  field name
     * @param value the value
     * @return LogicExpression
     */
    default <E> L sw(int index, SerializableFunction<E, String> name, String value) {
        return sw(index, name, value, MatchStrategy.AUTO);
    }

    /**
     * start with value. 以value开始.
     *
     * @param <E>           the element type
     * @param index         the index
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    <E> L sw(int index, SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy);

    /**
     * start with value. 以value开始.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           field name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E> L sw(int index, SerializableFunction<E, String> name, String value, IgnoreStrategy ignoreStrategy) {
        return sw(index, name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * start with value. 以value开始.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           field name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E> L sw(int index, SerializableFunction<E, String> name, String value, Predicate<String> ignoreStrategy) {
        return sw(index, name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * start with value. 以value开始.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E> L sw(int index, SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy,
            IgnoreStrategy ignoreStrategy) {
        return sw(index, name, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * start with value. 以value开始.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L sw(int index, SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy);

    /**
     * start with value. 以value开始.
     *
     * @param index    the index
     * @param property bean property
     * @return LogicExpression
     */
    default L sw(int index, SerializableSupplier<String> property) {
        return sw(index, property, MatchStrategy.AUTO);
    }

    /**
     * start with value. 以value开始.
     *
     * @param index         the index
     * @param property      the property
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L sw(int index, SerializableSupplier<String> property, MatchStrategy matchStrategy);

    /**
     * start with value. 以value开始.
     *
     * @param index          the index
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L sw(int index, SerializableSupplier<String> property, IgnoreStrategy ignoreStrategy) {
        return sw(index, property, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * start with value. 以value开始.
     *
     * @param index          the index
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L sw(int index, SerializableSupplier<String> property, Predicate<String> ignoreStrategy) {
        return sw(index, property, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * start with value. 以value开始.
     *
     * @param index          the index
     * @param property       the property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L sw(int index, SerializableSupplier<String> property, MatchStrategy matchStrategy,
            IgnoreStrategy ignoreStrategy) {
        return sw(index, property, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * start with value. 以value开始.
     *
     * @param index          the index
     * @param property       the property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L sw(int index, SerializableSupplier<String> property, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy);
}