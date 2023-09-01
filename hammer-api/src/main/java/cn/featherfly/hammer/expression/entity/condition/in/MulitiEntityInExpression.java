
package cn.featherfly.hammer.expression.entity.condition.in;

import java.util.Collection;
import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableIntSupplier;
import cn.featherfly.common.function.serializable.SerializableLongSupplier;
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.function.serializable.SerializableToIntFunction;
import cn.featherfly.common.function.serializable.SerializableToLongFunction;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.MulitiEntityConditionExpression;

/**
 * The Interface EntityInExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface MulitiEntityInExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends MulitiEntityConditionExpression {

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <E>   the element type
     * @param <R>   the generic type
     * @param index the index
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E, R> L in(int index, SerializableFunction<E, R> name, R value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <E>            the element type
     * @param <R>            the generic type
     * @param index          the index
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E, R> L in(int index, SerializableFunction<E, R> name, R value, Predicate<R> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E> L in(int index, SerializableToIntFunction<E> name, int value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L in(int index, SerializableToIntFunction<E> name, int value, Predicate<Integer> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E> L in(int index, SerializableToLongFunction<E> name, long value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L in(int index, SerializableToLongFunction<E> name, long value, Predicate<Long> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <E>   the element type
     * @param <R>   the generic type
     * @param index the index
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E, R> L in(int index, SerializableFunction<E, R> name, @SuppressWarnings("unchecked") R... value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E> L in(int index, SerializableToIntFunction<E> name, int... value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E> L in(int index, SerializableToLongFunction<E> name, long... value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <E>            the element type
     * @param <R>            the generic type
     * @param index          the index
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E, R> L in(int index, SerializableFunction<E, R> name, R[] value, Predicate<R[]> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L in(int index, SerializableToIntFunction<E> name, int[] value, Predicate<int[]> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L in(int index, SerializableToLongFunction<E> name, long[] value, Predicate<long[]> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <E>   the element type
     * @param <R>   the generic type
     * @param index the index
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E, R> L in(int index, SerializableFunction<E, R> name, Collection<R> value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <E>            the element type
     * @param <R>            the generic type
     * @param index          the index
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E, R> L in(int index, SerializableFunction<E, R> name, Collection<R> value,
            Predicate<Collection<R>> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <E>      the element type
     * @param <R>      the generic type
     * @param index    the index
     * @param property 对象属性
     * @return LogicExpression
     */
    <E, R> L in(int index, SerializableSupplier<R> property);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <E>            the element type
     * @param <R>            the generic type
     * @param index          the index
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E, R> L in(int index, SerializableSupplier<R> property, Predicate<R> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <E>      the element type
     * @param <R>      the generic type
     * @param index    the index
     * @param property 对象属性
     * @return LogicExpression
     */
    <E, R> L in(int index, SerializableIntSupplier property);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <E>            the element type
     * @param <R>            the generic type
     * @param index          the index
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E, R> L in(int index, SerializableIntSupplier property, Predicate<Integer> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <E>      the element type
     * @param <R>      the generic type
     * @param index    the index
     * @param property 对象属性
     * @return LogicExpression
     */
    <E, R> L in(int index, SerializableLongSupplier property);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <E>            the element type
     * @param <R>            the generic type
     * @param index          the index
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E, R> L in(int index, SerializableLongSupplier property, Predicate<Long> ignoreStrategy);
}