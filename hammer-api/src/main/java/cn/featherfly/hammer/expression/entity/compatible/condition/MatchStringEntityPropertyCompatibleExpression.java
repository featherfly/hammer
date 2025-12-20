/*
 * All rights Reserved, Designed By zhongj
 * @Title: MatchStringEntityPropertyCompatibleExpression.java
 * @Package cn.featherfly.hammer.expression.entity.compatible.condition
 * @author: zhongj
 * @date: 2025-12-11 01:27:11
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.compatible.condition;

import cn.featherfly.hammer.expression.condition.field.MatchStringExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetStringFuzzyQueryExpression;

/**
 * The Interface MatchStringEntityExpression.
 *
 * @author zhongj
 * @param <T> the element type
 */
public interface MatchStringEntityPropertyCompatibleExpression<T> extends MatchStringExpression {

    /**
     * entity match string function string property expression.
     *
     * @param name the name
     * @return entity match string function property expression
     */
    SetStringFuzzyQueryExpression property(String name);
}
