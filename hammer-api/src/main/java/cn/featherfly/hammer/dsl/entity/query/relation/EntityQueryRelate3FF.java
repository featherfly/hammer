
package cn.featherfly.hammer.dsl.entity.query.relation;

import com.speedment.common.tuple.Tuple3;
import com.speedment.common.tuple.Tuple4;

import cn.featherfly.hammer.dsl.entity.query.EntityQuery4;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroup4;
import cn.featherfly.hammer.dsl.entity.query.EntityQueryConditionGroupLogic4;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression4;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelateExpression3FF;

/**
 * The Interface EntityQueryRelate3FF.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 * @param <R2> the generic type
 * @param <R3> the generic type
 */
public interface EntityQueryRelate3FF<E, R1, R2, R3> extends
        EntityQueryRelateExpression3FF<E, R1, R2, R3, EntityQueryConditionGroup4<E, R1, R2, R3, Tuple3<E, R1, R2>>,
                EntityQueryConditionGroupLogic4<E, R1, R2, R3, Tuple3<E, R1, R2>>,
                EntityQuerySortExpression4<E, R1, R2, R3, Tuple3<E, R1, R2>>,
                EntityQueryRelatedFetched3FFF<E, R1, R2, R3>,
                EntityQueryConditionGroup4<E, R1, R2, R3, Tuple4<E, R1, R2, R3>>,
                EntityQueryConditionGroupLogic4<E, R1, R2, R3, Tuple4<E, R1, R2, R3>>,
                EntityQuerySortExpression4<E, R1, R2, R3, Tuple4<E, R1, R2, R3>>>,
        EntityQuery4<E, R1, R2, R3, Tuple3<E, R1, R2>> {

}
