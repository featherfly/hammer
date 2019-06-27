
package cn.featherfly.juorm.dsl.query;

import cn.featherfly.juorm.dml.builder.SortBuilder;
import cn.featherfly.juorm.expression.LogicExpression;

/**
 * <p>
 * QueryConditionLogic
 * </p>
 *
 * @author zhongj
 */
public interface QueryConditionLogic extends QueryConditionLimit, QueryExecutor, QueryValueExecutor,
        LogicExpression<QueryConditionExpression, QueryConditionLogic> {

    /**
     * 结束当前条件并进入排序器
     *
     * @return SortBuilder
     */
    SortBuilder sort();
}
