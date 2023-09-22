
/*
 * All rights Reserved, Designed By zhongj
 * @Title: EqualsEntityExpressionImpl.java
 * @Package cn.featherfly.hammer.expression.entity.condition.eq
 * @Description: EqualsEntityExpressionImpl
 * @author: zhongj
 * @date: 2023-08-07 17:41:07
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.condition.nba;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

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
import cn.featherfly.hammer.expression.entity.condition.AbstractConditionEntityExpression;

/**
 * The Class AbstractNotBetweenEntityExpression.
 *
 * @author zhongj
 * @param <T> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public abstract class AbstractNotBetweenEntityExpression<T, C extends ConditionExpression,
        L extends LogicExpression<C, L>>
        extends AbstractConditionEntityExpression<MulitiEntityNotBetweenExpression<C, L>>
        implements NotBetweenEntityExpression<T> {

    /**
     * Instantiates a new abstract not between entity expression.
     *
     * @param index          the index
     * @param expression     the expression
     * @param ignoreStrategy the ignore strategy
     */
    protected AbstractNotBetweenEntityExpression(int index, MulitiEntityNotBetweenExpression<C, L> expression,
            Predicate<?> ignoreStrategy) {
        super(index, expression, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToIntFunction<T> name, int min, int max) {
        expression.nba(index, name, min, max);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToIntFunction<T> name, int min, int max,
            BiPredicate<Integer, Integer> ignoreStrategy) {
        expression.nba(index, name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToLongFunction<T> name, long min, long max) {
        expression.nba(index, name, min, max);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToLongFunction<T> name, long min, long max, BiPredicate<Long, Long> ignoreStrategy) {
        expression.nba(index, name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToDoubleFunction<T> name, double min, double max) {
        expression.nba(index, name, min, max);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToDoubleFunction<T> name, double min, double max,
            BiPredicate<Double, Double> ignoreStrategy) {
        expression.nba(index, name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> void accept(SerializableToNumberFunction<T, N> name, N min, N max) {
        expression.nba(index, name, min, max);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> void accept(SerializableToNumberFunction<T, N> name, N min, N max,
            BiPredicate<N, N> ignoreStrategy) {
        expression.nba(index, name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> void accept(SerializableToDateFunction<T, D> name, D min, D max) {
        expression.nba(index, name, min, max);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> void accept(SerializableToDateFunction<T, D> name, D min, D max,
            BiPredicate<D, D> ignoreStrategy) {
        expression.nba(index, name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> void accept(SerializableToEnumFunction<T, E> name, E min, E max) {
        expression.nba(index, name, min, max);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> void accept(SerializableToEnumFunction<T, E> name, E min, E max,
            BiPredicate<E, E> ignoreStrategy) {
        expression.nba(index, name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToLocalTimeFunction<T> name, LocalTime min, LocalTime max) {
        expression.nba(index, name, min, max);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToLocalTimeFunction<T> name, LocalTime min, LocalTime max,
            BiPredicate<LocalTime, LocalTime> ignoreStrategy) {
        expression.nba(index, name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToLocalDateFunction<T> name, LocalDate min, LocalDate max) {
        expression.nba(index, name, min, max);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToLocalDateFunction<T> name, LocalDate min, LocalDate max,
            BiPredicate<LocalDate, LocalDate> ignoreStrategy) {
        expression.nba(index, name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToLocalDateTimeFunction<T> name, LocalDateTime min, LocalDateTime max) {
        expression.nba(index, name, min, max);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToLocalDateTimeFunction<T> name, LocalDateTime min, LocalDateTime max,
            BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {
        expression.nba(index, name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToStringFunction<T> name, String min, String max) {
        expression.nba(index, name, min, max);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToStringFunction<T> name, String min, String max,
            BiPredicate<String, String> ignoreStrategy) {
        expression.nba(index, name, min, max, ignoreStrategy);
    }
}
