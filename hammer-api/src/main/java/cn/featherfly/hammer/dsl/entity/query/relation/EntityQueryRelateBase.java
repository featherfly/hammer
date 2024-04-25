
package cn.featherfly.hammer.dsl.entity.query.relation;

import cn.featherfly.common.function.serializable.SerializableFunction1;
import cn.featherfly.common.function.serializable.SerializableFunction2;
import cn.featherfly.common.function.serializable.SerializableUnaryOperator1;
import cn.featherfly.hammer.dsl.entity.EntityOnExpression1;

/**
 * The Interface EntityQueryRelateBase.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface EntityQueryRelateBase<E> {

    /**
     * Join.
     *
     * @param <R>      the generic type
     * @param joinType the join type
     * @return the entity query related expression
     */
    <R> EntityOnExpression1<E, R, EntityQueryRelate1R<E, R>> join(Class<R> joinType);

    /**
     * join on.
     *
     * @param <Q>          the generic type
     * @param <R>          the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelateExpression
     */
    <R> EntityQueryRelate1P<E, R> join(SerializableFunction1<E, R> propertyName);

    /**
     * join on.
     *
     * @param <Q>          the generic type
     * @param <R>          the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelateExpression
     */
    <R> EntityQueryRelate1R<E, R> join(SerializableFunction2<R, E> propertyName);

    /**
     * join on.
     *
     * @param <Q>          the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelateExpression
     */
    EntityQueryRelate1P<E, E> join(SerializableUnaryOperator1<E> propertyName);
}
