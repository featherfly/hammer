
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition;

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
import cn.featherfly.hammer.expression.entity.condition.in.MulitiEntityInExpression;

/**
 * The Class MulitiEntityIsNullExpressionImpl.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class MulitiEntityInExpressionImpl<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends MulitiEntityConditionExpressionProxy<C, L> implements MulitiEntityInExpression<C, L> {

    /**
     * Instantiates a new muliti entity in expression impl.
     *
     * @param proxy the proxy
     */
    public MulitiEntityInExpressionImpl(AbstractMulitiEntityConditionExpression<C, L> proxy) {
        super(proxy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E, R> L in(int index, SerializableFunction<E, R> name, R value) {
        return proxy.in0(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E, R> L in(int index, SerializableFunction<E, R> name, R value, Predicate<R> ignoreStrategy) {
        return proxy.in0(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L in(int index, SerializableToIntFunction<E> name, int value) {
        return proxy.in0(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L in(int index, SerializableToIntFunction<E> name, int value, IntPredicate ignoreStrategy) {
        return proxy.in0(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L in(int index, SerializableToLongFunction<E> name, long value) {
        return proxy.in0(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L in(int index, SerializableToLongFunction<E> name, long value, LongPredicate ignoreStrategy) {
        return proxy.in0(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L in(int index, SerializableToDoubleFunction<E> name, double value) {
        return proxy.in0(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L in(int index, SerializableToDoubleFunction<E> name, double value, DoublePredicate ignoreStrategy) {
        return proxy.in0(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E, R> L in(int index, SerializableFunction<E, R> name, @SuppressWarnings("unchecked") R... value) {
        return proxy.in0(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L in(int index, SerializableToIntFunction<E> name, int... value) {
        return proxy.in0(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L in(int index, SerializableToLongFunction<E> name, long... value) {
        return proxy.in0(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L in(int index, SerializableToDoubleFunction<E> name, double... value) {
        return proxy.in0(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E, R> L in(int index, SerializableFunction<E, R> name, R[] value, Predicate<R[]> ignoreStrategy) {
        return proxy.in0(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L in(int index, SerializableToIntFunction<E> name, int[] value, Predicate<int[]> ignoreStrategy) {
        return proxy.in0(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L in(int index, SerializableToLongFunction<E> name, long[] value, Predicate<long[]> ignoreStrategy) {
        return proxy.in0(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L in(int index, SerializableToDoubleFunction<E> name, double[] value,
            Predicate<double[]> ignoreStrategy) {
        return proxy.in0(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E, R> L in(int index, SerializableFunction<E, R> name, Collection<R> value) {
        return proxy.in0(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E, R> L in(int index, SerializableFunction<E, R> name, Collection<R> value,
            Predicate<Collection<R>> ignoreStrategy) {
        return proxy.in0(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in(int index, SerializableSupplier<R> property) {
        return proxy.in0(new AtomicInteger(index), property, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L in(int index, SerializableSupplier<R> property, Predicate<R> ignoreStrategy) {
        return proxy.in0(new AtomicInteger(index), property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(int index, SerializableIntSupplier property) {
        return proxy.in0(new AtomicInteger(index), property, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(int index, SerializableIntSupplier property, IntPredicate ignoreStrategy) {
        return proxy.in0(new AtomicInteger(index), property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(int index, SerializableLongSupplier property) {
        return proxy.in0(new AtomicInteger(index), property, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(int index, SerializableLongSupplier property, LongPredicate ignoreStrategy) {
        return proxy.in0(new AtomicInteger(index), property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(int index, SerializableDoubleSupplier property) {
        return proxy.in0(new AtomicInteger(index), property, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(int index, SerializableDoubleSupplier property, DoublePredicate ignoreStrategy) {
        return proxy.in0(new AtomicInteger(index), property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L in(int index, SerializableToStringFunction<E> name, String value, MatchStrategy matchStrategy) {
        return proxy.in0(new AtomicInteger(index), name, value, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L in(int index, SerializableToStringFunction<E> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        return proxy.in0(new AtomicInteger(index), name, value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L in(int index, SerializableToStringFunction<E> name, String[] value, MatchStrategy matchStrategy) {
        return proxy.in0(new AtomicInteger(index), name, value, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L in(int index, SerializableToStringFunction<E> name, String[] value, MatchStrategy matchStrategy,
            Predicate<String[]> ignoreStrategy) {
        return proxy.in0(new AtomicInteger(index), name, value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(int index, SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return proxy.in0(new AtomicInteger(index), property, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(int index, SerializableStringSupplier property, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        return proxy.in0(new AtomicInteger(index), property, matchStrategy, ignoreStrategy);
    }

}
