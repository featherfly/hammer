
/*
 * All rights Reserved, Designed By zhongj
 * @Title: EqualsEntityExpressionImpl.java
 * @Package cn.featherfly.hammer.expression.entity.condition.eq
 * @Description: EqualsEntityExpressionImpl
 * @author: zhongj
 * @date: 2023-08-07 17:41:07
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.condition.lt;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;
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
import cn.featherfly.common.lang.function.SerializableToCollectionFunction;
import cn.featherfly.common.lang.function.SerializableToDateFunction;
import cn.featherfly.common.lang.function.SerializableToDoubleFunction;
import cn.featherfly.common.lang.function.SerializableToEnumFunction;
import cn.featherfly.common.lang.function.SerializableToIntFunction;
import cn.featherfly.common.lang.function.SerializableToLocalDateFunction;
import cn.featherfly.common.lang.function.SerializableToLocalDateTimeFunction;
import cn.featherfly.common.lang.function.SerializableToLocalTimeFunction;
import cn.featherfly.common.lang.function.SerializableToLongFunction;
import cn.featherfly.common.lang.function.SerializableToNumberFunction;
import cn.featherfly.common.lang.function.SerializableToStringFunction;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.AbstractConditionEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.CompareEntityPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionDatePropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionDoublePropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionEnumPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionIntPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionLocalDatePropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionLocalDateTimePropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionLocalTimePropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionLongPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionNumberPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionStringPropertyExpression;

/**
 * The Class LessThanEntityExpressionImpl.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class LessThanEntityExpressionImpl<E, C extends ConditionExpression, L extends LogicExpression<C, L>> extends
        AbstractConditionEntityExpression<MulitiEntityLessThanExpression<C, L>> implements LessThanEntityExpression<E> {

    /**
     * Instantiates a new great equals entity expression impl.
     *
     * @param index      the index
     * @param expression the expression
     */
    public LessThanEntityExpressionImpl(int index, MulitiEntityLessThanExpression<C, L> expression) {
        super(index, expression);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToIntFunction<E> name, int value) {
        expression.lt(index, name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToIntFunction<E> name, int value, Predicate<Integer> ignoreStrategy) {
        expression.lt(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToLongFunction<E> name, long value) {
        expression.lt(index, name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToLongFunction<E> name, long value, Predicate<Long> ignoreStrategy) {
        expression.lt(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToDoubleFunction<E> name, double value) {
        expression.lt(index, name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToDoubleFunction<E> name, double value, Predicate<Double> ignoreStrategy) {
        expression.lt(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> void accept(SerializableFunction<E, N> name, N value) {
        expression.lt(index, name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> void accept(SerializableFunction<E, N> name, N value, Predicate<N> ignoreStrategy) {
        expression.lt(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> void accept(SerializableFunction<E, D> name, D value) {
        expression.lt(index, name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> void accept(SerializableFunction<E, D> name, D value, Predicate<D> ignoreStrategy) {
        expression.lt(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableFunction<E, LocalTime> name, LocalTime value) {
        expression.lt(index, name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableFunction<E, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        expression.lt(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableFunction<E, LocalDate> name, LocalDate value) {
        expression.lt(index, name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableFunction<E, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        expression.lt(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableFunction<E, LocalDateTime> name, LocalDateTime value) {
        expression.lt(index, name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableFunction<E, LocalDateTime> name, LocalDateTime value,
            Predicate<LocalDateTime> ignoreStrategy) {
        expression.lt(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableFunction<E, String> name, String value) {
        expression.lt(index, name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableFunction<E, String> name, String value, Predicate<String> ignoreStrategy) {
        expression.lt(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableIntSupplier property) {
        expression.lt(index, property);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableIntSupplier property, Predicate<Integer> ignoreStrategy) {
        expression.lt(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableLongSupplier property) {
        expression.lt(index, property);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableLongSupplier property, Predicate<Long> ignoreStrategy) {
        expression.lt(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableDoubleSupplier property) {
        expression.lt(index, property);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableDoubleSupplier property, Predicate<Double> ignoreStrategy) {
        expression.lt(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> void accept(SerializableDateSupplier<R> property) {
        expression.lt(index, property);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> void accept(SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy) {
        expression.lt(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> void accept(SerializableNumberSupplier<R> property) {
        expression.lt(index, property);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> void accept(SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy) {
        expression.lt(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableLocalDateSupplier property) {
        expression.lt(index, property);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        expression.lt(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableLocalTimeSupplier property) {
        expression.lt(index, property);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        expression.lt(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableLocalDateTimeSupplier property) {
        expression.lt(index, property);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        expression.lt(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableStringSupplier property) {
        expression.lt(index, property);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        expression.lt(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> CompareEntityPropertyExpression<R> property(SerializableFunction<E, R> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Collection<RE>,
            RE> CompareEntityPropertyExpression<RE> property(SerializableToCollectionFunction<E, R, RE> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> ConditionEntityExpressionIntPropertyExpression property(SerializableToIntFunction<E> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> ConditionEntityExpressionLongPropertyExpression property(SerializableToLongFunction<E> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> ConditionEntityExpressionDoublePropertyExpression property(SerializableToDoubleFunction<E> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> ConditionEntityExpressionDatePropertyExpression<R> property(
            SerializableToDateFunction<E, R> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConditionEntityExpressionLocalDatePropertyExpression property(SerializableToLocalDateFunction<E> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConditionEntityExpressionLocalTimePropertyExpression property(SerializableToLocalTimeFunction<E> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConditionEntityExpressionLocalDateTimePropertyExpression property(
            SerializableToLocalDateTimeFunction<E> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> ConditionEntityExpressionNumberPropertyExpression<R> property(
            SerializableToNumberFunction<E, R> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Enum<R>> ConditionEntityExpressionEnumPropertyExpression<R> property(
            SerializableToEnumFunction<E, R> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConditionEntityExpressionStringPropertyExpression property(SerializableToStringFunction<E> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

}
