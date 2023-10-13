
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
import cn.featherfly.common.function.serializable.SerializableToDoubleFunction;
import cn.featherfly.common.function.serializable.SerializableToIntFunction;
import cn.featherfly.common.function.serializable.SerializableToLongFunction;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
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
public interface MulitiEntityLessEqualsExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends MulitiEntityConditionExpression {

    /**
     * less and equals. 小于等于.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E> L le(int index, SerializableToIntFunction<E> name, int value);

    /**
     * less and equals. 小于等于.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L le(int index, SerializableToIntFunction<E> name, int value, IntPredicate ignoreStrategy);

    /**
     * less and equals. 小于等于.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E> L le(int index, SerializableToLongFunction<E> name, long value);

    /**
     * less and equals. 小于等于.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L le(int index, SerializableToLongFunction<E> name, long value, LongPredicate ignoreStrategy);

    /**
     * less and equals. 小于等于.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E> L le(int index, SerializableToDoubleFunction<E> name, double value);

    /**
     * less and equals. 小于等于.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L le(int index, SerializableToDoubleFunction<E> name, double value, DoublePredicate ignoreStrategy);

    /**
     * less and equals. 小于等于.
     *
     * @param <E>   the element type
     * @param <N>   number type
     * @param index the index
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E, N extends Number> L le(int index, SerializableFunction<E, N> name, N value);

    /**
     * less and equals. 小于等于.
     *
     * @param <E>            the element type
     * @param <N>            number type
     * @param index          the index
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E, N extends Number> L le(int index, SerializableFunction<E, N> name, N value, Predicate<N> ignoreStrategy);

    /**
     * less and equals. 小于等于.
     *
     * @param <T>   the generic type
     * @param <E>   the element type
     * @param index the index
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <T, E extends Enum<E>> L le(int index, SerializableFunction<T, E> name, E value);

    /**
     * less and equals. 小于等于.
     *
     * @param <T>            the generic type
     * @param <E>            the element type
     * @param index          the index
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T, E extends Enum<E>> L le(int index, SerializableFunction<T, E> name, E value, Predicate<E> ignoreStrategy);

    /**
     * less and equals. 小于等于.
     *
     * @param <E>   the element type
     * @param <D>   date type
     * @param index the index
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E, D extends Date> L le(int index, SerializableFunction<E, D> name, D value);

    /**
     * less and equals. 小于等于.
     *
     * @param <E>            the element type
     * @param <D>            date type
     * @param index          the index
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E, D extends Date> L le(int index, SerializableFunction<E, D> name, D value, Predicate<D> ignoreStrategy);

    /**
     * less and equals. 小于等于.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E> L le(int index, SerializableFunction<E, LocalTime> name, LocalTime value);

    /**
     * less and equals. 小于等于.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L le(int index, SerializableFunction<E, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy);

    /**
     * less and equals. 小于等于.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E> L le(int index, SerializableFunction<E, LocalDate> name, LocalDate value);

    /**
     * less and equals. 小于等于.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L le(int index, SerializableFunction<E, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy);

    /**
     * less and equals. 小于等于.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E> L le(int index, SerializableFunction<E, LocalDateTime> name, LocalDateTime value);

    /**
     * less and equals. 小于等于.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L le(int index, SerializableFunction<E, LocalDateTime> name, LocalDateTime value,
            Predicate<LocalDateTime> ignoreStrategy);

    /**
     * less and equals. 小于等于.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default <E> L le(int index, SerializableFunction<E, String> name, String value) {
        return le(index, name, value, MatchStrategy.AUTO);
    }

    /**
     * less and equals. 小于等于.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E> L le(int index, SerializableFunction<E, String> name, String value, Predicate<String> ignoreStrategy) {
        return le(index, name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * less and equals. 小于等于.
     *
     * @param <E>           the element type
     * @param index         the index
     * @param name          参数名称
     * @param value         参数值
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    <E> L le(int index, SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy);

    /**
     * less and equals. 小于等于.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           参数名称
     * @param value          参数值
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L le(int index, SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy);

    /**
     * less and equals. 小于等于.
     *
     * @param index    the index
     * @param property 对象属性
     * @return LogicExpression
     */
    L le(int index, SerializableIntSupplier property);

