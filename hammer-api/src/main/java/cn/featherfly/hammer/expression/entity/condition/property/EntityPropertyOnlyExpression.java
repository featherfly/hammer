
/*
 * All rights Reserved, Designed By zhongj
 * @Title: Entities.java
 * @Package cn.featherfly.hammer.expression.entity.condition.eq
 * @Description: Entities
 * @author: zhongj
 * @date: 2023-07-18 14:44:18
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.condition.property;

import cn.featherfly.hammer.expression.entity.condition.EntityPropertyExpression;

/**
 * entity property only expression .
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface EntityPropertyOnlyExpression<E>
        extends EntityPropertyExpression<E, EntityPropertyOnlyExpression<E>, EntityPropertyOnlyLogicExpression<E>> {
}
