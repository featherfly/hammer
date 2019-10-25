
package cn.featherfly.juorm.dsl.query;

import cn.featherfly.juorm.expression.RepositoryConditionGroupLogicExpression;
import cn.featherfly.juorm.expression.query.TypeQueryConditionLimit;
import cn.featherfly.juorm.expression.query.TypeQueryExecutor;

/**
 * <p>
 * RepositoryQueryConditionGroupLogic
 * </p>
 *
 * @author zhongj
 */
public interface RepositoryTypeQueryConditionGroupLogicExpression extends TypeQueryConditionLimit, TypeQueryExecutor,
        RepositoryConditionGroupLogicExpression<RepositoryTypeQueryConditionGroupExpression, RepositoryTypeQueryConditionGroupLogicExpression> {

    /**
     * 结束当前条件并进入排序器
     *
     * @return SortBuilder
     */
    TypeQuerySortExpression sort();
}
