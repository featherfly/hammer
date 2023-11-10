
package cn.featherfly.hammer.dsl.query;

import cn.featherfly.hammer.expression.query.QueryConditionLogicExpression;

/**
 * QueryConditionLogic.
 *
 * @author zhongj
 */
public interface QueryConditionLogic
        extends QueryConditionLogicExpression<QueryConditionExpression, QueryConditionLogic> {

    /**
     * 结束当前条件并进入排序器
     *
     * @return QuerySortExpression
     */
    QuerySortExpression sort();
}
