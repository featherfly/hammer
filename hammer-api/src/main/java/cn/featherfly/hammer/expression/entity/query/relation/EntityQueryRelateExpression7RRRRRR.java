//
//package cn.featherfly.hammer.expression.entity.query.relation;
//
//import com.speedment.common.tuple.Tuple2;
//
//import cn.featherfly.hammer.expression.api.entity.EntityQueryRelate;
//import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression8;
//import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression8;
//import cn.featherfly.hammer.expression.entity.query.EntityQueryExpression8;
//import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression8;
//
///**
// * type query relation entity expression.
// *
// * @author zhongj
// * @param <E>  the element type
// * @param <R1> the generic type
// * @param <R2> the generic type
// * @param <R3> the generic type
// * @param <R4> the generic type
// * @param <R5> the generic type
// * @param <R6> the generic type
// * @param <R7> the generic type
// * @param <C>  the generic type
// * @param <L>  the generic type
// * @param <S>  the generic type
// * @param <F>  the generic type
// * @param <FC> the generic type
// * @param <FL> the generic type
// * @param <FS> the generic type
// */
//public interface EntityQueryRelateExpression7RRRRRR<E, R1, R2, R3, R4, R5, R6, R7,
//        C extends EntityQueryConditionGroupExpression8<E, R1, R2, R3, R4, R5, R6, R7, C, L, S, E>,
//        L extends EntityQueryConditionGroupLogicExpression8<E, R1, R2, R3, R4, R5, R6, R7, C, L, S, E>,
//        S extends EntityQuerySortExpression8<E, R1, R2, R3, R4, R5, R6, R7, E>,
//        F extends EntityQueryRelatedFetchedExpression7RRRRRRF<E, R1, R2, R3, R4, R5, R6, R7, FC, FL, FS>,
//        FC extends EntityQueryConditionGroupExpression8<E, R1, R2, R3, R4, R5, R6, R7, FC, FL, FS, Tuple2<E, R7>>,
//        FL extends EntityQueryConditionGroupLogicExpression8<E, R1, R2, R3, R4, R5, R6, R7, FC, FL, FS, Tuple2<E, R7>>,
//        FS extends EntityQuerySortExpression8<E, R1, R2, R3, R4, R5, R6, R7, Tuple2<E, R7>>>
//        //        extends EntityQueryRelationExpression7<E, R1, R2, R3, R4, R5, R6, R7, C, L, R>, EntityQueryRelate<QR> {
//        extends EntityQueryExpression8<E, R1, R2, R3, R4, R5, R6, R7, C, L, S, E>, EntityQueryRelate<F> {
//    // 目前就实现5次关联（join）
//}
