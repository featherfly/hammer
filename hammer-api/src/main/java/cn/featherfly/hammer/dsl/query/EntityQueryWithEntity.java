
package cn.featherfly.hammer.dsl.query;

import cn.featherfly.hammer.expression.query.EntityQueryWithEntityExpression;

/**
 * The Interface EntityQueryWithEntity.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface EntityQueryWithEntity<E> extends
        EntityQueryWithEntityExpression<E, EntityQueryWith<E>, EntityQueryWithEntity<E>, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>> {
}
