
package cn.featherfly.juorm.dsl.query;

import cn.featherfly.juorm.dml.builder.SortBuilder;
import cn.featherfly.juorm.expression.LogicGroupExpression;

/**
 * <p>
 * QueryConditionGroupLogic
 * </p>
 *
 * @author zhongj
 */
public interface QueryConditionGroupLogic extends QueryConditionLimit, QueryExecutor, QueryValueExecutor,
        LogicGroupExpression<QueryConditionGroupExpression, QueryConditionGroupLogic> {

    /**
     * 结束当前条件并进入排序器
     *
     * @return SortBuilder
     */
    SortBuilder sort();
}
