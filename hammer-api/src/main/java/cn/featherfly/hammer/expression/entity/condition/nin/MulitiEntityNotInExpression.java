
package cn.featherfly.hammer.expression.entity.condition.nin;

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
 * The Interface MulitiEntityNotInExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface MulitiEntityNotInExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends MulitiEntityConditionExpression {

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <E>   the element type
     * @param <R>   the generic type
     * @param index the index
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E, R> L nin(int index, SerializableFunction<E, R> name, R value);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <E>            the element type
     * @param <R>            the generic type
     * @param index          the index
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E, R> L nin(int index, SerializableFunction<E, R> name, R value, Predicate<R> ignoreStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E> L nin(int index, SerializableToIntFunction<E> name, int value);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L nin(int index, SerializableToIntFunction<E> name, int value, Predicate<Integer> ignoreStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E> L nin(int index, SerializableToLongFunction<E> name, long value);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L nin(int index, SerializableToLongFunction<E> name, long value, Predicate<Long> ignoreStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <E>   the element type
     * @param <R>   the generic type
     * @param index the index
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E, R> L nin(int index, SerializableFunction<E, R> name, @SuppressWarnings("unchecked") R... value);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E> L nin(int index, SerializableToIntFunction<E> name, int... value);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E> L nin(int index, SerializableToLongFunction<E> name, long... value);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <E>            the element type
     * @param <R>            the generic type
     * @param index          the index
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E, R> L nin(int index, SerializableFunction<E, R> name, R[] value, Predicate<R[]> ignoreStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L nin(int index, SerializableToIntFunction<E> name, int[] value, Predicate<int[]> ignoreStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L nin(int index, SerializableToLongFunction<E> name, long[] value, Predicate<long[]> ignoreStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <E>   the element type
     * @param <R>   the generic type
     * @param index the index
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E, R> L nin(int index, SerializableFunction<E, R> name, Collection<R> value);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <E>            the element type
     * @param <R>            the generic type
     * @param index          the index
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E, R> L nin(int index, SerializableFunction<E, R> name, Collection<R> value,
            Predicate<Collection<R>> ignoreStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <E>      the element type
     * @param <R>      the generic type
     * @param index    the index
     * @param property 对象属性
     * @return LogicExpression
     */
    <E, R> L nin(int index, SerializableSupplier<R> property);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <E>            the element type
     * @param <R>            the generic type
     * @param index          the index
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E, R> L nin(int index, SerializableSupplier<R> property, Predicate<R> ignoreStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <E>      the element type
     * @param <R>      the generic type
     * @param index    the index
     * @param property 对象属性
     * @return LogicExpression
     */
    <E, R> L nin(int index, SerializableIntSupplier property);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <E>            the element type
     * @param <R>            the generic type
     * @param index          the index
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E, R> L nin(int index, SerializableIntSupplier property, Predicate<Integer> ignoreStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <E>      the element type
     * @param <R>      the generic type
     * @param index    the index
     * @param property 对象属性
     * @return LogicExpression
     */
    <E, R> L nin(int index, SerializableLongSupplier property);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <E>            the element type
     * @param <R>            the generic type
     * @param index          the index
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E, R> L nin(int index, SerializableLongSupplier property, Predicate<Long> ignoreStrategy);
}