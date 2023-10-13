
package cn.featherfly.hammer.dsl.entity.query;

import cn.featherfly.hammer.expression.entity.query.EntityQueryValueConditionGroupLogicExpression;
import cn.featherfly.hammer.expression.entity.query.EntityQueryValueSortExpression;

/**
 * The Interface EntityQueryValueConditionGroupLogic.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <V> the value type
 */
public interface EntityQueryValueConditionGroupLogic<E, V>
        extends EntityQueryValueConditionGroupLogicExpression<E, V, EntityQueryValueConditionGroup<E, V>,
                EntityQueryValueConditionGroupLogic<E, V>, EntityQueryValueSortExpression<E, V>> {
}
