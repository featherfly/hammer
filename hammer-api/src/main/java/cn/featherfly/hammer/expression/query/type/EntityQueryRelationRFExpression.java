//
//package cn.featherfly.hammer.expression.query.type;
//
//import cn.featherfly.common.lang.function.SerializableFunction;
//import cn.featherfly.common.lang.function.SerializableFunction1;
//import cn.featherfly.common.lang.function.SerializableFunction2;
//import cn.featherfly.common.lang.function.SerializableFunction3;
//import cn.featherfly.hammer.expression.condition.type.EntitySortExpression3;
//import cn.featherfly.hammer.expression.condition.type.EntitySortExpression4;
//import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression3;
//import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression4;
//import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression3;
//import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression4;
//
///**
// * The Interface TypeQueryWithExpression.
// *
// * @author zhongj
// * @param <E>  the element type
// * @param <R1> relate from type
// * @param <R2> relate to type
// * @param <C>  the generic type
// * @param <L>  the generic type
// * @param <R>  the return type
// */
//public interface EntityQueryRelationRFExpression<E, R1, R2,
//        C extends EntityQueryConditionGroupExpression3<E, R1, R2, C, L, S, E>,
//        L extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, C, L, S, E>,
//        S extends EntitySortExpression3<E, R1, R2, S>, R> extends EntityQueryExpression3<E, R1, R2, C, L, S, R> {
//
//    /**
//     * relate to.
//     *
//     * @param <RE>         the generic type
//     * @param <QR>         the generic type
//     * @param <R3>         the generic type
//     * @param propertyName find type object property name
//     * @return TypeQueryWithOnExpression
//     */
//    default <RE extends EntityQueryRelateExpression3<E, R1, R2, R3, QR, RC, RL, RS, R>,
//            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS>,
//            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS>,
//            QR extends EntityQueryRelatedFetchedExpression3FFF<E, R1, R2, R3, RC, RL, RS>,
//            RS extends EntitySortExpression4<E, R1, R2, R3, RS>,
//            R3> RE relate(SerializableFunction<E, R3> propertyName) {
//        return join(propertyName);
//    }
//
//    /**
//     * join on.
//     *
//     * @param <RE>         the generic type
//     * @param <QR>         the generic type
//     * @param <R3>         the generic type
//     * @param propertyName find type object property name
//     * @return TypeQueryWithOnExpression
//     */
//    <RE extends EntityQueryRelateExpression3<E, R1, R2, R3, QR, RC, RL, RS, R>,
//            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS>,
//            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS>,
//            QR extends EntityQueryRelatedFetchedExpression3FFF<E, R1, R2, R3, RC, RL, RS>,
//            RS extends EntitySortExpression4<E, R1, R2, R3, RS>, R3> RE join(SerializableFunction<E, R3> propertyName);
//
//    /**
//     * relate to.
//     *
//     * @param <RE>         the generic type
//     * @param <QR>         the generic type
//     * @param <R3>         the generic type
//     * @param propertyName find type object property name
//     * @return TypeQueryWithOnExpression
//     */
//    default <RE extends EntityQueryRelateExpression3<E, R1, R2, R3, QR, RC, RL, RS, R>,
//            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS>,
//            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS>,
//            QR extends EntityQueryRelatedFetchedExpression3FFF<E, R1, R2, R3, RC, RL, RS>,
//            RS extends EntitySortExpression4<E, R1, R2, R3, RS>,
//            R3> RE relate(SerializableFunction2<R3, E> propertyName) {
//        return join(propertyName);
//    }
//
//    /**
//     * join on.
//     *
//     * @param <RE>         the generic type
//     * @param <QR>         the generic type
//     * @param <R3>         the generic type
//     * @param propertyName find type object property name
//     * @return TypeQueryWithOnExpression
//     */
//    <RE extends EntityQueryRelateExpression3<E, R1, R2, R3, QR, RC, RL, RS, R>,
//            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS>,
//            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS>,
//            QR extends EntityQueryRelatedFetchedExpression3FFF<E, R1, R2, R3, RC, RL, RS>,
//            RS extends EntitySortExpression4<E, R1, R2, R3, RS>, R3> RE join(SerializableFunction2<R3, E> propertyName);
//
//    /**
//     * relate to.
//     *
//     * @param <RE>         the generic type
//     * @param <QR>         the generic type
//     * @param propertyName find type object property name
//     * @return TypeQueryWithOnExpression
//     */
//    default <RE extends EntityQueryRelateExpression3<E, R1, R2, E, QR, RC, RL, RS, R>,
//            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, E, RC, RL, RS>,
//            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, E, RC, RL, RS>,
//            QR extends EntityQueryRelatedFetchedExpression3FFF<E, R1, R2, E, RC, RL, RS>,
//            RS extends EntitySortExpression4<E, R1, R2, E, RS>> RE relate(SerializableFunction1<E, E> propertyName) {
//        return join(propertyName);
//    }
//
//    /**
//     * join on.
//     *
//     * @param <RE>         the generic type
//     * @param <QR>         the generic type
//     * @param propertyName find type object property name
//     * @return TypeQueryWithOnExpression
//     */
//    <RE extends EntityQueryRelateExpression3<E, R1, R2, E, QR, RC, RL, RS, R>,
//            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, E, RC, RL, RS>,
//            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, E, RC, RL, RS>,
//            QR extends EntityQueryRelatedFetchedExpression3FFF<E, R1, R2, E, RC, RL, RS>,
//            RS extends EntitySortExpression4<E, R1, R2, E, RS>> RE join(SerializableFunction1<E, E> propertyName);
//
//    /**
//     * relate to.
//     *
//     * @param <RE>         the generic type
//     * @param <QR>         the generic type
//     * @param <R3>         the generic type
//     * @param propertyName find type object property name
//     * @return TypeQueryWithOnExpression
//     */
//    default <RE extends EntityQueryRelateExpression3<E, R1, R2, R3, QR, RC, RL, RS, R>,
//            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS>,
//            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS>,
//            QR extends EntityQueryRelatedFetchedExpression3FFF<E, R1, R2, R3, RC, RL, RS>,
//            RS extends EntitySortExpression4<E, R1, R2, R3, RS>,
//            R3> RE relate1(SerializableFunction<R1, R3> propertyName) {
//        return join1(propertyName);
//    }
//
//    /**
//     * join on.
//     *
//     * @param <RE>         the generic type
//     * @param <QR>         the generic type
//     * @param <R3>         the generic type
//     * @param propertyName find type object property name
//     * @return TypeQueryWithOnExpression
//     */
//    <RE extends EntityQueryRelateExpression3<E, R1, R2, R3, QR, RC, RL, RS, R>,
//            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS>,
//            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS>,
//            QR extends EntityQueryRelatedFetchedExpression3FFF<E, R1, R2, R3, RC, RL, RS>,
//            RS extends EntitySortExpression4<E, R1, R2, R3, RS>,
//            R3> RE join1(SerializableFunction<R1, R3> propertyName);
//
//    /**
//     * relate to.
//     *
//     * @param <RE>         the generic type
//     * @param <QR>         the generic type
//     * @param <R3>         the generic type
//     * @param propertyName find type object property name
//     * @return TypeQueryWithOnExpression
//     */
//    default <RE extends EntityQueryRelateExpression3<E, R1, R2, R3, QR, RC, RL, RS, R>,
//            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS>,
//            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS>,
//            QR extends EntityQueryRelatedFetchedExpression3FFF<E, R1, R2, R3, RC, RL, RS>,
//            RS extends EntitySortExpression4<E, R1, R2, R3, RS>,
//            R3> RE relate1(SerializableFunction2<R3, R1> propertyName) {
//        return join1(propertyName);
//    }
//
//    /**
//     * join on.
//     *
//     * @param <RE>         the generic type
//     * @param <QR>         the generic type
//     * @param <R3>         the generic type
//     * @param propertyName find type object property name
//     * @return TypeQueryWithOnExpression
//     */
//    <RE extends EntityQueryRelateExpression3<E, R1, R2, R3, QR, RC, RL, RS, R>,
//            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS>,
//            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS>,
//            QR extends EntityQueryRelatedFetchedExpression3FFF<E, R1, R2, R3, RC, RL, RS>,
//            RS extends EntitySortExpression4<E, R1, R2, R3, RS>,
//            R3> RE join1(SerializableFunction2<R3, R1> propertyName);
//
//    //    /**
//    //     * relate to.
//    //     *
//    //     * @param <RE>         the generic type
//    //     * @param <QR>         the generic type
//    //     * @param propertyName find type object property name
//    //     * @return TypeQueryWithOnExpression
//    //     */
//    //    default <RE extends EntityQueryRelateExpression3<E, R1, R2, R1, QR, RC, RL, RS, R>,
//    //            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R1, RC, RL, RS, R>,
//    //            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R1, RC, RL, RS, R>,
//    //            QR extends EntityQueryRelatedFetchedExpression3<E, R1, R2, R1, RC, RL, RS, R>> RE relate1(
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
//    <RE extends EntityQueryRelateExpression3<E, R1, R2, R1, QR, RC, RL, RS, R>,
//            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R1, RC, RL, RS>,
//            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R1, RC, RL, RS>,
//            QR extends EntityQueryRelatedFetchedExpression3FFF<E, R1, R2, R1, RC, RL, RS>,
//            RS extends EntitySortExpression4<E, R1, R2, R1, RS>> RE join1(SerializableFunction1<R1, R1> propertyName);
//
//    // ********************************************************************
//    // 2
//    // ********************************************************************
//
//    //    /**
//    //     * relate to.
//    //     *
//    //     * @param <RE>         the generic type
//    //     * @param <QR>         the generic type
//    //     * @param <R3>         the generic type
//    //     * @param propertyName find type object property name
//    //     * @return TypeQueryWithOnExpression
//    //     */
//    //    default <RE extends EntityQueryRelateExpression3<E, R1, R2, R3, QR, RC, RL, RS, R>,
//    //            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS>,
//    //            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS>,
//    //            QR extends EntityQueryRelatedFetchedExpression3<E, R1, R2, R3, RC, RL, RS, R>,
//    //            R3> RE relate2(SerializableFunction1<R2, R3> propertyName) {
//    //        return join2(propertyName);
//    //    }
//
//    /**
//     * join on.
//     *
//     * @param <RE>         the generic type
//     * @param <QR>         the generic type
//     * @param <R3>         the generic type
//     * @param propertyName find type object property name
//     * @return TypeQueryWithOnExpression
//     */
//    <RE extends EntityQueryRelateExpression3<E, R1, R2, R3, QR, RC, RL, RS, R>,
//            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS>,
//            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS>,
//            QR extends EntityQueryRelatedFetchedExpression3FFF<E, R1, R2, R3, RC, RL, RS>,
//            RS extends EntitySortExpression4<E, R1, R2, R3, RS>,
//            R3> RE join2(SerializableFunction1<R2, R3> propertyName);
//
//    //    /**
//    //     * relate to.
//    //     *
//    //     * @param <RE>         the generic type
//    //     * @param <QR>         the generic type
//    //     * @param <R3>         the generic type
//    //     * @param propertyName find type object property name
//    //     * @return TypeQueryWithOnExpression
//    //     */
//    //    default <RE extends EntityQueryRelateExpression3<E, R1, R2, R3, QR, RC, RL, RS, R>,
//    //            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS>,
//    //            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS>,
//    //            QR extends EntityQueryRelatedFetchedExpression3<E, R1, R2, R3, RC, RL, RS, R>,
//    //            R3> RE relate2(SerializableFunction2<R3, R2> propertyName) {
//    //        return join2(propertyName);
//    //    }
//
//    /**
//     * join on.
//     *
//     * @param <RE>         the generic type
//     * @param <QR>         the generic type
//     * @param <R3>         the generic type
//     * @param propertyName find type object property name
//     * @return TypeQueryWithOnExpression
//     */
//    <RE extends EntityQueryRelateExpression3<E, R1, R2, R3, QR, RC, RL, RS, R>,
//            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS>,
//            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS>,
//            QR extends EntityQueryRelatedFetchedExpression3FFF<E, R1, R2, R3, RC, RL, RS>,
//            RS extends EntitySortExpression4<E, R1, R2, R3, RS>,
//            R3> RE join2(SerializableFunction2<R3, R2> propertyName);
//
//    //    /**
//    //     * relate to.
//    //     *
//    //     * @param <RE>         the generic type
//    //     * @param <QR>         the generic type
//    //     * @param propertyName find type object property name
//    //     * @return TypeQueryWithOnExpression
//    //     */
//    //    default <RE extends EntityQueryRelateExpression3<E, R1, R2, R2, QR, RC, RL, RS, R>,
//    //            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R2, RC, RL, RS, R>,
//    //            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R2, RC, RL, RS, R>,
//    //            QR extends EntityQueryRelatedFetchedExpression3<E, R1, R2, R2, RC, RL, RS, R>> RE relate2(
//    //                    SerializableFunction3<R2, R2> propertyName) {
//    //        return join2(propertyName);
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
//    <RE extends EntityQueryRelateExpression3<E, R1, R2, R2, QR, RC, RL, RS, R>,
//            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R2, RC, RL, RS>,
//            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R2, RC, RL, RS>,
//            QR extends EntityQueryRelatedFetchedExpression3FFF<E, R1, R2, R2, RC, RL, RS>,
//            RS extends EntitySortExpression4<E, R1, R2, R2, RS>> RE join2(SerializableFunction3<R2, R2> propertyName);
//
//}
