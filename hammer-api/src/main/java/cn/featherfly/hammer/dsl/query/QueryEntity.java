
package cn.featherfly.hammer.dsl.query;

import cn.featherfly.hammer.expression.query.QueryEntityExpression;

/**
 * dsl for query data.
 *
 * @author zhongj
 */
public interface QueryEntity extends
        QueryEntityExpression<QueryEntityProperties, QueryWith, QueryWithOn, QueryWithEntity, QueryConditionGroupExpression, QueryConditionGroupLogicExpression, RepositoryQueryConditionGroupExpression, RepositoryQueryConditionGroupLogicExpression> {
}
