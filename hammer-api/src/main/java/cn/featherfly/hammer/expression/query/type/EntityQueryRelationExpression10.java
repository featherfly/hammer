//
//package cn.featherfly.hammer.expression.query.type;
//
//import cn.featherfly.hammer.expression.EntityConditionGroupExpression2;
//import cn.featherfly.hammer.expression.EntityConditionGroupLogicExpression2;
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
// */
//
//public interface EntityQueryRelationExpression10<E, R1, Q extends EntityQueryEntityPropertiesExpression<E, Q, C, L>,
//        C extends EntityConditionGroupExpression2<E, R1, C, L>,
//        L extends EntityConditionGroupLogicExpression2<E, R1, C, L>>
//        //    extends EntityQueryExpression<E, Q, C, L>
//        extends EntityQueryRelationExpressionBase<E, R1, Q, C, L, E> {
//    // YUFEI_TODO 后续再看是否需优化QueryCountExecutor
//    // EntityQueryRelationExpression 继承
//    // EntityWhereExpression<E, C, L>,    EntityQueryListExecutor<E>,   EntityQueryConditionLimit<E>
//    // EntityQueryExpression 继承
//    // EntityWhereExpression<E, C, L>,    EntityQueryListExecutor<E>,   EntityQueryConditionLimit<E>,   QueryCountExecutor
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
//    //    @Override
//    //    default <RE extends EntityQueryRelationEntityExpression2<E, R1, R2, Q, QR, C, L>,
//    //            QR extends EntityQueryRelationExpression2<E, R1, R2, Q, C, L>,
//    //            R2> RE relate(SerializableFunction<E, R2> propertyName) {
//    //        return join(propertyName);
//    //    }
//    //
//    //    /**
//    //     * join on.
//    //     *
//    //     * @param <RE>         the generic type
//    //     * @param <QR>         the generic type
//    //     * @param <R2>         the generic type
//    //     * @param propertyName find type object property name
//    //     * @return TypeQueryWithOnExpression
//    //     */
//    //    @Override
//    //    <RE extends EntityQueryRelationEntityExpression2<E, R1, R2, Q, QR, C, L>,
//    //            QR extends EntityQueryRelationExpression2<E, R1, R2, Q, C, L>,
//    //            R2> RE join(SerializableFunction<E, R2> propertyName);
//    //
//    //    /**
//    //     * relate to.
//    //     *
//    //     * @param <RE>         the generic type
//    //     * @param <QR>         the generic type
//    //     * @param <R2>         the generic type
//    //     * @param propertyName find type object property name
//    //     * @return TypeQueryWithOnExpression
//    //     */
//    //    @Override
//    //    default <RE extends EntityQueryRelationEntityExpression2<E, R1, R2, Q, QR, C, L>,
//    //            QR extends EntityQueryRelationExpression2<E, R1, R2, Q, C, L>,
//    //            R2> RE relate(SerializableFunction2<R2, E> propertyName) {
//    //        return join(propertyName);
//    //    }
//    //
//    //    /**
//    //     * join on.
//    //     *
//    //     * @param <RE>         the generic type
//    //     * @param <QR>         the generic type
//    //     * @param <R2>         the generic type
//    //     * @param propertyName find type object property name
//    //     * @return TypeQueryWithOnExpression
//    //     */
//    //    @Override
//    //    <RE extends EntityQueryRelationEntityExpression2<E, R1, R2, Q, QR, C, L>,
//    //            QR extends EntityQueryRelationExpression2<E, R1, R2, Q, C, L>,
//    //            R2> RE join(SerializableFunction2<R2, E> propertyName);
//    //
//    //    /**
//    //     * relate to.
//    //     *
//    //     * @param <RE>         the generic type
//    //     * @param <QR>         the generic type
//    //     * @param propertyName find type object property name
//    //     * @return TypeQueryWithOnExpression
//    //     */
//    //    @Override
//    //    default <RE extends EntityQueryRelationEntityExpression2<E, R1, E, Q, QR, C, L>,
//    //            QR extends EntityQueryRelationExpression2<E, R1, E, Q, C, L>> RE relate(
//    //                    SerializableFunction1<E, E> propertyName) {
//    //        return join(propertyName);
//    //    }
//    //
//    //    /**
//    //     * join on.
//    //     *
//    //     * @param <RE>         the generic type
//    //     * @param <QR>         the generic type
//    //     * @param propertyName find type object property name
//    //     * @return TypeQueryWithOnExpression
//    //     */
//    //    @Override
//    //    <RE extends EntityQueryRelationEntityExpression2<E, R1, E, Q, QR, C, L>,
//    //            QR extends EntityQueryRelationExpression2<E, R1, E, Q, C, L>> RE join(
//    //                    SerializableFunction1<E, E> propertyName);
//    //
//    //    /**
//    //     * relate to.
//    //     *
//    //     * @param <RE>         the generic type
//    //     * @param <QR>         the generic type
//    //     * @param <R2>         the generic type
//    //     * @param propertyName find type object property name
//    //     * @return TypeQueryWithOnExpression
//    //     */
//    //    @Override
//    //    default <RE extends EntityQueryRelationEntityExpression2<E, R1, R2, Q, QR, C, L>,
//    //            QR extends EntityQueryRelationExpression2<E, R1, R2, Q, C, L>,
//    //            R2> RE relate1(SerializableFunction<R1, R2> propertyName) {
//    //        return join1(propertyName);
//    //    }
//    //
//    //    /**
//    //     * join on.
//    //     *
//    //     * @param <RE>         the generic type
//    //     * @param <QR>         the generic type
//    //     * @param <R2>         the generic type
//    //     * @param propertyName find type object property name
//    //     * @return TypeQueryWithOnExpression
//    //     */
//    //    @Override
//    //    <RE extends EntityQueryRelationEntityExpression2<E, R1, R2, Q, QR, C, L>,
//    //            QR extends EntityQueryRelationExpression2<E, R1, R2, Q, C, L>,
//    //            R2> RE join1(SerializableFunction<R1, R2> propertyName);
//    //
//    //    /**
//    //     * relate to.
//    //     *
//    //     * @param <RE>         the generic type
//    //     * @param <QR>         the generic type
//    //     * @param <R2>         the generic type
//    //     * @param propertyName find type object property name
//    //     * @return TypeQueryWithOnExpression
//    //     */
//    //    @Override
//    //    default <RE extends EntityQueryRelationEntityExpression2<E, R1, R2, Q, QR, C, L>,
//    //            QR extends EntityQueryRelationExpression2<E, R1, R2, Q, C, L>,
//    //            R2> RE relate1(SerializableFunction2<R2, R1> propertyName) {
//    //        return join1(propertyName);
//    //    }
//    //
//    //    /**
//    //     * join on.
//    //     *
//    //     * @param <RE>         the generic type
//    //     * @param <QR>         the generic type
//    //     * @param <R2>         the generic type
//    //     * @param propertyName find type object property name
//    //     * @return TypeQueryWithOnExpression
//    //     */
//    //    @Override
//    //    <RE extends EntityQueryRelationEntityExpression2<E, R1, R2, Q, QR, C, L>,
//    //            QR extends EntityQueryRelationExpression2<E, R1, R2, Q, C, L>,
//    //            R2> RE join1(SerializableFunction2<R2, R1> propertyName);
//    //
//    //    /**
//    //     * relate to.
//    //     *
//    //     * @param <RE>         the generic type
//    //     * @param <QR>         the generic type
//    //     * @param propertyName find type object property name
//    //     * @return TypeQueryWithOnExpression
//    //     */
//    //    @Override
//    //    default <RE extends EntityQueryRelationEntityExpression2<E, R1, R1, Q, QR, C, L>,
//    //            QR extends EntityQueryRelationExpression2<E, R1, R1, Q, C, L>> RE relate1(
//    //                    SerializableFunction1<R1, R1> propertyName) {
//    //        return join1(propertyName);
//    //    }
//    //
//    //    /**
//    //     * join on.
//    //     *
//    //     * @param <RE>         the generic type
//    //     * @param <QR>         the generic type
//    //     * @param propertyName find type object property name
//    //     * @return TypeQueryWithOnExpression
//    //     */
//    //    @Override
//    //    <RE extends EntityQueryRelationEntityExpression2<E, R1, R1, Q, QR, C, L>,
//    //            QR extends EntityQueryRelationExpression2<E, R1, R1, Q, C, L>> RE join1(
//    //                    SerializableFunction1<R1, R1> propertyName);
//
//}
