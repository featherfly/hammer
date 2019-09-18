
package cn.featherfly.juorm.dsl.query;

import cn.featherfly.juorm.expression.ConditionLogicExpression;
import cn.featherfly.juorm.expression.query.TypeQueryConditionLimit;
import cn.featherfly.juorm.expression.query.TypeQueryExecutor;

/**
 * <p>
 * QueryConditionLogic
 * </p>
 *
 * @author zhongj
 */
public interface TypeQueryConditionLogicExpression extends TypeQueryConditionLimit, TypeQueryExecutor,
        ConditionLogicExpression<TypeQueryConditionExpression, TypeQueryConditionLogicExpression> {

    /**
     * 结束当前条件并进入排序器
     *
     * @return QuerySortExpression
     */
    TypeQuerySortExpression sort();
}
