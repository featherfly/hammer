
package cn.featherfly.hammer.expression.condition.nsw;

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
 * muliti not start with expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface MulitiNotStartWithExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * not start with value. 不以value开始.
     *
     * @param index the index
     * @param name  field name
     * @param value the value
     * @return LogicExpression
     */
    default L nsw(int index, String name, String value) {
        return nsw(index, name, value, MatchStrategy.AUTO);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param index         the index
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L nsw(int index, String name, String value, MatchStrategy matchStrategy);

    /**
     * not start with value. 不以value开始.
     *
     * @param index          the index
     * @param name           field name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nsw(int index, String name, String value, Predicate<String> ignoreStrategy) {
        return nsw(index, name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param index          the index
     * @param name           field name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nsw(int index, String name, String value, IgnoreStrategy ignoreStrategy) {
        return nsw(index, name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    default L nsw(int index, String name, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return nsw(index, name, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nsw(int index, String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);

    /**
     * not start with value. 不以value开始.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L nsw(int index, Field field, String value) {
        return nsw(index, field.name(), value);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param index         the index
     * @param field         the field
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L nsw(int index, Field field, String value, MatchStrategy matchStrategy) {
        return nsw(index, field.name(), value, matchStrategy);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nsw(int index, Field field, String value, IgnoreStrategy ignoreStrategy) {
        return nsw(index, field.name(), value, ignoreStrategy);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nsw(int index, Field field, String value, Predicate<String> ignoreStrategy) {
        return nsw(index, field.name(), value, ignoreStrategy);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nsw(int index, Field field, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return nsw(index, field.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nsw(int index, Field field, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return nsw(index, field.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L nsw(int index, AliasField field, String value) {
        return nsw(index, field.getAliasOrName(), value);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param index         the index
     * @param field         the field
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L nsw(int index, AliasField field, String value, MatchStrategy matchStrategy) {
        return nsw(index, field.getAliasOrName(), value, matchStrategy);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nsw(int index, AliasField field, String value, IgnoreStrategy ignoreStrategy) {
        return nsw(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nsw(int index, AliasField field, String value, Predicate<String> ignoreStrategy) {
        return nsw(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nsw(int index, AliasField field, String value, MatchStrategy matchStrategy,
            IgnoreStrategy ignoreStrategy) {
        return nsw(index, field.getAliasOrName(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nsw(int index, AliasField field, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        return nsw(index, field.getAliasOrName(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  field name
     * @param value the value
     * @return LogicExpression
     */
    default <E> L nsw(int index, SerializableFunction<E, String> name, String value) {
        return nsw(index, name, value, MatchStrategy.AUTO);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param <E>           the element type
     * @param index         the index
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    <E> L nsw(int index, SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy);

    /**
     * not start with value. 不以value开始.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           field name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E> L nsw(int index, SerializableFunction<E, String> name, String value, IgnoreStrategy ignoreStrategy) {
        return nsw(index, name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           field name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E> L nsw(int index, SerializableFunction<E, String> name, String value, Predicate<String> ignoreStrategy) {
        return nsw(index, name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E> L nsw(int index, SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy,
            IgnoreStrategy ignoreStrategy) {
        return nsw(index, name, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L nsw(int index, SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy);

    /**
     * not start with value. 不以value开始.
     *
     * @param index    the index
     * @param property bean property
     * @return LogicExpression
     */
    default L nsw(int index, SerializableSupplier<String> property) {
        return nsw(index, property, MatchStrategy.AUTO);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param index         the index
     * @param property      the property
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L nsw(int index, SerializableSupplier<String> property, MatchStrategy matchStrategy);

    /**
     * not start with value. 不以value开始.
     *
     * @param index          the index
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nsw(int index, SerializableSupplier<String> property, IgnoreStrategy ignoreStrategy) {
        return nsw(index, property, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param index          the index
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nsw(int index, SerializableSupplier<String> property, Predicate<String> ignoreStrategy) {
        return nsw(index, property, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param index          the index
     * @param property       the property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nsw(int index, SerializableSupplier<String> property, MatchStrategy matchStrategy,
            IgnoreStrategy ignoreStrategy) {
        return nsw(index, property, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * not start with value. 不以value开始.
     *
     * @param index          the index
     * @param property       the property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nsw(int index, SerializableSupplier<String> property, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy);
}