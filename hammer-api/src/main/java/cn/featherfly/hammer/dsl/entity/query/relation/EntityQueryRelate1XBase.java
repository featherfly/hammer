
package cn.featherfly.hammer.dsl.entity.query.relation;

import cn.featherfly.common.function.serializable.SerializableFunction1;
import cn.featherfly.common.function.serializable.SerializableFunction2;
import cn.featherfly.common.function.serializable.SerializableUnaryOperator1;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelatedExpression;

/**
 * The Interface EntityQueryRelate1XBase.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 */
public interface EntityQueryRelate1XBase<E, R1> {

    /**
     * Join.
     *
     * @param <R2>     the generic type
     * @param joinType the join type
     * @return EntityQueryRelatedExpression
     */
    <R2> EntityQueryRelatedExpression<E, R2, EntityQueryRelate2RR<E, R1, R2>,
            EntityQueryRelatedFetched2RF<E, R1, R2>> join(Class<R2> joinType);

    /**
     * join on.
     *
     * @param <Q>          the generic type
     * @param <R2>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelate2RR
     */
    <R2> EntityQueryRelate2RR<E, R1, R2> join(SerializableFunction2<R2, E> propertyName);

    /**
     * join on.
     *
     * @param <Q>          the generic type
     * @param <R2>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelate2RP
     */
    <R2> EntityQueryRelate2RP<E, R1, R2> join(SerializableFunction1<E, R2> propertyName);

    /**
     * join on.
     *
     * @param <Q>          the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelate2RP
     */
    EntityQueryRelate2RP<E, R1, E> join(SerializableUnaryOperator1<E> propertyName);

    // ********************************************************************
    //	join 2
    // ********************************************************************

    /**
     * Join.
     *
     * @param <R2>     the generic type
     * @param joinType the join type
     * @return EntityQueryRelatedExpression
     */
    <R2> EntityQueryRelatedExpression<R1, R2, EntityQueryRelate2RR<E, R1, R2>,
            EntityQueryRelatedFetched2RF<E, R1, R2>> join2(Class<R2> joinType);

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <R2>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelate2RR
     */
    <R2> EntityQueryRelate2RR<E, R1, R2> join2(SerializableFunction2<R2, R1> propertyName);

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <R2>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelate2RP
     */
    <R2> EntityQueryRelate2RP<E, R1, R2> join2(SerializableFunction1<R1, R2> propertyName);

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelate2RP
     */
    EntityQueryRelate2RP<E, R1, R1> join2(SerializableUnaryOperator1<R1> propertyName);

}
