
package cn.featherfly.hammer.dsl.query.type;

import cn.featherfly.hammer.expression.condition.type.EntitySortExpression;
import cn.featherfly.hammer.expression.query.type.EntityQueryConditionLimit;
import cn.featherfly.hammer.expression.query.type.EntityQueryLimitExecutor;

/**
 * The Interface EntityQuerySortExpression.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface EntityQuerySortExpression<E> extends EntitySortExpression<E, EntityQuerySortExpression<E>>,
        EntityQueryConditionLimit<E>, EntityQueryLimitExecutor<E> {

}
