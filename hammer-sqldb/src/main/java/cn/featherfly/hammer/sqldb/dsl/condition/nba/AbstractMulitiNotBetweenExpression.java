
package cn.featherfly.hammer.sqldb.dsl.condition.nba;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
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
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.nba.MulitiNotBetweenExpression;
import cn.featherfly.hammer.sqldb.dsl.condition.AbstractInternalMulitiConditionHolder;
import cn.featherfly.hammer.sqldb.dsl.condition.InternalMulitiCondition;

/**
 * abstract muliti not between and expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public abstract class AbstractMulitiNotBetweenExpression<I extends InternalMulitiCondition<L>,
        C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends AbstractInternalMulitiConditionHolder<I, C, L> implements MulitiNotBetweenExpression<C, L> {

    /**
     * Instantiates a new muliti not between expression impl.
     *
     * @param internalMulitiCondition the internal muliti condition
     */
    protected AbstractMulitiNotBetweenExpression(I internalMulitiCondition) {
        super(internalMulitiCondition);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L nba(int index, SerializableToIntFunction<E> name, int min, int max) {
        return hold.nba(new AtomicInteger(index), name, min, max, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L nba(int index, SerializableToIntFunction<E> name, int min, int max,
            BiPredicate<Integer, Integer> ignoreStrategy) {
        return hold.nba(new AtomicInteger(index), name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L nba(int index, SerializableToLongFunction<E> name, long min, long max) {
        return hold.nba(new AtomicInteger(index), name, min, max, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L nba(int index, SerializableToLongFunction<E> name, long min, long max,
            BiPredicate<Long, Long> ignoreStrategy) {
        return hold.nba(new AtomicInteger(index), name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L nba(int index, SerializableToDoubleFunction<E> name, double min, double max) {
        return hold.nba(new AtomicInteger(index), name, min, max, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L nba(int index, SerializableToDoubleFunction<E> name, double min, double max,
            BiPredicate<Double, Double> ignoreStrategy) {
        return hold.nba(new AtomicInteger(index), name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E, N extends Number> L nba(int index, SerializableToNumberFunction<E, N> name, N min, N max) {
        return hold.nba(new AtomicInteger(index), name, min, max, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E, N extends Number> L nba(int index, SerializableToNumberFunction<E, N> name, N min, N max,
            BiPredicate<N, N> ignoreStrategy) {
        return hold.nba(new AtomicInteger(index), name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E, D extends Date> L nba(int index, SerializableToDateFunction<E, D> name, D min, D max) {
        return hold.nba(new AtomicInteger(index), name, min, max, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E, D extends Date> L nba(int index, SerializableToDateFunction<E, D> name, D min, D max,
            BiPredicate<D, D> ignoreStrategy) {
        return hold.nba(new AtomicInteger(index), name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L nba(int index, SerializableToLocalTimeFunction<E> name, LocalTime min, LocalTime max) {
        return hold.nba(new AtomicInteger(index), name, min, max, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L nba(int index, SerializableToLocalTimeFunction<E> name, LocalTime min, LocalTime max,
            BiPredicate<LocalTime, LocalTime> ignoreStrategy) {
        return hold.nba(new AtomicInteger(index), name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L nba(int index, SerializableToLocalDateFunction<E> name, LocalDate min, LocalDate max) {
        return hold.nba(new AtomicInteger(index), name, min, max, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L nba(int index, SerializableToLocalDateFunction<E> name, LocalDate min, LocalDate max,
            BiPredicate<LocalDate, LocalDate> ignoreStrategy) {
        return hold.nba(new AtomicInteger(index), name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L nba(int index, SerializableToLocalDateTimeFunction<E> name, LocalDateTime min, LocalDateTime max) {
        return hold.nba(new AtomicInteger(index), name, min, max, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L nba(int index, SerializableToLocalDateTimeFunction<E> name, LocalDateTime min, LocalDateTime max,
            BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {
        return hold.nba(new AtomicInteger(index), name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L nba(int index, SerializableToStringFunction<E> name, String min, String max) {
        return hold.nba(new AtomicInteger(index), name, min, max, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L nba(int index, SerializableToStringFunction<E> name, String min, String max,
            BiPredicate<String, String> ignoreStrategy) {
        return hold.nba(new AtomicInteger(index), name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, E extends Enum<E>> L nba(int index, SerializableToEnumFunction<T, E> name, E min, E max) {
        return hold.nba(new AtomicInteger(index), name, min, max, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, E extends Enum<E>> L nba(int index, SerializableToEnumFunction<T, E> name, E min, E max,
            BiPredicate<E, E> ignoreStrategy) {
        return hold.nba(new AtomicInteger(index), name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(int index, String name, int min, int max) {
        return hold.nba(new AtomicInteger(index), name, min, max, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(int index, String name, int min, int max, BiPredicate<Integer, Integer> ignoreStrategy) {
        return hold.nba(new AtomicInteger(index), name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(int index, String name, long min, long max) {
        return hold.nba(new AtomicInteger(index), name, min, max, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(int index, String name, long min, long max, BiPredicate<Long, Long> ignoreStrategy) {
        return hold.nba(new AtomicInteger(index), name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(int index, String name, double min, double max) {
        return hold.nba(new AtomicInteger(index), name, min, max, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(int index, String name, double min, double max, BiPredicate<Double, Double> ignoreStrategy) {
        return hold.nba(new AtomicInteger(index), name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L nba(int index, String name, N min, N max) {
        return hold.nba(new AtomicInteger(index), name, min, max, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> L nba(int index, String name, N min, N max, BiPredicate<N, N> ignoreStrategy) {
        return hold.nba(new AtomicInteger(index), name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L nba(int index, String name, D min, D max) {
        return hold.nba(new AtomicInteger(index), name, min, max, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> L nba(int index, String name, D min, D max, BiPredicate<D, D> ignoreStrategy) {
        return hold.nba(new AtomicInteger(index), name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L nba(int index, String name, E min, E max) {
        return hold.nba(new AtomicInteger(index), name, min, max, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L nba(int index, String name, E min, E max, BiPredicate<E, E> ignoreStrategy) {
        return hold.nba(new AtomicInteger(index), name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(int index, String name, LocalTime min, LocalTime max) {
        return hold.nba(new AtomicInteger(index), name, min, max, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(int index, String name, LocalTime min, LocalTime max,
            BiPredicate<LocalTime, LocalTime> ignoreStrategy) {
        return hold.nba(new AtomicInteger(index), name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(int index, String name, LocalDate min, LocalDate max) {
        return hold.nba(new AtomicInteger(index), name, min, max, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(int index, String name, LocalDate min, LocalDate max,
            BiPredicate<LocalDate, LocalDate> ignoreStrategy) {
        return hold.nba(new AtomicInteger(index), name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(int index, String name, LocalDateTime min, LocalDateTime max) {
        return hold.nba(new AtomicInteger(index), name, min, max, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(int index, String name, LocalDateTime min, LocalDateTime max,
            BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {
        return hold.nba(new AtomicInteger(index), name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(int index, String name, String min, String max) {
        return hold.nba(new AtomicInteger(index), name, min, max, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(int index, String name, String min, String max, BiPredicate<String, String> ignoreStrategy) {
        return hold.nba(new AtomicInteger(index), name, min, max, ignoreStrategy);
    }

}
