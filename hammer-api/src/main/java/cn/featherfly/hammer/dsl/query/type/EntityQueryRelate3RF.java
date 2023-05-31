
package cn.featherfly.hammer.dsl.query.type;

import com.speedment.common.tuple.Tuple2;
import com.speedment.common.tuple.Tuple3;

import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression4;
import cn.featherfly.hammer.expression.query.type.EntityQueryRelateExpression3RF;

/**
 * The Interface EntityQueryRelate3RF.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 * @param <R2> the generic type
 * @param <R3> the generic type
 */
public interface EntityQueryRelate3RF<E, R1, R2, R3> extends
        EntityQueryRelateExpression3RF<E, R1, R2, R3, EntityQueryConditionGroup4<E, R1, R2, R3, Tuple2<E, R2>>,
                EntityQueryConditionGroupLogic4<E, R1, R2, R3, Tuple2<E, R2>>,
                EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R2>>, EntityQueryRelatedFetched3RFF<E, R1, R2, R3>,
                EntityQueryConditionGroup4<E, R1, R2, R3, Tuple3<E, R2, R3>>,
                EntityQueryConditionGroupLogic4<E, R1, R2, R3, Tuple3<E, R2, R3>>,
                EntityQuerySortExpression4<E, R1, R2, R3, Tuple3<E, R2, R3>>>,
        EntityQuery4<E, R1, R2, R3, Tuple2<E, R2>> {

}
