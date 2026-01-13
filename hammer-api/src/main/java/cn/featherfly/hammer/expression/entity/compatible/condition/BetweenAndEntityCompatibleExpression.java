/*
 * All rights Reserved, Designed By zhongj
 * @Title: BetweenAndEntityCompatibleExpression.java
 * @Package cn.featherfly.hammer.expression.entity.compatible.condition
 * @author: zhongj
 * @date: 2025-12-11 01:27:11
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.compatible.condition;

import cn.featherfly.hammer.expression.condition.BetweenAndExpression;
import cn.featherfly.hammer.expression.entity.condition.BetweenAndEntityExpression;

/**
 * between and entity expression.
 *
 * @author zhongj
 * @param <T> the element type
 */
public interface BetweenAndEntityCompatibleExpression<T> extends BetweenAndEntityExpression<T>, BetweenAndExpression {
}
