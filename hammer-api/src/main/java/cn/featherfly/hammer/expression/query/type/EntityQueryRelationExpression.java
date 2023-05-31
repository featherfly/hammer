//
//package cn.featherfly.hammer.expression.query.type;
//
//import com.speedment.common.tuple.Tuple2;
//import com.speedment.common.tuple.Tuple3;
//
//import cn.featherfly.common.lang.function.SerializableFunction;
//import cn.featherfly.common.lang.function.SerializableFunction1;
//import cn.featherfly.common.lang.function.SerializableFunction2;
//import cn.featherfly.hammer.expression.condition.type.EntitySortExpression3;
//import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression2;
//import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression3;
//import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression2;
//import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression3;
//import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression2;
//
///**
// * The Interface EntityQueryRelationExpression.
// *
// * @author zhongj
// * @param <E>  the element type
// * @param <R1> relate from type
// * @param <Q>  the generic type
// * @param <C>  the generic type
// * @param <L>  the generic type
// */
//// TODO 关联查询实现后重命名为EntityQueryRalateExpression
//public interface EntityQueryRelationExpression<E, R1, C extends EntityQueryConditionGroupExpression2<E, R1, C, L, S, R>,
//        L extends EntityQueryConditionGroupLogicExpression2<E, R1, C, L, S, R>,
//        S extends EntityQuerySortExpression2<E, R1, R>, R>
//        //        extends EntityWhereExpression2<E, R1, C, L>,
//        //        EntityQueryListExecutor<R>, QueryCountExecutor, EntityQueryConditionLimit<R> {
//        extends EntityQueryExpression2<E, R1, C, L, S, R> {
//
//    //    /**
//    //     * relate to.
//    //     *
//    //     * @param <RE>         the generic type
//    //     * @param <QR>         the generic type
//    //     * @param <R2>         the generic type
//    //     * @param propertyName find type object property name
//    //     * @return TypeQueryWithOnExpression
//    //     */
//    //    default <RE extends EntityQueryRelateExpression2<E, R1, R2, QR, RC, RL, RS, R>,
//    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS>,
//    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS>,
//    //            QR extends EntityQueryRelatedFetchedExpression2<E, R1, R2, RC, RL, RS>,
//    //            RS extends EntitySortExpression3<E, R1, R2, RS>, R2> RE relate(SerializableFunction<E, R2> propertyName) {
//    //        return join(propertyName);
//    //    }
//
//    /**
//     * join on.
//     *
//     * @param <RE>         the generic type
//     * @param <QR>         the generic type
//     * @param <R2>         the generic type
//     * @param propertyName find type object property name
//     * @return TypeQueryWithOnExpression
//     */
//    <RE extends EntityQueryRelateExpression2<E, R1, R2, QR, RC, RL, RS, R>,
//            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS>,
//            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS>,
//            RS extends EntitySortExpression3<E, R1, R2, RS>,
//            FC extends EntityQueryConditionGroupExpression3<E, R, FC, FL, FS, Tuple3<E, R1, R2>>,
//            FL extends EntityQueryConditionGroupLogicExpression3<E, R, FC, FL, FS, Tuple3<E, R1, R2>>,
//            FS extends EntityQuerySortExpression2<E, R, Tuple2<E, R>>,
//            QR extends EntityQueryRelatedFetchedExpression2FF<E, R1, R2, FC, FL, FS>,
//            R2> RE join(SerializableFunction<E, R2> propertyName);
//
//    //    /**
//    //     * relate to.
//    //     *
//    //     * @param <RE>         the generic type
//    //     * @param <QR>         the generic type
//    //     * @param <R2>         the generic type
//    //     * @param propertyName find type object property name
//    //     * @return TypeQueryWithOnExpression
//    //     */
//    //    default <RE extends EntityQueryRelateExpression2<E, R1, R2, QR, RC, RL, RS, R>,
//    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS>,
//    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS>,
//    //            QR extends EntityQueryRelatedFetchedExpression2<E, R1, R2, RC, RL, RS>,
//    //            RS extends EntitySortExpression3<E, R1, R2, RS>, R2> RE relate(SerializableFunction2<R2, E> propertyName) {
//    //        return join(propertyName);
//    //    }
//
//    /**
//     * join on.
//     *
//     * @param <RE>         the generic type
//     * @param <QR>         the generic type
//     * @param <R2>         the generic type
//     * @param propertyName find type object property name
//     * @return TypeQueryWithOnExpression
//     */
//    <RE extends EntityQueryRelateExpression2<E, R1, R2, QR, RC, RL, RS, R>,
//            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS>,
//            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS>,
//            QR extends EntityQueryRelatedFetchedExpression2FF<E, R1, R2, RC, RL, RS>,
//            RS extends EntitySortExpression3<E, R1, R2, RS>, R2> RE join(SerializableFunction2<R2, E> propertyName);
//
//    //    /**
//    //     * relate to.
//    //     *
//    //     * @param <RE>         the generic type
//    //     * @param <QR>         the generic type
//    //     * @param propertyName find type object property name
//    //     * @return TypeQueryWithOnExpression
//    //     */
//    //    default <RE extends EntityQueryRelateExpression2<E, R1, E, QR, RC, RL, RS, R>,
//    //            RC extends EntityQueryConditionGroupExpression3<E, R1, E, RC, RL, RS>,
//    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, E, RC, RL, RS>,
//    //            QR extends EntityQueryRelatedFetchedExpression2<E, R1, E, RC, RL, RS>,
//    //            RS extends EntitySortExpression3<E, R1, E, RS>> RE relate(SerializableFunction1<E, E> propertyName) {
//    //        return join(propertyName);
//    //    }
//
//    /**
//     * join on.
//     *
//     * @param <RE>         the generic type
//     * @param <QR>         the generic type
//     * @param propertyName find type object property name
//     * @return TypeQueryWithOnExpression
//     */
//    <RE extends EntityQueryRelateExpression2<E, R1, E, QR, RC, RL, RS, R>,
//            RC extends EntityQueryConditionGroupExpression3<E, R1, E, RC, RL, RS>,
//            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, E, RC, RL, RS>,
//            QR extends EntityQueryRelatedFetchedExpression2FF<E, R1, E, RC, RL, RS>,
//            RS extends EntitySortExpression3<E, R1, E, RS>> RE join(SerializableFunction1<E, E> propertyName);
//
//    //    /**
//    //     * relate to.
//    //     *
//    //     * @param <RE>         the generic type
//    //     * @param <QR>         the generic type
//    //     * @param <R2>         the generic type
//    //     * @param propertyName find type object property name
//    //     * @return TypeQueryWithOnExpression
//    //     */
//    //    default <RE extends EntityQueryRelateExpression2<E, R1, R2, QR, RC, RL, RS, R>,
//    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS>,
//    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS>,
//    //            QR extends EntityQueryRelatedFetchedExpression2<E, R1, R2, RC, RL, RS>,
//    //            RS extends EntitySortExpression3<E, R1, R2, RS>, R2> RE relate1(SerializableFunction<R1, R2> propertyName) {
//    //        return join1(propertyName);
//    //    }
//
//    /**
//     * join on.
//     *
//     * @param <RE>         the generic type
//     * @param <QR>         the generic type
//     * @param <R2>         the generic type
//     * @param propertyName find type object property name
//     * @return TypeQueryWithOnExpression
//     */
//    <RE extends EntityQueryRelateExpression2<E, R1, R2, QR, RC, RL, RS, R>,
//            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS>,
//            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS>,
//            QR extends EntityQueryRelatedFetchedExpression2FF<E, R1, R2, RC, RL, RS>,
//            RS extends EntitySortExpression3<E, R1, R2, RS>, R2> RE join1(SerializableFunction<R1, R2> propertyName);
//
//    //    /**
//    //     * relate to.
//    //     *
//    //     * @param <RE>         the generic type
//    //     * @param <QR>         the generic type
//    //     * @param <R2>         the generic type
//    //     * @param propertyName find type object property name
//    //     * @return TypeQueryWithOnExpression
//    //     */
//    //    default <RE extends EntityQueryRelateExpression2<E, R1, R2, QR, RC, RL, RS, R>,
//    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS>,
//    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS>,
//    //            QR extends EntityQueryRelatedFetchedExpression2<E, R1, R2, RC, RL, RS>,
//    //            RS extends EntitySortExpression3<E, R1, R2, RS>,
//    //            R2> RE relate1(SerializableFunction2<R2, R1> propertyName) {
//    //        return join1(propertyName);
//    //    }
//
//    /**
//     * join on.
//     *
//     * @param <RE>         the generic type
//     * @param <QR>         the generic type
//     * @param <R2>         the generic type
//     * @param propertyName find type object property name
//     * @return TypeQueryWithOnExpression
//     */
//    <RE extends EntityQueryRelateExpression2<E, R1, R2, QR, RC, RL, RS, R>,
//            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS>,
//            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS>,
//            QR extends EntityQueryRelatedFetchedExpression2FF<E, R1, R2, RC, RL, RS>,
//            RS extends EntitySortExpression3<E, R1, R2, RS>, R2> RE join1(SerializableFunction2<R2, R1> propertyName);
//
//    //    /**
//    //     * relate to.
//    //     *
//    //     * @param <RE>         the generic type
//    //     * @param <QR>         the generic type
//    //     * @param propertyName find type object property name
//    //     * @return TypeQueryWithOnExpression
//    //     */
//    //    default <RE extends EntityQueryRelationEntityExpression2<E, R1, R1, QR, RC, RL, RS, R>,
//    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R1, RC, RL, RS, R>,
//    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R1, RC, RL, RS, R>,
//    //            QR extends EntityQueryRelatedFetchedExpression2<E, R1, R1, RC, RL, RS, R>> RE relate1(
//    //                    SerializableFunction1<R1, R1> propertyName) {
//    //        return join1(propertyName);
//    //    }
//
//    /**
//     * join on.
//     *
//     * @param <RE>         the generic type
//     * @param <QR>         the generic type
//     * @param propertyName find type object property name
//     * @return TypeQueryWithOnExpression
//     */
//    <RE extends EntityQueryRelateExpression2<E, R1, R1, QR, RC, RL, RS, R>,
//            RC extends EntityQueryConditionGroupExpression3<E, R1, R1, RC, RL, RS>,
//            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R1, RC, RL, RS>,
//            QR extends EntityQueryRelatedFetchedExpression2FF<E, R1, R1, RC, RL, RS>,
//            RS extends EntitySortExpression3<E, R1, R1, RS>> RE join1(SerializableFunction1<R1, R1> propertyName);
//
//}
