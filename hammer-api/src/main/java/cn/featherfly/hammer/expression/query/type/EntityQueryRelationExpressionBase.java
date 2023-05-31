//
//package cn.featherfly.hammer.expression.query.type;
//
//import cn.featherfly.common.lang.function.SerializableFunction;
//import cn.featherfly.common.lang.function.SerializableFunction1;
//import cn.featherfly.common.lang.function.SerializableFunction2;
//import cn.featherfly.hammer.expression.EntityConditionGroupExpression2;
//import cn.featherfly.hammer.expression.EntityConditionGroupLogicExpression2;
//import cn.featherfly.hammer.expression.EntityWhereExpression2;
//import cn.featherfly.hammer.expression.query.QueryCountExecutor;
//
///**
// * The Interface TypeQueryWithExpression.
// *
// * @author zhongj
// * @param <E>  the element type
// * @param <R1> relate from type
// * @param <Q>  the generic type
// * @param <C>  the generic type
// * @param <L>  the generic type
// * @param <R>  the generic type
// */
//
//public interface EntityQueryRelationExpressionBase<E, R1, C extends EntityConditionGroupExpression2<E, R1, C, L>,
//        L extends EntityConditionGroupLogicExpression2<E, R1, C, L>, R> extends EntityWhereExpression2<E, R1, C, L>,
//        EntityQueryListExecutor<R>, QueryCountExecutor, EntityQueryConditionLimit<R> {
//
//    /**
//     * relate to.
//     *
//     * @param <RE>         the generic type
//     * @param <QR>         the generic type
//     * @param <R2>         the generic type
//     * @param propertyName find type object property name
//     * @return TypeQueryWithOnExpression
//     */
//    default <RE extends EntityQueryRelationEntityExpression2<E, R1, R2, QR, C, L>,
//            QR extends EntityQueryRelationExpression2<E, R1, R2, C, L>,
//            R2> RE relate(SerializableFunction<E, R2> propertyName) {
//        return join(propertyName);
//    }
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
//    <RE extends EntityQueryRelationEntityExpression2<E, R1, R2, QR, C, L>,
//            QR extends EntityQueryRelationExpression2<E, R1, R2, C, L>,
//            R2> RE join(SerializableFunction<E, R2> propertyName);
//
//    /**
//     * relate to.
//     *
//     * @param <RE>         the generic type
//     * @param <QR>         the generic type
//     * @param <R2>         the generic type
//     * @param propertyName find type object property name
//     * @return TypeQueryWithOnExpression
//     */
//    default <RE extends EntityQueryRelationEntityExpression2<E, R1, R2, QR, C, L>,
//            QR extends EntityQueryRelationExpression2<E, R1, R2, C, L>,
//            R2> RE relate(SerializableFunction2<R2, E> propertyName) {
//        return join(propertyName);
//    }
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
//    <RE extends EntityQueryRelationEntityExpression2<E, R1, R2, QR, C, L>,
//            QR extends EntityQueryRelationExpression2<E, R1, R2, C, L>,
//            R2> RE join(SerializableFunction2<R2, E> propertyName);
//
//    /**
//     * relate to.
//     *
//     * @param <RE>         the generic type
//     * @param <QR>         the generic type
//     * @param propertyName find type object property name
//     * @return TypeQueryWithOnExpression
//     */
//    default <RE extends EntityQueryRelationEntityExpression2<E, R1, E, QR, C, L>,
//            QR extends EntityQueryRelationExpression2<E, R1, E, C, L>> RE relate(
//                    SerializableFunction1<E, E> propertyName) {
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
//    <RE extends EntityQueryRelationEntityExpression2<E, R1, E, QR, C, L>,
//            QR extends EntityQueryRelationExpression2<E, R1, E, C, L>> RE join(
//                    SerializableFunction1<E, E> propertyName);
//
//    /**
//     * relate to.
//     *
//     * @param <RE>         the generic type
//     * @param <QR>         the generic type
//     * @param <R2>         the generic type
//     * @param propertyName find type object property name
//     * @return TypeQueryWithOnExpression
//     */
//    default <RE extends EntityQueryRelationEntityExpression2<E, R1, R2, QR, C, L>,
//            QR extends EntityQueryRelationExpression2<E, R1, R2, C, L>,
//            R2> RE relate1(SerializableFunction<R1, R2> propertyName) {
//        return join1(propertyName);
//    }
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
//    <RE extends EntityQueryRelationEntityExpression2<E, R1, R2, QR, C, L>,
//            QR extends EntityQueryRelationExpression2<E, R1, R2, C, L>,
//            R2> RE join1(SerializableFunction<R1, R2> propertyName);
//
//    /**
//     * relate to.
//     *
//     * @param <RE>         the generic type
//     * @param <QR>         the generic type
//     * @param <R2>         the generic type
//     * @param propertyName find type object property name
//     * @return TypeQueryWithOnExpression
//     */
//    default <RE extends EntityQueryRelationEntityExpression2<E, R1, R2, QR, C, L>,
//            QR extends EntityQueryRelationExpression2<E, R1, R2, C, L>,
//            R2> RE relate1(SerializableFunction2<R2, R1> propertyName) {
//        return join1(propertyName);
//    }
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
//    <RE extends EntityQueryRelationEntityExpression2<E, R1, R2, QR, C, L>,
//            QR extends EntityQueryRelationExpression2<E, R1, R2, C, L>,
//            R2> RE join1(SerializableFunction2<R2, R1> propertyName);
//
//    /**
//     * relate to.
//     *
//     * @param <RE>         the generic type
//     * @param <QR>         the generic type
//     * @param propertyName find type object property name
//     * @return TypeQueryWithOnExpression
//     */
//    default <RE extends EntityQueryRelationEntityExpression2<E, R1, R1, QR, C, L>,
//            QR extends EntityQueryRelationExpression2<E, R1, R1, C, L>> RE relate1(
//                    SerializableFunction1<R1, R1> propertyName) {
//        return join1(propertyName);
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
//    <RE extends EntityQueryRelationEntityExpression2<E, R1, R1, QR, C, L>,
//            QR extends EntityQueryRelationExpression2<E, R1, R1, C, L>> RE join1(
//                    SerializableFunction1<R1, R1> propertyName);
//
//}
