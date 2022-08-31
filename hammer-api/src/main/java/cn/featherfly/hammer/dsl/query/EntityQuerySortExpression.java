
package cn.featherfly.hammer.dsl.query;

import cn.featherfly.hammer.expression.condition.SortExpression;
import cn.featherfly.hammer.expression.query.EntityQueryConditionLimit;
import cn.featherfly.hammer.expression.query.EntityQueryLimitExecutor;

/**
 * The Interface EntityQuerySortExpression.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface EntityQuerySortExpression<E> extends SortExpression<EntityQuerySortExpression<E>>,
        EntityQueryConditionLimit<E>, EntityQueryLimitExecutor<E> {

}
