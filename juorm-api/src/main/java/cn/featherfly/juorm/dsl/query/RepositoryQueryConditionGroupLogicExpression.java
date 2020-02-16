
package cn.featherfly.juorm.dsl.query;

import cn.featherfly.juorm.expression.RepositoryConditionGroupLogicExpression;
import cn.featherfly.juorm.expression.query.QueryConditionLimit;
import cn.featherfly.juorm.expression.query.QueryCountExecutor;
import cn.featherfly.juorm.expression.query.QueryExecutor;
import cn.featherfly.juorm.expression.query.QueryValueExecutor;

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
