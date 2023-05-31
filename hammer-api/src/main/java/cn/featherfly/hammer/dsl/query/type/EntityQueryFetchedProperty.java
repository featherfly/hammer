
package cn.featherfly.hammer.dsl.query.type;

import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression;
import cn.featherfly.hammer.expression.query.type.EntityQueryFetchedPropertyExpression;

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
