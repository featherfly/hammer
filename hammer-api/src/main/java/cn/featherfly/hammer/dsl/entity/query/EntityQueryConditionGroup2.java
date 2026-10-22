
package cn.featherfly.hammer.dsl.entity.query;

import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression2;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression2;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortedExpression2;

/**
 * The Interface EntityQueryConditionGroupExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <E2> the generic type
 * @param <R> the generic type
 */
public interface EntityQueryConditionGroup2<E, E2, R> extends
    EntityQueryConditionGroupExpression2<E, E2, EntityQueryConditionGroup2<E, E2, R>,
        EntityQueryConditionGroupLogic2<E, E2, R>, EntityQuerySortExpression2<E, E2, R>,
        EntityQuerySortedExpression2<E, E2, R>, R> {

}
