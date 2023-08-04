
/*
 * All rights Reserved, Designed By zhongj
 * @Title: Entities.java
 * @Package cn.featherfly.hammer.expression.entity.condition.eq
 * @Description: Entities
 * @author: zhongj
 * @date: 2023-07-18 14:44:18
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.condition.in;

import java.util.Collection;
import java.util.function.Predicate;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableIntSupplier;
import cn.featherfly.common.lang.function.SerializableLongSupplier;
import cn.featherfly.common.lang.function.SerializableSupplier;
import cn.featherfly.common.lang.function.SerializableToIntFunction;
import cn.featherfly.common.lang.function.SerializableToLongFunction;

/**
 * The Interface InEntityExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface InEntityExpression<E> extends InEntityPropertyExpression<E> {

    //    /**
    //     * entity in function property expression.
    //     *
    //     * @param <R>  the generic type
    //     * @param name the name
    //     * @return entity in function property expression.
    //     */
    //    <R> EntityInFunctionPropertyExpression<E, R> property(SerializableFunction<E, R> name);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <R> void accept(SerializableFunction<E, R> name, R value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>          the generic type
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> void accept(SerializableFunction<E, R> name, R value, Predicate<R> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    void accept(SerializableToIntFunction<E> name, int value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    void accept(SerializableToIntFunction<E> name, int value, Predicate<Integer> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    void accept(SerializableToLongFunction<E> name, long value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    void accept(SerializableToLongFunction<E> name, long value, Predicate<Long> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <R> void accept(SerializableFunction<E, R> name, @SuppressWarnings("unchecked") R... value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    void accept(SerializableToIntFunction<E> name, int... value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    void accept(SerializableToLongFunction<E> name, long... value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>          the generic type
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> void accept(SerializableFunction<E, R> name, R[] value, Predicate<R[]> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    void accept(SerializableToIntFunction<E> name, int[] value, Predicate<int[]> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    void accept(SerializableToLongFunction<E> name, long[] value, Predicate<long[]> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <R> void accept(SerializableFunction<E, R> name, Collection<R> value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>          the generic type
     * @param name         参数名称
     * @param value        参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> void accept(SerializableFunction<E, R> name, Collection<R> value, Predicate<Collection<R>> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    <R> void accept(SerializableSupplier<R> property);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>          the generic type
     * @param property     对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> void accept(SerializableSupplier<R> property, Predicate<R> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    <R> void accept(SerializableIntSupplier property);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>          the generic type
     * @param property     对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> void accept(SerializableIntSupplier property, Predicate<Integer> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    <R> void accept(SerializableLongSupplier property);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>          the generic type
     * @param property     对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> void accept(SerializableLongSupplier property, Predicate<Long> ignoreStrategy);
}
