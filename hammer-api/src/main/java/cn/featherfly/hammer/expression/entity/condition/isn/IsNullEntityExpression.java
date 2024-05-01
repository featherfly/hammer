
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

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.hammer.expression.entity.condition.NullNotNullEntityExpression;

/**
 * The Interface IsNullEntityExpression.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface IsNullEntityExpression<E> extends NullNotNullEntityExpression<E> {

    /**
     * entity is null function property expression.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return entity is null function property expression
     */
    <R> IsNullEntityPropertyExpression<R> property(SerializableFunction<E, R> name);
}
