package cn.featherfly.hammer.expression.entity.query.relation;

import com.speedment.common.tuple.Tuple2;
import com.speedment.common.tuple.Tuple3;

import cn.featherfly.common.function.serializable.SerializableFunction1;
import cn.featherfly.common.function.serializable.SerializableFunction2;
import cn.featherfly.common.function.serializable.SerializableUnaryOperator1;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression3;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression4;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression3;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression4;
import cn.featherfly.hammer.expression.entity.query.EntityQueryExpression3;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression3;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression4;

/**
 * The Interface EntityQueryRelatedFetchedExpression2RF.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the relate type
 * @param <R2> the relate type
 * @param <C>  the generic type
 * @param <L>  the generic type
 * @param <S>  the generic type
 */

public interface EntityQueryRelatedFetchedExpression2RF<E, R1, R2,
        C extends EntityQueryConditionGroupExpression3<E, R1, R2, C, L, S, Tuple2<E, R2>>,
        L extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, C, L, S, Tuple2<E, R2>>,
        S extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>>
        extends EntityQueryExpression3<E, R1, R2, C, L, S, Tuple2<E, R2>> {

    /**
     * join.
     *
     * @param <QR>     the generic type
     * @param <RC>     the generic type
     * @param <RL>     the generic type
     * @param <RS>     the generic type
     * @param <QRF>    the generic type
     * @param <QRC>    the generic type
     * @param <QRL>    the generic type
     * @param <QRS>    the generic type
     * @param <R3>     the generic type
     * @param joinType the join type
     * @return EntityQueryRelateExpression3RF
     */
    <QR extends EntityQueryRelateExpression3RFR<E, R1, R2, R3, RC, RL, RS, QRF, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R2>>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R2>>,
            QRF extends EntityQueryRelatedFetchedExpression3RFF<E, R1, R2, R3, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple3<E, R2, R3>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple3<E, R2, R3>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple3<E, R2, R3>>,
            R3> EntityQueryRelatedExpression<E, R3, QR, QRF> join(Class<R3> joinType);

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
     * @return EntityQueryRelateExpression3RF
     */
    <RE extends EntityQueryRelateExpression3RFR<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R2>>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R2>>,
            QR extends EntityQueryRelatedFetchedExpression3RFF<E, R1, R2, R3, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple3<E, R2, R3>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple3<E, R2, R3>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple3<E, R2, R3>>,
            R3> RE join(SerializableFunction2<R3, E> propertyName);

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
     * @return EntityQueryRelateExpression3RF
     */
    <RE extends EntityQueryRelateExpression3RFP<E, R1, R2, R3, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R2>>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R2>>,
            QR extends EntityQueryRelatedFetchedExpression3RFP<E, R1, R2, R3, RC, RL, RS>,
            R3> RE join(SerializableFunction1<E, R3> propertyName);

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
     * @return EntityQueryRelateExpression3RF
     */
    <RE extends EntityQueryRelateExpression3RFP<E, R1, R2, E, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, E, RC, RL, RS, Tuple2<E, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, E, RC, RL, RS, Tuple2<E, R2>>,
            RS extends EntityQuerySortExpression4<E, R1, R2, E, Tuple2<E, R2>>,
            QR extends EntityQueryRelatedFetchedExpression3RFP<E, R1, R2, E, RC, RL, RS>> RE join(
                    SerializableUnaryOperator1<E> propertyName);

    // ********************************************************************
    //	2
    // ********************************************************************

    /**
     * join on.
     *
     * @param <QR>     the generic type
     * @param <RC>     the generic type
     * @param <RL>     the generic type
     * @param <RS>     the generic type
     * @param <QRF>    the generic type
     * @param <QRC>    the generic type
     * @param <QRL>    the generic type
     * @param <QRS>    the generic type
     * @param <R3>     the generic type
     * @param joinType the join type
     * @return EntityQueryRelateExpression3RF
     */
    <QR extends EntityQueryRelateExpression3RFR<E, R1, R2, R3, RC, RL, RS, QRF, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R2>>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R2>>,
            QRF extends EntityQueryRelatedFetchedExpression3RFF<E, R1, R2, R3, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple3<E, R2, R3>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple3<E, R2, R3>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple3<E, R2, R3>>,
            R3> EntityQueryRelatedExpression<R1, R3, QR, QRF> join2(Class<R3> joinType);

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
     * @return EntityQueryRelateExpression3RF
     */
    <RE extends EntityQueryRelateExpression3RFR<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R2>>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R2>>,
            QR extends EntityQueryRelatedFetchedExpression3RFF<E, R1, R2, R3, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple3<E, R2, R3>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple3<E, R2, R3>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple3<E, R2, R3>>,
            R3> RE join2(SerializableFunction2<R3, R1> propertyName);

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
     * @return EntityQueryRelateExpression3RF
     */
    <RE extends EntityQueryRelateExpression3RFP<E, R1, R2, R3, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R2>>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R2>>,
            QR extends EntityQueryRelatedFetchedExpression3RFP<E, R1, R2, R3, RC, RL, RS>,
            R3> RE join2(SerializableFunction1<R1, R3> propertyName);

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
     * @return EntityQueryRelateExpression3RF
     */
    <RE extends EntityQueryRelateExpression3RFP<E, R1, R2, R1, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R1, RC, RL, RS, Tuple2<E, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R1, RC, RL, RS, Tuple2<E, R2>>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R1, Tuple2<E, R2>>,
            QR extends EntityQueryRelatedFetchedExpression3RFP<E, R1, R2, R1, RC, RL, RS>> RE join2(
                    SerializableUnaryOperator1<R1> propertyName);

    // ********************************************************************
    // 3
    // ********************************************************************

    /**
     * join on.
     *
     * @param <QR>     the generic type
     * @param <RC>     the generic type
     * @param <RL>     the generic type
     * @param <RS>     the generic type
     * @param <QRF>    the generic type
     * @param <QRC>    the generic type
     * @param <QRL>    the generic type
     * @param <QRS>    the generic type
     * @param <R3>     the generic type
     * @param joinType the join type
     * @return EntityQueryRelateExpression3RF
     */
    <QR extends EntityQueryRelateExpression3RFR<E, R1, R2, R3, RC, RL, RS, QRF, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R2>>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R2>>,
            QRF extends EntityQueryRelatedFetchedExpression3RFF<E, R1, R2, R3, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple3<E, R2, R3>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple3<E, R2, R3>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple3<E, R2, R3>>,
            R3> EntityQueryRelatedExpression<R2, R3, QR, QRF> join3(Class<R3> joinType);

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
     * @return EntityQueryRelateExpression3RF
     */
    <RE extends EntityQueryRelateExpression3RFR<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R2>>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R2>>,
            QR extends EntityQueryRelatedFetchedExpression3RFF<E, R1, R2, R3, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple3<E, R2, R3>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple3<E, R2, R3>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple3<E, R2, R3>>,
            R3> RE join3(SerializableFunction2<R3, R2> propertyName);

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
     * @return EntityQueryRelateExpression3RF
     */
    <RE extends EntityQueryRelateExpression3RFP<E, R1, R2, R3, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R2>>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R2>>,
            QR extends EntityQueryRelatedFetchedExpression3RFP<E, R1, R2, R3, RC, RL, RS>,
            R3> RE join3(SerializableFunction1<R2, R3> propertyName);

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
     * @return EntityQueryRelateExpression3RF
     */
    <RE extends EntityQueryRelateExpression3RFP<E, R1, R2, R2, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R2, RC, RL, RS, Tuple2<E, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R2, RC, RL, RS, Tuple2<E, R2>>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R2, Tuple2<E, R2>>,
            QR extends EntityQueryRelatedFetchedExpression3RFP<E, R1, R2, R2, RC, RL, RS>> RE join3(
                    SerializableUnaryOperator1<R2> propertyName);

}
