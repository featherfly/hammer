
package cn.featherfly.hammer.dsl.repository.query;

import cn.featherfly.hammer.expression.repository.query.RepositoryQueryConditionsGroupExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortExpression;

/**
 * repository query conditions group
 *
 * @author zhongj
 */
public interface RepositoryQueryConditionsGroup extends RepositoryQueryConditionsGroupExpression<
        RepositoryQueryConditionsGroup, RepositoryQueryConditionsGroupLogic, RepositoryQuerySortExpression> {

}
