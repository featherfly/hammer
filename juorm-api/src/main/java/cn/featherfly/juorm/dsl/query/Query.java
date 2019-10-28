
package cn.featherfly.juorm.dsl.query;

import cn.featherfly.juorm.expression.query.QueryExpression;

/**
 * <p>
 * dsl for query
 * </p>
 *
 * @author zhongj
 */
public interface Query extends
        QueryExpression<QueryEntity, QueryEntityProperties, QueryWith, QueryWithOn, QueryWithEntity, QueryConditionGroupExpression, QueryConditionGroupLogicExpression, RepositoryQueryConditionGroupExpression, RepositoryQueryConditionGroupLogicExpression, TypeQueryEntity, TypeQueryEntityProperties, TypeQueryWith, TypeQueryWithEntity, TypeQueryConditionGroupExpression, TypeQueryConditionGroupLogicExpression, RepositoryTypeQueryConditionGroupExpression, RepositoryTypeQueryConditionGroupLogicExpression> {
}
