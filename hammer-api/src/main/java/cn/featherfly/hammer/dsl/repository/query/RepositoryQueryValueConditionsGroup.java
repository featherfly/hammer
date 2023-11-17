
package cn.featherfly.hammer.dsl.repository.query;

import cn.featherfly.hammer.expression.repository.query.RepositoryQueryValueConditionsGroupExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryValueSortExpression;

/**
 * repository query value conditions group.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface RepositoryQueryValueConditionsGroup
        extends RepositoryQueryValueConditionsGroupExpression<RepositoryQueryValueConditionsGroup,
                RepositoryQueryValueConditionsGroupLogic, RepositoryQueryValueSortExpression> {

}
