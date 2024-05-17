
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-15 19:30:15
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.dsl.condition;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiPredicate;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

import cn.featherfly.common.db.builder.model.ParamedColumnElement;
import cn.featherfly.common.exception.UnsupportedException;
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
import cn.featherfly.hammer.expression.condition.Expression;
import cn.featherfly.hammer.expression.condition.IgnorableExpression;
import cn.featherfly.hammer.expression.condition.MulitiRepositoryExpression;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;

/**
 * internal muliti condition.
 *
 * @author zhongj
 * @param <L> the generic type
 */
public interface InternalMulitiCondition<L> extends MulitiRepositoryExpression, IgnorableExpression {

    /**
     * Gets the jdbc.
     *
     * @return the jdbc
     */
    Jdbc getJdbc();

    /**
     * Adds the condition.
     *
     * @param condition the condition
     * @return the expression
     */
    Expression addCondition(Expression condition);

    /**
     * between and.
     *
     * @param <V> the value type
     * @param index the index
     * @param field the field
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L ba(AtomicInteger index, Serializable field, V min, V max, BiPredicate<V, V> ignoreStrategy);

    /**
     * between and.
     *
     * @param <V> the value type
     * @param index the index
     * @param field the field
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L ba(AtomicInteger index, Serializable field, V min, V max, Predicate<?> ignoreStrategy);

    /**
     * between and.
     *
     * @param <V> the value type
     * @param index the index
     * @param field the field
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    <V> L ba(AtomicInteger index, String field, V min, V max, BiPredicate<V, V> ignoreStrategy);

    /**
     * between and.
     *
     * @param <V> the value type
     * @param index the index
     * @param field the field
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    default <V> L ba(AtomicInteger index, Object field, V min, V max, BiPredicate<V, V> ignoreStrategy) {
        if (field instanceof String) {
            return ba(index, (String) field, min, max, ignoreStrategy);
        } else if (field instanceof ParamedColumnElement) {
            return ba(index, (ParamedColumnElement) field, min, max, ignoreStrategy);
        } else {
            throw new UnsupportedException("unsupported type " + field.getClass().getName());
        }
    }

    /**
     * between and.
     *
     * @param <V> the value type
     * @param index the index
     * @param field the field
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L ba(AtomicInteger index, String field, V min, V max, Predicate<?> ignoreStrategy);

    /**
     * between and.
     *
     * @param <V> the value type
     * @param index the index
     * @param field the field
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <V> L ba(AtomicInteger index, Object field, V min, V max, Predicate<?> ignoreStrategy) {
        if (field instanceof String) {
            return ba(index, (String) field, min, max, ignoreStrategy);
        } else if (field instanceof ParamedColumnElement) {
            return ba(index, (ParamedColumnElement) field, min, max, ignoreStrategy);
        } else {
            throw new UnsupportedException("unsupported type " + field.getClass().getName());
        }
    }

    /**
     * between and.
     *
     * @param <V> the value type
     * @param index the index
     * @param field the field
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    <V> L ba(AtomicInteger index, ParamedColumnElement field, V min, V max, BiPredicate<V, V> ignoreStrategy);

    /**
     * between and.
     *
     * @param <V> the value type
     * @param index the index
     * @param field the field
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L ba(AtomicInteger index, ParamedColumnElement field, V min, V max, Predicate<?> ignoreStrategy);

    // ********************************************************************

    /**
     * not between and.
     *
     * @param <V> the value type
     * @param index the index
     * @param field the field
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L nba(AtomicInteger index, Serializable field, V min, V max, BiPredicate<V, V> ignoreStrategy);

    /**
     * not between and.
     *
     * @param <V> the value type
     * @param index the index
     * @param field the field
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L nba(AtomicInteger index, Serializable field, V min, V max, Predicate<?> ignoreStrategy);

    /**
     * not between and.
     *
     * @param <V> the value type
     * @param index the index
     * @param field the field
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L nba(AtomicInteger index, String field, V min, V max, BiPredicate<V, V> ignoreStrategy);

    /**
     * not between and.
     *
     * @param <V> the value type
     * @param index the index
     * @param field the field
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <V> L nba(AtomicInteger index, Object field, V min, V max, BiPredicate<V, V> ignoreStrategy) {
        if (field instanceof String) {
            return nba(index, (String) field, min, max, ignoreStrategy);
        } else if (field instanceof ParamedColumnElement) {
            return nba(index, (ParamedColumnElement) field, min, max, ignoreStrategy);
        } else {
            throw new UnsupportedException("unsupported type " + field.getClass().getName());
        }
    }

    /**
     * not between and.
     *
     * @param <V> the value type
     * @param index the index
     * @param field the field
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L nba(AtomicInteger index, String field, V min, V max, Predicate<?> ignoreStrategy);

    /**
     * not between and.
     *
     * @param <V> the value type
     * @param index the index
     * @param field the field
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <V> L nba(AtomicInteger index, Object field, V min, V max, Predicate<?> ignoreStrategy) {
        if (field instanceof String) {
            return nba(index, (String) field, min, max, ignoreStrategy);
        } else if (field instanceof ParamedColumnElement) {
            return nba(index, (ParamedColumnElement) field, min, max, ignoreStrategy);
        } else {
            throw new UnsupportedException("unsupported type " + field.getClass().getName());
        }
    }

    /**
     * not between and.
     *
     * @param <V> the value type
     * @param index the index
     * @param field the field
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L nba(AtomicInteger index, ParamedColumnElement field, V min, V max, BiPredicate<V, V> ignoreStrategy);

    /**
     * not between and.
     *
     * @param <V> the value type
     * @param index the index
     * @param field the field
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L nba(AtomicInteger index, ParamedColumnElement field, V min, V max, Predicate<?> ignoreStrategy);

    // ********************************************************************

    /**
     * equals.
     *
     * @param <R> the generic type
     * @param index the index
     * @param property the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L eq(AtomicInteger index, SerializableSupplier<R> property, Predicate<?> ignoreStrategy);

    /**
     * equals.
     *
     * @param <R> the generic type
     * @param index the index
     * @param property the property
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L eq(AtomicInteger index, SerializableSupplier<R> property, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy);

    /**
     * equals.
     *
     * @param index the index
     * @param property the property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq(AtomicInteger index, Serializable property, int value, IntPredicate ignoreStrategy);

    /**
     * equals.
     *
     * @param index the index
     * @param property the property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq(AtomicInteger index, Serializable property, long value, LongPredicate ignoreStrategy);

    /**
     * equals.
     *
     * @param index the index
     * @param property the property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq(AtomicInteger index, Serializable property, double value, DoublePredicate ignoreStrategy);

    /**
     * equals.
     *
     * @param <R> the generic type
     * @param index the index
     * @param property the property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L eq(AtomicInteger index, Serializable property, R value, Predicate<?> ignoreStrategy);

    /**
     * equals.
     *
     * @param <R> the generic type
     * @param index the index
     * @param property the property
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L eq(AtomicInteger index, Serializable property, R value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy);

    /**
     * equals.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq(AtomicInteger index, String field, int value, IntPredicate ignoreStrategy);

    /**
     * equals.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(AtomicInteger index, Object field, int value, IntPredicate ignoreStrategy) {
        if (field instanceof String) {
            return eq(index, (String) field, value, ignoreStrategy);
        } else if (field instanceof ParamedColumnElement) {
            return eq(index, (ParamedColumnElement) field, value, ignoreStrategy);
        } else {
            throw new UnsupportedException("unsupported type " + field.getClass().getName());
        }
    }

    /**
     * equals.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq(AtomicInteger index, String field, long value, LongPredicate ignoreStrategy);

    /**
     * equals.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(AtomicInteger index, Object field, long value, LongPredicate ignoreStrategy) {
        if (field instanceof String) {
            return eq(index, (String) field, value, ignoreStrategy);
        } else if (field instanceof ParamedColumnElement) {
            return eq(index, (ParamedColumnElement) field, value, ignoreStrategy);
        } else {
            throw new UnsupportedException("unsupported type " + field.getClass().getName());
        }
    }

    /**
     * equals.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq(AtomicInteger index, String field, double value, DoublePredicate ignoreStrategy);

    /**
     * equals.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(AtomicInteger index, Object field, double value, DoublePredicate ignoreStrategy) {
        if (field instanceof String) {
            return eq(index, (String) field, value, ignoreStrategy);
        } else if (field instanceof ParamedColumnElement) {
            return eq(index, (ParamedColumnElement) field, value, ignoreStrategy);
        } else {
            throw new UnsupportedException("unsupported type " + field.getClass().getName());
        }
    }

    /**
     * equals.
     *
     * @param <R> the generic type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L eq(AtomicInteger index, String field, R value, Predicate<?> ignoreStrategy);

    /**
     * equals.
     *
     * @param <R> the generic type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R> L eq(AtomicInteger index, Object field, R value, Predicate<?> ignoreStrategy) {
        if (field instanceof String) {
            return eq(index, (String) field, value, ignoreStrategy);
        } else if (field instanceof ParamedColumnElement) {
            return eq(index, (ParamedColumnElement) field, value, ignoreStrategy);
        } else {
            throw new UnsupportedException("unsupported type " + field.getClass().getName());
        }
    }

    /**
     * equals.
     *
     * @param <R> the generic type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L eq(AtomicInteger index, String field, R value, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy);

    /**
     * equals.
     *
     * @param <R> the generic type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R> L eq(AtomicInteger index, Object field, R value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        if (field instanceof String) {
            return eq(index, (String) field, value, matchStrategy, ignoreStrategy);
        } else if (field instanceof ParamedColumnElement) {
            return eq(index, (ParamedColumnElement) field, value, matchStrategy, ignoreStrategy);
        } else {
            throw new UnsupportedException("unsupported type " + field.getClass().getName());
        }
    }

    /**
     * equals.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq(AtomicInteger index, ParamedColumnElement field, int value, IntPredicate ignoreStrategy);

    /**
     * equals.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq(AtomicInteger index, ParamedColumnElement field, long value, LongPredicate ignoreStrategy);

    /**
     * equals.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq(AtomicInteger index, ParamedColumnElement field, double value, DoublePredicate ignoreStrategy);

    /**
     * equals.
     *
     * @param <R> the generic type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L eq(AtomicInteger index, ParamedColumnElement field, R value, Predicate<?> ignoreStrategy);

    /**
     * equals.
     *
     * @param <R> the generic type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L eq(AtomicInteger index, ParamedColumnElement field, R value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy);

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * not equals.
     *
     * @param <R> the generic type
     * @param index the index
     * @param property the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L ne(AtomicInteger index, SerializableSupplier<R> property, Predicate<?> ignoreStrategy);

    /**
     * not equals.
     *
     * @param <R> the generic type
     * @param index the index
     * @param property the property
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L ne(AtomicInteger index, SerializableSupplier<R> property, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy);

    /**
     * not equals.
     *
     * @param index the index
     * @param property the property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne(AtomicInteger index, Serializable property, int value, IntPredicate ignoreStrategy);

    /**
     * not equals.
     *
     * @param index the index
     * @param property the property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne(AtomicInteger index, Serializable property, long value, LongPredicate ignoreStrategy);

    /**
     * not equals.
     *
     * @param index the index
     * @param property the property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne(AtomicInteger index, Serializable property, double value, DoublePredicate ignoreStrategy);

    /**
     * not equals.
     *
     * @param <R> the generic type
     * @param index the index
     * @param property the property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L ne(AtomicInteger index, Serializable property, R value, Predicate<?> ignoreStrategy);

    /**
     * not equals.
     *
     * @param <R> the generic type
     * @param index the index
     * @param property the property
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L ne(AtomicInteger index, Serializable property, R value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy);

    /**
     * not equals.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne(AtomicInteger index, String field, int value, IntPredicate ignoreStrategy);

    /**
     * not equals.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne(AtomicInteger index, String field, long value, LongPredicate ignoreStrategy);

    /**
     * not equals.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne(AtomicInteger index, String field, double value, DoublePredicate ignoreStrategy);

    /**
     * not equals.
     *
     * @param <R> the generic type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L ne(AtomicInteger index, String field, R value, Predicate<?> ignoreStrategy);

    /**
     * not equals.
     *
     * @param <R> the generic type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R> L ne(AtomicInteger index, Object field, R value, Predicate<?> ignoreStrategy) {
        if (field instanceof String) {
            return ne(index, (String) field, value, ignoreStrategy);
        } else if (field instanceof ParamedColumnElement) {
            return ne(index, (ParamedColumnElement) field, value, ignoreStrategy);
        } else {
            throw new UnsupportedException("unsupported type " + field.getClass().getName());
        }
    }

    /**
     * not equals.
     *
     * @param <R> the generic type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L ne(AtomicInteger index, String field, R value, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy);

    /**
     * not equals.
     *
     * @param <R> the generic type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R> L ne(AtomicInteger index, Object field, R value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        if (field instanceof String) {
            return ne(index, (String) field, value, matchStrategy, ignoreStrategy);
        } else if (field instanceof ParamedColumnElement) {
            return ne(index, (ParamedColumnElement) field, value, matchStrategy, ignoreStrategy);
        } else {
            throw new UnsupportedException("unsupported type " + field.getClass().getName());
        }
    }

    /**
     * not equals.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne(AtomicInteger index, ParamedColumnElement field, int value, IntPredicate ignoreStrategy);

    /**
     * not equals.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne(AtomicInteger index, ParamedColumnElement field, long value, LongPredicate ignoreStrategy);

    /**
     * not equals.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ne(AtomicInteger index, ParamedColumnElement field, double value, DoublePredicate ignoreStrategy);

    /**
     * not equals.
     *
     * @param <R> the generic type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L ne(AtomicInteger index, ParamedColumnElement field, R value, Predicate<?> ignoreStrategy);

    /**
     * not equals.
     *
     * @param <R> the generic type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L ne(AtomicInteger index, ParamedColumnElement field, R value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy);

    /**
     * equals or not equals.
     *
     * @param <R> the generic type
     * @param index the index
     * @param comparisonOperator the comparison operator
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L eqOrNe(AtomicInteger index, ComparisonOperator comparisonOperator, String field, R value,
        MatchStrategy matchStrategy, Predicate<?> ignoreStrategy);

    /**
     * equals or not equals.
     *
     * @param <R> the generic type
     * @param index the index
     * @param comparisonOperator the comparison operator
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L eqOrNe(AtomicInteger index, ComparisonOperator comparisonOperator, ParamedColumnElement field, R value,
        MatchStrategy matchStrategy, Predicate<?> ignoreStrategy);

    // ****************************************************************************************************************

    /**
     * start with value.
     *
     * @param index the index
     * @param property the property
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L sw(AtomicInteger index, SerializableStringSupplier property, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy);

    /**
     * start with value.
     *
     * @param index the index
     * @param property the property
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L sw(AtomicInteger index, Serializable property, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy);

    /**
     * start with value.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L sw(AtomicInteger index, String field, String value, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy);

    /**
     * start with value.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L sw(AtomicInteger index, ParamedColumnElement field, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy);

    // ****************************************************************************************************************

    /**
     * not start with value.
     *
     * @param index the index
     * @param property the property
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nsw(AtomicInteger index, SerializableStringSupplier property, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy);

    /**
     * not start with value.
     *
     * @param index the index
     * @param property the property
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nsw(AtomicInteger index, Serializable property, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy);

    /**
     * not start with value.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nsw(AtomicInteger index, String field, String value, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy);

    /**
     * not start with value.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nsw(AtomicInteger index, ParamedColumnElement field, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy);

    // ****************************************************************************************************************

    /**
     * contains value.
     *
     * @param index the index
     * @param property the property
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L co(AtomicInteger index, SerializableStringSupplier property, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy);

    /**
     * contains value.
     *
     * @param index the index
     * @param property the property
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L co(AtomicInteger index, Serializable property, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy);

    /**
     * contains value.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L co(AtomicInteger index, String field, String value, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy);

    /**
     * contains value.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L co(AtomicInteger index, ParamedColumnElement field, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy);

    // ****************************************************************************************************************

    /**
     * not contains value.
     *
     * @param index the index
     * @param property the property
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nco(AtomicInteger index, SerializableStringSupplier property, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy);

    /**
     * not contains value.
     *
     * @param index the index
     * @param property the property
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nco(AtomicInteger index, Serializable property, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy);

    /**
     * not contains value.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nco(AtomicInteger index, String field, String value, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy);

    /**
     * not contains value.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nco(AtomicInteger index, ParamedColumnElement field, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy);

    // ****************************************************************************************************************

    /**
     * end with value.
     *
     * @param index the index
     * @param property the property
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ew(AtomicInteger index, SerializableStringSupplier property, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy);

    /**
     * end with value.
     *
     * @param index the index
     * @param property the property
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ew(AtomicInteger index, Serializable property, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy);

    /**
     * end with value.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ew(AtomicInteger index, String field, String value, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy);

    /**
     * end with value.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ew(AtomicInteger index, ParamedColumnElement field, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy);

    // ****************************************************************************************************************

    /**
     * not end with value.
     *
     * @param index the index
     * @param property the property
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L newv(AtomicInteger index, SerializableStringSupplier property, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy);

    /**
     * not end with value.
     *
     * @param index the index
     * @param property the property
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L newv(AtomicInteger index, Serializable property, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy);

    /**
     * not end with value.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L newv(AtomicInteger index, String field, String value, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy);

    /**
     * not end with value.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L newv(AtomicInteger index, ParamedColumnElement field, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy);

    // ****************************************************************************************************************

    /**
     * like.
     *
     * @param index the index
     * @param property the property
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lk(AtomicInteger index, SerializableStringSupplier property, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy);

    /**
     * like.
     *
     * @param index the index
     * @param property the property
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lk(AtomicInteger index, Serializable property, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy);

    /**
     * like.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lk(AtomicInteger index, String field, String value, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy);

    /**
     * like.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lk(AtomicInteger index, ParamedColumnElement field, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy);

    // ****************************************************************************************************************

    /**
     * not like.
     *
     * @param index the index
     * @param property the property
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nl(AtomicInteger index, SerializableStringSupplier property, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy);

    /**
     * not like.
     *
     * @param index the index
     * @param property the property
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nl(AtomicInteger index, Serializable property, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy);

    /**
     * not like.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nl(AtomicInteger index, String field, String value, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy);

    /**
     * not like.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nl(AtomicInteger index, ParamedColumnElement field, String value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy);

    // ****************************************************************************************************************

    /**
     * in.
     *
     * @param index the index
     * @param property the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in(AtomicInteger index, SerializableIntSupplier property, IntPredicate ignoreStrategy);

    /**
     * in.
     *
     * @param index the index
     * @param property the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in(AtomicInteger index, SerializableIntSupplier property, Predicate<?> ignoreStrategy);

    /**
     * in.
     *
     * @param index the index
     * @param property the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in(AtomicInteger index, SerializableLongSupplier property, LongPredicate ignoreStrategy);

    /**
     * in.
     *
     * @param index the index
     * @param property the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in(AtomicInteger index, SerializableLongSupplier property, Predicate<?> ignoreStrategy);

    /**
     * in.
     *
     * @param index the index
     * @param property the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in(AtomicInteger index, SerializableDoubleSupplier property, DoublePredicate ignoreStrategy);

    /**
     * in.
     *
     * @param index the index
     * @param property the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in(AtomicInteger index, SerializableDoubleSupplier property, Predicate<?> ignoreStrategy);

    /**
     * in.
     *
     * @param <R> the generic type
     * @param index the index
     * @param property the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L in(AtomicInteger index, SerializableSupplier<R> property, Predicate<?> ignoreStrategy);

    /**
     * in.
     *
     * @param index the index
     * @param property the property
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in(AtomicInteger index, SerializableStringSupplier property, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy);

    /**
     * in.
     *
     * @param index the index
     * @param property the property
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in(AtomicInteger index, SerializableArraySupplier<String> property, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy);

    /**
     * in.
     *
     * @param <T> the generic type
     * @param index the index
     * @param property the property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L in(AtomicInteger index, SerializableToIntFunction<T> property, int value, IntPredicate ignoreStrategy);

    /**
     * in.
     *
     * @param <T> the generic type
     * @param index the index
     * @param property the property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L in(AtomicInteger index, SerializableToLongFunction<T> property, long value, LongPredicate ignoreStrategy);

    /**
     * in.
     *
     * @param <T> the generic type
     * @param index the index
     * @param property the property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L in(AtomicInteger index, SerializableToDoubleFunction<T> property, double value,
        DoublePredicate ignoreStrategy);

    /**
     * in.
     *
     * @param <R> the generic type
     * @param index the index
     * @param property the property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L in(AtomicInteger index, Serializable property, R value, Predicate<?> ignoreStrategy);

    /**
     * in.
     *
     * @param <R> the generic type
     * @param index the index
     * @param property the property
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L in(AtomicInteger index, Serializable property, R value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy);

    /**
     * in.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in(AtomicInteger index, String field, int value, IntPredicate ignoreStrategy);

    /**
     * in.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in(AtomicInteger index, String field, long value, LongPredicate ignoreStrategy);

    /**
     * in.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in(AtomicInteger index, String field, double value, DoublePredicate ignoreStrategy);

    /**
     * in.
     *
     * @param <R> the generic type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L in(AtomicInteger index, String field, R value, Predicate<?> ignoreStrategy);

    /**
     * in.
     *
     * @param <R> the generic type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R> L in(AtomicInteger index, Object field, R value, Predicate<?> ignoreStrategy) {
        if (field instanceof String) {
            return in(index, (String) field, value, ignoreStrategy);
        } else if (field instanceof ParamedColumnElement) {
            return in(index, (ParamedColumnElement) field, value, ignoreStrategy);
        } else {
            throw new UnsupportedException("unsupported type " + field.getClass().getName());
        }
    }

    /**
     * in.
     *
     * @param <R> the generic type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L in(AtomicInteger index, String field, R value, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy);

    /**
     * in.
     *
     * @param <R> the generic type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R> L in(AtomicInteger index, Object field, R value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        if (field instanceof String) {
            return in(index, (String) field, value, matchStrategy, ignoreStrategy);
        } else if (field instanceof ParamedColumnElement) {
            return in(index, (ParamedColumnElement) field, value, matchStrategy, ignoreStrategy);
        } else {
            throw new UnsupportedException("unsupported type " + field.getClass().getName());
        }
    }

    /**
     * in.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in(AtomicInteger index, ParamedColumnElement field, int value, IntPredicate ignoreStrategy);

    /**
     * in.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in(AtomicInteger index, ParamedColumnElement field, long value, LongPredicate ignoreStrategy);

    /**
     * in.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in(AtomicInteger index, ParamedColumnElement field, double value, DoublePredicate ignoreStrategy);

    /**
     * in.
     *
     * @param <R> the generic type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L in(AtomicInteger index, ParamedColumnElement field, R value, Predicate<?> ignoreStrategy);

    /**
     * in.
     *
     * @param <R> the generic type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L in(AtomicInteger index, ParamedColumnElement field, R value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy);

    // ****************************************************************************************************************

    /**
     * not in.
     *
     * @param index the index
     * @param property the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni(AtomicInteger index, SerializableIntSupplier property, IntPredicate ignoreStrategy);

    /**
     * not in.
     *
     * @param index the index
     * @param property the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni(AtomicInteger index, SerializableIntSupplier property, Predicate<?> ignoreStrategy);

    /**
     * not in.
     *
     * @param index the index
     * @param property the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni(AtomicInteger index, SerializableLongSupplier property, LongPredicate ignoreStrategy);

    /**
     * not in.
     *
     * @param index the index
     * @param property the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni(AtomicInteger index, SerializableLongSupplier property, Predicate<?> ignoreStrategy);

    /**
     * not in.
     *
     * @param index the index
     * @param property the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni(AtomicInteger index, SerializableDoubleSupplier property, DoublePredicate ignoreStrategy);

    /**
     * not in.
     *
     * @param index the index
     * @param property the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni(AtomicInteger index, SerializableDoubleSupplier property, Predicate<?> ignoreStrategy);

    /**
     * not in.
     *
     * @param <R> the generic type
     * @param index the index
     * @param property the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L ni(AtomicInteger index, SerializableSupplier<R> property, Predicate<?> ignoreStrategy);

    /**
     * not in.
     *
     * @param <T> the generic type
     * @param index the index
     * @param property the property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L ni(AtomicInteger index, SerializableToIntFunction<T> property, int value, IntPredicate ignoreStrategy);

    /**
     * not in.
     *
     * @param <T> the generic type
     * @param index the index
     * @param property the property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L ni(AtomicInteger index, SerializableToLongFunction<T> property, long value, LongPredicate ignoreStrategy);

    /**
     * not in.
     *
     * @param <T> the generic type
     * @param index the index
     * @param property the property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T> L ni(AtomicInteger index, SerializableToDoubleFunction<T> property, double value,
        DoublePredicate ignoreStrategy);

    /**
     * not in.
     *
     * @param <R> the generic type
     * @param index the index
     * @param property the property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L ni(AtomicInteger index, Serializable property, R value, Predicate<?> ignoreStrategy);

    /**
     * not in.
     *
     * @param <R> the generic type
     * @param index the index
     * @param property the property
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L ni(AtomicInteger index, Serializable property, R value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy);

    /**
     * not in.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni(AtomicInteger index, String field, int value, IntPredicate ignoreStrategy);

    /**
     * not in.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni(AtomicInteger index, String field, long value, LongPredicate ignoreStrategy);

    /**
     * not in.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni(AtomicInteger index, String field, double value, DoublePredicate ignoreStrategy);

    /**
     * not in.
     *
     * @param <R> the generic type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L ni(AtomicInteger index, String field, R value, Predicate<?> ignoreStrategy);

    /**
     * not in.
     *
     * @param <R> the generic type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R> L ni(AtomicInteger index, Object field, R value, Predicate<?> ignoreStrategy) {
        if (field instanceof String) {
            return ni(index, (String) field, value, ignoreStrategy);
        } else if (field instanceof ParamedColumnElement) {
            return ni(index, (ParamedColumnElement) field, value, ignoreStrategy);
        } else {
            throw new UnsupportedException("unsupported type " + field.getClass().getName());
        }
    }

    /**
     * not in.
     *
     * @param <R> the generic type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L ni(AtomicInteger index, String field, R value, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy);

    /**
     * not in.
     *
     * @param <R> the generic type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R> L ni(AtomicInteger index, Object field, R value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        if (field instanceof String) {
            return ni(index, (String) field, value, matchStrategy, ignoreStrategy);
        } else if (field instanceof ParamedColumnElement) {
            return ni(index, (ParamedColumnElement) field, value, matchStrategy, ignoreStrategy);
        } else {
            throw new UnsupportedException("unsupported type " + field.getClass().getName());
        }
    }

    /**
     * not in.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni(AtomicInteger index, ParamedColumnElement field, int value, IntPredicate ignoreStrategy);

    /**
     * not in.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni(AtomicInteger index, ParamedColumnElement field, long value, LongPredicate ignoreStrategy);

    /**
     * not in.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni(AtomicInteger index, ParamedColumnElement field, double value, DoublePredicate ignoreStrategy);

    /**
     * not in.
     *
     * @param <R> the generic type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L ni(AtomicInteger index, ParamedColumnElement field, R value, Predicate<?> ignoreStrategy);

    /**
     * not in.
     *
     * @param <R> the generic type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L ni(AtomicInteger index, ParamedColumnElement field, R value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy);

    // ****************************************************************************************************************

    /**
     * is null. <br>
     * operate has no effect for is null.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    L isn(AtomicInteger index, String field, Boolean value);

    /**
     * is null. <br>
     * operate has no effect for is null.
     *
     * @param index the index
     * @param property the property
     * @param value the value
     * @return LogicExpression
     */
    L isn(AtomicInteger index, Serializable property, Boolean value);

