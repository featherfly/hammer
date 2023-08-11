
package cn.featherfly.hammer.dsl.entity.query.relation;

import com.speedment.common.tuple.Tuple6;

import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroup6;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroupLogic6;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression6;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelatedFetchedExpression5FFFFF;

/**
 * The Interface EntityQueryRelatedFetched5FFFFF.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 * @param <R2> the generic type
 * @param <R3> the generic type
 * @param <R4> the generic type
 * @param <R5> the generic type
 */
public interface EntityQueryRelatedFetched5FFFFF<E, R1, R2, R3, R4, R5> extends
        EntityQueryRelatedFetchedExpression5FFFFF<E, R1, R2, R3, R4, R5,
                EntityQueryConditionGroup6<E, R1, R2, R3, R4, R5, Tuple6<E, R1, R2, R3, R4, R5>>,
                EntityQueryConditionGroupLogic6<E, R1, R2, R3, R4, R5, Tuple6<E, R1, R2, R3, R4, R5>>,
                EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple6<E, R1, R2, R3, R4, R5>>> {

}
