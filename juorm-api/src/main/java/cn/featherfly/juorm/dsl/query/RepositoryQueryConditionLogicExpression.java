
package cn.featherfly.juorm.dsl.query;

import cn.featherfly.juorm.expression.ConditionLogicExpression;
import cn.featherfly.juorm.expression.query.QueryConditionLimit;
import cn.featherfly.juorm.expression.query.QueryExecutor;
import cn.featherfly.juorm.expression.query.QueryValueExecutor;

/**
 * <p>
 * RepositoryQueryConditionLogic
 * </p>
 *
 * @author zhongj
 */
public interface RepositoryQueryConditionLogicExpression extends QueryConditionLimit, QueryExecutor, QueryValueExecutor,
        ConditionLogicExpression<RepositoryQueryConditionExpression, RepositoryQueryConditionLogicExpression> {

    /**
     * 结束当前条件并进入排序器
     *
     * @return QuerySortExpression
     */
    QuerySortExpression sort();
}