    /**
     * is not null. <br>
     * operate has no effect for is not null.
     *
     * @param index the index
     * @param property the property
     * @param value the value
     * @return LogicExpression
     */
    L inn(AtomicInteger index, Serializable property, Boolean value);

    /**
     * is not null. <br>
     * operate has no effect for is not null.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    L inn(AtomicInteger index, String field, Boolean value);

    // ********************************************************************

    /**
     * great equals.
     *
     * @param index the index
     * @param property the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(AtomicInteger index, SerializableIntSupplier property, IntPredicate ignoreStrategy);

    /**
     * great equals.
     *
     * @param index the index
     * @param property the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(AtomicInteger index, SerializableLongSupplier property, LongPredicate ignoreStrategy);

    /**
     * great equals.
     *
     * @param index the index
     * @param property the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(AtomicInteger index, SerializableDoubleSupplier property, DoublePredicate ignoreStrategy);

    /**
     * great equals.
     *
     * @param index the index
     * @param property the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(AtomicInteger index, SerializableIntSupplier property, Predicate<?> ignoreStrategy);

    /**
     * great equals.
     *
     * @param index the index
     * @param property the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(AtomicInteger index, SerializableLongSupplier property, Predicate<?> ignoreStrategy);

    /**
     * great equals.
     *
     * @param index the index
     * @param property the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(AtomicInteger index, SerializableDoubleSupplier property, Predicate<?> ignoreStrategy);

    /**
     * great equals.
     *
     * @param <V> the value type
     * @param index the index
     * @param property the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L ge(AtomicInteger index, SerializableSupplier<V> property, Predicate<?> ignoreStrategy);

    /**
     * great equals.
     *
     * @param index the index
     * @param property the property
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(AtomicInteger index, SerializableStringSupplier property, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy);

    /**
     * great equals.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(AtomicInteger index, SerializableToIntFunction<?> field, int value, IntPredicate ignoreStrategy);

    /**
     * great equals.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(AtomicInteger index, SerializableToLongFunction<?> field, long value, LongPredicate ignoreStrategy);

    /**
     * great equals.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(AtomicInteger index, SerializableToDoubleFunction<?> field, double value, DoublePredicate ignoreStrategy);

    /**
     * great equals.
     *
     * @param <V> the value type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L ge(AtomicInteger index, Serializable field, V value, Predicate<?> ignoreStrategy);

    /**
     * great equals.
     *
     * @param <V> the value type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L ge(AtomicInteger index, Serializable field, V value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy);

    /**
     * great equals.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(AtomicInteger index, String field, int value, IntPredicate ignoreStrategy);

    /**
     * great equals.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(AtomicInteger index, String field, long value, LongPredicate ignoreStrategy);

    /**
     * great equals.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(AtomicInteger index, String field, double value, DoublePredicate ignoreStrategy);

    /**
     * great equals.
     *
     * @param <V> the value type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L ge(AtomicInteger index, String field, V value, Predicate<?> ignoreStrategy);

    /**
     * great equals.
     *
     * @param <V> the value type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <V> L ge(AtomicInteger index, Object field, V value, Predicate<?> ignoreStrategy) {
        if (field instanceof String) {
            return ge(index, (String) field, value, ignoreStrategy);
        } else if (field instanceof ParamedColumnElement) {
            return ge(index, (ParamedColumnElement) field, value, ignoreStrategy);
        } else {
            throw new UnsupportedException("unsupported type " + field.getClass().getName());
        }
    }

    /**
     * great equals.
     *
     * @param <V> the value type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L ge(AtomicInteger index, String field, V value, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy);

    /**
     * great equals.
     *
     * @param <V> the value type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <V> L ge(AtomicInteger index, Object field, V value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        if (field instanceof String) {
            return ge(index, (String) field, value, matchStrategy, ignoreStrategy);
        } else if (field instanceof ParamedColumnElement) {
            return ge(index, (ParamedColumnElement) field, value, matchStrategy, ignoreStrategy);
        } else {
            throw new UnsupportedException("unsupported type " + field.getClass().getName());
        }
    }

    /**
     * great equals.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(AtomicInteger index, ParamedColumnElement field, int value, IntPredicate ignoreStrategy);

    /**
     * great equals.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(AtomicInteger index, ParamedColumnElement field, long value, LongPredicate ignoreStrategy);

    /**
     * great equals.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ge(AtomicInteger index, ParamedColumnElement field, double value, DoublePredicate ignoreStrategy);

    /**
     * great equals.
     *
     * @param <V> the value type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L ge(AtomicInteger index, ParamedColumnElement field, V value, Predicate<?> ignoreStrategy);

    /**
     * great equals.
     *
     * @param <V> the value type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L ge(AtomicInteger index, ParamedColumnElement field, V value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy);

    // ********************************************************************

    /**
     * great than.
     *
     * @param index the index
     * @param property the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(AtomicInteger index, SerializableIntSupplier property, IntPredicate ignoreStrategy);

    /**
     * great than.
     *
     * @param index the index
     * @param property the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(AtomicInteger index, SerializableLongSupplier property, LongPredicate ignoreStrategy);

    /**
     * great than.
     *
     * @param index the index
     * @param property the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(AtomicInteger index, SerializableDoubleSupplier property, DoublePredicate ignoreStrategy);

    /**
     * great than.
     *
     * @param index the index
     * @param property the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(AtomicInteger index, SerializableIntSupplier property, Predicate<?> ignoreStrategy);

    /**
     * great than.
     *
     * @param index the index
     * @param property the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(AtomicInteger index, SerializableLongSupplier property, Predicate<?> ignoreStrategy);

    /**
     * great than.
     *
     * @param index the index
     * @param property the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(AtomicInteger index, SerializableDoubleSupplier property, Predicate<?> ignoreStrategy);

    /**
     * great than.
     *
     * @param <V> the value type
     * @param index the index
     * @param property the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L gt(AtomicInteger index, SerializableSupplier<V> property, Predicate<?> ignoreStrategy);

    /**
     * great than.
     *
     * @param index the index
     * @param property the property
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(AtomicInteger index, SerializableStringSupplier property, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy);

    /**
     * great than.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(AtomicInteger index, SerializableToIntFunction<?> field, int value, IntPredicate ignoreStrategy);

    /**
     * great than.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(AtomicInteger index, SerializableToLongFunction<?> field, long value, LongPredicate ignoreStrategy);

    /**
     * great than.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(AtomicInteger index, SerializableToDoubleFunction<?> field, double value, DoublePredicate ignoreStrategy);

    /**
     * great than.
     *
     * @param <V> the value type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L gt(AtomicInteger index, Serializable field, V value, Predicate<?> ignoreStrategy);

    /**
     * great than.
     *
     * @param <V> the value type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L gt(AtomicInteger index, Serializable field, V value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy);

    /**
     * great than.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(AtomicInteger index, String field, int value, IntPredicate ignoreStrategy);

    /**
     * great than.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(AtomicInteger index, String field, long value, LongPredicate ignoreStrategy);

    /**
     * great than.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(AtomicInteger index, String field, double value, DoublePredicate ignoreStrategy);

    /**
     * great than.
     *
     * @param <V> the value type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L gt(AtomicInteger index, String field, V value, Predicate<?> ignoreStrategy);

    /**
     * great than.
     *
     * @param <V> the value type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <V> L gt(AtomicInteger index, Object field, V value, Predicate<?> ignoreStrategy) {
        if (field instanceof String) {
            return gt(index, (String) field, value, ignoreStrategy);
        } else if (field instanceof ParamedColumnElement) {
            return gt(index, (ParamedColumnElement) field, value, ignoreStrategy);
        } else {
            throw new UnsupportedException("unsupported type " + field.getClass().getName());
        }
    }

    /**
     * great than.
     *
     * @param <V> the value type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L gt(AtomicInteger index, String field, V value, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy);

    /**
     * great than.
     *
     * @param <V> the value type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <V> L gt(AtomicInteger index, Object field, V value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        if (field instanceof String) {
            return gt(index, (String) field, value, matchStrategy, ignoreStrategy);
        } else if (field instanceof ParamedColumnElement) {
            return gt(index, (ParamedColumnElement) field, value, matchStrategy, ignoreStrategy);
        } else {
            throw new UnsupportedException("unsupported type " + field.getClass().getName());
        }
    }

    /**
     * great than.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(AtomicInteger index, ParamedColumnElement field, int value, IntPredicate ignoreStrategy);

    /**
     * great than.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(AtomicInteger index, ParamedColumnElement field, long value, LongPredicate ignoreStrategy);

    /**
     * great than.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(AtomicInteger index, ParamedColumnElement field, double value, DoublePredicate ignoreStrategy);

    /**
     * great than.
     *
     * @param <V> the value type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L gt(AtomicInteger index, ParamedColumnElement field, V value, Predicate<?> ignoreStrategy);

    /**
     * great than.
     *
     * @param <V> the value type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L gt(AtomicInteger index, ParamedColumnElement field, V value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy);

    // ********************************************************************

    /**
     * less equals.
     *
     * @param index the index
     * @param property the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(AtomicInteger index, SerializableIntSupplier property, IntPredicate ignoreStrategy);

    /**
     * less equals.
     *
     * @param index the index
     * @param property the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */

