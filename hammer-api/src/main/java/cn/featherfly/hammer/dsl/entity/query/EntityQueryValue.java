
package cn.featherfly.hammer.dsl.entity.query;

import cn.featherfly.hammer.expression.entity.query.EntityQueryValueExpression;
import cn.featherfly.hammer.expression.entity.query.EntityQueryValueSortExpression;

/**
 * dsl for entity query value.
 *
 * @author zhongj
 * @param <E> the query entity type
 * @param <V> the fetch value type
 * @param <T> this expression
 */
public interface EntityQueryValue<E, V, T extends EntityQueryValue<E, V, T>>
    extends EntityQueryValueExpression<E, V, EntityQueryValueConditionGroup<E, V>,
        EntityQueryValueConditionGroupLogic<E, V>, EntityQueryValueSortExpression<E, V>, T> {
}
