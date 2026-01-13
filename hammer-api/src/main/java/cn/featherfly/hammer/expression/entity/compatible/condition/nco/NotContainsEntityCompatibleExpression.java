/*
 * All rights Reserved, Designed By zhongj
 * @Title: NotContainsEntityCompatibleExpression.java
 * @Package cn.featherfly.hammer.expression.entity.compatible.condition.nco
 * @author: zhongj
 * @date: 2025-12-11 01:25:11
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.compatible.condition.nco;

import cn.featherfly.hammer.expression.entity.compatible.condition.MatchStringEntityPropertyCompatibleExpression;
import cn.featherfly.hammer.expression.entity.condition.nco.NotContainsEntityExpression;

/**
 * The Interface NotContainsEntityCompatibleExpression.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface NotContainsEntityCompatibleExpression<E>
    extends NotContainsEntityExpression<E>, MatchStringEntityPropertyCompatibleExpression<E> {

}
