
package cn.featherfly.hammer.dsl.entity.compat.query;

import cn.featherfly.hammer.expression.entity.compatible.query.EntityQueryValueConditionGroupCompatibleExpression;
import cn.featherfly.hammer.expression.entity.compatible.query.EntityQueryValueSortCompatibleExpression;

/**
 * The Interface EntityQueryValueConditionGroup.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface EntityQueryValueConditionGroupCompat<E, V>
    extends EntityQueryValueConditionGroupCompatibleExpression<E, V, EntityQueryValueConditionGroupCompat<E, V>,
        EntityQueryValueConditionGroupLogicCompat<E, V>, EntityQueryValueSortCompatibleExpression<E, V>> {

}
