
/*
 * All rights Reserved, Designed By zhongj
 * @Title: Entities.java
 * @Package cn.featherfly.hammer.expression.entity.condition.eq
 * @Description: Entities
 * @author: zhongj
 * @date: 2023-07-18 14:44:18
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.condition.le;

import cn.featherfly.hammer.expression.entity.condition.CompareEntityExpression;

/**
 * The Interface LessEqualsEntityExpression. less equals. 小于等于.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface LessEqualsEntityExpression<E>
        extends CompareEntityExpression<E>, LessEqualsEntityPropertyExpression<E> {
}
