
/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntityQueryRelatedFetched.java
 * @Package cn.featherfly.hammer.dsl.query.type
 * @Description: EntityQueryRelatedFetched
 * @author: zhongj
 * @date: 2023-06-01 16:30:01
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.dsl.entity.query.relation;

import cn.featherfly.common.tuple.Tuple2;

import cn.featherfly.common.function.serializable.SerializableFunction1;
import cn.featherfly.common.function.serializable.SerializableFunction2;
import cn.featherfly.common.function.serializable.SerializableUnaryOperator1;
import cn.featherfly.hammer.dsl.entity.EntityOnExpression2;
import cn.featherfly.hammer.dsl.entity.query.EntityQuery2;

/**
 * The Interface EntityQueryRelatedFetched1F.
 *
 * @author zhongj
 * @param <E>  query type
 * @param <R1> query or joined type
 */
public interface EntityQueryRelatedFetched1F<E, R1> extends EntityQuery2<E, R1, Tuple2<E, R1>> {

    /**
     * join on.
     *
     * @param <J>      join type
     * @param joinType the join type
     * @return EntityQueryRelate2F
     */
    <J> EntityOnExpression2<E, R1, J, EntityQueryRelate2FR<E, R1, J>> join(Class<J> joinType);

    /**
     * join on.
     *
     * @param <Q>          the generic type
     * @param <R2>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelate2F
     */
    <Q extends EntityQueryRelate2FP<E, R1, R2>, R2> Q join(SerializableFunction1<E, R2> propertyName);

    /**
     * join on.
     *
     * @param <Q>          the generic type
     * @param <R2>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelate2F
     */
    <Q extends EntityQueryRelate2FR<E, R1, R2>, R2> Q join(SerializableFunction2<R2, E> propertyName);

    /**
     * join on.
     *
     * @param <Q>          the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelate2F
     */
    <Q extends EntityQueryRelate2FP<E, R1, E>> Q join(SerializableUnaryOperator1<E> propertyName);

    // ****************************************************************************************************************
    //  join 2
    // ****************************************************************************************************************

    /**
     * join on.
     *
     * @param <Q>          the generic type
     * @param <R2>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelate2F
     */
    <Q extends EntityQueryRelate2FP<E, R1, R2>, R2> Q join2(SerializableFunction1<R1, R2> propertyName);

    /**
     * join on.
     *
     * @param <Q>          the generic type
     * @param <R2>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelate2F
     */
    <Q extends EntityQueryRelate2FR<E, R1, R2>, R2> Q join2(SerializableFunction2<R2, R1> propertyName);

    /**
     * join on.
     *
     * @param <Q>          the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelate2F
     */
    <Q extends EntityQueryRelate2FP<E, R1, R1>> Q join2(SerializableUnaryOperator1<R1> propertyName);
}
