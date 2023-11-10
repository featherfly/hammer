
package cn.featherfly.hammer.expression.repository.query;

import cn.featherfly.hammer.expression.query.QueryValueConditionLimit;
import cn.featherfly.hammer.expression.query.QueryValueOneExecutor;
import cn.featherfly.hammer.expression.repository.query.sort.RepositorySortedExpression;

/**
 * repository query value sorted expression.
 *
 * @author zhongj
 */
public interface RepositoryQueryValueSortedExpression
        extends RepositorySortedExpression<RepositoryQueryValueSortedExpression>, QueryValueConditionLimit,
        QueryValueOneExecutor {

}
