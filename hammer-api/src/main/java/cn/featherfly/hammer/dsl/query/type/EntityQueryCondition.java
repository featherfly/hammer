
package cn.featherfly.hammer.dsl.query.type;

import cn.featherfly.hammer.expression.entity.condition.EntityConditionsExpression;

/**
 * The Interface EntityQueryConditionExpression.
 *
 * @author zhongj
 */
public interface EntityQueryCondition<E> extends
        EntityConditionsExpression<E, EntityQueryCondition<E>, EntityQueryConditionLogicExpression<E>> {
}
