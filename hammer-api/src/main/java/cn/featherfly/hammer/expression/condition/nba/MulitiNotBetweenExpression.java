
package cn.featherfly.hammer.expression.condition.nba;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.function.BiPredicate;

import cn.featherfly.common.function.serializable.SerializableToDateFunction;
import cn.featherfly.common.function.serializable.SerializableToDoubleFunction;
import cn.featherfly.common.function.serializable.SerializableToEnumFunction;
import cn.featherfly.common.function.serializable.SerializableToIntFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalDateFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalDateTimeFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalTimeFunction;
import cn.featherfly.common.function.serializable.SerializableToLongFunction;
import cn.featherfly.common.function.serializable.SerializableToNumberFunction;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.common.repository.AliasField;
import cn.featherfly.common.repository.Field;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * muliti not between and expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface MulitiNotBetweenExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * not between and.
     *
     * @param index the index
     * @param name  the name
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    L nba(int index, String name, int min, int max);

    /**
     * not between and.
     *
     * @param index          the index
     * @param name the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nba(int index, String name, int min, int max, BiPredicate<Integer, Integer> ignoreStrategy);

    /**
     * not between and.
     *
     * @param index the index
     * @param name  the name
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    L nba(int index, String name, long min, long max);

    /**
     * not between and.
     *
     * @param index          the index
     * @param name the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nba(int index, String name, long min, long max, BiPredicate<Long, Long> ignoreStrategy);

    /**
     * not between and.
     *
     * @param index the index
     * @param name  the name
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    L nba(int index, String name, double min, double max);

    /**
     * not between and.
     *
     * @param index          the index
     * @param name the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nba(int index, String name, double min, double max, BiPredicate<Double, Double> ignoreStrategy);

    /**
     * not between and.
     *
     * @param <N>   number type
     * @param index the index
     * @param name  the name
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    <N extends Number> L nba(int index, String name, N min, N max);

    /**
     * not between and.
     *
     * @param <N>            number type
     * @param index          the index
     * @param name the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L nba(int index, String name, N min, N max, BiPredicate<N, N> ignoreStrategy);

    /**
     * not between and.
     *
     * @param <D>   date type
     * @param index the index
     * @param name  the name
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    <D extends Date> L nba(int index, String name, D min, D max);

    /**
     * not between and.
     *
     * @param <D>            date type
     * @param index          the index
     * @param name the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L nba(int index, String name, D min, D max, BiPredicate<D, D> ignoreStrategy);

    /**
     * not between and.
     *
     * @param <E>   the enum type
     * @param index the index
     * @param name  the name
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    <E extends Enum<E>> L nba(int index, String name, E min, E max);

    /**
     * not between and.
     *
     * @param <E>            the enum type
     * @param index          the index
     * @param name the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E extends Enum<E>> L nba(int index, String name, E min, E max, BiPredicate<E, E> ignoreStrategy);

    /**
     * not between and.
     *
     * @param index the index
     * @param name  the name
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    L nba(int index, String name, LocalTime min, LocalTime max);

    /**
     * not between and.
     *
     * @param index          the index
     * @param name the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nba(int index, String name, LocalTime min, LocalTime max, BiPredicate<LocalTime, LocalTime> ignoreStrategy);

    /**
     * not between and.
     *
     * @param index the index
     * @param name  the name
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    L nba(int index, String name, LocalDate min, LocalDate max);

    /**
     * not between and.
     *
     * @param index          the index
     * @param name the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nba(int index, String name, LocalDate min, LocalDate max, BiPredicate<LocalDate, LocalDate> ignoreStrategy);

    /**
     * not between and.
     *
     * @param index the index
     * @param name  the name
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    L nba(int index, String name, LocalDateTime min, LocalDateTime max);

    /**
     * not between and.
     *
     * @param index          the index
     * @param name the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nba(int index, String name, LocalDateTime min, LocalDateTime max,
            BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy);

    /**
     * not between and.
     *
     * @param index the index
     * @param name  the name
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    L nba(int index, String name, String min, String max);

    /**
     * not between and.
     *
     * @param index          the index
     * @param name the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nba(int index, String name, String min, String max, BiPredicate<String, String> ignoreStrategy);

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * not between and.
     *
     * @param index the index
     * @param field the field
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    default L nba(int index, Field field, int min, int max) {
        return nba(index, field.name(), min, max);
    }

    /**
     * not between and.
     *
     * @param index          the index
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nba(int index, Field field, int min, int max, BiPredicate<Integer, Integer> ignoreStrategy) {
        return nba(index, field.name(), min, max, ignoreStrategy);
    }

    /**
     * not between and.
     *
     * @param index the index
     * @param field the field
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    default L nba(int index, Field field, long min, long max) {
        return nba(index, field.name(), min, max);
    }

    /**
     * not between and.
     *
     * @param index          the index
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nba(int index, Field field, long min, long max, BiPredicate<Long, Long> ignoreStrategy) {
        return nba(index, field.name(), min, max, ignoreStrategy);
    }

    /**
     * not between and.
     *
     * @param index the index
     * @param field the field
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    default L nba(int index, Field field, double min, double max) {
        return nba(index, field.name(), min, max);
    }

    /**
     * not between and.
     *
     * @param index          the index
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nba(int index, Field field, double min, double max, BiPredicate<Double, Double> ignoreStrategy) {
        return nba(index, field.name(), min, max, ignoreStrategy);
    }

    /**
     * not between and.
     *
     * @param <N>   number type
     * @param index the index
     * @param field the field
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    default <N extends Number> L nba(int index, Field field, N min, N max) {
        return nba(index, field.name(), min, max);
    }

    /**
     * not between and.
     *
     * @param <N>            number type
     * @param index          the index
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L nba(int index, Field field, N min, N max, BiPredicate<N, N> ignoreStrategy) {
        return nba(index, field.name(), min, max, ignoreStrategy);
    }

    /**
     * not between and.
     *
     * @param <D>   date type
     * @param index the index
     * @param field the field
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    default <D extends Date> L nba(int index, Field field, D min, D max) {
        return nba(index, field.name(), min, max);
    }

    /**
     * not between and.
     *
     * @param <D>            date type
     * @param index          the index
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L nba(int index, Field field, D min, D max, BiPredicate<D, D> ignoreStrategy) {
        return nba(index, field.name(), min, max, ignoreStrategy);
    }

    /**
     * not between and.
     *
     * @param <E>   the enum type
     * @param index the index
     * @param field the field
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    default <E extends Enum<E>> L nba(int index, Field field, E min, E max) {
        return nba(index, field.name(), min, max);
    }

    /**
     * not between and.
     *
     * @param <E>            the enum type
     * @param index          the index
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E extends Enum<E>> L nba(int index, Field field, E min, E max, BiPredicate<E, E> ignoreStrategy) {
        return nba(index, field.name(), min, max, ignoreStrategy);
    }

    /**
     * not between and.
     *
     * @param index the index
     * @param field the field
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    default L nba(int index, Field field, LocalTime min, LocalTime max) {
        return nba(index, field.name(), min, max);
    }

    /**
     * not between and.
     *
     * @param index          the index
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nba(int index, Field field, LocalTime min, LocalTime max,
            BiPredicate<LocalTime, LocalTime> ignoreStrategy) {
        return nba(index, field.name(), min, max, ignoreStrategy);
    }

    /**
     * not between and.
     *
     * @param index the index
     * @param field the field
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    default L nba(int index, Field field, LocalDate min, LocalDate max) {
        return nba(index, field.name(), min, max);
    }

    /**
     * not between and.
     *
     * @param index          the index
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nba(int index, Field field, LocalDate min, LocalDate max,
            BiPredicate<LocalDate, LocalDate> ignoreStrategy) {
        return nba(index, field.name(), min, max, ignoreStrategy);
    }

    /**
     * not between and.
     *
     * @param index the index
     * @param field the field
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    default L nba(int index, Field field, LocalDateTime min, LocalDateTime max) {
        return nba(index, field.name(), min, max);
    }

    /**
     * not between and.
     *
     * @param index          the index
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nba(int index, Field field, LocalDateTime min, LocalDateTime max,
            BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {
        return nba(index, field.name(), min, max, ignoreStrategy);
    }

    /**
     * not between and.
     *
     * @param index the index
     * @param field the field
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    default L nba(int index, Field field, String min, String max) {
        return nba(index, field.name(), min, max);
    }

    /**
     * not between and.
     *
     * @param index          the index
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nba(int index, Field field, String min, String max, BiPredicate<String, String> ignoreStrategy) {
        return nba(index, field.name(), min, max, ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * not between and.
     *
     * @param index the index
     * @param field the field
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    default L nba(int index, AliasField field, int min, int max) {
        return nba(index, field.getAliasOrName(), min, max);
    }

    /**
     * not between and.
     *
     * @param index          the index
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nba(int index, AliasField field, int min, int max, BiPredicate<Integer, Integer> ignoreStrategy) {
        return nba(index, field.getAliasOrName(), min, max, ignoreStrategy);
    }

    /**
     * not between and.
     *
     * @param index the index
     * @param field the field
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    default L nba(int index, AliasField field, long min, long max) {
        return nba(index, field.getAliasOrName(), min, max);
    }

    /**
     * not between and.
     *
     * @param index          the index
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nba(int index, AliasField field, long min, long max, BiPredicate<Long, Long> ignoreStrategy) {
        return nba(index, field.getAliasOrName(), min, max, ignoreStrategy);
    }

    /**
     * not between and.
     *
     * @param index the index
     * @param field the field
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    default L nba(int index, AliasField field, double min, double max) {
        return nba(index, field.getAliasOrName(), min, max);
    }

    /**
     * not between and.
     *
     * @param index          the index
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nba(int index, AliasField field, double min, double max, BiPredicate<Double, Double> ignoreStrategy) {
        return nba(index, field.getAliasOrName(), min, max, ignoreStrategy);
    }

    /**
     * not between and.
     *
     * @param <N>   number type
     * @param index the index
     * @param field the field
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    default <N extends Number> L nba(int index, AliasField field, N min, N max) {
        return nba(index, field.getAliasOrName(), min, max);
    }

    /**
     * not between and.
     *
     * @param <N>            number type
     * @param index          the index
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L nba(int index, AliasField field, N min, N max, BiPredicate<N, N> ignoreStrategy) {
        return nba(index, field.getAliasOrName(), min, max, ignoreStrategy);
    }

    /**
     * not between and.
     *
     * @param <D>   date type
     * @param index the index
     * @param field the field
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    default <D extends Date> L nba(int index, AliasField field, D min, D max) {
        return nba(index, field.getAliasOrName(), min, max);
    }

    /**
     * not between and.
     *
     * @param <D>            date type
     * @param index          the index
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L nba(int index, AliasField field, D min, D max, BiPredicate<D, D> ignoreStrategy) {
        return nba(index, field.getAliasOrName(), min, max, ignoreStrategy);
    }

    /**
     * not between and.
     *
     * @param <E>   the enum type
     * @param index the index
     * @param field the field
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    default <E extends Enum<E>> L nba(int index, AliasField field, E min, E max) {
        return nba(index, field.getAliasOrName(), min, max);
    }

    /**
     * not between and.
     *
     * @param <E>            the enum type
     * @param index          the index
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E extends Enum<E>> L nba(int index, AliasField field, E min, E max, BiPredicate<E, E> ignoreStrategy) {
        return nba(index, field.getAliasOrName(), min, max, ignoreStrategy);
    }

    /**
     * not between and.
     *
     * @param index the index
     * @param field the field
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    default L nba(int index, AliasField field, LocalTime min, LocalTime max) {
        return nba(index, field.getAliasOrName(), min, max);
    }

    /**
     * not between and.
     *
     * @param index          the index
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nba(int index, AliasField field, LocalTime min, LocalTime max,
            BiPredicate<LocalTime, LocalTime> ignoreStrategy) {
        return nba(index, field.getAliasOrName(), min, max, ignoreStrategy);
    }

    /**
     * not between and.
     *
     * @param index the index
     * @param field the field
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    default L nba(int index, AliasField field, LocalDate min, LocalDate max) {
        return nba(index, field.getAliasOrName(), min, max);
    }

    /**
     * not between and.
     *
     * @param index          the index
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nba(int index, AliasField field, LocalDate min, LocalDate max,
            BiPredicate<LocalDate, LocalDate> ignoreStrategy) {
        return nba(index, field.getAliasOrName(), min, max, ignoreStrategy);
    }

    /**
     * not between and.
     *
     * @param index the index
     * @param field the field
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    default L nba(int index, AliasField field, LocalDateTime min, LocalDateTime max) {
        return nba(index, field.getAliasOrName(), min, max);
    }

    /**
     * not between and.
     *
     * @param index          the index
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nba(int index, AliasField field, LocalDateTime min, LocalDateTime max,
            BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {
        return nba(index, field.getAliasOrName(), min, max, ignoreStrategy);
    }

    /**
     * not between and.
     *
     * @param index the index
     * @param field the field
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    default L nba(int index, AliasField field, String min, String max) {
        return nba(index, field.getAliasOrName(), min, max);
    }

    /**
     * not between and.
     *
     * @param index          the index
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nba(int index, AliasField field, String min, String max, BiPredicate<String, String> ignoreStrategy) {
        return nba(index, field.getAliasOrName(), min, max, ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * not between and.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  the name
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    <E> L nba(int index, SerializableToIntFunction<E> name, int min, int max);

    /**
     * not between and.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L nba(int index, SerializableToIntFunction<E> name, int min, int max,
            BiPredicate<Integer, Integer> ignoreStrategy);

    /**
     * not between and.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  the name
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    <E> L nba(int index, SerializableToLongFunction<E> name, long min, long max);

    /**
     * not between and.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L nba(int index, SerializableToLongFunction<E> name, long min, long max,
            BiPredicate<Long, Long> ignoreStrategy);

    /**
     * not between and.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  the name
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    <E> L nba(int index, SerializableToDoubleFunction<E> name, double min, double max);

    /**
     * not between and.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L nba(int index, SerializableToDoubleFunction<E> name, double min, double max,
            BiPredicate<Double, Double> ignoreStrategy);

    /**
     * not between and.
     *
     * @param <E>   the element type
     * @param <N>   number type
     * @param index the index
     * @param name  the name
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    <E, N extends Number> L nba(int index, SerializableToNumberFunction<E, N> name, N min, N max);

    /**
     * not between and.
     *
     * @param <E>            the element type
     * @param <N>            number type
     * @param index          the index
     * @param name the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E, N extends Number> L nba(int index, SerializableToNumberFunction<E, N> name, N min, N max,
            BiPredicate<N, N> ignoreStrategy);

    /**
     * not between and.
     *
     * @param <E>   the element type
     * @param <D>   date type
     * @param index the index
     * @param name  the name
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    <E, D extends Date> L nba(int index, SerializableToDateFunction<E, D> name, D min, D max);

    /**
     * not between and.
     *
     * @param <E>            the element type
     * @param <D>            date type
     * @param index          the index
     * @param name the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E, D extends Date> L nba(int index, SerializableToDateFunction<E, D> name, D min, D max,
            BiPredicate<D, D> ignoreStrategy);

    /**
     * not between and.
     *
     * @param <T>   the generic type
     * @param <E>   the enum type
     * @param index the index
     * @param name  the name
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    <T, E extends Enum<E>> L nba(int index, SerializableToEnumFunction<T, E> name, E min, E max);

    /**
     * not between and.
     *
     * @param <T>            the generic type
     * @param <E>            the enum type
     * @param index          the index
     * @param name the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T, E extends Enum<E>> L nba(int index, SerializableToEnumFunction<T, E> name, E min, E max,
            BiPredicate<E, E> ignoreStrategy);

    /**
     * not between and.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  the name
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    <E> L nba(int index, SerializableToLocalTimeFunction<E> name, LocalTime min, LocalTime max);

    /**
     * not between and.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L nba(int index, SerializableToLocalTimeFunction<E> name, LocalTime min, LocalTime max,
            BiPredicate<LocalTime, LocalTime> ignoreStrategy);

    /**
     * not between and.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  the name
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    <E> L nba(int index, SerializableToLocalDateFunction<E> name, LocalDate min, LocalDate max);

    /**
     * not between and.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L nba(int index, SerializableToLocalDateFunction<E> name, LocalDate min, LocalDate max,
            BiPredicate<LocalDate, LocalDate> ignoreStrategy);

    /**
     * not between and.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  the name
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    <E> L nba(int index, SerializableToLocalDateTimeFunction<E> name, LocalDateTime min, LocalDateTime max);

    /**
     * not between and.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L nba(int index, SerializableToLocalDateTimeFunction<E> name, LocalDateTime min, LocalDateTime max,
            BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy);

    /**
     * not between and.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  the name
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    <E> L nba(int index, SerializableToStringFunction<E> name, String min, String max);

    /**
     * not between and.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L nba(int index, SerializableToStringFunction<E> name, String min, String max,
            BiPredicate<String, String> ignoreStrategy);
}