//
///*
// * All rights Reserved, Designed By zhongj
// * @Title: EntityQueryRelatedExpression.java
// * @Description: EntityQueryRelatedExpression
// * @author: zhongj
// * @date: 2023-08-11 16:17:11
// * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
// */
//package cn.featherfly.hammer.dsl.entity.query.relation;
//
//import cn.featherfly.common.tuple.Tuple3;
//
//import cn.featherfly.common.function.FourArgusFunction;
//import cn.featherfly.hammer.expression.query.QueryRelateExpression;
//
///**
// * EntityQueryRelatedExpression.
// *
// * @author zhongj
// * @param <J>  the generic type
// * @param <T>  the generic type
// * @param <E1> the generic type
// * @param <E2> the generic type
// * @param <E3> the generic type
// * @param <R>  the generic type
// * @param <F>  the generic type
// */
//public interface EntityQueryMulitiRelatedExpression2<J, E1, E2, E3, R extends QueryRelateExpression<F>, F>
//        extends EntityQueryMulitiRelatedExpression<J, Tuple3<E1, E2, E3>, R, F> {
//    IMPLSOON 新的join on api
//    /**
//     * On.
//     *
//     * @param expression the expression
//     * @return the re
//     */
//    R on(FourArgusFunction<J, E1, E2, E3, R> expression);
//
//    /**
//     * T.
//     */
//    @Override
//    default void t() {
//        on((j, e1, e2, e3) -> j.property("user").eq(e3.property("id")));
//        on((j, es) -> j.property("user").eq(es.get2().property("id")));
//    }
//}
