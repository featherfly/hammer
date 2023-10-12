
package cn.featherfly.hammer.dsl.entity.query;

import cn.featherfly.hammer.expression.entity.query.EntityQueryValueExpression;
import cn.featherfly.hammer.expression.entity.query.EntityQueryValueSortExpression;

/**
 * dsl for entity query value.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <V> the value type
 */
public interface EntityQueryValue<E, V> extends EntityQueryValueExpression<E, V, EntityQueryValueConditionGroup<E, V>,
        EntityQueryValueConditionGroupLogic<E, V>, EntityQueryValueSortExpression<E, V>> {
}
