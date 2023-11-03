
/*
 * All rights Reserved, Designed By zhongj
 * @Title: ConpareEntityExpression.java
 * @Package cn.featherfly.hammer.expression.entity.condition
 * @Description: ConpareEntityExpression
 * @author: zhongj
 * @date: 2023-07-19 18:01:19
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

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.AliasField;
import cn.featherfly.common.repository.Field;
import cn.featherfly.common.repository.IgnoreStrategy;

/**
 * compare expression.
 *
 * @author zhongj
 */
public interface CompareExpression extends CompareSupplierExpression {

    /**
     * compare. 比较
     *
     * @param name  the name
     * @param value the value
     */
    default void accept(String name, int value) {
        accept(name, value, (IntPredicate) getIgnoreStrategy()::test);
    }

    /**
     * compare. 比较
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    void accept(String name, int value, IntPredicate ignoreStrategy);

    /**
     * compare. 比较
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    default void accept(String name, int value, IgnoreStrategy ignoreStrategy) {
        accept(name, value, (IntPredicate) ignoreStrategy::test);
    }

    /**
     * compare. 比较
     *
     * @param field the field
     * @param value the value
     */
    default void accept(Field field, int value) {
        accept(field.name(), value);
    }

    /**
     * compare. 比较
     *
     * @param field            the field
     * @param value            the value
     * @param ignoIntPredicate the igno int predicate
     */
    default void accept(Field field, int value, IntPredicate ignoIntPredicate) {
        accept(field.name(), value, ignoIntPredicate);
    }

    /**
     * compare. 比较
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    default void accept(Field field, int value, IgnoreStrategy ignoreStrategy) {
        accept(field.name(), value, ignoreStrategy);
    }

    /**
     * compare. 比较
     *
     * @param field the field
     * @param value the value
     */
    default void accept(AliasField field, int value) {
        accept(field.getAliasOrName(), value);
    }

    /**
     * compare. 比较
     *
     * @param field            the field
     * @param value            the value
     * @param ignoIntPredicate the igno int predicate
     */
    default void accept(AliasField field, int value, IntPredicate ignoIntPredicate) {
        accept(field.getAliasOrName(), value, ignoIntPredicate);
    }

    /**
     * compare. 比较
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    default void accept(AliasField field, int value, IgnoreStrategy ignoreStrategy) {
        accept(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * compare. 比较
     *
     * @param name  the name
     * @param value the value
     */
    default void accept(String name, long value) {
        accept(name, value, (LongPredicate) getIgnoreStrategy()::test);
    }

    /**
     * compare. 比较
     *
     * @param field the field
     * @param value the value
     */
    default void accept(Field field, long value) {
        accept(field.name(), value);
    }

    /**
     * compare. 比较
     *
     * @param field the field
     * @param value the value
     */
    default void accept(AliasField field, long value) {
        accept(field.getAliasOrName(), value);
    }

    /**
     * compare. 比较
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    void accept(String name, long value, LongPredicate ignoreStrategy);

    /**
     * compare. 比较
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    default void accept(String name, long value, IgnoreStrategy ignoreStrategy) {
        accept(name, value, (LongPredicate) ignoreStrategy::test);
    }

    /**
     * compare. 比较
     *
     * @param field            the field
     * @param value            the value
     * @param ignoIntPredicate the igno int predicate
     */
    default void accept(Field field, long value, LongPredicate ignoIntPredicate) {
        accept(field.name(), value, ignoIntPredicate);
    }

    /**
     * compare. 比较
     *
     * @param field            the field
     * @param value            the value
     * @param ignoIntPredicate the igno int predicate
     */
    default void accept(Field field, long value, IgnoreStrategy ignoIntPredicate) {
        accept(field.name(), value, ignoIntPredicate);
    }

    /**
     * compare. 比较
     *
     * @param field            the field
     * @param value            the value
     * @param ignoIntPredicate the igno int predicate
     */
    default void accept(AliasField field, long value, LongPredicate ignoIntPredicate) {
        accept(field.getAliasOrName(), value, ignoIntPredicate);
    }

    /**
     * compare. 比较
     *
     * @param field            the field
     * @param value            the value
     * @param ignoIntPredicate the igno int predicate
     */
    default void accept(AliasField field, long value, IgnoreStrategy ignoIntPredicate) {
        accept(field.getAliasOrName(), value, ignoIntPredicate);
    }

    /**
     * compare. 比较
     *
     * @param name  the name
     * @param value the value
     */
    default void accept(String name, double value) {
        accept(name, value, (DoublePredicate) getIgnoreStrategy()::test);
    }

