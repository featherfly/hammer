
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.function.Predicate;

import cn.featherfly.common.lang.function.SerializableDateSupplier;
import cn.featherfly.common.lang.function.SerializableDoubleSupplier;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableIntSupplier;
import cn.featherfly.common.lang.function.SerializableLocalDateSupplier;
import cn.featherfly.common.lang.function.SerializableLocalDateTimeSupplier;
import cn.featherfly.common.lang.function.SerializableLocalTimeSupplier;
import cn.featherfly.common.lang.function.SerializableLongSupplier;
import cn.featherfly.common.lang.function.SerializableNumberSupplier;
import cn.featherfly.common.lang.function.SerializableStringSupplier;
import cn.featherfly.common.lang.function.SerializableToDoubleFunction;
import cn.featherfly.common.lang.function.SerializableToIntFunction;
import cn.featherfly.common.lang.function.SerializableToLongFunction;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.gt.MulitiEntityGreatThanExpression;

/**
 * The Class MulitiEntityGreatThanExpressionImpl.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class MulitiEntityGreatThanExpressionImpl<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends MulitiEntityConditionExpressionProxy<C, L> implements MulitiEntityGreatThanExpression<C, L> {

    /**
     * Instantiates a new muliti entity great than expression impl.
     *
     * @param proxy the proxy
     */
    public MulitiEntityGreatThanExpressionImpl(AbstractMulitiEntityConditionExpression<C, L> proxy) {
        super(proxy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L gt(int index, SerializableToIntFunction<E> name, int value) {
        return proxy.gt0(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L gt(int index, SerializableToIntFunction<E> name, int value, Predicate<Integer> ignoreStrategy) {
        return proxy.gt0(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L gt(int index, SerializableToLongFunction<E> name, long value) {
        return proxy.gt0(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L gt(int index, SerializableToLongFunction<E> name, long value, Predicate<Long> ignoreStrategy) {
        return proxy.gt0(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L gt(int index, SerializableToDoubleFunction<E> name, double value) {
        return proxy.gt0(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L gt(int index, SerializableToDoubleFunction<E> name, double value, Predicate<Double> ignoreStrategy) {
        return proxy.gt0(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E, N extends Number> L gt(int index, SerializableFunction<E, N> name, N value) {
        return proxy.gt0(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E, N extends Number> L gt(int index, SerializableFunction<E, N> name, N value,
            Predicate<N> ignoreStrategy) {
        return proxy.gt0(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E, D extends Date> L gt(int index, SerializableFunction<E, D> name, D value) {
        return proxy.gt0(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E, D extends Date> L gt(int index, SerializableFunction<E, D> name, D value, Predicate<D> ignoreStrategy) {
        return proxy.gt0(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L gt(int index, SerializableFunction<E, LocalTime> name, LocalTime value) {
        return proxy.gt0(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L gt(int index, SerializableFunction<E, LocalTime> name, LocalTime value,
            Predicate<LocalTime> ignoreStrategy) {
        return proxy.gt0(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L gt(int index, SerializableFunction<E, LocalDate> name, LocalDate value) {
        return proxy.gt0(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L gt(int index, SerializableFunction<E, LocalDate> name, LocalDate value,
            Predicate<LocalDate> ignoreStrategy) {
        return proxy.gt0(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L gt(int index, SerializableFunction<E, LocalDateTime> name, LocalDateTime value) {
        return proxy.gt0(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L gt(int index, SerializableFunction<E, LocalDateTime> name, LocalDateTime value,
            Predicate<LocalDateTime> ignoreStrategy) {
        return proxy.gt0(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L gt(int index, SerializableFunction<E, String> name, String value) {
        return proxy.gt0(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L gt(int index, SerializableFunction<E, String> name, String value, Predicate<String> ignoreStrategy) {
        return proxy.gt0(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(int index, SerializableIntSupplier property) {
        return proxy.gt0(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(int index, SerializableIntSupplier property, Predicate<Integer> ignoreStrategy) {
        return proxy.gt0(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(int index, SerializableLongSupplier property) {
        return proxy.gt0(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(int index, SerializableLongSupplier property, Predicate<Long> ignoreStrategy) {
        return proxy.gt0(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(int index, SerializableDoubleSupplier property) {
        return proxy.gt0(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(int index, SerializableDoubleSupplier property, Predicate<Double> ignoreStrategy) {
        return proxy.gt0(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L gt(int index, SerializableDateSupplier<R> property) {
        return proxy.gt0(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L gt(int index, SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy) {
        return proxy.gt0(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L gt(int index, SerializableNumberSupplier<R> property) {
        return proxy.gt0(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L gt(int index, SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy) {
        return proxy.gt0(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(int index, SerializableLocalDateSupplier property) {
        return proxy.gt0(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(int index, SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return proxy.gt0(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(int index, SerializableLocalTimeSupplier property) {
        return proxy.gt0(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(int index, SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return proxy.gt0(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(int index, SerializableLocalDateTimeSupplier property) {
        return proxy.gt0(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(int index, SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return proxy.gt0(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(int index, SerializableStringSupplier property) {
        return proxy.gt0(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(int index, SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return proxy.gt0(index, property, ignoreStrategy);
    }

}
