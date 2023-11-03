
/*
 * All rights Reserved, Designed By zhongj
 * @Title: Entities.java
 * @Package cn.featherfly.hammer.expression.entity.condition.eq
 * @Description: Entities
 * @author: zhongj
 * @date: 2023-07-18 14:44:18
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.condition.in;

import java.util.Collection;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableToCollectionFunction;
import cn.featherfly.hammer.expression.entity.condition.InNotInEntityExpression;

/**
 * The Interface InEntityExpression.
 *
 * @author zhongj
 * @param <T> the element type
 */
public interface InEntityExpression<T> extends InNotInEntityExpression<T> {

    /**
     * entity in function property expression.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return entity in function property expression.
     */
    <R> InEntityPropertyExpression<R> property(SerializableFunction<T, R> name);

    /**
     * entity in function property expression.
     *
     * @param <R>  the generic type
     * @param <E>  the generic type
     * @param name the name
     * @return entity in function property expression.
     */
    <R extends Collection<E>, E> InEntityPropertyExpression<E> property(SerializableToCollectionFunction<T, R, E> name);
}
