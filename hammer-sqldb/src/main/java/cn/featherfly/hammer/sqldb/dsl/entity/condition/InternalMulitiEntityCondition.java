
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-15 19:30:15
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.dsl.entity.condition;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiPredicate;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

import cn.featherfly.common.db.builder.model.ParamedColumnElement;
import cn.featherfly.common.operator.ComparisonOperator;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.mapping.PropertyMapping;
import cn.featherfly.hammer.expression.entity.condition.MulitiEntityConditionExpression;
import cn.featherfly.hammer.sqldb.dsl.condition.InternalMulitiCondition;

/**
 * internal muliti entity condition.
 *
 * @author zhongj
 * @param <L> the generic type
 */
public interface InternalMulitiEntityCondition<L> extends InternalMulitiCondition<L>, MulitiEntityConditionExpression {

    /**
     * between and.
     *
     * @param <V> the value type
     * @param index the index
     * @param pm the pm
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L ba(AtomicInteger index, PropertyMapping<?> pm, V min, V max, BiPredicate<V, V> ignoreStrategy);

    /**
     * between and.
     *
     * @param <V> the value type
     * @param index the index
     * @param pm the pm
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy1Object paramsInName,
     * @return LogicExpression
     */
    <V> L ba(AtomicInteger index, PropertyMapping<?> pm, V min, V max, Predicate<?> ignoreStrategy);

    /**
     * between and.
     *
     * @param <V> the value type
     * @param index the index
     * @param pm the pm
     * @param name the name
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L ba(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, V min, V max,
        BiPredicate<V, V> ignoreStrategy);

    /**
     * between and.
     *
     * @param <V> the value type
     * @param index the index
     * @param pm the pm
     * @param name the name
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy1Object paramsInName,
     * @return LogicExpression
     */
    <V> L ba(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, V min, V max,
        Predicate<?> ignoreStrategy);

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * not between and.
     *
     * @param <V> the value type
     * @param index the index
     * @param pm the pm
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L nba(AtomicInteger index, PropertyMapping<?> pm, V min, V max, BiPredicate<V, V> ignoreStrategy);

