
package cn.featherfly.hammer.dsl.entity.query;

import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelateBase;
import cn.featherfly.hammer.expression.entity.query.EntityQueryPropertiesExpression;

/**
 * dsl for entity query fetcher.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface EntityQueryFetch<E> extends EntityQueryRelateBase<E>, EntityQuery<E>,
        EntityQueryPropertiesExpression<E, EntityQueryFetchedProperty<E>> {
}
