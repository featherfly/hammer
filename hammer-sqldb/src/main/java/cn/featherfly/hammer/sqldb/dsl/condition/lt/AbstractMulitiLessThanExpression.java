
package cn.featherfly.hammer.sqldb.dsl.condition.lt;

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
import cn.featherfly.hammer.expression.condition.lt.MulitiLessThanExpression;
import cn.featherfly.hammer.sqldb.dsl.condition.AbstractInternalMulitiConditionHolder;
import cn.featherfly.hammer.sqldb.dsl.condition.InternalMulitiCondition;

/**
 * abstract muliti less equals expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public abstract class AbstractMulitiLessThanExpression<I extends InternalMulitiCondition<L>,
    C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends AbstractInternalMulitiConditionHolder<I, C, L> implements MulitiLessThanExpression<C, L> {

    /**
     * Instantiates a new muliti less than expression impl.
     *
     * @param internalMulitiCondition the internal muliti condition
     */
    protected AbstractMulitiLessThanExpression(I internalMulitiCondition) {
        super(internalMulitiCondition);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L lt(int index, SerializableToIntFunction<E> name, int value) {
        return hold.lt(new AtomicInteger(index), name, value, (IntPredicate) getIgnoreStrategy()::test);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L lt(int index, SerializableToIntFunction<E> name, int value, IntPredicate ignoreStrategy) {
        return hold.lt(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L lt(int index, SerializableToLongFunction<E> name, long value) {
        return hold.lt(new AtomicInteger(index), name, value, (LongPredicate) getIgnoreStrategy()::test);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L lt(int index, SerializableToLongFunction<E> name, long value, LongPredicate ignoreStrategy) {
        return hold.lt(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L lt(int index, SerializableToDoubleFunction<E> name, double value) {
        return hold.lt(new AtomicInteger(index), name, value, (DoublePredicate) getIgnoreStrategy()::test);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L lt(int index, SerializableToDoubleFunction<E> name, double value, DoublePredicate ignoreStrategy) {
        return hold.lt(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E, N extends Number> L lt(int index, SerializableFunction<E, N> name, N value) {
        return hold.lt(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E, N extends Number> L lt(int index, SerializableFunction<E, N> name, N value,
        Predicate<N> ignoreStrategy) {
        return hold.lt(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E, D extends Date> L lt(int index, SerializableFunction<E, D> name, D value) {
        return hold.lt(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E, D extends Date> L lt(int index, SerializableFunction<E, D> name, D value, Predicate<D> ignoreStrategy) {
        return hold.lt(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L lt(int index, SerializableFunction<E, LocalTime> name, LocalTime value) {
        return hold.lt(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L lt(int index, SerializableFunction<E, LocalTime> name, LocalTime value,
        Predicate<LocalTime> ignoreStrategy) {
        return hold.lt(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L lt(int index, SerializableFunction<E, LocalDate> name, LocalDate value) {
        return hold.lt(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L lt(int index, SerializableFunction<E, LocalDate> name, LocalDate value,
        Predicate<LocalDate> ignoreStrategy) {
        return hold.lt(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L lt(int index, SerializableFunction<E, LocalDateTime> name, LocalDateTime value) {
        return hold.lt(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L lt(int index, SerializableFunction<E, LocalDateTime> name, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return hold.lt(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L lt(int index, SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy) {
        return hold.lt(new AtomicInteger(index), name, value, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L lt(int index, SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return hold.lt(new AtomicInteger(index), name, value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(int index, SerializableIntSupplier property, int value) {
        return hold.lt(new AtomicInteger(index), property, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(int index, SerializableIntSupplier property, int value, IntPredicate ignoreStrategy) {
        return hold.lt(new AtomicInteger(index), property, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(int index, SerializableLongSupplier property, long value) {
        return hold.lt(new AtomicInteger(index), property, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(int index, SerializableLongSupplier property, long value, LongPredicate ignoreStrategy) {
        return hold.lt(new AtomicInteger(index), property, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(int index, SerializableDoubleSupplier property, double value) {
        return hold.lt(new AtomicInteger(index), property, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(int index, SerializableDoubleSupplier property, double value, DoublePredicate ignoreStrategy) {
        return hold.lt(new AtomicInteger(index), property, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L lt(int index, SerializableDateSupplier<D> property, D value) {
        return hold.lt(new AtomicInteger(index), property, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L lt(int index, SerializableDateSupplier<D> property, D value,
        Predicate<D> ignoreStrategy) {
        return hold.lt(new AtomicInteger(index), property, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L lt(int index, SerializableNumberSupplier<N> property, N value) {
        return hold.lt(new AtomicInteger(index), property, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L lt(int index, SerializableNumberSupplier<N> property, N value,
        Predicate<N> ignoreStrategy) {
        return hold.lt(new AtomicInteger(index), property, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(int index, SerializableLocalDateSupplier property, LocalDate value) {
        return hold.lt(new AtomicInteger(index), property, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(int index, SerializableLocalDateSupplier property, LocalDate value,
        Predicate<LocalDate> ignoreStrategy) {
        return hold.lt(new AtomicInteger(index), value, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(int index, SerializableLocalTimeSupplier property, LocalTime value) {
        return hold.lt(new AtomicInteger(index), property, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(int index, SerializableLocalTimeSupplier property, LocalTime value,
        Predicate<LocalTime> ignoreStrategy) {
        return hold.lt(new AtomicInteger(index), property, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(int index, SerializableLocalDateTimeSupplier property, LocalDateTime value) {
        return hold.lt(new AtomicInteger(index), property, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(int index, SerializableLocalDateTimeSupplier property, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {
        return hold.lt(new AtomicInteger(index), property, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(int index, SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return hold.lt(new AtomicInteger(index), property, value, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(int index, SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return hold.lt(new AtomicInteger(index), property, value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, E extends Enum<E>> L lt(int index, SerializableFunction<T, E> name, E value) {
        return hold.lt(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, E extends Enum<E>> L lt(int index, SerializableFunction<T, E> name, E value,
        Predicate<E> ignoreStrategy) {
        return hold.lt(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L lt(int index, SerializableEnumSupplier<E> property, E value) {
        return hold.lt(new AtomicInteger(index), property, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L lt(int index, SerializableEnumSupplier<E> property, E value,
        Predicate<E> ignoreStrategy) {
        return hold.lt(new AtomicInteger(index), property, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(int index, String name, int value) {
        return hold.lt(new AtomicInteger(index), name, value, (IntPredicate) getIgnoreStrategy()::test);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(int index, String name, int value, IntPredicate ignoreStrategy) {
        return hold.lt(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(int index, String name, long value) {
        return hold.lt(new AtomicInteger(index), name, value, (LongPredicate) getIgnoreStrategy()::test);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(int index, String name, long value, LongPredicate ignoreStrategy) {
        return hold.lt(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(int index, String name, double value) {
        return hold.lt(new AtomicInteger(index), name, value, (DoublePredicate) getIgnoreStrategy()::test);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(int index, String name, double value, DoublePredicate ignoreStrategy) {
        return hold.lt(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L lt(int index, String name, N value) {
        return hold.lt(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L lt(int index, String name, N value, Predicate<N> ignoreStrategy) {
        return hold.lt(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L lt(int index, String name, E value) {
        return hold.lt(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L lt(int index, String name, E value, Predicate<E> ignoreStrategy) {
        return hold.lt(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L lt(int index, String name, D value) {
        return hold.lt(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L lt(int index, String name, D value, Predicate<D> ignoreStrategy) {
        return hold.lt(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(int index, String name, LocalTime value) {
        return hold.lt(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(int index, String name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return hold.lt(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(int index, String name, LocalDate value) {
        return hold.lt(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(int index, String name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return hold.lt(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(int index, String name, LocalDateTime value) {
        return hold.lt(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(int index, String name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return hold.lt(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(int index, String name, String value, MatchStrategy mathMatchStrategy) {
        return hold.lt(new AtomicInteger(index), name, value, mathMatchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(int index, String name, String value, MatchStrategy mathMatchStrategy,
        Predicate<String> ignoreStrategy) {
        return hold.lt(new AtomicInteger(index), name, value, mathMatchStrategy, ignoreStrategy);
    }
}
