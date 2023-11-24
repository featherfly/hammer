
package cn.featherfly.hammer.dsl.repository.query;

import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsLogicExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression;

/**
 * repository query conditions logic
 *
 * @author zhongj
 */
public interface RepositoryQueryConditionsLogic extends RepositoryQueryConditionsLogicExpression<
        RepositoryQueryConditions, RepositoryQueryConditionsLogic, RepositoryQuerySortExpression> {
}
