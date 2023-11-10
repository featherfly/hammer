
/*
 * All rights Reserved, Designed By zhongj
 * @Title: Entities.java
 * @Package cn.featherfly.hammer.expression.entity.condition.eq
 * @Description: Entities
 * @author: zhongj
 * @date: 2023-07-18 14:44:18
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.repository.condition.isn;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.hammer.expression.repository.condition.NullNotNullRepositoryExpression;

/**
 * The Interface IsNullEntityExpression.
 *
 * @author zhongj
 */
public interface IsNullRepositoryExpression extends NullNotNullRepositoryExpression {

    /**
     * repository is null function property expression.
     *
     * @param name the name
     * @return entity is null function property expression
     */
    IsNullRepositoryPropertyExpression property(String name);

    /**
     * repository is null function property expression.
     *
     * @param <T>  the generic type
     * @param <R>  the generic type
     * @param name the name
     * @return entity is null function property expression
     */
    <T, R> IsNullRepositoryPropertyExpression property(SerializableFunction<T, R> name);
}
