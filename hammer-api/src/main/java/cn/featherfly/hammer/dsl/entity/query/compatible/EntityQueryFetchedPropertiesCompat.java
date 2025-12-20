
package cn.featherfly.hammer.dsl.entity.query.compatible;

import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelateBase;
import cn.featherfly.hammer.expression.entity.compatible.query.EntityQueryFetchedPropertiesCompatibleExpression;

/**
 * dsl for entity query fetched properties.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface EntityQueryFetchedPropertiesCompat<E>
    extends EntityQueryRelateBase<E>, EntityQueryCompat<E, EntityQueryFetchedPropertiesCompat<E>>,
    EntityQueryFetchedPropertiesCompatibleExpression<E, EntityQueryFetchedPropertiesCompat<E>> {

}
