/*
 * All rights Reserved, Designed By zhongj
 * @Title: NotEqualsEntityCompatibleExpression.java
 * @Package cn.featherfly.hammer.expression.entity.compatible.condition.ne
 * @author: zhongj
 * @date: 2025-12-11 01:25:11
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.compatible.condition.ne;

import cn.featherfly.hammer.expression.condition.field.CompareExpression;
import cn.featherfly.hammer.expression.entity.condition.ne.NotEqualsEntityExpression;

/**
 * The Interface NotEqualsEntityCompatibleExpression.
 *
 * @author zhongj
 * @param <T> the element type
 */
public interface NotEqualsEntityCompatibleExpression<T> extends NotEqualsEntityExpression<T>, CompareExpression {
}
