/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-17 16:04:17
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.query;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import cn.featherfly.common.exception.UnsupportedException;
import cn.featherfly.common.operator.AggregateFunction;
import cn.featherfly.common.operator.Function;
import cn.featherfly.common.repository.AliasField;
import cn.featherfly.common.repository.Field;
import cn.featherfly.common.repository.QueryableField;

/**
 * query fetch field expression.
 *
 * @author zhongj
 * @param <Q>  the generic type
 * @param <Q2> the generic type
 */
public interface QueryFetchFieldExpression<Q, Q2> {

    /**
     * add query fetch field .
     *
     * @param consumer the consumer
     * @return query fetched field expression
     */
    Q fetch(Consumer<FetchField> consumer);

    /**
     * add query fetch field .
     *
     * @param consumer the consumer
     * @return query fetched field expression
     */
    Q2 fetch(BiConsumer<Q2, FetchField> consumer);

    /**
     * add query fetch field array.
     *
     * @param fields the field array
     * @return query fetched field expression
     */
    Q2 fetch(String... fields);

    /**
     * Fields.
     *
     * @param fields the fields
     * @return query fetched field expression
     */
    Q2 fetch(Field... fields);

    /**
     * add query fetch field .
     *
     * @param name name
     * @return query fetched field expression
     */
    default Q fetch(String name) {
        return fetch(false, name);
    }

    /**
     * add query fetch field with alias.
     *
     * @param name  name
     * @param alias the alias
     * @return query fetched field expression
     */
    default Q fetchAlias(String name, String alias) {
        return fetch(false, name, alias);
    }

    /**
     * add query fetch field .
     *
     * @param distinct the distinct
     * @param name     name
     * @return query fetched field expression
     */
    default Q fetch(boolean distinct, String name) {
        return fetch(distinct, name, null);
    }

    /**
     * add query fetch field .
     *
     * @param distinct the distinct
     * @param name     name
     * @param alias    the alias
     * @return query fetched field expression
     */
    Q fetch(boolean distinct, String name, String alias);

    /**
     * add query fetch field .
     *
     * @param function the function
     * @param name     name
     * @return query fetched field expression
     */
    default Q fetch(Function function, String name) {
        return fetch(function, name, null);
    }

    /**
     * add query fetch field .
     *
     * @param function the function
     * @param name     name
     * @param alias    the alias
     * @return query fetched field expression
     */
    default Q fetch(Function function, String name, String alias) {
        if (function instanceof AggregateFunction) {
            return fetch((AggregateFunction) function, name, alias);
        } else {
            // TODO 后续实现了相关Function再来修改
            throw new UnsupportedException();
        }
    }

    /**
     * add query fetch field .
     *
     * @param function the function
     * @param distinct the distinct
     * @param name     name
     * @return query fetched field expression
     */
    default Q fetch(Function function, boolean distinct, String name) {
        if (function instanceof AggregateFunction) {
            return fetch((AggregateFunction) function, distinct, name);
        } else {
            // TODO 后续实现了相关Function再来修改
            throw new UnsupportedException();
        }
    }

    /**
     * add query fetch field .
     *
     * @param function the function
     * @param distinct the distinct
     * @param name     name
     * @param alias    the alias
     * @return query fetched field expression
     */
    default Q fetch(Function function, boolean distinct, String name, String alias) {
        if (function instanceof AggregateFunction) {
            return fetch((AggregateFunction) function, distinct, name, alias);
        } else {
            // TODO 后续实现了相关Function再来修改
            throw new UnsupportedException();
        }
    }

    /**
     * add query fetch field .
     *
     * @param aggregateFunction aggregateFunction
     * @param name              name
     * @return query fetched field expression
     */
    default Q fetch(AggregateFunction aggregateFunction, String name) {
        return fetch(aggregateFunction, name, null);
    }

    /**
     * add query fetch field .
     *
     * @param aggregateFunction aggregateFunction
     * @param name              name
     * @param alias             the alias
     * @return query fetched field expression
     */
    default Q fetch(AggregateFunction aggregateFunction, String name, String alias) {
        return fetch(aggregateFunction, false, name, alias);
    }

