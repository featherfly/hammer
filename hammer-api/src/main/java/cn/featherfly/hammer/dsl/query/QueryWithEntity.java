
package cn.featherfly.hammer.dsl.query;

import cn.featherfly.hammer.expression.query.QueryRelateEntityExpression;

/**
 * <p>
 * dsl for query data
 * </p>
 *
 * @author zhongj
 */
public interface QueryWithEntity extends
        QueryRelateEntityExpression<QueryWith, QueryWithOn, QueryWithEntity, RepositoryQueryConditionGroupExpression, RepositoryQueryConditionGroupLogicExpression> {
}
