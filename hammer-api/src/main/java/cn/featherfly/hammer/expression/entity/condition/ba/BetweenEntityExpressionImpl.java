
/*
 * All rights Reserved, Designed By zhongj
 * @Title: EqualsEntityExpressionImpl.java
 * @Package cn.featherfly.hammer.expression.entity.condition.eq
 * @Description: EqualsEntityExpressionImpl
 * @author: zhongj
 * @date: 2023-08-07 17:41:07
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.condition.ba;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;
import java.util.Date;
import java.util.function.BiPredicate;

import cn.featherfly.common.exception.NotImplementedException;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableToCollectionFunction;
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
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionDatePropertyExpression2;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionDoublePropertyExpression2;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionEnumPropertyExpression2;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionIntPropertyExpression2;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionLocalDatePropertyExpression2;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionLocalDateTimePropertyExpression2;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionLocalTimePropertyExpression2;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionLongPropertyExpression2;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionNumberPropertyExpression2;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionStringPropertyExpression2;

/**
 * The Class BetweenEntityExpressionImpl.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class BetweenEntityExpressionImpl<E, C extends ConditionExpression, L extends LogicExpression<C, L>> extends
        AbstractConditionEntityExpression<MulitiEntityBetweenExpression<C, L>> implements BetweenEntityExpression<E> {

    /**
     * Instantiates a new great equals entity expression impl.
     *
     * @param index      the index
     * @param expression the expression
     */
    public BetweenEntityExpressionImpl(int index, MulitiEntityBetweenExpression<C, L> expression) {
        super(index, expression);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToIntFunction<E> name, int min, int max) {
        expression.ba(index, name, min, max);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToIntFunction<E> name, int min, int max,
            BiPredicate<Integer, Integer> ignoreStrategy) {
        expression.ba(index, name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToLongFunction<E> name, long min, long max) {
        expression.ba(index, name, min, max);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToLongFunction<E> name, long min, long max, BiPredicate<Long, Long> ignoreStrategy) {
        expression.ba(index, name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToDoubleFunction<E> name, double min, double max) {
        expression.ba(index, name, min, max);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToDoubleFunction<E> name, double min, double max,
            BiPredicate<Double, Double> ignoreStrategy) {
        expression.ba(index, name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> void accept(SerializableFunction<E, N> name, N min, N max) {
        expression.ba(index, name, min, max);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> void accept(SerializableFunction<E, N> name, N min, N max,
            BiPredicate<N, N> ignoreStrategy) {
        expression.ba(index, name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> void accept(SerializableFunction<E, D> name, D min, D max) {
        expression.ba(index, name, min, max);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> void accept(SerializableFunction<E, D> name, D min, D max,
            BiPredicate<D, D> ignoreStrategy) {
        expression.ba(index, name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableFunction<E, LocalTime> name, LocalTime min, LocalTime max) {
        expression.ba(index, name, min, max);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableFunction<E, LocalTime> name, LocalTime min, LocalTime max,
            BiPredicate<LocalTime, LocalTime> ignoreStrategy) {
        expression.ba(index, name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableFunction<E, LocalDate> name, LocalDate min, LocalDate max) {
        expression.ba(index, name, min, max);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableFunction<E, LocalDate> name, LocalDate min, LocalDate max,
            BiPredicate<LocalDate, LocalDate> ignoreStrategy) {
        expression.ba(index, name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableFunction<E, LocalDateTime> name, LocalDateTime min, LocalDateTime max) {
        expression.ba(index, name, min, max);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableFunction<E, LocalDateTime> name, LocalDateTime min, LocalDateTime max,
            BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {
        expression.ba(index, name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableFunction<E, String> name, String min, String max) {
        expression.ba(index, name, min, max);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableFunction<E, String> name, String min, String max,
            BiPredicate<String, String> ignoreStrategy) {
        expression.ba(index, name, min, max, ignoreStrategy);
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public void accept(SerializableIntSupplier propertyMin, SerializableIntSupplier propertyMax) {
    //        expression.ba(index, propertyMin, propertyMax);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public void accept(SerializableIntSupplier propertyMin, SerializableIntSupplier propertyMax,
    //            BiPredicate<Integer, Integer> ignoreStrategy) {
    //        expression.ba(index, propertyMin, propertyMax, ignoreStrategy);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public void accept(SerializableLongSupplier propertyMin, SerializableLongSupplier propertyMax) {
    //        expression.ba(index, propertyMin, propertyMax);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public void accept(SerializableLongSupplier propertyMin, SerializableLongSupplier propertyMax,
    //            BiPredicate<Long, Long> ignoreStrategy) {
    //        expression.ba(index, propertyMin, propertyMax, ignoreStrategy);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public void accept(SerializableDoubleSupplier propertyMin, SerializableDoubleSupplier propertyMax) {
    //        expression.ba(index, propertyMin, propertyMax);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public void accept(SerializableDoubleSupplier propertyMin, SerializableDoubleSupplier propertyMax,
    //            BiPredicate<Double, Double> ignoreStrategy) {
    //        expression.ba(index, propertyMin, propertyMax, ignoreStrategy);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <R extends Date> void accept(SerializableDateSupplier<R> propertyMin,
    //            SerializableDateSupplier<R> propertyMax) {
    //        expression.ba(index, propertyMin, propertyMax);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <D extends Date> void accept(SerializableDateSupplier<D> propertyMin,
    //            SerializableDateSupplier<D> propertyMax, BiPredicate<D, D> ignoreStrategy) {
    //        expression.ba(index, propertyMin, propertyMax, ignoreStrategy);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <N extends Number> void accept(SerializableNumberSupplier<N> propertyMin,
    //            SerializableNumberSupplier<N> propertyMax) {
    //        expression.ba(index, propertyMin, propertyMax);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <N extends Number> void accept(SerializableNumberSupplier<N> propertyMin,
    //            SerializableNumberSupplier<N> propertyMax, BiPredicate<N, N> ignoreStrategy) {
    //        expression.ba(index, propertyMin, propertyMax, ignoreStrategy);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public void accept(SerializableLocalDateSupplier propertyMin, SerializableLocalDateSupplier propertyMax) {
    //        expression.ba(index, propertyMin, propertyMax);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public void accept(SerializableLocalDateSupplier propertyMin, SerializableLocalDateSupplier propertyMax,
    //            BiPredicate<LocalDate, LocalDate> ignoreStrategy) {
    //        expression.ba(index, propertyMin, propertyMax, ignoreStrategy);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public void accept(SerializableLocalTimeSupplier propertyMin, SerializableLocalTimeSupplier propertyMax) {
    //        expression.ba(index, propertyMin, propertyMax);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public void accept(SerializableLocalTimeSupplier propertyMin, SerializableLocalTimeSupplier propertyMax,
    //            BiPredicate<LocalTime, LocalTime> ignoreStrategy) {
    //        expression.ba(index, propertyMin, propertyMax, ignoreStrategy);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public void accept(SerializableLocalDateTimeSupplier propertyMin, SerializableLocalDateTimeSupplier propertyMax) {
    //        expression.ba(index, propertyMin, propertyMax);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public void accept(SerializableLocalDateTimeSupplier propertyMin, SerializableLocalDateTimeSupplier propertyMax,
    //            BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {
    //        expression.ba(index, propertyMin, propertyMax, ignoreStrategy);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public void accept(SerializableStringSupplier propertyMin, SerializableStringSupplier propertyMax) {
    //        expression.ba(index, propertyMin, propertyMax);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public void accept(SerializableStringSupplier propertyMin, SerializableStringSupplier propertyMax,
    //            BiPredicate<String, String> ignoreStrategy) {
    //        expression.ba(index, propertyMin, propertyMax, ignoreStrategy);
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> BetweenEntityPropertyExpression<R> property(SerializableFunction<E, R> name) {
        // IMPLSOON 未实现property
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Collection<RE>,
            RE> BetweenEntityPropertyExpression<RE> property(SerializableToCollectionFunction<E, R, RE> name) {
        // IMPLSOON 未实现property
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> ConditionEntityExpressionIntPropertyExpression2 property(SerializableToIntFunction<E> name) {
        // IMPLSOON 未实现property
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> ConditionEntityExpressionLongPropertyExpression2 property(SerializableToLongFunction<E> name) {
        // IMPLSOON 未实现property
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> ConditionEntityExpressionDoublePropertyExpression2 property(SerializableToDoubleFunction<E> name) {
        // IMPLSOON 未实现property
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> ConditionEntityExpressionDatePropertyExpression2<R> property(
            SerializableToDateFunction<E, R> name) {
        // IMPLSOON 未实现property
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConditionEntityExpressionLocalDatePropertyExpression2 property(SerializableToLocalDateFunction<E> name) {
        // IMPLSOON 未实现property
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConditionEntityExpressionLocalTimePropertyExpression2 property(SerializableToLocalTimeFunction<E> name) {
        // IMPLSOON 未实现property
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConditionEntityExpressionLocalDateTimePropertyExpression2 property(
            SerializableToLocalDateTimeFunction<E> name) {
        // IMPLSOON 未实现property
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> ConditionEntityExpressionNumberPropertyExpression2<R> property(
            SerializableToNumberFunction<E, R> name) {
        // IMPLSOON 未实现property
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Enum<R>> ConditionEntityExpressionEnumPropertyExpression2<R> property(
            SerializableToEnumFunction<E, R> name) {
        // IMPLSOON 未实现property
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConditionEntityExpressionStringPropertyExpression2 property(SerializableToStringFunction<E> name) {
        // IMPLSOON 未实现property
        throw new NotImplementedException();
    }

}