    /**
     * compare. 比较
     *
     * @param field the field
     * @param value the value
     */
    default void accept(Field field, double value) {
        accept(field.name(), value);
    }

    /**
     * compare. 比较
     *
     * @param field the field
     * @param value the value
     */
    default void accept(AliasField field, double value) {
        accept(field.getAliasOrName(), value);
    }

    /**
     * compare. 比较
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    void accept(String name, double value, DoublePredicate ignoreStrategy);

    /**
     * compare. 比较
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    default void accept(String name, double value, IgnoreStrategy ignoreStrategy) {
        accept(name, value, (DoublePredicate) ignoreStrategy::test);
    }

    /**
     * compare. 比较
     *
     * @param field            the field
     * @param value            the value
     * @param ignoIntPredicate the igno int predicate
     */
    default void accept(Field field, double value, DoublePredicate ignoIntPredicate) {
        accept(field.name(), value, ignoIntPredicate);
    }

    /**
     * compare. 比较
     *
     * @param field            the field
     * @param value            the value
     * @param ignoIntPredicate the igno int predicate
     */
    default void accept(Field field, double value, IgnoreStrategy ignoIntPredicate) {
        accept(field.name(), value, ignoIntPredicate);
    }

    /**
     * compare. 比较
     *
     * @param field            the field
     * @param value            the value
     * @param ignoIntPredicate the igno int predicate
     */
    default void accept(AliasField field, double value, DoublePredicate ignoIntPredicate) {
        accept(field.getAliasOrName(), value, ignoIntPredicate);
    }

    /**
     * compare. 比较
     *
     * @param field            the field
     * @param value            the value
     * @param ignoIntPredicate the igno int predicate
     */
    default void accept(AliasField field, double value, IgnoreStrategy ignoIntPredicate) {
        accept(field.getAliasOrName(), value, ignoIntPredicate);
    }

    /**
     * compare. 比较
     *
     * @param <N>   number type
     * @param name  the name
     * @param value the value
     */
    default <N extends Number> void accept(String name, N value) {
        accept(name, value, getIgnoreStrategy()::test);
    }

    /**
     * compare. 比较
     *
     * @param <N>            number type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    <N extends Number> void accept(String name, N value, Predicate<N> ignoreStrategy);

    /**
     * compare. 比较
     *
     * @param <N>            number type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    default <N extends Number> void accept(String name, N value, IgnoreStrategy ignoreStrategy) {
        accept(name, value, ignoreStrategy::test);
    }

    /**
     * compare. 比较
     *
     * @param <N>   number type
     * @param field the field
     * @param value the value
     */
    default <N extends Number> void accept(Field field, N value) {
        accept(field.name(), value);
    }

    /**
     * compare. 比较
     *
     * @param <N>            number type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    default <N extends Number> void accept(Field field, N value, Predicate<N> ignoreStrategy) {
        accept(field.name(), value, ignoreStrategy);
    }

    /**
     * compare. 比较
     *
     * @param <N>            number type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    default <N extends Number> void accept(Field field, N value, IgnoreStrategy ignoreStrategy) {
        accept(field.name(), value, ignoreStrategy);
    }

    /**
     * compare. 比较
     *
     * @param <N>   number type
     * @param field the field
     * @param value the value
     */
    default <N extends Number> void accept(AliasField field, N value) {
        accept(field.getAliasOrName(), value);
    }

    /**
     * compare. 比较
     *
     * @param <N>            number type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    default <N extends Number> void accept(AliasField field, N value, Predicate<N> ignoreStrategy) {
        accept(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * compare. 比较
     *
     * @param <N>            number type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    default <N extends Number> void accept(AliasField field, N value, IgnoreStrategy ignoreStrategy) {
        accept(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * compare. 比较
     *
     * @param <D>   date type
     * @param name  the name
     * @param value the value
     */
    default <D extends Date> void accept(String name, D value) {
        accept(name, value, getIgnoreStrategy()::test);
    }

    /**
     * compare. 比较
     *
     * @param <D>            date type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    <D extends Date> void accept(String name, D value, Predicate<D> ignoreStrategy);

    /**
     * compare. 比较
     *
     * @param <D>            date type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    default <D extends Date> void accept(String name, D value, IgnoreStrategy ignoreStrategy) {
        accept(name, value, ignoreStrategy::test);
    }

    /**
     * compare. 比较
     *
     * @param <D>   date type
     * @param field the field
     * @param value the value
     */
    default <D extends Date> void accept(Field field, D value) {
        accept(field.name(), value);
    }

