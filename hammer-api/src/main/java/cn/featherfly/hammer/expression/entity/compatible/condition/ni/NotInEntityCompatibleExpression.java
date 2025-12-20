/*
 * All rights Reserved, Designed By zhongj
 * @Title: NotInEntityCompatibleExpression.java
 * @Package cn.featherfly.hammer.expression.entity.compatible.condition.ni
 * @author: zhongj
 * @date: 2025-12-11 01:26:11
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.compatible.condition.ni;

import cn.featherfly.hammer.expression.condition.InOrNotInExpression;
import cn.featherfly.hammer.expression.entity.condition.ni.NotInEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.ni.NotInEntityPropertyValueExpression;

/**
 * The Interface NotInEntityExpression.
 *
 * @author zhongj
 * @param <T> the element type
 */
public interface NotInEntityCompatibleExpression<T> extends NotInEntityExpression<T>, InOrNotInExpression {

    /**
     * entity in function property expression.
     *
     * @param <R> the generic type
     * @param name the name
     * @return entity in function property expression.
     */
    <R> NotInEntityPropertyValueExpression<R> property(String name);
}
