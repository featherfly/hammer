
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
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
import cn.featherfly.hammer.expression.entity.condition.ge.MulitiEntityGreatEqualsExpression;

/**
 * The Class MulitiEntityGreatEqualsExpressionImpl.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class MulitiEntityGreatEqualsExpressionImpl<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends MulitiEntityConditionExpressionProxy<C, L> implements MulitiEntityGreatEqualsExpression<C, L> {

    /**
     * Instantiates a new muliti entity equals expression impl.
     *
     * @param proxy the proxy
     */
    public MulitiEntityGreatEqualsExpressionImpl(AbstractMulitiEntityConditionExpression<C, L> proxy) {
        super(proxy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L ge(int index, SerializableToIntFunction<E> name, int value) {
        return proxy.ge0(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L ge(int index, SerializableToIntFunction<E> name, int value, IntPredicate ignoreStrategy) {
        return proxy.ge0(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L ge(int index, SerializableToLongFunction<E> name, long value) {
        return proxy.ge0(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L ge(int index, SerializableToLongFunction<E> name, long value, LongPredicate ignoreStrategy) {
        return proxy.ge0(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L ge(int index, SerializableToDoubleFunction<E> name, double value) {
        return proxy.ge0(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L ge(int index, SerializableToDoubleFunction<E> name, double value, DoublePredicate ignoreStrategy) {
        return proxy.ge0(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E, N extends Number> L ge(int index, SerializableFunction<E, N> name, N value) {
        return proxy.ge0(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E, N extends Number> L ge(int index, SerializableFunction<E, N> name, N value,
            Predicate<N> ignoreStrategy) {
        return proxy.ge0(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E, D extends Date> L ge(int index, SerializableFunction<E, D> name, D value) {
        return proxy.ge0(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E, D extends Date> L ge(int index, SerializableFunction<E, D> name, D value, Predicate<D> ignoreStrategy) {
        return proxy.ge0(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L ge(int index, SerializableFunction<E, LocalTime> name, LocalTime value) {
        return proxy.ge0(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L ge(int index, SerializableFunction<E, LocalTime> name, LocalTime value,
            Predicate<LocalTime> ignoreStrategy) {
        return proxy.ge0(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L ge(int index, SerializableFunction<E, LocalDate> name, LocalDate value) {
        return proxy.ge0(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L ge(int index, SerializableFunction<E, LocalDate> name, LocalDate value,
            Predicate<LocalDate> ignoreStrategy) {
        return proxy.ge0(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L ge(int index, SerializableFunction<E, LocalDateTime> name, LocalDateTime value) {
        return proxy.ge0(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L ge(int index, SerializableFunction<E, LocalDateTime> name, LocalDateTime value,
            Predicate<LocalDateTime> ignoreStrategy) {
        return proxy.ge0(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L ge(int index, SerializableFunction<E, String> name, String value) {
        return proxy.ge0(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L ge(int index, SerializableFunction<E, String> name, String value, Predicate<String> ignoreStrategy) {
        return proxy.ge0(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(int index, SerializableIntSupplier property) {
        return proxy.ge0(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(int index, SerializableIntSupplier property, IntPredicate ignoreStrategy) {
        return proxy.ge0(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(int index, SerializableLongSupplier property) {
        return proxy.ge0(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(int index, SerializableLongSupplier property, LongPredicate ignoreStrategy) {
        return proxy.ge0(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(int index, SerializableDoubleSupplier property) {
        return proxy.ge0(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(int index, SerializableDoubleSupplier property, DoublePredicate ignoreStrategy) {
        return proxy.ge0(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L ge(int index, SerializableDateSupplier<R> property) {
        return proxy.ge0(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L ge(int index, SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy) {
        return proxy.ge0(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L ge(int index, SerializableNumberSupplier<R> property) {
        return proxy.ge0(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L ge(int index, SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy) {
        return proxy.ge0(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(int index, SerializableLocalDateSupplier property) {
        return proxy.ge0(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(int index, SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return proxy.ge0(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(int index, SerializableLocalTimeSupplier property) {
        return proxy.ge0(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(int index, SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return proxy.ge0(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(int index, SerializableLocalDateTimeSupplier property) {
        return proxy.ge0(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(int index, SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return proxy.ge0(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(int index, SerializableStringSupplier property) {
        return proxy.ge0(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(int index, SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return proxy.ge0(index, property, ignoreStrategy);
    }
}