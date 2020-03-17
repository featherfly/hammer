
package cn.featherfly.hammer.dsl.query;

import cn.featherfly.hammer.expression.ConditionLogicExpression;
import cn.featherfly.hammer.expression.query.TypeQueryConditionLimit;
import cn.featherfly.hammer.expression.query.TypeQueryExecutor;

/**
 * <p>
 * RepositoryQueryConditionLogic
 * </p>
 *
 * @author zhongj
 */
public interface RepositoryTypeQueryConditionLogicExpression extends TypeQueryConditionLimit, TypeQueryExecutor,
        ConditionLogicExpression<RepositoryTypeQueryConditionExpression, RepositoryTypeQueryConditionLogicExpression> {

    /**
     * 结束当前条件并进入排序器
     *
     * @return QuerySortExpression
     */
    TypeQuerySortExpression sort();
}
