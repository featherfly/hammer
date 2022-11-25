
package cn.featherfly.hammer.dsl.query.type;

import cn.featherfly.hammer.expression.EntityConditionGroupLogicExpression;
import cn.featherfly.hammer.expression.query.QueryCountExecutor;
import cn.featherfly.hammer.expression.query.type.EntityQueryConditionLimit;
import cn.featherfly.hammer.expression.query.type.EntityQueryExecutor;

/**
 * <p>
 * QueryConditionGroupLogic
 * </p>
 *
 * @author zhongj
 */
public interface EntityQueryConditionGroupLogicExpression<E>
        extends EntityQueryConditionLimit<E>, EntityQueryExecutor<E>, QueryCountExecutor,
        EntityConditionGroupLogicExpression<E, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>> {

    /**
     * 结束当前条件并进入排序器
     *
     * @return SortBuilder
     */
    EntityQuerySortExpression<E> sort();
}
