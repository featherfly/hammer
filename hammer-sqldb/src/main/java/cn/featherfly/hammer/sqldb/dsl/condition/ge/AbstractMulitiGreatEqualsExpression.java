
package cn.featherfly.hammer.sqldb.dsl.condition.ge;

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
import cn.featherfly.common.function.serializable.SerializableToDoubleFunction;
import cn.featherfly.common.function.serializable.SerializableToIntFunction;
import cn.featherfly.common.function.serializable.SerializableToLongFunction;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.ge.MulitiGreatEqualsExpression;
import cn.featherfly.hammer.sqldb.dsl.condition.AbstractInternalMulitiConditionHolder;
import cn.featherfly.hammer.sqldb.dsl.condition.InternalMulitiCondition;

/**
 * abstract muliti great equals expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public abstract class AbstractMulitiGreatEqualsExpression<I extends InternalMulitiCondition<L>,
        C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends AbstractInternalMulitiConditionHolder<I, C, L> implements MulitiGreatEqualsExpression<C, L> {

    /**
     * Instantiates a new muliti great equals expression impl.
     *
     * @param internalMulitiCondition the internal muliti condition
     */
    protected AbstractMulitiGreatEqualsExpression(I internalMulitiCondition) {
        super(internalMulitiCondition);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L ge(int index, SerializableToIntFunction<E> name, int value) {
        return hold.ge(new AtomicInteger(index), name, value, (IntPredicate) getIgnoreStrategy()::test);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L ge(int index, SerializableToIntFunction<E> name, int value, IntPredicate ignoreStrategy) {
        return hold.ge(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L ge(int index, SerializableToLongFunction<E> name, long value) {
        return hold.ge(new AtomicInteger(index), name, value, (LongPredicate) getIgnoreStrategy()::test);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L ge(int index, SerializableToLongFunction<E> name, long value, LongPredicate ignoreStrategy) {
        return hold.ge(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L ge(int index, SerializableToDoubleFunction<E> name, double value) {
        return hold.ge(new AtomicInteger(index), name, value, (DoublePredicate) getIgnoreStrategy()::test);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L ge(int index, SerializableToDoubleFunction<E> name, double value, DoublePredicate ignoreStrategy) {
        return hold.ge(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E, N extends Number> L ge(int index, SerializableFunction<E, N> name, N value) {
        return hold.ge(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E, N extends Number> L ge(int index, SerializableFunction<E, N> name, N value,
            Predicate<N> ignoreStrategy) {
        return hold.ge(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E, D extends Date> L ge(int index, SerializableFunction<E, D> name, D value) {
        return hold.ge(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E, D extends Date> L ge(int index, SerializableFunction<E, D> name, D value, Predicate<D> ignoreStrategy) {
        return hold.ge(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L ge(int index, SerializableFunction<E, LocalTime> name, LocalTime value) {
        return hold.ge(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L ge(int index, SerializableFunction<E, LocalTime> name, LocalTime value,
            Predicate<LocalTime> ignoreStrategy) {
        return hold.ge(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L ge(int index, SerializableFunction<E, LocalDate> name, LocalDate value) {
        return hold.ge(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L ge(int index, SerializableFunction<E, LocalDate> name, LocalDate value,
            Predicate<LocalDate> ignoreStrategy) {
        return hold.ge(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L ge(int index, SerializableFunction<E, LocalDateTime> name, LocalDateTime value) {
        return hold.ge(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L ge(int index, SerializableFunction<E, LocalDateTime> name, LocalDateTime value,
            Predicate<LocalDateTime> ignoreStrategy) {
        return hold.ge(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L ge(int index, SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy) {
        return hold.ge(new AtomicInteger(index), name, value, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L ge(int index, SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        return hold.ge(new AtomicInteger(index), name, value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(int index, SerializableIntSupplier property) {
        return hold.ge(new AtomicInteger(index), property, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(int index, SerializableIntSupplier property, IntPredicate ignoreStrategy) {
        return hold.ge(new AtomicInteger(index), property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(int index, SerializableLongSupplier property) {
        return hold.ge(new AtomicInteger(index), property, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(int index, SerializableLongSupplier property, LongPredicate ignoreStrategy) {
        return hold.ge(new AtomicInteger(index), property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(int index, SerializableDoubleSupplier property) {
        return hold.ge(new AtomicInteger(index), property, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(int index, SerializableDoubleSupplier property, DoublePredicate ignoreStrategy) {
        return hold.ge(new AtomicInteger(index), property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L ge(int index, SerializableDateSupplier<R> property) {
        return hold.ge(new AtomicInteger(index), property, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L ge(int index, SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy) {
        return hold.ge(new AtomicInteger(index), property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L ge(int index, SerializableNumberSupplier<R> property) {
        return hold.ge(new AtomicInteger(index), property, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L ge(int index, SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy) {
        return hold.ge(new AtomicInteger(index), property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(int index, SerializableLocalDateSupplier property) {
        return hold.ge(new AtomicInteger(index), property, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(int index, SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return hold.ge(new AtomicInteger(index), property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(int index, SerializableLocalTimeSupplier property) {
        return hold.ge(new AtomicInteger(index), property, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(int index, SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return hold.ge(new AtomicInteger(index), property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(int index, SerializableLocalDateTimeSupplier property) {
        return hold.ge(new AtomicInteger(index), property, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(int index, SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return hold.ge(new AtomicInteger(index), property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(int index, SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return hold.ge(new AtomicInteger(index), property, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(int index, SerializableStringSupplier property, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        return hold.ge(new AtomicInteger(index), property, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, E extends Enum<E>> L ge(int index, SerializableFunction<T, E> name, E value) {
        return hold.ge(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, E extends Enum<E>> L ge(int index, SerializableFunction<T, E> name, E value,
            Predicate<E> ignoreStrategy) {
        return hold.ge(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L ge(int index, SerializableEnumSupplier<E> property) {
        return hold.ge(new AtomicInteger(index), property, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L ge(int index, SerializableEnumSupplier<E> property, Predicate<E> ignoreStrategy) {
        return hold.ge(new AtomicInteger(index), property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(int index, String name, int value) {
        return hold.ge(new AtomicInteger(index), name, value, (IntPredicate) getIgnoreStrategy()::test);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(int index, String name, int value, IntPredicate ignoreStrategy) {
        return hold.ge(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(int index, String name, long value) {
        return hold.ge(new AtomicInteger(index), name, value, (LongPredicate) getIgnoreStrategy()::test);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(int index, String name, long value, LongPredicate ignoreStrategy) {
        return hold.ge(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(int index, String name, double value) {
        return hold.ge(new AtomicInteger(index), name, value, (DoublePredicate) getIgnoreStrategy()::test);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(int index, String name, double value, DoublePredicate ignoreStrategy) {
        return hold.ge(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ge(int index, String name, N value) {
        return hold.ge(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L ge(int index, String name, N value, Predicate<N> ignoreStrategy) {
        return hold.ge(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L ge(int index, String name, E value) {
        return hold.ge(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L ge(int index, String name, E value, Predicate<E> ignoreStrategy) {
        return hold.ge(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ge(int index, String name, D value) {
        return hold.ge(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L ge(int index, String name, D value, Predicate<D> ignoreStrategy) {
        return hold.ge(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(int index, String name, LocalTime value) {
        return hold.ge(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(int index, String name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return hold.ge(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(int index, String name, LocalDate value) {
        return hold.ge(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(int index, String name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return hold.ge(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(int index, String name, LocalDateTime value) {
        return hold.ge(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(int index, String name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return hold.ge(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(int index, String name, String value, MatchStrategy mathMatchStrategy) {
        return hold.ge(new AtomicInteger(index), name, value, mathMatchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(int index, String name, String value, MatchStrategy mathMatchStrategy,
            Predicate<String> ignoreStrategy) {
        return hold.ge(new AtomicInteger(index), name, value, mathMatchStrategy, ignoreStrategy);
    }
}
