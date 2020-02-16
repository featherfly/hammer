
package cn.featherfly.juorm.dsl.query;

import cn.featherfly.juorm.expression.ConditionGroupLogicExpression;
import cn.featherfly.juorm.expression.query.QueryConditionLimit;
import cn.featherfly.juorm.expression.query.QueryCountExecutor;
import cn.featherfly.juorm.expression.query.QueryExecutor;
import cn.featherfly.juorm.expression.query.QueryValueExecutor;

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
