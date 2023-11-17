
package cn.featherfly.hammer.dsl.query;

import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic;
import cn.featherfly.hammer.expression.query.QueryRelateExpression;

/**
 * <p>
 * dsl for query data
 * </p>
 *
 * @author zhongj
 */
public interface QueryWith extends
        QueryRelateExpression<QueryWith, QueryWithOn, QueryWithEntity, RepositoryQueryConditionsGroup, RepositoryQueryConditionsGroupLogic> {
}
