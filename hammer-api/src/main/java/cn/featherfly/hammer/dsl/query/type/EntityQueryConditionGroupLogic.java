
package cn.featherfly.hammer.dsl.query.type;

import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression;

/**
 * The Interface EntityQueryConditionGroupLogicExpression.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface EntityQueryConditionGroupLogic<E>
        //        extends EntityQueryConditionLimit<E>,
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
