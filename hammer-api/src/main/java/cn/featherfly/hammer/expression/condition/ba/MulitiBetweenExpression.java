
package cn.featherfly.hammer.expression.condition.ba;

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
 * muliti between and expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface MulitiBetweenExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * between and.
     *
     * @param index the index
     * @param name  the name
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    L ba(int index, String name, int min, int max);

    /**
     * between and.
     *
     * @param index          the index
     * @param name the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ba(int index, String name, int min, int max, BiPredicate<Integer, Integer> ignoreStrategy);

    /**
     * between and.
     *
     * @param index the index
     * @param name  the name
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    L ba(int index, String name, long min, long max);

    /**
     * between and.
     *
     * @param index          the index
     * @param name the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ba(int index, String name, long min, long max, BiPredicate<Long, Long> ignoreStrategy);

    /**
     * between and.
     *
     * @param index the index
     * @param name  the name
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    L ba(int index, String name, double min, double max);

    /**
     * between and.
     *
     * @param index          the index
     * @param name the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ba(int index, String name, double min, double max, BiPredicate<Double, Double> ignoreStrategy);

    /**
     * between and.
     *
     * @param <N>   number type
     * @param index the index
     * @param name  the name
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    <N extends Number> L ba(int index, String name, N min, N max);

    /**
     * between and.
     *
     * @param <N>            number type
     * @param index          the index
     * @param name the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L ba(int index, String name, N min, N max, BiPredicate<N, N> ignoreStrategy);

    /**
     * between and.
     *
     * @param <D>   date type
     * @param index the index
     * @param name  the name
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    <D extends Date> L ba(int index, String name, D min, D max);

    /**
     * between and.
     *
     * @param <D>            date type
     * @param index          the index
     * @param name the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L ba(int index, String name, D min, D max, BiPredicate<D, D> ignoreStrategy);

    /**
     * between and.
     *
     * @param <E>   the enum type
     * @param index the index
     * @param name  the name
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    <E extends Enum<E>> L ba(int index, String name, E min, E max);

    /**
     * between and.
     *
     * @param <E>            the enum type
     * @param index          the index
     * @param name the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E extends Enum<E>> L ba(int index, String name, E min, E max, BiPredicate<E, E> ignoreStrategy);

    /**
     * between and.
     *
     * @param index the index
     * @param name  the name
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    L ba(int index, String name, LocalTime min, LocalTime max);

    /**
     * between and.
     *
     * @param index          the index
     * @param name the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ba(int index, String name, LocalTime min, LocalTime max, BiPredicate<LocalTime, LocalTime> ignoreStrategy);

    /**
     * between and.
     *
     * @param index the index
     * @param name  the name
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    L ba(int index, String name, LocalDate min, LocalDate max);

    /**
     * between and.
     *
     * @param index          the index
     * @param name the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ba(int index, String name, LocalDate min, LocalDate max, BiPredicate<LocalDate, LocalDate> ignoreStrategy);

    /**
     * between and.
     *
     * @param index the index
     * @param name  the name
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    L ba(int index, String name, LocalDateTime min, LocalDateTime max);

    /**
     * between and.
     *
     * @param index          the index
     * @param name the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ba(int index, String name, LocalDateTime min, LocalDateTime max,
            BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy);

    /**
     * between and.
     *
     * @param index the index
     * @param name  the name
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    L ba(int index, String name, String min, String max);

    /**
     * between and.
     *
     * @param index          the index
     * @param name the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ba(int index, String name, String min, String max, BiPredicate<String, String> ignoreStrategy);

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * between and.
     *
     * @param index the index
     * @param field the field
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    default L ba(int index, Field field, int min, int max) {
        return ba(index, field.name(), min, max);
    }

    /**
     * between and.
     *
     * @param index          the index
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ba(int index, Field field, int min, int max, BiPredicate<Integer, Integer> ignoreStrategy) {
        return ba(index, field.name(), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param index the index
     * @param field the field
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    default L ba(int index, Field field, long min, long max) {
        return ba(index, field.name(), min, max);
    }

    /**
     * between and.
     *
     * @param index          the index
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ba(int index, Field field, long min, long max, BiPredicate<Long, Long> ignoreStrategy) {
        return ba(index, field.name(), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param index the index
     * @param field the field
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    default L ba(int index, Field field, double min, double max) {
        return ba(index, field.name(), min, max);
    }

    /**
     * between and.
     *
     * @param index          the index
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ba(int index, Field field, double min, double max, BiPredicate<Double, Double> ignoreStrategy) {
        return ba(index, field.name(), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param <N>   number type
     * @param index the index
     * @param field the field
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    default <N extends Number> L ba(int index, Field field, N min, N max) {
        return ba(index, field.name(), min, max);
    }

    /**
     * between and.
     *
     * @param <N>            number type
     * @param index          the index
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L ba(int index, Field field, N min, N max, BiPredicate<N, N> ignoreStrategy) {
        return ba(index, field.name(), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param <D>   date type
     * @param index the index
     * @param field the field
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    default <D extends Date> L ba(int index, Field field, D min, D max) {
        return ba(index, field.name(), min, max);
    }

    /**
     * between and.
     *
     * @param <D>            date type
     * @param index          the index
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L ba(int index, Field field, D min, D max, BiPredicate<D, D> ignoreStrategy) {
        return ba(index, field.name(), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param <E>   the enum type
     * @param index the index
     * @param field the field
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    default <E extends Enum<E>> L ba(int index, Field field, E min, E max) {
        return ba(index, field.name(), min, max);
    }

    /**
     * between and.
     *
     * @param <E>            the enum type
     * @param index          the index
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E extends Enum<E>> L ba(int index, Field field, E min, E max, BiPredicate<E, E> ignoreStrategy) {
        return ba(index, field.name(), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param index the index
     * @param field the field
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    default L ba(int index, Field field, LocalTime min, LocalTime max) {
        return ba(index, field.name(), min, max);
    }

    /**
     * between and.
     *
     * @param index          the index
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ba(int index, Field field, LocalTime min, LocalTime max,
            BiPredicate<LocalTime, LocalTime> ignoreStrategy) {
        return ba(index, field.name(), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param index the index
     * @param field the field
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    default L ba(int index, Field field, LocalDate min, LocalDate max) {
        return ba(index, field.name(), min, max);
    }

    /**
     * between and.
     *
     * @param index          the index
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ba(int index, Field field, LocalDate min, LocalDate max,
            BiPredicate<LocalDate, LocalDate> ignoreStrategy) {
        return ba(index, field.name(), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param index the index
     * @param field the field
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    default L ba(int index, Field field, LocalDateTime min, LocalDateTime max) {
        return ba(index, field.name(), min, max);
    }

    /**
     * between and.
     *
     * @param index          the index
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ba(int index, Field field, LocalDateTime min, LocalDateTime max,
            BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {
        return ba(index, field.name(), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param index the index
     * @param field the field
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    default L ba(int index, Field field, String min, String max) {
        return ba(index, field.name(), min, max);
    }

    /**
     * between and.
     *
     * @param index          the index
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ba(int index, Field field, String min, String max, BiPredicate<String, String> ignoreStrategy) {
        return ba(index, field.name(), min, max, ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * between and.
     *
     * @param index the index
     * @param field the field
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    default L ba(int index, AliasField field, int min, int max) {
        return ba(index, field.getAliasOrName(), min, max);
    }

    /**
     * between and.
     *
     * @param index          the index
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ba(int index, AliasField field, int min, int max, BiPredicate<Integer, Integer> ignoreStrategy) {
        return ba(index, field.getAliasOrName(), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param index the index
     * @param field the field
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    default L ba(int index, AliasField field, long min, long max) {
        return ba(index, field.getAliasOrName(), min, max);
    }

    /**
     * between and.
     *
     * @param index          the index
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ba(int index, AliasField field, long min, long max, BiPredicate<Long, Long> ignoreStrategy) {
        return ba(index, field.getAliasOrName(), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param index the index
     * @param field the field
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    default L ba(int index, AliasField field, double min, double max) {
        return ba(index, field.getAliasOrName(), min, max);
    }

    /**
     * between and.
     *
     * @param index          the index
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ba(int index, AliasField field, double min, double max, BiPredicate<Double, Double> ignoreStrategy) {
        return ba(index, field.getAliasOrName(), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param <N>   number type
     * @param index the index
     * @param field the field
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    default <N extends Number> L ba(int index, AliasField field, N min, N max) {
        return ba(index, field.getAliasOrName(), min, max);
    }

    /**
     * between and.
     *
     * @param <N>            number type
     * @param index          the index
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L ba(int index, AliasField field, N min, N max, BiPredicate<N, N> ignoreStrategy) {
        return ba(index, field.getAliasOrName(), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param <D>   date type
     * @param index the index
     * @param field the field
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    default <D extends Date> L ba(int index, AliasField field, D min, D max) {
        return ba(index, field.getAliasOrName(), min, max);
    }

    /**
     * between and.
     *
     * @param <D>            date type
     * @param index          the index
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L ba(int index, AliasField field, D min, D max, BiPredicate<D, D> ignoreStrategy) {
        return ba(index, field.getAliasOrName(), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param <E>   the enum type
     * @param index the index
     * @param field the field
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    default <E extends Enum<E>> L ba(int index, AliasField field, E min, E max) {
        return ba(index, field.getAliasOrName(), min, max);
    }

    /**
     * between and.
     *
     * @param <E>            the enum type
     * @param index          the index
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E extends Enum<E>> L ba(int index, AliasField field, E min, E max, BiPredicate<E, E> ignoreStrategy) {
        return ba(index, field.getAliasOrName(), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param index the index
     * @param field the field
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    default L ba(int index, AliasField field, LocalTime min, LocalTime max) {
        return ba(index, field.getAliasOrName(), min, max);
    }

    /**
     * between and.
     *
     * @param index          the index
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ba(int index, AliasField field, LocalTime min, LocalTime max,
            BiPredicate<LocalTime, LocalTime> ignoreStrategy) {
        return ba(index, field.getAliasOrName(), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param index the index
     * @param field the field
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    default L ba(int index, AliasField field, LocalDate min, LocalDate max) {
        return ba(index, field.getAliasOrName(), min, max);
    }

    /**
     * between and.
     *
     * @param index          the index
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ba(int index, AliasField field, LocalDate min, LocalDate max,
            BiPredicate<LocalDate, LocalDate> ignoreStrategy) {
        return ba(index, field.getAliasOrName(), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param index the index
     * @param field the field
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    default L ba(int index, AliasField field, LocalDateTime min, LocalDateTime max) {
        return ba(index, field.getAliasOrName(), min, max);
    }

    /**
     * between and.
     *
     * @param index          the index
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ba(int index, AliasField field, LocalDateTime min, LocalDateTime max,
            BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {
        return ba(index, field.getAliasOrName(), min, max, ignoreStrategy);
    }

    /**
     * between and.
     *
     * @param index the index
     * @param field the field
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    default L ba(int index, AliasField field, String min, String max) {
        return ba(index, field.getAliasOrName(), min, max);
    }

    /**
     * between and.
     *
     * @param index          the index
     * @param field          the field
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ba(int index, AliasField field, String min, String max, BiPredicate<String, String> ignoreStrategy) {
        return ba(index, field.getAliasOrName(), min, max, ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * between and.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  the name
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    <E> L ba(int index, SerializableToIntFunction<E> name, int min, int max);

    /**
     * between and.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L ba(int index, SerializableToIntFunction<E> name, int min, int max,
            BiPredicate<Integer, Integer> ignoreStrategy);

    /**
     * between and.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  the name
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    <E> L ba(int index, SerializableToLongFunction<E> name, long min, long max);

    /**
     * between and.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L ba(int index, SerializableToLongFunction<E> name, long min, long max, BiPredicate<Long, Long> ignoreStrategy);

    /**
     * between and.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  the name
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    <E> L ba(int index, SerializableToDoubleFunction<E> name, double min, double max);

    /**
     * between and.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L ba(int index, SerializableToDoubleFunction<E> name, double min, double max,
            BiPredicate<Double, Double> ignoreStrategy);

    /**
     * between and.
     *
     * @param <E>   the element type
     * @param <N>   number type
     * @param index the index
     * @param name  the name
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    <E, N extends Number> L ba(int index, SerializableToNumberFunction<E, N> name, N min, N max);

    /**
     * between and.
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
    <E, N extends Number> L ba(int index, SerializableToNumberFunction<E, N> name, N min, N max,
            BiPredicate<N, N> ignoreStrategy);

    /**
     * between and.
     *
     * @param <E>   the element type
     * @param <D>   date type
     * @param index the index
     * @param name  the name
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    <E, D extends Date> L ba(int index, SerializableToDateFunction<E, D> name, D min, D max);

    /**
     * between and.
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
    <E, D extends Date> L ba(int index, SerializableToDateFunction<E, D> name, D min, D max,
            BiPredicate<D, D> ignoreStrategy);

    /**
     * between and.
     *
     * @param <T>   the generic type
     * @param <E>   the enum type
     * @param index the index
     * @param name  the name
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    <T, E extends Enum<E>> L ba(int index, SerializableToEnumFunction<T, E> name, E min, E max);

    /**
     * between and.
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
    <T, E extends Enum<E>> L ba(int index, SerializableToEnumFunction<T, E> name, E min, E max,
            BiPredicate<E, E> ignoreStrategy);

    /**
     * between and.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  the name
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    <E> L ba(int index, SerializableToLocalTimeFunction<E> name, LocalTime min, LocalTime max);

    /**
     * between and.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L ba(int index, SerializableToLocalTimeFunction<E> name, LocalTime min, LocalTime max,
            BiPredicate<LocalTime, LocalTime> ignoreStrategy);

    /**
     * between and.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  the name
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    <E> L ba(int index, SerializableToLocalDateFunction<E> name, LocalDate min, LocalDate max);

    /**
     * between and.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L ba(int index, SerializableToLocalDateFunction<E> name, LocalDate min, LocalDate max,
            BiPredicate<LocalDate, LocalDate> ignoreStrategy);

    /**
     * between and.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  the name
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    <E> L ba(int index, SerializableToLocalDateTimeFunction<E> name, LocalDateTime min, LocalDateTime max);

    /**
     * between and.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L ba(int index, SerializableToLocalDateTimeFunction<E> name, LocalDateTime min, LocalDateTime max,
            BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy);

    /**
     * between and.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  the name
     * @param min   the min
     * @param max   the max
     * @return LogicExpression
     */
    <E> L ba(int index, SerializableToStringFunction<E> name, String min, String max);

    /**
     * between and.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L ba(int index, SerializableToStringFunction<E> name, String min, String max,
            BiPredicate<String, String> ignoreStrategy);
}