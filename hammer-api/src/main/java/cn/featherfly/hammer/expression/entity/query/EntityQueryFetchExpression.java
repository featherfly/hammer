//
//package cn.featherfly.hammer.expression.entity.query;
//
//import com.speedment.common.tuple.Tuple2;
//
//import cn.featherfly.common.function.serializable.SerializableFunction1;
//import cn.featherfly.common.function.serializable.SerializableFunction2;
//import cn.featherfly.common.function.serializable.SerializableUnaryOperator1;
//import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelateExpression1P;
//import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelateExpression1R;
//import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelatedExpression;
//import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelatedFetchedExpression1F;
//import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelatedFetchedExpression1P;
//
///**
// * EntityQueryFetchExpression .
// *
// * @author zhongj
// * @param <E>  the query type
// * @param <C>  the generic type
// * @param <L>  the generic type
// * @param <Q>  the generic type
// * @param <CV> the generic type
// * @param <LV> the generic type
// * @param <S>  the generic type
// */
//public interface EntityQueryFetchExpression<E, C extends EntityQueryConditionGroupExpression<E, C, L, S>,
//        L extends EntityQueryConditionGroupLogicExpression<E, C, L, S>,
//        Q extends EntityQueryFetchedPropertyExpression<E, CV, LV, Q, S>,
//        CV extends EntityQueryValueConditionGroupExpression<E, CV, LV, S>,
//        LV extends EntityQueryValueConditionGroupLogicExpression<E, CV, LV, S>, S extends EntityQuerySortExpression<E>>
//        extends EntityQueryExpression<E, C, L, S>, EntityQueryPropertiesExpression<E, Q> {
//
//    /**
//     * Join.
//     *
//     * @param <QR>     the generic type
//     * @param <RC>     the generic type
//     * @param <RL>     the generic type
//     * @param <RS>     the generic type
//     * @param <QRF>    the generic type
//     * @param <FC>     the generic type
//     * @param <FL>     the generic type
//     * @param <FS>     the generic type
//     * @param <R>      the generic type
//     * @param joinType the join type
//     * @return the entity query related expression
//     */
//    <QR extends EntityQueryRelateExpression1R<E, R, RC, RL, RS, QRF, FC, FL, FS>,
//            RC extends EntityQueryConditionGroupExpression2<E, R, RC, RL, RS, E>,
//            RL extends EntityQueryConditionGroupLogicExpression2<E, R, RC, RL, RS, E>,
//            RS extends EntityQuerySortExpression2<E, R, E>,
//            QRF extends EntityQueryRelatedFetchedExpression1F<E, R, FC, FL, FS>,
//            FC extends EntityQueryConditionGroupExpression2<E, R, FC, FL, FS, Tuple2<E, R>>,
//            FL extends EntityQueryConditionGroupLogicExpression2<E, R, FC, FL, FS, Tuple2<E, R>>,
//            FS extends EntityQuerySortExpression2<E, R, Tuple2<E, R>>,
//            R> EntityQueryRelatedExpression<E, R, QR, QRF> join(Class<R> joinType);
//
//    //    /**
//    //     * join on.
//    //     *
//    //     * @param <RE>         the generic type
//    //     * @param <RC>         the generic type
//    //     * @param <RL>         the generic type
//    //     * @param <RS>         the generic type
//    //     * @param <QR>         the generic type
//    //     * @param <FC>         the generic type
//    //     * @param <FL>         the generic type
//    //     * @param <FS>         the generic type
//    //     * @param <J>          the generic type
//    //     * @param <R>          the generic type
//    //     * @param propertyName find type object property name
//    //     * @param joinType     the join type
//    //     * @return EntityQueryRelateExpression
//    //     */
//    //    <RE extends EntityQueryRelateExpression<E, R, RC, RL, RS, QR, FC, FL, FS>,
//    //            RC extends EntityQueryConditionGroupExpression2<E, R, RC, RL, RS, E>,
//    //            RL extends EntityQueryConditionGroupLogicExpression2<E, R, RC, RL, RS, E>,
//    //            RS extends EntityQuerySortExpression2<E, R, E>,
//    //            QR extends EntityQueryRelatedFetchedExpression<E, R, FC, FL, FS>,
//    //            FC extends EntityQueryConditionGroupExpression2<E, R, FC, FL, FS, Tuple2<E, R>>,
//    //            FL extends EntityQueryConditionGroupLogicExpression2<E, R, FC, FL, FS, Tuple2<E, R>>,
//    //            FS extends EntityQuerySortExpression2<E, R, Tuple2<E, R>>, J,
//    //            R> RE join(SerializableFunction1<E, J> propertyName, Class<R> joinType);
//    //
//    //    /**
//    //     * join on.
//    //     *
//    //     * @param <RE>                 the generic type
//    //     * @param <RC>                 the generic type
//    //     * @param <RL>                 the generic type
//    //     * @param <RS>                 the generic type
//    //     * @param <QR>                 the generic type
//    //     * @param <FC>                 the generic type
//    //     * @param <FL>                 the generic type
//    //     * @param <FS>                 the generic type
//    //     * @param <J>                  the generic type
//    //     * @param <R>                  the generic type
//    //     * @param propertyName         find type object property name
//    //     * @param joinTypePropertyName the join type property name
//    //     * @return EntityQueryRelateExpression
//    //     */
//    //    <RE extends EntityQueryRelateExpression<E, R, RC, RL, RS, QR, FC, FL, FS>,
//    //            RC extends EntityQueryConditionGroupExpression2<E, R, RC, RL, RS, E>,
//    //            RL extends EntityQueryConditionGroupLogicExpression2<E, R, RC, RL, RS, E>,
//    //            RS extends EntityQuerySortExpression2<E, R, E>,
//    //            QR extends EntityQueryRelatedFetchedExpression<E, R, FC, FL, FS>,
//    //            FC extends EntityQueryConditionGroupExpression2<E, R, FC, FL, FS, Tuple2<E, R>>,
//    //            FL extends EntityQueryConditionGroupLogicExpression2<E, R, FC, FL, FS, Tuple2<E, R>>,
//    //            FS extends EntityQuerySortExpression2<E, R, Tuple2<E, R>>, J extends Number,
//    //            R> RE join(SerializableFunction1<E, J> propertyName, SerializableFunction1<R, J> joinTypePropertyName);
//
//    //    /**
//    //     * join on.
//    //     *
//    //     * @param <RE>                 the generic type
//    //     * @param <RC>                 the generic type
//    //     * @param <RL>                 the generic type
//    //     * @param <RS>                 the generic type
//    //     * @param <QR>                 the generic type
//    //     * @param <FC>                 the generic type
//    //     * @param <FL>                 the generic type
//    //     * @param <FS>                 the generic type
//    //     * @param <R>                  the generic type
//    //     * @param <J>                  the generic type
//    //     * @param joinTypePropertyName the join type property name
//    //     * @return EntityQueryRelateExpression
//    //     */
//    //    <RE extends EntityQueryRelateExpression<E, R, RC, RL, RS, QR, FC, FL, FS>,
//    //            RC extends EntityQueryConditionGroupExpression2<E, R, RC, RL, RS, E>,
//    //            RL extends EntityQueryConditionGroupLogicExpression2<E, R, RC, RL, RS, E>,
//    //            RS extends EntityQuerySortExpression2<E, R, E>,
//    //            QR extends EntityQueryRelatedFetchedExpression<E, R, FC, FL, FS>,
//    //            FC extends EntityQueryConditionGroupExpression2<E, R, FC, FL, FS, Tuple2<E, R>>,
//    //            FL extends EntityQueryConditionGroupLogicExpression2<E, R, FC, FL, FS, Tuple2<E, R>>,
//    //            FS extends EntityQuerySortExpression2<E, R, Tuple2<E, R>>, R,
//    //            J extends Number> RE join(SerializableToNumberFunction1<R, J> joinTypePropertyName);
//    //
//    //    /**
//    //     * join on.
//    //     *
//    //     * @param <RE>                 the generic type
//    //     * @param <RC>                 the generic type
//    //     * @param <RL>                 the generic type
//    //     * @param <RS>                 the generic type
//    //     * @param <QR>                 the generic type
//    //     * @param <FC>                 the generic type
//    //     * @param <FL>                 the generic type
//    //     * @param <FS>                 the generic type
//    //     * @param <R>                  the generic type
//    //     * @param joinTypePropertyName the join type property name
//    //     * @return EntityQueryRelateExpression
//    //     */
//    //    <RE extends EntityQueryRelateExpression<E, R, RC, RL, RS, QR, FC, FL, FS>,
//    //            RC extends EntityQueryConditionGroupExpression2<E, R, RC, RL, RS, E>,
//    //            RL extends EntityQueryConditionGroupLogicExpression2<E, R, RC, RL, RS, E>,
//    //            RS extends EntityQuerySortExpression2<E, R, E>,
//    //            QR extends EntityQueryRelatedFetchedExpression<E, R, FC, FL, FS>,
//    //            FC extends EntityQueryConditionGroupExpression2<E, R, FC, FL, FS, Tuple2<E, R>>,
//    //            FL extends EntityQueryConditionGroupLogicExpression2<E, R, FC, FL, FS, Tuple2<E, R>>,
//    //            FS extends EntityQuerySortExpression2<E, R, Tuple2<E, R>>,
//    //            R> RE join(SerializableToStringFunction1<R> joinTypePropertyName);
//
//    //    /**
//    //     * relate to .
//    //     *
//    //     * @param <RE>         the generic type
//    //     * @param <QR>         the generic type
//    //     * @param <R>          the generic type
//    //     * @param propertyName find type object property name
//    //     * @return EntityQueryRelateExpression
//    //     */
//    //    default <RE extends EntityQueryRelateExpression<E, R, QR, RC, RL, RS, R>,
//    //            RC extends EntityQueryConditionGroupExpression2<E, R, RC, RL, RS, R>,
//    //            RL extends EntityQueryConditionGroupLogicExpression2<E, R, RC, RL, RS, R>,
//    //            RS extends EntityQuerySortExpression2<E, R1, R>,
//    //            QR extends EntityQueryRelatedFetchedExpression<E, R, RC, RL, RS>, R1,
//    //            R> RE relate(SerializableFunction<E, R1> propertyName) {
//    //        return join(propertyName);
//    //    }
//
//    /**
//     * join on.
//     *
//     * @param <RE>         the generic type
//     * @param <RC>         the generic type
//     * @param <RL>         the generic type
//     * @param <RS>         the generic type
//     * @param <QR>         the generic type
//     * @param <R>          the generic type
//     * @param propertyName find type object property name
//     * @return EntityQueryRelateExpression
//     */
//    <RE extends EntityQueryRelateExpression1P<E, R, RC, RL, RS, QR>,
//            RC extends EntityQueryConditionGroupExpression2<E, R, RC, RL, RS, E>,
//            RL extends EntityQueryConditionGroupLogicExpression2<E, R, RC, RL, RS, E>,
//            RS extends EntityQuerySortExpression2<E, R, E>,
//            QR extends EntityQueryRelatedFetchedExpression1P<E, R, RC, RL, RS>,
//            R> RE join(SerializableFunction1<E, R> propertyName);
//
//    //    /**
//    //     * join on.
//    //     *
//    //     * @param <RE>                 the generic type
//    //     * @param <RC>                 the generic type
//    //     * @param <RL>                 the generic type
//    //     * @param <RS>                 the generic type
//    //     * @param <QR>                 the generic type
//    //     * @param <FC>                 the generic type
//    //     * @param <FL>                 the generic type
//    //     * @param <FS>                 the generic type
//    //     * @param <R>                  the generic type
//    //     * @param <J>                  the generic type
//    //     * @param propertyName         find type object property name
//    //     * @param joinType             the join type
//    //     * @param joinTypePropertyName the join type property name
//    //     * @return EntityQueryRelateExpression
//    //     */
//    //    <RE extends EntityQueryRelateExpression<E, R, RC, RL, RS, QR, FC, FL, FS>,
//    //            RC extends EntityQueryConditionGroupExpression2<E, R, RC, RL, RS, E>,
//    //            RL extends EntityQueryConditionGroupLogicExpression2<E, R, RC, RL, RS, E>,
//    //            RS extends EntityQuerySortExpression2<E, R, E>,
//    //            QR extends EntityQueryRelatedFetchedExpression<E, R, FC, FL, FS>,
//    //            FC extends EntityQueryConditionGroupExpression2<E, R, FC, FL, FS, Tuple2<E, R>>,
//    //            FL extends EntityQueryConditionGroupLogicExpression2<E, R, FC, FL, FS, Tuple2<E, R>>,
//    //            FS extends EntityQuerySortExpression2<E, R, Tuple2<E, R>>, R,
//    //            J> RE join(SerializableFunction1<E, J> propertyName, Class<R> joinType,
//    //                    SerializableFunction1<R, J> joinTypePropertyName);
//
//    //    /**
//    //     * relate to.
//    //     *
//    //     * @param <RE>         the generic type
//    //     * @param <QR>         the generic type
//    //     * @param <R>          the generic type
//    //     * @param propertyName find type object property name
//    //     * @return EntityQueryRelateExpression
//    //     */
//    //    default <RE extends EntityQueryRelateExpression<E, R, QR, RC, RL, RS>,
//    //            RC extends EntityQueryConditionGroupExpression2<E, R, RC, RL, RS>,
//    //            RL extends EntityQueryConditionGroupLogicExpression2<E, R, RC, RL, RS>,
//    //            RS extends EntitySortExpression2<E, R, RS>,
//    //            QR extends EntityQueryRelatedFetchedExpression<E, R, RC, RL, RS>,
//    //            R> RE relate(SerializableFunction2<R, E> propertyName) {
//    //        return join(propertyName);
//    //    }
//
//    /**
//     * join on.
//     *
//     * @param <RE>         the generic type
//     * @param <RC>         the generic type
//     * @param <RL>         the generic type
//     * @param <RS>         the generic type
//     * @param <QR>         the generic type
//     * @param <R>          the generic type
//     * @param propertyName find type object property name
//     * @return EntityQueryRelateExpression
//     */
//    <RE extends EntityQueryRelateExpression1R<E, R, RC, RL, RS, QRF, FC, FL, FS>,
//            RC extends EntityQueryConditionGroupExpression2<E, R, RC, RL, RS, E>,
//            RL extends EntityQueryConditionGroupLogicExpression2<E, R, RC, RL, RS, E>,
//            RS extends EntityQuerySortExpression2<E, R, E>,
//            QRF extends EntityQueryRelatedFetchedExpression1F<E, R, FC, FL, FS>,
//            FC extends EntityQueryConditionGroupExpression2<E, R, FC, FL, FS, Tuple2<E, R>>,
//            FL extends EntityQueryConditionGroupLogicExpression2<E, R, FC, FL, FS, Tuple2<E, R>>,
//            FS extends EntityQuerySortExpression2<E, R, Tuple2<E, R>>,
//            R> RE join(SerializableFunction2<R, E> propertyName);
//
//    //    /**
//    //     * relate to.
//    //     *
//    //     * @param <RE>         the generic type
//    //     * @param <QR>         the generic type
//    //     * @param propertyName find type object property name
//    //     * @return EntityQueryRelateExpression
//    //     */
//    //    default <RE extends EntityQueryRelateExpression<E, E, QR, RC, RL, RS, FC, FL, FS>,
//    //            RC extends EntityQueryConditionGroupExpression2<E, E, RC, RL, RS, E>,
//    //            RL extends EntityQueryConditionGroupLogicExpression2<E, E, RC, RL, RS, E>,
//    //            RS extends EntityQuerySortExpression2<E, E, E>,
//    //            FC extends EntityQueryConditionGroupExpression2<E, E, FC, FL, FS, Tuple2<E, E>>,
//    //            FL extends EntityQueryConditionGroupLogicExpression2<E, E, FC, FL, FS, Tuple2<E, E>>,
//    //            FS extends EntityQuerySortExpression2<E, E, Tuple2<E, E>>,
//    //            QR extends EntityQueryRelatedFetchedExpression<E, E, FC, FL, FS>> RE relate(
//    //                    SerializableUnaryOperator1<E> propertyName) {
//    //        return join(propertyName);
//    //    }
//
//    /**
//     * join on.
//     *
//     * @param <RE>         the generic type
//     * @param <RC>         the generic type
//     * @param <RL>         the generic type
//     * @param <RS>         the generic type
//     * @param <QR>         the generic type
//     * @param propertyName find type object property name
//     * @return EntityQueryRelateExpression
//     */
//    <RE extends EntityQueryRelateExpression1P<E, E, RC, RL, RS, QR>,
//            RC extends EntityQueryConditionGroupExpression2<E, E, RC, RL, RS, E>,
//            RL extends EntityQueryConditionGroupLogicExpression2<E, E, RC, RL, RS, E>,
//            RS extends EntityQuerySortExpression2<E, E, E>,
//            QR extends EntityQueryRelatedFetchedExpression1P<E, E, RC, RL, RS>> RE join(
//                    SerializableUnaryOperator1<E> propertyName);
//
//    //    /**
//    //     * join on.
//    //     *
//    //     * @param <RE>         the generic type
//    //     * @param <RC>         the generic type
//    //     * @param <RL>         the generic type
//    //     * @param <RS>         the generic type
//    //     * @param <QR>         the generic type
//    //     * @param <FC>         the generic type
//    //     * @param <FL>         the generic type
//    //     * @param <FS>         the generic type
//    //     * @param <J>          the generic type
//    //     * @param propertyName find type object property name
//    //     * @param joinType     the join type
//    //     * @return EntityQueryRelateExpression
//    //     */
//    //    <RE extends EntityQueryRelateExpression<E, E, RC, RL, RS, QR, FC, FL, FS>,
//    //            RC extends EntityQueryConditionGroupExpression2<E, E, RC, RL, RS, E>,
//    //            RL extends EntityQueryConditionGroupLogicExpression2<E, E, RC, RL, RS, E>,
//    //            RS extends EntityQuerySortExpression2<E, E, E>,
//    //            QR extends EntityQueryRelatedFetchedExpression<E, E, FC, FL, FS>,
//    //            FC extends EntityQueryConditionGroupExpression2<E, E, FC, FL, FS, Tuple2<E, E>>,
//    //            FL extends EntityQueryConditionGroupLogicExpression2<E, E, FC, FL, FS, Tuple2<E, E>>,
//    //            FS extends EntityQuerySortExpression2<E, E, Tuple2<E, E>>,
//    //            J> RE join(SerializableFunction3<E, J> propertyName, Class<E> joinType);
//    //
//    //    /**
//    //     * join on.
//    //     *
//    //     * @param <RE>                 the generic type
//    //     * @param <RC>                 the generic type
//    //     * @param <RL>                 the generic type
//    //     * @param <RS>                 the generic type
//    //     * @param <QR>                 the generic type
//    //     * @param <FC>                 the generic type
//    //     * @param <FL>                 the generic type
//    //     * @param <FS>                 the generic type
//    //     * @param <J>                  the generic type
//    //     * @param propertyName         find type object property name
//    //     * @param joinType             the join type
//    //     * @param joinTypePropertyName the join type property name
//    //     * @return EntityQueryRelateExpression
//    //     */
//    //    <RE extends EntityQueryRelateExpression<E, E, RC, RL, RS, QR, FC, FL, FS>,
//    //            RC extends EntityQueryConditionGroupExpression2<E, E, RC, RL, RS, E>,
//    //            RL extends EntityQueryConditionGroupLogicExpression2<E, E, RC, RL, RS, E>,
//    //            RS extends EntityQuerySortExpression2<E, E, E>,
//    //            QR extends EntityQueryRelatedFetchedExpression<E, E, FC, FL, FS>,
//    //            FC extends EntityQueryConditionGroupExpression2<E, E, FC, FL, FS, Tuple2<E, E>>,
//    //            FL extends EntityQueryConditionGroupLogicExpression2<E, E, FC, FL, FS, Tuple2<E, E>>,
//    //            FS extends EntityQuerySortExpression2<E, E, Tuple2<E, E>>,
//    //            J> RE join(SerializableFunction3<E, J> propertyName, SerializableFunction3<E, J> joinTypePropertyName);
//    //
//    //    /**
//    //     * join on.
//    //     *
//    //     * @param <RE>                 the generic type
//    //     * @param <RC>                 the generic type
//    //     * @param <RL>                 the generic type
//    //     * @param <RS>                 the generic type
//    //     * @param <QR>                 the generic type
//    //     * @param <FC>                 the generic type
//    //     * @param <FL>                 the generic type
//    //     * @param <FS>                 the generic type
//    //     * @param <J>                  the generic type
//    //     * @param propertyName         find type object property name
//    //     * @param joinType             the join type
//    //     * @param joinTypePropertyName the join type property name
//    //     * @return EntityQueryRelateExpression
//    //     */
//    //    <RE extends EntityQueryRelateExpression<E, E, RC, RL, RS, QR, FC, FL, FS>,
//    //            RC extends EntityQueryConditionGroupExpression2<E, E, RC, RL, RS, E>,
//    //            RL extends EntityQueryConditionGroupLogicExpression2<E, E, RC, RL, RS, E>,
//    //            RS extends EntityQuerySortExpression2<E, E, E>,
//    //            QR extends EntityQueryRelatedFetchedExpression<E, E, FC, FL, FS>,
//    //            FC extends EntityQueryConditionGroupExpression2<E, E, FC, FL, FS, Tuple2<E, E>>,
//    //            FL extends EntityQueryConditionGroupLogicExpression2<E, E, FC, FL, FS, Tuple2<E, E>>,
//    //            FS extends EntityQuerySortExpression2<E, E, Tuple2<E, E>>,
//    //            J> RE join(SerializableFunction3<E, J> propertyName, Class<E> joinType,
//    //                    SerializableFunction3<E, J> joinTypePropertyName);
//
//    //    /**
//    //     * relate to.
//    //     *
//    //     * @param <R>           the generic type
//    //     * @param propertyValue find type object property value
//    //     * @return EntityQueryRelateExpression
//    //     */
//    //    default <RE extends EntityQueryRelationEntityExpression<E, R, QR, C, L>,
//    //            QR extends EntityQueryRelationExpression<E, R, C, L>, R> RE relate(SerializableSupplier<R> propertyValue) {
//    //        return join(propertyValue);
//    //    }
//
//    //    /**
//    //     * join on.
//    //     *
//    //     * @param <R>           the generic type
//    //     * @param propertyValue find type object property value
//    //     * @return EntityQueryRelateExpression
//    //     */
//    //    <RE extends EntityQueryRelationEntityExpression<E, R, QR, C, L>,
//    //            QR extends EntityQueryRelationExpression<E, R, C, L>, R> RE join(SerializableSupplier<R> propertyValue);
//
//    //    /**
//    //     * join on.
//    //     *
//    //     * @param <R>          the generic type
//    //     * @param propertyName with type object property name
//    //     * @param index        with index, the first is 1
//    //     * @return EntityQueryRelateExpression
//    //     */
//    //    <RE extends EntityQueryRelationEntityExpression<E, R, C, L>, R> RE join(SerializableFunction<E, R> propertyName,
//    //            int index);
//}
