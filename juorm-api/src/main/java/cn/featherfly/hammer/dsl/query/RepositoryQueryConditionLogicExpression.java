
package cn.featherfly.hammer.dsl.query;

import cn.featherfly.hammer.expression.ConditionLogicExpression;
import cn.featherfly.hammer.expression.query.QueryConditionLimit;
import cn.featherfly.hammer.expression.query.QueryCountExecutor;
import cn.featherfly.hammer.expression.query.QueryExecutor;
import cn.featherfly.hammer.expression.query.QueryValueExecutor;

/**
 * <p>
 * RepositoryQueryConditionLogic
 * </p>
 *
 * @author zhongj
 */
public interface RepositoryQueryConditionLogicExpression
        extends QueryConditionLimit, QueryExecutor, QueryValueExecutor,
        QueryCountExecutor,
        ConditionLogicExpression<RepositoryQueryConditionExpression, RepositoryQueryConditionLogicExpression> {

    /**
     * 结束当前条件并进入排序器
     *
     * @return QuerySortExpression
     */
    QuerySortExpression sort();
}
