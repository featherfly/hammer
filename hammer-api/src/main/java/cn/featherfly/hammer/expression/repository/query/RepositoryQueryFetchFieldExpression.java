/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-17 16:04:17
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.repository.query;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.operator.AggregateFunction;
import cn.featherfly.common.operator.Function;
import cn.featherfly.common.repository.AliasField;
import cn.featherfly.common.repository.Field;
import cn.featherfly.common.repository.QueryableField;
import cn.featherfly.hammer.expression.query.FetchField;
import cn.featherfly.hammer.expression.query.QueryFetchFieldExpression;

/**
 * repository query fetch field expression.
 *
 * @author zhongj
 * @param <Q>  the generic type
 * @param <Q2> the generic type
 */
public interface RepositoryQueryFetchFieldExpression<Q, Q2> extends QueryFetchFieldExpression<Q, Q2> {

    /**
     * add query fetch field.
     *
     * @param consumer the consumer
     * @return query fetched one field expression
     */
    // TODO 是否重命名为fields,因为和field(SerialFunction)冲突，在调用时需要强制类型转换
    // 例如：.field((Consumer<FetchField>) f -> f.name("password"))
    default Q field(Consumer<FetchField> consumer) {
        return fetch(consumer);
    }

    /**
     * add query fetch fields.
     *
     * @param consumer the consumer
     * @return query fetched muliti fields expression
     */
    default Q2 field(BiConsumer<Q2, FetchField> consumer) {
        return fetch(consumer);
    }

    /**
     * add query fetch fields.
     *
     * @param fields the fields
     * @return query fetched muliti fields expression
     */
    default Q2 fields(String... fields) {
        return fetch(fields);
    }

    /**
     * add query fetch fields.
     *
     * @param fields the fields
     * @return query fetched muliti fields expression
     */
    default Q2 field(Field... fields) {
        return fetch(fields);
    }

    /**
     * add query fetch fields.
     *
     * @param fields the fields
     * @return query fetched muliti fields expression
     */
    default Q2 field(AliasField... fields) {
        return fetch(fields);
    }

    /**
     * add query fetch fields .
     *
     * @param fields the fields
     * @return query fetched muliti fields expression
     */
    default Q2 field(SerializableFunction<?, ?>... fields) {
        return fetch(fields);
    }

    /**
     * add query fetch field .
     *
     * @param name name
     * @return query fetched one field expression
     */
    default Q field(String name) {
        return fetch(false, name);
    }

    /**
     * add query fetch field .
     *
     * @param name  the name
     * @param alias the alias
     * @return query fetched one field expression
     */
    default Q field(String name, String alias) {
        return fetch(false, name, alias);
    }

    /**
     * add query fetch field .
     *
     * @param distinct the distinct
     * @param name     name
     * @return query fetched one field expression
     */
    default Q field(boolean distinct, String name) {
        return fetch(distinct, name, null);
    }

    /**
     * add query fetch field .
     *
     * @param distinct the distinct
     * @param name     name
     * @param alias    the alias
     * @return query fetched one field expression
     */
    default Q field(boolean distinct, String name, String alias) {
        return fetch(distinct, name, alias);
    }

    /**
     * add query fetch field .
     *
     * @param function the function
     * @param name     name
     * @return query fetched one field expression
     */
    default Q field(Function function, String name) {
        return fetch(function, name, null);
    }

    /**
     * add query fetch field .
     *
     * @param function the function
     * @param name     name
     * @param alias    the alias
     * @return query fetched one field expression
     */
    default Q field(Function function, String name, String alias) {
        return fetch(function, name, alias);
    }

    /**
     * add query fetch field .
     *
     * @param function the function
     * @param distinct the distinct
     * @param name     name
     * @param alias    the alias
     * @return query fetched one field expression
     */
    default Q field(Function function, boolean distinct, String name, String alias) {
        return fetch(function, distinct, name, alias);
    }

    /**
     * add query fetch field .
     *
     * @param aggregateFunction aggregateFunction
     * @param name              name
     * @return query fetched one field expression
     */
    default Q field(AggregateFunction aggregateFunction, String name) {
        return fetch(aggregateFunction, false, name);
    }

