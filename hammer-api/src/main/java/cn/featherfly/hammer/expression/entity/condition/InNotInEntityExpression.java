
/*
 * All rights Reserved, Designed By zhongj
 * @Title: Entities.java
 * @Package cn.featherfly.hammer.expression.entity.condition.eq
 * @Description: Entities
 * @author: zhongj
 * @date: 2023-07-18 14:44:18
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.condition;

import java.util.Collection;
import java.util.Date;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableDoubleSupplier;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableIntSupplier;
import cn.featherfly.common.function.serializable.SerializableLongSupplier;
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

/**
 * The Interface InNotInEntityExpression.
 *
 * @author zhongj
 * @param <T> the element type
 */
public interface InNotInEntityExpression<T> {

    /**
     * entity in function int and int array property expression.
     *
     * @param name the name
     * @return entity in function property expression.
     */
    ConditionEntityExpressionIntAndArrayPropertyExpression property(SerializableToIntFunction<T> name);

    /**
     * entity in function property expression.
     *
     * @param name the name
     * @return entity in function property expression.
     */
    ConditionEntityExpressionLongAndArrayPropertyExpression property(SerializableToLongFunction<T> name);

    /**
     * entity in function property expression.
     *
     * @param name the name
     * @return entity in function property expression.
     */
    ConditionEntityExpressionDoubleAndArrayPropertyExpression property(SerializableToDoubleFunction<T> name);

    /**
     * entity in function property expression.
     *
     * @param <N>  the generic type
     * @param name the name
     * @return entity in function property expression.
     */
    <N extends Number> ConditionEntityExpressionNumberAndArrayPropertyExpression<N> property(
            SerializableToNumberFunction<T, N> name);

    /**
     * entity in function property expression.
     *
     * @param <D>  the generic type
     * @param name the name
     * @return entity in function property expression.
     */
    <D extends Date> ConditionEntityExpressionDateAndArrayPropertyExpression<D> property(
            SerializableToDateFunction<T, D> name);

    /**
     * entity in function property expression.
     *
     * @param <E>  the generic type
     * @param name the name
     * @return entity in function property expression.
     */
    <E extends Enum<E>> ConditionEntityExpressionEnumAndArrayPropertyExpression<E> property(
            SerializableToEnumFunction<T, E> name);

    /**
     * entity in function property expression.
     *
     * @param name the name
     * @return entity in function property expression.
     */
    ConditionEntityExpressionLocalDateTimeAndArrayPropertyExpression property(
            SerializableToLocalDateTimeFunction<T> name);

    /**
     * entity in function property expression.
     *
     * @param name the name
     * @return entity in function property expression.
     */
    ConditionEntityExpressionLocalDateAndArrayPropertyExpression property(SerializableToLocalDateFunction<T> name);

    /**
     * entity in function property expression.
     *
     * @param name the name
     * @return entity in function property expression.
     */
    ConditionEntityExpressionLocalTimeAndArrayPropertyExpression property(SerializableToLocalTimeFunction<T> name);

    /**
     * entity in function property expression.
     *
     * @param name the name
     * @return entity in function property expression.
     */
    ConditionEntityExpressionStringAndArrayPropertyExpression property(SerializableToStringFunction<T> name);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param <R>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <R> void accept(SerializableFunction<T, R> name, R value);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param <R>            the generic type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> void accept(SerializableFunction<T, R> name, R value, Predicate<R> ignoreStrategy);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    void accept(SerializableToIntFunction<T> name, int value);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    void accept(SerializableToIntFunction<T> name, int value, IntPredicate ignoreStrategy);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    void accept(SerializableToLongFunction<T> name, long value);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    void accept(SerializableToLongFunction<T> name, long value, LongPredicate ignoreStrategy);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    void accept(SerializableToDoubleFunction<T> name, double value);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    void accept(SerializableToDoubleFunction<T> name, double value, DoublePredicate ignoreStrategy);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param <R>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <R> void accept(SerializableFunction<T, R> name, @SuppressWarnings("unchecked") R... value);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    void accept(SerializableToIntFunction<T> name, int... value);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    void accept(SerializableToLongFunction<T> name, long... value);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param <R>            the generic type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> void accept(SerializableFunction<T, R> name, R[] value, Predicate<R[]> ignoreStrategy);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    void accept(SerializableToIntFunction<T> name, int[] value, Predicate<int[]> ignoreStrategy);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    void accept(SerializableToLongFunction<T> name, long[] value, Predicate<long[]> ignoreStrategy);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param <R>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <R> void accept(SerializableFunction<T, R> name, Collection<R> value);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param <R>            the generic type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> void accept(SerializableFunction<T, R> name, Collection<R> value, Predicate<Collection<R>> ignoreStrategy);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    <R> void accept(SerializableSupplier<R> property);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param <R>            the generic type
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> void accept(SerializableSupplier<R> property, Predicate<R> ignoreStrategy);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    void accept(SerializableIntSupplier property);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    void accept(SerializableIntSupplier property, IntPredicate ignoreStrategy);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    void accept(SerializableLongSupplier property);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    void accept(SerializableLongSupplier property, LongPredicate ignoreStrategy);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    void accept(SerializableDoubleSupplier property);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    void accept(SerializableDoubleSupplier property, DoublePredicate ignoreStrategy);
}
