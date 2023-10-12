
package cn.featherfly.hammer.dsl.entity.query;

import cn.featherfly.hammer.expression.entity.query.EntityQueryValueConditionGroupExpression;
import cn.featherfly.hammer.expression.entity.query.EntityQueryValueSortExpression;

/**
 * The Interface EntityQueryValueConditionGroup.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface EntityQueryValueConditionGroup<E, V>
        extends EntityQueryValueConditionGroupExpression<E, V, EntityQueryValueConditionGroup<E, V>,
                EntityQueryValueConditionGroupLogic<E, V>, EntityQueryValueSortExpression<E, V>> {

}
