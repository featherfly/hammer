
package cn.featherfly.hammer.dsl.entity.query.relation;

import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroup5;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroupLogic5;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression5;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelatedFetchedExpression4RRRP;

/**
 * The Interface EntityQueryRelatedFetched4RRRP.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 * @param <R2> the generic type
 * @param <R3> the generic type
 * @param <R4> the generic type
 */
public interface EntityQueryRelatedFetched4RRRP<E, R1, R2, R3, R4> extends
        EntityQueryRelatedFetchedExpression4RRRP<E, R1, R2, R3, R4, EntityQueryConditionGroup5<E, R1, R2, R3, R4, E>,
                EntityQueryConditionGroupLogic5<E, R1, R2, R3, R4, E>,
                EntityQuerySortExpression5<E, R1, R2, R3, R4, E>> {

}
