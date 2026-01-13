/*
 * All rights Reserved, Designed By zhongj
 * @Title: LessThanEntityCompatibleExpression.java
 * @Package cn.featherfly.hammer.expression.entity.compatible.condition.lt
 * @author: zhongj
 * @date: 2025-12-11 01:25:11
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.compatible.condition.lt;

import cn.featherfly.hammer.expression.entity.compatible.condition.CompareEntityValuePropertyCompatibleExpression;
import cn.featherfly.hammer.expression.entity.condition.CompareEntityExpression;

/**
 * The Interface LessThanEntityCompatibleExpression.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface LessThanEntityCompatibleExpression<E>
    extends CompareEntityExpression<E>, CompareEntityValuePropertyCompatibleExpression<E> {
}
