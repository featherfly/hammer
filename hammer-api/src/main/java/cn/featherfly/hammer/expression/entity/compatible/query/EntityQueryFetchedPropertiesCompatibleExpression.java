/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntityQueryFetchedPropertiesCompatibleExpression.java
 * @Package cn.featherfly.hammer.expression.entity.compatible.query
 * @author: zhongj
 * @date: 2025-12-11 02:25:11
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.compatible.query;

import cn.featherfly.common.exception.UnsupportedException;
import cn.featherfly.common.operator.AggregateFunction;
import cn.featherfly.common.operator.Function;
import cn.featherfly.hammer.expression.entity.query.EntityQueryFetchedPropertiesExpression;

/**
 * The Interface EntityQueryFetchExpression.
 *
 * @author zhongj
 * @param <E> the query type
 * @param <Q> the generic type
 */
public interface EntityQueryFetchedPropertiesCompatibleExpression<E,
    Q extends EntityQueryFetchedPropertiesCompatibleExpression<E, Q>>
    extends EntityQueryFetchedPropertiesExpression<E, Q> {

    /**
     * 设置返回的属性..
     *
     * @param <R> the generic type
     * @param propertyName propertyName
     * @return QueryEntityPropertiesExpression
     */
    default <R> Q fetch(String propertyName) {
        return fetch(false, propertyName);
    }

    /**
     * 设置返回的属性..
     *
     * @param <R> the generic type
     * @param distinct the distinct
     * @param propertyName propertyName
     * @return QueryEntityPropertiesExpression
     */
    <R> Q fetch(boolean distinct, String propertyName);

    /**
     * 批量设置返回的属性.
     *
     * @param propertyNames propertyNames
     * @return QueryEntityPropertiesExpression
     */
    Q fetch(String... propertyNames);

    /**
     * 添加查询出来的属性.
     *
     * @param <R> the generic type
     * @param function the function
     * @param propertyName propertyName
     * @return QueryEntityPropertiesExpression
     */
    default <R> Q fetch(Function function, String propertyName) {
        if (function instanceof AggregateFunction) {
            return fetch((AggregateFunction) function, propertyName);
        } else {
            // TODO 后续实现了相关Function再来修改
            throw new UnsupportedException();
        }
    }

    /**
     * 添加查询出来的属性.
     *
     * @param <R> the generic type
     * @param aggregateFunction aggregateFunction
     * @param propertyName propertyName
     * @return QueryEntityPropertiesExpression
     */
    default <R> Q fetch(AggregateFunction aggregateFunction, String propertyName) {
        return fetch(aggregateFunction, false, propertyName);
    }

    /**
     * 添加查询出来的属性.
     *
     * @param <R> the generic type
     * @param aggregateFunction aggregateFunction
     * @param distinct the distinct
     * @param propertyName propertyName
     * @return QueryEntityPropertiesExpression
     */
    <R> Q fetch(AggregateFunction aggregateFunction, boolean distinct, String propertyName);

    /**
     * Distinct.
     *
     * @param <R> the generic type
     * @param propertyName the property name
     * @return the q
     */
    default <R> Q distinct(String propertyName) {
        return fetch(true, propertyName);
    }

    /**
     * Count.
     *
     * @param <R> the generic type
     * @param propertyName the property name
     * @return the q
     */
    default <R> Q count(String propertyName) {
        return count(false, propertyName);
    }

    /**
     * Count.
     *
     * @param <R> the generic type
     * @param distinct the distinct
     * @param propertyName the property name
     * @return the q
     */
    default <R> Q count(boolean distinct, String propertyName) {
        return fetch(AggregateFunction.COUNT, distinct, propertyName);
    }

    /**
     * Sum.
     *
     * @param <R> the generic type
     * @param propertyName the property name
     * @return the q
     */
    default <R> Q sum(String propertyName) {
        return sum(false, propertyName);
    }

    /**
     * Sum.
     *
     * @param <R> the generic type
     * @param distinct the distinct
     * @param propertyName the property name
     * @return the q
     */
    default <R> Q sum(boolean distinct, String propertyName) {
        return fetch(AggregateFunction.SUM, distinct, propertyName);
    }

    /**
     * Max.
     *
     * @param <R> the generic type
     * @param propertyName the property name
     * @return the q
     */
    default <R> Q max(String propertyName) {
        return max(false, propertyName);
    }

    /**
     * Max.
     *
     * @param <R> the generic type
     * @param distinct the distinct
     * @param propertyName the property name
     * @return the q
     */
    default <R> Q max(boolean distinct, String propertyName) {
        return fetch(AggregateFunction.MAX, distinct, propertyName);
    }

    /**
     * Min.
     *
     * @param <R> the generic type
     * @param propertyName the property name
     * @return the q
     */
    default <R> Q min(String propertyName) {
        return min(false, propertyName);
    }

    /**
     * Min.
     *
     * @param <R> the generic type
     * @param distinct the distinct
     * @param propertyName the property name
     * @return the q
     */
    default <R> Q min(boolean distinct, String propertyName) {
        return fetch(AggregateFunction.MIN, distinct, propertyName);
    }

    /**
     * Avg.
     *
     * @param <R> the generic type
     * @param propertyName the property name
     * @return the q
     */
    default <R> Q avg(String propertyName) {
        return avg(false, propertyName);
    }

    /**
     * Avg.
     *
     * @param <R> the generic type
     * @param distinct the distinct
     * @param propertyName the property name
     * @return the q
     */
    default <R> Q avg(boolean distinct, String propertyName) {
        return fetch(AggregateFunction.AVG, distinct, propertyName);
    }
}
