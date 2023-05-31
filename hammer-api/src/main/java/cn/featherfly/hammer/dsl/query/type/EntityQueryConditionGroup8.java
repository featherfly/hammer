
package cn.featherfly.hammer.dsl.query.type;

import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression8;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression8;

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
public interface EntityQueryConditionGroup8<E, E2, E3, E4, E5, E6, E7, E8, R> extends
        EntityQueryConditionGroupExpression8<E, E2, E3, E4, E5, E6, E7, E8,
                EntityQueryConditionGroup8<E, E2, E3, E4, E5, E6, E7, E8, R>,
                EntityQueryConditionGroupLogic8<E, E2, E3, E4, E5, E6, E7, E8, R>,
                EntityQuerySortExpression8<E, E2, E3, E4, E5, E6, E7, E8, R>, R> {

}
