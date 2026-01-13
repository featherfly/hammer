/*
 * All rights Reserved, Designed By zhongj
 * @Title: LessEqualsEntityCompatibleExpression.java
 * @Package cn.featherfly.hammer.expression.entity.compatible.condition.le
 * @author: zhongj
 * @date: 2025-12-11 01:24:11
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.compatible.condition.le;

import cn.featherfly.hammer.expression.entity.compatible.condition.CompareEntityValuePropertyCompatibleExpression;
import cn.featherfly.hammer.expression.entity.condition.CompareEntityExpression;

/**
 * The Interface LessEqualsEntityCompatibleExpression.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface LessEqualsEntityCompatibleExpression<E>
    extends CompareEntityExpression<E>, CompareEntityValuePropertyCompatibleExpression<E> {
}
