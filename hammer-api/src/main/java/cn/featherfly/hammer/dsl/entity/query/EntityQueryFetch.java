
package cn.featherfly.hammer.dsl.entity.query;

import cn.featherfly.common.exception.UnsupportedException;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.operator.AggregateFunction;
import cn.featherfly.common.operator.Function;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelateBase;

/**
 * dsl for entity query fetcher.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface EntityQueryFetch<E> extends EntityQueryRelateBase<E>, EntityQuery<E, EntityQueryFetch<E>> {

    /**
     * 批量添加查询出来的属性.
     *
     * @param propertyNames propertyNames
     * @return QueryEntityPropertiesExpression
     */
    EntityQueryFetchedProperties<E> property(
        @SuppressWarnings("unchecked") SerializableFunction<E, ?>... propertyNames);

    /**
     * 添加查询出来的属性.
     *
     * @param <V> the value type
     * @param propertyName propertyName
     * @return QueryEntityPropertiesExpression
     */
    default <V> EntityQueryOneFetchedProperty<E, V> property(SerializableFunction<E, V> propertyName) {
        return property(false, propertyName);
    }

    /**
     * 添加查询出来的属性.
     *
     * @param <V> the generic type
     * @param distinct the distinct
     * @param propertyName propertyName
     * @return QueryEntityPropertiesExpression
     */
    <V> EntityQueryOneFetchedProperty<E, V> property(boolean distinct, SerializableFunction<E, V> propertyName);

    /**
     * 添加查询出来的属性.
     *
     * @param <V> the value type
     * @param function the function
     * @param propertyName propertyName
     * @return QueryEntityPropertiesExpression
     */
    default <V> EntityQueryOneFetchedProperty<E, V> property(Function function,
        SerializableFunction<E, V> propertyName) {
        //        if (function instanceof AggregateFunction) {
        //            return property((AggregateFunction) function, propertyName);
        //        } else {
        //            // TODO 后续实现了相关Function再来修改
        //            throw new UnsupportedException();
        //        }
        // TODO 后续实现了相关Function再来修改
        throw new UnsupportedException();
    }

    /**
     * 添加查询出来的属性.
     *
     * @param <V> the value type
     * @param aggregateFunction aggregateFunction
     * @param propertyName propertyName
     * @return QueryEntityPropertiesExpression
     */
    default <V> EntityQueryOneFetchedProperty<E, V> property(AggregateFunction aggregateFunction,
        SerializableFunction<E, V> propertyName) {
        return property(aggregateFunction, false, propertyName);
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
    <V> EntityQueryOneFetchedProperty<E, V> property(AggregateFunction aggregateFunction, boolean distinct,
        SerializableFunction<E, V> propertyName);

    /**
     * 设置返回的属性..
     *
     * @param <V> the value type
     * @param propertyName propertyName
     * @return QueryEntityPropertiesExpression
     */
    default <V> EntityQueryOneFetchedProperty<E, V> fetch(SerializableFunction<E, V> propertyName) {
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
    default <V> EntityQueryOneFetchedProperty<E, V> fetch(boolean distinct, SerializableFunction<E, V> propertyName) {
        return property(distinct, propertyName);
    }

    /**
     * 批量设置返回的属性.
     *
     * @param propertyNames propertyNames
     * @return QueryEntityPropertiesExpression
     */
    default EntityQueryFetchedProperties<E> fetch(
        @SuppressWarnings("unchecked") SerializableFunction<E, ?>... propertyNames) {
        return property(propertyNames);
    }

    /**
     * 添加查询出来的属性.
     *
     * @param <V> the value type
     * @param function the function
     * @param propertyName propertyName
     * @return QueryEntityPropertiesExpression
     */
    default <V> EntityQueryOneFetchedProperty<E, V> fetch(Function function, SerializableFunction<E, V> propertyName) {
        return property(function, propertyName);
    }

    /**
     * 添加查询出来的属性.
     *
     * @param <V> the value type
     * @param aggregateFunction aggregateFunction
     * @param propertyName propertyName
     * @return QueryEntityPropertiesExpression
     */
    default <V> EntityQueryOneFetchedProperty<E, V> fetch(AggregateFunction aggregateFunction,
        SerializableFunction<E, V> propertyName) {
        return property(aggregateFunction, propertyName);
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
    default <V> EntityQueryOneFetchedProperty<E, V> fetch(AggregateFunction aggregateFunction, boolean distinct,
        SerializableFunction<E, V> propertyName) {
        return property(aggregateFunction, distinct, propertyName);
    }

    /**
     * Distinct.
     *
     * @param <V> the value type
     * @param propertyName the property name
     * @return the q
     */
    default <V> EntityQueryOneFetchedProperty<E, V> distinct(SerializableFunction<E, V> propertyName) {
        return property(true, propertyName);
    }

    /**
     * Count.
     *
     * @param <V> the value type
     * @param propertyName the property name
     * @return the q
     */
    default <V> EntityQueryOneFetchedProperty<E, V> count(SerializableFunction<E, V> propertyName) {
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
    default <V> EntityQueryOneFetchedProperty<E, V> count(boolean distinct, SerializableFunction<E, V> propertyName) {
        return property(AggregateFunction.COUNT, distinct, propertyName);
    }

    /**
     * Sum.
     *
     * @param <V> the value type
     * @param propertyName the property name
     * @return the q
     */
    default <V> EntityQueryOneFetchedProperty<E, V> sum(SerializableFunction<E, V> propertyName) {
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
    default <V> EntityQueryOneFetchedProperty<E, V> sum(boolean distinct, SerializableFunction<E, V> propertyName) {
        return property(AggregateFunction.SUM, distinct, propertyName);
    }

    /**
     * Max.
     *
     * @param <V> the value type
     * @param propertyName the property name
     * @return the q
     */
    default <V> EntityQueryOneFetchedProperty<E, V> max(SerializableFunction<E, V> propertyName) {
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
    default <V> EntityQueryOneFetchedProperty<E, V> max(boolean distinct, SerializableFunction<E, V> propertyName) {
        return property(AggregateFunction.MAX, distinct, propertyName);
    }

    /**
     * Min.
     *
     * @param <V> the value type
     * @param propertyName the property name
     * @return the q
     */
    default <V> EntityQueryOneFetchedProperty<E, V> min(SerializableFunction<E, V> propertyName) {
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
    default <V> EntityQueryOneFetchedProperty<E, V> min(boolean distinct, SerializableFunction<E, V> propertyName) {
        return property(AggregateFunction.MIN, distinct, propertyName);
    }

    /**
     * Avg.
     *
     * @param <V> the value type
     * @param propertyName the property name
     * @return the q
     */
    default <V> EntityQueryOneFetchedProperty<E, V> avg(SerializableFunction<E, V> propertyName) {
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
    default <V> EntityQueryOneFetchedProperty<E, V> avg(boolean distinct, SerializableFunction<E, V> propertyName) {
        return property(AggregateFunction.AVG, distinct, propertyName);
    }
}
