
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

import cn.featherfly.common.lang.function.SerializableFunction;

/**
 * The Interface SortEntityExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <S> the generic type
 */
public interface SortEntityExpression<E> {

    /**
     * apply sort(asc or desc) property.
     *
     * @param <R>  the generic type
     * @param name 名称
     * @return this
     */
    <R> SortEntityExpression<E> accept(SerializableFunction<E, R> name);

    /**
     * apply sort(asc or desc) property .
     *
     * @param names 名称
     * @return this
     */
    SortEntityExpression<E> accept(@SuppressWarnings("unchecked") SerializableFunction<E, ?>... names);
}
