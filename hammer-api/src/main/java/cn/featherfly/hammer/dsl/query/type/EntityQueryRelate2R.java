
package cn.featherfly.hammer.dsl.query.type;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression3;
import cn.featherfly.hammer.expression.query.type.EntityQueryRelateExpression2R;

/**
 * The Interface EntityQueryRelate2R.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 * @param <R2> the generic type
 */
public interface EntityQueryRelate2R<E, R1, R2> extends
        EntityQueryRelateExpression2R<E, R1, R2, EntityQueryConditionGroup3<E, R1, R2, E>,
                EntityQueryConditionGroupLogic3<E, R1, R2, E>, EntityQuerySortExpression3<E, R1, R2, E>,
                EntityQueryRelatedFetched2RF<E, R1, R2>, EntityQueryConditionGroup3<E, R1, R2, Tuple2<E, R2>>,
                EntityQueryConditionGroupLogic3<E, R1, R2, Tuple2<E, R2>>,
                EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>>,
        EntityQuery3<E, R1, R2, E> {
}
