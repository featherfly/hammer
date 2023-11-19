/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-15 17:35:15
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.condition.eq;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
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
import cn.featherfly.common.function.serializable.SerializableSupplier;
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
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.eq.MulitiEqualsExpression;
import cn.featherfly.hammer.sqldb.jdbc.dsl.condition.AbstractInternalMulitiConditionHolder;
import cn.featherfly.hammer.sqldb.jdbc.dsl.condition.InternalMulitiCondition;

/**
 * abstract muliti equals expression.
 *
 * @author zhongj
 * @param <I> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public abstract class AbstractMulitiEqualsExpression<I extends InternalMulitiCondition<L>,
        C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends AbstractInternalMulitiConditionHolder<I, C, L> implements MulitiEqualsExpression<C, L> {

    /**
     * Instantiates a new muliti equals expression impl.
     *
     * @param internalMulitiCondition the internal muliti condition
     */
    protected AbstractMulitiEqualsExpression(I internalMulitiCondition) {
        super(internalMulitiCondition);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E, R> L eq(int index, SerializableFunction<E, R> name, R value, MatchStrategy matchStrategy,
            Predicate<R> ignoreStrategy) {
        return hold.eq(new AtomicInteger(index), name, value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(int index, SerializableStringSupplier property, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        return hold.eq(new AtomicInteger(index), property, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L eq(int index, SerializableToIntFunction<T> name, int value, IntPredicate ignoreStrategy) {
        return hold.eq(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L eq(int index, SerializableToLongFunction<T> name, long value, LongPredicate ignoreStrategy) {
        return hold.eq(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L eq(int index, SerializableToDoubleFunction<T> name, double value, DoublePredicate ignoreStrategy) {
        return hold.eq(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, N extends Number> L eq(int index, SerializableToNumberFunction<T, N> name, N value,
            Predicate<N> ignoreStrategy) {
        return hold.eq(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, E extends Enum<E>> L eq(int index, SerializableToEnumFunction<T, E> name, E value,
            Predicate<E> ignoreStrategy) {
        return hold.eq(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, D extends Date> L eq(int index, SerializableToDateFunction<T, D> name, D value,
            Predicate<D> ignoreStrategy) {
        return hold.eq(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L eq(int index, SerializableToLocalTimeFunction<T> name, LocalTime value,
            Predicate<LocalTime> ignoreStrategy) {
        return hold.eq(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L eq(int index, SerializableToLocalDateFunction<T> name, LocalDate value,
            Predicate<LocalDate> ignoreStrategy) {
        return hold.eq(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L eq(int index, SerializableToLocalDateTimeFunction<T> name, LocalDateTime value,
            Predicate<LocalDateTime> ignoreStrategy) {
        return hold.eq(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L eq(int index, SerializableToStringFunction<T> name, String value, Predicate<String> ignoreStrategy) {
        return hold.eq(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L eq(int index, SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        return hold.eq(new AtomicInteger(index), name, value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L eq(int index, SerializableSupplier<R> property, Predicate<R> ignoreStrategy) {
        return hold.eq(new AtomicInteger(index), property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(int index, SerializableIntSupplier property, IntPredicate ignoreStrategy) {
        return hold.eq(new AtomicInteger(index), property, property.getAsInt(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(int index, SerializableLongSupplier property, LongPredicate ignoreStrategy) {
        return hold.eq(new AtomicInteger(index), property, property.getAsLong(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(int index, SerializableDoubleSupplier property, DoublePredicate ignoreStrategy) {
        return hold.eq(new AtomicInteger(index), property, property.getAsDouble(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L eq(int index, SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy) {
        return hold.eq(new AtomicInteger(index), property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L eq(int index, SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy) {
        return hold.eq(new AtomicInteger(index), property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L eq(int index, SerializableEnumSupplier<E> property, Predicate<E> ignoreStrategy) {
        return hold.eq(new AtomicInteger(index), property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(int index, SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return hold.eq(new AtomicInteger(index), property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(int index, SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return hold.eq(new AtomicInteger(index), property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(int index, SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return hold.eq(new AtomicInteger(index), property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(int index, SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return hold.eq(new AtomicInteger(index), property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(int index, String name, int value, IntPredicate ignoreStrategy) {
        return hold.eq(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(int index, String name, long value, LongPredicate ignoreStrategy) {
        return hold.eq(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(int index, String name, double value, DoublePredicate ignoreStrategy) {
        return hold.eq(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L eq(int index, String name, N value, Predicate<N> ignoreStrategy) {
        return hold.eq(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L eq(int index, String name, E value, Predicate<E> ignoreStrategy) {
        return hold.eq(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L eq(int index, String name, D value, Predicate<D> ignoreStrategy) {
        return hold.eq(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(int index, String name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return hold.eq(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(int index, String name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return hold.eq(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(int index, String name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return hold.eq(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(int index, String name, String value, Predicate<String> ignoreStrategy) {
        return hold.eq(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(int index, String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return hold.eq(new AtomicInteger(index), name, value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L eq(int index, String name, R value, MatchStrategy matchStrategy, Predicate<R> ignoreStrategy) {
        return hold.eq(new AtomicInteger(index), name, value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(int index, SerializableLocalTimeSupplier property) {
        return hold.eq(new AtomicInteger(index), property, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(int index, SerializableLocalDateTimeSupplier property) {
        return hold.eq(new AtomicInteger(index), property, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(int index, SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return hold.eq(new AtomicInteger(index), property, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L eq(int index, String name, R value, MatchStrategy matchStrategy) {
        return hold.eq(new AtomicInteger(index), name, value, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(int index, String name, int value) {
        return hold.eq(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(int index, String name, long value) {
        return hold.eq(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(int index, String name, double value) {
        return hold.eq(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L eq(int index, String name, N value) {
        return hold.eq(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L eq(int index, String name, E value) {
        return hold.eq(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L eq(int index, String name, D value) {
        return hold.eq(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(int index, String name, LocalTime value) {
        return hold.eq(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(int index, String name, LocalDate value) {
        return hold.eq(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(int index, String name, LocalDateTime value) {
        return hold.eq(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(int index, String name, String value) {
        return hold.eq(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(int index, String name, String value, MatchStrategy matchStrategy) {
        return hold.eq(new AtomicInteger(index), name, value, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> L eq(int index, SerializableFunction<T, R> name, R value) {
        return hold.eq(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> L eq(int index, SerializableFunction<T, R> name, R value, MatchStrategy matchStrategy) {
        return hold.eq(new AtomicInteger(index), name, value, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L eq(int index, SerializableToIntFunction<T> name, int value) {
        return hold.eq(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L eq(int index, SerializableToLongFunction<T> name, long value) {
        return hold.eq(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L eq(int index, SerializableToDoubleFunction<T> name, double value) {
        return hold.eq(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, N extends Number> L eq(int index, SerializableToNumberFunction<T, N> name, N value) {
        return hold.eq(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, E extends Enum<E>> L eq(int index, SerializableToEnumFunction<T, E> name, E value) {
        return hold.eq(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, D extends Date> L eq(int index, SerializableToDateFunction<T, D> name, D value) {
        return hold.eq(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L eq(int index, SerializableToLocalTimeFunction<T> name, LocalTime value) {
        return hold.eq(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L eq(int index, SerializableToLocalDateFunction<T> name, LocalDate value) {
        return hold.eq(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L eq(int index, SerializableToLocalDateTimeFunction<T> name, LocalDateTime value) {
        return hold.eq(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L eq(int index, SerializableToStringFunction<T> name, String value) {
        return hold.eq(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L eq(int index, SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy) {
        return hold.eq(new AtomicInteger(index), name, value, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L eq(int index, SerializableSupplier<R> property) {
        return hold.eq(new AtomicInteger(index), property, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(int index, SerializableIntSupplier property) {
        return hold.eq(new AtomicInteger(index), property, property.getAsInt(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(int index, SerializableLongSupplier property) {
        return hold.eq(new AtomicInteger(index), property, property.getAsLong(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(int index, SerializableDoubleSupplier property) {
        return hold.eq(new AtomicInteger(index), property, property.getAsDouble(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L eq(int index, SerializableDateSupplier<D> property) {
        return hold.eq(new AtomicInteger(index), property, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L eq(int index, SerializableNumberSupplier<N> property) {
        return hold.eq(new AtomicInteger(index), property, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L eq(int index, SerializableEnumSupplier<E> property) {
        return hold.eq(new AtomicInteger(index), property, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(int index, SerializableLocalDateSupplier property) {
        return hold.eq(new AtomicInteger(index), property, getIgnoreStrategy());
    }

}
