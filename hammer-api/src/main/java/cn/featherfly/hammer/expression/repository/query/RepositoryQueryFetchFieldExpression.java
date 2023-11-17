/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-17 16:04:17
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.repository.query;

import cn.featherfly.common.exception.UnsupportedException;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.operator.AggregateFunction;
import cn.featherfly.common.operator.Function;
import cn.featherfly.hammer.expression.query.QueryFetchFieldExpression;

/**
 * repository query fetch field expression.
 *
 * @author zhongj
 * @param <Q> the generic type
 */
public interface RepositoryQueryFetchFieldExpression<Q> extends QueryFetchFieldExpression<Q> {

    /**
     * add query fetch field .
     *
     * @param <T>  the generic type
     * @param <R>  the generic type
     * @param name name
     * @return QueryEntityPropertiesExpression
     */
    default <T, R> Q field(SerializableFunction<T, R> name) {
        return field(false, name);
    }

    /**
     * add query fetch field .
     *
     * @param <T>   the generic type
     * @param <R>   the generic type
     * @param name  name
     * @param alias the alias
     * @return QueryEntityPropertiesExpression
     */
    default <T, R> Q field(SerializableFunction<T, R> name, String alias) {
        return field(false, name, alias);
    }

    /**
     * add query fetch field .
     *
     * @param <T>      the generic type
     * @param <R>      the generic type
     * @param distinct the distinct
     * @param name     name
     * @return QueryEntityPropertiesExpression
     */
    default <T, R> Q field(boolean distinct, SerializableFunction<T, R> name) {
        return field(false, name, null);
    }

    /**
     * add query fetch field .
     *
     * @param <T>      the generic type
     * @param <R>      the generic type
     * @param distinct the distinct
     * @param name     name
     * @param alias    the alias
     * @return QueryEntityPropertiesExpression
     */
    default <T, R> Q field(boolean distinct, SerializableFunction<T, R> name, String alias) {
        return field(distinct, LambdaUtils.getLambdaPropertyName(name), alias);
    }

    /**
     * add query fetch field .
     *
     * @param <T>      the generic type
     * @param <R>      the generic type
     * @param function the function
     * @param name     name
     * @return QueryEntityPropertiesExpression
     */
    default <T, R> Q field(Function function, SerializableFunction<T, R> name) {
        return field(function, name, null);
    }

    /**
     * add query fetch field .
     *
     * @param <T>      the generic type
     * @param <R>      the generic type
     * @param function the function
     * @param name     name
     * @param alias    the alias
     * @return QueryEntityPropertiesExpression
     */
    default <T, R> Q field(Function function, SerializableFunction<T, R> name, String alias) {
        if (function instanceof AggregateFunction) {
            return field((AggregateFunction) function, name, alias);
        } else {
            // TODO 后续实现了相关Function再来修改
            throw new UnsupportedException();
        }
    }

    /**
     * add query fetch field .
     *
     * @param <T>               the generic type
     * @param <R>               the generic type
     * @param aggregateFunction aggregateFunction
     * @param name              name
     * @return QueryEntityPropertiesExpression
     */
    default <T, R> Q field(AggregateFunction aggregateFunction, SerializableFunction<T, R> name) {
        return field(aggregateFunction, false, name);
    }

    /**
     * add query fetch field .
     *
     * @param <T>               the generic type
     * @param <R>               the generic type
     * @param aggregateFunction aggregateFunction
     * @param name              name
     * @param alias             the alias
     * @return QueryEntityPropertiesExpression
     */
    default <T, R> Q field(AggregateFunction aggregateFunction, SerializableFunction<T, R> name, String alias) {
        return field(aggregateFunction, false, name, alias);
    }

    /**
     * add query fetch field .
     *
     * @param <T>               the generic type
     * @param <R>               the generic type
     * @param aggregateFunction aggregateFunction
     * @param distinct          the distinct
     * @param name              name
     * @return QueryEntityPropertiesExpression
     */
    default <T, R> Q field(AggregateFunction aggregateFunction, boolean distinct, SerializableFunction<T, R> name) {
        return field(aggregateFunction, distinct, name, null);
    }

