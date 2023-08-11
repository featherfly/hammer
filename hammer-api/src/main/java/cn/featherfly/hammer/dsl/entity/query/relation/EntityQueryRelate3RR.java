
package cn.featherfly.hammer.dsl.entity.query.relation;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.hammer.dsl.entity.query.EntityQuery4;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroup4;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroupLogic4;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression4;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelateExpression3RR;

/**
 * The Interface EntityQueryRelate3RF.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 * @param <R2> the generic type
 * @param <R3> the generic type
 */
public interface EntityQueryRelate3RR<E, R1, R2, R3> extends
        EntityQueryRelateExpression3RR<E, R1, R2, R3, EntityQueryConditionGroup4<E, R1, R2, R3, E>,
                EntityQueryConditionGroupLogic4<E, R1, R2, R3, E>, EntityQuerySortExpression4<E, R1, R2, R3, E>,
                EntityQueryRelatedFetched3RRF<E, R1, R2, R3>, EntityQueryConditionGroup4<E, R1, R2, R3, Tuple2<E, R3>>,
                EntityQueryConditionGroupLogic4<E, R1, R2, R3, Tuple2<E, R3>>,
                EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R3>>>,
        EntityQuery4<E, R1, R2, R3, E> {

}
