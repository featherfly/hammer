
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-03-05 17:10:05
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.condition.property;

import cn.featherfly.hammer.expression.condition.GroupEndExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * entity property only logic expression.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface EntityPropertyOnlyLogicExpression<E>
    extends LogicExpression<EntityPropertyOnlyExpression<E>, EntityPropertyOnlyLogicExpression<E>>,
    GroupEndExpression<EntityPropertyOnlyExpression<E>, EntityPropertyOnlyLogicExpression<E>> {

}
