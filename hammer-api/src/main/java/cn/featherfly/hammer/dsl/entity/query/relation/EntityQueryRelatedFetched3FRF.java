
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

import com.speedment.common.tuple.Tuple3;

import cn.featherfly.common.function.serializable.SerializableFunction1;
import cn.featherfly.common.function.serializable.SerializableFunction2;
import cn.featherfly.common.function.serializable.SerializableUnaryOperator1;
import cn.featherfly.hammer.dsl.entity.query.EntityQuery4;

/**
 * The Interface EntityQueryRelatedFetched3FRF.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 * @param <R2> the generic type
 * @param <R3> the generic type
 */
public interface EntityQueryRelatedFetched3FRF<E, R1, R2, R3> extends EntityQuery4<E, R1, R2, R3, Tuple3<E, R1, R3>> {

    /**
     * join.
     *
     * @param <R4>     the generic type
     * @param joinType the join type
     * @return EntityQueryRelatedExpression
     */
    <R4> EntityQueryRelatedExpression<E, R4, EntityQueryRelate4FRFR<E, R1, R2, R3, R4>,
            EntityQueryRelatedFetched4FRFF<E, R1, R2, R3, R4>> join(Class<R4> joinType);

    /**
     * join on.
     *
     * @param <R4>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelate4FRFR
     */
    <R4> EntityQueryRelate4FRFR<E, R1, R2, R3, R4> join(SerializableFunction2<R4, E> propertyName);

    /**
     * join on.
     *
     * @param <R4>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelate4FRFP
     */
    <R4> EntityQueryRelate4FRFP<E, R1, R2, R3, R4> join(SerializableFunction1<E, R4> propertyName);

    /**
     * join on.
     *
     * @param propertyName find type object property name
     * @return EntityQueryRelate4FRFP
     */
    EntityQueryRelate4FRFP<E, R1, R2, R3, E> join(SerializableUnaryOperator1<E> propertyName);

    // ********************************************************************
    //  2
    // ********************************************************************

    /**
     * join.
     *
     * @param <R4>     the generic type
     * @param joinType the join type
     * @return EntityQueryRelatedExpression
     */
    <R4> EntityQueryRelatedExpression<R1, R4, EntityQueryRelate4FRFR<E, R1, R2, R3, R4>,
            EntityQueryRelatedFetched4FRFF<E, R1, R2, R3, R4>> join2(Class<R4> joinType);

    /**
     * join on.
     *
     * @param <R4>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelate4FRFR
     */
    <R4> EntityQueryRelate4FRFR<E, R1, R2, R3, R4> join2(SerializableFunction2<R4, R1> propertyName);

    /**
     * join on.
     *
     * @param <R4>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelate4FRFP
     */
    <R4> EntityQueryRelate4FRFP<E, R1, R2, R3, R4> join2(SerializableFunction1<R1, R4> propertyName);

    /**
     * join on.
     *
     * @param propertyName find type object property name
     * @return EntityQueryRelate4FRFP
     */
    EntityQueryRelate4FRFP<E, R1, R2, R3, R1> join2(SerializableUnaryOperator1<R1> propertyName);

    // ********************************************************************
    // 3
    // ********************************************************************

    /**
     * join.
     *
     * @param <R4>     the generic type
     * @param joinType the join type
     * @return EntityQueryRelatedExpression
     */
    <R4> EntityQueryRelatedExpression<R2, R4, EntityQueryRelate4FRFR<E, R1, R2, R3, R4>,
            EntityQueryRelatedFetched4FRFF<E, R1, R2, R3, R4>> join3(Class<R4> joinType);

    /**
     * join on.
     *
     * @param <R4>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelate4FRFR
     */
    <R4> EntityQueryRelate4FRFR<E, R1, R2, R3, R4> join3(SerializableFunction2<R4, R2> propertyName);

    /**
     * join on.
     *
     * @param <R4>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelate4FRFP
     */
    <R4> EntityQueryRelate4FRFP<E, R1, R2, R3, R4> join3(SerializableFunction1<R2, R4> propertyName);

    /**
     * join on.
     *
     * @param propertyName find type object property name
     * @return EntityQueryRelate4FRFP
     */
    EntityQueryRelate4FRFP<E, R1, R2, R3, R2> join3(SerializableUnaryOperator1<R2> propertyName);

    // ********************************************************************
    // 4
    // ********************************************************************

    /**
     * join.
     *
     * @param <R4>     the generic type
     * @param joinType the join type
     * @return EntityQueryRelatedExpression
     */
    <R4> EntityQueryRelatedExpression<R3, R4, EntityQueryRelate4FRFR<E, R1, R2, R3, R4>,
            EntityQueryRelatedFetched4FRFF<E, R1, R2, R3, R4>> join4(Class<R4> joinType);

    /**
     * join on.
     *
     * @param <R4>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelate4FRFR
     */
    <R4> EntityQueryRelate4FRFR<E, R1, R2, R3, R4> join4(SerializableFunction2<R4, R3> propertyName);

    /**
     * join on.
     *
     * @param <R4>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelate4FRFP
     */
    <R4> EntityQueryRelate4FRFP<E, R1, R2, R3, R4> join4(SerializableFunction1<R3, R4> propertyName);

    /**
     * join on.
     *
     * @param propertyName find type object property name
     * @return EntityQueryRelate4FRFP
     */
    EntityQueryRelate4FRFP<E, R1, R2, R3, R3> join4(SerializableUnaryOperator1<R3> propertyName);

}
