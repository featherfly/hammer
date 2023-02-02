
package cn.featherfly.hammer.dsl.query;

import cn.featherfly.hammer.expression.condition.SortExpression;
import cn.featherfly.hammer.expression.query.QueryConditionLimit;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;

/**
 * The Interface QuerySortExpression.
 *
 * @author zhongj
 */
public interface QuerySortExpression
        extends SortExpression<QuerySortExpression>, QueryConditionLimit, QueryLimitExecutor {

}
