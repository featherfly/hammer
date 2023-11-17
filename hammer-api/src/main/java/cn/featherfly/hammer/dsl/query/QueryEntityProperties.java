
package cn.featherfly.hammer.dsl.query;

import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic;
import cn.featherfly.hammer.expression.query.QueryEntityPropertiesExpression;

/**
 * <p>
 * dsl for query data
 * </p>
 *
 * @author zhongj
 */
public interface QueryEntityProperties extends
        QueryEntityPropertiesExpression<QueryEntityProperties, QueryWith, QueryWithOn, QueryWithEntity, QueryConditionGroupExpression, QueryConditionGroupLogicExpression, RepositoryQueryConditionsGroup, RepositoryQueryConditionsGroupLogic> {
}
