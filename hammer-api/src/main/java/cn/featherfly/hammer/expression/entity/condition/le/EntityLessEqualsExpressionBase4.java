
package cn.featherfly.hammer.expression.entity.condition.le;

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
import cn.featherfly.common.function.serializable.SerializableEnumSupplier;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableIntSupplier;
import cn.featherfly.common.function.serializable.SerializableLocalDateSupplier;
import cn.featherfly.common.function.serializable.SerializableLocalDateTimeSupplier;
import cn.featherfly.common.function.serializable.SerializableLocalTimeSupplier;
import cn.featherfly.common.function.serializable.SerializableLongSupplier;
import cn.featherfly.common.function.serializable.SerializableNumberSupplier;
import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.function.serializable.SerializableToDoubleFunction4;
import cn.featherfly.common.function.serializable.SerializableToIntFunction4;
import cn.featherfly.common.function.serializable.SerializableToLongFunction4;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityLessEqualsExpressionBase4.
 *
 * @author zhongj
 * @param <T>  the first comparable type
 * @param <T2> the second comparable type
 * @param <T3> the third comparable type
 * @param <T4> the fourth comparable type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityLessEqualsExpressionBase4<T, T2, T3, T4, C extends ConditionExpression,
        L extends LogicExpression<C, L>> extends EntityLessEqualsExpressionBase3<T, T2, T3, C, L> {

    /**
     * less and equals. 小于等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L le4(SerializableToIntFunction4<T4> name, int value);

    /**
     * less and equals. 小于等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le4(SerializableToIntFunction4<T4> name, int value, IntPredicate ignoreStrategy);

    /**
     * less and equals. 小于等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L le4(SerializableToLongFunction4<T4> name, long value);

    /**
     * less and equals. 小于等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le4(SerializableToLongFunction4<T4> name, long value, LongPredicate ignoreStrategy);

    /**
     * less and equals. 小于等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L le4(SerializableToDoubleFunction4<T4> name, double value);

    /**
     * less and equals. 小于等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le4(SerializableToDoubleFunction4<T4> name, double value, DoublePredicate ignoreStrategy);

    /**
     * less and equals. 小于等于.
     *
     * @param <N>   number type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <N extends Number> L le4(SerializableFunction<T4, N> name, N value);

    /**
     * less and equals. 小于等于.
     *
     * @param <N>            number type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L le4(SerializableFunction<T4, N> name, N value, Predicate<N> ignoreStrategy);

    /**
     * less and equals. 小于等于.
     *
     * @param <N>   number type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E extends Enum<E>> L le4(SerializableFunction<T4, E> name, E value);

    /**
     * less and equals. 小于等于.
     *
     * @param <N>            number type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E extends Enum<E>> L le4(SerializableFunction<T4, E> name, E value, Predicate<E> ignoreStrategy);

    /**
     * less and equals. 小于等于.
     *
     * @param <D>   date type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <D extends Date> L le4(SerializableFunction<T4, D> name, D value);

    /**
     * less and equals. 小于等于.
     *
     * @param <D>            date type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L le4(SerializableFunction<T4, D> name, D value, Predicate<D> ignoreStrategy);

    /**
     * less and equals. 小于等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L le4(SerializableFunction<T4, LocalTime> name, LocalTime value);

    /**
     * less and equals. 小于等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le4(SerializableFunction<T4, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy);

    /**
     * less and equals. 小于等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L le4(SerializableFunction<T4, LocalDate> name, LocalDate value);

    /**
     * less and equals. 小于等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le4(SerializableFunction<T4, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy);

    /**
     * less and equals. 小于等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L le4(SerializableFunction<T4, LocalDateTime> name, LocalDateTime value);

    /**
     * less and equals. 小于等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le4(SerializableFunction<T4, LocalDateTime> name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * less and equals. 小于等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default L le4(SerializableFunction<T4, String> name, String value) {
        return le4(name, value, MatchStrategy.AUTO);
    }

    /**
     * less and equals. 小于等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L le4(SerializableFunction<T4, String> name, String value, Predicate<String> ignoreStrategy) {
        return le4(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * less and equals. 小于等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L le4(SerializableFunction<T4, String> name, String value, MatchStrategy matchStrategy);

    /**
     * less and equals. 小于等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le4(SerializableFunction<T4, String> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy);

    /**
     * less and equals. 小于等于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L le4(SerializableIntSupplier property);

    /**
     * less and equals. 小于等于.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le4(SerializableIntSupplier property, IntPredicate ignoreStrategy);

    /**
     * less and equals. 小于等于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L le4(SerializableLongSupplier property);

    /**
     * less and equals. 小于等于.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le4(SerializableLongSupplier property, LongPredicate ignoreStrategy);

    /**
     * less and equals. 小于等于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L le4(SerializableDoubleSupplier property);

    /**
     * less and equals. 小于等于.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le4(SerializableDoubleSupplier property, DoublePredicate ignoreStrategy);

    /**
     * less and equals. 小于等于.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    <R extends Date> L le4(SerializableDateSupplier<R> property);

    /**
     * less and equals. 小于等于.
     *
     * @param <R>            the generic type
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R extends Date> L le4(SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy);

    /**
     * less and equals. 小于等于.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    <R extends Number> L le4(SerializableNumberSupplier<R> property);

    /**
     * less and equals. 小于等于.
     *
     * @param <R>            the generic type
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R extends Number> L le4(SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy);

    /**
     * less and equals. 小于等于.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    <E extends Enum<E>> L le4(SerializableEnumSupplier<E> property);

    /**
     * less and equals. 小于等于.
     *
     * @param <R>            the generic type
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E extends Enum<E>> L le4(SerializableEnumSupplier<E> property, Predicate<E> ignoreStrategy);

    /**
     * less and equals. 小于等于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L le4(SerializableLocalDateSupplier property);

    /**
     * less and equals. 小于等于.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le4(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy);

    /**
     * less and equals. 小于等于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L le4(SerializableLocalTimeSupplier property);

    /**
     * less and equals. 小于等于.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le4(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy);

    /**
     * less and equals. 小于等于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L le4(SerializableLocalDateTimeSupplier property);

    /**
     * less and equals. 小于等于.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le4(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * less and equals. 小于等于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    default L le4(SerializableStringSupplier property) {
        return le4(property, MatchStrategy.AUTO);
    }

    /**
     * less and equals. 小于等于.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L le4(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return le4(property, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * less and equals. 小于等于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L le4(SerializableStringSupplier property, MatchStrategy matchStrategy);

    /**
     * less and equals. 小于等于.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le4(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);

}