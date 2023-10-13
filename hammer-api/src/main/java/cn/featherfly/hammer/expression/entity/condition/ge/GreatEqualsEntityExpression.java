
/*
 * All rights Reserved, Designed By zhongj
 * @Title: Entities.java
 * @Package cn.featherfly.hammer.expression.entity.condition.eq
 * @Description: Entities
 * @author: zhongj
 * @date: 2023-07-18 14:44:18
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.condition.ge;

import cn.featherfly.hammer.expression.entity.condition.CompareEntityExpression;

/**
 * The Interface GreatEqualsEntityExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface GreatEqualsEntityExpression<E>
        extends CompareEntityExpression<E>, GreatEqualsEntityPropertyExpression<E> {

    //    /**
    //     * entity great equals function property expression.
    //     *
    //     * @param <R>  the generic type
    //     * @param name the name
    //     * @return entity great equals function property expression.
    //     */
    //    <R> EntityConditionFunctionIntPropertyExpression<E, C, L> property(SerializableToIntFunction<E> name);
    //
    //    /**
    //     * entity great equals function property expression.
    //     *
    //     * @param <R>  the generic type
    //     * @param name the name
    //     * @return entity great equals function property expression.
    //     */
    //    <R> EntityConditionFunctionLongPropertyExpression<E, C, L> property(SerializableToLongFunction<E> name);
    //
    //    /**
    //     * entity great equals function property expression.
    //     *
    //     * @param <R>  the generic type
    //     * @param name the name
    //     * @return entity great equals function property expression.
    //     */
    //    <R> EntityConditionFunctionDoublePropertyExpression<E, C, L> property(SerializableToDoubleFunction<E> name);
    //
    //    /**
    //     * entity great equals function property expression.
    //     *
    //     * @param <R>  the generic type
    //     * @param name the name
    //     * @return entity great equals function property expression.
    //     */
    //    <R extends Date> EntityGreatEqualsFunctionPropertyValueExpression<E, R, C, L> property(
    //            SerializableToDateFunction<E, R> name);
    //
    //    /**
    //     * entity great equals function property expression.
    //     *
    //     * @param <R>  the generic type
    //     * @param name the name
    //     * @return entity great equals function property expression.
    //     */
    //    EntityGreatEqualsFunctionPropertyValueExpression<E, LocalDate, C, L> property(SerializableToLocalDateFunction<E> name);
    //
    //    /**
    //     * entity great equals function property expression.
    //     *
    //     * @param <R>  the generic type
    //     * @param name the name
    //     * @return entity great equals function property expression.
    //     */
    //    EntityGreatEqualsFunctionPropertyValueExpression<E, LocalTime, C, L> property(SerializableToLocalTimeFunction<E> name);
    //
    //    /**
    //     * entity great equals function property expression.
    //     *
    //     * @param <R>  the generic type
    //     * @param name the name
    //     * @return entity great equals function property expression.
    //     */
    //    EntityGreatEqualsFunctionPropertyValueExpression<E, LocalDateTime, C, L> property(
    //            SerializableToLocalDateTimeFunction<E> name);
    //
    //    /**
    //     * entity great equals function property expression.
    //     *
    //     * @param <R>  the generic type
    //     * @param name the name
    //     * @return entity great equals function property expression.
    //     */
    //    EntityGreatEqualsFunctionPropertyValueExpression<E, String, C, L> property(SerializableToStringFunction<E> name);
    //
    //    /**
    //     * entity great equals function property expression.
    //     *
    //     * @param <R>  the generic type
    //     * @param name the name
    //     * @return entity great equals function property expression.
    //     */
    //    <R extends Number> EntityGreatEqualsFunctionPropertyValueExpression<E, R, C, L> property(
    //            SerializableToNumberFunction<E, R> name);
    //
    //    /**
    //     * entity great equals function property expression.
    //     *
    //     * @param <R>  the generic type
    //     * @param name the name
    //     * @return entity great equals function property expression.
    //     */
    //    <R> EntityGreatEqualsFunctionPropertyExpression<R, C, L> property(SerializableFunction<E, R> name);

    //    /**
    //     * great and equals. 大于等于.
    //     *
    //     * @param name  参数名称
    //     * @param value 参数值
    //     * @return LogicExpression
    //     */
    //    void accept(SerializableToIntFunction<E> name, int value);
    //
    //    /**
    //     * great and equals. 大于等于.
    //     *
    //     * @param name         参数名称
    //     * @param value        参数值
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    void accept(SerializableToIntFunction<E> name, int value, Predicate<Integer> ignoreStrategy);
    //
    //    /**
    //     * great and equals. 大于等于.
    //     *
    //     * @param name  参数名称
    //     * @param value 参数值
    //     * @return LogicExpression
    //     */
    //    void accept(SerializableToLongFunction<E> name, long value);
    //
    //    /**
    //     * great and equals. 大于等于.
    //     *
    //     * @param name         参数名称
    //     * @param value        参数值
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    void accept(SerializableToLongFunction<E> name, long value, Predicate<Integer> ignoreStrategy);
    //
    //    /**
    //     * great and equals. 大于等于.
    //     *
    //     * @param name  参数名称
    //     * @param value 参数值
    //     * @return LogicExpression
    //     */
    //    void accept(SerializableToDoubleFunction<E> name, double value);
    //
    //    /**
    //     * great and equals. 大于等于.
    //     *
    //     * @param name         参数名称
    //     * @param value        参数值
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    void accept(SerializableToDoubleFunction<E> name, double value, Predicate<Double> ignoreStrategy);
    //
    //    /**
    //     * great and equals. 大于等于.
    //     *
    //     * @param <N>   number type
    //     * @param name  参数名称
    //     * @param value 参数值
    //     * @return LogicExpression
    //     */
    //    <N extends Number> void accept(SerializableFunction<E, N> name, N value);
    //
    //    /**
    //     * great and equals. 大于等于.
    //     *
    //     * @param <N>          number type
    //     * @param name         参数名称
    //     * @param value        参数值
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    <N extends Number> void accept(SerializableFunction<E, N> name, N value, Predicate<N> ignoreStrategy);
    //
    //    /**
    //     * great and equals. 大于等于.
    //     *
    //     * @param <D>   date type
    //     * @param name  参数名称
    //     * @param value 参数值
    //     * @return LogicExpression
    //     */
    //    <D extends Date> void accept(SerializableFunction<E, D> name, D value);
    //
    //    /**
    //     * great and equals. 大于等于.
    //     *
    //     * @param <D>          date type
    //     * @param name         参数名称
    //     * @param value        参数值
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    <D extends Date> void accept(SerializableFunction<E, D> name, D value, Predicate<D> ignoreStrategy);
    //
    //    /**
    //     * great and equals. 大于等于.
    //     *
    //     * @param name  参数名称
    //     * @param value 参数值
    //     * @return LogicExpression
    //     */
    //    void accept(SerializableFunction<E, LocalTime> name, LocalTime value);
    //
    //    /**
    //     * great and equals. 大于等于.
    //     *
    //     * @param name         参数名称
    //     * @param value        参数值
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    void accept(SerializableFunction<E, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy);
    //
    //    /**
    //     * great and equals. 大于等于.
    //     *
    //     * @param name  参数名称
    //     * @param value 参数值
    //     * @return LogicExpression
    //     */
    //    void accept(SerializableFunction<E, LocalDate> name, LocalDate value);
    //
    //    /**
    //     * great and equals. 大于等于.
    //     *
    //     * @param name         参数名称
    //     * @param value        参数值
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    void accept(SerializableFunction<E, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy);
    //
    //    /**
    //     * great and equals. 大于等于.
    //     *
    //     * @param name  参数名称
    //     * @param value 参数值
    //     * @return LogicExpression
    //     */
    //    void accept(SerializableFunction<E, LocalDateTime> name, LocalDateTime value);
    //
    //    /**
    //     * great and equals. 大于等于.
    //     *
    //     * @param name         参数名称
    //     * @param value        参数值
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    void accept(SerializableFunction<E, LocalDateTime> name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy);
    //
    //    /**
    //     * great and equals. 大于等于.
    //     *
    //     * @param name  参数名称
    //     * @param value 参数值
    //     * @return LogicExpression
    //     */
    //    void accept(SerializableFunction<E, String> name, String value);
    //
    //    /**
    //     * great and equals. 大于等于.
    //     *
    //     * @param name         参数名称
    //     * @param value        参数值
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    void accept(SerializableFunction<E, String> name, String value, Predicate<String> ignoreStrategy);
    //
    //    /**
    //     * great and equals. 大于等于.
    //     *
    //     * @param property 对象属性
    //     * @return LogicExpression
    //     */
    //    void accept(SerializableIntSupplier property);
    //
    //    /**
    //     * great and equals. 大于等于.
    //     *
    //     * @param property     对象属性
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    void accept(SerializableIntSupplier property, Predicate<Integer> ignoreStrategy);
    //
    //    /**
    //     * great and equals. 大于等于.
    //     *
    //     * @param property 对象属性
    //     * @return LogicExpression
    //     */
    //    void accept(SerializableLongSupplier property);
    //
    //    /**
    //     * great and equals. 大于等于.
    //     *
    //     * @param property     对象属性
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    void accept(SerializableLongSupplier property, Predicate<Long> ignoreStrategy);
    //
    //    /**
    //     * great and equals. 大于等于.
    //     *
    //     * @param property 对象属性
    //     * @return LogicExpression
    //     */
    //    void accept(SerializableDoubleSupplier property);
    //
    //    /**
    //     * great and equals. 大于等于.
    //     *
    //     * @param property     对象属性
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    void accept(SerializableDoubleSupplier property, Predicate<Double> ignoreStrategy);
    //
    //    /**
    //     * great and equals. 大于等于.
    //     *
    //     * @param <R>      the generic type
    //     * @param property 对象属性
    //     * @return LogicExpression
    //     */
    //    <R extends Date> void accept(SerializableDateSupplier<R> property);
    //
    //    /**
    //     * great and equals. 大于等于.
    //     *
    //     * @param <R>          the generic type
    //     * @param property     对象属性
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    <R extends Date> void accept(SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy);
    //
    //    /**
    //     * great and equals. 大于等于.
    //     *
    //     * @param <R>      the generic type
    //     * @param property 对象属性
    //     * @return LogicExpression
    //     */
    //    <R extends Number> void accept(SerializableNumberSupplier<R> property);
    //
    //    /**
    //     * great and equals. 大于等于.
    //     *
    //     * @param <R>          the generic type
    //     * @param property     对象属性
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    <R extends Number> void accept(SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy);
    //
    //    /**
    //     * great and equals. 大于等于.
    //     *
    //     * @param property 对象属性
    //     * @return LogicExpression
    //     */
    //    void accept(SerializableLocalDateSupplier property);
    //
    //    /**
    //     * great and equals. 大于等于.
    //     *
    //     * @param property     对象属性
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    void accept(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy);
    //
    //    /**
    //     * great and equals. 大于等于.
    //     *
    //     * @param property 对象属性
    //     * @return LogicExpression
    //     */
    //    void accept(SerializableLocalTimeSupplier property);
    //
    //    /**
    //     * great and equals. 大于等于.
    //     *
    //     * @param property     对象属性
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    void accept(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy);
    //
    //    /**
    //     * great and equals. 大于等于.
    //     *
    //     * @param property 对象属性
    //     * @return LogicExpression
    //     */
    //    void accept(SerializableLocalDateTimeSupplier property);
    //
    //    /**
    //     * great and equals. 大于等于.
    //     *
    //     * @param property     对象属性
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    void accept(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy);
    //
    //    /**
    //     * great and equals. 大于等于.
    //     *
    //     * @param property 对象属性
    //     * @return LogicExpression
    //     */
    //    void accept(SerializableStringSupplier property);
    //
    //    /**
    //     * great and equals. 大于等于.
    //     *
    //     * @param property     对象属性
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    void accept(SerializableStringSupplier property, Predicate<String> ignoreStrategy);
}
