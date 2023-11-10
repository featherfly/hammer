
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-15 19:30:15
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.condition;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiPredicate;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableArraySupplier;
import cn.featherfly.common.function.serializable.SerializableDoubleSupplier;
import cn.featherfly.common.function.serializable.SerializableIntSupplier;
import cn.featherfly.common.function.serializable.SerializableLongSupplier;
import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.function.serializable.SerializableToDoubleFunction;
import cn.featherfly.common.function.serializable.SerializableToIntFunction;
import cn.featherfly.common.function.serializable.SerializableToLongFunction;
import cn.featherfly.common.operator.ComparisonOperator;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.IgnorableExpression;
import cn.featherfly.hammer.expression.condition.MulitiRepositoryExpression;

/**
 * internal muliti condition.
 *
 * @author zhongj
 * @param <L> the generic type
 */
public interface InternalMulitiCondition<L> extends MulitiRepositoryExpression, IgnorableExpression {
    /**
     * between and.
     *
     * @param <V>            the value type
     * @param index          the index
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <V> L ba(AtomicInteger index, Serializable name, V min, V max) {
        return ba(index, name, min, max, getIgnoreStrategy());
    }

    /**
     * between and.
     *
     * @param <V>            the value type
     * @param index          the index
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L ba(AtomicInteger index, Serializable name, V min, V max, BiPredicate<V, V> ignoreStrategy);

    /**
     * between and.
     *
     * @param <V>            the value type
     * @param index          the index
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L ba(AtomicInteger index, Serializable name, V min, V max, Predicate<?> ignoreStrategy);

    /**
     * between and.
     *
     * @param <V>            the value type
     * @param index          the index
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    <V> L ba(AtomicInteger index, String name, V min, V max, BiPredicate<V, V> ignoreStrategy);

    /**
     * between and.
     *
     * @param <V>            the value type
     * @param index          the index
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L ba(AtomicInteger index, String name, V min, V max, Predicate<?> ignoreStrategy);

    // ********************************************************************

    /**
     * not between and.
     *
     * @param <V>            the value type
     * @param index          the index
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L nba(AtomicInteger index, Serializable name, V min, V max, BiPredicate<V, V> ignoreStrategy);

    /**
     * not between and.
     *
     * @param <V>            the value type
     * @param index          the index
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L nba(AtomicInteger index, Serializable name, V min, V max, Predicate<?> ignoreStrategy);

    /**
     * not between and.
     *
     * @param <V>            the value type
     * @param index          the index
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L nba(AtomicInteger index, String name, V min, V max, BiPredicate<V, V> ignoreStrategy);

    /**
     * not between and.
     *
     * @param <V>            the value type
     * @param index          the index
     * @param name           the name
     * @param min            the min
     * @param max            the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L nba(AtomicInteger index, String name, V min, V max, Predicate<?> ignoreStrategy);

    // ********************************************************************

    /**
     * equals.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L eq(AtomicInteger index, SerializableSupplier<R> property, Predicate<?> ignoreStrategy);

    /**
     * equals.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param property       the property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L eq(AtomicInteger index, SerializableSupplier<R> property, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy);

    /**
     * equals.
     *
     * @param index          the index
     * @param property       the property
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq(AtomicInteger index, Serializable property, int value, IntPredicate ignoreStrategy);

    /**
     * equals.
     *
     * @param index          the index
     * @param property       the property
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq(AtomicInteger index, Serializable property, long value, LongPredicate ignoreStrategy);

    /**
     * equals.
     *
     * @param index          the index
     * @param property       the property
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq(AtomicInteger index, Serializable property, double value, DoublePredicate ignoreStrategy);

    /**
     * equals.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param property       the property
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L eq(AtomicInteger index, Serializable property, R value, Predicate<?> ignoreStrategy);

    /**
     * equals.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param property       the property
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L eq(AtomicInteger index, Serializable property, R value, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy);

    /**
     * equals.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq(AtomicInteger index, String name, int value, IntPredicate ignoreStrategy);

    /**
     * equals.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq(AtomicInteger index, String name, long value, LongPredicate ignoreStrategy);

    /**
     * equals.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq(AtomicInteger index, String name, double value, DoublePredicate ignoreStrategy);

    /**
     * equals.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L eq(AtomicInteger index, String name, R value, Predicate<?> ignoreStrategy);

    /**
     * equals.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L eq(AtomicInteger index, String name, R value, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy);

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * not equals.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L ne(AtomicInteger index, SerializableSupplier<R> property, Predicate<?> ignoreStrategy);

    /**
     * not equals.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param property       the property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L ne(AtomicInteger index, SerializableSupplier<R> property, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy);

    /**
     * not equals.
     *
     * @param index          the index
     * @param property       the property
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne(AtomicInteger index, Serializable property, int value, IntPredicate ignoreStrategy);

    /**
     * not equals.
     *
     * @param index          the index
     * @param property       the property
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne(AtomicInteger index, Serializable property, long value, LongPredicate ignoreStrategy);

    /**
     * not equals.
     *
     * @param index          the index
     * @param property       the property
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne(AtomicInteger index, Serializable property, double value, DoublePredicate ignoreStrategy);

    /**
     * not equals.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param property       the property
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L ne(AtomicInteger index, Serializable property, R value, Predicate<?> ignoreStrategy);

    /**
     * not equals.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param property       the property
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L ne(AtomicInteger index, Serializable property, R value, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy);

    /**
     * not equals.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne(AtomicInteger index, String name, int value, IntPredicate ignoreStrategy);

    /**
     * not equals.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne(AtomicInteger index, String name, long value, LongPredicate ignoreStrategy);

    /**
     * not equals.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne(AtomicInteger index, String name, double value, DoublePredicate ignoreStrategy);

    /**
     * not equals.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L ne(AtomicInteger index, String name, R value, Predicate<?> ignoreStrategy);

    /**
     * not equals.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L ne(AtomicInteger index, String name, R value, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy);

    /**
     * equals or not equals.
     *
     * @param <R>                the generic type
     * @param index              the index
     * @param comparisonOperator the comparison operator
     * @param name               the name
     * @param value              the value
     * @param matchStrategy      the match strategy
     * @param ignoreStrategy     the ignore strategy
     * @return LogicExpression
     */
    <R> L eqOrNe(AtomicInteger index, ComparisonOperator comparisonOperator, String name, R value,
            MatchStrategy matchStrategy, Predicate<?> ignoreStrategy);

