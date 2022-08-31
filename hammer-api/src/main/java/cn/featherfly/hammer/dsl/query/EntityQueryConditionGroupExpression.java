
package cn.featherfly.hammer.dsl.query;

import cn.featherfly.hammer.expression.EntityConditionGroupExpression;

/**
 * The Interface EntityQueryConditionGroupExpression.
 *
 * @author zhongj
 */
public interface EntityQueryConditionGroupExpression<E> extends
        EntityConditionGroupExpression<E, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>> {

}
