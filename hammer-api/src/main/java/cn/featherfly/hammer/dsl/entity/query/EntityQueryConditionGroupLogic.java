
package cn.featherfly.hammer.dsl.entity.query;

import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression;

/**
 * The Interface EntityQueryConditionGroupLogicExpression.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface EntityQueryConditionGroupLogic<E>
        //        extends EntityQueryLimitSetter<E>,
        //        EntityQueryExecutor<E>, QueryCountExecutor, QueryValueExecutor, EntityConditionGroupLogicExpression<E,
        //                EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>> {
        extends EntityQueryConditionGroupLogicExpression<E, EntityQueryConditionGroup<E>,
                EntityQueryConditionGroupLogic<E>, EntityQuerySortExpression<E>> {

    //    /**
    //     * 结束当前条件并进入排序器.
    //     *
    //     * @return SortBuilder
    //     */
    //    EntityQuerySortExpression<E> sort();
}
