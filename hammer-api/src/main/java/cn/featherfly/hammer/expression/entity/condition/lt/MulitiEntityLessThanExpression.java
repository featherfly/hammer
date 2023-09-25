
package cn.featherfly.hammer.expression.entity.condition.lt;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableDateSupplier;
import cn.featherfly.common.function.serializable.SerializableDoubleSupplier;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableIntSupplier;
import cn.featherfly.common.function.serializable.SerializableLocalDateSupplier;
import cn.featherfly.common.function.serializable.SerializableLocalDateTimeSupplier;
import cn.featherfly.common.function.serializable.SerializableLocalTimeSupplier;
import cn.featherfly.common.function.serializable.SerializableLongSupplier;
import cn.featherfly.common.function.serializable.SerializableNumberSupplier;
import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.function.serializable.SerializableToDoubleFunction;
import cn.featherfly.common.function.serializable.SerializableToIntFunction;
import cn.featherfly.common.function.serializable.SerializableToLongFunction;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.MulitiEntityConditionExpression;

/**
 * The Interface MulitiEntityLessEqualsExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface MulitiEntityLessThanExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends MulitiEntityConditionExpression {

    /**
     * less than. 小于.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E> L lt(int index, SerializableToIntFunction<E> name, int value);

    /**
     * less than. 小于.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L lt(int index, SerializableToIntFunction<E> name, int value, IntPredicate ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E> L lt(int index, SerializableToLongFunction<E> name, long value);

    /**
     * less than. 小于.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L lt(int index, SerializableToLongFunction<E> name, long value, LongPredicate ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E> L lt(int index, SerializableToDoubleFunction<E> name, double value);

    /**
     * less than. 小于.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L lt(int index, SerializableToDoubleFunction<E> name, double value, DoublePredicate ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param <E>   the element type
     * @param <N>   number type
     * @param index the index
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E, N extends Number> L lt(int index, SerializableFunction<E, N> name, N value);

    /**
     * less than. 小于.
     *
     * @param <E>            the element type
     * @param <N>            number type
     * @param index          the index
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E, N extends Number> L lt(int index, SerializableFunction<E, N> name, N value, Predicate<N> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param <E>   the element type
     * @param <D>   date type
     * @param index the index
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E, D extends Date> L lt(int index, SerializableFunction<E, D> name, D value);

    /**
     * less than. 小于.
     *
     * @param <E>            the element type
     * @param <D>            date type
     * @param index          the index
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E, D extends Date> L lt(int index, SerializableFunction<E, D> name, D value, Predicate<D> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E> L lt(int index, SerializableFunction<E, LocalTime> name, LocalTime value);

    /**
     * less than. 小于.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L lt(int index, SerializableFunction<E, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E> L lt(int index, SerializableFunction<E, LocalDate> name, LocalDate value);

    /**
     * less than. 小于.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L lt(int index, SerializableFunction<E, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E> L lt(int index, SerializableFunction<E, LocalDateTime> name, LocalDateTime value);

    /**
     * less than. 小于.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L lt(int index, SerializableFunction<E, LocalDateTime> name, LocalDateTime value,
            Predicate<LocalDateTime> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E> L lt(int index, SerializableFunction<E, String> name, String value);

    /**
     * less than. 小于.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L lt(int index, SerializableFunction<E, String> name, String value, Predicate<String> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param index    the index
     * @param property 对象属性
     * @return LogicExpression
     */
    L lt(int index, SerializableIntSupplier property);

    /**
     * less than. 小于.
     *
     * @param index          the index
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(int index, SerializableIntSupplier property, IntPredicate ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param index    the index
     * @param property 对象属性
     * @return LogicExpression
     */
    L lt(int index, SerializableLongSupplier property);

    /**
     * less than. 小于.
     *
     * @param index          the index
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(int index, SerializableLongSupplier property, LongPredicate ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param index    the index
     * @param property 对象属性
     * @return LogicExpression
     */
    L lt(int index, SerializableDoubleSupplier property);

    /**
     * less than. 小于.
     *
     * @param index          the index
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(int index, SerializableDoubleSupplier property, DoublePredicate ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param <R>      the generic type
     * @param index    the index
     * @param property 对象属性
     * @return LogicExpression
     */
    <R extends Date> L lt(int index, SerializableDateSupplier<R> property);

    /**
     * less than. 小于.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R extends Date> L lt(int index, SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param <R>      the generic type
     * @param index    the index
     * @param property 对象属性
     * @return LogicExpression
     */
    <R extends Number> L lt(int index, SerializableNumberSupplier<R> property);

    /**
     * less than. 小于.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R extends Number> L lt(int index, SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param index    the index
     * @param property 对象属性
     * @return LogicExpression
     */
    L lt(int index, SerializableLocalDateSupplier property);

    /**
     * less than. 小于.
     *
     * @param index          the index
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(int index, SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param index    the index
     * @param property 对象属性
     * @return LogicExpression
     */
    L lt(int index, SerializableLocalTimeSupplier property);

    /**
     * less than. 小于.
     *
     * @param index          the index
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(int index, SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param index    the index
     * @param property 对象属性
     * @return LogicExpression
     */
    L lt(int index, SerializableLocalDateTimeSupplier property);

    /**
     * less than. 小于.
     *
     * @param index          the index
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(int index, SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param index    the index
     * @param property 对象属性
     * @return LogicExpression
     */
    L lt(int index, SerializableStringSupplier property);

    /**
     * less than. 小于.
     *
     * @param index          the index
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(int index, SerializableStringSupplier property, Predicate<String> ignoreStrategy);
}