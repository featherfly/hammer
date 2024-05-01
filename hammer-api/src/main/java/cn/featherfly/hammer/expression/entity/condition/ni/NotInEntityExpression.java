
/*
 * All rights Reserved, Designed By zhongj
 * @Title: Entities.java
 * @Package cn.featherfly.hammer.expression.entity.condition.eq
 * @Description: Entities
 * @author: zhongj
 * @date: 2023-07-18 14:44:18
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.condition.ni;

import java.util.Collection;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableIntSupplier;
import cn.featherfly.common.function.serializable.SerializableLongSupplier;
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.function.serializable.SerializableToCollectionFunction;
import cn.featherfly.common.function.serializable.SerializableToIntFunction;
import cn.featherfly.common.function.serializable.SerializableToLongFunction;
import cn.featherfly.hammer.expression.entity.condition.InNotInEntityExpression;

/**
 * not in entity expression.
 *
 * @author zhongj
 * @param <T> the element type
 */
public interface NotInEntityExpression<T> extends InNotInEntityExpression<T> {

    /**
     * entity not in function property expression.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return entity not in function property expression.
     */
    <R> NotInEntityPropertyExpression<R> property(SerializableFunction<T, R> name);

    /**
     * entity not in function property expression.
     *
     * @param <R>  the generic type
     * @param <E>  the generic type
     * @param name the name
     * @return entity not in function property expression.
     */
    <R extends Collection<E>,
            E> NotInEntityPropertyExpression<E> property(SerializableToCollectionFunction<T, R, E> name);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <R>   the generic type
     * @param name  the name
     * @param value the value
     */
    @Override
    <R> void accept(SerializableFunction<T, R> name, R value);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <R>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    @Override
    <R> void accept(SerializableFunction<T, R> name, R value, Predicate<R> ignoreStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name  the name
     * @param value the value
     */
    @Override
    void accept(SerializableToIntFunction<T> name, int value);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    @Override
    void accept(SerializableToIntFunction<T> name, int value, IntPredicate ignoreStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name  the name
     * @param value the value
     */
    @Override
    void accept(SerializableToLongFunction<T> name, long value);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    @Override
    void accept(SerializableToLongFunction<T> name, long value, LongPredicate ignoreStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <R>   the generic type
     * @param name  the name
     * @param value the value
     */
    @Override
    <R> void accept(SerializableFunction<T, R> name, @SuppressWarnings("unchecked") R... value);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name  the name
     * @param value the value
     */
    @Override
    void accept(SerializableToIntFunction<T> name, int... value);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name  the name
     * @param value the value
     */
    @Override
    void accept(SerializableToLongFunction<T> name, long... value);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <R>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    @Override
    <R> void accept(SerializableFunction<T, R> name, R[] value, Predicate<R[]> ignoreStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    @Override
    void accept(SerializableToIntFunction<T> name, int[] value, Predicate<int[]> ignoreStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    @Override
    void accept(SerializableToLongFunction<T> name, long[] value, Predicate<long[]> ignoreStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <R>   the generic type
     * @param name  the name
     * @param value the value
     */
    @Override
    <R> void accept(SerializableFunction<T, R> name, Collection<R> value);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <R>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    @Override
    <R> void accept(SerializableFunction<T, R> name, Collection<R> value, Predicate<Collection<R>> ignoreStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <R>      the generic type
     * @param property bean property
     */
    @Override
    <R> void accept(SerializableSupplier<R> property);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <R>            the generic type
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     */
    @Override
    <R> void accept(SerializableSupplier<R> property, Predicate<R> ignoreStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     */
    @Override
    void accept(SerializableIntSupplier property);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     */
    @Override
    void accept(SerializableIntSupplier property, IntPredicate ignoreStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     */
    @Override
    void accept(SerializableLongSupplier property);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     */
    @Override
    void accept(SerializableLongSupplier property, LongPredicate ignoreStrategy);
}
