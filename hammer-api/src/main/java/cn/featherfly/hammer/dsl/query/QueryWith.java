
package cn.featherfly.hammer.dsl.query;

import cn.featherfly.hammer.expression.query.QueryRelateExpression;

/**
 * <p>
 * dsl for query data
 * </p>
 *
 * @author zhongj
 */
public interface QueryWith extends
        QueryRelateExpression<QueryWith, QueryWithOn, QueryWithEntity, RepositoryQueryConditionGroupExpression, RepositoryQueryConditionGroupLogicExpression> {
}
