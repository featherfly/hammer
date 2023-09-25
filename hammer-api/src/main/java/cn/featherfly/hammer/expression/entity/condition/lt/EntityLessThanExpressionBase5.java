
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
import cn.featherfly.common.function.serializable.SerializableToDoubleFunction5;
import cn.featherfly.common.function.serializable.SerializableToIntFunction5;
import cn.featherfly.common.function.serializable.SerializableToLongFunction5;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityLessThanExpressionBase5.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <E5> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityLessThanExpressionBase5<E, E2, E3, E4, E5, C extends ConditionExpression,
        L extends LogicExpression<C, L>> extends EntityLessThanExpressionBase4<E, E2, E3, E4, C, L> {

    /**
     * less than. 小于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L lt5(SerializableToIntFunction5<E5> name, int value);

    /**
     * less than. 小于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt5(SerializableToIntFunction5<E5> name, int value, IntPredicate ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L lt5(SerializableToLongFunction5<E5> name, long value);

    /**
     * less than. 小于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt5(SerializableToLongFunction5<E5> name, long value, LongPredicate ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L lt5(SerializableToDoubleFunction5<E5> name, double value);

    /**
     * less than. 小于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt5(SerializableToDoubleFunction5<E5> name, double value, DoublePredicate ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param <N>   number type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <N extends Number> L lt5(SerializableFunction<E5, N> name, N value);

    /**
     * less than. 小于.
     *
     * @param <N>            number type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L lt5(SerializableFunction<E5, N> name, N value, Predicate<N> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param <D>   date type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <D extends Date> L lt5(SerializableFunction<E5, D> name, D value);

    /**
     * less than. 小于.
     *
     * @param <D>            date type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L lt5(SerializableFunction<E5, D> name, D value, Predicate<D> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L lt5(SerializableFunction<E5, LocalTime> name, LocalTime value);

    /**
     * less than. 小于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt5(SerializableFunction<E5, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L lt5(SerializableFunction<E5, LocalDate> name, LocalDate value);

    /**
     * less than. 小于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt5(SerializableFunction<E5, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L lt5(SerializableFunction<E5, LocalDateTime> name, LocalDateTime value);

    /**
     * less than. 小于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt5(SerializableFunction<E5, LocalDateTime> name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L lt5(SerializableFunction<E5, String> name, String value);

    /**
     * less than. 小于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt5(SerializableFunction<E5, String> name, String value, Predicate<String> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L lt5(SerializableIntSupplier property);

    /**
     * less than. 小于.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt5(SerializableIntSupplier property, IntPredicate ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L lt5(SerializableLongSupplier property);

    /**
     * less than. 小于.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt5(SerializableLongSupplier property, LongPredicate ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L lt5(SerializableDoubleSupplier property);

    /**
     * less than. 小于.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt5(SerializableDoubleSupplier property, DoublePredicate ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    <R extends Date> L lt5(SerializableDateSupplier<R> property);

    /**
     * less than. 小于.
     *
     * @param <R>            the generic type
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R extends Date> L lt5(SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    <R extends Number> L lt5(SerializableNumberSupplier<R> property);

    /**
     * less than. 小于.
     *
     * @param <R>            the generic type
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R extends Number> L lt5(SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L lt5(SerializableLocalDateSupplier property);

    /**
     * less than. 小于.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt5(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L lt5(SerializableLocalTimeSupplier property);

    /**
     * less than. 小于.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt5(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L lt5(SerializableLocalDateTimeSupplier property);

    /**
     * less than. 小于.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt5(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * less than. 小于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L lt5(SerializableStringSupplier property);

    /**
     * less than. 小于.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt5(SerializableStringSupplier property, Predicate<String> ignoreStrategy);

}