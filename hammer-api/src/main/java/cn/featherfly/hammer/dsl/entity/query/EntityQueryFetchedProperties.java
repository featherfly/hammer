
package cn.featherfly.hammer.dsl.entity.query;

import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelateBase;
import cn.featherfly.hammer.expression.entity.query.EntityQueryFetchedPropertiesExpression;

/**
 * dsl for entity query fetched properties.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface EntityQueryFetchedProperties<E> extends EntityQueryRelateBase<E>, EntityQuery<E>,
        EntityQueryFetchedPropertiesExpression<E, EntityQueryFetchedProperties<E>> {

}
