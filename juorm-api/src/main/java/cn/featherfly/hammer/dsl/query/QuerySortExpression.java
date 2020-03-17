
package cn.featherfly.hammer.dsl.query;

import cn.featherfly.hammer.expression.condition.SortExpression;
import cn.featherfly.hammer.expression.query.QueryConditionLimit;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;

/**
 * <p>
 * SortExpression
 * </p>
 *
 * @author zhongj
 */
public interface QuerySortExpression
        extends SortExpression<QuerySortExpression>, QueryConditionLimit,
        QueryLimitExecutor {

}
