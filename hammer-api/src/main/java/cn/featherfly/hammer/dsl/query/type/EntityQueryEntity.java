
package cn.featherfly.hammer.dsl.query.type;

import cn.featherfly.hammer.expression.query.type.EntityQueryEntityExpression;

/**
 * dsl for query entity.
 *
 * @author zhongj
 */
public interface EntityQueryEntity<E>
        extends EntityQuery<E>, EntityQueryEntityExpression<E, EntityQueryEntityProperties<E>,
                EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>> {

    //    TypeQueryEntity compatiblity();

    /**
     * 结束当前条件并进入排序器
     *
     * @return QuerySortExpression
     */
    EntityQuerySortExpression<E> sort();
}
