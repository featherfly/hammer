/*
 * All rights Reserved, Designed By zhongj
 * @Title: NotStartWithEntityCompatibleExpression.java
 * @Package cn.featherfly.hammer.expression.entity.compatible.condition.nsw
 * @author: zhongj
 * @date: 2025-12-11 01:26:11
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.compatible.condition.nsw;

import cn.featherfly.hammer.expression.entity.compatible.condition.MatchStringEntityPropertyCompatibleExpression;
import cn.featherfly.hammer.expression.entity.condition.nsw.NotStartWithEntityExpression;

/**
 * The Interface StartWithEntityCompatibleExpression.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface NotStartWithEntityCompatibleExpression<E>
    extends NotStartWithEntityExpression<E>, MatchStringEntityPropertyCompatibleExpression<E> {

}
