
package cn.featherfly.hammer.expression.condition.ew;

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
 * muliti end with expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface MulitiEndWithExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * end with value. 以value结尾.
     *
     * @param index the index
     * @param name  field name
     * @param value the value
     * @return LogicExpression
     */
    default L ew(int index, String name, String value) {
        return ew(index, name, value, MatchStrategy.AUTO);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param index         the index
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L ew(int index, String name, String value, MatchStrategy matchStrategy);

    /**
     * end with value. 以value结尾.
     *
     * @param index          the index
     * @param name           field name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ew(int index, String name, String value, Predicate<String> ignoreStrategy) {
        return ew(index, name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param index          the index
     * @param name           field name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ew(int index, String name, String value, IgnoreStrategy ignoreStrategy) {
        return ew(index, name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    default L ew(int index, String name, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return ew(index, name, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ew(int index, String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);

    /**
     * end with value. 以value结尾.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L ew(int index, Field field, String value) {
        return ew(index, field.name(), value);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param index         the index
     * @param field         the field
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L ew(int index, Field field, String value, MatchStrategy matchStrategy) {
        return ew(index, field.name(), value, matchStrategy);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ew(int index, Field field, String value, IgnoreStrategy ignoreStrategy) {
        return ew(index, field.name(), value, ignoreStrategy);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ew(int index, Field field, String value, Predicate<String> ignoreStrategy) {
        return ew(index, field.name(), value, ignoreStrategy);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ew(int index, Field field, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return ew(index, field.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ew(int index, Field field, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return ew(index, field.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L ew(int index, AliasField field, String value) {
        return ew(index, field.getAliasOrName(), value);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param index         the index
     * @param field         the field
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L ew(int index, AliasField field, String value, MatchStrategy matchStrategy) {
        return ew(index, field.getAliasOrName(), value, matchStrategy);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ew(int index, AliasField field, String value, IgnoreStrategy ignoreStrategy) {
        return ew(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ew(int index, AliasField field, String value, Predicate<String> ignoreStrategy) {
        return ew(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ew(int index, AliasField field, String value, MatchStrategy matchStrategy,
            IgnoreStrategy ignoreStrategy) {
        return ew(index, field.getAliasOrName(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ew(int index, AliasField field, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        return ew(index, field.getAliasOrName(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  field name
     * @param value the value
     * @return LogicExpression
     */
    default <E> L ew(int index, SerializableFunction<E, String> name, String value) {
        return ew(index, name, value, MatchStrategy.AUTO);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param <E>           the element type
     * @param index         the index
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    <E> L ew(int index, SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy);

    /**
     * end with value. 以value结尾.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           field name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E> L ew(int index, SerializableFunction<E, String> name, String value, IgnoreStrategy ignoreStrategy) {
        return ew(index, name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           field name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E> L ew(int index, SerializableFunction<E, String> name, String value, Predicate<String> ignoreStrategy) {
        return ew(index, name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E> L ew(int index, SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy,
            IgnoreStrategy ignoreStrategy) {
        return ew(index, name, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L ew(int index, SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy);

    /**
     * end with value. 以value结尾.
     *
     * @param index    the index
     * @param property bean property
     * @return LogicExpression
     */
    default L ew(int index, SerializableSupplier<String> property) {
        return ew(index, property, MatchStrategy.AUTO);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param index         the index
     * @param property      the property
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L ew(int index, SerializableSupplier<String> property, MatchStrategy matchStrategy);

    /**
     * end with value. 以value结尾.
     *
     * @param index          the index
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ew(int index, SerializableSupplier<String> property, IgnoreStrategy ignoreStrategy) {
        return ew(index, property, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param index          the index
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ew(int index, SerializableSupplier<String> property, Predicate<String> ignoreStrategy) {
        return ew(index, property, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param index          the index
     * @param property       the property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ew(int index, SerializableSupplier<String> property, MatchStrategy matchStrategy,
            IgnoreStrategy ignoreStrategy) {
        return ew(index, property, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param index          the index
     * @param property       the property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ew(int index, SerializableSupplier<String> property, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy);
}