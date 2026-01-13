/*
 * All rights Reserved, Designed By zhongj
 * @Title: BetweenAndEntityPropertyCompatibleExpression.java
 * @Package cn.featherfly.hammer.expression.entity.compatible.condition
 * @author: zhongj
 * @date: 2025-12-11 01:27:11
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.compatible.condition;

import cn.featherfly.hammer.expression.entity.condition.BetweenAndEntityPropertyExpression;

/**
 * The Interface BetweenAndEntityPropertyExpression.
 *
 * @author zhongj
 * @param <V> the value type
 */
public interface BetweenAndEntityPropertyCompatibleExpression<V> extends BetweenAndEntityCompatibleExpression<V>,
    BetweenAndEntityPropertyExpression<V>, BetweenAndEntityValuePropertyCompatibleExpression<V> {

    /**
     * entity between and function property expression.
     *
     * @param <R> the generic type
     * @param name the name
     * @return entity between and function property expression.
     */
    <R> BetweenAndEntityPropertyCompatibleExpression<R> property(String name);
}
