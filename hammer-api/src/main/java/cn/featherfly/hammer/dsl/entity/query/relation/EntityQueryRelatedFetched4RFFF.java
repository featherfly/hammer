
package cn.featherfly.hammer.dsl.entity.query.relation;

import com.speedment.common.tuple.Tuple4;

import cn.featherfly.common.function.serializable.SerializableFunction1;
import cn.featherfly.common.function.serializable.SerializableFunction2;
import cn.featherfly.common.function.serializable.SerializableUnaryOperator1;
import cn.featherfly.hammer.dsl.entity.EntityOnExpression5;
import cn.featherfly.hammer.dsl.entity.query.EntityQuery5;

/**
 * The Interface EntityQueryRelatedFetched4FFRF.
 *
 * @author zhongj
 * @param <E>  query type
 * @param <R1> query or joined type
 * @param <R2> query or joined type
 * @param <R3> query or joined type
 * @param <R4> query or joined type
 */
public interface EntityQueryRelatedFetched4RFFF<E, R1, R2, R3, R4>
    extends EntityQuery5<E, R1, R2, R3, R4, Tuple4<E, R2, R3, R4>> {

    /**
     * join.
     *
     * @param <J>      join type
     * @param joinType the join type
     * @return EntityQueryRelatedExpression
     */
    <J> EntityOnExpression5<E, R1, R2, R3, R4, J, EntityQueryRelate5RFFFR<E, R1, R2, R3, R4, J>> join(
        Class<J> joinType);

    /**
     * join on.
     *
     * @param <R5>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelate5RFFFR
     */
    <R5> EntityQueryRelate5RFFFR<E, R1, R2, R3, R4, R5> join(SerializableFunction2<R5, E> propertyName);

    /**
     * join on.
     *
     * @param <R5>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelate5RFFFP
     */
    <R5> EntityQueryRelate5RFFFP<E, R1, R2, R3, R4, R5> join(SerializableFunction1<E, R5> propertyName);

    /**
     * join on.
     *
     * @param propertyName find type object property name
     * @return EntityQueryRelate5RFFFP
     */
    EntityQueryRelate5RFFFP<E, R1, R2, R3, R4, E> join(SerializableUnaryOperator1<E> propertyName);

    // ********************************************************************
    //  2
    // ********************************************************************

    /**
     * join on.
     *
     * @param <R5>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelate5RFFFR
     */
    <R5> EntityQueryRelate5RFFFR<E, R1, R2, R3, R4, R5> join2(SerializableFunction2<R5, R1> propertyName);

    /**
     * join on.
     *
     * @param <R5>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelate5RFFFP
     */
    <R5> EntityQueryRelate5RFFFP<E, R1, R2, R3, R4, R5> join2(SerializableFunction1<R1, R5> propertyName);

    /**
     * join on.
     *
     * @param propertyName find type object property name
     * @return EntityQueryRelate5RFFFP
     */
    EntityQueryRelate5RFFFP<E, R1, R2, R3, R4, R1> join2(SerializableUnaryOperator1<R1> propertyName);

    // ********************************************************************
    // 3
    // ********************************************************************

    /**
     * join on.
     *
     * @param <R5>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelate5RFFFR
     */
    <R5> EntityQueryRelate5RFFFR<E, R1, R2, R3, R4, R5> join3(SerializableFunction2<R5, R2> propertyName);

    /**
     * join on.
     *
     * @param <R5>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelate5RFFFP
     */
    <R5> EntityQueryRelate5RFFFP<E, R1, R2, R3, R4, R5> join3(SerializableFunction1<R2, R5> propertyName);

    /**
     * join on.
     *
     * @param propertyName find type object property name
     * @return EntityQueryRelate5RFFFP
     */
    EntityQueryRelate5RFFFP<E, R1, R2, R3, R4, R2> join3(SerializableUnaryOperator1<R2> propertyName);

    // ********************************************************************
    // 4
    // ********************************************************************

    /**
     * join on.
     *
     * @param <R5>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelate5RFFFR
     */
    <R5> EntityQueryRelate5RFFFR<E, R1, R2, R3, R4, R5> join4(SerializableFunction2<R5, R3> propertyName);

    /**
     * join on.
     *
     * @param <R5>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelate5RFFFP
     */
    <R5> EntityQueryRelate5RFFFP<E, R1, R2, R3, R4, R5> join4(SerializableFunction1<R3, R5> propertyName);

    /**
     * join on.
     *
     * @param propertyName find type object property name
     * @return EntityQueryRelate5RFFFP
     */
    EntityQueryRelate5RFFFP<E, R1, R2, R3, R4, R3> join4(SerializableUnaryOperator1<R3> propertyName);

    // ********************************************************************
    // 5
    // ********************************************************************

    /**
     * join on.
     *
     * @param <R5>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelate5RFFFR
     */
    <R5> EntityQueryRelate5RFFFR<E, R1, R2, R3, R4, R5> join5(SerializableFunction2<R5, R4> propertyName);

    /**
     * join on.
     *
     * @param <R5>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelate5RFFFP
     */
    <R5> EntityQueryRelate5RFFFP<E, R1, R2, R3, R4, R5> join5(SerializableFunction1<R4, R5> propertyName);

    /**
     * join on.
     *
     * @param propertyName find type object property name
     * @return EntityQueryRelate5RFFFP
     */
    EntityQueryRelate5RFFFP<E, R1, R2, R3, R4, R4> join5(SerializableUnaryOperator1<R4> propertyName);
}
