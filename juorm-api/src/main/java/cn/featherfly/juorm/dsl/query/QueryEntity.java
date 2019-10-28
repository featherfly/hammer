
package cn.featherfly.juorm.dsl.query;

import cn.featherfly.juorm.expression.query.QueryEntityExpression;

/**
 * <p>
 * dsl for query data
 * </p>
 *
 * @author zhongj
 */
public interface QueryEntity extends
        QueryEntityExpression<QueryEntityProperties, QueryWith, QueryWithOn, QueryWithEntity, QueryConditionGroupExpression, QueryConditionGroupLogicExpression, RepositoryQueryConditionGroupExpression, RepositoryQueryConditionGroupLogicExpression> {
}
