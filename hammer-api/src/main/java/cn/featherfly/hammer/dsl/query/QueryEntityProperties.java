
package cn.featherfly.hammer.dsl.query;

import cn.featherfly.hammer.expression.query.QueryEntityPropertiesExpression;

/**
 * <p>
 * dsl for query data
 * </p>
 *
 * @author zhongj
 */
public interface QueryEntityProperties extends
        QueryEntityPropertiesExpression<QueryEntityProperties, QueryWith, QueryWithOn, QueryWithEntity, QueryConditionGroupExpression, QueryConditionGroupLogicExpression, RepositoryQueryConditionGroupExpression, RepositoryQueryConditionGroupLogicExpression> {
}
