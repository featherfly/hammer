
package cn.featherfly.hammer.expression.query;

import cn.featherfly.common.lang.function.SerializableFunction;

/**
 * dsl for query count number executor.
 *
 * @author zhongj
 */
// IMPLSOON 这个接口暂时还没有使用，没有引入DSL体系
public interface QueryAggregateExecutor<Q extends QueryValueExecutor> extends QueryCountExecutor {

    /**
     * Count.
     *
     * @param propertyName the property name
     * @return the q
     */
    default Q count(String propertyName) {
        return count(false, propertyName);
    }

    /**
     * Count.
     *
     * @param distinct     the distinct
     * @param propertyName the property name
     * @return the q
     */
    Q count(boolean distinct, String propertyName);

    /**
     * Count.
     *
     * @param <T>          the generic type
     * @param <R>          the generic type
     * @param propertyName the property name
     * @return the q
     */
    default <T, R> long count(SerializableFunction<T, R> propertyName) {
        return count(false, propertyName);
    }

    /**
     * Count.
     *
     * @param <T>          the generic type
     * @param <R>          the generic type
     * @param distinct     the distinct
     * @param propertyName the property name
     * @return the q
     */
    <T, R> long count(boolean distinct, SerializableFunction<T, R> propertyName);

    /**
     * Sum.
     *
     * @param propertyName the property name
     * @return the q
     */
    default Q sum(String propertyName) {
        return sum(false, propertyName);
    }

    /**
     * Sum.
     *
     * @param distinct     the distinct
     * @param propertyName the property name
     * @return the q
     */
    Q sum(boolean distinct, String propertyName);

    /**
     * Sum.
     *
     * @param <T>          the generic type
     * @param <R>          the generic type
     * @param propertyName the property name
     * @return the q
     */
    default <T, R> Q sum(SerializableFunction<T, R> propertyName) {
        return sum(false, propertyName);
    }

    /**
     * Sum.
     *
     * @param <T>          the generic type
     * @param <R>          the generic type
     * @param distinct     the distinct
     * @param propertyName the property name
     * @return the q
     */
    <T, R> Q sum(boolean distinct, SerializableFunction<T, R> propertyName);

    /**
     * Max.
     *
     * @param propertyName the property name
     * @return the q
     */
    default Q max(String propertyName) {
        return max(false, propertyName);
    }

    /**
     * Max.
     *
     * @param distinct     the distinct
     * @param propertyName the property name
     * @return the q
     */
    Q max(boolean distinct, String propertyName);

    /**
     * Max.
     *
     * @param <T>          the generic type
     * @param <R>          the generic type
     * @param propertyName the property name
     * @return the q
     */
    default <T, R> Q max(SerializableFunction<T, R> propertyName) {
        return max(false, propertyName);
    }

    /**
     * Max.
     *
     * @param <T>          the generic type
     * @param <R>          the generic type
     * @param distinct     the distinct
     * @param propertyName the property name
     * @return the q
     */
    <T, R> Q max(boolean distinct, SerializableFunction<T, R> propertyName);

    /**
     * Min.
     *
     * @param propertyName the property name
     * @return the q
     */
    default Q min(String propertyName) {
        return min(false, propertyName);
    }

    /**
     * Min.
     *
     * @param distinct     the distinct
     * @param propertyName the property name
     * @return the q
     */
    Q min(boolean distinct, String propertyName);

    /**
     * Min.
     *
     * @param <T>          the generic type
     * @param <R>          the generic type
     * @param propertyName the property name
     * @return the q
     */
    default <T, R> Q min(SerializableFunction<T, R> propertyName) {
        return min(false, propertyName);
    }

    /**
     * Min.
     *
     * @param <T>          the generic type
     * @param <R>          the generic type
     * @param distinct     the distinct
     * @param propertyName the property name
     * @return the q
     */
    <T, R> Q min(boolean distinct, SerializableFunction<T, R> propertyName);

    /**
     * Avg.
     *
     * @param propertyName the property name
     * @return the q
     */
    default Q avg(String propertyName) {
        return avg(false, propertyName);
    }

    /**
     * Avg.
     *
     * @param distinct     the distinct
     * @param propertyName the property name
     * @return the q
     */
    Q avg(boolean distinct, String propertyName);

    /**
     * Avg.
     *
     * @param <T>          the generic type
     * @param <R>          the generic type
     * @param propertyName the property name
     * @return the q
     */
    default <T, R> Q avg(SerializableFunction<T, R> propertyName) {
        return avg(false, propertyName);
    }

    /**
     * Avg.
     *
     * @param <T>          the generic type
     * @param <R>          the generic type
     * @param distinct     the distinct
     * @param propertyName the property name
     * @return the q
     */
    <T, R> Q avg(boolean distinct, SerializableFunction<T, R> propertyName);
}
