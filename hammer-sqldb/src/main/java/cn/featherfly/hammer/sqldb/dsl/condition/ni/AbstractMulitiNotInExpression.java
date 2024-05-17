
package cn.featherfly.hammer.sqldb.dsl.condition.ni;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;
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
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.ni.MulitiNotInExpression;
import cn.featherfly.hammer.sqldb.dsl.condition.AbstractInternalMulitiConditionHolder;
import cn.featherfly.hammer.sqldb.dsl.condition.InternalMulitiCondition;

/**
 * abstract muliti not in expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public abstract class AbstractMulitiNotInExpression<I extends InternalMulitiCondition<L>, C extends ConditionExpression,
    L extends LogicExpression<C, L>> extends AbstractInternalMulitiConditionHolder<I, C, L>
    implements MulitiNotInExpression<C, L> {

    /**
     * Instantiates a new muliti entity not in expression impl.
     *
     * @param internalMulitiCondition the internal muliti condition
     */
    protected AbstractMulitiNotInExpression(I internalMulitiCondition) {
        super(internalMulitiCondition);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E, R> L ni(int index, SerializableFunction<E, R> name, R value) {
        return hold.ni(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E, R> L ni(int index, SerializableFunction<E, R> name, R value, Predicate<R> ignoreStrategy) {
        return hold.ni(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L ni(int index, SerializableToIntFunction<E> name, int value) {
        return hold.ni(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L ni(int index, SerializableToIntFunction<E> name, int value, IntPredicate ignoreStrategy) {
        return hold.ni(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L ni(int index, SerializableToLongFunction<E> name, long value) {
        return hold.ni(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L ni(int index, SerializableToLongFunction<E> name, long value, LongPredicate ignoreStrategy) {
        return hold.ni(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L ni(int index, SerializableToDoubleFunction<E> name, double value) {
        return hold.ni(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L ni(int index, SerializableToDoubleFunction<E> name, double value, DoublePredicate ignoreStrategy) {
        return hold.ni(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E, R> L ni(int index, SerializableFunction<E, R> name, @SuppressWarnings("unchecked") R... value) {
        return hold.ni(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L ni(int index, SerializableToIntFunction<E> name, int... value) {
        return hold.ni(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L ni(int index, SerializableToLongFunction<E> name, long... value) {
        return hold.ni(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L ni(int index, SerializableToDoubleFunction<E> name, double... value) {
        return hold.ni(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E, R> L ni(int index, SerializableFunction<E, R> name, R[] value, Predicate<R[]> ignoreStrategy) {
        return hold.ni(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L ni(int index, SerializableToIntFunction<E> name, int[] value, Predicate<int[]> ignoreStrategy) {
        return hold.ni(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L ni(int index, SerializableToLongFunction<E> name, long[] value, Predicate<long[]> ignoreStrategy) {
        return hold.ni(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L ni(int index, SerializableToDoubleFunction<E> name, double[] value,
        Predicate<double[]> ignoreStrategy) {
        return hold.ni(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E, R> L ni(int index, SerializableFunction<E, R> name, Collection<R> value) {
        return hold.ni(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E, R> L ni(int index, SerializableFunction<E, R> name, Collection<R> value,
        Predicate<Collection<R>> ignoreStrategy) {
        return hold.ni(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ni(int index, SerializableSupplier<R> property) {
        return hold.ni(new AtomicInteger(index), property, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ni(int index, SerializableSupplier<R> property, Predicate<R> ignoreStrategy) {
        return hold.ni(new AtomicInteger(index), property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(int index, SerializableIntSupplier property) {
        return hold.ni(new AtomicInteger(index), property, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(int index, SerializableIntSupplier property, IntPredicate ignoreStrategy) {
        return hold.ni(new AtomicInteger(index), property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(int index, SerializableLongSupplier property) {
        return hold.ni(new AtomicInteger(index), property, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(int index, SerializableLongSupplier property, LongPredicate ignoreStrategy) {
        return hold.ni(new AtomicInteger(index), property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(int index, SerializableDoubleSupplier property) {
        return hold.ni(new AtomicInteger(index), property, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(int index, SerializableDoubleSupplier property, DoublePredicate ignoreStrategy) {
        return hold.ni(new AtomicInteger(index), property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L ni(int index, SerializableToStringFunction<E> name, String value, MatchStrategy matchStrategy) {
        return hold.ni(new AtomicInteger(index), name, value, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L ni(int index, SerializableToStringFunction<E> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return hold.ni(new AtomicInteger(index), name, value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L ni(int index, SerializableToStringFunction<E> name, String[] value, MatchStrategy matchStrategy) {
        return hold.ni(new AtomicInteger(index), name, value, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L ni(int index, SerializableToStringFunction<E> name, String[] value, MatchStrategy matchStrategy,
        Predicate<String[]> ignoreStrategy) {
        return hold.ni(new AtomicInteger(index), name, value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(int index, SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return hold.ni(new AtomicInteger(index), property, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(int index, SerializableStringSupplier property, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return hold.ni(new AtomicInteger(index), property, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ni(int index, String name, R value) {
        return hold.ni(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ni(int index, String name, R value, Predicate<R> ignoreStrategy) {
        return hold.ni(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(int index, String name, int value) {
        return hold.ni(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(int index, String name, int value, IntPredicate ignoreStrategy) {
        return hold.ni(new AtomicInteger(index), name, value, (IntPredicate) getIgnoreStrategy()::test);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(int index, String name, long value) {
        return hold.ni(new AtomicInteger(index), name, value, (LongPredicate) getIgnoreStrategy()::test);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(int index, String name, long value, LongPredicate ignoreStrategy) {
        return hold.ni(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(int index, String name, double value) {
        return hold.ni(new AtomicInteger(index), name, value, (DoublePredicate) getIgnoreStrategy()::test);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(int index, String name, double value, DoublePredicate ignoreStrategy) {
        return hold.ni(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ni(int index, String name, @SuppressWarnings("unchecked") R... value) {
        return hold.ni(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(int index, String name, int... value) {
        return hold.ni(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(int index, String name, long... value) {
        return hold.ni(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(int index, String name, double... value) {
        return hold.ni(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ni(int index, String name, R[] value, Predicate<R[]> ignoreStrategy) {
        return hold.ni(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(int index, String name, int[] value, Predicate<int[]> ignoreStrategy) {
        return hold.ni(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(int index, String name, long[] value, Predicate<long[]> ignoreStrategy) {
        return hold.ni(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(int index, String name, double[] value, Predicate<double[]> ignoreStrategy) {
        return hold.ni(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(int index, String name, String value, MatchStrategy matchStrategy) {
        return hold.ni(new AtomicInteger(index), name, value, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(int index, String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return hold.ni(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(int index, String name, String[] value, MatchStrategy matchStrategy) {
        return hold.ni(new AtomicInteger(index), name, value, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(int index, String name, String[] value, MatchStrategy matchStrategy,
        Predicate<String[]> ignoreStrategy) {
        return hold.ni(new AtomicInteger(index), name, value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ni(int index, String name, Collection<R> value) {
        return hold.ni(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ni(int index, String name, Collection<R> value, Predicate<Collection<R>> ignoreStrategy) {
        return hold.ni(new AtomicInteger(index), name, value, ignoreStrategy);
    }

}
