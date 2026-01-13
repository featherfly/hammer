
/*
 * All rights Reserved, Designed By zhongj
 * @Title: Entities.java
 * @Package cn.featherfly.hammer.expression.entity.condition.eq
 * @Description: Entities
 * @author: zhongj
 * @date: 2023-07-18 14:44:18
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.compatible.condition.co;

import cn.featherfly.hammer.expression.entity.compatible.condition.MatchStringEntityPropertyCompatibleExpression;
import cn.featherfly.hammer.expression.entity.condition.co.ContainsEntityExpression;

/**
 * The Interface ContainsEntityCompatibleExpression.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface ContainsEntityCompatibleExpression<E>
    extends ContainsEntityExpression<E>, MatchStringEntityPropertyCompatibleExpression<E> {

}