    // ****************************************************************************************************************

    /**
     * start with value.
     *
     * @param index          the index
     * @param property       the property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L sw(AtomicInteger index, SerializableSupplier<String> property, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy);

    /**
     * start with value.
     *
     * @param index          the index
     * @param property       the property
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L sw(AtomicInteger index, Serializable property, String value, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy);

    /**
     * start with value.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L sw(AtomicInteger index, String name, String value, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy);

    // ****************************************************************************************************************

    /**
     * not start with value.
     *
     * @param index          the index
     * @param property       the property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nsw(AtomicInteger index, SerializableSupplier<String> property, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy);

    /**
     * not start with value.
     *
     * @param index          the index
     * @param property       the property
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nsw(AtomicInteger index, Serializable property, String value, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy);

    /**
     * not start with value.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nsw(AtomicInteger index, String name, String value, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy);

    // ****************************************************************************************************************

    /**
     * contains value.
     *
     * @param index          the index
     * @param property       the property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L co(AtomicInteger index, SerializableSupplier<String> property, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy);

    /**
     * contains value.
     *
     * @param index          the index
     * @param property       the property
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L co(AtomicInteger index, Serializable property, String value, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy);

    /**
     * contains value.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L co(AtomicInteger index, String name, String value, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy);

    // ****************************************************************************************************************

    /**
     * not contains value.
     *
     * @param index          the index
     * @param property       the property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nco(AtomicInteger index, SerializableSupplier<String> property, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy);

    /**
     * not contains value.
     *
     * @param index          the index
     * @param property       the property
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nco(AtomicInteger index, Serializable property, String value, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy);

    /**
     * not contains value.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nco(AtomicInteger index, String name, String value, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy);

    // ****************************************************************************************************************

    /**
     * end with value.
     *
     * @param index          the index
     * @param property       the property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ew(AtomicInteger index, SerializableSupplier<String> property, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy);

    /**
     * end with value.
     *
     * @param index          the index
     * @param property       the property
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ew(AtomicInteger index, Serializable property, String value, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy);

    /**
     * end with value.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ew(AtomicInteger index, String name, String value, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy);

    // ****************************************************************************************************************

    /**
     * not end with value.
     *
     * @param index          the index
     * @param property       the property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L newv(AtomicInteger index, SerializableSupplier<String> property, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy);

    /**
     * not end with value.
     *
     * @param index          the index
     * @param property       the property
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L newv(AtomicInteger index, Serializable property, String value, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy);

    /**
     * not end with value.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L newv(AtomicInteger index, String name, String value, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy);

    // ****************************************************************************************************************

    /**
     * like.
     *
     * @param index          the index
     * @param property       the property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lk(AtomicInteger index, SerializableSupplier<String> property, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy);

    /**
     * like.
     *
     * @param index          the index
     * @param property       the property
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lk(AtomicInteger index, Serializable property, String value, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy);

    /**
     * like.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lk(AtomicInteger index, String name, String value, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy);

    // ****************************************************************************************************************

    /**
     * not like.
     *
     * @param index          the index
     * @param property       the property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nl(AtomicInteger index, SerializableSupplier<String> property, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy);

    /**
     * not like.
     *
     * @param index          the index
     * @param property       the property
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nl(AtomicInteger index, Serializable property, String value, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy);

    /**
     * not like.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nl(AtomicInteger index, String name, String value, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy);

    // ****************************************************************************************************************

    /**
     * in.
     *
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in(AtomicInteger index, SerializableIntSupplier property, IntPredicate ignoreStrategy);

    /**
     * in.
     *
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in(AtomicInteger index, SerializableIntSupplier property, Predicate<?> ignoreStrategy);

    /**
     * in.
     *
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in(AtomicInteger index, SerializableLongSupplier property, LongPredicate ignoreStrategy);

    /**
     * in.
     *
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in(AtomicInteger index, SerializableLongSupplier property, Predicate<?> ignoreStrategy);

    /**
     * in.
     *
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in(AtomicInteger index, SerializableDoubleSupplier property, DoublePredicate ignoreStrategy);

    /**
     * in.
     *
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in(AtomicInteger index, SerializableDoubleSupplier property, Predicate<?> ignoreStrategy);

    /**
     * in.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L in(AtomicInteger index, SerializableSupplier<R> property, Predicate<?> ignoreStrategy);

    /**
     * in.
     *
     * @param index          the index
     * @param property       the property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in(AtomicInteger index, SerializableStringSupplier property, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy);

    /**
     * in.
     *
     * @param index          the index
     * @param property       the property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in(AtomicInteger index, SerializableArraySupplier<String> property, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy);

    /**
     * in.
     *
     * @param <T>            the generic type
     * @param index          the index
     * @param property       the property
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L in(AtomicInteger index, SerializableToIntFunction<T> property, int value, IntPredicate ignoreStrategy);

    /**
     * in.
     *
     * @param <T>            the generic type
     * @param index          the index
     * @param property       the property
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L in(AtomicInteger index, SerializableToLongFunction<T> property, long value, LongPredicate ignoreStrategy);

    /**
     * in.
     *
     * @param <T>            the generic type
     * @param index          the index
     * @param property       the property
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L in(AtomicInteger index, SerializableToDoubleFunction<T> property, double value,
            DoublePredicate ignoreStrategy);

    /**
     * in.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param property       the property
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L in(AtomicInteger index, Serializable property, R value, Predicate<?> ignoreStrategy);

    /**
     * in.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param property       the property
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L in(AtomicInteger index, Serializable property, R value, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy);

    /**
     * in.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in(AtomicInteger index, String name, int value, IntPredicate ignoreStrategy);

    /**
     * in.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in(AtomicInteger index, String name, long value, LongPredicate ignoreStrategy);

    /**
     * in.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in(AtomicInteger index, String name, double value, DoublePredicate ignoreStrategy);

    /**
     * in.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L in(AtomicInteger index, String name, R value, Predicate<?> ignoreStrategy);

    /**
     * in.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L in(AtomicInteger index, String name, R value, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy);

    // ****************************************************************************************************************

    /**
     * not in.
     *
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni(AtomicInteger index, SerializableIntSupplier property, IntPredicate ignoreStrategy);

    /**
     * not in.
     *
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni(AtomicInteger index, SerializableIntSupplier property, Predicate<?> ignoreStrategy);

    /**
     * not in.
     *
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni(AtomicInteger index, SerializableLongSupplier property, LongPredicate ignoreStrategy);

    /**
     * not in.
     *
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni(AtomicInteger index, SerializableLongSupplier property, Predicate<?> ignoreStrategy);

    /**
     * not in.
     *
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni(AtomicInteger index, SerializableDoubleSupplier property, DoublePredicate ignoreStrategy);

    /**
     * not in.
     *
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni(AtomicInteger index, SerializableDoubleSupplier property, Predicate<?> ignoreStrategy);

    /**
     * not in.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L ni(AtomicInteger index, SerializableSupplier<R> property, Predicate<?> ignoreStrategy);

    /**
     * not in.
     *
     * @param <T>            the generic type
     * @param index          the index
     * @param property       the property
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L ni(AtomicInteger index, SerializableToIntFunction<T> property, int value, IntPredicate ignoreStrategy);

    /**
     * not in.
     *
     * @param <T>            the generic type
     * @param index          the index
     * @param property       the property
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L ni(AtomicInteger index, SerializableToLongFunction<T> property, long value, LongPredicate ignoreStrategy);

    /**
     * not in.
     *
     * @param <T>            the generic type
     * @param index          the index
     * @param property       the property
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L ni(AtomicInteger index, SerializableToDoubleFunction<T> property, double value,
            DoublePredicate ignoreStrategy);

    /**
     * not in.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param property       the property
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L ni(AtomicInteger index, Serializable property, R value, Predicate<?> ignoreStrategy);

    /**
     * not in.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param property       the property
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L ni(AtomicInteger index, Serializable property, R value, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy);

    /**
     * not in.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni(AtomicInteger index, String name, int value, IntPredicate ignoreStrategy);

    /**
     * not in.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni(AtomicInteger index, String name, long value, LongPredicate ignoreStrategy);

    /**
     * not in.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni(AtomicInteger index, String name, double value, DoublePredicate ignoreStrategy);

    /**
     * not in.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L ni(AtomicInteger index, String name, R value, Predicate<?> ignoreStrategy);

    /**
     * not in.
     *
     * @param <R>            the generic type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L ni(AtomicInteger index, String name, R value, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy);

    // ****************************************************************************************************************

    /**
     * is null.
     *
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L isn(AtomicInteger index, String name, Boolean value);

    /**
     * is null.
     *
     * @param index    the index
     * @param property the property
     * @param value    the value
     * @return LogicExpression
     */
    L isn(AtomicInteger index, Serializable property, Boolean value);

