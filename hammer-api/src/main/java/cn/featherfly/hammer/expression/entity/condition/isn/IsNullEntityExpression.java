
/*
 * All rights Reserved, Designed By zhongj
 * @Title: Entities.java
 * @Package cn.featherfly.hammer.expression.entity.condition.eq
 * @Description: Entities
 * @author: zhongj
 * @date: 2023-07-18 14:44:18
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.condition.isn;

import cn.featherfly.common.lang.function.SerializableFunction;

/**
 * The Interface IsNullEntityExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface IsNullEntityExpression<E> {

    /**
     * entity is null function property expression.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return entity is null function property expression
     */
    <R> IsNullEntityPropertyExpression<E, R> property(SerializableFunction<E, R> name);

    /**
     * is null value.
     *
     * @param <R>      the generic type
     * @param property the property
     * @return the l
     */
    default <R> void accept(SerializableFunction<E, R> property) {
        accept(property, true);
    }

    /**
     * is null value.
     *
     * @param <R>      the generic type
     * @param property the property
     * @param value    the value
     * @return the l
     */
    <R> void accept(SerializableFunction<E, R> property, Boolean value);
}
