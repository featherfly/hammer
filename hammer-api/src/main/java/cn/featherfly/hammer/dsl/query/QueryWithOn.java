
package cn.featherfly.hammer.dsl.query;

import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroupLogic;
import cn.featherfly.hammer.expression.query.QueryRelateOnExpression;

/**
 * <p>
 * dsl for query data
 * </p>
 *
 * @author zhongj
 */
public interface QueryWithOn extends
        QueryRelateOnExpression<QueryWith, QueryWithOn, QueryWithEntity, RepositoryQueryConditionsGroup, RepositoryQueryConditionsGroupLogic> {
}
