
package cn.featherfly.hammer.dsl.query.type;

import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression;
import cn.featherfly.hammer.expression.query.type.EntityQueryEntityPropertiesExpression;

/**
 * dsl for query entity.
 *
 * @author zhongj
 */
public interface EntityQueryEntity<E>
        extends EntityQuery<E>, EntityQueryEntityPropertiesExpression<E, EntityQueryEntity<E>,
                EntityQueryConditionGroup<E>, EntityQueryConditionGroupLogic<E>, EntityQuerySortExpression<E>> {

    //    TypeQueryEntity compatiblity();

    /**
     * 结束当前条件并进入排序器
     *
     * @return QuerySortExpression
     */
    EntityQuerySortExpression<E> sort();
}
