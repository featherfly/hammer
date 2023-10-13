
package cn.featherfly.hammer.expression.entity.query;

import cn.featherfly.common.exception.UnsupportedException;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.operator.AggregateFunction;
import cn.featherfly.common.operator.Function;

/**
 * The Interface EntityQueryFetchExpression.
 *
 * @author zhongj
 * @param <E> the query type
 * @param <Q> the generic type
 */
public interface EntityQueryFetchedPropertiesExpression<E, Q extends EntityQueryFetchedPropertiesExpression<E, Q>> {

    /**
     * 批量添加查询出来的属性.
     *
     * @param propertyNames propertyNames
     * @return QueryEntityPropertiesExpression
     */
    Q property(@SuppressWarnings("unchecked") SerializableFunction<E, ?>... propertyNames);

    /**
     * 添加查询出来的属性.
     *
     * @param <R>          the generic type
     * @param propertyName propertyName
     * @return QueryEntityPropertiesExpression
     */
    default <R> Q property(SerializableFunction<E, R> propertyName) {
        return property(false, propertyName);
    }

    /**
     * 添加查询出来的属性.
     *
     * @param <R>          the generic type
     * @param distinct     the distinct
     * @param propertyName propertyName
     * @return QueryEntityPropertiesExpression
     */
    <R> Q property(boolean distinct, SerializableFunction<E, R> propertyName);

    /**
     * 添加查询出来的属性.
     *
     * @param <R>          the generic type
     * @param function     the function
     * @param propertyName propertyName
     * @return QueryEntityPropertiesExpression
     */
    default <R> Q property(Function function, SerializableFunction<E, R> propertyName) {
        if (function instanceof AggregateFunction) {
            return property((AggregateFunction) function, propertyName);
        } else {
            // TODO 后续实现了相关Function再来修改
            throw new UnsupportedException();
        }
    }

    /**
     * 添加查询出来的属性.
     *
     * @param <R>               the generic type
     * @param aggregateFunction aggregateFunction
     * @param propertyName      propertyName
     * @return QueryEntityPropertiesExpression
     */
    default <R> Q property(AggregateFunction aggregateFunction, SerializableFunction<E, R> propertyName) {
        return property(aggregateFunction, false, propertyName);
    }

    /**
     * 添加查询出来的属性.
     *
     * @param <R>               the generic type
     * @param aggregateFunction aggregateFunction
     * @param distinct          the distinct
     * @param propertyName      propertyName
     * @return QueryEntityPropertiesExpression
     */
    <R> Q property(AggregateFunction aggregateFunction, boolean distinct, SerializableFunction<E, R> propertyName);

    /**
     * 设置返回的属性..
     *
     * @param <R>          the generic type
     * @param propertyName propertyName
     * @return QueryEntityPropertiesExpression
     */
    default <R> Q fetch(SerializableFunction<E, R> propertyName) {
        return fetch(false, propertyName);
    }

    /**
     * 设置返回的属性..
     *
     * @param <R>          the generic type
     * @param distinct     the distinct
     * @param propertyName propertyName
     * @return QueryEntityPropertiesExpression
     */
    default <R> Q fetch(boolean distinct, SerializableFunction<E, R> propertyName) {
        return property(distinct, propertyName);
    }

    /**
     * 批量设置返回的属性.
     *
     * @param propertyNames propertyNames
     * @return QueryEntityPropertiesExpression
     */
    default Q fetch(@SuppressWarnings("unchecked") SerializableFunction<E, ?>... propertyNames) {
        return property(propertyNames);
    }

    /**
     * 添加查询出来的属性.
     *
     * @param <R>          the generic type
     * @param function     the function
     * @param propertyName propertyName
     * @return QueryEntityPropertiesExpression
     */
    default <R> Q fetch(Function function, SerializableFunction<E, R> propertyName) {
        return property(function, propertyName);
    }

    /**
     * 添加查询出来的属性.
     *
     * @param <R>               the generic type
     * @param aggregateFunction aggregateFunction
     * @param propertyName      propertyName
     * @return QueryEntityPropertiesExpression
     */
    default <R> Q fetch(AggregateFunction aggregateFunction, SerializableFunction<E, R> propertyName) {
        return property(aggregateFunction, propertyName);
    }

    /**
     * 添加查询出来的属性.
     *
     * @param <R>               the generic type
     * @param aggregateFunction aggregateFunction
     * @param distinct          the distinct
     * @param propertyName      propertyName
     * @return QueryEntityPropertiesExpression
     */
    default <R> Q fetch(AggregateFunction aggregateFunction, boolean distinct,
            SerializableFunction<E, R> propertyName) {
        return property(aggregateFunction, distinct, propertyName);
    }

    /**
     * Distinct.
     *
     * @param <R>          the generic type
     * @param propertyName the property name
     * @return the q
     */
    default <R> Q distinct(SerializableFunction<E, R> propertyName) {
        return property(true, propertyName);
    }

    /**
     * Count.
     *
     * @param <R>          the generic type
     * @param propertyName the property name
     * @return the q
     */
    default <R> Q count(SerializableFunction<E, R> propertyName) {
        return count(false, propertyName);
    }

    /**
     * Count.
     *
     * @param <R>          the generic type
     * @param distinct     the distinct
     * @param propertyName the property name
     * @return the q
     */
    default <R> Q count(boolean distinct, SerializableFunction<E, R> propertyName) {
        return property(AggregateFunction.COUNT, distinct, propertyName);
    }

    /**
     * Sum.
     *
     * @param <R>          the generic type
     * @param propertyName the property name
     * @return the q
     */
    default <R> Q sum(SerializableFunction<E, R> propertyName) {
        return sum(false, propertyName);
    }

    /**
     * Sum.
     *
     * @param <R>          the generic type
     * @param distinct     the distinct
     * @param propertyName the property name
     * @return the q
     */
    default <R> Q sum(boolean distinct, SerializableFunction<E, R> propertyName) {
        return property(AggregateFunction.SUM, distinct, propertyName);
    }

    /**
     * Max.
     *
     * @param <R>          the generic type
     * @param propertyName the property name
     * @return the q
     */
    default <R> Q max(SerializableFunction<E, R> propertyName) {
        return max(false, propertyName);
    }

    /**
     * Max.
     *
     * @param <R>          the generic type
     * @param distinct     the distinct
     * @param propertyName the property name
     * @return the q
     */
    default <R> Q max(boolean distinct, SerializableFunction<E, R> propertyName) {
        return property(AggregateFunction.MAX, distinct, propertyName);
    }

    /**
     * Min.
     *
     * @param <R>          the generic type
     * @param propertyName the property name
     * @return the q
     */
    default <R> Q min(SerializableFunction<E, R> propertyName) {
        return min(false, propertyName);
    }

    /**
     * Min.
     *
     * @param <R>          the generic type
     * @param distinct     the distinct
     * @param propertyName the property name
     * @return the q
     */
    default <R> Q min(boolean distinct, SerializableFunction<E, R> propertyName) {
        return property(AggregateFunction.MIN, distinct, propertyName);
    }

    /**
     * Avg.
     *
     * @param <R>          the generic type
     * @param propertyName the property name
     * @return the q
     */
    default <R> Q avg(SerializableFunction<E, R> propertyName) {
        return avg(false, propertyName);
    }

    /**
     * Avg.
     *
     * @param <R>          the generic type
     * @param distinct     the distinct
     * @param propertyName the property name
     * @return the q
     */
    default <R> Q avg(boolean distinct, SerializableFunction<E, R> propertyName) {
        return property(AggregateFunction.AVG, distinct, propertyName);
    }

}
