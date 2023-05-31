
package cn.featherfly.hammer.dsl.query.type;

import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression;
import cn.featherfly.hammer.expression.query.type.EntityQueryFetchExpression;

/**
 * dsl for entity query fetcher.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface EntityQueryFetch<E> extends EntityQuery<E>,
        EntityQueryFetchExpression<E, EntityQueryConditionGroup<E>, EntityQueryConditionGroupLogic<E>,
                EntityQueryFetchedProperty<E>, EntityQueryValueConditionGroup<E>,
                EntityQueryValueConditionGroupLogic<E>, EntityQuerySortExpression<E>> {

    //    /**
    //     * 结束当前条件并进入排序器.
    //     *
    //     * @return QuerySortExpression
    //     */
    //    EntityQuerySortExpression<E> sort();
}
