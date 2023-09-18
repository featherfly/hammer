
/*
 * All rights Reserved, Designed By zhongj
 * @Title: Entities.java
 * @Package cn.featherfly.hammer.expression.entity.condition.eq
 * @Description: Entities
 * @author: zhongj
 * @date: 2023-07-18 14:44:18
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.condition.nba;

import cn.featherfly.hammer.expression.entity.condition.BetweenAndEntityExpression;

/**
 * The Interface NotBetweenEntityExpression.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface NotBetweenEntityExpression<E>
        extends BetweenAndEntityExpression<E>, NotBetweenEntityPropertyExpression<E> {
}
