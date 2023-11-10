
package cn.featherfly.hammer.dsl.repository.query;

import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression;

/**
 * repository query conditions
 *
 * @author zhongj
 */
public interface RepositoryQueryConditions extends RepositoryQueryConditionsExpression<RepositoryQueryConditions,
        RepositoryQueryConditionsLogic, RepositoryQuerySortExpression> {

}
