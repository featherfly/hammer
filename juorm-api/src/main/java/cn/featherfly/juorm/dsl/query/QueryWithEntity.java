
package cn.featherfly.juorm.dsl.query;

import cn.featherfly.juorm.expression.query.QueryWithEntityExpression;

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
