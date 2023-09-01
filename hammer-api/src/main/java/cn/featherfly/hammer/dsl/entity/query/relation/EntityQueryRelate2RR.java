
package cn.featherfly.hammer.dsl.entity.query.relation;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.hammer.dsl.entity.query.EntityQuery3;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroup3;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroupLogic3;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression3;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelateExpression2RR;

/**
 * The Interface EntityQueryRelate2RR.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 * @param <R2> the generic type
 */
public interface EntityQueryRelate2RR<E, R1, R2> extends
        EntityQueryRelateExpression2RR<E, R1, R2, EntityQueryConditionGroup3<E, R1, R2, E>,
                EntityQueryConditionGroupLogic3<E, R1, R2, E>, EntityQuerySortExpression3<E, R1, R2, E>,
                EntityQueryRelatedFetched2RF<E, R1, R2>, EntityQueryConditionGroup3<E, R1, R2, Tuple2<E, R2>>,
                EntityQueryConditionGroupLogic3<E, R1, R2, Tuple2<E, R2>>,
                EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>>,
        EntityQuery3<E, R1, R2, E> {
}