    /**
     * add query fetch field .
     *
     * @param <T>               the generic type
     * @param <R>               the generic type
     * @param aggregateFunction aggregateFunction
     * @param distinct          the distinct
     * @param name              name
     * @param alias             the alias
     * @return QueryEntityPropertiesExpression
     */
    default <T, R> Q field(AggregateFunction aggregateFunction, boolean distinct, SerializableFunction<T, R> name,
            String alias) {
        return field(aggregateFunction, distinct, LambdaUtils.getLambdaPropertyName(name), alias);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * Count.
     *
     * @param <T>  the generic type
     * @param <R>  the generic type
     * @param name the field name
     * @return the query fetched expression
     */
    default <T, R> Q count(SerializableFunction<T, R> name) {
        return count(false, name);
    }

    /**
     * Count.
     *
     * @param <T>   the generic type
     * @param <R>   the generic type
     * @param name  the field name
     * @param alias the alias
     * @return the query fetched expression
     */
    default <T, R> Q count(SerializableFunction<T, R> name, String alias) {
        return count(false, name, alias);
    }

    /**
     * Count.
     *
     * @param <T>      the generic type
     * @param <R>      the generic type
     * @param distinct the distinct
     * @param name     the field name
     * @return the query fetched expression
     */
    default <T, R> Q count(boolean distinct, SerializableFunction<T, R> name) {
        return count(distinct, name, null);
    }

    /**
     * Count.
     *
     * @param <T>      the generic type
     * @param <R>      the generic type
     * @param distinct the distinct
     * @param name     the field name
     * @param alias    the alias
     * @return the query fetched expression
     */
    default <T, R> Q count(boolean distinct, SerializableFunction<T, R> name, String alias) {
        return field(AggregateFunction.COUNT, distinct, name, alias);
    }

    /**
     * Sum.
     *
     * @param <T>  the generic type
     * @param <R>  the generic type
     * @param name the field name
     * @return the query fetched expression
     */
    default <T, R> Q sum(SerializableFunction<T, R> name) {
        return sum(false, name);
    }

    /**
     * Sum.
     *
     * @param <T>   the generic type
     * @param <R>   the generic type
     * @param name  the field name
     * @param alias the alias
     * @return the query fetched expression
     */
    default <T, R> Q sum(SerializableFunction<T, R> name, String alias) {
        return sum(false, name, alias);
    }

    /**
     * Sum.
     *
     * @param <T>      the generic type
     * @param <R>      the generic type
     * @param distinct the distinct
     * @param name     the field name
     * @return the query fetched expression
     */
    default <T, R> Q sum(boolean distinct, SerializableFunction<T, R> name) {
        return sum(distinct, name, null);
    }

    /**
     * Sum.
     *
     * @param <T>      the generic type
     * @param <R>      the generic type
     * @param distinct the distinct
     * @param name     the field name
     * @param alias    the alias
     * @return the query fetched expression
     */
    default <T, R> Q sum(boolean distinct, SerializableFunction<T, R> name, String alias) {
        return field(AggregateFunction.SUM, distinct, name, alias);
    }

    /**
     * Max.
     *
     * @param <T>  the generic type
     * @param <R>  the generic type
     * @param name the field name
     * @return the query fetched expression
     */
    default <T, R> Q max(SerializableFunction<T, R> name) {
        return max(false, name);
    }

    /**
     * Max.
     *
     * @param <T>   the generic type
     * @param <R>   the generic type
     * @param name  the field name
     * @param alias the alias
     * @return the query fetched expression
     */
    default <T, R> Q max(SerializableFunction<T, R> name, String alias) {
        return max(false, name, alias);
    }

    /**
     * Max.
     *
     * @param <T>      the generic type
     * @param <R>      the generic type
     * @param distinct the distinct
     * @param name     the field name
     * @return the query fetched expression
     */
    default <T, R> Q max(boolean distinct, SerializableFunction<T, R> name) {
        return max(distinct, name, null);
    }

    /**
     * Max.
     *
     * @param <T>      the generic type
     * @param <R>      the generic type
     * @param distinct the distinct
     * @param name     the field name
     * @param alias    the alias
     * @return the query fetched expression
     */
    default <T, R> Q max(boolean distinct, SerializableFunction<T, R> name, String alias) {
        return field(AggregateFunction.MAX, distinct, name, alias);
    }

    /**
     * Min.
     *
     * @param <T>  the generic type
     * @param <R>  the generic type
     * @param name the field name
     * @return the query fetched expression
     */
    default <T, R> Q min(SerializableFunction<T, R> name) {
        return min(false, name);
    }

    /**
     * Min.
     *
     * @param <T>      the generic type
     * @param <R>      the generic type
     * @param distinct the distinct
     * @param name     the field name
     * @return the query fetched expression
     */
    default <T, R> Q min(boolean distinct, SerializableFunction<T, R> name) {
        return field(AggregateFunction.MIN, distinct, name);
    }

    /**
     * Avg.
     *
     * @param <T>  the generic type
     * @param <R>  the generic type
     * @param name the field name
     * @return the query fetched expression
     */
    default <T, R> Q avg(SerializableFunction<T, R> name) {
        return avg(false, name);
    }

    /**
     * Avg.
     *
     * @param <T>   the generic type
     * @param <R>   the generic type
     * @param name  the field name
     * @param alias the alias
     * @return the query fetched expression
     */
    default <T, R> Q avg(SerializableFunction<T, R> name, String alias) {
        return avg(false, name, alias);
    }

    /**
     * Avg.
     *
     * @param <T>      the generic type
     * @param <R>      the generic type
     * @param distinct the distinct
     * @param name     the field name
     * @return the query fetched expression
     */
    default <T, R> Q avg(boolean distinct, SerializableFunction<T, R> name) {
        return avg(distinct, name, null);
    }

    /**
     * Avg.
     *
     * @param <T>      the generic type
     * @param <R>      the generic type
     * @param distinct the distinct
     * @param name     the field name
     * @param alias    the alias
     * @return the query fetched expression
     */
    default <T, R> Q avg(boolean distinct, SerializableFunction<T, R> name, String alias) {
        return field(AggregateFunction.AVG, distinct, name, alias);
    }

    /**
     * Distinct.
     *
     * @param <T>  the generic type
     * @param <R>  the generic type
     * @param name the field name
     * @return the query fetched expression
     */
    default <T, R> Q distinct(SerializableFunction<T, R> name) {
        return distinct(name, null);
    }

    /**
     * Distinct.
     *
     * @param <T>   the generic type
     * @param <R>   the generic type
     * @param name  the field name
     * @param alias the alias
     * @return the query fetched expression
     */
    default <T, R> Q distinct(SerializableFunction<T, R> name, String alias) {
        return field(true, name, alias);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * add query fetch field .
     *
     * @param <T>  the generic type
     * @param <R>  the generic type
     * @param name name
     * @return QueryEntityPropertiesExpression
     */
    default <T, R> Q fetch(SerializableFunction<T, R> name) {
        return field(false, name);
    }

    /**
     * add query fetch field .
     *
     * @param <T>   the generic type
     * @param <R>   the generic type
     * @param name  name
     * @param alias the alias
     * @return QueryEntityPropertiesExpression
     */
    default <T, R> Q fetch(SerializableFunction<T, R> name, String alias) {
        return field(false, name, alias);
    }

    /**
     * add query fetch field .
     *
     * @param <T>      the generic type
     * @param <R>      the generic type
     * @param distinct the distinct
     * @param name     name
     * @return QueryEntityPropertiesExpression
     */
    default <T, R> Q fetch(boolean distinct, SerializableFunction<T, R> name) {
        return field(false, name, null);
    }

    /**
     * add query fetch field .
     *
     * @param <T>      the generic type
     * @param <R>      the generic type
     * @param distinct the distinct
     * @param name     name
     * @param alias    the alias
     * @return QueryEntityPropertiesExpression
     */
    default <T, R> Q fetch(boolean distinct, SerializableFunction<T, R> name, String alias) {
        return field(distinct, LambdaUtils.getLambdaPropertyName(name), alias);
    }

    /**
     * add query fetch field .
     *
     * @param <T>      the generic type
     * @param <R>      the generic type
     * @param function the function
     * @param name     name
     * @return QueryEntityPropertiesExpression
     */
    default <T, R> Q fetch(Function function, SerializableFunction<T, R> name) {
        return field(function, name, null);
    }

    /**
     * add query fetch field .
     *
     * @param <T>      the generic type
     * @param <R>      the generic type
     * @param function the function
     * @param name     name
     * @param alias    the alias
     * @return QueryEntityPropertiesExpression
     */
    default <T, R> Q fetch(Function function, SerializableFunction<T, R> name, String alias) {
        return field(function, name, alias);
    }

    /**
     * add query fetch field .
     *
     * @param <T>               the generic type
     * @param <R>               the generic type
     * @param aggregateFunction aggregateFunction
     * @param name              name
     * @return QueryEntityPropertiesExpression
     */
    default <T, R> Q fetch(AggregateFunction aggregateFunction, SerializableFunction<T, R> name) {
        return field(aggregateFunction, false, name);
    }

    /**
     * add query fetch field .
     *
     * @param <T>               the generic type
     * @param <R>               the generic type
     * @param aggregateFunction aggregateFunction
     * @param name              name
     * @param alias             the alias
     * @return QueryEntityPropertiesExpression
     */
    default <T, R> Q fetch(AggregateFunction aggregateFunction, SerializableFunction<T, R> name, String alias) {
        return field(aggregateFunction, false, name, alias);
    }

    /**
     * add query fetch field .
     *
     * @param <T>               the generic type
     * @param <R>               the generic type
     * @param aggregateFunction aggregateFunction
     * @param distinct          the distinct
     * @param name              name
     * @return QueryEntityPropertiesExpression
     */
    default <T, R> Q fetch(AggregateFunction aggregateFunction, boolean distinct, SerializableFunction<T, R> name) {
        return field(aggregateFunction, distinct, name, null);
    }

    /**
     * add query fetch field .
     *
     * @param <T>               the generic type
     * @param <R>               the generic type
     * @param aggregateFunction aggregateFunction
     * @param distinct          the distinct
     * @param name              name
     * @param alias             the alias
     * @return QueryEntityPropertiesExpression
     */
    default <T, R> Q fetch(AggregateFunction aggregateFunction, boolean distinct, SerializableFunction<T, R> name,
            String alias) {
        return field(aggregateFunction, distinct, LambdaUtils.getLambdaPropertyName(name), alias);
    }

}