    /**
     * is not null.
     *
     * @param index    the index
     * @param property the property
     * @param value    the value
     * @return LogicExpression
     */
    L inn(AtomicInteger index, Serializable property, Boolean value);

    /**
     * is not null.
     *
     * @param index the index
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    L inn(AtomicInteger index, String name, Boolean value);

    // ********************************************************************

    /**
     * great equals.
     *
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(AtomicInteger index, SerializableIntSupplier property, IntPredicate ignoreStrategy);

    /**
     * great equals.
     *
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(AtomicInteger index, SerializableLongSupplier property, LongPredicate ignoreStrategy);

    /**
     * great equals.
     *
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(AtomicInteger index, SerializableDoubleSupplier property, DoublePredicate ignoreStrategy);

    /**
     * great equals.
     *
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(AtomicInteger index, SerializableIntSupplier property, Predicate<?> ignoreStrategy);

    /**
     * great equals.
     *
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(AtomicInteger index, SerializableLongSupplier property, Predicate<?> ignoreStrategy);

    /**
     * great equals.
     *
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(AtomicInteger index, SerializableDoubleSupplier property, Predicate<?> ignoreStrategy);

    /**
     * great equals.
     *
     * @param <V>            the value type
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L ge(AtomicInteger index, SerializableSupplier<V> property, Predicate<?> ignoreStrategy);

    /**
     * great equals.
     *
     * @param index          the index
     * @param property       the property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(AtomicInteger index, SerializableStringSupplier property, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy);

    /**
     * great equals.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(AtomicInteger index, SerializableToIntFunction<?> name, int value, IntPredicate ignoreStrategy);

    /**
     * great equals.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(AtomicInteger index, SerializableToLongFunction<?> name, long value, LongPredicate ignoreStrategy);

    /**
     * great equals.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(AtomicInteger index, SerializableToDoubleFunction<?> name, double value, DoublePredicate ignoreStrategy);

    /**
     * great equals.
     *
     * @param <V>            the value type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L ge(AtomicInteger index, Serializable name, V value, Predicate<?> ignoreStrategy);

    /**
     * great equals.
     *
     * @param <V>            the value type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L ge(AtomicInteger index, Serializable name, V value, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy);

    /**
     * great equals.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(AtomicInteger index, String name, int value, IntPredicate ignoreStrategy);

    /**
     * great equals.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(AtomicInteger index, String name, long value, LongPredicate ignoreStrategy);

    /**
     * great equals.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(AtomicInteger index, String name, double value, DoublePredicate ignoreStrategy);

    /**
     * great equals.
     *
     * @param <V>            the value type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L ge(AtomicInteger index, String name, V value, Predicate<?> ignoreStrategy);

    /**
     * great equals.
     *
     * @param <V>            the value type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L ge(AtomicInteger index, String name, V value, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy);

    // ********************************************************************

    /**
     * great than.
     *
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(AtomicInteger index, SerializableIntSupplier property, IntPredicate ignoreStrategy);

    /**
     * great than.
     *
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(AtomicInteger index, SerializableLongSupplier property, LongPredicate ignoreStrategy);

    /**
     * great than.
     *
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(AtomicInteger index, SerializableDoubleSupplier property, DoublePredicate ignoreStrategy);

    /**
     * great than.
     *
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(AtomicInteger index, SerializableIntSupplier property, Predicate<?> ignoreStrategy);

    /**
     * great than.
     *
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(AtomicInteger index, SerializableLongSupplier property, Predicate<?> ignoreStrategy);

    /**
     * great than.
     *
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(AtomicInteger index, SerializableDoubleSupplier property, Predicate<?> ignoreStrategy);

    /**
     * great than.
     *
     * @param <V>            the value type
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L gt(AtomicInteger index, SerializableSupplier<V> property, Predicate<?> ignoreStrategy);

    /**
     * great than.
     *
     * @param index          the index
     * @param property       the property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(AtomicInteger index, SerializableStringSupplier property, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy);

    /**
     * great than.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(AtomicInteger index, SerializableToIntFunction<?> name, int value, IntPredicate ignoreStrategy);

    /**
     * great than.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(AtomicInteger index, SerializableToLongFunction<?> name, long value, LongPredicate ignoreStrategy);

    /**
     * great than.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(AtomicInteger index, SerializableToDoubleFunction<?> name, double value, DoublePredicate ignoreStrategy);

    /**
     * great than.
     *
     * @param <V>            the value type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L gt(AtomicInteger index, Serializable name, V value, Predicate<?> ignoreStrategy);

    /**
     * great than.
     *
     * @param <V>            the value type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L gt(AtomicInteger index, Serializable name, V value, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy);

    /**
     * great than.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(AtomicInteger index, String name, int value, IntPredicate ignoreStrategy);

    /**
     * great than.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(AtomicInteger index, String name, long value, LongPredicate ignoreStrategy);

    /**
     * great than.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(AtomicInteger index, String name, double value, DoublePredicate ignoreStrategy);

    /**
     * great than.
     *
     * @param <V>            the value type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L gt(AtomicInteger index, String name, V value, Predicate<?> ignoreStrategy);

    /**
     * great than.
     *
     * @param <V>            the value type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L gt(AtomicInteger index, String name, V value, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy);

    // ********************************************************************

    /**
     * less equals.
     *
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(AtomicInteger index, SerializableIntSupplier property, IntPredicate ignoreStrategy);

    /**
     * less equals.
     *
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */

