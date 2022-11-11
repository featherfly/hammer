
package cn.featherfly.hammer.dsl.query.type;

import cn.featherfly.hammer.expression.query.type.EntityQueryEntityExpression;

/**
 * dsl for query entity.
 *
 * @author zhongj
 */
public interface EntityQueryEntity<E> extends EntityQuery<E>,
        EntityQueryEntityExpression<E, EntityQueryEntityProperties<E>, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>> {
}
