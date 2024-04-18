
/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntityDelete.java
 * @Package cn.featherfly.hammer.dsl.execute
 * @Description: EntityDelete
 * @author: zhongj
 * @date: 2022-11-28 15:41:28
 * @Copyright: 2022 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.dsl.entity.execute;

import cn.featherfly.hammer.config.dsl.DeleteConditionConfig;
import cn.featherfly.hammer.dsl.entity.EntityOnExpression1;
import cn.featherfly.hammer.expression.entity.execute.EntityDeleteExpression;

/**
 * EntityDelete.
 *
 * @author zhongj
 */
public interface EntityDelete<E>
    extends EntityDeleteExpression<E, EntityExecutableConditionGroup<E, DeleteConditionConfig>,
        EntityExecutableConditionGroupLogic<E, DeleteConditionConfig>> {

    /**
     * Join.
     *
     * @param <J>      the generic type
     * @param joinType the join type
     * @return the entity on expression1
     */
    <J> EntityOnExpression1<E, J, EntityDelete2<E, J>> join(Class<J> joinType);

    //    /**
    //     * join on.
    //     *
    //     * @param <Q>          the generic type
    //     * @param <R>          the generic type
    //     * @param propertyName find type object property name
    //     * @return EntityQueryRelateExpression
    //     */
    //    <R> EntityQueryRelate1P<E, R> join(SerializableFunction1<E, R> propertyName);
    //
    //    /**
    //     * join on.
    //     *
    //     * @param <Q>          the generic type
    //     * @param <R>          the generic type
    //     * @param propertyName find type object property name
    //     * @return EntityQueryRelateExpression
    //     */
    //    <R> EntityQueryRelate1R<E, R> join(SerializableFunction2<R, E> propertyName);
    //
    //    /**
    //     * join on.
    //     *
    //     * @param <Q>          the generic type
    //     * @param propertyName find type object property name
    //     * @return EntityQueryRelateExpression
    //     */
    //    EntityQueryRelate1P<E, E> join(SerializableUnaryOperator1<E> propertyName);
}
