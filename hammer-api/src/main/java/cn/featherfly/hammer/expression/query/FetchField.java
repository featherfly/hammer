
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-17 20:47:17
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.query;

import cn.featherfly.common.operator.AggregateFunction;

/**
 * The Interface FetchFields.
 *
 * @author zhongj
 */
public interface FetchField {

    /**
     * Distinct.
     *
     * @return the distincted
     */
    default DistinctAware distinct() {
        return distinct(true);
    }

    /**
     * Distinct.
     *
     * @param distinct the distinct
     * @return the distincted
     */
    DistinctAware distinct(boolean distinct);

    /**
     * Name.
     *
     * @param name the name
     * @return the fetch field
     */
    NameAware name(String name);

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * Aggregate.
     *
     * @param aggregateFunction the aggregate function
     * @param name              the name
     * @return the aggregate field
     */
    AggregatedField aggregate(AggregateFunction aggregateFunction, String name);

    /**
     * Count.
     *
     * @param name the name
     * @return the aggregate field
     */
    default AggregatedField count(String name) {
        return aggregate(AggregateFunction.COUNT, name);
    }

    /**
     * Max.
     *
     * @param name the name
     * @return the aggregate field
     */
    default AggregatedField max(String name) {
        return aggregate(AggregateFunction.MAX, name);
    }

    /**
     * Min.
     *
     * @param name the name
     * @return the aggregate field
     */
    default AggregatedField min(String name) {
        return aggregate(AggregateFunction.MIN, name);
    }

    /**
     * Sum.
     *
     * @param name the name
     * @return the aggregate field
     */
    default AggregatedField sum(String name) {
        return aggregate(AggregateFunction.SUM, name);
    }

    /**
     * Avg.
     *
     * @param name the name
     * @return the aggregate field
     */
    default AggregatedField avg(String name) {
        return aggregate(AggregateFunction.AVG, name);
    }
    // ----------------------------------------------------------------------------------------------------------------

    /**
     * Aggregate.
     *
     * @param distinct          the distinct
     * @param aggregateFunction the aggregate function
     * @param name              the name
     * @return the aggregate field
     */
    AggregateDistinctNameAware aggregate(boolean distinct, AggregateFunction aggregateFunction, String name);

    /**
     * Count.
     *
     * @param distinct the distinct
     * @param name     the name
     * @return the aggregate field
     */
    default AggregateDistinctNameAware count(boolean distinct, String name) {
        return aggregate(distinct, AggregateFunction.COUNT, name);
    }

    /**
     * Max.
     *
     * @param distinct the distinct
     * @param name     the name
     * @return the aggregate field
     */
    default AggregateDistinctNameAware max(boolean distinct, String name) {
        return aggregate(distinct, AggregateFunction.MAX, name);
    }

    /**
     * Min.
     *
     * @param distinct the distinct
     * @param name     the name
     * @return the aggregate field
     */
    default AggregateDistinctNameAware min(boolean distinct, String name) {
        return aggregate(distinct, AggregateFunction.MIN, name);
    }

    /**
     * Sum.
     *
     * @param distinct the distinct
     * @param name     the name
     * @return the aggregate field
     */
    default AggregateDistinctNameAware sum(boolean distinct, String name) {
        return aggregate(distinct, AggregateFunction.SUM, name);
    }

    /**
     * Avg.
     *
     * @param distinct the distinct
     * @param name     the name
     * @return the aggregate field
     */
    default AggregateDistinctNameAware avg(boolean distinct, String name) {
        return aggregate(distinct, AggregateFunction.AVG, name);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * Aggregate.
     *
     * @param aggregateFunction the aggregate function
     * @return the aggregate field
     */
    AggregateAware aggregate(AggregateFunction aggregateFunction);

    /**
     * Count.
     *
     * @return the aggregate field
     */
    default AggregateAware count() {
        return aggregate(AggregateFunction.COUNT);
    }

    /**
     * Max.
     *
     * @return the aggregate field
     */
    default AggregateAware max() {
        return aggregate(AggregateFunction.MAX);
    }

    /**
     * Min.
     *
     * @return the aggregate field
     */
    default AggregateAware min() {
        return aggregate(AggregateFunction.MIN);
    }

    /**
     * Sum.
     *
     * @return the aggregate field
     */
    default AggregateAware sum() {
        return aggregate(AggregateFunction.SUM);
    }

    /**
     * Avg.
     *
     * @return the aggregate field
     */
    default AggregateAware avg() {
        return aggregate(AggregateFunction.AVG);
    }

    //    /**
    //     * Function.
    //     *
    //     * @param fun the fun
    //     * @return the fetch field
    //     */
    //    F function(Function fun);
}
