
package cn.featherfly.hammer.dsl.query;

import cn.featherfly.hammer.expression.ConditionLogicExpression;
import cn.featherfly.hammer.expression.query.QueryConditionLimit;
import cn.featherfly.hammer.expression.query.QueryCountExecutor;
import cn.featherfly.hammer.expression.query.QueryExecutor;
import cn.featherfly.hammer.expression.query.QueryValueExecutor;

/**
 * <p>
 * QueryConditionLogic
 * </p>
 *
 * @author zhongj
 */
public interface QueryConditionLogicExpression extends QueryConditionLimit,
        QueryExecutor, QueryValueExecutor, QueryCountExecutor,
        ConditionLogicExpression<QueryConditionExpression, QueryConditionLogicExpression> {

    /**
     * 结束当前条件并进入排序器
     *
     * @return QuerySortExpression
     */
    QuerySortExpression sort();
}
