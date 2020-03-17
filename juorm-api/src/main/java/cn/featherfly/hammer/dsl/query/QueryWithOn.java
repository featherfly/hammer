
package cn.featherfly.hammer.dsl.query;

import cn.featherfly.hammer.expression.query.QueryWithOnExpression;

/**
 * <p>
 * dsl for query data
 * </p>
 *
 * @author zhongj
 */
public interface QueryWithOn extends
        QueryWithOnExpression<QueryWith, QueryWithOn, QueryWithEntity, RepositoryQueryConditionGroupExpression, RepositoryQueryConditionGroupLogicExpression> {
}
