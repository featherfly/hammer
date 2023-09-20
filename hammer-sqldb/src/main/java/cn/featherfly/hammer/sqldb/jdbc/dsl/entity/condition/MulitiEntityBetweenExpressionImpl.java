
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.function.BiPredicate;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableToDoubleFunction;
import cn.featherfly.common.function.serializable.SerializableToIntFunction;
import cn.featherfly.common.function.serializable.SerializableToLongFunction;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.ba.MulitiEntityBetweenExpression;

/**
 * The Class MulitiEntityBetweenExpressionImpl.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class MulitiEntityBetweenExpressionImpl<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends MulitiEntityConditionExpressionProxy<C, L> implements MulitiEntityBetweenExpression<C, L> {

    /**
     * Instantiates a new muliti entity between expression impl.
     *
     * @param proxy the proxy
     */
    public MulitiEntityBetweenExpressionImpl(AbstractMulitiEntityConditionExpression<C, L> proxy) {
        super(proxy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L ba(int index, SerializableToIntFunction<E> name, int min, int max) {
        return proxy.ba0(index, name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L ba(int index, SerializableToIntFunction<E> name, int min, int max,
            BiPredicate<Integer, Integer> ignoreStrategy) {
        return proxy.ba0(index, name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L ba(int index, SerializableToLongFunction<E> name, long min, long max) {
        return proxy.ba0(index, name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L ba(int index, SerializableToLongFunction<E> name, long min, long max,
            BiPredicate<Long, Long> ignoreStrategy) {
        return proxy.ba0(index, name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L ba(int index, SerializableToDoubleFunction<E> name, double min, double max) {
        return proxy.ba0(index, name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L ba(int index, SerializableToDoubleFunction<E> name, double min, double max,
            BiPredicate<Double, Double> ignoreStrategy) {
        return proxy.ba0(index, name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E, N extends Number> L ba(int index, SerializableFunction<E, N> name, N min, N max) {
        return proxy.ba0(index, name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E, N extends Number> L ba(int index, SerializableFunction<E, N> name, N min, N max,
            BiPredicate<N, N> ignoreStrategy) {
        return proxy.ba0(index, name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E, D extends Date> L ba(int index, SerializableFunction<E, D> name, D min, D max) {
        return proxy.ba0(index, name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E, D extends Date> L ba(int index, SerializableFunction<E, D> name, D min, D max,
            BiPredicate<D, D> ignoreStrategy) {
        return proxy.ba0(index, name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L ba(int index, SerializableFunction<E, LocalTime> name, LocalTime min, LocalTime max) {
        return proxy.ba0(index, name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L ba(int index, SerializableFunction<E, LocalTime> name, LocalTime min, LocalTime max,
            BiPredicate<LocalTime, LocalTime> ignoreStrategy) {
        return proxy.ba0(index, name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L ba(int index, SerializableFunction<E, LocalDate> name, LocalDate min, LocalDate max) {
        return proxy.ba0(index, name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L ba(int index, SerializableFunction<E, LocalDate> name, LocalDate min, LocalDate max,
            BiPredicate<LocalDate, LocalDate> ignoreStrategy) {
        return proxy.ba0(index, name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L ba(int index, SerializableFunction<E, LocalDateTime> name, LocalDateTime min, LocalDateTime max) {
        return proxy.ba0(index, name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L ba(int index, SerializableFunction<E, LocalDateTime> name, LocalDateTime min, LocalDateTime max,
            BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {
        return proxy.ba0(index, name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L ba(int index, SerializableFunction<E, String> name, String min, String max) {
        return proxy.ba0(index, name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L ba(int index, SerializableFunction<E, String> name, String min, String max,
            BiPredicate<String, String> ignoreStrategy) {
        return proxy.ba0(index, name, min, max, ignoreStrategy);
    }

}
