
package cn.featherfly.juorm.dsl.query;

import cn.featherfly.juorm.expression.ConditionGroupLogicExpression;
import cn.featherfly.juorm.expression.query.QueryCountExecutor;
import cn.featherfly.juorm.expression.query.TypeQueryConditionLimit;
import cn.featherfly.juorm.expression.query.TypeQueryExecutor;

/**
 * <p>
 * QueryConditionGroupLogic
 * </p>
 *
 * @author zhongj
 */
public interface TypeQueryConditionGroupLogicExpression
        extends TypeQueryConditionLimit, TypeQueryExecutor, QueryCountExecutor,
        ConditionGroupLogicExpression<TypeQueryConditionGroupExpression, TypeQueryConditionGroupLogicExpression> {

    /**
     * 结束当前条件并进入排序器
     *
     * @return SortBuilder
     */
    TypeQuerySortExpression sort();
}
