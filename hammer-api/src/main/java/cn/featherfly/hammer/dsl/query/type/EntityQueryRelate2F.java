
package cn.featherfly.hammer.dsl.query.type;

import com.speedment.common.tuple.Tuple2;
import com.speedment.common.tuple.Tuple3;

import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression3;
import cn.featherfly.hammer.expression.query.type.EntityQueryRelateExpression2F;

/**
 * The Interface EntityQueryRelate2F.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 * @param <R2> the generic type
 */
public interface EntityQueryRelate2F<E, R1, R2> extends
        EntityQueryRelateExpression2F<E, R1, R2, EntityQueryConditionGroup3<E, R1, R2, Tuple2<E, R1>>,
                EntityQueryConditionGroupLogic3<E, R1, R2, Tuple2<E, R1>>,
                EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R1>>, EntityQueryRelatedFetched2FF<E, R1, R2>,
                EntityQueryConditionGroup3<E, R1, R2, Tuple3<E, R1, R2>>,
                EntityQueryConditionGroupLogic3<E, R1, R2, Tuple3<E, R1, R2>>,
                EntityQuerySortExpression3<E, R1, R2, Tuple3<E, R1, R2>>>,
        EntityQuery3<E, R1, R2, Tuple2<E, R1>> {

    //    E, R1, R2,
    //    C extends EntityQueryConditionGroupExpression3<E, R1, R2, C, L, S, Tuple2<E, R1>>,
    //    L extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, C, L, S, Tuple2<E, R1>>,
    //    S extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R1>>,
    //    F extends EntityQueryRelatedFetchedExpression2FF<E, R1, R2, FC, FL, FS>,
    //    FC extends EntityQueryConditionGroupExpression3<E, R1, R2, FC, FL, FS, Tuple3<E, R1, R2>>,
    //    FL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, FC, FL, FS, Tuple3<E, R1, R2>>,
    //    FS extends EntityQuerySortExpression3<E, R1, R2, Tuple3<E, R1, R2>>

}
