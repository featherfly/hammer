
/*
 * All rights Reserved, Designed By zhongj
 * @Title: Entities.java
 * @Package cn.featherfly.hammer.expression.entity.condition.eq
 * @Description: Entities
 * @author: zhongj
 * @date: 2023-07-18 14:44:18
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.condition.ba;

import cn.featherfly.hammer.expression.entity.condition.BetweenAndEntityExpression;

/**
 * The Interface BetweenEntityExpression.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface BetweenEntityExpression<E> extends BetweenAndEntityExpression<E>, BetweenEntityPropertyExpression<E> {
}
