
package cn.featherfly.hammer.expression.entity.query;

import cn.featherfly.hammer.expression.condition.type.EntitySortExpression4;
import cn.featherfly.hammer.expression.query.type.EntityQueryConditionLimit;
import cn.featherfly.hammer.expression.query.type.EntityQueryLimitExecutor;

/**
 * The Interface EntityQuerySortExpression.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface EntityQuerySortExpression4<E, E2, E3, E4, R>
        extends EntitySortExpression4<E, E2, E3, E4, EntityQuerySortExpression4<E, E2, E3, E4, R>>,
        EntityQueryConditionLimit<R>, EntityQueryLimitExecutor<R> {

}
