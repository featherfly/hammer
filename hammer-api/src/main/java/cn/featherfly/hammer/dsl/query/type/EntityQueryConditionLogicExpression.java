
package cn.featherfly.hammer.dsl.query.type;

import cn.featherfly.hammer.expression.ConditionLogicExpression;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression;
import cn.featherfly.hammer.expression.query.QueryCountExecutor;
import cn.featherfly.hammer.expression.query.QueryValueExecutor;
import cn.featherfly.hammer.expression.query.type.EntityQueryConditionLimit;
import cn.featherfly.hammer.expression.query.type.EntityQueryExecutor;

/**
 * The Interface EntityQueryConditionLogicExpression.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface EntityQueryConditionLogicExpression<E>
        extends EntityQueryConditionLimit<E>, EntityQueryExecutor<E>, QueryCountExecutor, QueryValueExecutor,
        ConditionLogicExpression<EntityQueryCondition<E>, EntityQueryConditionLogicExpression<E>> {

    /**
     * 结束当前条件并进入排序器.
     *
     * @return QuerySortExpression
     */
    EntityQuerySortExpression<E> sort();
}
