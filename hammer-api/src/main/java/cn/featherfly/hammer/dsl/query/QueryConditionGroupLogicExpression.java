
package cn.featherfly.hammer.dsl.query;

import cn.featherfly.hammer.expression.ConditionGroupLogicExpression;
import cn.featherfly.hammer.expression.query.QueryConditionLimit;
import cn.featherfly.hammer.expression.query.QueryCountExecutor;
import cn.featherfly.hammer.expression.query.QueryExecutor;
import cn.featherfly.hammer.expression.query.QueryValueExecutor;

/**
 * <p>
 * QueryConditionGroupLogic
 * </p>
 *
 * @author zhongj
 */
public interface QueryConditionGroupLogicExpression extends QueryConditionLimit,
        QueryExecutor, QueryValueExecutor, QueryCountExecutor,
        ConditionGroupLogicExpression<QueryConditionGroupExpression, QueryConditionGroupLogicExpression> {

    /**
     * 结束当前条件并进入排序器
     *
     * @return SortBuilder
     */
    QuerySortExpression sort();
}
