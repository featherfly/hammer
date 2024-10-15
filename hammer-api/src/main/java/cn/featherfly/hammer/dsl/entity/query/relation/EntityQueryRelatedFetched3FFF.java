
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

import cn.featherfly.common.tuple.Tuple4;

import cn.featherfly.common.function.serializable.SerializableFunction1;
import cn.featherfly.common.function.serializable.SerializableFunction2;
import cn.featherfly.common.function.serializable.SerializableUnaryOperator1;
import cn.featherfly.hammer.dsl.entity.EntityOnExpression4;
import cn.featherfly.hammer.dsl.entity.query.EntityQuery4;

/**
 * The Interface EntityQueryRelatedFetched3FFF.
 *
 * @author zhongj
 * @param <E>  query type
 * @param <R1> query or joined type
 * @param <R2> query or joined type
 * @param <R3> query or joined type
 */
public interface EntityQueryRelatedFetched3FFF<E, R1, R2, R3>
    extends EntityQuery4<E, R1, R2, R3, Tuple4<E, R1, R2, R3>> {

    /**
     * join.
     *
     * @param <J>      join type
     * @param joinType the join type
     * @return EntityQueryRelate4FFFR
     */
    <J> EntityOnExpression4<E, R1, R2, R3, J, EntityQueryRelate4FFFR<E, R1, R2, R3, J>> join(Class<J> joinType);

    /**
     * join on.
     *
     * @param <R4>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelate4FFFR
     */
    <R4> EntityQueryRelate4FFFR<E, R1, R2, R3, R4> join(SerializableFunction2<R4, E> propertyName);

    /**
     * join on.
     *
     * @param <R4>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelate4FFFP
     */
    <R4> EntityQueryRelate4FFFP<E, R1, R2, R3, R4> join(SerializableFunction1<E, R4> propertyName);

    /**
     * join on.
     *
     * @param propertyName find type object property name
     * @return EntityQueryRelate4FFFP
     */
    EntityQueryRelate4FFFP<E, R1, R2, R3, E> join(SerializableUnaryOperator1<E> propertyName);

    // ********************************************************************
    //  join 2
    // ********************************************************************

    /**
     * join on.
     *
     * @param <R4>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelate4FFFR
     */
    <R4> EntityQueryRelate4FFFR<E, R1, R2, R3, R4> join2(SerializableFunction2<R4, R1> propertyName);

    /**
     * join on.
     *
     * @param <R4>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelate4FFFR
     */
    <R4> EntityQueryRelate4FFFP<E, R1, R2, R3, R4> join2(SerializableFunction1<R1, R4> propertyName);

    /**
     * join on.
     *
     * @param propertyName find type object property name
     * @return EntityQueryRelate4FFFR
     */
    EntityQueryRelate4FFFP<E, R1, R2, R3, R1> join2(SerializableUnaryOperator1<R1> propertyName);

    // ********************************************************************
    // 3
    // ********************************************************************

    /**
     * join on.
     *
     * @param <R4>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelate4FFFR
     */
    <R4> EntityQueryRelate4FFFR<E, R1, R2, R3, R4> join3(SerializableFunction2<R4, R2> propertyName);

    /**
     * join on.
     *
     * @param <R4>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelate4FFFP
     */
    <R4> EntityQueryRelate4FFFP<E, R1, R2, R3, R4> join3(SerializableFunction1<R2, R4> propertyName);

    /**
     * join on.
     *
     * @param propertyName find type object property name
     * @return EntityQueryRelate4FFFP
     */
    EntityQueryRelate4FFFP<E, R1, R2, R3, R2> join3(SerializableUnaryOperator1<R2> propertyName);

    // ********************************************************************
    // 4
    // ********************************************************************

    /**
     * join on.
     *
     * @param <R4>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelate4FFFR
     */
    <R4> EntityQueryRelate4FFFR<E, R1, R2, R3, R4> join4(SerializableFunction2<R4, R3> propertyName);

    /**
     * join on.
     *
     * @param <R4>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelate4FFFP
     */
    <R4> EntityQueryRelate4FFFP<E, R1, R2, R3, R4> join4(SerializableFunction1<R3, R4> propertyName);

    /**
     * join on.
     *
     * @param propertyName find type object property name
     * @return EntityQueryRelate4FFFP
     */
    EntityQueryRelate4FFFP<E, R1, R2, R3, R3> join4(SerializableUnaryOperator1<R3> propertyName);
}
