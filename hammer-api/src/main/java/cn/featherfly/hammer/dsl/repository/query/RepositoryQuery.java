
package cn.featherfly.hammer.dsl.repository.query;

import cn.featherfly.hammer.expression.repository.query.RepositoryQueryExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression;

/**
 * repository query.
 *
 * @author zhongj
 */
public interface RepositoryQuery extends RepositoryQueryExpression<RepositoryQueryConditionsGroup,
        RepositoryQueryConditionsGroupLogic, RepositoryQuerySortExpression> {
}