    L le(AtomicInteger index, SerializableLongSupplier property, LongPredicate ignoreStrategy);

    /**
     * less equals.
     *
     * @param index the index
     * @param property the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */

    L le(AtomicInteger index, SerializableDoubleSupplier property, DoublePredicate ignoreStrategy);

    /**
     * less equals.
     *
     * @param index the index
     * @param property the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(AtomicInteger index, SerializableIntSupplier property, Predicate<?> ignoreStrategy);

    /**
     * less equals.
     *
     * @param index the index
     * @param property the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(AtomicInteger index, SerializableLongSupplier property, Predicate<?> ignoreStrategy);

    /**
     * less equals.
     *
     * @param index the index
     * @param property the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(AtomicInteger index, SerializableDoubleSupplier property, Predicate<?> ignoreStrategy);

    /**
     * less equals.
     *
     * @param <V> the value type
     * @param index the index
     * @param property the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L le(AtomicInteger index, SerializableSupplier<V> property, Predicate<?> ignoreStrategy);

    /**
     * less equals.
     *
     * @param index the index
     * @param property the property
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(AtomicInteger index, SerializableStringSupplier property, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy);

    /**
     * less equals.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(AtomicInteger index, SerializableToIntFunction<?> field, int value, IntPredicate ignoreStrategy);

    /**
     * less equals.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(AtomicInteger index, SerializableToLongFunction<?> field, long value, LongPredicate ignoreStrategy);

    /**
     * less equals.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(AtomicInteger index, SerializableToDoubleFunction<?> field, double value, DoublePredicate ignoreStrategy);

    /**
     * less equals.
     *
     * @param <V> the value type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L le(AtomicInteger index, Serializable field, V value, Predicate<?> ignoreStrategy);

    /**
     * less equals.
     *
     * @param <V> the value type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L le(AtomicInteger index, Serializable field, V value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy);

    /**
     * less equals.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(AtomicInteger index, String field, int value, IntPredicate ignoreStrategy);

    /**
     * less equals.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(AtomicInteger index, String field, long value, LongPredicate ignoreStrategy);

    /**
     * less equals.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(AtomicInteger index, String field, double value, DoublePredicate ignoreStrategy);

    /**
     * less equals.
     *
     * @param <V> the value type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L le(AtomicInteger index, String field, V value, Predicate<?> ignoreStrategy);

    /**
     * less equals.
     *
     * @param <V> the value type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <V> L le(AtomicInteger index, Object field, V value, Predicate<?> ignoreStrategy) {
        if (field instanceof String) {
            return le(index, (String) field, value, ignoreStrategy);
        } else if (field instanceof ParamedColumnElement) {
            return le(index, (ParamedColumnElement) field, value, ignoreStrategy);
        } else {
            throw new UnsupportedException("unsupported type " + field.getClass().getName());
        }
    }

    /**
     * less equals.
     *
     * @param <V> the value type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L le(AtomicInteger index, String field, V value, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy);

    /**
     * less equals.
     *
     * @param <V> the value type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <V> L le(AtomicInteger index, Object field, V value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        if (field instanceof String) {
            return le(index, (String) field, value, matchStrategy, ignoreStrategy);
        } else if (field instanceof ParamedColumnElement) {
            return le(index, (ParamedColumnElement) field, value, matchStrategy, ignoreStrategy);
        } else {
            throw new UnsupportedException("unsupported type " + field.getClass().getName());
        }
    }

    /**
     * less equals.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(AtomicInteger index, ParamedColumnElement field, int value, IntPredicate ignoreStrategy);

    /**
     * less equals.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(AtomicInteger index, ParamedColumnElement field, long value, LongPredicate ignoreStrategy);

    /**
     * less equals.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L le(AtomicInteger index, ParamedColumnElement field, double value, DoublePredicate ignoreStrategy);

    /**
     * less equals.
     *
     * @param <V> the value type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L le(AtomicInteger index, ParamedColumnElement field, V value, Predicate<?> ignoreStrategy);

    /**
     * less equals.
     *
     * @param <V> the value type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L le(AtomicInteger index, ParamedColumnElement field, V value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy);

    // ****************************************************************************************************************

    /**
     * less than.
     *
     * @param index the index
     * @param property the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(AtomicInteger index, SerializableIntSupplier property, IntPredicate ignoreStrategy);

    /**
     * less than.
     *
     * @param index the index
     * @param property the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(AtomicInteger index, SerializableLongSupplier property, LongPredicate ignoreStrategy);

    /**
     * less than.
     *
     * @param index the index
     * @param property the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(AtomicInteger index, SerializableDoubleSupplier property, DoublePredicate ignoreStrategy);

    /**
     * less than.
     *
     * @param index the index
     * @param property the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(AtomicInteger index, SerializableIntSupplier property, Predicate<?> ignoreStrategy);

    /**
     * less than.
     *
     * @param index the index
     * @param property the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(AtomicInteger index, SerializableLongSupplier property, Predicate<?> ignoreStrategy);

    /**
     * less than.
     *
     * @param index the index
     * @param property the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(AtomicInteger index, SerializableDoubleSupplier property, Predicate<?> ignoreStrategy);

    /**
     * less than.
     *
     * @param <V> the value type
     * @param index the index
     * @param property the property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L lt(AtomicInteger index, SerializableSupplier<V> property, Predicate<?> ignoreStrategy);

    /**
     * less than.
     *
     * @param index the index
     * @param property the property
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(AtomicInteger index, SerializableStringSupplier property, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy);

    /**
     * less than.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(AtomicInteger index, SerializableToIntFunction<?> field, int value, IntPredicate ignoreStrategy);

    /**
     * less than.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(AtomicInteger index, SerializableToLongFunction<?> field, long value, LongPredicate ignoreStrategy);

    /**
     * less than.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(AtomicInteger index, SerializableToDoubleFunction<?> field, double value, DoublePredicate ignoreStrategy);

    /**
     * less than.
     *
     * @param <V> the value type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L lt(AtomicInteger index, Serializable field, V value, Predicate<?> ignoreStrategy);

    /**
     * less than.
     *
     * @param <V> the value type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L lt(AtomicInteger index, Serializable field, V value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy);

    /**
     * less than.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(AtomicInteger index, String field, int value, IntPredicate ignoreStrategy);

    /**
     * less than.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(AtomicInteger index, String field, long value, LongPredicate ignoreStrategy);

    /**
     * less than.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(AtomicInteger index, String field, double value, DoublePredicate ignoreStrategy);

    /**
     * less than.
     *
     * @param <V> the value type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L lt(AtomicInteger index, String field, V value, Predicate<?> ignoreStrategy);

    /**
     * less than.
     *
     * @param <V> the value type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <V> L lt(AtomicInteger index, Object field, V value, Predicate<?> ignoreStrategy) {
        if (field instanceof String) {
            return lt(index, (String) field, value, ignoreStrategy);
        } else if (field instanceof ParamedColumnElement) {
            return lt(index, (ParamedColumnElement) field, value, ignoreStrategy);
        } else {
            throw new UnsupportedException("unsupported type " + field.getClass().getName());
        }
    }

    /**
     * less than.
     *
     * @param <V> the value type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L lt(AtomicInteger index, String field, V value, MatchStrategy matchStrategy, Predicate<?> ignoreStrategy);

    /**
     * less than.
     *
     * @param <V> the value type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <V> L lt(AtomicInteger index, Object field, V value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy) {
        if (field instanceof String) {
            return lt(index, (String) field, value, matchStrategy, ignoreStrategy);
        } else if (field instanceof ParamedColumnElement) {
            return lt(index, (ParamedColumnElement) field, value, matchStrategy, ignoreStrategy);
        } else {
            throw new UnsupportedException("unsupported type " + field.getClass().getName());
        }
    }

    /**
     * less than.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(AtomicInteger index, ParamedColumnElement field, int value, IntPredicate ignoreStrategy);

    /**
     * less than.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(AtomicInteger index, ParamedColumnElement field, long value, LongPredicate ignoreStrategy);

    /**
     * less than.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L lt(AtomicInteger index, ParamedColumnElement field, double value, DoublePredicate ignoreStrategy);

    /**
     * less than.
     *
     * @param <V> the value type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L lt(AtomicInteger index, ParamedColumnElement field, V value, Predicate<?> ignoreStrategy);

    /**
     * less than.
     *
     * @param <V> the value type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <V> L lt(AtomicInteger index, ParamedColumnElement field, V value, MatchStrategy matchStrategy,
        Predicate<?> ignoreStrategy);
}
