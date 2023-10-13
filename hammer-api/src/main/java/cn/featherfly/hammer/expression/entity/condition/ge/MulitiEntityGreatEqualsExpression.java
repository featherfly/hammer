
package cn.featherfly.hammer.expression.entity.condition.ge;

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
 * The Interface MulitiEntityEqualsExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface MulitiEntityGreatEqualsExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends MulitiEntityConditionExpression {

    /**
     * great and equals. 大于等于.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E> L ge(int index, SerializableToIntFunction<E> name, int value);

    /**
     * great and equals. 大于等于.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L ge(int index, SerializableToIntFunction<E> name, int value, IntPredicate ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E> L ge(int index, SerializableToLongFunction<E> name, long value);

    /**
     * great and equals. 大于等于.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L ge(int index, SerializableToLongFunction<E> name, long value, LongPredicate ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E> L ge(int index, SerializableToDoubleFunction<E> name, double value);

    /**
     * great and equals. 大于等于.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L ge(int index, SerializableToDoubleFunction<E> name, double value, DoublePredicate ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param <E>   the element type
     * @param <N>   number type
     * @param index the index
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E, N extends Number> L ge(int index, SerializableFunction<E, N> name, N value);

    /**
     * great and equals. 大于等于.
     *
     * @param <E>            the element type
     * @param <N>            number type
     * @param index          the index
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E, N extends Number> L ge(int index, SerializableFunction<E, N> name, N value, Predicate<N> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param <T>   the generic type
     * @param <E>   the element type
     * @param index the index
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <T, E extends Enum<E>> L ge(int index, SerializableFunction<T, E> name, E value);

    /**
     * great and equals. 大于等于.
     *
     * @param <T>            the generic type
     * @param <E>            the element type
     * @param index          the index
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T, E extends Enum<E>> L ge(int index, SerializableFunction<T, E> name, E value, Predicate<E> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param <E>   the element type
     * @param <D>   date type
     * @param index the index
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E, D extends Date> L ge(int index, SerializableFunction<E, D> name, D value);

    /**
     * great and equals. 大于等于.
     *
     * @param <E>            the element type
     * @param <D>            date type
     * @param index          the index
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E, D extends Date> L ge(int index, SerializableFunction<E, D> name, D value, Predicate<D> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E> L ge(int index, SerializableFunction<E, LocalTime> name, LocalTime value);

    /**
     * great and equals. 大于等于.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L ge(int index, SerializableFunction<E, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E> L ge(int index, SerializableFunction<E, LocalDate> name, LocalDate value);

    /**
     * great and equals. 大于等于.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L ge(int index, SerializableFunction<E, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    <E> L ge(int index, SerializableFunction<E, LocalDateTime> name, LocalDateTime value);

    /**
     * great and equals. 大于等于.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L ge(int index, SerializableFunction<E, LocalDateTime> name, LocalDateTime value,
            Predicate<LocalDateTime> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default <E> L ge(int index, SerializableFunction<E, String> name, String value) {
        return ge(index, name, value, MatchStrategy.AUTO);
    }

    /**
     * great and equals. 大于等于.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E> L ge(int index, SerializableFunction<E, String> name, String value, Predicate<String> ignoreStrategy) {
        return ge(index, name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * great and equals. 大于等于.
     *
     * @param <E>               the element type
     * @param index             the index
     * @param name              参数名称
     * @param value             参数值
     * @param mathMatchStrategy the math match strategy
     * @return LogicExpression
     */
    <E> L ge(int index, SerializableFunction<E, String> name, String value, MatchStrategy mathMatchStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param <E>               the element type
     * @param index             the index
     * @param name              参数名称
     * @param value             参数值
     * @param mathMatchStrategy the math match strategy
     * @param ignoreStrategy    the ignore strategy
     * @return LogicExpression
     */
    <E> L ge(int index, SerializableFunction<E, String> name, String value, MatchStrategy mathMatchStrategy,
            Predicate<String> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param index    the index
     * @param property 对象属性
     * @return LogicExpression
     */
    L ge(int index, SerializableIntSupplier property);

    /**
     * great and equals. 大于等于.
     *
     * @param index          the index
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(int index, SerializableIntSupplier property, IntPredicate ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param index    the index
     * @param property 对象属性
     * @return LogicExpression
     */
    L ge(int index, SerializableLongSupplier property);

    /**
     * great and equals. 大于等于.
     *
     * @param index          the index
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(int index, SerializableLongSupplier property, LongPredicate ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param index    the index
     * @param property 对象属性
     * @return LogicExpression
     */
    L ge(int index, SerializableDoubleSupplier property);

    /**
     * great and equals. 大于等于.
     *
     * @param index          the index
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(int index, SerializableDoubleSupplier property, DoublePredicate ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param <R>      the generic type
     * @param index    the index
     * @param property 对象属性
     * @return LogicExpression
     */
    <R extends Date> L ge(int index, SerializableDateSupplier<R> property);

    /**
     * great and equals. 大于等于.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R extends Date> L ge(int index, SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param <R>      the generic type
     * @param index    the index
     * @param property 对象属性
     * @return LogicExpression
     */
    <R extends Number> L ge(int index, SerializableNumberSupplier<R> property);

    /**
     * great and equals. 大于等于.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R extends Number> L ge(int index, SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param <E>      the element type
     * @param index    the index
     * @param property 对象属性
     * @return LogicExpression
     */
    <E extends Enum<E>> L ge(int index, SerializableEnumSupplier<E> property);

    /**
     * great and equals. 大于等于.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E extends Enum<E>> L ge(int index, SerializableEnumSupplier<E> property, Predicate<E> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param index    the index
     * @param property 对象属性
     * @return LogicExpression
     */
    L ge(int index, SerializableLocalDateSupplier property);

    /**
     * great and equals. 大于等于.
     *
     * @param index          the index
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(int index, SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param index    the index
     * @param property 对象属性
     * @return LogicExpression
     */
    L ge(int index, SerializableLocalTimeSupplier property);

    /**
     * great and equals. 大于等于.
     *
     * @param index          the index
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(int index, SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param index    the index
     * @param property 对象属性
     * @return LogicExpression
     */
    L ge(int index, SerializableLocalDateTimeSupplier property);

    /**
     * great and equals. 大于等于.
     *
     * @param index          the index
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(int index, SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param index    the index
     * @param property 对象属性
     * @return LogicExpression
     */
    default L ge(int index, SerializableStringSupplier property) {
        return ge(index, property, MatchStrategy.AUTO);
    }

    /**
     * great and equals. 大于等于.
     *
     * @param index          the index
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ge(int index, SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return ge(index, property, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * great and equals. 大于等于.
     *
     * @param index             the index
     * @param property          对象属性
     * @param mathMatchStrategy the math match strategy
     * @return LogicExpression
     */
    L ge(int index, SerializableStringSupplier property, MatchStrategy mathMatchStrategy);

    /**
     * great and equals. 大于等于.
     *
     * @param index             the index
     * @param property          对象属性
     * @param mathMatchStrategy the math match strategy
     * @param ignoreStrategy    the ignore strategy
     * @return LogicExpression
     */
    L ge(int index, SerializableStringSupplier property, MatchStrategy mathMatchStrategy,
            Predicate<String> ignoreStrategy);
}