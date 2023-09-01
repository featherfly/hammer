
package cn.featherfly.hammer.expression.entity.query.relation;

import com.speedment.common.tuple.Tuple2;
import com.speedment.common.tuple.Tuple3;

import cn.featherfly.hammer.expression.api.entity.QueryRelate;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression5;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression5;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression5;

/**
 * The Interface EntityQueryRelateExpression4RFRR.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 * @param <R2> the generic type
 * @param <R3> the generic type
 * @param <R4> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 * @param <S>  the generic type
 * @param <F>  the generic type
 * @param <FC> the generic type
 * @param <FL> the generic type
 * @param <FS> the generic type
 */
public interface EntityQueryRelateExpression4RFRR<E, R1, R2, R3, R4,
        C extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, C, L, S, Tuple2<E, R2>>,
        L extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, C, L, S, Tuple2<E, R2>>,
        S extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple2<E, R2>>,
        F extends EntityQueryRelatedFetchedExpression4RFRF<E, R1, R2, R3, R4, FC, FL, FS>,
        FC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, FC, FL, FS, Tuple3<E, R2, R4>>,
        FL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, FC, FL, FS, Tuple3<E, R2, R4>>,
        FS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple3<E, R2, R4>>>
        extends EntityQueryRelateExpression4RFRXBase<E, R1, R2, R3, R4, C, L, S>, QueryRelate<F> {
    //    /**
    //     * join.
    //     *
    //     * @param <QR>     the generic type
    //     * @param <RC>     the generic type
    //     * @param <RL>     the generic type
    //     * @param <RS>     the generic type
    //     * @param <QRF>    the generic type
    //     * @param <QRC>    the generic type
    //     * @param <QRL>    the generic type
    //     * @param <QRS>    the generic type
    //     * @param <R5>     the generic type
    //     * @param joinType the join type
    //     * @return EntityQueryRelateExpression5RFRR
    //     */
    //    <QR extends EntityQueryRelateExpression5RFRRR<E, R1, R2, R3, R4, R5, RC, RL, RS, QRF, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple2<E, R2>>,
    //            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple2<E, R2>>,
    //            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple2<E, R2>>,
    //            QRF extends EntityQueryRelatedFetchedExpression5RFRRF<E, R1, R2, R3, R4, R5, QRC, QRL, QRS>,
    //            QRC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS, Tuple3<E, R2, R5>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
    //                    Tuple3<E, R2, R5>>,
    //            QRS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple3<E, R2, R5>>,
    //            R5> EntityQueryRelatedExpression<E, R5, QR, QRF> join(Class<R5> joinType);
    //
    //    /**
    //     * join on.
    //     *
    //     * @param <RE>         the generic type
    //     * @param <RC>         the generic type
    //     * @param <RL>         the generic type
    //     * @param <RS>         the generic type
    //     * @param <QR>         the generic type
    //     * @param <QRC>        the generic type
    //     * @param <QRL>        the generic type
    //     * @param <QRS>        the generic type
    //     * @param <R5>         the generic type
    //     * @param propertyName find type object property name
    //     * @return EntityQueryRelateExpression5RFRR
    //     */
    //    <RE extends EntityQueryRelateExpression5RFRRR<E, R1, R2, R3, R4, R5, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple2<E, R2>>,
    //            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple2<E, R2>>,
    //            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple2<E, R2>>,
    //            QR extends EntityQueryRelatedFetchedExpression5RFRRF<E, R1, R2, R3, R4, R5, QRC, QRL, QRS>,
    //            QRC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS, Tuple3<E, R2, R5>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
    //                    Tuple3<E, R2, R5>>,
    //            QRS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple3<E, R2, R5>>,
    //            R5> RE join(SerializableFunction2<R5, E> propertyName);
    //
    //    /**
    //     * join on.
    //     *
    //     * @param <RE>         the generic type
    //     * @param <RC>         the generic type
    //     * @param <RL>         the generic type
    //     * @param <RS>         the generic type
    //     * @param <QR>         the generic type
    //     * @param <QRC>        the generic type
    //     * @param <QRL>        the generic type
    //     * @param <QRS>        the generic type
    //     * @param <R5>         the generic type
    //     * @param propertyName find type object property name
    //     * @return EntityQueryRelateExpression5RFRR
    //     */
    //    <RE extends EntityQueryRelateExpression5RFRRR<E, R1, R2, R3, R4, R5, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple2<E, R2>>,
    //            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple2<E, R2>>,
    //            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple2<E, R2>>,
    //            QR extends EntityQueryRelatedFetchedExpression5RFRRF<E, R1, R2, R3, R4, R5, QRC, QRL, QRS>,
    //            QRC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS, Tuple3<E, R2, R5>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
    //                    Tuple3<E, R2, R5>>,
    //            QRS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple3<E, R2, R5>>,
    //            R5> RE join(SerializableFunction1<E, R5> propertyName);
    //
    //    /**
    //     * join on.
    //     *
    //     * @param <RE>         the generic type
    //     * @param <RC>         the generic type
    //     * @param <RL>         the generic type
    //     * @param <RS>         the generic type
    //     * @param <QR>         the generic type
    //     * @param <QRC>        the generic type
    //     * @param <QRL>        the generic type
    //     * @param <QRS>        the generic type
    //     * @param propertyName find type object property name
    //     * @return EntityQueryRelateExpression5RFRR
    //     */
    //    <RE extends EntityQueryRelateExpression5RFRRR<E, R1, R2, R3, R4, E, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, E, RC, RL, RS, Tuple2<E, R2>>,
    //            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, E, RC, RL, RS, Tuple2<E, R2>>,
    //            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, E, Tuple2<E, R2>>,
    //            QR extends EntityQueryRelatedFetchedExpression5RFRRF<E, R1, R2, R3, R4, E, QRC, QRL, QRS>,
    //            QRC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, E, QRC, QRL, QRS, Tuple3<E, R2, E>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, E, QRC, QRL, QRS,
    //                    Tuple3<E, R2, E>>,
    //            QRS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, E, Tuple3<E, R2, E>>> RE join(
    //                    SerializableUnaryOperator1<E> propertyName);
    //
    //    // ********************************************************************
    //    //  2
    //    // ********************************************************************
    //
    //    /**
    //     * join.
    //     *
    //     * @param <QR>     the generic type
    //     * @param <RC>     the generic type
    //     * @param <RL>     the generic type
    //     * @param <RS>     the generic type
    //     * @param <QRF>    the generic type
    //     * @param <QRC>    the generic type
    //     * @param <QRL>    the generic type
    //     * @param <QRS>    the generic type
    //     * @param <R5>     the generic type
    //     * @param joinType the join type
    //     * @return EntityQueryRelateExpression5RFRR
    //     */
    //    <QR extends EntityQueryRelateExpression5RFRRR<E, R1, R2, R3, R4, R5, RC, RL, RS, QRF, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple2<E, R2>>,
    //            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple2<E, R2>>,
    //            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple2<E, R2>>,
    //            QRF extends EntityQueryRelatedFetchedExpression5RFRRF<E, R1, R2, R3, R4, R5, QRC, QRL, QRS>,
    //            QRC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS, Tuple3<E, R2, R5>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
    //                    Tuple3<E, R2, R5>>,
    //            QRS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple3<E, R2, R5>>,
    //            R5> EntityQueryRelatedExpression<R1, R5, QR, QRF> join2(Class<R5> joinType);
    //
    //    /**
    //     * join on.
    //     *
    //     * @param <RE>         the generic type
    //     * @param <RC>         the generic type
    //     * @param <RL>         the generic type
    //     * @param <RS>         the generic type
    //     * @param <QR>         the generic type
    //     * @param <QRC>        the generic type
    //     * @param <QRL>        the generic type
    //     * @param <QRS>        the generic type
    //     * @param <R5>         the generic type
    //     * @param propertyName find type object property name
    //     * @return EntityQueryRelateExpression5RFRR
    //     */
    //    <RE extends EntityQueryRelateExpression5RFRRR<E, R1, R2, R3, R4, R5, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple2<E, R2>>,
    //            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple2<E, R2>>,
    //            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple2<E, R2>>,
    //            QR extends EntityQueryRelatedFetchedExpression5RFRRF<E, R1, R2, R3, R4, R5, QRC, QRL, QRS>,
    //            QRC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS, Tuple3<E, R2, R5>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
    //                    Tuple3<E, R2, R5>>,
    //            QRS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple3<E, R2, R5>>,
    //            R5> RE join2(SerializableFunction1<R1, R5> propertyName);
    //
    //    /**
    //     * join on.
    //     *
    //     * @param <RE>         the generic type
    //     * @param <RC>         the generic type
    //     * @param <RL>         the generic type
    //     * @param <RS>         the generic type
    //     * @param <QR>         the generic type
    //     * @param <QRC>        the generic type
    //     * @param <QRL>        the generic type
    //     * @param <QRS>        the generic type
    //     * @param <R5>         the generic type
    //     * @param propertyName find type object property name
    //     * @return EntityQueryRelateExpression5RFRR
    //     */
    //    <RE extends EntityQueryRelateExpression5RFRRR<E, R1, R2, R3, R4, R5, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple2<E, R2>>,
    //            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple2<E, R2>>,
    //            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple2<E, R2>>,
    //            QR extends EntityQueryRelatedFetchedExpression5RFRRF<E, R1, R2, R3, R4, R5, QRC, QRL, QRS>,
    //            QRC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS, Tuple3<E, R2, R5>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
    //                    Tuple3<E, R2, R5>>,
    //            QRS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple3<E, R2, R5>>,
    //            R5> RE join2(SerializableFunction2<R5, R1> propertyName);
    //
    //    /**
    //     * join on.
    //     *
    //     * @param <RE>         the generic type
    //     * @param <RC>         the generic type
    //     * @param <RL>         the generic type
    //     * @param <RS>         the generic type
    //     * @param <QR>         the generic type
    //     * @param <QRC>        the generic type
    //     * @param <QRL>        the generic type
    //     * @param <QRS>        the generic type
    //     * @param propertyName find type object property name
    //     * @return EntityQueryRelateExpression5RFRR
    //     */
    //    <RE extends EntityQueryRelateExpression5RFRRR<E, R1, R2, R3, R4, R1, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R1, RC, RL, RS, Tuple2<E, R2>>,
    //            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R1, RC, RL, RS, Tuple2<E, R2>>,
    //            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R1, Tuple2<E, R2>>,
    //            QR extends EntityQueryRelatedFetchedExpression5RFRRF<E, R1, R2, R3, R4, R1, QRC, QRL, QRS>,
    //            QRC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R1, QRC, QRL, QRS, Tuple3<E, R2, R1>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R1, QRC, QRL, QRS,
    //                    Tuple3<E, R2, R1>>,
    //            QRS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R1, Tuple3<E, R2, R1>>> RE join2(
    //                    SerializableUnaryOperator1<R1> propertyName);
    //
    //    // ********************************************************************
    //    // 3
    //    // ********************************************************************
    //
    //    /**
    //     * join.
    //     *
    //     * @param <QR>     the generic type
    //     * @param <RC>     the generic type
    //     * @param <RL>     the generic type
    //     * @param <RS>     the generic type
    //     * @param <QRF>    the generic type
    //     * @param <QRC>    the generic type
    //     * @param <QRL>    the generic type
    //     * @param <QRS>    the generic type
    //     * @param <R5>     the generic type
    //     * @param joinType the join type
    //     * @return EntityQueryRelateExpression5RFRR
    //     */
    //    <QR extends EntityQueryRelateExpression5RFRRR<E, R1, R2, R3, R4, R5, RC, RL, RS, QRF, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple2<E, R2>>,
    //            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple2<E, R2>>,
    //            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple2<E, R2>>,
    //            QRF extends EntityQueryRelatedFetchedExpression5RFRRF<E, R1, R2, R3, R4, R5, QRC, QRL, QRS>,
    //            QRC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS, Tuple3<E, R2, R5>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
    //                    Tuple3<E, R2, R5>>,
    //            QRS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple3<E, R2, R5>>,
    //            R5> EntityQueryRelatedExpression<R2, R5, QR, QRF> join3(Class<R5> joinType);
    //
    //    /**
    //     * join on.
    //     *
    //     * @param <RE>         the generic type
    //     * @param <RC>         the generic type
    //     * @param <RL>         the generic type
    //     * @param <RS>         the generic type
    //     * @param <QR>         the generic type
    //     * @param <QRC>        the generic type
    //     * @param <QRL>        the generic type
    //     * @param <QRS>        the generic type
    //     * @param <R5>         the generic type
    //     * @param propertyName find type object property name
    //     * @return EntityQueryRelateExpression5RFRR
    //     */
    //    <RE extends EntityQueryRelateExpression5RFRRR<E, R1, R2, R3, R4, R5, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple2<E, R2>>,
    //            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple2<E, R2>>,
    //            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple2<E, R2>>,
    //            QR extends EntityQueryRelatedFetchedExpression5RFRRF<E, R1, R2, R3, R4, R5, QRC, QRL, QRS>,
    //            QRC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS, Tuple3<E, R2, R5>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
    //                    Tuple3<E, R2, R5>>,
    //            QRS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple3<E, R2, R5>>,
    //            R5> RE join3(SerializableFunction1<R2, R5> propertyName);
    //
    //    /**
    //     * join on.
    //     *
    //     * @param <RE>         the generic type
    //     * @param <RC>         the generic type
    //     * @param <RL>         the generic type
    //     * @param <RS>         the generic type
    //     * @param <QR>         the generic type
    //     * @param <QRC>        the generic type
    //     * @param <QRL>        the generic type
    //     * @param <QRS>        the generic type
    //     * @param <R5>         the generic type
    //     * @param propertyName find type object property name
    //     * @return EntityQueryRelateExpression5RFRR
    //     */
    //    <RE extends EntityQueryRelateExpression5RFRRR<E, R1, R2, R3, R4, R5, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple2<E, R2>>,
    //            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple2<E, R2>>,
    //            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple2<E, R2>>,
    //            QR extends EntityQueryRelatedFetchedExpression5RFRRF<E, R1, R2, R3, R4, R5, QRC, QRL, QRS>,
    //            QRC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS, Tuple3<E, R2, R5>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
    //                    Tuple3<E, R2, R5>>,
    //            QRS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple3<E, R2, R5>>,
    //            R5> RE join3(SerializableFunction2<R5, R2> propertyName);
    //
    //    /**
    //     * join on.
    //     *
    //     * @param <RE>         the generic type
    //     * @param <RC>         the generic type
    //     * @param <RL>         the generic type
    //     * @param <RS>         the generic type
    //     * @param <QR>         the generic type
    //     * @param <QRC>        the generic type
    //     * @param <QRL>        the generic type
    //     * @param <QRS>        the generic type
    //     * @param propertyName find type object property name
    //     * @return EntityQueryRelateExpression5RFRR
    //     */
    //    <RE extends EntityQueryRelateExpression5RFRRR<E, R1, R2, R3, R4, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R2, RC, RL, RS, Tuple2<E, R2>>,
    //            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R2, RC, RL, RS, Tuple2<E, R2>>,
    //            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R2, Tuple2<E, R2>>,
    //            QR extends EntityQueryRelatedFetchedExpression5RFRRF<E, R1, R2, R3, R4, R2, QRC, QRL, QRS>,
    //            QRC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R2, QRC, QRL, QRS, Tuple3<E, R2, R2>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R2, QRC, QRL, QRS,
    //                    Tuple3<E, R2, R2>>,
    //            QRS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R2, Tuple3<E, R2, R2>>> RE join3(
    //                    SerializableUnaryOperator1<R2> propertyName);
    //
    //    // ********************************************************************
    //    // 4
    //    // ********************************************************************
    //
    //    /**
    //     * join.
    //     *
    //     * @param <QR>     the generic type
    //     * @param <RC>     the generic type
    //     * @param <RL>     the generic type
    //     * @param <RS>     the generic type
    //     * @param <QRF>    the generic type
    //     * @param <QRC>    the generic type
    //     * @param <QRL>    the generic type
    //     * @param <QRS>    the generic type
    //     * @param <R5>     the generic type
    //     * @param joinType the join type
    //     * @return EntityQueryRelateExpression5RFRR
    //     */
    //    <QR extends EntityQueryRelateExpression5RFRRR<E, R1, R2, R3, R4, R5, RC, RL, RS, QRF, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple2<E, R2>>,
    //            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple2<E, R2>>,
    //            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple2<E, R2>>,
    //            QRF extends EntityQueryRelatedFetchedExpression5RFRRF<E, R1, R2, R3, R4, R5, QRC, QRL, QRS>,
    //            QRC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS, Tuple3<E, R2, R5>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
    //                    Tuple3<E, R2, R5>>,
    //            QRS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple3<E, R2, R5>>,
    //            R5> EntityQueryRelatedExpression<R3, R5, QR, QRF> join4(Class<R5> joinType);
    //
    //    /**
    //     * join on.
    //     *
    //     * @param <RE>         the generic type
    //     * @param <RC>         the generic type
    //     * @param <RL>         the generic type
    //     * @param <RS>         the generic type
    //     * @param <QR>         the generic type
    //     * @param <QRC>        the generic type
    //     * @param <QRL>        the generic type
    //     * @param <QRS>        the generic type
    //     * @param <R5>         the generic type
    //     * @param propertyName find type object property name
    //     * @return EntityQueryRelateExpression5RFRR
    //     */
    //    <RE extends EntityQueryRelateExpression5RFRRR<E, R1, R2, R3, R4, R5, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple2<E, R2>>,
    //            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple2<E, R2>>,
    //            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple2<E, R2>>,
    //            QR extends EntityQueryRelatedFetchedExpression5RFRRF<E, R1, R2, R3, R4, R5, QRC, QRL, QRS>,
    //            QRC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS, Tuple3<E, R2, R5>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
    //                    Tuple3<E, R2, R5>>,
    //            QRS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple3<E, R2, R5>>,
    //            R5> RE join4(SerializableFunction1<R3, R5> propertyName);
    //
    //    /**
    //     * join on.
    //     *
    //     * @param <RE>         the generic type
    //     * @param <RC>         the generic type
    //     * @param <RL>         the generic type
    //     * @param <RS>         the generic type
    //     * @param <QR>         the generic type
    //     * @param <QRC>        the generic type
    //     * @param <QRL>        the generic type
    //     * @param <QRS>        the generic type
    //     * @param <R5>         the generic type
    //     * @param propertyName find type object property name
    //     * @return EntityQueryRelateExpression5RFRR
    //     */
    //    <RE extends EntityQueryRelateExpression5RFRRR<E, R1, R2, R3, R4, R5, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple2<E, R2>>,
    //            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple2<E, R2>>,
    //            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple2<E, R2>>,
    //            QR extends EntityQueryRelatedFetchedExpression5RFRRF<E, R1, R2, R3, R4, R5, QRC, QRL, QRS>,
    //            QRC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS, Tuple3<E, R2, R5>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
    //                    Tuple3<E, R2, R5>>,
    //            QRS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple3<E, R2, R5>>,
    //            R5> RE join4(SerializableFunction2<R5, R3> propertyName);
    //
    //    /**
    //     * join on.
    //     *
    //     * @param <RE>         the generic type
    //     * @param <RC>         the generic type
    //     * @param <RL>         the generic type
    //     * @param <RS>         the generic type
    //     * @param <QR>         the generic type
    //     * @param <QRC>        the generic type
    //     * @param <QRL>        the generic type
    //     * @param <QRS>        the generic type
    //     * @param propertyName find type object property name
    //     * @return EntityQueryRelateExpression5RFRR
    //     */
    //    <RE extends EntityQueryRelateExpression5RFRRR<E, R1, R2, R3, R4, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R3, RC, RL, RS, Tuple2<E, R2>>,
    //            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R3, RC, RL, RS, Tuple2<E, R2>>,
    //            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R3, Tuple2<E, R2>>,
    //            QR extends EntityQueryRelatedFetchedExpression5RFRRF<E, R1, R2, R3, R4, R3, QRC, QRL, QRS>,
    //            QRC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R3, QRC, QRL, QRS, Tuple3<E, R2, R3>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R3, QRC, QRL, QRS,
    //                    Tuple3<E, R2, R3>>,
    //            QRS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R3, Tuple3<E, R2, R3>>> RE join4(
    //                    SerializableUnaryOperator1<R3> propertyName);
    //
    //    // ********************************************************************
    //    // 5
    //    // ********************************************************************
    //
    //    /**
    //     * join.
    //     *
    //     * @param <QR>     the generic type
    //     * @param <RC>     the generic type
    //     * @param <RL>     the generic type
    //     * @param <RS>     the generic type
    //     * @param <QRF>    the generic type
    //     * @param <QRC>    the generic type
    //     * @param <QRL>    the generic type
    //     * @param <QRS>    the generic type
    //     * @param <R5>     the generic type
    //     * @param joinType the join type
    //     * @return EntityQueryRelateExpression5RFRR
    //     */
    //    <QR extends EntityQueryRelateExpression5RFRRR<E, R1, R2, R3, R4, R5, RC, RL, RS, QRF, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple2<E, R2>>,
    //            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple2<E, R2>>,
    //            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple2<E, R2>>,
    //            QRF extends EntityQueryRelatedFetchedExpression5RFRRF<E, R1, R2, R3, R4, R5, QRC, QRL, QRS>,
    //            QRC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS, Tuple3<E, R2, R5>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
    //                    Tuple3<E, R2, R5>>,
    //            QRS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple3<E, R2, R5>>,
    //            R5> EntityQueryRelatedExpression<R4, R5, QR, QRF> join5(Class<R5> joinType);
    //
    //    /**
    //     * join on.
    //     *
    //     * @param <RE>         the generic type
    //     * @param <RC>         the generic type
    //     * @param <RL>         the generic type
    //     * @param <RS>         the generic type
    //     * @param <QR>         the generic type
    //     * @param <QRC>        the generic type
    //     * @param <QRL>        the generic type
    //     * @param <QRS>        the generic type
    //     * @param <R5>         the generic type
    //     * @param propertyName find type object property name
    //     * @return EntityQueryRelateExpression5RFRR
    //     */
    //    <RE extends EntityQueryRelateExpression5RFRRR<E, R1, R2, R3, R4, R5, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple2<E, R2>>,
    //            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple2<E, R2>>,
    //            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple2<E, R2>>,
    //            QR extends EntityQueryRelatedFetchedExpression5RFRRF<E, R1, R2, R3, R4, R5, QRC, QRL, QRS>,
    //            QRC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS, Tuple3<E, R2, R5>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
    //                    Tuple3<E, R2, R5>>,
    //            QRS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple3<E, R2, R5>>,
    //            R5> RE join5(SerializableFunction1<R4, R5> propertyName);
    //
    //    /**
    //     * join on.
    //     *
    //     * @param <RE>         the generic type
    //     * @param <RC>         the generic type
    //     * @param <RL>         the generic type
    //     * @param <RS>         the generic type
    //     * @param <QR>         the generic type
    //     * @param <QRC>        the generic type
    //     * @param <QRL>        the generic type
    //     * @param <QRS>        the generic type
    //     * @param <R5>         the generic type
    //     * @param propertyName find type object property name
    //     * @return EntityQueryRelateExpression5RFRR
    //     */
    //    <RE extends EntityQueryRelateExpression5RFRRR<E, R1, R2, R3, R4, R5, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple2<E, R2>>,
    //            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple2<E, R2>>,
    //            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple2<E, R2>>,
    //            QR extends EntityQueryRelatedFetchedExpression5RFRRF<E, R1, R2, R3, R4, R5, QRC, QRL, QRS>,
    //            QRC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS, Tuple3<E, R2, R5>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
    //                    Tuple3<E, R2, R5>>,
    //            QRS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple3<E, R2, R5>>,
    //            R5> RE join5(SerializableFunction2<R5, R4> propertyName);
    //
    //    /**
    //     * join on.
    //     *
    //     * @param <RE>         the generic type
    //     * @param <RC>         the generic type
    //     * @param <RL>         the generic type
    //     * @param <RS>         the generic type
    //     * @param <QR>         the generic type
    //     * @param <QRC>        the generic type
    //     * @param <QRL>        the generic type
    //     * @param <QRS>        the generic type
    //     * @param propertyName find type object property name
    //     * @return EntityQueryRelateExpression5RFRR
    //     */
    //    <RE extends EntityQueryRelateExpression5RFRRR<E, R1, R2, R3, R4, R4, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R4, RC, RL, RS, Tuple2<E, R2>>,
    //            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R4, RC, RL, RS, Tuple2<E, R2>>,
    //            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R4, Tuple2<E, R2>>,
    //            QR extends EntityQueryRelatedFetchedExpression5RFRRF<E, R1, R2, R3, R4, R4, QRC, QRL, QRS>,
    //            QRC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R4, QRC, QRL, QRS, Tuple3<E, R2, R4>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R4, QRC, QRL, QRS,
    //                    Tuple3<E, R2, R4>>,
    //            QRS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R4, Tuple3<E, R2, R4>>> RE join5(
    //                    SerializableUnaryOperator1<R4> propertyName);
}
