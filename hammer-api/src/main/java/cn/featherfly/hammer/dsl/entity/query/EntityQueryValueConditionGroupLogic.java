
package cn.featherfly.hammer.dsl.entity.query;

import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression;
import cn.featherfly.hammer.expression.entity.query.EntityQueryValueConditionGroupLogicExpression;

/**
 * The Interface EntityQueryValueConditionGroupLogic.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface EntityQueryValueConditionGroupLogic<E> extends EntityQueryValueConditionGroupLogicExpression<E,
        EntityQueryValueConditionGroup<E>, EntityQueryValueConditionGroupLogic<E>, EntityQuerySortExpression<E>> {
}
