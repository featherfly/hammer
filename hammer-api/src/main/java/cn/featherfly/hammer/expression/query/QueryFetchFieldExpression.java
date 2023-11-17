/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-17 16:04:17
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.query;

import cn.featherfly.common.exception.UnsupportedException;
import cn.featherfly.common.operator.AggregateFunction;
import cn.featherfly.common.operator.Function;
import cn.featherfly.common.repository.AliasField;
import cn.featherfly.common.repository.Field;

/**
 * query fetch field expression.
 *
 * @author zhongj
 * @param <Q> the generic type
 */
public interface QueryFetchFieldExpression<Q> {

    //    /**
    //     * Field.
    //     *
    //     * @param consumer the consumer
    //     * @return the q
    //     */ TODO 先实现了功能再来加入这个
    //    Q field(Consumer<FetchField> consumer);

    /**
     * add query fetch field .
     *
     * @param name name
     * @return query fetched field expression
     */
    default Q field(String name) {
        return field(false, name);
    }

    /**
     * add query fetch field .
     *
     * @param name  the name
     * @param alias the alias
     * @return query fetched field expression
     */
    default Q field(String name, String alias) {
        return field(false, name, alias);
    }

    /**
     * add query fetch field .
     *
     * @param distinct the distinct
     * @param name     name
     * @return query fetched field expression
     */
    default Q field(boolean distinct, String name) {
        return field(distinct, name, null);
    }

    /**
     * add query fetch field .
     *
     * @param distinct the distinct
     * @param name     name
     * @param alias    the alias
     * @return query fetched field expression
     */
    Q field(boolean distinct, String name, String alias);

    /**
     * add query fetch field .
     *
     * @param function the function
     * @param name     name
     * @return query fetched field expression
     */
    default Q field(Function function, String name) {
        return field(function, name, null);
    }

