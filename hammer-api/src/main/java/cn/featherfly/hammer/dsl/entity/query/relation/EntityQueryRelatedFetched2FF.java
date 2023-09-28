
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
import cn.featherfly.hammer.dsl.entity.query.EntityQuery3;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelatedExpression;

/**
 * The Interface EntityQueryRelatedFetched2FF.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 * @param <R2> the generic type
 */
public interface EntityQueryRelatedFetched2FF<E, R1, R2> extends EntityQuery3<E, R1, R2, Tuple3<E, R1, R2>> {

    /**
     * join.
     *
     * @param <R3>     the generic type
     * @param joinType the join type
     * @return EntityQueryRelate3FF
     */
    <R3> EntityQueryRelatedExpression<E, R3, EntityQueryRelate3FFR<E, R1, R2, R3>,
            EntityQueryRelatedFetched3FFF<E, R1, R2, R3>> join(Class<R3> joinType);

    /**
     * join on.
     *
     * @param <R3>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelate3FF
     */
    <R3> EntityQueryRelate3FFR<E, R1, R2, R3> join(SerializableFunction2<R3, E> propertyName);

    /**
     * join on.
     *
     * @param <R3>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelate3FF
     */
    <R3> EntityQueryRelate3FFP<E, R1, R2, R3> join(SerializableFunction1<E, R3> propertyName);

    /**
     * join on.
     *
     * @param propertyName find type object property name
     * @return EntityQueryRelate3FF
     */
    EntityQueryRelate3FFP<E, R1, R2, E> join(SerializableUnaryOperator1<E> propertyName);

    // ********************************************************************
    //  join 2
    // ********************************************************************

    /**
     * join.
     *
     * @param <R3>     the generic type
     * @param joinType the join type
     * @return EntityQueryRelate3FF
     */
    <R3> EntityQueryRelatedExpression<R1, R3, EntityQueryRelate3FFR<E, R1, R2, R3>,
            EntityQueryRelatedFetched3FFF<E, R1, R2, R3>> join2(Class<R3> joinType);

    /**
     * join on.
     *
     * @param <R3>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelate3FF
     */
    <R3> EntityQueryRelate3FFR<E, R1, R2, R3> join2(SerializableFunction2<R3, R1> propertyName);

    /**
     * join on.
     *
     * @param <R3>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelate3FF
     */
    <R3> EntityQueryRelate3FFP<E, R1, R2, R3> join2(SerializableFunction1<R1, R3> propertyName);

    /**
     * join on.
     *
     * @param propertyName find type object property name
     * @return EntityQueryRelate3FF
     */
    EntityQueryRelate3FFP<E, R1, R2, R1> join2(SerializableUnaryOperator1<R1> propertyName);

    // ********************************************************************
    // join 3
    // ********************************************************************

    /**
     * join.
     *
     * @param <R3>     the generic type
     * @param joinType the join type
     * @return EntityQueryRelate3FF
     */
    <R3> EntityQueryRelatedExpression<R2, R3, EntityQueryRelate3FFR<E, R1, R2, R3>,
            EntityQueryRelatedFetched3FFF<E, R1, R2, R3>> join3(Class<R3> joinType);

    /**
     * join on.
     *
     * @param <R3>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelate3FF
     */
    <R3> EntityQueryRelate3FFR<E, R1, R2, R3> join3(SerializableFunction2<R3, R2> propertyName);

    /**
     * join on.
     *
     * @param <R3>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelate3FF
     */
    <R3> EntityQueryRelate3FFP<E, R1, R2, R3> join3(SerializableFunction1<R2, R3> propertyName);

    /**
     * join on.
     *
     * @param propertyName find type object property name
     * @return EntityQueryRelate3FF
     */
    EntityQueryRelate3FFP<E, R1, R2, R2> join3(SerializableUnaryOperator1<R2> propertyName);

}
