
package cn.featherfly.hammer.dsl.query;

import cn.featherfly.hammer.expression.query.QueryConditionLimit;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.query.sort.RepositorySortExpression;

/**
 * The Interface QuerySortExpression.
 *
 * @author zhongj
 */
public interface QuerySortExpression
        extends RepositorySortExpression<QuerySortExpression>, QueryConditionLimit, QueryLimitExecutor {

}
