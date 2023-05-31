
package cn.featherfly.hammer.expression.query.type;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableFunction1;
import cn.featherfly.common.lang.function.SerializableFunction2;
import cn.featherfly.common.lang.function.SerializableFunction3;
import cn.featherfly.hammer.expression.api.entity.EntityQueryRelate;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression3;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression4;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression3;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression4;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression3;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression4;

/**
 * The Interface EntityQueryRelationEntityExpression2.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 * @param <R2> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 * @param <S>  the generic type
 * @param <F>  the generic type
 * @param <FC> the generic type
 * @param <FL> the generic type
 * @param <FS> the generic type
 */
public interface EntityQueryRelateExpression2R<E, R1, R2,
        C extends EntityQueryConditionGroupExpression3<E, R1, R2, C, L, S, E>,
        L extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, C, L, S, E>,
        S extends EntityQuerySortExpression3<E, R1, R2, E>,
        F extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, FC, FL, FS>,
        FC extends EntityQueryConditionGroupExpression3<E, R1, R2, FC, FL, FS, Tuple2<E, R2>>,
        FL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, FC, FL, FS, Tuple2<E, R2>>,
        FS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>>
        extends EntityQueryExpression3<E, R1, R2, C, L, S, E>, EntityQueryRelate<F> {

    //    /**
    //     * relate to.
    //     *
    //     * @param <RE>         the generic type
    //     * @param <QR>         the generic type
    //     * @param <R3>         the generic type
    //     * @param propertyName find type object property name
    //     * @return TypeQueryWithOnExpression
    //     */
    //    default <RE extends EntityQueryRelateExpression3<E, R1, R2, R3, RC,RL,RS, QR, QRC, QRL, QRS, E>,
    //            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R2>>,
    //            QR extends EntityQueryRelatedFetchedExpression3RRF<E, R1, R2, R3, QRC, QRL, QRS>,
    //            R3> RE relate(SerializableFunction<E, R3> propertyName) {
    //        return join(propertyName);
    //    }

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <RC>         the generic type
     * @param <RL>         the generic type
     * @param <RS>         the generic type
     * @param <QR>         the generic type
     * @param <QRC>        the generic type
     * @param <QRL>        the generic type
     * @param <QRS>        the generic type
     * @param <R3>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    <RE extends EntityQueryRelateExpression3RR<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, E>,
            QR extends EntityQueryRelatedFetchedExpression3RRF<E, R1, R2, R3, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R3>>,
            R3> RE join(SerializableFunction<E, R3> propertyName);

    //    /**
    //     * relate to.
    //     *
    //     * @param <RE>         the generic type
    //     * @param <QR>         the generic type
    //     * @param <R3>         the generic type
    //     * @param propertyName find type object property name
    //     * @return TypeQueryWithOnExpression
    //     */
    //    default <RE extends EntityQueryRelateExpression3<E, R1, R2, R3, RC,RL,RS, QR, QRC, QRL, QRS, R>,
    //            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS>,
    //            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS>,
    //            QR extends EntityQueryRelatedFetchedExpression3RRF<E, R1, R2, R3, QRC, QRL, QRS>,
    //            QRS extends EntitySortExpression4<E, R1, R2, R3, QRS>,
    //            R3> RE relate(SerializableFunction2<R3, E> propertyName) {
    //        return join(propertyName);
    //    }

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <RC>         the generic type
     * @param <RL>         the generic type
     * @param <RS>         the generic type
     * @param <QR>         the generic type
     * @param <QRC>        the generic type
     * @param <QRL>        the generic type
     * @param <QRS>        the generic type
     * @param <R3>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    <RE extends EntityQueryRelateExpression3RR<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, E>,
            QR extends EntityQueryRelatedFetchedExpression3RRF<E, R1, R2, R3, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R3>>,
            R3> RE join(SerializableFunction2<R3, E> propertyName);

    //    /**
    //     * relate to.
    //     *
    //     * @param <RE>         the generic type
    //     * @param <QR>         the generic type
    //     * @param propertyName find type object property name
    //     * @return TypeQueryWithOnExpression
    //     */
    //    default <RE extends EntityQueryRelateExpression3<E, R1, R2, E, QR, QRC, QRL, QRS, R>,
    //            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, E, QRC, QRL, QRS>,
    //            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, E, QRC, QRL, QRS>,
    //            QR extends EntityQueryRelatedFetchedExpression3RRF<E, R1, R2, E, QRC, QRL, QRS>,
    //            QRS extends EntitySortExpression4<E, R1, R2, E, QRS>> RE relate(SerializableFunction1<E, E> propertyName) {
    //        return join(propertyName);
    //    }

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <RC>         the generic type
     * @param <RL>         the generic type
     * @param <RS>         the generic type
     * @param <QR>         the generic type
     * @param <QRC>        the generic type
     * @param <QRL>        the generic type
     * @param <QRS>        the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    <RE extends EntityQueryRelateExpression3RR<E, R1, R2, E, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, E, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, E, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression4<E, R1, R2, E, E>,
            QR extends EntityQueryRelatedFetchedExpression3RRF<E, R1, R2, E, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, E, QRC, QRL, QRS, Tuple2<E, E>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, E, QRC, QRL, QRS, Tuple2<E, E>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, E, Tuple2<E, E>>> RE join(
                    SerializableFunction1<E, E> propertyName);

    //    /**
    //     * relate to.
    //     *
    //     * @param <RE>         the generic type
    //     * @param <QR>         the generic type
    //     * @param <R3>         the generic type
    //     * @param propertyName find type object property name
    //     * @return TypeQueryWithOnExpression
    //     */
    //    default <RE extends EntityQueryRelateExpression3<E, R1, R2, R3, RC,RL,RS, QR, QRC, QRL, QRS, R>,
    //            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS>,
    //            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS>,
    //            QR extends EntityQueryRelatedFetchedExpression3RRF<E, R1, R2, R3, QRC, QRL, QRS>,
    //            QRS extends EntitySortExpression4<E, R1, R2, R3, QRS>,
    //            R3> RE relate1(SerializableFunction<R1, R3> propertyName) {
    //        return join1(propertyName);
    //    }

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <RC>         the generic type
     * @param <RL>         the generic type
     * @param <RS>         the generic type
     * @param <QR>         the generic type
     * @param <QRC>        the generic type
     * @param <QRL>        the generic type
     * @param <QRS>        the generic type
     * @param <R3>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    <RE extends EntityQueryRelateExpression3RR<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, E>,
            QR extends EntityQueryRelatedFetchedExpression3RRF<E, R1, R2, R3, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R3>>,
            R3> RE join1(SerializableFunction<R1, R3> propertyName);

    //    /**
    //     * relate to.
    //     *
    //     * @param <RE>         the generic type
    //     * @param <QR>         the generic type
    //     * @param <R3>         the generic type
    //     * @param propertyName find type object property name
    //     * @return TypeQueryWithOnExpression
    //     */
    //    default <RE extends EntityQueryRelateExpression3<E, R1, R2, R3, RC,RL,RS, QR, QRC, QRL, QRS, R>,
    //            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS>,
    //            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS>,
    //            QR extends EntityQueryRelatedFetchedExpression3RRF<E, R1, R2, R3, QRC, QRL, QRS>,
    //            QRS extends EntitySortExpression4<E, R1, R2, R3, QRS>,
    //            R3> RE relate1(SerializableFunction2<R3, R1> propertyName) {
    //        return join1(propertyName);
    //    }

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <RC>         the generic type
     * @param <RL>         the generic type
     * @param <RS>         the generic type
     * @param <QR>         the generic type
     * @param <QRC>        the generic type
     * @param <QRL>        the generic type
     * @param <QRS>        the generic type
     * @param <R3>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    <RE extends EntityQueryRelateExpression3RR<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, E>,
            QR extends EntityQueryRelatedFetchedExpression3RRF<E, R1, R2, R3, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R3>>,
            R3> RE join1(SerializableFunction2<R3, R1> propertyName);

    //    /**
    //     * relate to.
    //     *
    //     * @param <RE>         the generic type
    //     * @param <QR>         the generic type
    //     * @param propertyName find type object property name
    //     * @return TypeQueryWithOnExpression
    //     */
    //    default <RE extends EntityQueryRelateExpression3<E, R1, R2, R1, QR, QRC, QRL, QRS, R>,
    //            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R1, QRC, QRL, QRS, R>,
    //            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R1, QRC, QRL, QRS, R>,
    //            QR extends EntityQueryRelatedFetchedExpression3<E, R1, R2, R1, QRC, QRL, QRS, R>> RE relate1(
    //                    SerializableFunction1<R1, R1> propertyName) {
    //        return join1(propertyName);
    //    }

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <RC>         the generic type
     * @param <RL>         the generic type
     * @param <RS>         the generic type
     * @param <QR>         the generic type
     * @param <QRC>        the generic type
     * @param <QRL>        the generic type
     * @param <QRS>        the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    <RE extends EntityQueryRelateExpression3RR<E, R1, R2, R1, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R1, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R1, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R1, E>,
            QR extends EntityQueryRelatedFetchedExpression3RRF<E, R1, R2, R1, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R1, QRC, QRL, QRS, Tuple2<E, R1>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R1, QRC, QRL, QRS, Tuple2<E, R1>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R1, Tuple2<E, R1>>> RE join1(
                    SerializableFunction1<R1, R1> propertyName);

    // ********************************************************************
    // 2
    // ********************************************************************

    //    /**
    //     * relate to.
    //     *
    //     * @param <RE>         the generic type
    //     * @param <QR>         the generic type
    //     * @param <R3>         the generic type
    //     * @param propertyName find type object property name
    //     * @return TypeQueryWithOnExpression
    //     */
    //    default <RE extends EntityQueryRelateExpression3<E, R1, R2, R3, RC,RL,RS, QR, QRC, QRL, QRS, R>,
    //            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS>,
    //            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS>,
    //            QR extends EntityQueryRelatedFetchedExpression3<E, R1, R2, R3, QRC, QRL, QRS, R>,
    //            R3> RE relate2(SerializableFunction1<R2, R3> propertyName) {
    //        return join2(propertyName);
    //    }

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <RC>         the generic type
     * @param <RL>         the generic type
     * @param <RS>         the generic type
     * @param <QR>         the generic type
     * @param <QRC>        the generic type
     * @param <QRL>        the generic type
     * @param <QRS>        the generic type
     * @param <R3>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    <RE extends EntityQueryRelateExpression3RR<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, E>,
            QR extends EntityQueryRelatedFetchedExpression3RRF<E, R1, R2, R3, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R3>>,
            R3> RE join2(SerializableFunction1<R2, R3> propertyName);

    //    /**
    //     * relate to.
    //     *
    //     * @param <RE>         the generic type
    //     * @param <QR>         the generic type
    //     * @param <R3>         the generic type
    //     * @param propertyName find type object property name
    //     * @return TypeQueryWithOnExpression
    //     */
    //    default <RE extends EntityQueryRelateExpression3<E, R1, R2, R3, RC,RL,RS, QR, QRC, QRL, QRS, R>,
    //            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS>,
    //            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS>,
    //            QR extends EntityQueryRelatedFetchedExpression3<E, R1, R2, R3, QRC, QRL, QRS, R>,
    //            R3> RE relate2(SerializableFunction2<R3, R2> propertyName) {
    //        return join2(propertyName);
    //    }

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <RC>         the generic type
     * @param <RL>         the generic type
     * @param <RS>         the generic type
     * @param <QR>         the generic type
     * @param <QRC>        the generic type
     * @param <QRL>        the generic type
     * @param <QRS>        the generic type
     * @param <R3>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    <RE extends EntityQueryRelateExpression3RR<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, E>,
            QR extends EntityQueryRelatedFetchedExpression3RRF<E, R1, R2, R3, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R3>>,
            R3> RE join2(SerializableFunction2<R3, R2> propertyName);

    //    /**
    //     * relate to.
    //     *
    //     * @param <RE>         the generic type
    //     * @param <QR>         the generic type
    //     * @param propertyName find type object property name
    //     * @return TypeQueryWithOnExpression
    //     */
    //    default <RE extends EntityQueryRelateExpression3<E, R1, R2, R2, QR, QRC, QRL, QRS, R>,
    //            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R2, QRC, QRL, QRS, R>,
    //            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R2, QRC, QRL, QRS, R>,
    //            QR extends EntityQueryRelatedFetchedExpression3<E, R1, R2, R2, QRC, QRL, QRS, R>> RE relate2(
    //                    SerializableFunction3<R2, R2> propertyName) {
    //        return join2(propertyName);
    //    }

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <RC>         the generic type
     * @param <RL>         the generic type
     * @param <RS>         the generic type
     * @param <QR>         the generic type
     * @param <QRC>        the generic type
     * @param <QRL>        the generic type
     * @param <QRS>        the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    <RE extends EntityQueryRelateExpression3RR<E, R1, R2, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R2, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R2, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R2, E>,
            QR extends EntityQueryRelatedFetchedExpression3RRF<E, R1, R2, R2, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R2, Tuple2<E, R2>>> RE join2(
                    SerializableFunction3<R2, R2> propertyName);

}
