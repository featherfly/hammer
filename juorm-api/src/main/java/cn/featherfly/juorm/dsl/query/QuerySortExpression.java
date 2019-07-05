
package cn.featherfly.juorm.dsl.query;

import cn.featherfly.juorm.expression.condition.SortExpression;
import cn.featherfly.juorm.expression.query.QueryConditionLimit;
import cn.featherfly.juorm.expression.query.QueryExecutor;
import cn.featherfly.juorm.expression.query.QueryValueExecutor;

/**
 * <p>
 * SortExpression
 * </p>
 *
 * @author zhongj
 */
public interface QuerySortExpression
        extends SortExpression<QuerySortExpression>, QueryConditionLimit, QueryExecutor, QueryValueExecutor {

}
