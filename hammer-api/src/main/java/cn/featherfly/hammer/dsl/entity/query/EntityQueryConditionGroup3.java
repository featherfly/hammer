
package cn.featherfly.hammer.dsl.entity.query;

import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression3;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression3;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortedExpression3;

/**
 * The Interface EntityQueryConditionGroupExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <E2> the generic type
 * @param <E3> the generic type
 * @param <R> the generic type
 */
public interface EntityQueryConditionGroup3<E, E2, E3, R> extends
    EntityQueryConditionGroupExpression3<E, E2, E3, EntityQueryConditionGroup3<E, E2, E3, R>,
        EntityQueryConditionGroupLogic3<E, E2, E3, R>, EntityQuerySortExpression3<E, E2, E3, R>,
        EntityQuerySortedExpression3<E, E2, E3, R>, R> {

}
