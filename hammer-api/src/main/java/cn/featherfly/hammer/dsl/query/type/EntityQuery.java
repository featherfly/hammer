
package cn.featherfly.hammer.dsl.query.type;

import cn.featherfly.hammer.expression.query.type.EntityQueryExpression;

/**
 * dsl for query entity.
 *
 * @author zhongj
 */
public interface EntityQuery<E> extends
        EntityQueryExpression<E, EntityQueryEntityProperties<E>, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>> {
}
