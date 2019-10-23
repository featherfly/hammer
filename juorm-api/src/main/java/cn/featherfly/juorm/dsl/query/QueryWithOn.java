
package cn.featherfly.juorm.dsl.query;

import cn.featherfly.juorm.expression.query.QueryWithOnExpression;

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
