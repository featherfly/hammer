
package cn.featherfly.hammer.dsl.entity.query;

import cn.featherfly.hammer.expression.entity.query.EntityQueryFetchedPropertyExpression;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression;

/**
 * dsl for entity query fetcher fetched.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface EntityQueryFetchedProperty<E>
        extends EntityQueryFetchedPropertyExpression<E, EntityQueryValueConditionGroup<E>,
                EntityQueryValueConditionGroupLogic<E>, EntityQueryFetchedProperty<E>, EntityQuerySortExpression<E>> {

}
