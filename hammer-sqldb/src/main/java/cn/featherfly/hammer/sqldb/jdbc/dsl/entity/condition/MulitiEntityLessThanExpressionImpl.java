
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableDateSupplier;
import cn.featherfly.common.function.serializable.SerializableDoubleSupplier;
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
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.lt.MulitiEntityLessThanExpression;

/**
 * The Class MulitiEntityLessThanExpressionImpl.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class MulitiEntityLessThanExpressionImpl<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends MulitiEntityConditionExpressionProxy<C, L> implements MulitiEntityLessThanExpression<C, L> {

    /**
     * Instantiates a new muliti entity less than expression impl.
     *
     * @param proxy the proxy
     */
    public MulitiEntityLessThanExpressionImpl(AbstractMulitiEntityConditionExpression<C, L> proxy) {
        super(proxy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L lt(int index, SerializableToIntFunction<E> name, int value) {
        return proxy.lt0(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L lt(int index, SerializableToIntFunction<E> name, int value, Predicate<Integer> ignoreStrategy) {
        return proxy.lt0(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L lt(int index, SerializableToLongFunction<E> name, long value) {
        return proxy.lt0(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L lt(int index, SerializableToLongFunction<E> name, long value, Predicate<Long> ignoreStrategy) {
        return proxy.lt0(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L lt(int index, SerializableToDoubleFunction<E> name, double value) {
        return proxy.lt0(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L lt(int index, SerializableToDoubleFunction<E> name, double value, Predicate<Double> ignoreStrategy) {
        return proxy.lt0(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E, N extends Number> L lt(int index, SerializableFunction<E, N> name, N value) {
        return proxy.lt0(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E, N extends Number> L lt(int index, SerializableFunction<E, N> name, N value,
            Predicate<N> ignoreStrategy) {
        return proxy.lt0(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E, D extends Date> L lt(int index, SerializableFunction<E, D> name, D value) {
        return proxy.lt0(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E, D extends Date> L lt(int index, SerializableFunction<E, D> name, D value, Predicate<D> ignoreStrategy) {
        return proxy.lt0(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L lt(int index, SerializableFunction<E, LocalTime> name, LocalTime value) {
        return proxy.lt0(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L lt(int index, SerializableFunction<E, LocalTime> name, LocalTime value,
            Predicate<LocalTime> ignoreStrategy) {
        return proxy.lt0(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L lt(int index, SerializableFunction<E, LocalDate> name, LocalDate value) {
        return proxy.lt0(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L lt(int index, SerializableFunction<E, LocalDate> name, LocalDate value,
            Predicate<LocalDate> ignoreStrategy) {
        return proxy.lt0(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L lt(int index, SerializableFunction<E, LocalDateTime> name, LocalDateTime value) {
        return proxy.lt0(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L lt(int index, SerializableFunction<E, LocalDateTime> name, LocalDateTime value,
            Predicate<LocalDateTime> ignoreStrategy) {
        return proxy.lt0(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L lt(int index, SerializableFunction<E, String> name, String value) {
        return proxy.lt0(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L lt(int index, SerializableFunction<E, String> name, String value, Predicate<String> ignoreStrategy) {
        return proxy.lt0(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(int index, SerializableIntSupplier property) {
        return proxy.lt0(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(int index, SerializableIntSupplier property, Predicate<Integer> ignoreStrategy) {
        return proxy.lt0(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(int index, SerializableLongSupplier property) {
        return proxy.lt0(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(int index, SerializableLongSupplier property, Predicate<Long> ignoreStrategy) {
        return proxy.lt0(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(int index, SerializableDoubleSupplier property) {
        return proxy.lt0(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(int index, SerializableDoubleSupplier property, Predicate<Double> ignoreStrategy) {
        return proxy.lt0(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L lt(int index, SerializableDateSupplier<R> property) {
        return proxy.lt0(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L lt(int index, SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy) {
        return proxy.lt0(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L lt(int index, SerializableNumberSupplier<R> property) {
        return proxy.lt0(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L lt(int index, SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy) {
        return proxy.lt0(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(int index, SerializableLocalDateSupplier property) {
        return proxy.lt0(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(int index, SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return proxy.lt0(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(int index, SerializableLocalTimeSupplier property) {
        return proxy.lt0(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(int index, SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return proxy.lt0(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(int index, SerializableLocalDateTimeSupplier property) {
        return proxy.lt0(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(int index, SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return proxy.lt0(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(int index, SerializableStringSupplier property) {
        return proxy.lt0(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(int index, SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return proxy.lt0(index, property, ignoreStrategy);
    }

}
