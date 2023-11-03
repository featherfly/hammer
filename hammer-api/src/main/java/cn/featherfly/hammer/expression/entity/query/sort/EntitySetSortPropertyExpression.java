
/*
 * All rights Reserved, Designed By zhongj
 * @Title: Entities.java
 * @Package cn.featherfly.hammer.expression.entity.condition.eq
 * @Description: Entities
 * @author: zhongj
 * @date: 2023-07-18 14:44:18
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.query.sort;

import cn.featherfly.common.function.serializable.SerializableFunction;

/**
 * The Interface SortEntityExpression.
 *
 * @author zhongj
 * @param <E> the element type
 */
@FunctionalInterface
public interface EntitySetSortPropertyExpression<E> {

    /**
     * set sort(asc or desc) field.
     *
     * @param property the bean property
     * @return EntitySetSortPropertyExpression
     */
    EntitySetSortPropertyExpression<E> property(SerializableFunction<E, ?> property);

    /**
     * set sort(asc or desc) property .
     *
     * @param property1 the first bean property
     * @param property2 the second bean property
     * @return EntitySetSortPropertyExpression
     */
    default EntitySetSortPropertyExpression<E> property(SerializableFunction<E, ?> property1,
            SerializableFunction<E, ?> property2) {
        EntitySetSortPropertyExpression<E> exp = property(property1);
        return exp.property(property2);
    }

    /**
     * set sort(asc or desc) property .
     *
     * @param property1 the first bean property
     * @param property2 the second bean property
     * @param property3 the third bean property
     * @return EntitySetSortPropertyExpression
     */
    default EntitySetSortPropertyExpression<E> property(SerializableFunction<E, ?> property1,
            SerializableFunction<E, ?> property2, SerializableFunction<E, ?> property3) {
        EntitySetSortPropertyExpression<E> exp = property(property1);
        exp = exp.property(property2);
        return exp.property(property3);
    }

    /**
     * set sort(asc or desc) property .
     *
     * @param properties bean property array
     * @return EntitySetSortPropertyExpression
     */
    default EntitySetSortPropertyExpression<E> property(
            @SuppressWarnings("unchecked") SerializableFunction<E, ?>... properties) {
        EntitySetSortPropertyExpression<E> exp = null;
        for (SerializableFunction<E, ?> name : properties) {
            if (exp == null) {
                exp = property(name);
            } else {
                exp = exp.property(name);
            }
        }
        return exp;
    }
}
