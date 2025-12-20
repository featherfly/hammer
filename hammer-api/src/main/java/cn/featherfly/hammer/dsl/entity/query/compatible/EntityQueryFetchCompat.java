
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2025-12-10 15:56:10
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.dsl.entity.query.compatible;

import cn.featherfly.common.exception.NotImplementedException;
import cn.featherfly.common.exception.UnsupportedException;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.operator.AggregateFunction;
import cn.featherfly.common.operator.DateFunction;
import cn.featherfly.common.operator.Function;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryFetchedProperties;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelateBase;

/**
 * CompatibleEntityQueryFetch.
 *
 * @author zhongj
 */
public interface EntityQueryFetchCompat<E>
    extends EntityQueryRelateBase<E>, EntityQueryCompat<E, EntityQueryFetchCompat<E>> {

    /**
     * 设置返回的属性..
     *
     * @param <V> the value type
     * @param propertyName propertyName
     * @return QueryEntityPropertiesExpression
     */
    default <V> EntityQueryFetchedOnePropertyCompat<E, V> fetch(SerializableFunction<E, V> propertyName) {
        return fetch(false, propertyName);
    }

    /**
     * 设置返回的属性..
     *
     * @param <V> the value type
     * @param distinct the distinct
     * @param propertyName propertyName
     * @return QueryEntityPropertiesExpression
     */
    <V> EntityQueryFetchedOnePropertyCompat<E, V> fetch(boolean distinct, SerializableFunction<E, V> propertyName);

    /**
     * 批量设置返回的属性.
     *
     * @param propertyNames propertyNames
     * @return QueryEntityPropertiesExpression
     */
    EntityQueryFetchedProperties<E> fetch(@SuppressWarnings("unchecked") SerializableFunction<E, ?>... propertyNames);

    /**
     * 添加查询出来的属性.
     *
     * @param <V> the value type
     * @param function the function
     * @param propertyName propertyName
     * @return QueryEntityPropertiesExpression
     */
    default <V> EntityQueryFetchedOnePropertyCompat<E, V> fetch(Function function,
        SerializableFunction<E, V> propertyName) {
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
     * @param <V> the value type
     * @param aggregateFunction aggregateFunction
     * @param propertyName propertyName
     * @return QueryEntityPropertiesExpression
     */
    default <V> EntityQueryFetchedOnePropertyCompat<E, V> fetch(AggregateFunction aggregateFunction,
        SerializableFunction<E, V> propertyName) {
        return fetch(aggregateFunction, false, propertyName);
    }

    /**
     * 添加查询出来的属性.
     *
     * @param <V> the value type
     * @param aggregateFunction aggregateFunction
     * @param distinct the distinct
     * @param propertyName propertyName
     * @return QueryEntityPropertiesExpression
     */
    <V> EntityQueryFetchedOnePropertyCompat<E, V> fetch(AggregateFunction aggregateFunction, boolean distinct,
        SerializableFunction<E, V> propertyName);

    /**
     * Distinct.
     *
     * @param <V> the value type
     * @param propertyName the property name
     * @return the q
     */
    default <V> EntityQueryFetchedOnePropertyCompat<E, V> distinct(SerializableFunction<E, V> propertyName) {
        return fetch(true, propertyName);
    }

    /**
     * Count.
     *
     * @param <V> the value type
     * @param propertyName the property name
     * @return the q
     */
    default <V> EntityQueryFetchedOnePropertyCompat<E, V> count(SerializableFunction<E, V> propertyName) {
        return count(false, propertyName);
    }

    /**
     * Count.
     *
     * @param <V> the value type
     * @param distinct the distinct
     * @param propertyName the property name
     * @return the q
     */
    default <V> EntityQueryFetchedOnePropertyCompat<E, V> count(boolean distinct,
        SerializableFunction<E, V> propertyName) {
        return fetch(AggregateFunction.COUNT, distinct, propertyName);
    }

    /**
     * Sum.
     *
     * @param <V> the value type
     * @param propertyName the property name
     * @return the q
     */
    default <V> EntityQueryFetchedOnePropertyCompat<E, V> sum(SerializableFunction<E, V> propertyName) {
        return sum(false, propertyName);
    }

    /**
     * Sum.
     *
     * @param <V> the value type
     * @param distinct the distinct
     * @param propertyName the property name
     * @return the q
     */
    default <V> EntityQueryFetchedOnePropertyCompat<E, V> sum(boolean distinct,
        SerializableFunction<E, V> propertyName) {
        return fetch(AggregateFunction.SUM, distinct, propertyName);
    }

    /**
     * Max.
     *
     * @param <V> the value type
     * @param propertyName the property name
     * @return the q
     */
    default <V> EntityQueryFetchedOnePropertyCompat<E, V> max(SerializableFunction<E, V> propertyName) {
        return max(false, propertyName);
    }

    /**
     * Max.
     *
     * @param <V> the value type
     * @param distinct the distinct
     * @param propertyName the property name
     * @return the q
     */
    default <V> EntityQueryFetchedOnePropertyCompat<E, V> max(boolean distinct,
        SerializableFunction<E, V> propertyName) {
        return fetch(AggregateFunction.MAX, distinct, propertyName);
    }

    /**
     * Min.
     *
     * @param <V> the value type
     * @param propertyName the property name
     * @return the q
     */
    default <V> EntityQueryFetchedOnePropertyCompat<E, V> min(SerializableFunction<E, V> propertyName) {
        return min(false, propertyName);
    }

    /**
     * Min.
     *
     * @param <V> the value type
     * @param distinct the distinct
     * @param propertyName the property name
     * @return the q
     */
    default <V> EntityQueryFetchedOnePropertyCompat<E, V> min(boolean distinct,
        SerializableFunction<E, V> propertyName) {
        return fetch(AggregateFunction.MIN, distinct, propertyName);
    }

    /**
     * Avg.
     *
     * @param <V> the value type
     * @param propertyName the property name
     * @return the q
     */
    default <V> EntityQueryFetchedOnePropertyCompat<E, V> avg(SerializableFunction<E, V> propertyName) {
        return avg(false, propertyName);
    }

    /**
     * Avg.
     *
     * @param <V> the value type
     * @param distinct the distinct
     * @param propertyName the property name
     * @return the q
     */
    default <V> EntityQueryFetchedOnePropertyCompat<E, V> avg(boolean distinct,
        SerializableFunction<E, V> propertyName) {
        return fetch(AggregateFunction.AVG, distinct, propertyName);
    }

    // ****************************************************************************************************************

    /**
     * 设置返回的属性..
     *
     * @param <V> the value type
     * @param propertyName propertyName
     * @return QueryEntityPropertiesExpression
     */
    default <V> EntityQueryFetchedOnePropertyCompat<E, V> fetch(String propertyName) {
        return fetch(false, propertyName);
    }

    /**
     * 设置返回的属性..
     *
     * @param <V> the value type
     * @param distinct the distinct
     * @param propertyName propertyName
     * @return QueryEntityPropertiesExpression
     */
    <V> EntityQueryFetchedOnePropertyCompat<E, V> fetch(boolean distinct, String propertyName);

    /**
     * 批量设置返回的属性.
     *
     * @param propertyNames propertyNames
     * @return QueryEntityPropertiesExpression
     */
    EntityQueryFetchedProperties<E> fetch(String... propertyNames);

    /**
     * 添加查询出来的属性.
     *
     * @param <V> the value type
     * @param function the function
     * @param propertyName propertyName
     * @return QueryEntityPropertiesExpression
     */
    default <V> EntityQueryFetchedOnePropertyCompat<E, V> fetch(Function function, String propertyName) {
        if (function instanceof AggregateFunction) {
            return fetch((AggregateFunction) function, propertyName);
        } else if (function instanceof DateFunction) {
            // NOIMPL 还未实现
            throw new NotImplementedException();
        } else {
            // TODO 后续实现了相关Function再来修改
            throw new UnsupportedException();
        }
    }

    /**
     * 添加查询出来的属性.
     *
     * @param <V> the value type
     * @param aggregateFunction aggregateFunction
     * @param propertyName propertyName
     * @return QueryEntityPropertiesExpression
     */
    default <V> EntityQueryFetchedOnePropertyCompat<E, V> fetch(AggregateFunction aggregateFunction,
        String propertyName) {
        return fetch(aggregateFunction, false, propertyName);
    }

    /**
     * 添加查询出来的属性.
     *
     * @param <V> the value type
     * @param aggregateFunction aggregateFunction
     * @param distinct the distinct
     * @param propertyName propertyName
     * @return QueryEntityPropertiesExpression
     */
    <V> EntityQueryFetchedOnePropertyCompat<E, V> fetch(AggregateFunction aggregateFunction, boolean distinct,
        String propertyName);

    /**
     * Distinct.
     *
     * @param <V> the value type
     * @param propertyName the property name
     * @return the q
     */
    default <V> EntityQueryFetchedOnePropertyCompat<E, V> distinct(String propertyName) {
        return fetch(true, propertyName);
    }

    /**
     * Count.
     *
     * @param <V> the value type
     * @param propertyName the property name
     * @return the q
     */
    default <V> EntityQueryFetchedOnePropertyCompat<E, V> count(String propertyName) {
        return count(false, propertyName);
    }

    /**
     * Count.
     *
     * @param <V> the value type
     * @param distinct the distinct
     * @param propertyName the property name
     * @return the q
     */
    default <V> EntityQueryFetchedOnePropertyCompat<E, V> count(boolean distinct, String propertyName) {
        return fetch(AggregateFunction.COUNT, distinct, propertyName);
    }

    /**
     * Sum.
     *
     * @param <V> the value type
     * @param propertyName the property name
     * @return the q
     */
    default <V> EntityQueryFetchedOnePropertyCompat<E, V> sum(String propertyName) {
        return sum(false, propertyName);
    }

    /**
     * Sum.
     *
     * @param <V> the value type
     * @param distinct the distinct
     * @param propertyName the property name
     * @return the q
     */
    default <V> EntityQueryFetchedOnePropertyCompat<E, V> sum(boolean distinct, String propertyName) {
        return fetch(AggregateFunction.SUM, distinct, propertyName);
    }

    /**
     * Max.
     *
     * @param <V> the value type
     * @param propertyName the property name
     * @return the q
     */
    default <V> EntityQueryFetchedOnePropertyCompat<E, V> max(String propertyName) {
        return max(false, propertyName);
    }

    /**
     * Max.
     *
     * @param <V> the value type
     * @param distinct the distinct
     * @param propertyName the property name
     * @return the q
     */
    default <V> EntityQueryFetchedOnePropertyCompat<E, V> max(boolean distinct, String propertyName) {
        return fetch(AggregateFunction.MAX, distinct, propertyName);
    }

    /**
     * Min.
     *
     * @param <V> the value type
     * @param propertyName the property name
     * @return the q
     */
    default <V> EntityQueryFetchedOnePropertyCompat<E, V> min(String propertyName) {
        return min(false, propertyName);
    }

    /**
     * Min.
     *
     * @param <V> the value type
     * @param distinct the distinct
     * @param propertyName the property name
     * @return the q
     */
    default <V> EntityQueryFetchedOnePropertyCompat<E, V> min(boolean distinct, String propertyName) {
        return fetch(AggregateFunction.MIN, distinct, propertyName);
    }

    /**
     * Avg.
     *
     * @param <V> the value type
     * @param propertyName the property name
     * @return the q
     */
    default <V> EntityQueryFetchedOnePropertyCompat<E, V> avg(String propertyName) {
        return avg(false, propertyName);
    }

    /**
     * Avg.
     *
     * @param <V> the value type
     * @param distinct the distinct
     * @param propertyName the property name
     * @return the q
     */
    default <V> EntityQueryFetchedOnePropertyCompat<E, V> avg(boolean distinct, String propertyName) {
        return fetch(AggregateFunction.AVG, distinct, propertyName);
    }

}
