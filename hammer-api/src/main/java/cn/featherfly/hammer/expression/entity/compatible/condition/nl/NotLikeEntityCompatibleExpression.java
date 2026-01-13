/*
 * All rights Reserved, Designed By zhongj
 * @Title: NotLikeEntityCompatibleExpression.java
 * @Package cn.featherfly.hammer.expression.entity.compatible.condition.nl
 * @author: zhongj
 * @date: 2025-12-11 01:26:11
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.compatible.condition.nl;

import cn.featherfly.hammer.expression.entity.compatible.condition.MatchStringEntityPropertyCompatibleExpression;
import cn.featherfly.hammer.expression.entity.condition.nl.NotLikeEntityExpression;

/**
 * The Interface NotLikeEntityCompatibleExpression.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface NotLikeEntityCompatibleExpression<E>
    extends NotLikeEntityExpression<E>, MatchStringEntityPropertyCompatibleExpression<E> {

}
