
/*
 * All rights Reserved, Designed By zhongj
 * @Title: MulitiEntityNotEqualsExpressionImpl.java
 * @Description: MulitiEntityNotEqualsExpressionImpl
 * @author: zhongj
 * @date: 2023-08-07 17:52:07
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition;

import java.io.Serializable;
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
import cn.featherfly.hammer.expression.entity.condition.ne.MulitiEntityNotEqualsExpression;

/**
 * The Class MulitiEntityNotEqualsExpressionImpl.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class MulitiEntityNotEqualsExpressionImpl<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends MulitiEntityConditionExpressionProxy<C, L> implements MulitiEntityNotEqualsExpression<C, L> {

    /**
     * Instantiates a new muliti entity neuals expression impl.
     *
     * @param proxy the proxy
     */
    public MulitiEntityNotEqualsExpressionImpl(AbstractMulitiEntityConditionExpression<C, L> proxy) {
        super(proxy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E, R> L ne(int index, SerializableFunction<E, R> name, R value, MatchStrategy matchStrategy) {
        return proxy.ne0(new AtomicInteger(index), name, value, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E, R> L ne(int index, SerializableFunction<E, R> name, R value, MatchStrategy matchStrategy,
            Predicate<R> ignoreStrategy) {
        return proxy.ne0(new AtomicInteger(index), name, value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(int index, SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return proxy.ne0(new AtomicInteger(index), property, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(int index, SerializableStringSupplier property, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        return proxy.ne0(new AtomicInteger(index), property, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L ne(int index, SerializableToIntFunction<T> name, int value) {
        return proxy.ne0(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L ne(int index, SerializableToIntFunction<T> name, int value, IntPredicate ignoreStrategy) {
        return proxy.ne0(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L ne(int index, SerializableToLongFunction<T> name, long value) {
        return proxy.ne0(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L ne(int index, SerializableToLongFunction<T> name, long value, LongPredicate ignoreStrategy) {
        return proxy.ne0(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L ne(int index, SerializableToDoubleFunction<T> name, double value) {
        return proxy.ne0(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L ne(int index, SerializableToDoubleFunction<T> name, double value, DoublePredicate ignoreStrategy) {
        return proxy.ne0(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, N extends Number> L ne(int index, SerializableToNumberFunction<T, N> name, N value) {
        return proxy.ne0(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, N extends Number> L ne(int index, SerializableToNumberFunction<T, N> name, N value,
            Predicate<N> ignoreStrategy) {
        return proxy.ne0(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, E extends Enum<E>> L ne(int index, SerializableToEnumFunction<T, E> name, E value) {
        return proxy.ne0(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, E extends Enum<E>> L ne(int index, SerializableToEnumFunction<T, E> name, E value,
            Predicate<E> ignoreStrategy) {
        return proxy.ne0(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, D extends Date> L ne(int index, SerializableToDateFunction<T, D> name, D value) {
        return proxy.ne0(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, D extends Date> L ne(int index, SerializableToDateFunction<T, D> name, D value,
            Predicate<D> ignoreStrategy) {
        return proxy.ne0(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L ne(int index, SerializableToLocalTimeFunction<T> name, LocalTime value) {
        return proxy.ne0(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L ne(int index, SerializableToLocalTimeFunction<T> name, LocalTime value,
            Predicate<LocalTime> ignoreStrategy) {
        return proxy.ne0(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L ne(int index, SerializableToLocalDateFunction<T> name, LocalDate value) {
        return proxy.ne0(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L ne(int index, SerializableToLocalDateFunction<T> name, LocalDate value,
            Predicate<LocalDate> ignoreStrategy) {
        return proxy.ne0(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L ne(int index, SerializableToLocalDateTimeFunction<T> name, LocalDateTime value) {
        return proxy.ne0(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L ne(int index, SerializableToLocalDateTimeFunction<T> name, LocalDateTime value,
            Predicate<LocalDateTime> ignoreStrategy) {
        return proxy.ne0(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L ne(int index, SerializableToStringFunction<T> name, String value) {
        return proxy.ne0(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L ne(int index, SerializableToStringFunction<T> name, String value, Predicate<String> ignoreStrategy) {
        return proxy.ne0(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L ne(int index, SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy) {
        return proxy.ne0(new AtomicInteger(index), name, value, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> L ne(int index, SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        return proxy.ne0(new AtomicInteger(index), name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ne(int index, SerializableSupplier<R> property) {
        return proxy.ne0(new AtomicInteger(index), property, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ne(int index, SerializableSupplier<R> property, Predicate<R> ignoreStrategy) {
        return proxy.ne0(new AtomicInteger(index), property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(int index, SerializableIntSupplier property) {
        return proxy.ne0(new AtomicInteger(index), (Serializable) property, property.get(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(int index, SerializableIntSupplier property, IntPredicate ignoreStrategy) {
        return proxy.ne0(new AtomicInteger(index), property, property.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(int index, SerializableLongSupplier property) {
        return proxy.ne0(new AtomicInteger(index), (Serializable) property, property.get(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(int index, SerializableLongSupplier property, LongPredicate ignoreStrategy) {
        return proxy.ne0(new AtomicInteger(index), property, property.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(int index, SerializableDoubleSupplier property) {
        return proxy.ne0(new AtomicInteger(index), (Serializable) property, property.get(), getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(int index, SerializableDoubleSupplier property, DoublePredicate ignoreStrategy) {
        return proxy.ne0(new AtomicInteger(index), property, property.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L ne(int index, SerializableDateSupplier<R> property) {
        return proxy.ne0(new AtomicInteger(index), property, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> L ne(int index, SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy) {
        return proxy.ne0(new AtomicInteger(index), property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L ne(int index, SerializableNumberSupplier<R> property) {
        return proxy.ne0(new AtomicInteger(index), property, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> L ne(int index, SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy) {
        return proxy.ne0(new AtomicInteger(index), property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L ne(int index, SerializableEnumSupplier<E> property) {
        return proxy.ne0(new AtomicInteger(index), property, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> L ne(int index, SerializableEnumSupplier<E> property, Predicate<E> ignoreStrategy) {
        return proxy.ne0(new AtomicInteger(index), property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(int index, SerializableLocalDateSupplier property) {
        return proxy.ne0(new AtomicInteger(index), property, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(int index, SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return proxy.ne0(new AtomicInteger(index), property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(int index, SerializableLocalTimeSupplier property) {
        return proxy.ne0(new AtomicInteger(index), property, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(int index, SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return proxy.ne0(new AtomicInteger(index), property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(int index, SerializableLocalDateTimeSupplier property) {
        return proxy.ne0(new AtomicInteger(index), property, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(int index, SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return proxy.ne0(new AtomicInteger(index), property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(int index, SerializableStringSupplier property) {
        return proxy.ne0(new AtomicInteger(index), property, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(int index, SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return proxy.ne0(new AtomicInteger(index), property, ignoreStrategy);
    }

}
