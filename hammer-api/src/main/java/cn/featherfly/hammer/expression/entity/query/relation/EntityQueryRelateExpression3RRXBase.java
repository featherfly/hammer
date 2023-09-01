
package cn.featherfly.hammer.expression.entity.query.relation;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.common.function.serializable.SerializableFunction1;
import cn.featherfly.common.function.serializable.SerializableFunction2;
import cn.featherfly.common.function.serializable.SerializableUnaryOperator1;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression4;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression5;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression4;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression5;
import cn.featherfly.hammer.expression.entity.query.EntityQueryExpression4;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression4;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression5;

/**
 * The Interface EntityQueryRelateExpression3PPP.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 * @param <R2> the generic type
 * @param <R3> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 * @param <S>  the generic type
 */
public interface EntityQueryRelateExpression3RRXBase<E, R1, R2, R3,
        C extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, C, L, S, E>,
        L extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, C, L, S, E>,
        S extends EntityQuerySortExpression4<E, R1, R2, R3, E>>
        extends EntityQueryExpression4<E, R1, R2, R3, C, L, S, E> {

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
     * @param <R4>     the generic type
     * @param joinType the join type
     * @return EntityQueryRelateExpression4RRRR
     */
    <QR extends EntityQueryRelateExpression4RRRR<E, R1, R2, R3, R4, RC, RL, RS, QRF, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, E>,
            QRF extends EntityQueryRelatedFetchedExpression4RRRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple2<E, R4>>,
            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple2<E, R4>>,
            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple2<E, R4>>,
            R4> EntityQueryRelatedExpression<E, R4, QR, QRF> join(Class<R4> joinType);

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
     * @param <R4>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelateExpression4RRRR
     */
    <RE extends EntityQueryRelateExpression4RRRR<E, R1, R2, R3, R4, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, E>,
            QR extends EntityQueryRelatedFetchedExpression4RRRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple2<E, R4>>,
            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple2<E, R4>>,
            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple2<E, R4>>,
            R4> RE join(SerializableFunction2<R4, E> propertyName);

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <RC>         the generic type
     * @param <RL>         the generic type
     * @param <RS>         the generic type
     * @param <QR>         the generic type
     * @param <R4>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelateExpression4RRRP
     */
    <RE extends EntityQueryRelateExpression4RRRP<E, R1, R2, R3, R4, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, E>,
            QR extends EntityQueryRelatedFetchedExpression4RRRP<E, R1, R2, R3, R4, RC, RL, RS>,
            R4> RE join(SerializableFunction1<E, R4> propertyName);

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <RC>         the generic type
     * @param <RL>         the generic type
     * @param <RS>         the generic type
     * @param <QR>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelateExpression4RRRP
     */
    <RE extends EntityQueryRelateExpression4RRRP<E, R1, R2, R3, E, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, E, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, E, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, E, E>,
            QR extends EntityQueryRelatedFetchedExpression4RRRP<E, R1, R2, R3, E, RC, RL, RS>> RE join(
                    SerializableUnaryOperator1<E> propertyName);

    // ********************************************************************
    //  2
    // ********************************************************************

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
     * @param <R4>     the generic type
     * @param joinType the join type
     * @return EntityQueryRelateExpression4RRRR
     */
    <QR extends EntityQueryRelateExpression4RRRR<E, R1, R2, R3, R4, RC, RL, RS, QRF, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, E>,
            QRF extends EntityQueryRelatedFetchedExpression4RRRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple2<E, R4>>,
            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple2<E, R4>>,
            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple2<E, R4>>,
            R4> EntityQueryRelatedExpression<R1, R4, QR, QRF> join2(Class<R4> joinType);

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
     * @param <R4>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelateExpression4RRRRR
     */
    <RE extends EntityQueryRelateExpression4RRRR<E, R1, R2, R3, R4, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, E>,
            QR extends EntityQueryRelatedFetchedExpression4RRRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple2<E, R4>>,
            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple2<E, R4>>,
            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple2<E, R4>>,
            R4> RE join2(SerializableFunction2<R4, R1> propertyName);

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <RC>         the generic type
     * @param <RL>         the generic type
     * @param <RS>         the generic type
     * @param <QR>         the generic type
     * @param <R4>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelateExpression4RRRP
     */
    <RE extends EntityQueryRelateExpression4RRRP<E, R1, R2, R3, R4, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, E>,
            QR extends EntityQueryRelatedFetchedExpression4RRRP<E, R1, R2, R3, R4, RC, RL, RS>,
            R4> RE join2(SerializableFunction1<R1, R4> propertyName);

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <RC>         the generic type
     * @param <RL>         the generic type
     * @param <RS>         the generic type
     * @param <QR>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelateExpression4RRRP
     */
    <RE extends EntityQueryRelateExpression4RRRP<E, R1, R2, R3, R1, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R1, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R1, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R1, E>,
            QR extends EntityQueryRelatedFetchedExpression4RRRP<E, R1, R2, R3, R1, RC, RL, RS>> RE join2(
                    SerializableUnaryOperator1<R1> propertyName);

    // ********************************************************************
    // 3
    // ********************************************************************

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
     * @param <R4>     the generic type
     * @param joinType the join type
     * @return EntityQueryRelateExpression4RRRR
     */
    <QR extends EntityQueryRelateExpression4RRRR<E, R1, R2, R3, R4, RC, RL, RS, QRF, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, E>,
            QRF extends EntityQueryRelatedFetchedExpression4RRRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple2<E, R4>>,
            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple2<E, R4>>,
            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple2<E, R4>>,
            R4> EntityQueryRelatedExpression<R2, R4, QR, QRF> join3(Class<R4> joinType);

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
     * @param <R4>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelateExpression4RRRR
     */
    <RE extends EntityQueryRelateExpression4RRRR<E, R1, R2, R3, R4, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, E>,
            QR extends EntityQueryRelatedFetchedExpression4RRRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple2<E, R4>>,
            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple2<E, R4>>,
            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple2<E, R4>>,
            R4> RE join3(SerializableFunction2<R4, R2> propertyName);

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <RC>         the generic type
     * @param <RL>         the generic type
     * @param <RS>         the generic type
     * @param <QR>         the generic type
     * @param <R4>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelateExpression4RRRP
     */
    <RE extends EntityQueryRelateExpression4RRRP<E, R1, R2, R3, R4, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, E>,
            QR extends EntityQueryRelatedFetchedExpression4RRRP<E, R1, R2, R3, R4, RC, RL, RS>,
            R4> RE join3(SerializableFunction1<R2, R4> propertyName);

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <RC>         the generic type
     * @param <RL>         the generic type
     * @param <RS>         the generic type
     * @param <QR>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelateExpression4RRRP
     */
    <RE extends EntityQueryRelateExpression4RRRP<E, R1, R2, R3, R2, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R2, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R2, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R2, E>,
            QR extends EntityQueryRelatedFetchedExpression4RRRP<E, R1, R2, R3, R2, RC, RL, RS>> RE join3(
                    SerializableUnaryOperator1<R2> propertyName);

    // ********************************************************************
    // 4
    // ********************************************************************

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
     * @param <R4>     the generic type
     * @param joinType the join type
     * @return EntityQueryRelateExpression4RRRR
     */
    <QR extends EntityQueryRelateExpression4RRRR<E, R1, R2, R3, R4, RC, RL, RS, QRF, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, E>,
            QRF extends EntityQueryRelatedFetchedExpression4RRRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple2<E, R4>>,
            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple2<E, R4>>,
            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple2<E, R4>>,
            R4> EntityQueryRelatedExpression<R3, R4, QR, QRF> join4(Class<R4> joinType);

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
     * @param <R4>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelateExpression4RRRR
     */
    <RE extends EntityQueryRelateExpression4RRRR<E, R1, R2, R3, R4, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, E>,
            QR extends EntityQueryRelatedFetchedExpression4RRRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple2<E, R4>>,
            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple2<E, R4>>,
            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple2<E, R4>>,
            R4> RE join4(SerializableFunction2<R4, R3> propertyName);

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
     * @param <R4>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelateExpression4RRRP
     */
    <RE extends EntityQueryRelateExpression4RRRP<E, R1, R2, R3, R4, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, E>,
            QR extends EntityQueryRelatedFetchedExpression4RRRP<E, R1, R2, R3, R4, RC, RL, RS>,
            R4> RE join4(SerializableFunction1<R3, R4> propertyName);

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
     * @return EntityQueryRelateExpression4RRRP
     */
    <RE extends EntityQueryRelateExpression4RRRP<E, R1, R2, R3, R3, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R3, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R3, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R3, E>,
            QR extends EntityQueryRelatedFetchedExpression4RRRP<E, R1, R2, R3, R3, RC, RL, RS>> RE join4(
                    SerializableUnaryOperator1<R3> propertyName);
}
