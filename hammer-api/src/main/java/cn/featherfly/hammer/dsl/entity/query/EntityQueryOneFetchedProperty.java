
package cn.featherfly.hammer.dsl.entity.query;

import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelateBase;
import cn.featherfly.hammer.expression.entity.query.EntityQueryFetchedPropertiesExpression;

/**
 * dsl for entity query fetched property.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <V> the value type
 */
public interface EntityQueryOneFetchedProperty<E, V> extends EntityQueryRelateBase<E>, EntityQueryValueOne<E, V>,
        EntityQueryFetchedPropertiesExpression<E, EntityQueryFetchedProperties<E>> {

}
