
package cn.featherfly.hammer.dsl.query;

import cn.featherfly.hammer.expression.condition.EntityConditionsExpression;

/**
 * The Interface EntityQueryConditionExpression.
 *
 * @author zhongj
 */
public interface EntityQueryConditionExpression<E> extends
        EntityConditionsExpression<E, EntityQueryConditionExpression<E>, EntityQueryConditionLogicExpression<E>> {
}
