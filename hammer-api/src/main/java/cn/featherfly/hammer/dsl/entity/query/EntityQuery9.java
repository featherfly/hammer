
package cn.featherfly.hammer.dsl.entity.query;

import cn.featherfly.hammer.expression.entity.query.EntityQueryExpression9;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression9;

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
 * @param <E8> the generic type
 * @param <R>  the generic type
 */
public interface EntityQuery9<E, E2, E3, E4, E5, E6, E7, E8, E9, R> extends
        EntityQueryExpression9<E, E2, E3, E4, E5, E6, E7, E8, E9,
                EntityQueryConditionGroup9<E, E2, E3, E4, E5, E6, E7, E8, E9, R>,
                EntityQueryConditionGroupLogic9<E, E2, E3, E4, E5, E6, E7, E8, E9, R>,
                EntityQuerySortExpression9<E, E2, E3, E4, E5, E6, E7, E8, E9, R>, R> {
}
