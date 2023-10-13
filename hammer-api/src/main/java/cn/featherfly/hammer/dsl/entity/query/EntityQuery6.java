
package cn.featherfly.hammer.dsl.entity.query;

import cn.featherfly.hammer.expression.entity.query.EntityQueryExpression6;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression6;

/**
 * dsl for query entity.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <E5> the generic type
 * @param <E6> the generic type
 * @param <R>  the generic type
 */
public interface EntityQuery6<E, E2, E3, E4, E5, E6, R> extends
        EntityQueryExpression6<E, E2, E3, E4, E5, E6, EntityQueryConditionGroup6<E, E2, E3, E4, E5, E6, R>,
                EntityQueryConditionGroupLogic6<E, E2, E3, E4, E5, E6, R>,
                EntityQuerySortExpression6<E, E2, E3, E4, E5, E6, R>, R> {
}
