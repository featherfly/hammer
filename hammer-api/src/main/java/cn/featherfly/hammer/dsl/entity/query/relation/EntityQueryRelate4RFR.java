
package cn.featherfly.hammer.dsl.entity.query.relation;

import com.speedment.common.tuple.Tuple2;
import com.speedment.common.tuple.Tuple3;

import cn.featherfly.hammer.dsl.entity.query.EntityQuery5;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroup5;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroupLogic5;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression5;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelateExpression4RFR;

/**
 * The Interface EntityQueryRelate4RFR.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 * @param <R2> the generic type
 * @param <R3> the generic type
 * @param <R4> the generic type
 */
public interface EntityQueryRelate4RFR<E, R1, R2, R3, R4> extends
        EntityQueryRelateExpression4RFR<E, R1, R2, R3, R4, EntityQueryConditionGroup5<E, R1, R2, R3, R4, Tuple2<E, R2>>,
                EntityQueryConditionGroupLogic5<E, R1, R2, R3, R4, Tuple2<E, R2>>,
                EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple2<E, R2>>,
                EntityQueryRelatedFetched4RFRF<E, R1, R2, R3, R4>,
                EntityQueryConditionGroup5<E, R1, R2, R3, R4, Tuple3<E, R2, R4>>,
                EntityQueryConditionGroupLogic5<E, R1, R2, R3, R4, Tuple3<E, R2, R4>>,
                EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple3<E, R2, R4>>>,
        EntityQuery5<E, R1, R2, R3, R4, Tuple2<E, R2>> {

}
