
package cn.featherfly.hammer.dsl.query;

import cn.featherfly.hammer.expression.ConditionLogicExpression;
import cn.featherfly.hammer.expression.query.EntityQueryConditionLimit;
import cn.featherfly.hammer.expression.query.EntityQueryExecutor;
import cn.featherfly.hammer.expression.query.QueryCountExecutor;

/**
 * <p>
 * QueryConditionLogic
 * </p>
 *
 * @author zhongj
 */
public interface EntityQueryConditionLogicExpression<E>
        extends EntityQueryConditionLimit<E>, EntityQueryExecutor<E>, QueryCountExecutor,
        ConditionLogicExpression<EntityQueryConditionExpression<E>, EntityQueryConditionLogicExpression<E>> {

    /**
     * 结束当前条件并进入排序器
     *
     * @return QuerySortExpression
     */
    TypeQuerySortExpression sort();
}
