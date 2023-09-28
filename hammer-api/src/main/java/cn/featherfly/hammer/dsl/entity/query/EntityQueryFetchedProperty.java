
package cn.featherfly.hammer.dsl.entity.query;

import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelateBase;
import cn.featherfly.hammer.expression.entity.query.EntityQueryExpression;
import cn.featherfly.hammer.expression.entity.query.EntityQueryPropertiesExpression;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression;
import cn.featherfly.hammer.expression.query.QueryValueExecutor;

/**
 * dsl for entity query fetcher fetched.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface EntityQueryFetchedProperty<E> extends EntityQueryRelateBase<E>,
        //        EntityQueryFetch<E>,
        EntityQueryExpression<E, EntityQueryValueConditionGroup<E>, EntityQueryValueConditionGroupLogic<E>,
                EntityQuerySortExpression<E>>,
        EntityQueryPropertiesExpression<E, EntityQueryFetchedProperty<E>>, QueryValueExecutor
//        extends EntityQueryFetchedPropertyExpression<E, EntityQueryValueConditionGroup<E>,
//                EntityQueryValueConditionGroupLogic<E>, EntityQueryFetchedProperty<E>, EntityQuerySortExpression<E>>
{

}
