
package cn.featherfly.hammer.dsl.entity.query;

import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression6;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression6;

/**
 * The Interface EntityQueryConditionGroupExpression.
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
public interface EntityQueryConditionGroup6<E, E2, E3, E4, E5, E6, R> extends
        EntityQueryConditionGroupExpression6<E, E2, E3, E4, E5, E6,
                EntityQueryConditionGroup6<E, E2, E3, E4, E5, E6, R>,
                EntityQueryConditionGroupLogic6<E, E2, E3, E4, E5, E6, R>,
                EntityQuerySortExpression6<E, E2, E3, E4, E5, E6, R>, R> {

}
