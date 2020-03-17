
package cn.featherfly.hammer.dsl.query;

import cn.featherfly.hammer.expression.RepositoryConditionGroupLogicExpression;
import cn.featherfly.hammer.expression.query.QueryConditionLimit;
import cn.featherfly.hammer.expression.query.QueryCountExecutor;
import cn.featherfly.hammer.expression.query.QueryExecutor;
import cn.featherfly.hammer.expression.query.QueryValueExecutor;

/**
 * <p>
 * RepositoryQueryConditionGroupLogic
 * </p>
 *
 * @author zhongj
 */
public interface RepositoryQueryConditionGroupLogicExpression
        extends QueryConditionLimit, QueryExecutor, QueryValueExecutor,
        QueryCountExecutor,
        RepositoryConditionGroupLogicExpression<RepositoryQueryConditionGroupExpression, RepositoryQueryConditionGroupLogicExpression> {

    /**
     * 结束当前条件并进入排序器
     *
     * @return SortBuilder
     */
    QuerySortExpression sort();
}