    /**
     * compare. 比较
     *
     * @param <D>            date type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    default <D extends Date> void accept(Field field, D value, Predicate<D> ignoreStrategy) {
        accept(field.name(), value, ignoreStrategy);
    }

    /**
     * compare. 比较
     *
     * @param <D>            date type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    default <D extends Date> void accept(Field field, D value, IgnoreStrategy ignoreStrategy) {
        accept(field.name(), value, ignoreStrategy);
    }

    /**
     * compare. 比较
     *
     * @param <D>   date type
     * @param field the field
     * @param value the value
     */
    default <D extends Date> void accept(AliasField field, D value) {
        accept(field.getAliasOrName(), value);
    }

    /**
     * compare. 比较
     *
     * @param <D>            date type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    default <D extends Date> void accept(AliasField field, D value, Predicate<D> ignoreStrategy) {
        accept(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * compare. 比较
     *
     * @param <D>            date type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    default <D extends Date> void accept(AliasField field, D value, IgnoreStrategy ignoreStrategy) {
        accept(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * compare. 比较
     *
     * @param <D>   date type
     * @param name  the name
     * @param value the value
     */
    default <E extends Enum<E>> void accept(String name, E value) {
        accept(name, value, getIgnoreStrategy()::test);
    }

    /**
     * compare. 比较
     *
     * @param <D>            date type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    <E extends Enum<E>> void accept(String name, E value, Predicate<E> ignoreStrategy);

    /**
     * compare. 比较
     *
     * @param <D>            date type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    default <E extends Enum<E>> void accept(String name, E value, IgnoreStrategy ignoreStrategy) {
        accept(name, value, ignoreStrategy::test);
    }

    /**
     * compare. 比较
     *
     * @param <D>   date type
     * @param field the field
     * @param value the value
     */
    default <E extends Enum<E>> void accept(Field field, E value) {
        accept(field.name(), value);
    }

    /**
     * compare. 比较
     *
     * @param <D>            date type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    default <E extends Enum<E>> void accept(Field field, E value, Predicate<E> ignoreStrategy) {
        accept(field.name(), value, ignoreStrategy);
    }

    /**
     * compare. 比较
     *
     * @param <D>            date type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    default <E extends Enum<E>> void accept(Field field, E value, IgnoreStrategy ignoreStrategy) {
        accept(field.name(), value, ignoreStrategy);
    }

    /**
     * compare. 比较
     *
     * @param <D>   date type
     * @param field the field
     * @param value the value
     */
    default <E extends Enum<E>> void accept(AliasField field, E value) {
        accept(field.getAliasOrName(), value);
    }

    /**
     * compare. 比较
     *
     * @param <E>            date type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    default <E extends Enum<E>> void accept(AliasField field, E value, Predicate<E> ignoreStrategy) {
        accept(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * compare. 比较
     *
     * @param <E>            date type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    default <E extends Enum<E>> void accept(AliasField field, E value, IgnoreStrategy ignoreStrategy) {
        accept(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * compare. 比较
     *
     * @param name  the name
     * @param value the value
     */
    default void accept(String name, LocalTime value) {
        accept(name, value, getIgnoreStrategy()::test);
    }

    /**
     * compare. 比较
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    void accept(String name, LocalTime value, Predicate<LocalTime> ignoreStrategy);

    /**
     * compare. 比较
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    default void accept(String name, LocalTime value, IgnoreStrategy ignoreStrategy) {
        accept(name, value, ignoreStrategy::test);
    }

    /**
     * compare. 比较
     *
     * @param field the field
     * @param value the value
     */
    default void accept(Field field, LocalTime value) {
        accept(field.name(), value);
    }

    /**
     * compare. 比较
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    default void accept(Field field, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        accept(field.name(), value, ignoreStrategy);
    }

    /**
     * compare. 比较
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    default void accept(Field field, LocalTime value, IgnoreStrategy ignoreStrategy) {
        accept(field.name(), value, ignoreStrategy);
    }

    /**
     * compare. 比较
     *
     * @param field the field
     * @param value the value
     */
    default void accept(AliasField field, LocalTime value) {
        accept(field.getAliasOrName(), value);
    }

    /**
     * compare. 比较
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    default void accept(AliasField field, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        accept(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * compare. 比较
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    default void accept(AliasField field, LocalTime value, IgnoreStrategy ignoreStrategy) {
        accept(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * compare. 比较
     *
     * @param name  the name
     * @param value the value
     */
    default void accept(String name, LocalDate value) {
        accept(name, value, getIgnoreStrategy()::test);
    }

    /**
     * compare. 比较
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    void accept(String name, LocalDate value, Predicate<LocalDate> ignoreStrategy);

    /**
     * compare. 比较
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    default void accept(String name, LocalDate value, IgnoreStrategy ignoreStrategy) {
        accept(name, value, ignoreStrategy::test);
    }

    /**
     * compare. 比较
     *
     * @param field the field
     * @param value the value
     */
    default void accept(Field field, LocalDate value) {
        accept(field.name(), value);
    }

