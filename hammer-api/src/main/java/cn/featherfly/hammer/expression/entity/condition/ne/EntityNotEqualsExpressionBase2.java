
package cn.featherfly.hammer.expression.entity.condition.ne;

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
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityEqualsExpression.
 *
 * @author zhongj
 * @param <T>  the first comparable type
 * @param <T2> the second comparable type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityNotEqualsExpressionBase2<T, T2, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends EntityNotEqualsExpression<T, C, L> {

    /**
     * not equals. 不等于.
     *
     * @param <R>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <R> L ne2(SerializableFunction<T2, R> name, R value);

    /**
     * not equals. 不等于.
     *
     * @param <R>            the generic type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L ne2(SerializableFunction<T2, R> name, R value, Predicate<R> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L ne2(SerializableToIntFunction<T2> name, int value);

    /**
     * not equals. 不等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne2(SerializableToIntFunction<T2> name, int value, IntPredicate ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L ne2(SerializableToLongFunction<T2> name, long value);

    /**
     * not equals. 不等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne2(SerializableToLongFunction<T2> name, long value, LongPredicate ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L ne2(SerializableToDoubleFunction<T2> name, double value);

    /**
     * not equals. 不等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne2(SerializableToDoubleFunction<T2> name, double value, DoublePredicate ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param <N>   number type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <N extends Number> L ne2(SerializableToNumberFunction<T2, N> name, N value);

    /**
     * not equals. 不等于.
     *
     * @param <N>            number type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L ne2(SerializableToNumberFunction<T2, N> name, N value, Predicate<N> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param <E>   the element type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E extends Enum<E>> L ne2(SerializableToEnumFunction<T2, E> name, E value);

    /**
     * not equals. 不等于.
     *
     * @param <E>            the element type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E extends Enum<E>> L ne2(SerializableToEnumFunction<T2, E> name, E value, Predicate<E> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param <D>   date type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <D extends Date> L ne2(SerializableToDateFunction<T2, D> name, D value);

    /**
     * not equals. 不等于.
     *
     * @param <D>            date type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L ne2(SerializableToDateFunction<T2, D> name, D value, Predicate<D> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L ne2(SerializableToLocalTimeFunction<T2> name, LocalTime value);

    /**
     * not equals. 不等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne2(SerializableToLocalTimeFunction<T2> name, LocalTime value, Predicate<LocalTime> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L ne2(SerializableToLocalDateFunction<T2> name, LocalDate value);

    /**
     * not equals. 不等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne2(SerializableToLocalDateFunction<T2> name, LocalDate value, Predicate<LocalDate> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L ne2(SerializableToLocalDateTimeFunction<T2> name, LocalDateTime value);

    /**
     * not equals. 不等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne2(SerializableToLocalDateTimeFunction<T2> name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default L ne2(SerializableToStringFunction<T2> name, String value) {
        return ne2(name, value, MatchStrategy.AUTO);
    }

    /**
     * not equals. 不等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne2(SerializableToStringFunction<T2> name, String value, Predicate<String> ignoreStrategy) {
        return ne2(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param name          参数名称
     * @param value         参数值
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L ne2(SerializableToStringFunction<T2> name, String value, MatchStrategy matchStrategy);

    /**
     * not equals. 不等于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne2(SerializableToStringFunction<T2> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy);

    // ********************************************************************
    // object property value
    // ********************************************************************

    /**
     * not equals. 不等于.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    <R> L ne2(SerializableSupplier<R> property);

    /**
     * not equals. 不等于.
     *
     * @param <R>            the generic type
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L ne2(SerializableSupplier<R> property, Predicate<R> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L ne2(SerializableIntSupplier property);

    /**
     * not equals. 不等于.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne2(SerializableIntSupplier property, IntPredicate ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L ne2(SerializableLongSupplier property);

    /**
     * not equals. 不等于.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne2(SerializableLongSupplier property, LongPredicate ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L ne2(SerializableDoubleSupplier property);

    /**
     * not equals. 不等于.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne2(SerializableDoubleSupplier property, DoublePredicate ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    <R extends Date> L ne2(SerializableDateSupplier<R> property);

    /**
     * not equals. 不等于.
     *
     * @param <R>            the generic type
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R extends Date> L ne2(SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    <R extends Number> L ne2(SerializableNumberSupplier<R> property);

    /**
     * not equals. 不等于.
     *
     * @param <R>            the generic type
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R extends Number> L ne2(SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param <E>      the element type
     * @param property 对象属性
     * @return LogicExpression
     */
    <E extends Enum<E>> L ne2(SerializableEnumSupplier<E> property);

    /**
     * not equals. 不等于.
     *
     * @param <E>            the element type
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E extends Enum<E>> L ne2(SerializableEnumSupplier<E> property, Predicate<E> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L ne2(SerializableLocalDateSupplier property);

    /**
     * not equals. 不等于.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne2(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L ne2(SerializableLocalTimeSupplier property);

    /**
     * not equals. 不等于.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne2(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L ne2(SerializableLocalDateTimeSupplier property);

    /**
     * not equals. 不等于.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne2(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    default L ne2(SerializableStringSupplier property) {
        return ne2(property, MatchStrategy.AUTO);
    }

    /**
     * not equals. 不等于.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ne2(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return ne2(property, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param property      对象属性
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L ne2(SerializableStringSupplier property, MatchStrategy matchStrategy);

    /**
     * not equals. 不等于.
     *
     * @param property       对象属性
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne2(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);
}