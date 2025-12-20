/*
 * All rights Reserved, Designed By zhongj
 * @Title: InOrNotInExpression.java
 * @Package cn.featherfly.hammer.expression.condition
 * @author: zhongj
 * @date: 2025-12-11 01:21:11
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.condition;

import java.util.Collection;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;

/**
 * The Interface InNotInRepositoryExpression.
 *
 * @author zhongj
 */
public interface InOrNotInExpression {

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param <R> the generic type
     * @param name the name
     * @param value the value
     */
    <R> void accept(String name, R value);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param <R> the generic type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     */
    <R> void accept(String name, R value, Predicate<R> ignoreStrategy);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     */
    void accept(String name, String value, MatchStrategy matchStrategy);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     */
    void accept(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param name the name
     * @param value the value
     */
    void accept(String name, int value);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     */
    void accept(String name, int value, IntPredicate ignoreStrategy);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param name the name
     * @param value the value
     */
    void accept(String name, long value);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     */
    void accept(String name, long value, LongPredicate ignoreStrategy);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param name the name
     * @param value the value
     */
    void accept(String name, double value);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     */
    void accept(String name, double value, DoublePredicate ignoreStrategy);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param <R> the generic type
     * @param name the name
     * @param value the value
     */
    <R> void accept(String name, @SuppressWarnings("unchecked") R... value);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     */
    void accept(String name, String[] value, MatchStrategy matchStrategy);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     */
    void accept(String name, String[] value, MatchStrategy matchStrategy, Predicate<String[]> ignoreStrategy);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param name the name
     * @param value the value
     */
    void accept(String name, int... value);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param name the name
     * @param value the value
     */
    void accept(String name, long... value);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param <R> the generic type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     */
    <R> void accept(String name, R[] value, Predicate<R[]> ignoreStrategy);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     */
    void accept(String name, int[] value, Predicate<int[]> ignoreStrategy);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     */
    void accept(String name, long[] value, Predicate<long[]> ignoreStrategy);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param <R> the generic type
     * @param name the name
     * @param value the value
     */
    <R> void accept(String name, Collection<R> value);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param <R> the generic type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     */
    <R> void accept(String name, Collection<R> value, Predicate<Collection<R>> ignoreStrategy);
}
