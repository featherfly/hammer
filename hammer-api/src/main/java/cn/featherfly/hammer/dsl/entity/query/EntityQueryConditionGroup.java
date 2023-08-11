
package cn.featherfly.hammer.dsl.entity.query;

import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression;

/**
 * The Interface EntityQueryConditionGroupExpression.
 *
 * @author zhongj
 */
public interface EntityQueryConditionGroup<E> extends EntityQueryConditionGroupExpression<E,
        EntityQueryConditionGroup<E>, EntityQueryConditionGroupLogic<E>, EntityQuerySortExpression<E>> {

}
