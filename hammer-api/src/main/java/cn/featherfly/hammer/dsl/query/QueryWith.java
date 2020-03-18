
package cn.featherfly.hammer.dsl.query;

import cn.featherfly.hammer.expression.query.QueryWithExpression;

/**
 * <p>
 * dsl for query data
 * </p>
 *
 * @author zhongj
 */
public interface QueryWith extends
        QueryWithExpression<QueryWith, QueryWithOn, QueryWithEntity, RepositoryQueryConditionGroupExpression, RepositoryQueryConditionGroupLogicExpression> {
}
