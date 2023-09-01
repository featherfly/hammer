
/*
 * All rights Reserved, Designed By zhongj
 * @Title: Entities.java
 * @Package cn.featherfly.hammer.expression.entity.condition.eq
 * @Description: Entities
 * @author: zhongj
 * @date: 2023-07-18 14:44:18
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.condition.inn;

import cn.featherfly.common.function.serializable.SerializableFunction;

/**
 * The Interface IsNotNullEntityExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface IsNotNullEntityExpression<E> {

    /**
     * entity is not null function property expression.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return entity is not null function property expression
     */
    <R> IsNotNullEntityPropertyExpression<E, R> property(SerializableFunction<E, R> name);

    /**
     * is not null value.
     *
     * @param <R>      the generic type
     * @param property the property
     * @return the l
     */
    default <R> void accept(SerializableFunction<E, R> property) {
        accept(property, true);
    }

    /**
     * is not null value.
     *
     * @param <R>      the generic type
     * @param property the property
     * @param value    the value
     * @return the l
     */
    <R> void accept(SerializableFunction<E, R> property, Boolean value);
}
