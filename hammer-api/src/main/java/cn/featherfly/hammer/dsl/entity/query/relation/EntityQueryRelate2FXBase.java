
package cn.featherfly.hammer.dsl.entity.query.relation;

import cn.featherfly.common.function.serializable.SerializableFunction1;
import cn.featherfly.common.function.serializable.SerializableFunction2;
import cn.featherfly.common.function.serializable.SerializableUnaryOperator1;

/**
 * The Interface EntityQueryRelate2FXBase.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 * @param <R2> the generic type
 */
public interface EntityQueryRelate2FXBase<E, R1, R2> {

    /**
     * join.
     *
     * @param <R3>     the generic type
     * @param joinType the join type
     * @return EntityQueryRelate3FRR
     */
    <R3> EntityQueryRelatedExpression<E, R3, EntityQueryRelate3FRR<E, R1, R2, R3>,
            EntityQueryRelatedFetched3FRF<E, R1, R2, R3>> join(Class<R3> joinType);

    /**
     * join on.
     *
     * @param <R3>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelate3FRR
     */
    <R3> EntityQueryRelate3FRR<E, R1, R2, R3> join(SerializableFunction2<R3, E> propertyName);

    /**
     * join on.
     *
     * @param <R3>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelate3FRP
     */
    <R3> EntityQueryRelate3FRP<E, R1, R2, R3> join(SerializableFunction1<E, R3> propertyName);

    /**
     * join on.
     *
     * @param propertyName find type object property name
     * @return EntityQueryRelate3FRP
     */
    EntityQueryRelate3FRP<E, R1, R2, E> join(SerializableUnaryOperator1<E> propertyName);

    /**
     * join.
     *
     * @param <R3>     the generic type
     * @param joinType the join type
     * @return EntityQueryRelate3FRR
     */
    <R3> EntityQueryRelatedExpression<R1, R3, EntityQueryRelate3FRR<E, R1, R2, R3>,
            EntityQueryRelatedFetched3FRF<E, R1, R2, R3>> join2(Class<R3> joinType);

    /**
     * join on.
     *
     * @param <R3>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelate3FRR
     */
    <R3> EntityQueryRelate3FRR<E, R1, R2, R3> join2(SerializableFunction2<R3, R1> propertyName);

    /**
     * join on.
     *
     * @param <R3>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelate3FRP
     */
    <R3> EntityQueryRelate3FRP<E, R1, R2, R3> join2(SerializableFunction1<R1, R3> propertyName);

    /**
     * join on.
     *
     * @param propertyName find type object property name
     * @return EntityQueryRelate3FRP
     */
    EntityQueryRelate3FRP<E, R1, R2, R1> join2(SerializableUnaryOperator1<R1> propertyName);

    // ********************************************************************
    // 3
    // ********************************************************************

    /**
     * join.
     *
     * @param <R3>     the generic type
     * @param joinType the join type
     * @return EntityQueryRelate3FRR
     */
    <R3> EntityQueryRelatedExpression<R2, R3, EntityQueryRelate3FRR<E, R1, R2, R3>,
            EntityQueryRelatedFetched3FRF<E, R1, R2, R3>> join3(Class<R3> joinType);

    /**
     * join on.
     *
     * @param <R3>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelate3FRR
     */
    <R3> EntityQueryRelate3FRR<E, R1, R2, R3> join3(SerializableFunction2<R3, R2> propertyName);

    /**
     * join on.
     *
     * @param <R3>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelate3FRP
     */
    <R3> EntityQueryRelate3FRP<E, R1, R2, R3> join3(SerializableFunction1<R2, R3> propertyName);

    /**
     * join on.
     *
     * @param propertyName find type object property name
     * @return EntityQueryRelate3FRP
     */
    EntityQueryRelate3FRP<E, R1, R2, R2> join3(SerializableUnaryOperator1<R2> propertyName);

}