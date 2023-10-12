
package cn.featherfly.hammer.dsl.entity.query;

import cn.featherfly.hammer.expression.entity.query.EntityQueryValueOneExpression;
import cn.featherfly.hammer.expression.entity.query.EntityQueryValueSortExpression;

/**
 * dsl for entity query value one.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <V> the value type
 */
public interface EntityQueryValueOne<E, V>
        extends EntityQueryValueOneExpression<E, V, EntityQueryValueConditionGroup<E, V>,
                EntityQueryValueConditionGroupLogic<E, V>, EntityQueryValueSortExpression<E, V>> {
}
