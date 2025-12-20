/*
 * All rights Reserved, Designed By zhongj
 * @Title: GreatEqualsEntityCompatibleExpression.java
 * @Package cn.featherfly.hammer.expression.entity.compatible.condition.ge
 * @author: zhongj
 * @date: 2025-12-11 01:24:11
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.compatible.condition.ge;

import cn.featherfly.hammer.expression.entity.compatible.condition.CompareEntityValuePropertyCompatibleExpression;
import cn.featherfly.hammer.expression.entity.condition.CompareEntityExpression;

/**
 * The Interface GreatEqualsEntityCompatibleExpression.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface GreatEqualsEntityCompatibleExpression<E>
    extends CompareEntityExpression<E>, CompareEntityValuePropertyCompatibleExpression<E> {
}
