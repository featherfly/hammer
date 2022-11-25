
package cn.featherfly.hammer.expression.query.type;

import cn.featherfly.common.lang.function.SerializableFunction;

/**
 * The Interface EntityQueryPropertiesExpression.
 *
 * @author zhongj
 * @param <E> the query type
 * @param <Q> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityQueryPropertiesExpression<E, Q extends EntityQueryPropertiesExpression<E, Q>> {

    /**
     * 添加select的列 .
     *
     * @param <R>          the generic type
     * @param propertyName propertyName
     * @return QueryEntityPropertiesExpression
     */
    default <R> Q property(SerializableFunction<E, R> propertyName) {
        return property(false, propertyName);
    }

    /**
     * 添加select的列 .
     *
     * @param <R>          the generic type
     * @param distinct     the distinct
     * @param propertyName propertyName
     * @return QueryEntityPropertiesExpression
     */
    <R> Q property(boolean distinct, SerializableFunction<E, R> propertyName);

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
     * 批量添加select的列 .
     *
     * @param <R>           the generic type
     * @param propertyNames propertyNames
     * @return QueryEntityPropertiesExpression
     */
    Q property(@SuppressWarnings("unchecked") SerializableFunction<E, ?>... propertyNames);

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
    <R> Q count(boolean distinct, SerializableFunction<E, R> propertyName);

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
    <R> Q sum(boolean distinct, SerializableFunction<E, R> propertyName);

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
    <R> Q max(boolean distinct, SerializableFunction<E, R> propertyName);

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
    <R> Q min(boolean distinct, SerializableFunction<E, R> propertyName);

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
    <R> Q avg(boolean distinct, SerializableFunction<E, R> propertyName);
}
