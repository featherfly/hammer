
/*
 * All rights Reserved, Designed By zhongj
 * @Title: ConpareEntityExpression.java
 * @Package cn.featherfly.hammer.expression.entity.condition
 * @Description: ConpareEntityExpression
 * @author: zhongj
 * @date: 2023-07-19 18:01:19
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.repository.condition;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.repository.Field;

/**
 * The Interface NullNotNullEntityExpression.
 *
 * @author zhongj
 */
public interface NullNotNullRepositoryExpression {

    /**
     * is null value or is not null value.
     *
     * @param field the field
     */
    default void accept(Field field) {
        accept(field.name());
    }

    /**
     * is null value or is not null value.
     *
     * @param field the field
     * @param value the value
     */
    default void accept(Field field, Boolean value) {
        accept(field.name(), value);
    }

    /**
     * is null value or is not null value.
     *
     * @param name the name
     */
    default void accept(String name) {
        accept(name, true);
    }

    /**
     * is null value or is not null value.
     *
     * @param name  the name
     * @param value the value
     */
    void accept(String name, Boolean value);

    /**
     * is null value or is not null value.
     *
     * @param <E>      the element type
     * @param <R>      the generic type
     * @param property the property
     */
    default <E, R> void accept(SerializableFunction<E, R> property) {
        accept(property, true);
    }

    /**
     * is null value or is not null value.
     *
     * @param <E>      the element type
     * @param <R>      the generic type
     * @param property the property
     * @param value    the value
     */
    <E, R> void accept(SerializableFunction<E, R> property, Boolean value);
}
