
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

import java.util.function.Function;

import cn.featherfly.common.lang.function.SerializableFunction;

/**
 * The Interface SortEntityExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <S> the generic type
 */
@FunctionalInterface
public interface SortEntityExpression<E> extends Function<SerializableFunction<E, ?>, SortEntityExpression<E>> {

    /**
     * apply sort(asc or desc) property .
     *
     * @param names 名称
     * @return this
     */
    default SortEntityExpression<E> apply(@SuppressWarnings("unchecked") SerializableFunction<E, ?>... names) {
        SortEntityExpression<E> exp = null;
        for (SerializableFunction<E, ?> name : names) {
            if (exp == null) {
                exp = apply(name);
            } else {
                exp = exp.apply(name);
            }
        }
        return exp;
    }
}
