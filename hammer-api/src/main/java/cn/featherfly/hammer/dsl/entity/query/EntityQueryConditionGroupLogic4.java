
package cn.featherfly.hammer.dsl.entity.query;

import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression4;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression4;

/**
 * The Interface EntityQueryConditionGroupLogicExpression.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <E4> the generic type
 * @param <R>  the generic type
 */
public interface EntityQueryConditionGroupLogic4<E, E2, E3, E4, R>
        extends EntityQueryConditionGroupLogicExpression4<E, E2, E3, E4, EntityQueryConditionGroup4<E, E2, E3, E4, R>,
                EntityQueryConditionGroupLogic4<E, E2, E3, E4, R>, EntityQuerySortExpression4<E, E2, E3, E4, R>, R> {

}
