
package cn.featherfly.hammer.dsl.entity.query;

import cn.featherfly.hammer.expression.entity.query.EntityQueryExpression;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression;

/**
 * dsl for query entity.
 *
 * @author zhongj
 */
public interface EntityQuery<E, T extends EntityQuery<E, T>> extends EntityQueryExpression<E,
    EntityQueryConditionGroup<E>, EntityQueryConditionGroupLogic<E>, EntityQuerySortExpression<E>, T> {
}
