
package cn.featherfly.hammer.dsl.entity.query.relation;

import cn.featherfly.common.function.serializable.SerializableFunction1;
import cn.featherfly.common.function.serializable.SerializableFunction2;
import cn.featherfly.common.function.serializable.SerializableUnaryOperator1;
import cn.featherfly.hammer.dsl.entity.EntityOnExpression3;

/**
 * The Interface EntityQueryRelate2RXBase.
 *
 * @author zhongj
 * @param <E>  query type
 * @param <R1> query or joined type
 * @param <R2> query or joined type
 */
public interface EntityQueryRelate2RXBase<E, R1, R2> {

    /**
     * join.
     *
     * @param <J>      join type
     * @param joinType the join type
     * @return EntityQueryRelatedExpression
     */
    <J> EntityOnExpression3<E, R1, R2, J, EntityQueryRelate3RRR<E, R1, R2, J>> join(Class<J> joinType);

    /**
     * join on.
     *
     * @param <R3>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelate3RRR
     */
    <R3> EntityQueryRelate3RRR<E, R1, R2, R3> join(SerializableFunction2<R3, E> propertyName);

    /**
     * join on.
     *
     * @param <R3>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelate3RRP
     */
    <R3> EntityQueryRelate3RRP<E, R1, R2, R3> join(SerializableFunction1<E, R3> propertyName);

    /**
     * join on.
     *
     * @param propertyName find type object property name
     * @return EntityQueryRelate3RRP
     */
    EntityQueryRelate3RRP<E, R1, R2, E> join(SerializableUnaryOperator1<E> propertyName);

    // ****************************************************************************************************************
    //	join 2
    // ****************************************************************************************************************

    /**
     * join on.
     *
     * @param <R3>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelate3RRR
     */
    <R3> EntityQueryRelate3RRR<E, R1, R2, R3> join2(SerializableFunction2<R3, R1> propertyName);

    /**
     * join on.
     *
     * @param <R3>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelate3RRP
     */
    <R3> EntityQueryRelate3RRP<E, R1, R2, R3> join2(SerializableFunction1<R1, R3> propertyName);

    /**
     * join on.
     *
     * @param propertyName find type object property name
     * @return EntityQueryRelate3RRP
     */
    EntityQueryRelate3RRP<E, R1, R2, R1> join2(SerializableUnaryOperator1<R1> propertyName);

    // ********************************************************************
    // join 3
    // ********************************************************************

    /**
     * join on.
     *
     * @param <R3>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelate3RRR
     */
    <R3> EntityQueryRelate3RRR<E, R1, R2, R3> join3(SerializableFunction2<R3, R2> propertyName);

    /**
     * join on.
     *
     * @param <R3>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelate3RRP
     */
    <R3> EntityQueryRelate3RRP<E, R1, R2, R3> join3(SerializableFunction1<R2, R3> propertyName);

    /**
     * join on.
     *
     * @param propertyName find type object property name
     * @return EntityQueryRelate3RRP
     */
    EntityQueryRelate3RRP<E, R1, R2, R2> join3(SerializableUnaryOperator1<R2> propertyName);

}