    /**
     * add query fetch field .
     *
     * @param function the function
     * @param name     name
     * @param alias    the alias
     * @return query fetched field expression
     */
    default Q field(Function function, String name, String alias) {
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
     * @param aggregateFunction aggregateFunction
     * @param name              name
     * @return query fetched field expression
     */
    default Q field(AggregateFunction aggregateFunction, String name) {
        return field(aggregateFunction, false, name);
    }

    /**
     * add query fetch field .
     *
     * @param aggregateFunction aggregateFunction
     * @param name              name
     * @param alias             the alias
     * @return query fetched field expression
     */
    default Q field(AggregateFunction aggregateFunction, String name, String alias) {
        return field(aggregateFunction, false, name, alias);
    }

    /**
     * add query fetch field .
     *
     * @param aggregateFunction aggregateFunction
     * @param distinct          the distinct
     * @param name              name
     * @return query fetched field expression
     */
    default Q field(AggregateFunction aggregateFunction, boolean distinct, String name) {
        return field(aggregateFunction, distinct, name, null);
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
    Q field(AggregateFunction aggregateFunction, boolean distinct, String name, String alias);

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * add query fetch field .
     *
     * @param field the field
     * @return query fetched field expression
     */
    default Q field(Field field) {
        return field(field.name());
    }

    /**
     * add query fetch field .
     *
     * @param field the field
     * @param alias the alias
     * @return query fetched field expression
     */
    default Q field(Field field, String alias) {
        return field(field.name(), alias);
    }

    /**
     * add query fetch field .
     *
     * @param distinct the distinct
     * @param field    the field
     * @return query fetched field expression
     */
    default Q field(boolean distinct, Field field) {
        return field(distinct, field.name());
    }

    /**
     * add query fetch field .
     *
     * @param distinct the distinct
     * @param field    the field
     * @param alias    the alias
     * @return query fetched field expression
     */
    default Q field(boolean distinct, Field field, String alias) {
        return field(distinct, field.name(), alias);
    }

    /**
     * add query fetch field .
     *
     * @param function the function
     * @param field    the field
     * @return query fetched field expression
     */
    default Q field(Function function, Field field) {
        return field(function, field.name());
    }

    /**
     * add query fetch field .
     *
     * @param function the function
     * @param field    the field
     * @param alias    the alias
     * @return query fetched field expression
     */
    default Q field(Function function, Field field, String alias) {
        return field(function, field.name(), alias);
    }

    /**
     * add query fetch field .
     *
     * @param aggregateFunction aggregateFunction
     * @param field             the field
     * @return query fetched field expression
     */
    default Q field(AggregateFunction aggregateFunction, Field field) {
        return field(aggregateFunction, field.name());
    }

    /**
     * add query fetch field .
     *
     * @param aggregateFunction aggregateFunction
     * @param field             the field
     * @param alias             the alias
     * @return query fetched field expression
     */
    default Q field(AggregateFunction aggregateFunction, Field field, String alias) {
        return field(aggregateFunction, field.name(), alias);
    }

    /**
     * add query fetch field .
     *
     * @param aggregateFunction aggregateFunction
     * @param distinct          the distinct
     * @param field             the field
     * @return query fetched field expression
     */
    default Q field(AggregateFunction aggregateFunction, boolean distinct, Field field) {
        return field(aggregateFunction, distinct, field.name());
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
    default Q field(AggregateFunction aggregateFunction, boolean distinct, Field field, String alias) {
        return field(aggregateFunction, distinct, field.name(), alias);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * add query fetch field .
     *
     * @param field the field
     * @return query fetched field expression
     */
    default Q field(AliasField field) {
        return field(field.getAliasOrName());
    }

    /**
     * add query fetch field .
     *
     * @param field the field
     * @param alias the alias
     * @return query fetched field expression
     */
    default Q field(AliasField field, String alias) {
        return field(field.getAliasOrName(), alias);
    }

    /**
     * add query fetch field .
     *
     * @param distinct the distinct
     * @param field    the field
     * @return query fetched field expression
     */
    default Q field(boolean distinct, AliasField field) {
        return field(distinct, field.getAliasOrName());
    }

    /**
     * add query fetch field .
     *
     * @param distinct the distinct
     * @param field    the field
     * @param alias    the alias
     * @return query fetched field expression
     */
    default Q field(boolean distinct, AliasField field, String alias) {
        return field(distinct, field.getAliasOrName(), alias);
    }

    /**
     * add query fetch field .
     *
     * @param function the function
     * @param field    the field
     * @return query fetched field expression
     */
    default Q field(Function function, AliasField field) {
        return field(function, field.getAliasOrName());
    }

    /**
     * add query fetch field .
     *
     * @param function the function
     * @param field    the field
     * @param alias    the alias
     * @return query fetched field expression
     */
    default Q field(Function function, AliasField field, String alias) {
        return field(function, field.getAliasOrName(), alias);
    }

    /**
     * add query fetch field .
     *
     * @param aggregateFunction aggregateFunction
     * @param field             the field
     * @return query fetched field expression
     */
    default Q field(AggregateFunction aggregateFunction, AliasField field) {
        return field(aggregateFunction, field.getAliasOrName());
    }

    /**
     * add query fetch field .
     *
     * @param aggregateFunction aggregateFunction
     * @param field             the field
     * @param alias             the alias
     * @return query fetched field expression
     */
    default Q field(AggregateFunction aggregateFunction, AliasField field, String alias) {
        return field(aggregateFunction, field.getAliasOrName(), alias);
    }

    /**
     * add query fetch field .
     *
     * @param aggregateFunction aggregateFunction
     * @param distinct          the distinct
     * @param field             the field
     * @return query fetched field expression
     */
    default Q field(AggregateFunction aggregateFunction, boolean distinct, AliasField field) {
        return field(aggregateFunction, distinct, field.getAliasOrName());
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
    default Q field(AggregateFunction aggregateFunction, boolean distinct, AliasField field, String alias) {
        return field(aggregateFunction, distinct, field.getAliasOrName(), alias);
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
        return field(AggregateFunction.COUNT, distinct, name, alias);
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
        return field(AggregateFunction.SUM, distinct, name, alias);
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
        return field(AggregateFunction.MAX, distinct, name, alias);
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
        return field(AggregateFunction.MIN, distinct, name, alias);
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
        return field(AggregateFunction.AVG, distinct, name, alias);
    }

    /**
     * Distinct.
     *
     * @param name the field name
     * @return the query fetched expression
     */
    default Q distinct(String name) {
        return field(true, name);
    }

    /**
     * Distinct.
     *
     * @param name  the field name
     * @param alias the alias
     * @return the query fetched expression
     */
    default Q distinct(String name, String alias) {
        return field(true, name, alias);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * Count.
     *
     * @param name the field name
     * @return the query fetched expression
     */
    default Q count(Field field) {
        return count(field.name());
    }

    /**
     * Count.
     *
     * @param name  the field name
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
     * @param name     the field name
     * @return the query fetched expression
     */
    default Q count(boolean distinct, Field field) {
        return count(distinct, field.name());
    }

    /**
     * Count.
     *
     * @param distinct the distinct
     * @param name     the field name
     * @param alias    the alias
     * @return the query fetched expression
     */
    default Q count(boolean distinct, Field field, String alias) {
        return count(distinct, field.name(), alias);
    }

    /**
     * Sum.
     *
     * @param name the field name
     * @return the query fetched expression
     */
    default Q sum(Field field) {
        return sum(field.name());
    }

    /**
     * Sum.
     *
     * @param name  the field name
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
     * @param name     the field name
     * @return the query fetched expression
     */
    default Q sum(boolean distinct, Field field) {
        return sum(distinct, field.name());
    }

    /**
     * Sum.
     *
     * @param distinct the distinct
     * @param name     the field name
     * @param alias    the alias
     * @return the query fetched expression
     */
    default Q sum(boolean distinct, Field field, String alias) {
        return sum(distinct, field.name(), alias);
    }

    /**
     * Max.
     *
     * @param name the field name
     * @return the query fetched expression
     */
    default Q max(Field field) {
        return max(field.name());
    }

    /**
     * Max.
     *
     * @param name  the field name
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
     * @param name     the field name
     * @return the query fetched expression
     */
    default Q max(boolean distinct, Field field) {
        return max(distinct, field.name());
    }

    /**
     * Max.
     *
     * @param distinct the distinct
     * @param name     the field name
     * @param alias    the alias
     * @return the query fetched expression
     */
    default Q max(boolean distinct, Field field, String alias) {
        return max(distinct, field.name(), alias);
    }

    /**
     * Min.
     *
     * @param name the field name
     * @return the query fetched expression
     */
    default Q min(Field field) {
        return min(field.name());
    }

    /**
     * Min.
     *
     * @param name  the field name
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
     * @param name     the field name
     * @return the query fetched expression
     */
    default Q min(boolean distinct, Field field) {
        return min(distinct, field.name());
    }

    /**
     * Min.
     *
     * @param distinct the distinct
     * @param name     the field name
     * @param alias    the alias
     * @return the query fetched expression
     */
    default Q min(boolean distinct, Field field, String alias) {
        return min(distinct, field.name(), alias);
    }

    /**
     * Avg.
     *
     * @param name the field name
     * @return the query fetched expression
     */
    default Q avg(Field field) {
        return avg(field.name());
    }

    /**
     * Avg.
     *
     * @param name  the field name
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
     * @param name     the field name
     * @return the query fetched expression
     */
    default Q avg(boolean distinct, Field field) {
        return avg(distinct, field.name());
    }

    /**
     * Avg.
     *
     * @param distinct the distinct
     * @param name     the field name
     * @param alias    the alias
     * @return the query fetched expression
     */
    default Q avg(boolean distinct, Field field, String alias) {
        return avg(distinct, field.name(), alias);
    }

    /**
     * Distinct.
     *
     * @param name the field name
     * @return the query fetched expression
     */
    default Q distinct(Field field) {
        return field(field.name());
    }

    /**
     * Distinct.
     *
     * @param name  the field name
     * @param alias the alias
     * @return the query fetched expression
     */
    default Q distinct(Field field, String alias) {
        return field(field.name(), alias);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * Count.
     *
     * @param field the field
     * @return the query fetched expression
     */
    default Q count(AliasField field) {
        return count(field.getAliasOrName());
    }

    /**
     * Count.
     *
     * @param name  the field name
     * @param alias the alias
     * @return the query fetched expression
     */
    default Q count(AliasField field, String alias) {
        return count(field.getAliasOrName(), alias);
    }

    /**
     * Count.
     *
     * @param distinct the distinct
     * @param name     the field name
     * @return the query fetched expression
     */
    default Q count(boolean distinct, AliasField field) {
        return count(distinct, field.getAliasOrName());
    }

    /**
     * Count.
     *
     * @param distinct the distinct
     * @param name     the field name
     * @param alias    the alias
     * @return the query fetched expression
     */
    default Q count(boolean distinct, AliasField field, String alias) {
        return count(distinct, field.getAliasOrName(), alias);
    }

    /**
     * Sum.
     *
     * @param name the field name
     * @return the query fetched expression
     */
    default Q sum(AliasField field) {
        return sum(field.getAliasOrName());
    }

    /**
     * Sum.
     *
     * @param name  the field name
     * @param alias the alias
     * @return the query fetched expression
     */
    default Q sum(AliasField field, String alias) {
        return sum(field.getAliasOrName(), alias);
    }

    /**
     * Sum.
     *
     * @param distinct the distinct
     * @param name     the field name
     * @return the query fetched expression
     */
    default Q sum(boolean distinct, AliasField field) {
        return sum(distinct, field.getAliasOrName());
    }

    /**
     * Sum.
     *
     * @param distinct the distinct
     * @param name     the field name
     * @param alias    the alias
     * @return the query fetched expression
     */
    default Q sum(boolean distinct, AliasField field, String alias) {
        return sum(distinct, field.getAliasOrName(), alias);
    }

    /**
     * Max.
     *
     * @param name the field name
     * @return the query fetched expression
     */
    default Q max(AliasField field) {
        return max(field.getAliasOrName());
    }

    /**
     * Max.
     *
     * @param name  the field name
     * @param alias the alias
     * @return the query fetched expression
     */
    default Q max(AliasField field, String alias) {
        return max(field.getAliasOrName(), alias);
    }

    /**
     * Max.
     *
     * @param distinct the distinct
     * @param name     the field name
     * @return the query fetched expression
     */
    default Q max(boolean distinct, AliasField field) {
        return max(distinct, field.getAliasOrName());
    }

    /**
     * Max.
     *
     * @param distinct the distinct
     * @param name     the field name
     * @param alias    the alias
     * @return the query fetched expression
     */
    default Q max(boolean distinct, AliasField field, String alias) {
        return max(distinct, field.getAliasOrName(), alias);
    }

    /**
     * Min.
     *
     * @param name the field name
     * @return the query fetched expression
     */
    default Q min(AliasField field) {
        return min(field.getAliasOrName());
    }

    /**
     * Min.
     *
     * @param name  the field name
     * @param alias the alias
     * @return the query fetched expression
     */
    default Q min(AliasField field, String alias) {
        return min(field.getAliasOrName(), alias);
    }

    /**
     * Min.
     *
     * @param distinct the distinct
     * @param name     the field name
     * @return the query fetched expression
     */
    default Q min(boolean distinct, AliasField field) {
        return min(distinct, field.getAliasOrName());
    }

    /**
     * Min.
     *
     * @param distinct the distinct
     * @param name     the field name
     * @param alias    the alias
     * @return the query fetched expression
     */
    default Q min(boolean distinct, AliasField field, String alias) {
        return min(distinct, field.getAliasOrName(), alias);
    }

    /**
     * Avg.
     *
     * @param name the field name
     * @return the query fetched expression
     */
    default Q avg(AliasField field) {
        return avg(field.getAliasOrName());
    }

    /**
     * Avg.
     *
     * @param name  the field name
     * @param alias the alias
     * @return the query fetched expression
     */
    default Q avg(AliasField field, String alias) {
        return avg(field.getAliasOrName(), alias);
    }

    /**
     * Avg.
     *
     * @param distinct the distinct
     * @param name     the field name
     * @return the query fetched expression
     */
    default Q avg(boolean distinct, AliasField field) {
        return avg(distinct, field.getAliasOrName());
    }

    /**
     * Avg.
     *
     * @param distinct the distinct
     * @param name     the field name
     * @param alias    the alias
     * @return the query fetched expression
     */
    default Q avg(boolean distinct, AliasField field, String alias) {
        return avg(distinct, field.getAliasOrName(), alias);
    }

    /**
     * Distinct.
     *
     * @param name the field name
     * @return the query fetched expression
     */
    default Q distinct(AliasField field) {
        return field(field.getAliasOrName());
    }

    /**
     * Distinct.
     *
     * @param name  the field name
     * @param alias the alias
     * @return the query fetched expression
     */
    default Q distinct(AliasField field, String alias) {
        return field(field.getAliasOrName(), alias);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * add query fetch field .
     *
     * @param name name
     * @return query fetched field expression
     */
    default Q fetch(String name) {
        return field(name);
    }

    /**
     * add query fetch field .
     *
     * @param name  name
     * @param alias the alias
     * @return query fetched field expression
     */
    default Q fetch(String name, String alias) {
        return field(name, alias);
    }

    /**
     * add query fetch field .
     *
     * @param distinct the distinct
     * @param name     name
     * @return query fetched field expression
     */
    default Q fetch(boolean distinct, String name) {
        return field(distinct, name);
    }

    /**
     * add query fetch field .
     *
     * @param distinct the distinct
     * @param name     name
     * @param alias    the alias
     * @return query fetched field expression
     */
    default Q fetch(boolean distinct, String name, String alias) {
        return field(distinct, name, alias);
    }

    /**
     * add query fetch field .
     *
     * @param function the function
     * @param name     name
     * @return query fetched field expression
     */
    default Q fetch(Function function, String name) {
        return field(function, name);
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
        return field(function, name, alias);
    }

    /**
     * add query fetch field .
     *
     * @param aggregateFunction aggregateFunction
     * @param name              name
     * @return query fetched field expression
     */
    default Q fetch(AggregateFunction aggregateFunction, String name) {
        return field(aggregateFunction, name);
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
        return field(aggregateFunction, name, alias);
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
        return field(aggregateFunction, distinct, name);
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
    default Q fetch(AggregateFunction aggregateFunction, boolean distinct, String name, String alias) {
        return field(aggregateFunction, distinct, name, alias);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * add query fetch field .
     *
     * @param field the field
     * @return query fetched field expression
     */
    default Q fetch(Field field) {
        return field(field.name());
    }

    /**
     * add query fetch field .
     *
     * @param field the field
     * @param alias the alias
     * @return query fetched field expression
     */
    default Q fetch(Field field, String alias) {
        return field(field.name(), alias);
    }

    /**
     * add query fetch field .
     *
     * @param distinct the distinct
     * @param field    the field
     * @return query fetched field expression
     */
    default Q fetch(boolean distinct, Field field) {
        return field(distinct, field.name());
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
        return field(distinct, field.name(), alias);
    }

    /**
     * add query fetch field .
     *
     * @param function the function
     * @param field    the field
     * @return query fetched field expression
     */
    default Q fetch(Function function, Field field) {
        return field(function, field.name());
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
        return field(function, field.name(), alias);
    }

    /**
     * add query fetch field .
     *
     * @param aggregateFunction aggregateFunction
     * @param field             the field
     * @return query fetched field expression
     */
    default Q fetch(AggregateFunction aggregateFunction, Field field) {
        return field(aggregateFunction, field.name());
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
        return field(aggregateFunction, field.name(), alias);
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
        return field(aggregateFunction, distinct, field.name());
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
        return field(aggregateFunction, distinct, field.name(), alias);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * add query fetch field .
     *
     * @param field the field
     * @return query fetched field expression
     */
    default Q fetch(AliasField field) {
        return field(field.getAliasOrName());
    }

    /**
     * add query fetch field .
     *
     * @param field the field
     * @param alias the alias
     * @return query fetched field expression
     */
    default Q fetch(AliasField field, String alias) {
        return field(field.getAliasOrName(), alias);
    }

    /**
     * add query fetch field .
     *
     * @param distinct the distinct
     * @param field    the field
     * @return query fetched field expression
     */
    default Q fetch(boolean distinct, AliasField field) {
        return field(distinct, field.getAliasOrName());
    }

    /**
     * add query fetch field .
     *
     * @param distinct the distinct
     * @param field    the field
     * @param alias    the alias
     * @return query fetched field expression
     */
    default Q fetch(boolean distinct, AliasField field, String alias) {
        return field(distinct, field.getAliasOrName(), alias);
    }

    /**
     * add query fetch field .
     *
     * @param function the function
     * @param field    the field
     * @return query fetched field expression
     */
    default Q fetch(Function function, AliasField field) {
        return field(function, field.getAliasOrName());
    }

    /**
     * add query fetch field .
     *
     * @param function the function
     * @param field    the field
     * @param alias    the alias
     * @return query fetched field expression
     */
    default Q fetch(Function function, AliasField field, String alias) {
        return field(function, field.getAliasOrName(), alias);
    }

    /**
     * add query fetch field .
     *
     * @param aggregateFunction aggregateFunction
     * @param field             the field
     * @return query fetched field expression
     */
    default Q fetch(AggregateFunction aggregateFunction, AliasField field) {
        return field(aggregateFunction, field.getAliasOrName());
    }

    /**
     * add query fetch field .
     *
     * @param aggregateFunction aggregateFunction
     * @param field             the field
     * @param alias             the alias
     * @return query fetched field expression
     */
    default Q fetch(AggregateFunction aggregateFunction, AliasField field, String alias) {
        return field(aggregateFunction, field.getAliasOrName(), alias);
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
        return field(aggregateFunction, distinct, field.getAliasOrName());
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
    default Q fetch(AggregateFunction aggregateFunction, boolean distinct, AliasField field, String alias) {
        return field(aggregateFunction, distinct, field.getAliasOrName(), alias);
    }
}
