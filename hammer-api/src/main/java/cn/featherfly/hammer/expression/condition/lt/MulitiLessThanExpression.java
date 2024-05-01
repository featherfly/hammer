
package cn.featherfly.hammer.expression.condition.lt;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableDateSupplier;
import cn.featherfly.common.function.serializable.SerializableDoubleSupplier;
import cn.featherfly.common.function.serializable.SerializableEnumSupplier;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableIntSupplier;
import cn.featherfly.common.function.serializable.SerializableLocalDateSupplier;
import cn.featherfly.common.function.serializable.SerializableLocalDateTimeSupplier;
import cn.featherfly.common.function.serializable.SerializableLocalTimeSupplier;
import cn.featherfly.common.function.serializable.SerializableLongSupplier;
import cn.featherfly.common.function.serializable.SerializableNumberSupplier;
import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.function.serializable.SerializableToDoubleFunction;
import cn.featherfly.common.function.serializable.SerializableToIntFunction;
import cn.featherfly.common.function.serializable.SerializableToLongFunction;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.AliasField;
import cn.featherfly.common.repository.Field;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * muliti less equals expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface MulitiLessThanExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * less than. 小于.
     *
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L lt(int index, String name, int value);

    /**
     * less than. 小于.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(int index, String name, int value, IntPredicate ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L lt(int index, String name, long value);

    /**
     * less than. 小于.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(int index, String name, long value, LongPredicate ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L lt(int index, String name, double value);

    /**
     * less than. 小于.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(int index, String name, double value, DoublePredicate ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param <N>   number type
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <N extends Number> L lt(int index, String name, N value);

    /**
     * less than. 小于.
     *
     * @param <N>            number type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L lt(int index, String name, N value, Predicate<N> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <E extends Enum<E>> L lt(int index, String name, E value);

    /**
     * less than. 小于.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E extends Enum<E>> L lt(int index, String name, E value, Predicate<E> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param <D>   date type
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <D extends Date> L lt(int index, String name, D value);

    /**
     * less than. 小于.
     *
     * @param <D>            date type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L lt(int index, String name, D value, Predicate<D> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L lt(int index, String name, LocalTime value);

    /**
     * less than. 小于.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(int index, String name, LocalTime value, Predicate<LocalTime> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L lt(int index, String name, LocalDate value);

    /**
     * less than. 小于.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(int index, String name, LocalDate value, Predicate<LocalDate> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L lt(int index, String name, LocalDateTime value);

    /**
     * less than. 小于.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(int index, String name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default L lt(int index, String name, String value) {
        return lt(index, name, value, MatchStrategy.AUTO);
    }

    /**
     * less than. 小于.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt(int index, String name, String value, Predicate<String> ignoreStrategy) {
        return lt(index, name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param index             the index
     * @param name              the name
     * @param value             the value
     * @param mathMatchStrategy the math match strategy
     * @return LogicExpression
     */
    L lt(int index, String name, String value, MatchStrategy mathMatchStrategy);

    /**
     * less than. 小于.
     *
     * @param index             the index
     * @param name              the name
     * @param value             the value
     * @param mathMatchStrategy the math match strategy
     * @param ignoreStrategy    the ignore strategy
     * @return LogicExpression
     */
    L lt(int index, String name, String value, MatchStrategy mathMatchStrategy, Predicate<String> ignoreStrategy);

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * less than. 小于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L lt(int index, Field field, int value) {
        return lt(index, field.name(), value);
    }

    /**
     * less than. 小于.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt(int index, Field field, int value, IntPredicate ignoreStrategy) {
        return lt(index, field.name(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L lt(int index, Field field, long value) {
        return lt(index, field.name(), value);
    }

    /**
     * less than. 小于.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt(int index, Field field, long value, LongPredicate ignoreStrategy) {
        return lt(index, field.name(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L lt(int index, Field field, double value) {
        return lt(index, field.name(), value);
    }

    /**
     * less than. 小于.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt(int index, Field field, double value, DoublePredicate ignoreStrategy) {
        return lt(index, field.name(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param <N>   number type
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <N extends Number> L lt(int index, Field field, N value) {
        return lt(index, field.name(), value);
    }

    /**
     * less than. 小于.
     *
     * @param <N>            number type
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L lt(int index, Field field, N value, Predicate<N> ignoreStrategy) {
        return lt(index, field.name(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param <E>   the element type
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <E extends Enum<E>> L lt(int index, Field field, E value) {
        return lt(index, field.name(), value);
    }

    /**
     * less than. 小于.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E extends Enum<E>> L lt(int index, Field field, E value, Predicate<E> ignoreStrategy) {
        return lt(index, field.name(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param <D>   date type
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <D extends Date> L lt(int index, Field field, D value) {
        return lt(index, field.name(), value);
    }

    /**
     * less than. 小于.
     *
     * @param <D>            date type
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L lt(int index, Field field, D value, Predicate<D> ignoreStrategy) {
        return lt(index, field.name(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L lt(int index, Field field, LocalTime value) {
        return lt(index, field.name(), value);
    }

    /**
     * less than. 小于.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt(int index, Field field, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return lt(index, field.name(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L lt(int index, Field field, LocalDate value) {
        return lt(index, field.name(), value);
    }

    /**
     * less than. 小于.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt(int index, Field field, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return lt(index, field.name(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L lt(int index, Field field, LocalDateTime value) {
        return lt(index, field.name(), value);
    }

    /**
     * less than. 小于.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt(int index, Field field, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return lt(index, field.name(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L lt(int index, Field field, String value) {
        return lt(index, field, value, MatchStrategy.AUTO);
    }

    /**
     * less than. 小于.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt(int index, Field field, String value, Predicate<String> ignoreStrategy) {
        return lt(index, field.name(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param index             the index
     * @param field             the field
     * @param value             the value
     * @param mathMatchStrategy the math match strategy
     * @return LogicExpression
     */
    default L lt(int index, Field field, String value, MatchStrategy mathMatchStrategy) {
        return lt(index, field.name(), value, mathMatchStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param index             the index
     * @param field             the field
     * @param value             the value
     * @param mathMatchStrategy the math match strategy
     * @param ignoreStrategy    the ignore strategy
     * @return LogicExpression
     */
    default L lt(int index, Field field, String value, MatchStrategy mathMatchStrategy,
            Predicate<String> ignoreStrategy) {
        return lt(index, field.name(), value, ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * less than. 小于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L lt(int index, AliasField field, int value) {
        return lt(index, field.getAliasOrName(), value);
    }

    /**
     * less than. 小于.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt(int index, AliasField field, int value, IntPredicate ignoreStrategy) {
        return lt(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L lt(int index, AliasField field, long value) {
        return lt(index, field.getAliasOrName(), value);
    }

    /**
     * less than. 小于.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt(int index, AliasField field, long value, LongPredicate ignoreStrategy) {
        return lt(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L lt(int index, AliasField field, double value) {
        return lt(index, field.getAliasOrName(), value);
    }

    /**
     * less than. 小于.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt(int index, AliasField field, double value, DoublePredicate ignoreStrategy) {
        return lt(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param <N>   number type
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <N extends Number> L lt(int index, AliasField field, N value) {
        return lt(index, field.getAliasOrName(), value);
    }

    /**
     * less than. 小于.
     *
     * @param <N>            number type
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L lt(int index, AliasField field, N value, Predicate<N> ignoreStrategy) {
        return lt(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param <E>   the element type
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <E extends Enum<E>> L lt(int index, AliasField field, E value) {
        return lt(index, field.getAliasOrName(), value);
    }

    /**
     * less than. 小于.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E extends Enum<E>> L lt(int index, AliasField field, E value, Predicate<E> ignoreStrategy) {
        return lt(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param <D>   date type
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <D extends Date> L lt(int index, AliasField field, D value) {
        return lt(index, field.getAliasOrName(), value);
    }

    /**
     * less than. 小于.
     *
     * @param <D>            date type
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L lt(int index, AliasField field, D value, Predicate<D> ignoreStrategy) {
        return lt(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L lt(int index, AliasField field, LocalTime value) {
        return lt(index, field.getAliasOrName(), value);
    }

    /**
     * less than. 小于.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt(int index, AliasField field, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return lt(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L lt(int index, AliasField field, LocalDate value) {
        return lt(index, field.getAliasOrName(), value);
    }

    /**
     * less than. 小于.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt(int index, AliasField field, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return lt(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L lt(int index, AliasField field, LocalDateTime value) {
        return lt(index, field.getAliasOrName(), value);
    }

    /**
     * less than. 小于.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt(int index, AliasField field, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return lt(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L lt(int index, AliasField field, String value) {
        return lt(index, field, value, MatchStrategy.AUTO);
    }

    /**
     * less than. 小于.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt(int index, AliasField field, String value, Predicate<String> ignoreStrategy) {
        return lt(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param index             the index
     * @param field             the field
     * @param value             the value
     * @param mathMatchStrategy the math match strategy
     * @return LogicExpression
     */
    default L lt(int index, AliasField field, String value, MatchStrategy mathMatchStrategy) {
        return lt(index, field.getAliasOrName(), value, mathMatchStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param index             the index
     * @param field             the field
     * @param value             the value
     * @param mathMatchStrategy the math match strategy
     * @param ignoreStrategy    the ignore strategy
     * @return LogicExpression
     */
    default L lt(int index, AliasField field, String value, MatchStrategy mathMatchStrategy,
            Predicate<String> ignoreStrategy) {
        return lt(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * less than. 小于.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <E> L lt(int index, SerializableToIntFunction<E> name, int value);

    /**
     * less than. 小于.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L lt(int index, SerializableToIntFunction<E> name, int value, IntPredicate ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <E> L lt(int index, SerializableToLongFunction<E> name, long value);

    /**
     * less than. 小于.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L lt(int index, SerializableToLongFunction<E> name, long value, LongPredicate ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <E> L lt(int index, SerializableToDoubleFunction<E> name, double value);

    /**
     * less than. 小于.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L lt(int index, SerializableToDoubleFunction<E> name, double value, DoublePredicate ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param <E>   the element type
     * @param <N>   number type
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <E, N extends Number> L lt(int index, SerializableFunction<E, N> name, N value);

    /**
     * less than. 小于.
     *
     * @param <E>            the element type
     * @param <N>            number type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E, N extends Number> L lt(int index, SerializableFunction<E, N> name, N value, Predicate<N> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param <T>   the generic type
     * @param <E>   the element type
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <T, E extends Enum<E>> L lt(int index, SerializableFunction<T, E> name, E value);

    /**
     * less than. 小于.
     *
     * @param <T>            the generic type
     * @param <E>            the element type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T, E extends Enum<E>> L lt(int index, SerializableFunction<T, E> name, E value, Predicate<E> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param <E>   the element type
     * @param <D>   date type
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <E, D extends Date> L lt(int index, SerializableFunction<E, D> name, D value);

    /**
     * less than. 小于.
     *
     * @param <E>            the element type
     * @param <D>            date type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E, D extends Date> L lt(int index, SerializableFunction<E, D> name, D value, Predicate<D> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <E> L lt(int index, SerializableFunction<E, LocalTime> name, LocalTime value);

    /**
     * less than. 小于.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L lt(int index, SerializableFunction<E, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <E> L lt(int index, SerializableFunction<E, LocalDate> name, LocalDate value);

    /**
     * less than. 小于.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L lt(int index, SerializableFunction<E, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <E> L lt(int index, SerializableFunction<E, LocalDateTime> name, LocalDateTime value);

    /**
     * less than. 小于.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L lt(int index, SerializableFunction<E, LocalDateTime> name, LocalDateTime value,
            Predicate<LocalDateTime> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default <E> L lt(int index, SerializableFunction<E, String> name, String value) {
        return lt(index, name, value, MatchStrategy.AUTO);
    }

    /**
     * less than. 小于.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E> L lt(int index, SerializableFunction<E, String> name, String value, Predicate<String> ignoreStrategy) {
        return lt(index, name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param <E>               the element type
     * @param index             the index
     * @param name              the name
     * @param value             the value
     * @param mathMatchStrategy the math match strategy
     * @return LogicExpression
     */
    <E> L lt(int index, SerializableFunction<E, String> name, String value, MatchStrategy mathMatchStrategy);

    /**
     * less than. 小于.
     *
     * @param <E>               the element type
     * @param index             the index
     * @param name              the name
     * @param value             the value
     * @param mathMatchStrategy the math match strategy
     * @param ignoreStrategy    the ignore strategy
     * @return LogicExpression
     */
    <E> L lt(int index, SerializableFunction<E, String> name, String value, MatchStrategy mathMatchStrategy,
            Predicate<String> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param index    the index
     * @param property bean property
     * @return LogicExpression
     */
    L lt(int index, SerializableIntSupplier property);

    /**
     * less than. 小于.
     *
     * @param index          the index
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(int index, SerializableIntSupplier property, IntPredicate ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param index    the index
     * @param property bean property
     * @return LogicExpression
     */
    L lt(int index, SerializableLongSupplier property);

    /**
     * less than. 小于.
     *
     * @param index          the index
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(int index, SerializableLongSupplier property, LongPredicate ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param index    the index
     * @param property bean property
     * @return LogicExpression
     */
    L lt(int index, SerializableDoubleSupplier property);

    /**
     * less than. 小于.
     *
     * @param index          the index
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(int index, SerializableDoubleSupplier property, DoublePredicate ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param <R>      the generic type
     * @param index    the index
     * @param property bean property
     * @return LogicExpression
     */
    <R extends Date> L lt(int index, SerializableDateSupplier<R> property);

    /**
     * less than. 小于.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R extends Date> L lt(int index, SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param <R>      the generic type
     * @param index    the index
     * @param property bean property
     * @return LogicExpression
     */
    <R extends Number> L lt(int index, SerializableNumberSupplier<R> property);

    /**
     * less than. 小于.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R extends Number> L lt(int index, SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param <E>      the element type
     * @param index    the index
     * @param property bean property
     * @return LogicExpression
     */
    <E extends Enum<E>> L lt(int index, SerializableEnumSupplier<E> property);

    /**
     * less than. 小于.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E extends Enum<E>> L lt(int index, SerializableEnumSupplier<E> property, Predicate<E> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param index    the index
     * @param property bean property
     * @return LogicExpression
     */
    L lt(int index, SerializableLocalDateSupplier property);

    /**
     * less than. 小于.
     *
     * @param index          the index
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(int index, SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param index    the index
     * @param property bean property
     * @return LogicExpression
     */
    L lt(int index, SerializableLocalTimeSupplier property);

    /**
     * less than. 小于.
     *
     * @param index          the index
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(int index, SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param index    the index
     * @param property bean property
     * @return LogicExpression
     */
    L lt(int index, SerializableLocalDateTimeSupplier property);

    /**
     * less than. 小于.
     *
     * @param index          the index
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(int index, SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param index    the index
     * @param property bean property
     * @return LogicExpression
     */
    default L lt(int index, SerializableStringSupplier property) {
        return lt(index, property, MatchStrategy.AUTO);
    }

    /**
     * less than. 小于.
     *
     * @param index          the index
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lt(int index, SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return lt(index, property, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * less than. 小于.
     *
     * @param index             the index
     * @param property          bean property
     * @param mathMatchStrategy the math match strategy
     * @return LogicExpression
     */
    L lt(int index, SerializableStringSupplier property, MatchStrategy mathMatchStrategy);

    /**
     * less than. 小于.
     *
     * @param index             the index
     * @param property          bean property
     * @param mathMatchStrategy the math match strategy
     * @param ignoreStrategy    the ignore strategy
     * @return LogicExpression
     */
    L lt(int index, SerializableStringSupplier property, MatchStrategy mathMatchStrategy,
            Predicate<String> ignoreStrategy);
}