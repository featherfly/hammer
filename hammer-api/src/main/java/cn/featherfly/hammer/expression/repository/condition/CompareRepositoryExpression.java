
/*
 * All rights Reserved, Designed By zhongj
 * @Title: ConpareEntityExpression.java
 * @Package cn.featherfly.hammer.expression.entity.condition
 * @Description: ConpareEntityExpression
 * @author: zhongj
 * @date: 2023-07-19 18:01:19
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.repository.condition;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableToDateFunction;
import cn.featherfly.common.function.serializable.SerializableToDoubleFunction;
import cn.featherfly.common.function.serializable.SerializableToIntFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalDateFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalDateTimeFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalTimeFunction;
import cn.featherfly.common.function.serializable.SerializableToLongFunction;
import cn.featherfly.common.function.serializable.SerializableToNumberFunction;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.field.CompareExpression;

/**
 * repository compare expression.
 *
 * @author zhongj
 */
public interface CompareRepositoryExpression extends CompareExpression, CompareRepositoryFieldExpression {
    //    , RepositoryComparePropertyExpression  {
    // TODO 后续来处理这个逻辑，应该是不需要了，因为BeanPropertyGetter是继承自SerialableFunction

    /**
     * compare. 比较
     *
     * @param <T>   the generic type
     * @param name  the name
     * @param value the value
     */
    default <T> void accept(SerializableToIntFunction<T> name, int value) {
        accept(name, value, (IntPredicate) getIgnoreStrategy()::test);
    }

    /**
     * compare. 比较
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    <T> void accept(SerializableToIntFunction<T> name, int value, IntPredicate ignoreStrategy);

    /**
     * compare. 比较
     *
     * @param <T>   the generic type
     * @param name  the name
     * @param value the value
     */
    default <T> void accept(SerializableToLongFunction<T> name, long value) {
        accept(name, value, (LongPredicate) getIgnoreStrategy()::test);
    }

    /**
     * compare. 比较
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    <T> void accept(SerializableToLongFunction<T> name, long value, LongPredicate ignoreStrategy);

    /**
     * compare. 比较
     *
     * @param <T>   the generic type
     * @param name  the name
     * @param value the value
     */
    default <T> void accept(SerializableToDoubleFunction<T> name, double value) {
        accept(name, value, (DoublePredicate) getIgnoreStrategy()::test);
    }

    /**
     * compare. 比较
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    <T> void accept(SerializableToDoubleFunction<T> name, double value, DoublePredicate ignoreStrategy);

    /**
     * compare. 比较
     *
     * @param <T>   the generic type
     * @param <N>   number type
     * @param name  the name
     * @param value the value
     */
    default <T, N extends Number> void accept(SerializableToNumberFunction<T, N> name, N value) {
        accept(name, value, getIgnoreStrategy()::test);
    }

    /**
     * compare. 比较
     *
     * @param <T>            the generic type
     * @param <N>            number type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    <T, N extends Number> void accept(SerializableToNumberFunction<T, N> name, N value, Predicate<N> ignoreStrategy);

    /**
     * compare. 比较
     *
     * @param <T>   the generic type
     * @param <D>   date type
     * @param name  the name
     * @param value the value
     */
    default <T, D extends Date> void accept(SerializableToDateFunction<T, D> name, D value) {
        accept(name, value, getIgnoreStrategy()::test);
    }

    /**
     * compare. 比较
     *
     * @param <T>            the generic type
     * @param <D>            date type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    <T, D extends Date> void accept(SerializableToDateFunction<T, D> name, D value, Predicate<D> ignoreStrategy);

    /**
     * compare. 比较
     *
     * @param <T>   the generic type
     * @param name  the name
     * @param value the value
     */
    default <T> void accept(SerializableToLocalTimeFunction<T> name, LocalTime value) {
        accept(name, value, getIgnoreStrategy()::test);
    }

    /**
     * compare. 比较
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    <T> void accept(SerializableToLocalTimeFunction<T> name, LocalTime value, Predicate<LocalTime> ignoreStrategy);

    /**
     * compare. 比较
     *
     * @param <T>   the generic type
     * @param name  the name
     * @param value the value
     */
    default <T> void accept(SerializableToLocalDateFunction<T> name, LocalDate value) {
        accept(name, value, getIgnoreStrategy()::test);
    }

    /**
     * compare. 比较
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    <T> void accept(SerializableToLocalDateFunction<T> name, LocalDate value, Predicate<LocalDate> ignoreStrategy);

    /**
     * compare. 比较
     *
     * @param <T>   the generic type
     * @param name  the name
     * @param value the value
     */
    default <T> void accept(SerializableToLocalDateTimeFunction<T> name, LocalDateTime value) {
        accept(name, value, getIgnoreStrategy()::test);
    }

    /**
     * compare. 比较
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    <T> void accept(SerializableToLocalDateTimeFunction<T> name, LocalDateTime value,
            Predicate<LocalDateTime> ignoreStrategy);

    /**
     * compare. 比较
     *
     * @param <T>   the generic type
     * @param name  the name
     * @param value the value
     */
    default <T> void accept(SerializableToStringFunction<T> name, String value) {
        accept(name, value, getIgnoreStrategy()::test);
    }

    /**
     * compare. 比较
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    default <T> void accept(SerializableToStringFunction<T> name, String value, Predicate<String> ignoreStrategy) {
        accept(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * equals or not equals. 等于或者不等于.
     *
     * @param <T>           the generic type
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     */
    default <T> void accept(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy) {
        accept(name, value, matchStrategy, getIgnoreStrategy()::test);
    }

    /**
     * equals or not equals. 等于或者不等于.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     */
    <T> void accept(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy);
}
