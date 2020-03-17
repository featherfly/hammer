
package cn.featherfly.hammer.dsl.query;

import cn.featherfly.hammer.expression.query.QueryWithEntityExpression;

/**
 * <p>
 * dsl for query data
 * </p>
 *
 * @author zhongj
 */
public interface QueryWithEntity extends
        QueryWithEntityExpression<QueryWith, QueryWithOn, QueryWithEntity, RepositoryQueryConditionGroupExpression, RepositoryQueryConditionGroupLogicExpression> {
}
