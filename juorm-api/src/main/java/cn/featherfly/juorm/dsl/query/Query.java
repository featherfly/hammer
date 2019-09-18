
package cn.featherfly.juorm.dsl.query;

import cn.featherfly.juorm.expression.query.QueryExpression;

/**
 * <p>
 * dsl for query
 * </p>
 *
 * @author zhongj
 */
public interface Query extends
        QueryExpression<QueryEntity, QueryEntityProperties, QueryWith, QueryWithOn, QueryWithEntity, QueryConditionGroupExpression, QueryConditionGroupLogicExpression, TypeQueryEntity, TypeQueryEntityProperties, TypeQueryWith, TypeQueryWithOn, TypeQueryWithEntity, TypeQueryConditionGroupExpression, TypeQueryConditionGroupLogicExpression> {
}
