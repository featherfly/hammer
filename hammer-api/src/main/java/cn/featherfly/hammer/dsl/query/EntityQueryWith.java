
package cn.featherfly.hammer.dsl.query;

import cn.featherfly.hammer.expression.query.EntityQueryWithExpression;

/**
 * <p>
 * dsl for query data
 * </p>
 *
 * @author zhongj
 */
public interface EntityQueryWith<E> extends
        EntityQueryWithExpression<E, EntityQueryWith<E>, EntityQueryWithEntity<E>, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>> {
}