    /**
     * not between and.
     *
     * @param <V> the value type
     * @param index the index
     * @param pm the pm
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L nba(AtomicInteger index, PropertyMapping<?> pm, V min, V max, Predicate<?> ignoreStrategy);

    /**
     * not between and.
     *
     * @param <V> the value type
     * @param index the index
     * @param pm the pm
     * @param name the name
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L nba(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, V min, V max,
        BiPredicate<V, V> ignoreStrategy);

    /**
     * not between and.
     *
     * @param <V> the value type
     * @param index the index
     * @param pm the pm
     * @param name the name
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L nba(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, V min, V max,
        Predicate<?> ignoreStrategy);

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * equals.
     *
     * @param index the index
     * @param pm the pm
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq(AtomicInteger index, PropertyMapping<?> pm, int value, IntPredicate ignoreStrategy);

    /**
     * equals.
     *
     * @param index the index
     * @param pm the pm
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq(AtomicInteger index, PropertyMapping<?> pm, long value, LongPredicate ignoreStrategy);

    /**
     * equals.
     *
     * @param index the index
     * @param pm the pm
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq(AtomicInteger index, PropertyMapping<?> pm, double value, DoublePredicate ignoreStrategy);

    /**
     * equals.
     *
     * @param <R> the generic type
     * @param index the index
     * @param pm the pm
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L eq(AtomicInteger index, PropertyMapping<?> pm, R value, Predicate<?> ignoreStrategy);

    /**
     * equals.
     *
     * @param <R> the generic type
     * @param index the index
     * @param pm the pm
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L eq(AtomicInteger index, PropertyMapping<?> pm, R value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy);

    /**
     * equals.
     *
     * @param index the index
     * @param pm the pm
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, int value, IntPredicate ignoreStrategy);

    /**
     * equals.
     *
     * @param index the index
     * @param pm the pm
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, long value,
        LongPredicate ignoreStrategy);

    /**
     * equals.
     *
     * @param index the index
     * @param pm the pm
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, double value,
        DoublePredicate ignoreStrategy);

    /**
     * equals.
     *
     * @param <R> the generic type
     * @param index the index
     * @param pm the pm
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L eq(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, R value,
        Predicate<?> ignoreStrategy);

    /**
     * equals.
     *
     * @param <R> the generic type
     * @param index the index
     * @param pm the pm
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L eq(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, R value,
        MatchStrategy matchStrategy, Predicate<?> ignoreStrategy);

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * not equals.
     *
     * @param index the index
     * @param pm the pm
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne(AtomicInteger index, PropertyMapping<?> pm, int value, IntPredicate ignoreStrategy);

    /**
     * not equals.
     *
     * @param index the index
     * @param pm the pm
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne(AtomicInteger index, PropertyMapping<?> pm, long value, LongPredicate ignoreStrategy);

    /**
     * not equals.
     *
     * @param index the index
     * @param pm the pm
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne(AtomicInteger index, PropertyMapping<?> pm, double value, DoublePredicate ignoreStrategy);

    /**
     * not equals.
     *
     * @param <R> the generic type
     * @param index the index
     * @param pm the pm
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L ne(AtomicInteger index, PropertyMapping<?> pm, R value, Predicate<?> ignoreStrategy);

    /**
     * not equals.
     *
     * @param <R> the generic type
     * @param index the index
     * @param pm the pm
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L ne(AtomicInteger index, PropertyMapping<?> pm, R value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy);

    /**
     * not equals.
     *
     * @param index the index
     * @param pm the pm
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, int value, IntPredicate ignoreStrategy);

    /**
     * not equals.
     *
     * @param index the index
     * @param pm the pm
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, long value,
        LongPredicate ignoreStrategy);

    /**
     * not equals.
     *
     * @param index the index
     * @param pm the pm
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, double value,
        DoublePredicate ignoreStrategy);

    /**
     * not equals.
     *
     * @param <R> the generic type
     * @param index the index
     * @param pm the pm
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L ne(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, R value,
        Predicate<?> ignoreStrategy);

    /**
     * not equals.
     *
     * @param <R> the generic type
     * @param index the index
     * @param pm the pm
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L ne(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, R value,
        MatchStrategy matchStrategy, Predicate<?> ignoreStrategy);

    // ****************************************************************************************************************

    /**
     * equals or not equals.
     *
     * @param <R> the generic type
     * @param index the index
     * @param comparisonOperator the comparison operator
     * @param pm the pm
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L eqOrNe(AtomicInteger index, ComparisonOperator comparisonOperator, PropertyMapping<?> pm, R value,
        MatchStrategy matchStrategy, Predicate<?> ignoreStrategy);

    /**
     * equals or not equals.
     *
     * @param <R> the generic type
     * @param index the index
     * @param comparisonOperator the comparison operator
     * @param pm the pm
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L eqOrNe(AtomicInteger index, ComparisonOperator comparisonOperator, PropertyMapping<?> pm,
        ParamedColumnElement name, R value, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy);

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * start with value.
     *
     * @param index the index
     * @param pm the pm
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L sw(AtomicInteger index, PropertyMapping<?> pm, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy);

    /**
     * start with value.
     *
     * @param index the index
     * @param pm the pm
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L sw(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, String value,
        MatchStrategy matchStrategy, Predicate<?> ignoreStrategy);

    /**
     * not start with value.
     *
     * @param index the index
     * @param pm the pm
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nsw(AtomicInteger index, PropertyMapping<?> pm, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy);

    /**
     * not start with value.
     *
     * @param index the index
     * @param pm the pm
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nsw(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, String value,
        MatchStrategy matchStrategy, Predicate<?> ignoreStrategy);

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * contains value.
     *
     * @param index the index
     * @param pm the pm
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L co(AtomicInteger index, PropertyMapping<?> pm, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy);

    /**
     * contains value.
     *
     * @param index the index
     * @param pm the pm
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L co(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, String value,
        MatchStrategy matchStrategy, Predicate<?> ignoreStrategy);

    /**
     * not contains value.
     *
     * @param index the index
     * @param pm the pm
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nco(AtomicInteger index, PropertyMapping<?> pm, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy);

    /**
     * not contains value.
     *
     * @param index the index
     * @param pm the pm
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nco(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, String value,
        MatchStrategy matchStrategy, Predicate<?> ignoreStrategy);

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * end with value.
     *
     * @param index the index
     * @param pm the pm
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ew(AtomicInteger index, PropertyMapping<?> pm, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy);

    /**
     * end with value.
     *
     * @param index the index
     * @param pm the pm
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ew(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, String value,
        MatchStrategy matchStrategy, Predicate<?> ignoreStrategy);

    /**
     * not end with value.
     *
     * @param index the index
     * @param pm the pm
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L newv(AtomicInteger index, PropertyMapping<?> pm, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy);

    /**
     * not end with value.
     *
     * @param index the index
     * @param pm the pm
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L newv(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, String value,
        MatchStrategy matchStrategy, Predicate<?> ignoreStrategy);

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * like.
     *
     * @param index the index
     * @param pm the pm
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lk(AtomicInteger index, PropertyMapping<?> pm, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy);

    /**
     * like.
     *
     * @param index the index
     * @param pm the pm
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lk(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, String value,
        MatchStrategy matchStrategy, Predicate<?> ignoreStrategy);

    /**
     * not like.
     *
     * @param index the index
     * @param pm the pm
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nl(AtomicInteger index, PropertyMapping<?> pm, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy);

    /**
     * not like.
     *
     * @param index the index
     * @param pm the pm
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nl(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, String value,
        MatchStrategy matchStrategy, Predicate<?> ignoreStrategy);

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * in.
     *
     * @param index the index
     * @param pm the pm
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in(AtomicInteger index, PropertyMapping<?> pm, int value, IntPredicate ignoreStrategy);

    /**
     * in.
     *
     * @param index the index
     * @param pm the pm
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in(AtomicInteger index, PropertyMapping<?> pm, long value, LongPredicate ignoreStrategy);

    /**
     * in.
     *
     * @param index the index
     * @param pm the pm
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in(AtomicInteger index, PropertyMapping<?> pm, double value, DoublePredicate ignoreStrategy);

    /**
     * in.
     *
     * @param <R> the generic type
     * @param index the index
     * @param pm the pm
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L in(AtomicInteger index, PropertyMapping<?> pm, R value, Predicate<?> ignoreStrategy);

    /**
     * in.
     *
     * @param <R> the generic type
     * @param index the index
     * @param pm the pm
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L in(AtomicInteger index, PropertyMapping<?> pm, R value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy);

    /**
     * in.
     *
     * @param index the index
     * @param pm the pm
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, int value, IntPredicate ignoreStrategy);

    /**
     * in.
     *
     * @param index the index
     * @param pm the pm
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, long value,
        LongPredicate ignoreStrategy);

    /**
     * in.
     *
     * @param index the index
     * @param pm the pm
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, double value,
        DoublePredicate ignoreStrategy);

    /**
     * in.
     *
     * @param <R> the generic type
     * @param index the index
     * @param pm the pm
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L in(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, R value,
        Predicate<?> ignoreStrategy);

    /**
     * in.
     *
     * @param <R> the generic type
     * @param index the index
     * @param pm the pm
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L in(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, R value,
        MatchStrategy matchStrategy, Predicate<?> ignoreStrategy);

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * not in.
     *
     * @param index the index
     * @param pm the pm
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni(AtomicInteger index, PropertyMapping<?> pm, int value, IntPredicate ignoreStrategy);

    /**
     * not in.
     *
     * @param index the index
     * @param pm the pm
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni(AtomicInteger index, PropertyMapping<?> pm, long value, LongPredicate ignoreStrategy);

    /**
     * not in.
     *
     * @param index the index
     * @param pm the pm
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni(AtomicInteger index, PropertyMapping<?> pm, double value, DoublePredicate ignoreStrategy);

    /**
     * not in.
     *
     * @param <R> the generic type
     * @param index the index
     * @param pm the pm
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L ni(AtomicInteger index, PropertyMapping<?> pm, R value, Predicate<?> ignoreStrategy);

    /**
     * not in.
     *
     * @param <R> the generic type
     * @param index the index
     * @param pm the pm
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L ni(AtomicInteger index, PropertyMapping<?> pm, R value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy);

    /**
     * not in.
     *
     * @param index the index
     * @param pm the pm
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, int value, IntPredicate ignoreStrategy);

    /**
     * not in.
     *
     * @param index the index
     * @param pm the pm
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, long value,
        LongPredicate ignoreStrategy);

    /**
     * not in.
     *
     * @param index the index
     * @param pm the pm
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, double value,
        DoublePredicate ignoreStrategy);

    /**
     * not in.
     *
     * @param <R> the generic type
     * @param index the index
     * @param pm the pm
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L ni(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, R value,
        Predicate<?> ignoreStrategy);

    /**
     * not in.
     *
     * @param <R> the generic type
     * @param index the index
     * @param pm the pm
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L ni(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, R value,
        MatchStrategy matchStrategy, Predicate<?> ignoreStrategy);

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * is null.
     *
     * @param index the index
     * @param pm the pm
     * @param value the value
     * @return LogicExpression
     */
    L isn(AtomicInteger index, PropertyMapping<?> pm, Boolean value);

