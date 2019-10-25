
package cn.featherfly.juorm.dsl.query;

import cn.featherfly.juorm.expression.ConditionLogicExpression;
import cn.featherfly.juorm.expression.query.TypeQueryConditionLimit;
import cn.featherfly.juorm.expression.query.TypeQueryExecutor;

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
