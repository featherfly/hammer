
package cn.featherfly.hammer.dsl.query;

import cn.featherfly.hammer.expression.TypeConditionGroupLogicExpression;
import cn.featherfly.hammer.expression.query.QueryCountExecutor;
import cn.featherfly.hammer.expression.query.TypeQueryConditionLimit;
import cn.featherfly.hammer.expression.query.TypeQueryExecutor;

/**
 * <p>
 * QueryConditionGroupLogic
 * </p>
 *
 * @author zhongj
 */
public interface TypeQueryConditionGroupLogicExpression
        extends TypeQueryConditionLimit, TypeQueryExecutor, QueryCountExecutor,
        TypeConditionGroupLogicExpression<TypeQueryConditionGroupExpression, TypeQueryConditionGroupLogicExpression> {

    /**
     * 结束当前条件并进入排序器
     *
     * @return SortBuilder
     */
    TypeQuerySortExpression sort();
}
