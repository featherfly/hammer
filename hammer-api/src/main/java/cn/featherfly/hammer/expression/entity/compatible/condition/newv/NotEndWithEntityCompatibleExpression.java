/*
 * All rights Reserved, Designed By zhongj
 * @Title: NotEndWithEntityCompatibleExpression.java
 * @Package cn.featherfly.hammer.expression.entity.compatible.condition.newv
 * @author: zhongj
 * @date: 2025-12-11 01:26:11
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.compatible.condition.newv;

import cn.featherfly.hammer.expression.entity.compatible.condition.MatchStringEntityPropertyCompatibleExpression;
import cn.featherfly.hammer.expression.entity.condition.newv.NotEndWithEntityExpression;

/**
 * The Interface NotEndWithEntityCompatibleExpression.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface NotEndWithEntityCompatibleExpression<E>
    extends NotEndWithEntityExpression<E>, MatchStringEntityPropertyCompatibleExpression<E> {

}
