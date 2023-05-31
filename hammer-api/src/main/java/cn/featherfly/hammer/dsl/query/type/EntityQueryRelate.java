
package cn.featherfly.hammer.dsl.query.type;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression2;
import cn.featherfly.hammer.expression.query.type.EntityQueryRelateExpression;

/**
 * The Interface EntityQueryRelation.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 */
public interface EntityQueryRelate<E, R1> extends
        EntityQueryRelateExpression<E, R1, EntityQueryConditionGroup2<E, R1, E>,
                EntityQueryConditionGroupLogic2<E, R1, E>, EntityQuerySortExpression2<E, R1, E>,
                EntityQueryRelatedFetched<E, R1>, EntityQueryConditionGroup2<E, R1, Tuple2<E, R1>>,
                EntityQueryConditionGroupLogic2<E, R1, Tuple2<E, R1>>,
                EntityQuerySortExpression2<E, R1, Tuple2<E, R1>>>,
        EntityQuery2<E, R1, E> {
}