    /**
     * compare. 比较
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    default void accept(Field field, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        accept(field.name(), value, ignoreStrategy);
    }

    /**
     * compare. 比较
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    default void accept(Field field, LocalDate value, IgnoreStrategy ignoreStrategy) {
        accept(field.name(), value, ignoreStrategy);
    }

    /**
     * compare. 比较
     *
     * @param field the field
     * @param value the value
     */
    default void accept(AliasField field, LocalDate value) {
        accept(field.getAliasOrName(), value);
    }

    /**
     * compare. 比较
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    default void accept(AliasField field, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        accept(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * compare. 比较
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    default void accept(AliasField field, LocalDate value, IgnoreStrategy ignoreStrategy) {
        accept(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * compare. 比较
     *
     * @param name  the name
     * @param value the value
     */
    default void accept(String name, LocalDateTime value) {
        accept(name, value, getIgnoreStrategy()::test);
    }

    /**
     * compare. 比较
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    void accept(String name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * compare. 比较
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    default void accept(String name, LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        accept(name, value, ignoreStrategy::test);
    }

    /**
     * compare. 比较
     *
     * @param field the field
     * @param value the value
     */
    default void accept(Field field, LocalDateTime value) {
        accept(field.name(), value);
    }

    /**
     * compare. 比较
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    default void accept(Field field, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        accept(field.name(), value, ignoreStrategy);
    }

    /**
     * compare. 比较
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    default void accept(Field field, LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        accept(field.name(), value, ignoreStrategy);
    }

    /**
     * compare. 比较
     *
     * @param field the field
     * @param value the value
     */
    default void accept(AliasField field, LocalDateTime value) {
        accept(field.getAliasOrName(), value);
    }

    /**
     * compare. 比较
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    default void accept(AliasField field, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        accept(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * compare. 比较
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    default void accept(AliasField field, LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        accept(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * compare. 比较
     *
     * @param name  the name
     * @param value the value
     */
    default void accept(String name, String value) {
        accept(name, value, MatchStrategy.AUTO);
    }

    /**
     * compare. 比较
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     */
    default void accept(String name, String value, MatchStrategy matchStrategy) {
        accept(name, value, matchStrategy, getIgnoreStrategy()::test);
    }

    /**
     * compare. 比较
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    default void accept(String name, String value, Predicate<String> ignoreStrategy) {
        accept(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * compare. 比较
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     */
    void accept(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);

    /**
     * compare. 比较
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    default void accept(String name, String value, IgnoreStrategy ignoreStrategy) {
        accept(name, value, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * compare. 比较
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    default void accept(String name, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        accept(name, value, matchStrategy, ignoreStrategy::test);
    }

    /**
     * compare. 比较
     *
     * @param field the field
     * @param value the value
     */
    default void accept(Field field, String value) {
        accept(field.name(), value);
    }

    /**
     * compare. 比较
     *
     * @param field         the field
     * @param value         the value
     * @param matchStrategy the match strategy
     */
    default void accept(Field field, String value, MatchStrategy matchStrategy) {
        accept(field.name(), value, matchStrategy);
    }

    /**
     * compare. 比较
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    default void accept(Field field, String value, Predicate<String> ignoreStrategy) {
        accept(field.name(), value, ignoreStrategy);
    }

    /**
     * compare. 比较
     *
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     */
    default void accept(Field field, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        accept(field.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * compare. 比较
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    default void accept(Field field, String value, IgnoreStrategy ignoreStrategy) {
        accept(field.name(), value, ignoreStrategy);
    }

    /**
     * compare. 比较
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    default void accept(Field field, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        accept(field.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * compare. 比较
     *
     * @param field the field
     * @param value the value
     */
    default void accept(AliasField field, String value) {
        accept(field.getAliasOrName(), value);
    }

    /**
     * compare. 比较
     *
     * @param field the field
     * @param value the value
     */
    default void accept(AliasField field, String value, MatchStrategy matchStrategy) {
        accept(field.getAliasOrName(), value, matchStrategy);
    }

    /**
     * compare. 比较
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    default void accept(AliasField field, String value, Predicate<String> ignoreStrategy) {
        accept(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * compare. 比较
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    default void accept(AliasField field, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        accept(field.getAliasOrName(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * compare. 比较
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    default void accept(AliasField field, String value, IgnoreStrategy ignoreStrategy) {
        accept(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * compare. 比较
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     */
    default void accept(AliasField field, String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        accept(field.getAliasOrName(), value, matchStrategy, ignoreStrategy);
    }
}
