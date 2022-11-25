
package cn.featherfly.hammer.dsl.query;

import cn.featherfly.hammer.dsl.query.type.EntityQueryEntity;
import cn.featherfly.hammer.expression.query.QueryExpression;

/**
 * <p>
 * dsl for query
 * </p>
 *
 * @author zhongj
 */
public interface Query extends
        QueryExpression<QueryEntity, QueryEntityProperties, QueryWith, QueryWithOn, QueryWithEntity, QueryConditionGroupExpression, QueryConditionGroupLogicExpression, RepositoryQueryConditionGroupExpression, RepositoryQueryConditionGroupLogicExpression, TypeQueryEntity, TypeQueryEntityProperties, TypeQueryWith, TypeQueryWithEntity, TypeQueryConditionGroupExpression, TypeQueryConditionGroupLogicExpression, RepositoryTypeQueryConditionGroupExpression, RepositoryTypeQueryConditionGroupLogicExpression> {

    <E> EntityQueryEntity<E> find(Class<E> repositoryType);
}
