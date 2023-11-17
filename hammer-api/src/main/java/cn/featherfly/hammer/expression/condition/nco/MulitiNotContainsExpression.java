
package cn.featherfly.hammer.expression.condition.nco;

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
 * muliti not contains expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface MulitiNotContainsExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * not contains value. 不包含value.
     *
     * @param index the index
     * @param name  field name
     * @param value the value
     * @return LogicExpression
     */
    default L nco(int index, String name, String value) {
        return nco(index, name, value, MatchStrategy.AUTO);
    }

    /**
     * not contains value. 不包含value.
     *
     * @param index         the index
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L nco(int index, String name, String value, MatchStrategy matchStrategy);

    /**
     * not contains value. 不包含value.
     *
     * @param index          the index
     * @param name           field name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nco(int index, String name, String value, Predicate<String> ignoreStrategy) {
        return nco(index, name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not contains value. 不包含value.
     *
     * @param index          the index
     * @param name           field name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nco(int index, String name, String value, IgnoreStrategy ignoreStrategy) {
        return nco(index, name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not contains value. 不包含value.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    default L nco(int index, String name, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return nco(index, name, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * not contains value. 不包含value.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nco(int index, String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);

    /**
     * not contains value. 不包含value.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L nco(int index, Field field, String value) {
        return nco(index, field.name(), value);
    }

    /**
     * not contains value. 不包含value.
     *
     * @param index         the index
     * @param field         the field
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L nco(int index, Field field, String value, MatchStrategy matchStrategy) {
        return nco(index, field.name(), value, matchStrategy);
    }

    /**
     * not contains value. 不包含value.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nco(int index, Field field, String value, IgnoreStrategy ignoreStrategy) {
        return nco(index, field.name(), value, ignoreStrategy);
    }

    /**
     * not contains value. 不包含value.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nco(int index, Field field, String value, Predicate<String> ignoreStrategy) {
        return nco(index, field.name(), value, ignoreStrategy);
    }

    /**
     * not contains value. 不包含value.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nco(int index, Field field, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return nco(index, field.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * not contains value. 不包含value.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nco(int index, Field field, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return nco(index, field.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * not contains value. 不包含value.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L nco(int index, AliasField field, String value) {
        return nco(index, field.getAliasOrName(), value);
    }

    /**
     * not contains value. 不包含value.
     *
     * @param index         the index
     * @param field         the field
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L nco(int index, AliasField field, String value, MatchStrategy matchStrategy) {
        return nco(index, field.getAliasOrName(), value, matchStrategy);
    }

    /**
     * not contains value. 不包含value.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nco(int index, AliasField field, String value, IgnoreStrategy ignoreStrategy) {
        return nco(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * not contains value. 不包含value.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nco(int index, AliasField field, String value, Predicate<String> ignoreStrategy) {
        return nco(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * not contains value. 不包含value.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nco(int index, AliasField field, String value, MatchStrategy matchStrategy,
            IgnoreStrategy ignoreStrategy) {
        return nco(index, field.getAliasOrName(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * not contains value. 不包含value.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nco(int index, AliasField field, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        return nco(index, field.getAliasOrName(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * not contains value. 不包含value.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  field name
     * @param value the value
     * @return LogicExpression
     */
    default <E> L nco(int index, SerializableFunction<E, String> name, String value) {
        return nco(index, name, value, MatchStrategy.AUTO);
    }

    /**
     * not contains value. 不包含value.
     *
     * @param <E>           the element type
     * @param index         the index
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    <E> L nco(int index, SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy);

    /**
     * not contains value. 不包含value.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           field name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E> L nco(int index, SerializableFunction<E, String> name, String value, IgnoreStrategy ignoreStrategy) {
        return nco(index, name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not contains value. 不包含value.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           field name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E> L nco(int index, SerializableFunction<E, String> name, String value, Predicate<String> ignoreStrategy) {
        return nco(index, name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not contains value. 不包含value.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E> L nco(int index, SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy,
            IgnoreStrategy ignoreStrategy) {
        return nco(index, name, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * not contains value. 不包含value.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L nco(int index, SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy);

    /**
     * not contains value. 不包含value.
     *
     * @param index    the index
     * @param property bean property
     * @return LogicExpression
     */
    default L nco(int index, SerializableSupplier<String> property) {
        return nco(index, property, MatchStrategy.AUTO);
    }

    /**
     * not contains value. 不包含value.
     *
     * @param index         the index
     * @param property      the property
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L nco(int index, SerializableSupplier<String> property, MatchStrategy matchStrategy);

    /**
     * not contains value. 不包含value.
     *
     * @param index          the index
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nco(int index, SerializableSupplier<String> property, IgnoreStrategy ignoreStrategy) {
        return nco(index, property, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not contains value. 不包含value.
     *
     * @param index          the index
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nco(int index, SerializableSupplier<String> property, Predicate<String> ignoreStrategy) {
        return nco(index, property, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not contains value. 不包含value.
     *
     * @param index          the index
     * @param property       the property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nco(int index, SerializableSupplier<String> property, MatchStrategy matchStrategy,
            IgnoreStrategy ignoreStrategy) {
        return nco(index, property, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * not contains value. 不包含value.
     *
     * @param index          the index
     * @param property       the property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nco(int index, SerializableSupplier<String> property, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy);
}