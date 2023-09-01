
package cn.featherfly.hammer.dsl.entity.query.relation;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.hammer.dsl.entity.query.EntityQuery6;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroup6;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroupLogic6;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression6;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelateExpression5RRFRP;

/**
 * The Interface EntityQueryRelate5RRFRP.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 * @param <R2> the generic type
 * @param <R3> the generic type
 * @param <R4> the generic type
 * @param <R5> the generic type
 */
public interface EntityQueryRelate5RRFRP<E, R1, R2, R3, R4, R5> extends
        EntityQueryRelateExpression5RRFRP<E, R1, R2, R3, R4, R5,
                EntityQueryConditionGroup6<E, R1, R2, R3, R4, R5, Tuple2<E, R3>>,
                EntityQueryConditionGroupLogic6<E, R1, R2, R3, R4, R5, Tuple2<E, R3>>,
                EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple2<E, R3>>,
                EntityQueryRelatedFetched5RRFRP<E, R1, R2, R3, R4, R5>>,
        EntityQuery6<E, R1, R2, R3, R4, R5, Tuple2<E, R3>> {

}
