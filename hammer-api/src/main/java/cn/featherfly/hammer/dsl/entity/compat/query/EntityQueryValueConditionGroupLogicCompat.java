
package cn.featherfly.hammer.dsl.entity.compat.query;

import cn.featherfly.hammer.expression.entity.compatible.query.EntityQueryValueConditionGroupLogicCompatibleExpression;
import cn.featherfly.hammer.expression.entity.compatible.query.EntityQueryValueSortCompatibleExpression;

/**
 * The Interface EntityQueryValueConditionGroupLogic.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <V> the value type
 */
public interface EntityQueryValueConditionGroupLogicCompat<E, V>
    extends EntityQueryValueConditionGroupLogicCompatibleExpression<E, V, EntityQueryValueConditionGroupCompat<E, V>,
        EntityQueryValueConditionGroupLogicCompat<E, V>, EntityQueryValueSortCompatibleExpression<E, V>> {
}
