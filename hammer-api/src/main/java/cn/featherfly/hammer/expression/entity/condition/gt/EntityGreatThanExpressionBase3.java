
package cn.featherfly.hammer.expression.entity.condition.gt;

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
import cn.featherfly.common.function.serializable.SerializableToDoubleFunction3;
import cn.featherfly.common.function.serializable.SerializableToIntFunction3;
import cn.featherfly.common.function.serializable.SerializableToLongFunction3;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityGreatThanExpressionBase3.
 *
 * @author zhongj
 * @param <T>  the first comparable type
 * @param <T2> the second comparable type
 * @param <T3> the third comparable type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityGreatThanExpressionBase3<T, T2, T3, C extends ConditionExpression,
        L extends LogicExpression<C, L>> extends EntityGreatThanExpressionBase2<T, T2, C, L> {

    /**
     * great than. 大于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L gt3(SerializableToIntFunction3<T3> name, int value);

    /**
     * great than. 大于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt3(SerializableToIntFunction3<T3> name, int value, IntPredicate ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L gt3(SerializableToLongFunction3<T3> name, long value);

    /**
     * great than. 大于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt3(SerializableToLongFunction3<T3> name, long value, LongPredicate ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L gt3(SerializableToDoubleFunction3<T3> name, double value);

    /**
     * great than. 大于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt3(SerializableToDoubleFunction3<T3> name, double value, DoublePredicate ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param <N>   number type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <N extends Number> L gt3(SerializableFunction<T3, N> name, N value);

    /**
     * great than. 大于.
     *
     * @param <N>            number type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L gt3(SerializableFunction<T3, N> name, N value, Predicate<N> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param <N>   number type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E extends Enum<E>> L gt3(SerializableFunction<T3, E> name, E value);

    /**
     * great than. 大于.
     *
     * @param <N>            number type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E extends Enum<E>> L gt3(SerializableFunction<T3, E> name, E value, Predicate<E> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param <D>   date type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <D extends Date> L gt3(SerializableFunction<T3, D> name, D value);

    /**
     * great than. 大于.
     *
     * @param <D>            date type
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L gt3(SerializableFunction<T3, D> name, D value, Predicate<D> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L gt3(SerializableFunction<T3, LocalTime> name, LocalTime value);

    /**
     * great than. 大于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt3(SerializableFunction<T3, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L gt3(SerializableFunction<T3, LocalDate> name, LocalDate value);

    /**
     * great than. 大于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt3(SerializableFunction<T3, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L gt3(SerializableFunction<T3, LocalDateTime> name, LocalDateTime value);

    /**
     * great than. 大于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt3(SerializableFunction<T3, LocalDateTime> name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default L gt3(SerializableFunction<T3, String> name, String value) {
        return gt3(name, value, MatchStrategy.AUTO);
    }

    /**
     * great than. 大于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt3(SerializableFunction<T3, String> name, String value, Predicate<String> ignoreStrategy) {
        return gt3(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    L gt3(SerializableFunction<T3, String> name, String value, MatchStrategy matchStrategy);

    /**
     * great than. 大于.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt3(SerializableFunction<T3, String> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L gt3(SerializableIntSupplier property);

    /**
     * great than. 大于.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt3(SerializableIntSupplier property, IntPredicate ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L gt3(SerializableLongSupplier property);

    /**
     * great than. 大于.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt3(SerializableLongSupplier property, LongPredicate ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L gt3(SerializableDoubleSupplier property);

    /**
     * great than. 大于.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt3(SerializableDoubleSupplier property, DoublePredicate ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    <R extends Date> L gt3(SerializableDateSupplier<R> property);

    /**
     * great than. 大于.
     *
     * @param <R>            the generic type
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R extends Date> L gt3(SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    <R extends Number> L gt3(SerializableNumberSupplier<R> property);

    /**
     * great than. 大于.
     *
     * @param <R>            the generic type
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R extends Number> L gt3(SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param <R>      the generic type
     * @param property 对象属性
     * @return LogicExpression
     */
    <E extends Enum<E>> L gt3(SerializableEnumSupplier<E> property);

    /**
     * great than. 大于.
     *
     * @param <R>            the generic type
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E extends Enum<E>> L gt3(SerializableEnumSupplier<E> property, Predicate<E> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L gt3(SerializableLocalDateSupplier property);

    /**
     * great than. 大于.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt3(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L gt3(SerializableLocalTimeSupplier property);

    /**
     * great than. 大于.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt3(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L gt3(SerializableLocalDateTimeSupplier property);

    /**
     * great than. 大于.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt3(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    default L gt3(SerializableStringSupplier property) {
        return gt3(property, MatchStrategy.AUTO);
    }

    /**
     * great than. 大于.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt3(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return gt3(property, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    L gt3(SerializableStringSupplier property, MatchStrategy matchStrategy);

    /**
     * great than. 大于.
     *
     * @param property       对象属性
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt3(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);

}