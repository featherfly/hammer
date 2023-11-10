
package cn.featherfly.hammer.dsl.entity.query.relation;

import cn.featherfly.hammer.dsl.entity.query.EntityQuery3;
import cn.featherfly.hammer.expression.query.QueryRelateExpression;

/**
 * The Interface EntityQueryRelate2RR.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 * @param <R2> the generic type
 */
public interface EntityQueryRelate2RR<E, R1, R2> extends EntityQueryRelate2RXBase<E, R1, R2>,
        QueryRelateExpression<EntityQueryRelatedFetched2RF<E, R1, R2>>, EntityQuery3<E, R1, R2, E> {
}