    /**
     * add query fetch field .
     *
     * @param aggregateFunction aggregateFunction
     * @param distinct          the distinct
     * @param name              name
     * @return query fetched field expression
     */
    default Q fetch(AggregateFunction aggregateFunction, boolean distinct, String name) {
        return fetch(aggregateFunction, distinct, name, null);
    }

    /**
     * add query fetch field .
     *
     * @param aggregateFunction aggregateFunction
     * @param distinct          the distinct
     * @param name              name
     * @param alias             the alias
     * @return query fetched field expression
     */
    Q fetch(AggregateFunction aggregateFunction, boolean distinct, String name, String alias);

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * add query fetch field .
     *
     * @param field the field
     * @return query fetched field expression
     */
    default Q fetch(Field field) {
        if (field instanceof AliasField) {
            return fetch((AliasField) field);
        } else {
            return fetch(field.name());
        }
    }

    /**
     * add query fetch field .
     *
     * @param field the field
     * @param alias the alias
     * @return query fetched field expression
     */
    default Q fetch(Field field, String alias) {
        return fetchAlias(field.name(), alias);
    }

    /**
     * add query fetch field .
     *
     * @param distinct the distinct
     * @param field    the field
     * @return query fetched field expression
     */
    default Q fetch(boolean distinct, Field field) {
        return fetch(distinct, field.name());
    }

    /**
     * add query fetch field .
     *
     * @param distinct the distinct
     * @param field    the field
     * @param alias    the alias
     * @return query fetched field expression
     */
    default Q fetch(boolean distinct, Field field, String alias) {
        return fetch(distinct, field.name(), alias);
    }

    /**
     * add query fetch field .
     *
     * @param function the function
     * @param field    the field
     * @return query fetched field expression
     */
    default Q fetch(Function function, Field field) {
        return fetch(function, field.name());
    }

    /**
     * add query fetch field .
     *
     * @param function the function
     * @param field    the field
     * @param alias    the alias
     * @return query fetched field expression
     */
    default Q fetch(Function function, Field field, String alias) {
        return fetch(function, field.name(), alias);
    }

    /**
     * add query fetch field .
     *
     * @param function the function
     * @param distinct the distinct
     * @param field    the field
     * @return query fetched field expression
     */
    default Q fetch(Function function, boolean distinct, Field field) {
        return fetch(function, distinct, field.name());
    }

    /**
     * add query fetch field .
     *
     * @param function the function
     * @param distinct the distinct
     * @param field    the field
     * @param alias    the alias
     * @return query fetched field expression
     */
    default Q fetch(Function function, boolean distinct, Field field, String alias) {
        return fetch(function, distinct, field.name(), alias);
    }

    /**
     * add query fetch field .
     *
     * @param aggregateFunction aggregateFunction
     * @param field             the field
     * @return query fetched field expression
     */
    default Q fetch(AggregateFunction aggregateFunction, Field field) {
        return fetch(aggregateFunction, field.name());
    }

    /**
     * add query fetch field .
     *
     * @param aggregateFunction aggregateFunction
     * @param field             the field
     * @param alias             the alias
     * @return query fetched field expression
     */
    default Q fetch(AggregateFunction aggregateFunction, Field field, String alias) {
        return fetch(aggregateFunction, field.name(), alias);
    }

    /**
     * add query fetch field .
     *
     * @param aggregateFunction aggregateFunction
     * @param distinct          the distinct
     * @param field             the field
     * @return query fetched field expression
     */
    default Q fetch(AggregateFunction aggregateFunction, boolean distinct, Field field) {
        return fetch(aggregateFunction, distinct, field.name());
    }

