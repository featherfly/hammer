
/*
 * All rights Reserved, Designed By zhongj
 * @Title: ConpareEntityExpression.java
 * @Package cn.featherfly.hammer.expression.entity.condition
 * @Description: ConpareEntityExpression
 * @author: zhongj
 * @date: 2023-07-19 18:01:19
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.condition;

import cn.featherfly.common.function.serializable.SerializableFunction;

/**
 * The Interface NullNotNullEntityExpression.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface NullNotNullEntityExpression<E> {

    /**
     * is null value or is not null value.
     *
     * @param <R>      the generic type
     * @param property the property
     */
    default <R> void accept(SerializableFunction<E, R> property) {
        accept(property, true);
    }

    /**
     * is null value or is not null value.
     *
     * @param <R>      the generic type
     * @param property the property
     * @param value    the value
     */
    <R> void accept(SerializableFunction<E, R> property, Boolean value);
}
