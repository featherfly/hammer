
package cn.featherfly.hammer.dsl.entity.query.relation;

import cn.featherfly.common.function.serializable.SerializableFunction1;
import cn.featherfly.common.function.serializable.SerializableFunction2;
import cn.featherfly.common.function.serializable.SerializableUnaryOperator1;
import cn.featherfly.hammer.dsl.entity.EntityOnExpression2;

/**
 * The Interface EntityQueryRelate1XBase.
 *
 * @author zhongj
 * @param <E>  query type
 * @param <R1> query or joined type
 */
public interface EntityQueryRelate1XBase<E, R1> {

    /**
     * Join.
     *
     * @param <J>      join type
     * @param joinType the join type
     * @return EntityQueryRelatedExpression
     */
    <J> EntityOnExpression2<E, R1, J, EntityQueryRelate2RR<E, R1, J>> join(Class<J> joinType);

    /**
     * join on.
     *
     * @param <R2>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelate2RR
     */
    <R2> EntityQueryRelate2RR<E, R1, R2> join(SerializableFunction2<R2, E> propertyName);

    /**
     * join on.
     *
     * @param <R2>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelate2RP
     */
    <R2> EntityQueryRelate2RP<E, R1, R2> join(SerializableFunction1<E, R2> propertyName);

    /**
     * join on.
     *
     * @param propertyName find type object property name
     * @return EntityQueryRelate2RP
     */
    EntityQueryRelate2RP<E, R1, E> join(SerializableUnaryOperator1<E> propertyName);

    // ********************************************************************
    //	join 2
    // ********************************************************************

    /**
     * join on.
     *
     * @param <R2>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelate2RR
     */
    <R2> EntityQueryRelate2RR<E, R1, R2> join2(SerializableFunction2<R2, R1> propertyName);

    /**
     * join on.
     *
     * @param <R2>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelate2RP
     */
    <R2> EntityQueryRelate2RP<E, R1, R2> join2(SerializableFunction1<R1, R2> propertyName);

    /**
     * join on.
     *
     * @param propertyName find type object property name
     * @return EntityQueryRelate2RP
     */
    EntityQueryRelate2RP<E, R1, R1> join2(SerializableUnaryOperator1<R1> propertyName);

}
