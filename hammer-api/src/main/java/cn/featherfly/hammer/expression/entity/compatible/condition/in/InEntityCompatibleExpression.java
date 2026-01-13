/*
 * All rights Reserved, Designed By zhongj
 * @Title: InEntityCompatibleExpression.java
 * @Package cn.featherfly.hammer.expression.entity.compatible.condition.in
 * @author: zhongj
 * @date: 2025-12-11 01:24:11
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.compatible.condition.in;

import cn.featherfly.hammer.expression.condition.InOrNotInExpression;
import cn.featherfly.hammer.expression.entity.condition.in.InEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.in.InEntityPropertyValueExpression;

/**
 * The Interface InEntityExpression.
 *
 * @author zhongj
 * @param <T> the element type
 */
public interface InEntityCompatibleExpression<T> extends InEntityExpression<T>, InOrNotInExpression {

    /**
     * entity in function property expression.
     *
     * @param <R> the generic type
     * @param name the name
     * @return entity in function property expression.
     */
    <R> InEntityPropertyValueExpression<R> property(String name);
}