    L le(AtomicInteger index, SerializableLongSupplier property, LongPredicate ignoreStrategy);

    /**
     * less equals.
     *
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */

    L le(AtomicInteger index, SerializableDoubleSupplier property, DoublePredicate ignoreStrategy);

    /**
     * less equals.
     *
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(AtomicInteger index, SerializableIntSupplier property, Predicate<?> ignoreStrategy);

    /**
     * less equals.
     *
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(AtomicInteger index, SerializableLongSupplier property, Predicate<?> ignoreStrategy);

    /**
     * less equals.
     *
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(AtomicInteger index, SerializableDoubleSupplier property, Predicate<?> ignoreStrategy);

    /**
     * less equals.
     *
     * @param <V>            the value type
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L le(AtomicInteger index, SerializableSupplier<V> property, Predicate<?> ignoreStrategy);

    /**
     * less equals.
     *
     * @param index          the index
     * @param property       the property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(AtomicInteger index, SerializableStringSupplier property, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy);

    /**
     * less equals.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(AtomicInteger index, SerializableToIntFunction<?> name, int value, IntPredicate ignoreStrategy);

    /**
     * less equals.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(AtomicInteger index, SerializableToLongFunction<?> name, long value, LongPredicate ignoreStrategy);

    /**
     * less equals.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(AtomicInteger index, SerializableToDoubleFunction<?> name, double value, DoublePredicate ignoreStrategy);

    /**
     * less equals.
     *
     * @param <V>            the value type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L le(AtomicInteger index, Serializable name, V value, Predicate<?> ignoreStrategy);

    /**
     * less equals.
     *
     * @param <V>            the value type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L le(AtomicInteger index, Serializable name, V value, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy);

    /**
     * less equals.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(AtomicInteger index, String name, int value, IntPredicate ignoreStrategy);

    /**
     * less equals.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(AtomicInteger index, String name, long value, LongPredicate ignoreStrategy);

    /**
     * less equals.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(AtomicInteger index, String name, double value, DoublePredicate ignoreStrategy);

    /**
     * less equals.
     *
     * @param <V>            the value type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L le(AtomicInteger index, String name, V value, Predicate<?> ignoreStrategy);

    /**
     * less equals.
     *
     * @param <V>            the value type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L le(AtomicInteger index, String name, V value, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy);

    // ****************************************************************************************************************

    /**
     * less than.
     *
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(AtomicInteger index, SerializableIntSupplier property, IntPredicate ignoreStrategy);

    /**
     * less than.
     *
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(AtomicInteger index, SerializableLongSupplier property, LongPredicate ignoreStrategy);

    /**
     * less than.
     *
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(AtomicInteger index, SerializableDoubleSupplier property, DoublePredicate ignoreStrategy);

    /**
     * less than.
     *
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(AtomicInteger index, SerializableIntSupplier property, Predicate<?> ignoreStrategy);

    /**
     * less than.
     *
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(AtomicInteger index, SerializableLongSupplier property, Predicate<?> ignoreStrategy);

    /**
     * less than.
     *
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(AtomicInteger index, SerializableDoubleSupplier property, Predicate<?> ignoreStrategy);

    /**
     * less than.
     *
     * @param <V>            the value type
     * @param index          the index
     * @param property       the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L lt(AtomicInteger index, SerializableSupplier<V> property, Predicate<?> ignoreStrategy);

    /**
     * less than.
     *
     * @param index          the index
     * @param property       the property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(AtomicInteger index, SerializableStringSupplier property, MatchStrategy matchStrategy,
            Predicate<?> ignoreStrategy);

    /**
     * less than.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(AtomicInteger index, SerializableToIntFunction<?> name, int value, IntPredicate ignoreStrategy);

    /**
     * less than.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(AtomicInteger index, SerializableToLongFunction<?> name, long value, LongPredicate ignoreStrategy);

    /**
     * less than.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(AtomicInteger index, SerializableToDoubleFunction<?> name, double value, DoublePredicate ignoreStrategy);

    /**
     * less than.
     *
     * @param <V>            the value type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L lt(AtomicInteger index, Serializable name, V value, Predicate<?> ignoreStrategy);

    /**
     * less than.
     *
     * @param <V>            the value type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L lt(AtomicInteger index, Serializable name, V value, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy);

    /**
     * less than.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(AtomicInteger index, String name, int value, IntPredicate ignoreStrategy);

    /**
     * less than.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(AtomicInteger index, String name, long value, LongPredicate ignoreStrategy);

    /**
     * less than.
     *
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(AtomicInteger index, String name, double value, DoublePredicate ignoreStrategy);

    /**
     * less than.
     *
     * @param <V>            the value type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L lt(AtomicInteger index, String name, V value, Predicate<?> ignoreStrategy);

    /**
     * less than.
     *
     * @param <V>            the value type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L lt(AtomicInteger index, String name, V value, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy);

}
