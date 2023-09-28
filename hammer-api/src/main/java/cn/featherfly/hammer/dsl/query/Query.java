
package cn.featherfly.hammer.dsl.query;

import cn.featherfly.hammer.dsl.entity.query.EntityQueryFetch;
import cn.featherfly.hammer.expression.query.QueryExpression;

/**
 * dsl for query.
 *
 * @author zhongj
 */
public interface Query extends
        QueryExpression<QueryEntity, QueryEntityProperties, QueryWith, QueryWithOn, QueryWithEntity,
                QueryConditionGroupExpression, QueryConditionGroupLogicExpression,
                RepositoryQueryConditionGroupExpression, RepositoryQueryConditionGroupLogicExpression
//                ,
//                TypeQueryEntity, TypeQueryEntityProperties, TypeQueryWith, TypeQueryWithEntity, TypeQueryConditionGroupExpression,TypeQueryConditionGroupLogicExpression,
//                RepositoryTypeQueryConditionGroupExpression, RepositoryTypeQueryConditionGroupLogicExpression
> {

    /**
     * start query dsl for entity.
     *
     * @param <E>    the element type
     * @param entity the entity
     * @return the entity query fetch
     */
    <E> EntityQueryFetch<E> find(Class<E> entity);
}