    /**
     * less and equals. 小于等于.
     *
     * @param index          the index
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(int index, SerializableIntSupplier property, IntPredicate ignoreStrategy);

    /**
     * less and equals. 小于等于.
     *
     * @param index    the index
     * @param property 对象属性
     * @return LogicExpression
     */
    L le(int index, SerializableLongSupplier property);

    /**
     * less and equals. 小于等于.
     *
     * @param index          the index
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(int index, SerializableLongSupplier property, LongPredicate ignoreStrategy);

    /**
     * less and equals. 小于等于.
     *
     * @param index    the index
     * @param property 对象属性
     * @return LogicExpression
     */
    L le(int index, SerializableDoubleSupplier property);

    /**
     * less and equals. 小于等于.
     *
     * @param index          the index
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(int index, SerializableDoubleSupplier property, DoublePredicate ignoreStrategy);

    /**
     * less and equals. 小于等于.
     *
     * @param <R>      the generic type
     * @param index    the index
     * @param property 对象属性
     * @return LogicExpression
     */
    <R extends Date> L le(int index, SerializableDateSupplier<R> property);

    /**
     * less and equals. 小于等于.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R extends Date> L le(int index, SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy);

    /**
     * less and equals. 小于等于.
     *
     * @param <R>      the generic type
     * @param index    the index
     * @param property 对象属性
     * @return LogicExpression
     */
    <R extends Number> L le(int index, SerializableNumberSupplier<R> property);

    /**
     * less and equals. 小于等于.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R extends Number> L le(int index, SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy);

    /**
     * less and equals. 小于等于.
     *
     * @param <E>      the element type
     * @param index    the index
     * @param property 对象属性
     * @return LogicExpression
     */
    <E extends Enum<E>> L le(int index, SerializableEnumSupplier<E> property);

    /**
     * less and equals. 小于等于.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E extends Enum<E>> L le(int index, SerializableEnumSupplier<E> property, Predicate<E> ignoreStrategy);

    /**
     * less and equals. 小于等于.
     *
     * @param index    the index
     * @param property 对象属性
     * @return LogicExpression
     */
    L le(int index, SerializableLocalDateSupplier property);

    /**
     * less and equals. 小于等于.
     *
     * @param index          the index
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(int index, SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy);

    /**
     * less and equals. 小于等于.
     *
     * @param index    the index
     * @param property 对象属性
     * @return LogicExpression
     */
    L le(int index, SerializableLocalTimeSupplier property);

    /**
     * less and equals. 小于等于.
     *
     * @param index          the index
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(int index, SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy);

    /**
     * less and equals. 小于等于.
     *
     * @param index    the index
     * @param property 对象属性
     * @return LogicExpression
     */
    L le(int index, SerializableLocalDateTimeSupplier property);

    /**
     * less and equals. 小于等于.
     *
     * @param index          the index
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(int index, SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * less and equals. 小于等于.
     *
     * @param index    the index
     * @param property 对象属性
     * @return LogicExpression
     */
    default L le(int index, SerializableStringSupplier property) {
        return le(index, property, MatchStrategy.AUTO);
    }

    /**
     * less and equals. 小于等于.
     *
     * @param index          the index
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L le(int index, SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return le(index, property, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * less and equals. 小于等于.
     *
     * @param index         the index
     * @param property      对象属性
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L le(int index, SerializableStringSupplier property, MatchStrategy matchStrategy);

    /**
     * less and equals. 小于等于.
     *
     * @param index          the index
     * @param property       对象属性
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(int index, SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);
}