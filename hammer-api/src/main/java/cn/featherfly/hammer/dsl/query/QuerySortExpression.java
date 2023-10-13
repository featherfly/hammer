
package cn.featherfly.hammer.dsl.query;

import cn.featherfly.hammer.expression.query.QueryConditionLimit;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.query.sort.SortExpression;

/**
 * The Interface QuerySortExpression.
 *
 * @author zhongj
 */
public interface QuerySortExpression
        extends SortExpression<QuerySortExpression>, QueryConditionLimit, QueryLimitExecutor {

}
