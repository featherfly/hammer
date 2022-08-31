
package cn.featherfly.hammer.dsl.query;

import cn.featherfly.hammer.expression.query.EntityQueryEntityExpression;

/**
 * dsl for query entity.
 *
 * @author zhongj
 */
public interface EntityQueryEntity<E> extends
        EntityQueryEntityExpression<E, EntityQueryEntityProperties<E>, EntityQueryWith<E>, EntityQueryWithEntity<E>, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>> {
}
