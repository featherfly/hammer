
package cn.featherfly.hammer.dsl.entity.query;

import cn.featherfly.hammer.expression.entity.query.EntityQueryExpression7;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression7;

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
 * @param <E7> the generic type
 * @param <R>  the generic type
 */
public interface EntityQuery7<E, E2, E3, E4, E5, E6, E7, R> extends
        EntityQueryExpression7<E, E2, E3, E4, E5, E6, E7, EntityQueryConditionGroup7<E, E2, E3, E4, E5, E6, E7, R>,
                EntityQueryConditionGroupLogic7<E, E2, E3, E4, E5, E6, E7, R>,
                EntityQuerySortExpression7<E, E2, E3, E4, E5, E6, E7, R>, R> {
}
