/*
 * All rights Reserved, Designed By zhongj
 * @Title: EndWithEntityCompatibleExpression.java
 * @Package cn.featherfly.hammer.expression.entity.compatible.condition.ew
 * @author: zhongj
 * @date: 2025-12-11 01:23:11
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.compatible.condition.ew;

import cn.featherfly.hammer.expression.entity.compatible.condition.MatchStringEntityPropertyCompatibleExpression;
import cn.featherfly.hammer.expression.entity.condition.ew.EndWithEntityExpression;

/**
 * The Interface EndWithEntityCompatibleExpression.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface EndWithEntityCompatibleExpression<E>
    extends EndWithEntityExpression<E>, MatchStringEntityPropertyCompatibleExpression<E> {

}
