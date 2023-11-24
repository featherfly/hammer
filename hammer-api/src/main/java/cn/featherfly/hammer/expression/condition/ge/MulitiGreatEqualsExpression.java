
package cn.featherfly.hammer.expression.condition.ge;

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
 * muliti great equals expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface MulitiGreatEqualsExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * great and equals. 大于等于.
     *
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L ge(int index, String name, int value);

    /**
     * great and equals. 大于等于.
     *
     * @param index          the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(int index, String name, int value, IntPredicate ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L ge(int index, String name, long value);

    /**
     * great and equals. 大于等于.
     *
     * @param index          the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(int index, String name, long value, LongPredicate ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L ge(int index, String name, double value);

    /**
     * great and equals. 大于等于.
     *
     * @param index          the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(int index, String name, double value, DoublePredicate ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param <N>   number type
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <N extends Number> L ge(int index, String name, N value);

    /**
     * great and equals. 大于等于.
     *
     * @param <N>            number type
     * @param index          the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L ge(int index, String name, N value, Predicate<N> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <E extends Enum<E>> L ge(int index, String name, E value);

    /**
     * great and equals. 大于等于.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E extends Enum<E>> L ge(int index, String name, E value, Predicate<E> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param <D>   date type
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <D extends Date> L ge(int index, String name, D value);

    /**
     * great and equals. 大于等于.
     *
     * @param <D>            date type
     * @param index          the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L ge(int index, String name, D value, Predicate<D> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L ge(int index, String name, LocalTime value);

    /**
     * great and equals. 大于等于.
     *
     * @param index          the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(int index, String name, LocalTime value, Predicate<LocalTime> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L ge(int index, String name, LocalDate value);

    /**
     * great and equals. 大于等于.
     *
     * @param index          the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(int index, String name, LocalDate value, Predicate<LocalDate> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L ge(int index, String name, LocalDateTime value);

    /**
     * great and equals. 大于等于.
     *
     * @param index          the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(int index, String name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default L ge(int index, String name, String value) {
        return ge(index, name, value, MatchStrategy.AUTO);
    }

    /**
     * great and equals. 大于等于.
     *
     * @param index          the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge(int index, String name, String value, Predicate<String> ignoreStrategy) {
        return ge(index, name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * great and equals. 大于等于.
     *
     * @param index             the index
     * @param name the name
     * @param value the value
     * @param mathMatchStrategy the math match strategy
     * @return LogicExpression
     */
    L ge(int index, String name, String value, MatchStrategy mathMatchStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param index             the index
     * @param name the name
     * @param value the value
     * @param mathMatchStrategy the math match strategy
     * @param ignoreStrategy    the ignore strategy
     * @return LogicExpression
     */
    L ge(int index, String name, String value, MatchStrategy mathMatchStrategy, Predicate<String> ignoreStrategy);

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * great and equals. 大于等于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L ge(int index, Field field, int value) {
        return ge(index, field.name(), value);
    }

    /**
     * great and equals. 大于等于.
     *
     * @param index          the index
     * @param field          the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge(int index, Field field, int value, IntPredicate ignoreStrategy) {
        return ge(index, field.name(), value, ignoreStrategy);
    }

    /**
     * great and equals. 大于等于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L ge(int index, Field field, long value) {
        return ge(index, field.name(), value);
    }

    /**
     * great and equals. 大于等于.
     *
     * @param index          the index
     * @param field          the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge(int index, Field field, long value, LongPredicate ignoreStrategy) {
        return ge(index, field.name(), value, ignoreStrategy);
    }

    /**
     * great and equals. 大于等于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L ge(int index, Field field, double value) {
        return ge(index, field.name(), value);
    }

    /**
     * great and equals. 大于等于.
     *
     * @param index          the index
     * @param field          the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge(int index, Field field, double value, DoublePredicate ignoreStrategy) {
        return ge(index, field.name(), value, ignoreStrategy);
    }

    /**
     * great and equals. 大于等于.
     *
     * @param <N>   number type
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <N extends Number> L ge(int index, Field field, N value) {
        return ge(index, field.name(), value);
    }

    /**
     * great and equals. 大于等于.
     *
     * @param <N>            number type
     * @param index          the index
     * @param field          the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L ge(int index, Field field, N value, Predicate<N> ignoreStrategy) {
        return ge(index, field.name(), value, ignoreStrategy);
    }

    /**
     * great and equals. 大于等于.
     *
     * @param <E>   the element type
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <E extends Enum<E>> L ge(int index, Field field, E value) {
        return ge(index, field.name(), value);
    }

    /**
     * great and equals. 大于等于.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param field          the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E extends Enum<E>> L ge(int index, Field field, E value, Predicate<E> ignoreStrategy) {
        return ge(index, field.name(), value, ignoreStrategy);
    }

    /**
     * great and equals. 大于等于.
     *
     * @param <D>   date type
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <D extends Date> L ge(int index, Field field, D value) {
        return ge(index, field.name(), value);
    }

    /**
     * great and equals. 大于等于.
     *
     * @param <D>            date type
     * @param index          the index
     * @param field          the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L ge(int index, Field field, D value, Predicate<D> ignoreStrategy) {
        return ge(index, field.name(), value, ignoreStrategy);
    }

    /**
     * great and equals. 大于等于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L ge(int index, Field field, LocalTime value) {
        return ge(index, field.name(), value);
    }

    /**
     * great and equals. 大于等于.
     *
     * @param index          the index
     * @param field          the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge(int index, Field field, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return ge(index, field.name(), value, ignoreStrategy);
    }

    /**
     * great and equals. 大于等于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L ge(int index, Field field, LocalDate value) {
        return ge(index, field.name(), value);
    }

    /**
     * great and equals. 大于等于.
     *
     * @param index          the index
     * @param field          the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge(int index, Field field, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return ge(index, field.name(), value, ignoreStrategy);
    }

    /**
     * great and equals. 大于等于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L ge(int index, Field field, LocalDateTime value) {
        return ge(index, field.name(), value);
    }

    /**
     * great and equals. 大于等于.
     *
     * @param index          the index
     * @param field          the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge(int index, Field field, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return ge(index, field.name(), value, ignoreStrategy);
    }

    /**
     * great and equals. 大于等于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L ge(int index, Field field, String value) {
        return ge(index, field, value, MatchStrategy.AUTO);
    }

    /**
     * great and equals. 大于等于.
     *
     * @param index          the index
     * @param field          the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge(int index, Field field, String value, Predicate<String> ignoreStrategy) {
        return ge(index, field.name(), value, ignoreStrategy);
    }

    /**
     * great and equals. 大于等于.
     *
     * @param index             the index
     * @param field             the field
     * @param value the value
     * @param mathMatchStrategy the math match strategy
     * @return LogicExpression
     */
    default L ge(int index, Field field, String value, MatchStrategy mathMatchStrategy) {
        return ge(index, field.name(), value, mathMatchStrategy);
    }

    /**
     * great and equals. 大于等于.
     *
     * @param index             the index
     * @param field             the field
     * @param value the value
     * @param mathMatchStrategy the math match strategy
     * @param ignoreStrategy    the ignore strategy
     * @return LogicExpression
     */
    default L ge(int index, Field field, String value, MatchStrategy mathMatchStrategy,
            Predicate<String> ignoreStrategy) {
        return ge(index, field.name(), value, ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * great and equals. 大于等于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L ge(int index, AliasField field, int value) {
        return ge(index, field.getAliasOrName(), value);
    }

    /**
     * great and equals. 大于等于.
     *
     * @param index          the index
     * @param field          the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge(int index, AliasField field, int value, IntPredicate ignoreStrategy) {
        return ge(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * great and equals. 大于等于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L ge(int index, AliasField field, long value) {
        return ge(index, field.getAliasOrName(), value);
    }

    /**
     * great and equals. 大于等于.
     *
     * @param index          the index
     * @param field          the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge(int index, AliasField field, long value, LongPredicate ignoreStrategy) {
        return ge(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * great and equals. 大于等于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L ge(int index, AliasField field, double value) {
        return ge(index, field.getAliasOrName(), value);
    }

    /**
     * great and equals. 大于等于.
     *
     * @param index          the index
     * @param field          the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge(int index, AliasField field, double value, DoublePredicate ignoreStrategy) {
        return ge(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * great and equals. 大于等于.
     *
     * @param <N>   number type
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <N extends Number> L ge(int index, AliasField field, N value) {
        return ge(index, field.getAliasOrName(), value);
    }

    /**
     * great and equals. 大于等于.
     *
     * @param <N>            number type
     * @param index          the index
     * @param field          the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L ge(int index, AliasField field, N value, Predicate<N> ignoreStrategy) {
        return ge(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * great and equals. 大于等于.
     *
     * @param <E>   the element type
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <E extends Enum<E>> L ge(int index, AliasField field, E value) {
        return ge(index, field.getAliasOrName(), value);
    }

    /**
     * great and equals. 大于等于.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param field          the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E extends Enum<E>> L ge(int index, AliasField field, E value, Predicate<E> ignoreStrategy) {
        return ge(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * great and equals. 大于等于.
     *
     * @param <D>   date type
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <D extends Date> L ge(int index, AliasField field, D value) {
        return ge(index, field.getAliasOrName(), value);
    }

    /**
     * great and equals. 大于等于.
     *
     * @param <D>            date type
     * @param index          the index
     * @param field          the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L ge(int index, AliasField field, D value, Predicate<D> ignoreStrategy) {
        return ge(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * great and equals. 大于等于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L ge(int index, AliasField field, LocalTime value) {
        return ge(index, field.getAliasOrName(), value);
    }

    /**
     * great and equals. 大于等于.
     *
     * @param index          the index
     * @param field          the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge(int index, AliasField field, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return ge(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * great and equals. 大于等于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L ge(int index, AliasField field, LocalDate value) {
        return ge(index, field.getAliasOrName(), value);
    }

    /**
     * great and equals. 大于等于.
     *
     * @param index          the index
     * @param field          the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge(int index, AliasField field, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return ge(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * great and equals. 大于等于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L ge(int index, AliasField field, LocalDateTime value) {
        return ge(index, field.getAliasOrName(), value);
    }

    /**
     * great and equals. 大于等于.
     *
     * @param index          the index
     * @param field          the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge(int index, AliasField field, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return ge(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * great and equals. 大于等于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L ge(int index, AliasField field, String value) {
        return ge(index, field, value, MatchStrategy.AUTO);
    }

    /**
     * great and equals. 大于等于.
     *
     * @param index          the index
     * @param field          the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge(int index, AliasField field, String value, Predicate<String> ignoreStrategy) {
        return ge(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * great and equals. 大于等于.
     *
     * @param index             the index
     * @param field             the field
     * @param value the value
     * @param mathMatchStrategy the math match strategy
     * @return LogicExpression
     */
    default L ge(int index, AliasField field, String value, MatchStrategy mathMatchStrategy) {
        return ge(index, field.getAliasOrName(), value, mathMatchStrategy);
    }

    /**
     * great and equals. 大于等于.
     *
     * @param index             the index
     * @param field             the field
     * @param value the value
     * @param mathMatchStrategy the math match strategy
     * @param ignoreStrategy    the ignore strategy
     * @return LogicExpression
     */
    default L ge(int index, AliasField field, String value, MatchStrategy mathMatchStrategy,
            Predicate<String> ignoreStrategy) {
        return ge(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * great and equals. 大于等于.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <E> L ge(int index, SerializableToIntFunction<E> name, int value);

    /**
     * great and equals. 大于等于.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L ge(int index, SerializableToIntFunction<E> name, int value, IntPredicate ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <E> L ge(int index, SerializableToLongFunction<E> name, long value);

    /**
     * great and equals. 大于等于.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L ge(int index, SerializableToLongFunction<E> name, long value, LongPredicate ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <E> L ge(int index, SerializableToDoubleFunction<E> name, double value);

    /**
     * great and equals. 大于等于.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L ge(int index, SerializableToDoubleFunction<E> name, double value, DoublePredicate ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param <E>   the element type
     * @param <N>   number type
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <E, N extends Number> L ge(int index, SerializableFunction<E, N> name, N value);

    /**
     * great and equals. 大于等于.
     *
     * @param <E>            the element type
     * @param <N>            number type
     * @param index          the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E, N extends Number> L ge(int index, SerializableFunction<E, N> name, N value, Predicate<N> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param <T>   the generic type
     * @param <E>   the element type
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <T, E extends Enum<E>> L ge(int index, SerializableFunction<T, E> name, E value);

    /**
     * great and equals. 大于等于.
     *
     * @param <T>            the generic type
     * @param <E>            the element type
     * @param index          the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T, E extends Enum<E>> L ge(int index, SerializableFunction<T, E> name, E value, Predicate<E> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param <E>   the element type
     * @param <D>   date type
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <E, D extends Date> L ge(int index, SerializableFunction<E, D> name, D value);

    /**
     * great and equals. 大于等于.
     *
     * @param <E>            the element type
     * @param <D>            date type
     * @param index          the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E, D extends Date> L ge(int index, SerializableFunction<E, D> name, D value, Predicate<D> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <E> L ge(int index, SerializableFunction<E, LocalTime> name, LocalTime value);

    /**
     * great and equals. 大于等于.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L ge(int index, SerializableFunction<E, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <E> L ge(int index, SerializableFunction<E, LocalDate> name, LocalDate value);

    /**
     * great and equals. 大于等于.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L ge(int index, SerializableFunction<E, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <E> L ge(int index, SerializableFunction<E, LocalDateTime> name, LocalDateTime value);

    /**
     * great and equals. 大于等于.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L ge(int index, SerializableFunction<E, LocalDateTime> name, LocalDateTime value,
            Predicate<LocalDateTime> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default <E> L ge(int index, SerializableFunction<E, String> name, String value) {
        return ge(index, name, value, MatchStrategy.AUTO);
    }

    /**
     * great and equals. 大于等于.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E> L ge(int index, SerializableFunction<E, String> name, String value, Predicate<String> ignoreStrategy) {
        return ge(index, name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * great and equals. 大于等于.
     *
     * @param <E>               the element type
     * @param index             the index
     * @param name the name
     * @param value the value
     * @param mathMatchStrategy the math match strategy
     * @return LogicExpression
     */
    <E> L ge(int index, SerializableFunction<E, String> name, String value, MatchStrategy mathMatchStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param <E>               the element type
     * @param index             the index
     * @param name the name
     * @param value the value
     * @param mathMatchStrategy the math match strategy
     * @param ignoreStrategy    the ignore strategy
     * @return LogicExpression
     */
    <E> L ge(int index, SerializableFunction<E, String> name, String value, MatchStrategy mathMatchStrategy,
            Predicate<String> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param index    the index
     * @param property bean property
     * @return LogicExpression
     */
    L ge(int index, SerializableIntSupplier property);

    /**
     * great and equals. 大于等于.
     *
     * @param index          the index
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(int index, SerializableIntSupplier property, IntPredicate ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param index    the index
     * @param property bean property
     * @return LogicExpression
     */
    L ge(int index, SerializableLongSupplier property);

    /**
     * great and equals. 大于等于.
     *
     * @param index          the index
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(int index, SerializableLongSupplier property, LongPredicate ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param index    the index
     * @param property bean property
     * @return LogicExpression
     */
    L ge(int index, SerializableDoubleSupplier property);

    /**
     * great and equals. 大于等于.
     *
     * @param index          the index
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(int index, SerializableDoubleSupplier property, DoublePredicate ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param <R>      the generic type
     * @param index    the index
     * @param property bean property
     * @return LogicExpression
     */
    <R extends Date> L ge(int index, SerializableDateSupplier<R> property);

    /**
     * great and equals. 大于等于.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R extends Date> L ge(int index, SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param <R>      the generic type
     * @param index    the index
     * @param property bean property
     * @return LogicExpression
     */
    <R extends Number> L ge(int index, SerializableNumberSupplier<R> property);

    /**
     * great and equals. 大于等于.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R extends Number> L ge(int index, SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param <E>      the element type
     * @param index    the index
     * @param property bean property
     * @return LogicExpression
     */
    <E extends Enum<E>> L ge(int index, SerializableEnumSupplier<E> property);

    /**
     * great and equals. 大于等于.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E extends Enum<E>> L ge(int index, SerializableEnumSupplier<E> property, Predicate<E> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param index    the index
     * @param property bean property
     * @return LogicExpression
     */
    L ge(int index, SerializableLocalDateSupplier property);

    /**
     * great and equals. 大于等于.
     *
     * @param index          the index
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(int index, SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param index    the index
     * @param property bean property
     * @return LogicExpression
     */
    L ge(int index, SerializableLocalTimeSupplier property);

    /**
     * great and equals. 大于等于.
     *
     * @param index          the index
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(int index, SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param index    the index
     * @param property bean property
     * @return LogicExpression
     */
    L ge(int index, SerializableLocalDateTimeSupplier property);

    /**
     * great and equals. 大于等于.
     *
     * @param index          the index
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(int index, SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param index    the index
     * @param property bean property
     * @return LogicExpression
     */
    default L ge(int index, SerializableStringSupplier property) {
        return ge(index, property, MatchStrategy.AUTO);
    }

    /**
     * great and equals. 大于等于.
     *
     * @param index          the index
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge(int index, SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return ge(index, property, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * great and equals. 大于等于.
     *
     * @param index             the index
     * @param property          bean property
     * @param mathMatchStrategy the math match strategy
     * @return LogicExpression
     */
    L ge(int index, SerializableStringSupplier property, MatchStrategy mathMatchStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param index             the index
     * @param property          bean property
     * @param mathMatchStrategy the math match strategy
     * @param ignoreStrategy    the ignore strategy
     * @return LogicExpression
     */
    L ge(int index, SerializableStringSupplier property, MatchStrategy mathMatchStrategy,
            Predicate<String> ignoreStrategy);
}