    /**
     * add query fetch field .
     *
     * @param aggregateFunction aggregateFunction
     * @param distinct          the distinct
     * @param field             the field
     * @param alias             the alias
     * @return query fetched field expression
     */
    default Q fetch(AggregateFunction aggregateFunction, boolean distinct, Field field, String alias) {
        return fetch(aggregateFunction, distinct, field.name(), alias);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * add query fetch field .
     *
     * @param field the field
     * @return query fetched field expression
     */
    default Q fetch(AliasField field) {
        return fetchAlias(field.name(), field.alias());
    }

    /**
     * add query fetch field .
     *
     * @param distinct the distinct
     * @param field    the field
     * @return query fetched field expression
     */
    default Q fetch(boolean distinct, AliasField field) {
        return fetch(distinct, field.name(), field.alias());
    }

    /**
     * add query fetch field .
     *
     * @param function the function
     * @param field    the field
     * @return query fetched field expression
     */
    default Q fetch(Function function, AliasField field) {
        return fetch(function, field.name(), field.alias());
    }

    /**
     * add query fetch field .
     *
     * @param function the function
     * @param field    the field
     * @return query fetched field expression
     */
    default Q fetch(Function function, boolean distinct, AliasField field) {
        return fetch(function, distinct, field.name(), field.alias());
    }

    /**
     * add query fetch field .
     *
     * @param aggregateFunction aggregateFunction
     * @param field             the field
     * @return query fetched field expression
     */
    default Q fetch(AggregateFunction aggregateFunction, AliasField field) {
        return fetch(aggregateFunction, field.name(), field.alias());
    }

    /**
     * add query fetch field .
     *
     * @param aggregateFunction aggregateFunction
     * @param distinct          the distinct
     * @param field             the field
     * @return query fetched field expression
     */
    default Q fetch(AggregateFunction aggregateFunction, boolean distinct, AliasField field) {
        return fetch(aggregateFunction, distinct, field.name(), field.alias());
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * add query fetch field .
     *
     * @param field the field
     * @return query fetched field expression
     */
    default Q fetch(QueryableField field) {
        if (field.function() == null) {
            return fetch(field.isDistinct(), field.name(), field.alias());
        } else {
            return fetch(field.function(), field.isDistinct(), field.name(), field.alias());
        }
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * Count.
     *
     * @param name the field name
     * @return the query fetched expression
     */
    default Q count(String name) {
        return count(false, name);
    }

    /**
     * Count.
     *
     * @param name  the field name
     * @param alias the alias
     * @return the query fetched expression
     */
    default Q count(String name, String alias) {
        return count(false, name, alias);
    }

    /**
     * Count.
     *
     * @param distinct the distinct
     * @param name     the field name
     * @return the query fetched expression
     */
    default Q count(boolean distinct, String name) {
        return count(distinct, name, null);
    }

    /**
     * Count.
     *
     * @param distinct the distinct
     * @param name     the field name
     * @param alias    the alias
     * @return the query fetched expression
     */
    default Q count(boolean distinct, String name, String alias) {
        return fetch(AggregateFunction.COUNT, distinct, name, alias);
    }

    /**
     * Sum.
     *
     * @param name the field name
     * @return the query fetched expression
     */
    default Q sum(String name) {
        return sum(false, name);
    }

    /**
     * Sum.
     *
     * @param name  the field name
     * @param alias the alias
     * @return the query fetched expression
     */
    default Q sum(String name, String alias) {
        return sum(false, name, alias);
    }

    /**
     * Sum.
     *
     * @param distinct the distinct
     * @param name     the field name
     * @return the query fetched expression
     */
    default Q sum(boolean distinct, String name) {
        return sum(distinct, name, null);
    }

    /**
     * Sum.
     *
     * @param distinct the distinct
     * @param name     the field name
     * @param alias    the alias
     * @return the query fetched expression
     */
    default Q sum(boolean distinct, String name, String alias) {
        return fetch(AggregateFunction.SUM, distinct, name, alias);
    }

    /**
     * Max.
     *
     * @param name the field name
     * @return the query fetched expression
     */
    default Q max(String name) {
        return max(false, name);
    }

    /**
     * Max.
     *
     * @param name  the field name
     * @param alias the alias
     * @return the query fetched expression
     */
    default Q max(String name, String alias) {
        return max(false, name, alias);
    }

    /**
     * Max.
     *
     * @param distinct the distinct
     * @param name     the field name
     * @return the query fetched expression
     */
    default Q max(boolean distinct, String name) {
        return max(distinct, name, null);
    }

    /**
     * Max.
     *
     * @param distinct the distinct
     * @param name     the field name
     * @param alias    the alias
     * @return the query fetched expression
     */
    default Q max(boolean distinct, String name, String alias) {
        return fetch(AggregateFunction.MAX, distinct, name, alias);
    }

    /**
     * Min.
     *
     * @param name the field name
     * @return the query fetched expression
     */
    default Q min(String name) {
        return min(false, name);
    }

    /**
     * Min.
     *
     * @param name  the field name
     * @param alias the alias
     * @return the query fetched expression
     */
    default Q min(String name, String alias) {
        return min(false, name, alias);
    }

    /**
     * Min.
     *
     * @param distinct the distinct
     * @param name     the field name
     * @return the query fetched expression
     */
    default Q min(boolean distinct, String name) {
        return min(distinct, name, null);
    }

    /**
     * Min.
     *
     * @param distinct the distinct
     * @param name     the field name
     * @param alias    the alias
     * @return the query fetched expression
     */
    default Q min(boolean distinct, String name, String alias) {
        return fetch(AggregateFunction.MIN, distinct, name, alias);
    }

    /**
     * Avg.
     *
     * @param name the field name
     * @return the query fetched expression
     */
    default Q avg(String name) {
        return avg(false, name);
    }

    /**
     * Avg.
     *
     * @param name  the field name
     * @param alias the alias
     * @return the query fetched expression
     */
    default Q avg(String name, String alias) {
        return avg(false, name, alias);
    }

    /**
     * Avg.
     *
     * @param distinct the distinct
     * @param name     the field name
     * @return the query fetched expression
     */
    default Q avg(boolean distinct, String name) {
        return avg(distinct, name, null);
    }

    /**
     * Avg.
     *
     * @param distinct the distinct
     * @param name     the field name
     * @param alias    the alias
     * @return the query fetched expression
     */
    default Q avg(boolean distinct, String name, String alias) {
        return fetch(AggregateFunction.AVG, distinct, name, alias);
    }

    /**
     * Distinct.
     *
     * @param name the field name
     * @return the query fetched expression
     */
    default Q distinct(String name) {
        return fetch(true, name);
    }

    /**
     * Distinct.
     *
     * @param name  the field name
     * @param alias the alias
     * @return the query fetched expression
     */
    default Q distinct(String name, String alias) {
        return fetch(true, name, alias);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * Count.
     *
     * @param field the field
     * @return the query fetched expression
     */
    default Q count(Field field) {
        return count(field.name());
    }

    /**
     * Count.
     *
     * @param field the field
     * @param alias the alias
     * @return the query fetched expression
     */
    default Q count(Field field, String alias) {
        return count(field.name(), alias);
    }

    /**
     * Count.
     *
     * @param distinct the distinct
     * @param field    the field
     * @return the query fetched expression
     */
    default Q count(boolean distinct, Field field) {
        return count(distinct, field.name());
    }

    /**
     * Count.
     *
     * @param distinct the distinct
     * @param field    the field
     * @param alias    the alias
     * @return the query fetched expression
     */
    default Q count(boolean distinct, Field field, String alias) {
        return count(distinct, field.name(), alias);
    }

    /**
     * Sum.
     *
     * @param field the field
     * @return the query fetched expression
     */
    default Q sum(Field field) {
        return sum(field.name());
    }

    /**
     * Sum.
     *
     * @param field the field
     * @param alias the alias
     * @return the query fetched expression
     */
    default Q sum(Field field, String alias) {
        return sum(field.name(), alias);
    }

    /**
     * Sum.
     *
     * @param distinct the distinct
     * @param field    the field
     * @return the query fetched expression
     */
    default Q sum(boolean distinct, Field field) {
        return sum(distinct, field.name());
    }

    /**
     * Sum.
     *
     * @param distinct the distinct
     * @param field    the field
     * @param alias    the alias
     * @return the query fetched expression
     */
    default Q sum(boolean distinct, Field field, String alias) {
        return sum(distinct, field.name(), alias);
    }

    /**
     * Max.
     *
     * @param field the field
     * @return the query fetched expression
     */
    default Q max(Field field) {
        return max(field.name());
    }

    /**
     * Max.
     *
     * @param field the field
     * @param alias the alias
     * @return the query fetched expression
     */
    default Q max(Field field, String alias) {
        return max(field.name(), alias);
    }

    /**
     * Max.
     *
     * @param distinct the distinct
     * @param field    the field
     * @return the query fetched expression
     */
    default Q max(boolean distinct, Field field) {
        return max(distinct, field.name());
    }

    /**
     * Max.
     *
     * @param distinct the distinct
     * @param field    the field
     * @param alias    the alias
     * @return the query fetched expression
     */
    default Q max(boolean distinct, Field field, String alias) {
        return max(distinct, field.name(), alias);
    }

    /**
     * Min.
     *
     * @param field the field
     * @return the query fetched expression
     */
    default Q min(Field field) {
        return min(field.name());
    }

    /**
     * Min.
     *
     * @param field the field
     * @param alias the alias
     * @return the query fetched expression
     */
    default Q min(Field field, String alias) {
        return min(field.name(), alias);
    }

    /**
     * Min.
     *
     * @param distinct the distinct
     * @param field    the field
     * @return the query fetched expression
     */
    default Q min(boolean distinct, Field field) {
        return min(distinct, field.name());
    }

    /**
     * Min.
     *
     * @param distinct the distinct
     * @param field    the field
     * @param alias    the alias
     * @return the query fetched expression
     */
    default Q min(boolean distinct, Field field, String alias) {
        return min(distinct, field.name(), alias);
    }

    /**
     * Avg.
     *
     * @param field the field
     * @return the query fetched expression
     */
    default Q avg(Field field) {
        return avg(field.name());
    }

    /**
     * Avg.
     *
     * @param field the field
     * @param alias the alias
     * @return the query fetched expression
     */
    default Q avg(Field field, String alias) {
        return avg(field.name(), alias);
    }

    /**
     * Avg.
     *
     * @param distinct the distinct
     * @param field    the field
     * @return the query fetched expression
     */
    default Q avg(boolean distinct, Field field) {
        return avg(distinct, field.name());
    }

    /**
     * Avg.
     *
     * @param distinct the distinct
     * @param field    the field
     * @param alias    the alias
     * @return the query fetched expression
     */
    default Q avg(boolean distinct, Field field, String alias) {
        return avg(distinct, field.name(), alias);
    }

    /**
     * Distinct.
     *
     * @param field the field
     * @return the query fetched expression
     */
    default Q distinct(Field field) {
        return distinct(field.name());
    }

    /**
     * Distinct.
     *
     * @param field the field
     * @param alias the alias
     * @return the query fetched expression
     */
    default Q distinct(Field field, String alias) {
        return distinct(field.name(), alias);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * Count.
     *
     * @param field the field
     * @return the query fetched expression
     */
    default Q count(AliasField field) {
        return count(field.name(), field.alias());
    }

    /**
     * Count.
     *
     * @param distinct the distinct
     * @param field    the field
     * @return the query fetched expression
     */
    default Q count(boolean distinct, AliasField field) {
        return count(distinct, field.name(), field.alias());
    }

    /**
     * Sum.
     *
     * @param field the field
     * @return the query fetched expression
     */
    default Q sum(AliasField field) {
        return sum(field.name(), field.alias());
    }

    /**
     * Sum.
     *
     * @param distinct the distinct
     * @param field    the field
     * @return the query fetched expression
     */
    default Q sum(boolean distinct, AliasField field) {
        return sum(distinct, field.name(), field.alias());
    }

    /**
     * Max.
     *
     * @param field the field
     * @return the query fetched expression
     */
    default Q max(AliasField field) {
        return max(field.name(), field.alias());
    }

    /**
     * Max.
     *
     * @param distinct the distinct
     * @param field    the field
     * @return the query fetched expression
     */
    default Q max(boolean distinct, AliasField field) {
        return max(distinct, field.name(), field.alias());
    }

    /**
     * Min.
     *
     * @param field the field
     * @return the query fetched expression
     */
    default Q min(AliasField field) {
        return min(field.name(), field.alias());
    }

    /**
     * Min.
     *
     * @param distinct the distinct
     * @param field    the field
     * @return the query fetched expression
     */
    default Q min(boolean distinct, AliasField field) {
        return min(distinct, field.name(), field.alias());
    }

    /**
     * Avg.
     *
     * @param field the field
     * @return the query fetched expression
     */
    default Q avg(AliasField field) {
        return avg(field.name(), field.alias());
    }

    /**
     * Avg.
     *
     * @param distinct the distinct
     * @param field    the field
     * @return the query fetched expression
     */
    default Q avg(boolean distinct, AliasField field) {
        return avg(distinct, field.name(), field.alias());
    }

    /**
     * Distinct.
     *
     * @param field the field
     * @return the query fetched expression
     */
    default Q distinct(AliasField field) {
        return distinct(field.name(), field.alias());
    }

    // ----------------------------------------------------------------------------------------------------------------
}
