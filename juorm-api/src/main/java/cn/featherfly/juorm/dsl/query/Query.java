
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
        QueryExpression<QueryEntity, QueryEntityProperties, QueryConditionGroupExpression, QueryConditionGroupLogicExpression, TypeQueryEntity, TypeQueryEntityProperties, TypeQueryConditionGroupExpression, TypeQueryConditionGroupLogicExpression> {
}
