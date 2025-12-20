/*
 * All rights Reserved, Designed By zhongj
 * @Title: StartWithEntityCompatibleExpression.java
 * @Package cn.featherfly.hammer.expression.entity.compatible.condition.sw
 * @author: zhongj
 * @date: 2025-12-11 01:27:11
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.compatible.condition.sw;

import cn.featherfly.hammer.expression.entity.compatible.condition.MatchStringEntityPropertyCompatibleExpression;
import cn.featherfly.hammer.expression.entity.condition.sw.StartWithEntityExpression;

/**
 * The Interface StartWithEntityCompatibleExpression.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface StartWithEntityCompatibleExpression<E>
    extends StartWithEntityExpression<E>, MatchStringEntityPropertyCompatibleExpression<E> {

}
