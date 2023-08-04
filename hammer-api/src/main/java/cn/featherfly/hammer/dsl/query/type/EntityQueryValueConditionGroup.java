
package cn.featherfly.hammer.dsl.query.type;

import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression;
import cn.featherfly.hammer.expression.entity.query.EntityQueryValueConditionGroupExpression;

/**
 * The Interface EntityQueryValueConditionGroup.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface EntityQueryValueConditionGroup<E> extends EntityQueryValueConditionGroupExpression<E,
        EntityQueryValueConditionGroup<E>, EntityQueryValueConditionGroupLogic<E>, EntityQuerySortExpression<E>> {

}
