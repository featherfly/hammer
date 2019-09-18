
package cn.featherfly.juorm.dsl.query;

import cn.featherfly.juorm.expression.query.QueryWithExpression;

/**
 * <p>
 * dsl for query data
 * </p>
 *
 * @author zhongj
 */
public interface QueryWith extends
        QueryWithExpression<QueryWith, QueryWithOn, QueryWithEntity, QueryConditionGroupExpression, QueryConditionGroupLogicExpression> {
}
