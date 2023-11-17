
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-14 15:01:14
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.condition.field;

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
import cn.featherfly.common.function.serializable.SerializableIntSupplier;
import cn.featherfly.common.function.serializable.SerializableLocalDateSupplier;
import cn.featherfly.common.function.serializable.SerializableLocalDateTimeSupplier;
import cn.featherfly.common.function.serializable.SerializableLocalTimeSupplier;
import cn.featherfly.common.function.serializable.SerializableLongSupplier;
import cn.featherfly.common.function.serializable.SerializableNumberSupplier;
import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.IgnorableExpression;

/**
 * compare supplier expression.
 *
 * @author zhongj
 */
public interface CompareSupplierExpression extends IgnorableExpression {

    /**
     * compare. 比较
     *
     * @param property  bean property
     */
    default void accept(SerializableIntSupplier property) {
        accept(property, (IntPredicate) getIgnoreStrategy()::test);
    }

    /**
     * compare. 比较
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     */
    void accept(SerializableIntSupplier property, IntPredicate ignoreStrategy);

    /**
     * compare. 比较
     *
     * @param property  bean property
     */
    default void accept(SerializableLongSupplier property) {
        accept(property, (LongPredicate) getIgnoreStrategy()::test);
    }

    /**
     * compare. 比较
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     */
    void accept(SerializableLongSupplier property, LongPredicate ignoreStrategy);

    /**
     * compare. 比较
     *
     * @param property  bean property
     */
    default void accept(SerializableDoubleSupplier property) {
        accept(property, (DoublePredicate) getIgnoreStrategy()::test);
    }

    /**
     * compare. 比较
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     */
    void accept(SerializableDoubleSupplier property, DoublePredicate ignoreStrategy);

    /**
     * compare. 比较
     *
     * @param <D>      the generic type
     * @param property  bean property
     */
    default <D extends Date> void accept(SerializableDateSupplier<D> property) {
        accept(property, getIgnoreStrategy()::test);
    }

    /**
     * compare. 比较
     *
     * @param <D>            the generic type
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     */
    <D extends Date> void accept(SerializableDateSupplier<D> property, Predicate<D> ignoreStrategy);

    /**
     * compare. 比较
     *
     * @param <R>      the generic type
     * @param property  bean property
     */
    default <R extends Number> void accept(SerializableNumberSupplier<R> property) {
        accept(property, getIgnoreStrategy()::test);
    }

    /**
     * compare. 比较
     *
     * @param <R>            the generic type
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     */
    <R extends Number> void accept(SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy);

    /**
     * compare. 比较
     *
     * @param property  bean property
     */
    default void accept(SerializableLocalDateSupplier property) {
        accept(property, getIgnoreStrategy()::test);
    }

    /**
     * compare. 比较
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     */
    void accept(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy);

    /**
     * compare. 比较
     *
     * @param property  bean property
     */
    default void accept(SerializableLocalTimeSupplier property) {
        accept(property, getIgnoreStrategy()::test);
    }

    /**
     * compare. 比较
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     */
    void accept(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy);

    /**
     * compare. 比较
     *
     * @param property  bean property
     */
    default void accept(SerializableLocalDateTimeSupplier property) {
        accept(property, getIgnoreStrategy()::test);
    }

    /**
     * compare. 比较
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     */
    void accept(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * compare. 比较
     *
     * @param property  bean property
     */
    default void accept(SerializableStringSupplier property) {
        accept(property, getIgnoreStrategy()::test);
    }

    /**
     * compare. 比较
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     */
    default void accept(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        accept(property, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * compare. 比较
     *
     * @param property  bean property
     * @param matchStrategy the match strategy
     */
    default void accept(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        accept(property, matchStrategy, getIgnoreStrategy()::test);
    }

    /**
     * compare. 比较
     *
     * @param property       bean property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     */
    void accept(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);

}
