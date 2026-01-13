/*
 * All rights Reserved, Designed By zhongj
 * @Title: EqualsEntityCompatibleExpression.java
 * @Package cn.featherfly.hammer.expression.entity.compatible.condition.eq
 * @author: zhongj
 * @date: 2025-12-11 01:23:11
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.compatible.condition.eq;

import cn.featherfly.hammer.expression.condition.field.CompareExpression;
import cn.featherfly.hammer.expression.entity.condition.eq.EqualsEntityExpression;

/**
 * The Interface EqualsEntityCompatibleExpression.
 *
 * @author zhongj
 * @param <T> the element type
 */
public interface EqualsEntityCompatibleExpression<T> extends EqualsEntityExpression<T>, CompareExpression {
}
