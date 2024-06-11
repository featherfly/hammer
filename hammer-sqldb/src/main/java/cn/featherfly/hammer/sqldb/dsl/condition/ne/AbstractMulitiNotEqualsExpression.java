
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-16 16:52:16
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.dsl.condition.ne;

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
import cn.featherfly.hammer.expression.condition.ne.MulitiNotEqualsExpression;
import cn.featherfly.hammer.sqldb.dsl.condition.AbstractInternalMulitiConditionHolder;
import cn.featherfly.hammer.sqldb.dsl.condition.InternalMulitiCondition;

/**
 * abstract muliti not equals expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public abstract class AbstractMulitiNotEqualsExpression<I extends InternalMulitiCondition<L>,
    C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends AbstractInternalMulitiConditionHolder<I, C, L> implements MulitiNotEqualsExpression<C, L> {

    /**
     * Instantiates a new muliti not equals expression impl.
     *
     * @param internalMulitiCondition the internal muliti condition
     */
    protected AbstractMulitiNotEqualsExpression(I internalMulitiCondition) {
        super(internalMulitiCondition);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E, R> L ne(int index, SerializableFunction<E, R> name, R value, MatchStrategy matchStrategy,
        Predicate<R> ignoreStrategy) {
        return hold.ne(new AtomicInteger(index), name, value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(int index, SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return hold.ne(new AtomicInteger(index), property, value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L ne(int index, SerializableToIntFunction<T> name, int value, IntPredicate ignoreStrategy) {
        return hold.ne(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L ne(int index, SerializableToLongFunction<T> name, long value, LongPredicate ignoreStrategy) {
        return hold.ne(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L ne(int index, SerializableToDoubleFunction<T> name, double value, DoublePredicate ignoreStrategy) {
        return hold.ne(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, N extends Number> L ne(int index, SerializableToNumberFunction<T, N> name, N value,
        Predicate<N> ignoreStrategy) {
        return hold.ne(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, E extends Enum<E>> L ne(int index, SerializableToEnumFunction<T, E> name, E value,
        Predicate<E> ignoreStrategy) {
        return hold.ne(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, D extends Date> L ne(int index, SerializableToDateFunction<T, D> name, D value,
        Predicate<D> ignoreStrategy) {
        return hold.ne(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L ne(int index, SerializableToLocalTimeFunction<T> name, LocalTime value,
        Predicate<LocalTime> ignoreStrategy) {
        return hold.ne(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L ne(int index, SerializableToLocalDateFunction<T> name, LocalDate value,
        Predicate<LocalDate> ignoreStrategy) {
        return hold.ne(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L ne(int index, SerializableToLocalDateTimeFunction<T> name, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return hold.ne(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L ne(int index, SerializableToStringFunction<T> name, String value, Predicate<String> ignoreStrategy) {
        return hold.ne(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L ne(int index, SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return hold.ne(new AtomicInteger(index), name, value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ne(int index, SerializableSupplier<R> property, R value, Predicate<R> ignoreStrategy) {
        return hold.ne(new AtomicInteger(index), property, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(int index, SerializableIntSupplier property, int value, IntPredicate ignoreStrategy) {
        return hold.ne(new AtomicInteger(index), property, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(int index, SerializableLongSupplier property, long value, LongPredicate ignoreStrategy) {
        return hold.ne(new AtomicInteger(index), property, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(int index, SerializableDoubleSupplier property, double value, DoublePredicate ignoreStrategy) {
        return hold.ne(new AtomicInteger(index), property, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ne(int index, SerializableDateSupplier<D> property, D value,
        Predicate<D> ignoreStrategy) {
        return hold.ne(new AtomicInteger(index), property, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ne(int index, SerializableNumberSupplier<N> property, N value,
        Predicate<N> ignoreStrategy) {
        return hold.ne(new AtomicInteger(index), property, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L ne(int index, SerializableEnumSupplier<E> property, E value,
        Predicate<E> ignoreStrategy) {
        return hold.ne(new AtomicInteger(index), property, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(int index, SerializableLocalDateSupplier property, LocalDate value,
        Predicate<LocalDate> ignoreStrategy) {
        return hold.ne(new AtomicInteger(index), property, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(int index, SerializableLocalTimeSupplier property, LocalTime value,
        Predicate<LocalTime> ignoreStrategy) {
        return hold.ne(new AtomicInteger(index), property, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(int index, SerializableLocalDateTimeSupplier property, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return hold.ne(new AtomicInteger(index), property, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(int index, SerializableStringSupplier property, String value, Predicate<String> ignoreStrategy) {
        return hold.ne(new AtomicInteger(index), property, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(int index, SerializableLocalTimeSupplier property, LocalTime value) {
        return hold.ne(new AtomicInteger(index), property, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(int index, SerializableLocalDateTimeSupplier property, LocalDateTime value) {
        return hold.ne(new AtomicInteger(index), property, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(int index, SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return hold.ne(new AtomicInteger(index), property, value, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ne(int index, SerializableSupplier<R> property, R value) {
        return hold.ne(new AtomicInteger(index), property, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(int index, SerializableIntSupplier property, int value) {
        return hold.ne(new AtomicInteger(index), property, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(int index, SerializableLongSupplier property, long value) {
        return hold.ne(new AtomicInteger(index), property, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(int index, SerializableDoubleSupplier property, double value) {
        return hold.ne(new AtomicInteger(index), property, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ne(int index, SerializableDateSupplier<D> property, D value) {
        return hold.ne(new AtomicInteger(index), property, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ne(int index, SerializableNumberSupplier<N> property, N value) {
        return hold.ne(new AtomicInteger(index), property, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L ne(int index, SerializableEnumSupplier<E> property, E value) {
        return hold.ne(new AtomicInteger(index), property, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(int index, SerializableLocalDateSupplier property, LocalDate value) {
        return hold.ne(new AtomicInteger(index), property, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(int index, String name, int value, IntPredicate ignoreStrategy) {
        return hold.ne(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(int index, String name, long value, LongPredicate ignoreStrategy) {
        return hold.ne(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(int index, String name, double value, DoublePredicate ignoreStrategy) {
        return hold.ne(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ne(int index, String name, N value, Predicate<N> ignoreStrategy) {
        return hold.ne(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L ne(int index, String name, E value, Predicate<E> ignoreStrategy) {
        return hold.ne(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ne(int index, String name, D value, Predicate<D> ignoreStrategy) {
        return hold.ne(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(int index, String name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return hold.ne(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(int index, String name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return hold.ne(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(int index, String name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return hold.ne(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(int index, String name, String value, Predicate<String> ignoreStrategy) {
        return hold.ne(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(int index, String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return hold.ne(new AtomicInteger(index), name, value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ne(int index, String name, R value, MatchStrategy matchStrategy, Predicate<R> ignoreStrategy) {
        return hold.ne(new AtomicInteger(index), name, value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ne(int index, String name, R value, MatchStrategy matchStrategy) {
        return hold.ne(new AtomicInteger(index), name, value, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(int index, String name, int value) {
        return hold.ne(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(int index, String name, long value) {
        return hold.ne(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(int index, String name, double value) {
        return hold.ne(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ne(int index, String name, N value) {
        return hold.ne(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L ne(int index, String name, E value) {
        return hold.ne(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ne(int index, String name, D value) {
        return hold.ne(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(int index, String name, LocalTime value) {
        return hold.ne(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(int index, String name, LocalDate value) {
        return hold.ne(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(int index, String name, LocalDateTime value) {
        return hold.ne(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(int index, String name, String value) {
        return hold.ne(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(int index, String name, String value, MatchStrategy matchStrategy) {
        return hold.ne(new AtomicInteger(index), name, value, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> L ne(int index, SerializableFunction<T, R> name, R value) {
        return hold.ne(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> L ne(int index, SerializableFunction<T, R> name, R value, MatchStrategy matchStrategy) {
        return hold.ne(new AtomicInteger(index), name, value, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L ne(int index, SerializableToIntFunction<T> name, int value) {
        return hold.ne(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L ne(int index, SerializableToLongFunction<T> name, long value) {
        return hold.ne(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L ne(int index, SerializableToDoubleFunction<T> name, double value) {
        return hold.ne(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, N extends Number> L ne(int index, SerializableToNumberFunction<T, N> name, N value) {
        return hold.ne(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, E extends Enum<E>> L ne(int index, SerializableToEnumFunction<T, E> name, E value) {
        return hold.ne(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, D extends Date> L ne(int index, SerializableToDateFunction<T, D> name, D value) {
        return hold.ne(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L ne(int index, SerializableToLocalTimeFunction<T> name, LocalTime value) {
        return hold.ne(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L ne(int index, SerializableToLocalDateFunction<T> name, LocalDate value) {
        return hold.ne(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L ne(int index, SerializableToLocalDateTimeFunction<T> name, LocalDateTime value) {
        return hold.ne(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L ne(int index, SerializableToStringFunction<T> name, String value) {
        return hold.ne(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L ne(int index, SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy) {
        return hold.ne(new AtomicInteger(index), name, value, matchStrategy, getIgnoreStrategy());
    }
}
