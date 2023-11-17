
package cn.featherfly.hammer.dsl.query;

import cn.featherfly.hammer.expression.condition.ConditionsGroupLogicExpression;
import cn.featherfly.hammer.expression.query.QueryConditionLimit;
import cn.featherfly.hammer.expression.query.QueryCountExecutor;
import cn.featherfly.hammer.expression.query.QueryExecutor;
import cn.featherfly.hammer.expression.query.QueryValueOneExecutor;

/**
 * QueryConditionGroupLogic.
 *
 * @author zhongj
 */
public interface QueryConditionGroupLogicExpression
        extends QueryConditionLimit, QueryExecutor, QueryValueOneExecutor, QueryCountExecutor,
        ConditionsGroupLogicExpression<QueryConditionGroupExpression, QueryConditionGroupLogicExpression> {

    /**
     * 结束当前条件并进入排序器
     *
     * @return SortBuilder
     */
    QuerySortExpression sort();
}
