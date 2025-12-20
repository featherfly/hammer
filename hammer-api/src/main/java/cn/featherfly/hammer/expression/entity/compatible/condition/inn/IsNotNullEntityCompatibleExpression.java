/*
 * All rights Reserved, Designed By zhongj
 * @Title: IsNullEntityCompatibleExpression.java
 * @Package cn.featherfly.hammer.expression.entity.compatible.condition.isn
 * @author: zhongj
 * @date: 2025-12-11 01:24:11
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.compatible.condition.inn;

import cn.featherfly.hammer.expression.condition.NullOrNotNullExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetIsNullOrIsNotNullValueExpression;
import cn.featherfly.hammer.expression.entity.condition.inn.IsNotNullEntityExpression;

/**
 * The Interface IsNotNullEntityCompatibleExpression.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface IsNotNullEntityCompatibleExpression<E> extends IsNotNullEntityExpression<E>, NullOrNotNullExpression {

    /**
     * entity is null function property expression.
     *
     * @param name the name
     * @return entity is null function property expression
     */
    SetIsNullOrIsNotNullValueExpression property(String name);
}
