/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntityQueryConditionGroupLogicCompat.java
 * @Package cn.featherfly.hammer.dsl.entity.query.compatible
 * @author: zhongj
 * @date: 2025-12-11 01:22:11
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.dsl.entity.query.compatible;

import cn.featherfly.hammer.expression.entity.compatible.query.EntityQueryConditionGroupLogicCompatibleExpression;
import cn.featherfly.hammer.expression.entity.compatible.query.EntityQuerySortCompatibleExpression;

/**
 * The Interface EntityQueryConditionGroupLogicExpression.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface EntityQueryConditionGroupLogicCompat<E>
    //        extends EntityQueryConditionLimit<E>,
    //        EntityQueryExecutor<E>, QueryCountExecutor, QueryValueExecutor, EntityConditionGroupLogicExpression<E,
    //                EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>> {
    extends EntityQueryConditionGroupLogicCompatibleExpression<E, EntityQueryConditionGroupCompat<E>,
        EntityQueryConditionGroupLogicCompat<E>, EntityQuerySortCompatibleExpression<E>> {

    //    /**
    //     * 结束当前条件并进入排序器.
    //     *
    //     * @return SortBuilder
    //     */
    //    EntityQuerySortExpression<E> sort();
}
