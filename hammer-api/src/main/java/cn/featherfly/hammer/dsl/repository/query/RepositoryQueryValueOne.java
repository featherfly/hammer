
package cn.featherfly.hammer.dsl.repository.query;

import cn.featherfly.hammer.expression.repository.query.RepositoryQueryValueOneExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryValueSortExpression;

/**
 * repository query value one.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <V> the value type
 */
public interface RepositoryQueryValueOne extends RepositoryQueryValueOneExpression<RepositoryQueryValueConditionsGroup,
        RepositoryQueryValueConditionsGroupLogic, RepositoryQueryValueSortExpression> {
}
