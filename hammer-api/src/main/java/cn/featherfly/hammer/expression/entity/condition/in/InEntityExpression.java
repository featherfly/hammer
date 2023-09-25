
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
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableDoubleSupplier;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableIntSupplier;
import cn.featherfly.common.function.serializable.SerializableLongSupplier;
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.function.serializable.SerializableToCollectionFunction;
import cn.featherfly.common.function.serializable.SerializableToDoubleFunction;
import cn.featherfly.common.function.serializable.SerializableToIntFunction;
import cn.featherfly.common.function.serializable.SerializableToLongFunction;
import cn.featherfly.hammer.expression.entity.condition.InNotInEntityExpression;

/**
 * The Interface InEntityExpression.
 *
 * @author zhongj
 * @param <T> the element type
 */
public interface InEntityExpression<T> extends InNotInEntityExpression<T> {

    /**
     * entity in function property expression.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return entity in function property expression.
     */
    <R> InEntityPropertyExpression<R> property(SerializableFunction<T, R> name);

    /**
     * entity in function property expression.
     *
     * @param <R>  the generic type
     * @param <E>  the generic type
     * @param name the name
     * @return entity in function property expression.
     */
    <R extends Collection<E>, E> InEntityPropertyExpression<E> property(SerializableToCollectionFunction<T, R, E> name);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    @Override
    <R> void accept(SerializableFunction<T, R> name, R value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>            the generic type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    @Override
    <R> void accept(SerializableFunction<T, R> name, R value, Predicate<R> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    @Override
    void accept(SerializableToIntFunction<T> name, int value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    @Override
    void accept(SerializableToIntFunction<T> name, int value, IntPredicate ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    @Override
    void accept(SerializableToLongFunction<T> name, long value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    @Override
    void accept(SerializableToLongFunction<T> name, long value, LongPredicate ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    @Override
    void accept(SerializableToDoubleFunction<T> name, double value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    @Override
    void accept(SerializableToDoubleFunction<T> name, double value, DoublePredicate ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    @Override
    <R> void accept(SerializableFunction<T, R> name, @SuppressWarnings("unchecked") R... value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    @Override
    void accept(SerializableToIntFunction<T> name, int... value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    @Override
    void accept(SerializableToLongFunction<T> name, long... value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>            the generic type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    @Override
    <R> void accept(SerializableFunction<T, R> name, R[] value, Predicate<R[]> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    @Override
    void accept(SerializableToIntFunction<T> name, int[] value, Predicate<int[]> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    @Override
    void accept(SerializableToLongFunction<T> name, long[] value, Predicate<long[]> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    @Override
    <R> void accept(SerializableFunction<T, R> name, Collection<R> value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>            the generic type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    @Override
    <R> void accept(SerializableFunction<T, R> name, Collection<R> value, Predicate<Collection<R>> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    @Override
    <R> void accept(SerializableSupplier<R> property);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>            the generic type
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    @Override
    <R> void accept(SerializableSupplier<R> property, Predicate<R> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    @Override
    void accept(SerializableIntSupplier property);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    @Override
    void accept(SerializableIntSupplier property, IntPredicate ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    @Override
    void accept(SerializableLongSupplier property);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    @Override
    void accept(SerializableLongSupplier property, LongPredicate ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    @Override
    void accept(SerializableDoubleSupplier property);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    @Override
    void accept(SerializableDoubleSupplier property, DoublePredicate ignoreStrategy);
}