    /**
     * is not null.
     *
     * @param index the index
     * @param pm the pm
     * @param value the value
     * @return LogicExpression
     */
    L inn(AtomicInteger index, PropertyMapping<?> pm, Boolean value);

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * great equals.
     *
     * @param index the index
     * @param pm the pm
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(AtomicInteger index, PropertyMapping<?> pm, int value, IntPredicate ignoreStrategy);

    /**
     * great equals.
     *
     * @param index the index
     * @param pm the pm
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(AtomicInteger index, PropertyMapping<?> pm, long value, LongPredicate ignoreStrategy);

    /**
     * great equals.
     *
     * @param index the index
     * @param pm the pm
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(AtomicInteger index, PropertyMapping<?> pm, double value, DoublePredicate ignoreStrategy);

    /**
     * great equals.
     *
     * @param <V> the value type
     * @param index the index
     * @param pm the pm
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L ge(AtomicInteger index, PropertyMapping<?> pm, V value, Predicate<?> ignoreStrategy);

    /**
     * great equals.
     *
     * @param <V> the value type
     * @param index the index
     * @param pm the pm
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L ge(AtomicInteger index, PropertyMapping<?> pm, V value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy);

    /**
     * great equals.
     *
     * @param index the index
     * @param pm the pm
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, int value, IntPredicate ignoreStrategy);

    /**
     * great equals.
     *
     * @param index the index
     * @param pm the pm
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, long value,
        LongPredicate ignoreStrategy);

    /**
     * great equals.
     *
     * @param index the index
     * @param pm the pm
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, double value,
        DoublePredicate ignoreStrategy);

    /**
     * great equals.
     *
     * @param <V> the value type
     * @param index the index
     * @param pm the pm
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L ge(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, V value,
        Predicate<?> ignoreStrategy);

    /**
     * great equals.
     *
     * @param <V> the value type
     * @param index the index
     * @param pm the pm
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L ge(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, V value,
        MatchStrategy matchStrategy, Predicate<?> ignoreStrategy);

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * great than.
     *
     * @param index the index
     * @param pm the pm
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(AtomicInteger index, PropertyMapping<?> pm, int value, IntPredicate ignoreStrategy);

    /**
     * great than.
     *
     * @param index the index
     * @param pm the pm
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(AtomicInteger index, PropertyMapping<?> pm, long value, LongPredicate ignoreStrategy);

    /**
     * great than.
     *
     * @param index the index
     * @param pm the pm
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(AtomicInteger index, PropertyMapping<?> pm, double value, DoublePredicate ignoreStrategy);

    /**
     * great than.
     *
     * @param <V> the value type
     * @param index the index
     * @param pm the pm
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L gt(AtomicInteger index, PropertyMapping<?> pm, V value, Predicate<?> ignoreStrategy);

    /**
     * great than.
     *
     * @param <V> the value type
     * @param index the index
     * @param pm the pm
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L gt(AtomicInteger index, PropertyMapping<?> pm, V value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy);

    /**
     * great than.
     *
     * @param index the index
     * @param pm the pm
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, int value, IntPredicate ignoreStrategy);

    /**
     * great than.
     *
     * @param index the index
     * @param pm the pm
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, long value,
        LongPredicate ignoreStrategy);

    /**
     * great than.
     *
     * @param index the index
     * @param pm the pm
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, double value,
        DoublePredicate ignoreStrategy);

    /**
     * great than.
     *
     * @param <V> the value type
     * @param index the index
     * @param pm the pm
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L gt(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, V value,
        Predicate<?> ignoreStrategy);

    /**
     * great than.
     *
     * @param <V> the value type
     * @param index the index
     * @param pm the pm
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L gt(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, V value,
        MatchStrategy matchStrategy, Predicate<?> ignoreStrategy);

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * less equals.
     *
     * @param index the index
     * @param pm the pm
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(AtomicInteger index, PropertyMapping<?> pm, int value, IntPredicate ignoreStrategy);

    /**
     * less equals.
     *
     * @param index the index
     * @param pm the pm
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(AtomicInteger index, PropertyMapping<?> pm, long value, LongPredicate ignoreStrategy);

    /**
     * less equals.
     *
     * @param index the index
     * @param pm the pm
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(AtomicInteger index, PropertyMapping<?> pm, double value, DoublePredicate ignoreStrategy);

    /**
     * less equals.
     *
     * @param <V> the value type
     * @param index the index
     * @param pm the pm
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L le(AtomicInteger index, PropertyMapping<?> pm, V value, Predicate<?> ignoreStrategy);

    /**
     * less equals.
     *
     * @param <V> the value type
     * @param index the index
     * @param pm the pm
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L le(AtomicInteger index, PropertyMapping<?> pm, V value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy);

    /**
     * less equals.
     *
     * @param index the index
     * @param pm the pm
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, int value, IntPredicate ignoreStrategy);

    /**
     * less equals.
     *
     * @param index the index
     * @param pm the pm
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, long value,
        LongPredicate ignoreStrategy);

    /**
     * less equals.
     *
     * @param index the index
     * @param pm the pm
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, double value,
        DoublePredicate ignoreStrategy);

    /**
     * less equals.
     *
     * @param <V> the value type
     * @param index the index
     * @param pm the pm
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L le(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, V value,
        Predicate<?> ignoreStrategy);

    /**
     * less equals.
     *
     * @param <V> the value type
     * @param index the index
     * @param pm the pm
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L le(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, V value,
        MatchStrategy matchStrategy, Predicate<?> ignoreStrategy);

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * less than.
     *
     * @param index the index
     * @param pm the pm
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(AtomicInteger index, PropertyMapping<?> pm, int value, IntPredicate ignoreStrategy);

    /**
     * less than.
     *
     * @param index the index
     * @param pm the pm
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(AtomicInteger index, PropertyMapping<?> pm, long value, LongPredicate ignoreStrategy);

    /**
     * less than.
     *
     * @param index the index
     * @param pm the pm
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(AtomicInteger index, PropertyMapping<?> pm, double value, DoublePredicate ignoreStrategy);

    /**
     * less than.
     *
     * @param <V> the value type
     * @param index the index
     * @param pm the pm
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L lt(AtomicInteger index, PropertyMapping<?> pm, V value, Predicate<?> ignoreStrategy);

    /**
     * less than.
     *
     * @param <V> the value type
     * @param index the index
     * @param pm the pm
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L lt(AtomicInteger index, PropertyMapping<?> pm, V value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy);

    /**
     * less than.
     *
     * @param index the index
     * @param pm the pm
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, int value, IntPredicate ignoreStrategy);

    /**
     * less than.
     *
     * @param index the index
     * @param pm the pm
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, long value,
        LongPredicate ignoreStrategy);

    /**
     * less than.
     *
     * @param index the index
     * @param pm the pm
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, double value,
        DoublePredicate ignoreStrategy);

    /**
     * less than.
     *
     * @param <V> the value type
     * @param index the index
     * @param pm the pm
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L lt(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, V value,
        Predicate<?> ignoreStrategy);

    /**
     * less than.
     *
     * @param <V> the value type
     * @param index the index
     * @param pm the pm
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L lt(AtomicInteger index, PropertyMapping<?> pm, ParamedColumnElement name, V value,
        MatchStrategy matchStrategy, Predicate<?> ignoreStrategy);
}
