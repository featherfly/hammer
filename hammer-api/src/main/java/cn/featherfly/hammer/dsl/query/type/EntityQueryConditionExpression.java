
package cn.featherfly.hammer.dsl.query.type;

import cn.featherfly.hammer.expression.condition.type.EntityConditionsExpression;

/**
 * The Interface EntityQueryConditionExpression.
 *
 * @author zhongj
 */
public interface EntityQueryConditionExpression<E> extends
        EntityConditionsExpression<E, EntityQueryConditionExpression<E>, EntityQueryConditionLogicExpression<E>> {
}
