
/*
 * All rights Reserved, Designed By zhongj
 * @Title: Entities.java
 * @Package cn.featherfly.hammer.expression.entity.condition.eq
 * @Description: Entities
 * @author: zhongj
 * @date: 2023-07-18 14:44:18
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.condition.gt;

import cn.featherfly.hammer.expression.entity.condition.CompareEntityExpression;

/**
 * The Interface GreatThanEntityExpression. great than. 大于.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface GreatThanEntityExpression<E> extends CompareEntityExpression<E>, GreatThanEntityPropertyExpression<E> {

    //    /**
    //     * great than. 大于.
    //     *
    //     * @param name  参数名称
    //     * @param value 参数值
    //     * @return LogicExpression
    //     */
    //    void accept(SerializableToIntFunction<E> name, int value);
    //
    //    /**
    //     * great than. 大于.
    //     *
    //     * @param name         参数名称
    //     * @param value        参数值
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    void accept(SerializableToIntFunction<E> name, int value, Predicate<Integer> ignoreStrategy);
    //
    //    /**
    //     * great than. 大于.
    //     *
    //     * @param name  参数名称
    //     * @param value 参数值
    //     * @return LogicExpression
    //     */
    //    void accept(SerializableToLongFunction<E> name, long value);
    //
    //    /**
    //     * great than. 大于.
    //     *
    //     * @param name         参数名称
    //     * @param value        参数值
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    void accept(SerializableToLongFunction<E> name, long value, Predicate<Integer> ignoreStrategy);
    //
    //    /**
    //     * great than. 大于.
    //     *
    //     * @param name  参数名称
    //     * @param value 参数值
    //     * @return LogicExpression
    //     */
    //    void accept(SerializableToDoubleFunction<E> name, double value);
    //
    //    /**
    //     * great than. 大于.
    //     *
    //     * @param name         参数名称
    //     * @param value        参数值
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    void accept(SerializableToDoubleFunction<E> name, double value, Predicate<Double> ignoreStrategy);
    //
    //    /**
    //     * great than. 大于.
    //     *
    //     * @param <N>   number type
    //     * @param name  参数名称
    //     * @param value 参数值
    //     * @return LogicExpression
    //     */
    //    <N extends Number> void accept(SerializableFunction<E, N> name, N value);
    //
    //    /**
    //     * great than. 大于.
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
    //     * great than. 大于.
    //     *
    //     * @param <D>   date type
    //     * @param name  参数名称
    //     * @param value 参数值
    //     * @return LogicExpression
    //     */
    //    <D extends Date> void accept(SerializableFunction<E, D> name, D value);
    //
    //    /**
    //     * great than. 大于.
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
    //     * great than. 大于.
    //     *
    //     * @param name  参数名称
    //     * @param value 参数值
    //     * @return LogicExpression
    //     */
    //    void accept(SerializableFunction<E, LocalTime> name, LocalTime value);
    //
    //    /**
    //     * great than. 大于.
    //     *
    //     * @param name         参数名称
    //     * @param value        参数值
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    void accept(SerializableFunction<E, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy);
    //
    //    /**
    //     * great than. 大于.
    //     *
    //     * @param name  参数名称
    //     * @param value 参数值
    //     * @return LogicExpression
    //     */
    //    void accept(SerializableFunction<E, LocalDate> name, LocalDate value);
    //
    //    /**
    //     * great than. 大于.
    //     *
    //     * @param name         参数名称
    //     * @param value        参数值
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    void accept(SerializableFunction<E, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy);
    //
    //    /**
    //     * great than. 大于.
    //     *
    //     * @param name  参数名称
    //     * @param value 参数值
    //     * @return LogicExpression
    //     */
    //    void accept(SerializableFunction<E, LocalDateTime> name, LocalDateTime value);
    //
    //    /**
    //     * great than. 大于.
    //     *
    //     * @param name         参数名称
    //     * @param value        参数值
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    void accept(SerializableFunction<E, LocalDateTime> name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy);
    //
    //    /**
    //     * great than. 大于.
    //     *
    //     * @param name  参数名称
    //     * @param value 参数值
    //     * @return LogicExpression
    //     */
    //    void accept(SerializableFunction<E, String> name, String value);
    //
    //    /**
    //     * great than. 大于.
    //     *
    //     * @param name         参数名称
    //     * @param value        参数值
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    void accept(SerializableFunction<E, String> name, String value, Predicate<String> ignoreStrategy);
    //
    //    /**
    //     * great than. 大于.
    //     *
    //     * @param property 对象属性
    //     * @return LogicExpression
    //     */
    //    void accept(SerializableIntSupplier property);
    //
    //    /**
    //     * great than. 大于.
    //     *
    //     * @param property     对象属性
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    void accept(SerializableIntSupplier property, Predicate<Integer> ignoreStrategy);
    //
    //    /**
    //     * great than. 大于.
    //     *
    //     * @param property 对象属性
    //     * @return LogicExpression
    //     */
    //    void accept(SerializableLongSupplier property);
    //
    //    /**
    //     * great than. 大于.
    //     *
    //     * @param property     对象属性
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    void accept(SerializableLongSupplier property, Predicate<Long> ignoreStrategy);
    //
    //    /**
    //     * great than. 大于.
    //     *
    //     * @param property 对象属性
    //     * @return LogicExpression
    //     */
    //    void accept(SerializableDoubleSupplier property);
    //
    //    /**
    //     * great than. 大于.
    //     *
    //     * @param property     对象属性
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    void accept(SerializableDoubleSupplier property, Predicate<Double> ignoreStrategy);
    //
    //    /**
    //     * great than. 大于.
    //     *
    //     * @param <R>      the generic type
    //     * @param property 对象属性
    //     * @return LogicExpression
    //     */
    //    <R extends Date> void accept(DateSupplier<R> property);
    //
    //    /**
    //     * great than. 大于.
    //     *
    //     * @param <R>          the generic type
    //     * @param property     对象属性
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    <R extends Date> void accept(DateSupplier<R> property, Predicate<R> ignoreStrategy);
    //
    //    /**
    //     * great than. 大于.
    //     *
    //     * @param <R>      the generic type
    //     * @param property 对象属性
    //     * @return LogicExpression
    //     */
    //    <R extends Number> void accept(NumberSupplier<R> property);
    //
    //    /**
    //     * great than. 大于.
    //     *
    //     * @param <R>          the generic type
    //     * @param property     对象属性
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    <R extends Number> void accept(NumberSupplier<R> property, Predicate<R> ignoreStrategy);
    //
    //    /**
    //     * great than. 大于.
    //     *
    //     * @param property 对象属性
    //     * @return LogicExpression
    //     */
    //    void accept(LocalDateSupplier property);
    //
    //    /**
    //     * great than. 大于.
    //     *
    //     * @param property     对象属性
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    void accept(LocalDateSupplier property, Predicate<LocalDate> ignoreStrategy);
    //
    //    /**
    //     * great than. 大于.
    //     *
    //     * @param property 对象属性
    //     * @return LogicExpression
    //     */
    //    void accept(LocalTimeSupplier property);
    //
    //    /**
    //     * great than. 大于.
    //     *
    //     * @param property     对象属性
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    void accept(LocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy);
    //
    //    /**
    //     * great than. 大于.
    //     *
    //     * @param property 对象属性
    //     * @return LogicExpression
    //     */
    //    void accept(LocalDateTimeSupplier property);
    //
    //    /**
    //     * great than. 大于.
    //     *
    //     * @param property     对象属性
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    void accept(LocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy);
    //
    //    /**
    //     * great than. 大于.
    //     *
    //     * @param property 对象属性
    //     * @return LogicExpression
    //     */
    //    void accept(StringSupplier property);
    //
    //    /**
    //     * great than. 大于.
    //     *
    //     * @param property     对象属性
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    void accept(StringSupplier property, Predicate<String> ignoreStrategy);
}
