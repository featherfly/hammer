
package cn.featherfly.hammer.expression.condition.in;

import java.util.Collection;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableDoubleSupplier;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableIntSupplier;
import cn.featherfly.common.function.serializable.SerializableLongSupplier;
import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.function.serializable.SerializableToDoubleFunction;
import cn.featherfly.common.function.serializable.SerializableToIntFunction;
import cn.featherfly.common.function.serializable.SerializableToLongFunction;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.AliasField;
import cn.featherfly.common.repository.Field;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * mntity in expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface MulitiInExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>   the generic type
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <R> L in(int index, String name, R value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L in(int index, String name, R value, Predicate<R> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L in(int index, String name, int value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in(int index, String name, int value, IntPredicate ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L in(int index, String name, long value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in(int index, String name, long value, LongPredicate ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L in(int index, String name, double value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in(int index, String name, double value, DoublePredicate ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>   the generic type
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <R> L in(int index, String name, @SuppressWarnings("unchecked") R... value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L in(int index, String name, int... value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L in(int index, String name, long... value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L in(int index, String name, double... value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L in(int index, String name, R[] value, Predicate<R[]> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in(int index, String name, int[] value, Predicate<int[]> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in(int index, String name, long[] value, Predicate<long[]> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in(int index, String name, double[] value, Predicate<double[]> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param index         the index
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L in(int index, String name, String value, MatchStrategy matchStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in(int index, String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param index         the index
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L in(int index, String name, String[] value, MatchStrategy matchStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in(int index, String name, String[] value, MatchStrategy matchStrategy, Predicate<String[]> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>   the generic type
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <R> L in(int index, String name, Collection<R> value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L in(int index, String name, Collection<R> value, Predicate<Collection<R>> ignoreStrategy);

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <E>   the element type
     * @param <R>   the generic type
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <E, R> L in(int index, SerializableFunction<E, R> name, R value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <E>            the element type
     * @param <R>            the generic type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E, R> L in(int index, SerializableFunction<E, R> name, R value, Predicate<R> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <E> L in(int index, SerializableToIntFunction<E> name, int value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L in(int index, SerializableToIntFunction<E> name, int value, IntPredicate ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <E> L in(int index, SerializableToLongFunction<E> name, long value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L in(int index, SerializableToLongFunction<E> name, long value, LongPredicate ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <E> L in(int index, SerializableToDoubleFunction<E> name, double value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L in(int index, SerializableToDoubleFunction<E> name, double value, DoublePredicate ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <E>   the element type
     * @param <R>   the generic type
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <E, R> L in(int index, SerializableFunction<E, R> name, @SuppressWarnings("unchecked") R... value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <E> L in(int index, SerializableToIntFunction<E> name, int... value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <E> L in(int index, SerializableToLongFunction<E> name, long... value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <E> L in(int index, SerializableToDoubleFunction<E> name, double... value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <E>            the element type
     * @param <R>            the generic type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E, R> L in(int index, SerializableFunction<E, R> name, R[] value, Predicate<R[]> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L in(int index, SerializableToIntFunction<E> name, int[] value, Predicate<int[]> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L in(int index, SerializableToLongFunction<E> name, long[] value, Predicate<long[]> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L in(int index, SerializableToDoubleFunction<E> name, double[] value, Predicate<double[]> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <E>           the element type
     * @param index         the index
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    <E> L in(int index, SerializableToStringFunction<E> name, String value, MatchStrategy matchStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L in(int index, SerializableToStringFunction<E> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <E>           the element type
     * @param index         the index
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    <E> L in(int index, SerializableToStringFunction<E> name, String[] value, MatchStrategy matchStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L in(int index, SerializableToStringFunction<E> name, String[] value, MatchStrategy matchStrategy,
            Predicate<String[]> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <E>   the element type
     * @param <R>   the generic type
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <E, R> L in(int index, SerializableFunction<E, R> name, Collection<R> value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <E>            the element type
     * @param <R>            the generic type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E, R> L in(int index, SerializableFunction<E, R> name, Collection<R> value,
            Predicate<Collection<R>> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>      the generic type
     * @param index    the index
     * @param property bean property
     * @return LogicExpression
     */
    <R> L in(int index, SerializableSupplier<R> property);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L in(int index, SerializableSupplier<R> property, Predicate<R> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param index    the index
     * @param property bean property
     * @return LogicExpression
     */
    L in(int index, SerializableIntSupplier property);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param index          the index
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in(int index, SerializableIntSupplier property, IntPredicate ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param index    the index
     * @param property bean property
     * @return LogicExpression
     */
    L in(int index, SerializableLongSupplier property);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param index          the index
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in(int index, SerializableLongSupplier property, LongPredicate ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param index    the index
     * @param property bean property
     * @return LogicExpression
     */
    L in(int index, SerializableDoubleSupplier property);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param index          the index
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in(int index, SerializableDoubleSupplier property, DoublePredicate ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param index         the index
     * @param property      bean property
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L in(int index, SerializableStringSupplier property, MatchStrategy matchStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param index          the index
     * @param property       bean property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in(int index, SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>   the generic type
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <R> L in(int index, Field field, R value) {
        return in(index, field.name(), value);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R> L in(int index, Field field, R value, Predicate<R> ignoreStrategy) {
        return in(index, field.name(), value, ignoreStrategy);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L in(int index, Field field, int value) {
        return in(index, field.name(), value);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L in(int index, Field field, int value, IntPredicate ignoreStrategy) {
        return in(index, field.name(), value, ignoreStrategy);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L in(int index, Field field, long value) {
        return in(index, field.name(), value);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L in(int index, Field field, long value, LongPredicate ignoreStrategy) {
        return in(index, field.name(), value, ignoreStrategy);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L in(int index, Field field, double value) {
        return in(index, field.name(), value);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L in(int index, Field field, double value, DoublePredicate ignoreStrategy) {
        return in(index, field.name(), value, ignoreStrategy);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>   the generic type
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <R> L in(int index, Field field, @SuppressWarnings("unchecked") R... value) {
        return in(index, field.name(), value);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L in(int index, Field field, int... value) {
        return in(index, field.name(), value);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L in(int index, Field field, long... value) {
        return in(index, field.name(), value);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L in(int index, Field field, double... value) {
        return in(index, field.name(), value);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R> L in(int index, Field field, R[] value, Predicate<R[]> ignoreStrategy) {
        return in(index, field.name(), value, ignoreStrategy);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L in(int index, Field field, int[] value, Predicate<int[]> ignoreStrategy) {
        return in(index, field.name(), value, ignoreStrategy);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L in(int index, Field field, long[] value, Predicate<long[]> ignoreStrategy) {
        return in(index, field.name(), value, ignoreStrategy);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L in(int index, Field field, double[] value, Predicate<double[]> ignoreStrategy) {
        return in(index, field.name(), value, ignoreStrategy);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param index         the index
     * @param field         the field
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L in(int index, Field field, String value, MatchStrategy matchStrategy) {
        return in(index, field.name(), value, matchStrategy);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L in(int index, Field field, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return in(index, field.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param index         the index
     * @param field         the field
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L in(int index, Field field, String[] value, MatchStrategy matchStrategy) {
        return in(index, field.name(), value, matchStrategy);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L in(int index, Field field, String[] value, MatchStrategy matchStrategy,
            Predicate<String[]> ignoreStrategy) {
        return in(index, field.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>   the generic type
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <R> L in(int index, Field field, Collection<R> value) {
        return in(index, field.name(), value);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R> L in(int index, Field field, Collection<R> value, Predicate<Collection<R>> ignoreStrategy) {
        return in(index, field.name(), value, ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>   the generic type
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <R> L in(int index, AliasField field, R value) {
        return in(index, field.getAliasOrName(), value);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R> L in(int index, AliasField field, R value, Predicate<R> ignoreStrategy) {
        return in(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L in(int index, AliasField field, int value) {
        return in(index, field.getAliasOrName(), value);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L in(int index, AliasField field, int value, IntPredicate ignoreStrategy) {
        return in(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L in(int index, AliasField field, long value) {
        return in(index, field.getAliasOrName(), value);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L in(int index, AliasField field, long value, LongPredicate ignoreStrategy) {
        return in(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L in(int index, AliasField field, double value) {
        return in(index, field.getAliasOrName(), value);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L in(int index, AliasField field, double value, DoublePredicate ignoreStrategy) {
        return in(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>   the generic type
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <R> L in(int index, AliasField field, @SuppressWarnings("unchecked") R... value) {
        return in(index, field.getAliasOrName(), value);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L in(int index, AliasField field, int... value) {
        return in(index, field.getAliasOrName(), value);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L in(int index, AliasField field, long... value) {
        return in(index, field.getAliasOrName(), value);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L in(int index, AliasField field, double... value) {
        return in(index, field.getAliasOrName(), value);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R> L in(int index, AliasField field, R[] value, Predicate<R[]> ignoreStrategy) {
        return in(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L in(int index, AliasField field, int[] value, Predicate<int[]> ignoreStrategy) {
        return in(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L in(int index, AliasField field, long[] value, Predicate<long[]> ignoreStrategy) {
        return in(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L in(int index, AliasField field, double[] value, Predicate<double[]> ignoreStrategy) {
        return in(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param index         the index
     * @param field         the field
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L in(int index, AliasField field, String value, MatchStrategy matchStrategy) {
        return in(index, field.getAliasOrName(), value, matchStrategy);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L in(int index, AliasField field, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        return in(index, field.getAliasOrName(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param index         the index
     * @param field         the field
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L in(int index, AliasField field, String[] value, MatchStrategy matchStrategy) {
        return in(index, field.getAliasOrName(), value, matchStrategy);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L in(int index, AliasField field, String[] value, MatchStrategy matchStrategy,
            Predicate<String[]> ignoreStrategy) {
        return in(index, field.getAliasOrName(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>   the generic type
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <R> L in(int index, AliasField field, Collection<R> value) {
        return in(index, field.getAliasOrName(), value);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R> L in(int index, AliasField field, Collection<R> value, Predicate<Collection<R>> ignoreStrategy) {
        return in(index, field.getAliasOrName(), value, ignoreStrategy);
    }

}