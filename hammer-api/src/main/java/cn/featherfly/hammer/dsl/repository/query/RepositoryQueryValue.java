
package cn.featherfly.hammer.dsl.repository.query;

import cn.featherfly.hammer.expression.repository.query.RepositoryQueryValueExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryValueSortExpression;

/**
 * repository query value.
 *
 * @author zhongj
 */
public interface RepositoryQueryValue extends RepositoryQueryValueExpression<RepositoryQueryValueConditionsGroup,
        RepositoryQueryValueConditionsGroupLogic, RepositoryQueryValueSortExpression> {
}
