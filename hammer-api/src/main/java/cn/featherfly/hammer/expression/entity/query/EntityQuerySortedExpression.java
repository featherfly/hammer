
package cn.featherfly.hammer.expression.entity.query;

import cn.featherfly.hammer.expression.entity.query.sort.EntitySortedExpression;

/**
 * The Interface EntityQuerySortExpression.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface EntityQuerySortedExpression<E> extends EntitySortedExpression<E, EntityQuerySortedExpression<E>>,
        EntityQueryConditionLimit<EntityQueryLimitExecutor<E>>, EntityQueryLimitExecutor<E> {

}
