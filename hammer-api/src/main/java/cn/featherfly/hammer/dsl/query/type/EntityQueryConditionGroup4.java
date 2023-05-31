
package cn.featherfly.hammer.dsl.query.type;

import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression4;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression4;

/**
 * The Interface EntityQueryConditionGroupExpression.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <R>  the generic type
 */
public interface EntityQueryConditionGroup4<E, E2, E3, E4, R>
        extends EntityQueryConditionGroupExpression4<E, E2, E3, E4, EntityQueryConditionGroup4<E, E2, E3, E4, R>,
                EntityQueryConditionGroupLogic4<E, E2, E3, E4, R>, EntityQuerySortExpression4<E, E2, E3, E4, R>, R> {

}
