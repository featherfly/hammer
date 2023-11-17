
package cn.featherfly.hammer.dsl.repository.query;

import cn.featherfly.hammer.expression.repository.query.RepositoryQueryValueConditionsGroupLogicExpression;
import cn.featherfly.hammer.expression.repository.query.RepositoryQueryValueSortExpression;

/**
 * repository query value conditions group logic.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <V> the value type
 */
public interface RepositoryQueryValueConditionsGroupLogic
        extends RepositoryQueryValueConditionsGroupLogicExpression<RepositoryQueryValueConditionsGroup,
                RepositoryQueryValueConditionsGroupLogic, RepositoryQueryValueSortExpression> {
}
