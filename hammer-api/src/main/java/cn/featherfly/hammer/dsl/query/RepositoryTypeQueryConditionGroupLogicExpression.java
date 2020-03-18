
package cn.featherfly.hammer.dsl.query;

import cn.featherfly.hammer.expression.RepositoryConditionGroupLogicExpression;
import cn.featherfly.hammer.expression.query.TypeQueryConditionLimit;
import cn.featherfly.hammer.expression.query.TypeQueryExecutor;

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