    /**
     * add query fetch field .
     *
     * @param aggregateFunction aggregateFunction
     * @param name              name
     * @param alias             the alias
     * @return query fetched one field expression
     */
    default Q field(AggregateFunction aggregateFunction, String name, String alias) {
        return fetch(aggregateFunction, false, name, alias);
    }

    /**
     * add query fetch field .
     *
     * @param aggregateFunction aggregateFunction
     * @param distinct          the distinct
     * @param name              name
     * @return query fetched one field expression
     */
    default Q field(AggregateFunction aggregateFunction, boolean distinct, String name) {
        return fetch(aggregateFunction, distinct, name, null);
    }

    /**
     * add query fetch field .
     *
     * @param aggregateFunction aggregateFunction
     * @param distinct          the distinct
     * @param name              name
     * @param alias             the alias
     * @return query fetched one field expression
     */
    default Q field(AggregateFunction aggregateFunction, boolean distinct, String name, String alias) {
        return fetch(aggregateFunction, distinct, name, alias);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * add query fetch field .
     *
     * @param field the field
     * @return query fetched one field expression
     */
    default Q field(QueryableField field) {
        return fetch(field);
    }

    /**
     * add query fetch field .
     *
     * @param field the field
     * @return query fetched one field expression
     */
    default Q field(Field field) {
        return fetch(field.name());
    }

    /**
     * add query fetch field .
     *
     * @param field the field
     * @param alias the alias
     * @return query fetched one field expression
     */
    default Q field(Field field, String alias) {
        return fetchAlias(field.name(), alias);
    }

    /**
     * add query fetch field .
     *
     * @param distinct the distinct
     * @param field    the field
     * @return query fetched one field expression
     */
    default Q field(boolean distinct, Field field) {
        return fetch(distinct, field.name());
    }

    /**
     * add query fetch field .
     *
     * @param distinct the distinct
     * @param field    the field
     * @param alias    the alias
     * @return query fetched one field expression
     */
    default Q field(boolean distinct, Field field, String alias) {
        return fetch(distinct, field.name(), alias);
    }

    /**
     * add query fetch field .
     *
     * @param function the function
     * @param field    the field
     * @return query fetched one field expression
     */
    default Q field(Function function, Field field) {
        return fetch(function, field.name());
    }

    /**
     * add query fetch field .
     *
     * @param function the function
     * @param field    the field
     * @param alias    the alias
     * @return query fetched one field expression
     */
    default Q field(Function function, Field field, String alias) {
        return fetch(function, field.name(), alias);
    }

    /**
     * add query fetch field .
     *
     * @param aggregateFunction aggregateFunction
     * @param field             the field
     * @return query fetched one field expression
     */
    default Q field(AggregateFunction aggregateFunction, Field field) {
        return fetch(aggregateFunction, field.name());
    }

    /**
     * add query fetch field .
     *
     * @param aggregateFunction aggregateFunction
     * @param field             the field
     * @param alias             the alias
     * @return query fetched one field expression
     */
    default Q field(AggregateFunction aggregateFunction, Field field, String alias) {
        return fetch(aggregateFunction, field.name(), alias);
    }

    /**
     * add query fetch field .
     *
     * @param aggregateFunction aggregateFunction
     * @param distinct          the distinct
     * @param field             the field
     * @return query fetched one field expression
     */
    default Q field(AggregateFunction aggregateFunction, boolean distinct, Field field) {
        return fetch(aggregateFunction, distinct, field.name());
    }

    /**
     * add query fetch field .
     *
     * @param aggregateFunction aggregateFunction
     * @param distinct          the distinct
     * @param field             the field
     * @param alias             the alias
     * @return query fetched one field expression
     */
    default Q field(AggregateFunction aggregateFunction, boolean distinct, Field field, String alias) {
        return fetch(aggregateFunction, distinct, field.name(), alias);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * add query fetch field .
     *
     * @param field the field
     * @return query fetched one field expression
     */
    default Q field(AliasField field) {
        return fetchAlias(field.name(), field.alias());
    }

    /**
     * add query fetch field .
     *
     * @param distinct the distinct
     * @param field    the field
     * @return query fetched one field expression
     */
    default Q field(boolean distinct, AliasField field) {
        return fetch(distinct, field.name(), field.alias());
    }

    /**
     * add query fetch field .
     *
     * @param function the function
     * @param field    the field
     * @return query fetched one field expression
     */
    default Q field(Function function, AliasField field) {
        return fetch(function, field.name(), field.alias());
    }

    /**
     * add query fetch field .
     *
     * @param aggregateFunction aggregateFunction
     * @param field             the field
     * @return query fetched one field expression
     */
    default Q field(AggregateFunction aggregateFunction, AliasField field) {
        return fetch(aggregateFunction, field.name(), field.alias());
    }

    /**
     * add query fetch field .
     *
     * @param aggregateFunction aggregateFunction
     * @param distinct          the distinct
     * @param field             the field
     * @return query fetched one field expression
     */
    default Q field(AggregateFunction aggregateFunction, boolean distinct, AliasField field) {
        return fetch(aggregateFunction, distinct, field.name(), field.alias());
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * add query fetch field .
     *
     * @param <T>  the generic type
     * @param <R>  the generic type
     * @param name name
     * @return query fetched one field expression
     */
    default <T, R> Q field(SerializableFunction<T, R> name) {
        return fetch(false, name);
    }

    /**
     * add query fetch field .
     *
     * @param <T>   the generic type
     * @param <R>   the generic type
     * @param name  name
     * @param alias the alias
     * @return query fetched one field expression
     */
    default <T, R> Q field(SerializableFunction<T, R> name, String alias) {
        return fetch(false, name, alias);
    }

    /**
     * add query fetch field .
     *
     * @param <T>      the generic type
     * @param <R>      the generic type
     * @param distinct the distinct
     * @param name     name
     * @return query fetched one field expression
     */
    default <T, R> Q field(boolean distinct, SerializableFunction<T, R> name) {
        return fetch(false, name, null);
    }

    /**
     * add query fetch field .
     *
     * @param <T>      the generic type
     * @param <R>      the generic type
     * @param distinct the distinct
     * @param name     name
     * @param alias    the alias
     * @return query fetched one field expression
     */
    default <T, R> Q field(boolean distinct, SerializableFunction<T, R> name, String alias) {
        return fetch(distinct, LambdaUtils.getLambdaPropertyName(name), alias);
    }

    /**
     * add query fetch field .
     *
     * @param <T>      the generic type
     * @param <R>      the generic type
     * @param function the function
     * @param name     name
     * @return query fetched one field expression
     */
    default <T, R> Q field(Function function, SerializableFunction<T, R> name) {
        return fetch(function, name, null);
    }

    /**
     * add query fetch field .
     *
     * @param <T>      the generic type
     * @param <R>      the generic type
     * @param function the function
     * @param name     name
     * @param alias    the alias
     * @return query fetched one field expression
     */
    default <T, R> Q field(Function function, SerializableFunction<T, R> name, String alias) {
        return fetch(function, LambdaUtils.getLambdaPropertyName(name), alias);
    }

    /**
     * add query fetch field .
     *
     * @param <T>               the generic type
     * @param <R>               the generic type
     * @param aggregateFunction aggregateFunction
     * @param name              name
     * @return query fetched one field expression
     */
    default <T, R> Q field(AggregateFunction aggregateFunction, SerializableFunction<T, R> name) {
        return fetch(aggregateFunction, false, name);
    }

    /**
     * add query fetch field .
     *
     * @param <T>               the generic type
     * @param <R>               the generic type
     * @param aggregateFunction aggregateFunction
     * @param name              name
     * @param alias             the alias
     * @return query fetched one field expression
     */
    default <T, R> Q field(AggregateFunction aggregateFunction, SerializableFunction<T, R> name, String alias) {
        return fetch(aggregateFunction, false, name, alias);
    }

    /**
     * add query fetch field .
     *
     * @param <T>               the generic type
     * @param <R>               the generic type
     * @param aggregateFunction aggregateFunction
     * @param distinct          the distinct
     * @param name              name
     * @return query fetched one field expression
     */
    default <T, R> Q field(AggregateFunction aggregateFunction, boolean distinct, SerializableFunction<T, R> name) {
        return fetch(aggregateFunction, distinct, name, null);
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
     * @return query fetched one field expression
     */
    default <T, R> Q field(AggregateFunction aggregateFunction, boolean distinct, SerializableFunction<T, R> name,
            String alias) {
        return fetch(aggregateFunction, distinct, LambdaUtils.getLambdaPropertyName(name), alias);
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
        return fetch(AggregateFunction.COUNT, distinct, name, alias);
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
        return fetch(AggregateFunction.SUM, distinct, name, alias);
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
        return fetch(AggregateFunction.MAX, distinct, name, alias);
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
        return fetch(AggregateFunction.MIN, distinct, name);
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
        return fetch(AggregateFunction.AVG, distinct, name, alias);
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
        return fetch(true, name, alias);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * add query fetch field .
     *
     * @param fields the fields
     * @return query fetched muliti fields expression
     */
    Q2 fetch(SerializableFunction<?, ?>... fields);

    /**
     * add query fetch field .
     *
     * @param <T>  the generic type
     * @param <R>  the generic type
     * @param name name
     * @return query fetched one field expression
     */
    default <T, R> Q fetch(SerializableFunction<T, R> name) {
        return fetch(false, name);
    }

    /**
     * add query fetch field .
     *
     * @param <T>   the generic type
     * @param <R>   the generic type
     * @param name  name
     * @param alias the alias
     * @return query fetched one field expression
     */
    default <T, R> Q fetch(SerializableFunction<T, R> name, String alias) {
        return fetch(false, name, alias);
    }

    /**
     * add query fetch field .
     *
     * @param <T>      the generic type
     * @param <R>      the generic type
     * @param distinct the distinct
     * @param name     name
     * @return query fetched one field expression
     */
    default <T, R> Q fetch(boolean distinct, SerializableFunction<T, R> name) {
        return fetch(false, name, null);
    }

    /**
     * add query fetch field .
     *
     * @param <T>      the generic type
     * @param <R>      the generic type
     * @param distinct the distinct
     * @param name     name
     * @param alias    the alias
     * @return query fetched one field expression
     */
    default <T, R> Q fetch(boolean distinct, SerializableFunction<T, R> name, String alias) {
        return fetch(distinct, LambdaUtils.getLambdaPropertyName(name), alias);
    }

    /**
     * add query fetch field .
     *
     * @param <T>      the generic type
     * @param <R>      the generic type
     * @param function the function
     * @param name     name
     * @return query fetched one field expression
     */
    default <T, R> Q fetch(Function function, SerializableFunction<T, R> name) {
        return fetch(function, name, null);
    }

    /**
     * add query fetch field .
     *
     * @param <T>      the generic type
     * @param <R>      the generic type
     * @param function the function
     * @param name     name
     * @param alias    the alias
     * @return query fetched one field expression
     */
    default <T, R> Q fetch(Function function, SerializableFunction<T, R> name, String alias) {
        return fetch(function, LambdaUtils.getLambdaPropertyName(name), alias);
    }

    /**
     * add query fetch field .
     *
     * @param <T>               the generic type
     * @param <R>               the generic type
     * @param aggregateFunction aggregateFunction
     * @param name              name
     * @return query fetched one field expression
     */
    default <T, R> Q fetch(AggregateFunction aggregateFunction, SerializableFunction<T, R> name) {
        return fetch(aggregateFunction, false, name);
    }

    /**
     * add query fetch field .
     *
     * @param <T>               the generic type
     * @param <R>               the generic type
     * @param aggregateFunction aggregateFunction
     * @param name              name
     * @param alias             the alias
     * @return query fetched one field expression
     */
    default <T, R> Q fetch(AggregateFunction aggregateFunction, SerializableFunction<T, R> name, String alias) {
        return fetch(aggregateFunction, false, name, alias);
    }

    /**
     * add query fetch field .
     *
     * @param <T>               the generic type
     * @param <R>               the generic type
     * @param aggregateFunction aggregateFunction
     * @param distinct          the distinct
     * @param name              name
     * @return query fetched one field expression
     */
    default <T, R> Q fetch(AggregateFunction aggregateFunction, boolean distinct, SerializableFunction<T, R> name) {
        return fetch(aggregateFunction, distinct, name, null);
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
     * @return query fetched one field expression
     */
    default <T, R> Q fetch(AggregateFunction aggregateFunction, boolean distinct, SerializableFunction<T, R> name,
            String alias) {
        return fetch(aggregateFunction, distinct, LambdaUtils.getLambdaPropertyName(name), alias);
    }

}
