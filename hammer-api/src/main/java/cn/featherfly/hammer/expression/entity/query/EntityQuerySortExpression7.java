
package cn.featherfly.hammer.expression.entity.query;

import cn.featherfly.hammer.expression.condition.type.EntitySortExpression7;
import cn.featherfly.hammer.expression.query.type.EntityQueryConditionLimit;
import cn.featherfly.hammer.expression.query.type.EntityQueryLimitExecutor;

/**
 * The Interface EntityQuerySortExpression.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface EntityQuerySortExpression7<E, E2, E3, E4, E5, E6, E7, R> extends
        EntitySortExpression7<E, E2, E3, E4, E5, E6, E7, EntityQuerySortExpression7<E, E2, E3, E4, E5, E6, E7, R>>,
        EntityQueryConditionLimit<R>, EntityQueryLimitExecutor<R> {

}
