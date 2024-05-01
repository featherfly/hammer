
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
import cn.featherfly.common.function.serializable.SerializableStringSupplier;
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
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.field.value.SetDateArrayExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetDoubleArrayExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetEnumArrayExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetIntArrayExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetLocalDateArrayExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetLocalDateTimeArrayExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetLocalTimeArrayExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetLongArrayExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetNumberArrayExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetStringArrayExpression;

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
    SetIntArrayExpression property(SerializableToIntFunction<T> name);

    /**
     * entity in function property expression.
     *
     * @param name the name
     * @return entity in function property expression.
     */
    SetLongArrayExpression property(SerializableToLongFunction<T> name);

    /**
     * entity in function property expression.
     *
     * @param name the name
     * @return entity in function property expression.
     */
    SetDoubleArrayExpression property(SerializableToDoubleFunction<T> name);

    /**
     * entity in function property expression.
     *
     * @param <N>  the generic type
     * @param name the name
     * @return entity in function property expression.
     */
    <N extends Number> SetNumberArrayExpression<N> property(SerializableToNumberFunction<T, N> name);

    /**
     * entity in function property expression.
     *
     * @param <D>  the generic type
     * @param name the name
     * @return entity in function property expression.
     */
    <D extends Date> SetDateArrayExpression<D> property(SerializableToDateFunction<T, D> name);

    /**
     * entity in function property expression.
     *
     * @param <E>  the generic type
     * @param name the name
     * @return entity in function property expression.
     */
    <E extends Enum<E>> SetEnumArrayExpression<E> property(SerializableToEnumFunction<T, E> name);

    /**
     * entity in function property expression.
     *
     * @param name the name
     * @return entity in function property expression.
     */
    SetLocalDateTimeArrayExpression property(SerializableToLocalDateTimeFunction<T> name);

    /**
     * entity in function property expression.
     *
     * @param name the name
     * @return entity in function property expression.
     */
    SetLocalDateArrayExpression property(SerializableToLocalDateFunction<T> name);

    /**
     * entity in function property expression.
     *
     * @param name the name
     * @return entity in function property expression.
     */
    SetLocalTimeArrayExpression property(SerializableToLocalTimeFunction<T> name);

    /**
     * entity in function property expression.
     *
     * @param name the name
     * @return entity in function property expression.
     */
    SetStringArrayExpression property(SerializableToStringFunction<T> name);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param <R>   the generic type
     * @param name  the name
     * @param value the value
     */
    <R> void accept(SerializableFunction<T, R> name, R value);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param <R>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    <R> void accept(SerializableFunction<T, R> name, R value, Predicate<R> ignoreStrategy);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     */
    void accept(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     */
    void accept(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param name  the name
     * @param value the value
     */
    void accept(SerializableToIntFunction<T> name, int value);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    void accept(SerializableToIntFunction<T> name, int value, IntPredicate ignoreStrategy);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param name  the name
     * @param value the value
     */
    void accept(SerializableToLongFunction<T> name, long value);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    void accept(SerializableToLongFunction<T> name, long value, LongPredicate ignoreStrategy);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param name  the name
     * @param value the value
     */
    void accept(SerializableToDoubleFunction<T> name, double value);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    void accept(SerializableToDoubleFunction<T> name, double value, DoublePredicate ignoreStrategy);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param <R>   the generic type
     * @param name  the name
     * @param value the value
     */
    <R> void accept(SerializableFunction<T, R> name, @SuppressWarnings("unchecked") R... value);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     */
    void accept(SerializableToStringFunction<T> name, String[] value, MatchStrategy matchStrategy);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     */
    void accept(SerializableToStringFunction<T> name, String[] value, MatchStrategy matchStrategy,
            Predicate<String[]> ignoreStrategy);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param name  the name
     * @param value the value
     */
    void accept(SerializableToIntFunction<T> name, int... value);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param name  the name
     * @param value the value
     */
    void accept(SerializableToLongFunction<T> name, long... value);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param <R>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    <R> void accept(SerializableFunction<T, R> name, R[] value, Predicate<R[]> ignoreStrategy);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    void accept(SerializableToIntFunction<T> name, int[] value, Predicate<int[]> ignoreStrategy);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    void accept(SerializableToLongFunction<T> name, long[] value, Predicate<long[]> ignoreStrategy);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param <R>   the generic type
     * @param name  the name
     * @param value the value
     */
    <R> void accept(SerializableFunction<T, R> name, Collection<R> value);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param <R>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    <R> void accept(SerializableFunction<T, R> name, Collection<R> value, Predicate<Collection<R>> ignoreStrategy);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param <R>      the generic type
     * @param property bean property
     */
    <R> void accept(SerializableSupplier<R> property);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param <R>            the generic type
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     */
    <R> void accept(SerializableSupplier<R> property, Predicate<R> ignoreStrategy);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param property      the property
     * @param matchStrategy the match strategy
     */
    void accept(SerializableStringSupplier property, MatchStrategy matchStrategy);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param property       the property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     */
    void accept(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param property bean property
     */
    void accept(SerializableIntSupplier property);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     */
    void accept(SerializableIntSupplier property, IntPredicate ignoreStrategy);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param property bean property
     */
    void accept(SerializableLongSupplier property);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     */
    void accept(SerializableLongSupplier property, LongPredicate ignoreStrategy);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param property bean property
     */
    void accept(SerializableDoubleSupplier property);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     */
    void accept(SerializableDoubleSupplier property, DoublePredicate ignoreStrategy);
}
