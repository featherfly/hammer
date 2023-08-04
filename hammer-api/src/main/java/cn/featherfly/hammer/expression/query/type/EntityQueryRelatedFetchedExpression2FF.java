package cn.featherfly.hammer.expression.query.type;

import com.speedment.common.tuple.Tuple3;
import com.speedment.common.tuple.Tuple4;

import cn.featherfly.common.lang.function.SerializableFunction1;
import cn.featherfly.common.lang.function.SerializableFunction2;
import cn.featherfly.common.lang.function.SerializableFunction3;
import cn.featherfly.common.lang.function.SerializableFunction4;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression3;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression4;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression3;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression4;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression3;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression4;

/**
 * The Interface EntityQueryRelatedFetchedExpression2FF.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the relate type
 * @param <R2> the relate type
 * @param <C>  the generic type
 * @param <L>  the generic type
 * @param <S>  the generic type
 */

public interface EntityQueryRelatedFetchedExpression2FF<E, R1, R2,
        C extends EntityQueryConditionGroupExpression3<E, R1, R2, C, L, S, Tuple3<E, R1, R2>>,
        L extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, C, L, S, Tuple3<E, R1, R2>>,
        S extends EntityQuerySortExpression3<E, R1, R2, Tuple3<E, R1, R2>>>
        extends EntityQueryExpression3<E, R1, R2, C, L, S, Tuple3<E, R1, R2>> {

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
     * @return EntityQueryRelateExpression3FF
     */
    <RE extends EntityQueryRelateExpression3FF<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, Tuple3<E, R1, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, Tuple3<E, R1, R2>>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple3<E, R1, R2>>,
            QR extends EntityQueryRelatedFetchedExpression3FFF<E, R1, R2, R3, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple4<E, R1, R2, R3>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple4<E, R1, R2, R3>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple4<E, R1, R2, R3>>, R3,
            J> RE join(SerializableFunction1<E, J> propertyName, Class<R3> joinType);

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
     * @return EntityQueryRelateExpression3FF
     */
    <RE extends EntityQueryRelateExpression3FF<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, Tuple3<E, R1, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, Tuple3<E, R1, R2>>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple3<E, R1, R2>>,
            QR extends EntityQueryRelatedFetchedExpression3FFF<E, R1, R2, R3, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple4<E, R1, R2, R3>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple4<E, R1, R2, R3>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple4<E, R1, R2, R3>>, R3,
            J> RE join(SerializableFunction1<E, J> propertyName, SerializableFunction1<R3, J> joinTypePropertyName);

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
     * @return EntityQueryRelateExpression3FF
     */
    <RE extends EntityQueryRelateExpression3FF<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, Tuple3<E, R1, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, Tuple3<E, R1, R2>>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple3<E, R1, R2>>,
            QR extends EntityQueryRelatedFetchedExpression3FFF<E, R1, R2, R3, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple4<E, R1, R2, R3>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple4<E, R1, R2, R3>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple4<E, R1, R2, R3>>, R3,
            J> RE join(SerializableFunction4<R3, J> joinTypePropertyName);

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
     * @return EntityQueryRelateExpression3FF
     */
    <RE extends EntityQueryRelateExpression3FF<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, Tuple3<E, R1, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, Tuple3<E, R1, R2>>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple3<E, R1, R2>>,
            QR extends EntityQueryRelatedFetchedExpression3FFF<E, R1, R2, R3, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple4<E, R1, R2, R3>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple4<E, R1, R2, R3>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple4<E, R1, R2, R3>>,
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
     * @param <R3>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelateExpression3FF
     */
    <RE extends EntityQueryRelateExpression3FF<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, Tuple3<E, R1, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, Tuple3<E, R1, R2>>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple3<E, R1, R2>>,
            QR extends EntityQueryRelatedFetchedExpression3FFF<E, R1, R2, R3, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple4<E, R1, R2, R3>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple4<E, R1, R2, R3>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple4<E, R1, R2, R3>>,
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
     * @param propertyName find type object property name
     * @return EntityQueryRelateExpression3FF
     */
    <RE extends EntityQueryRelateExpression3FF<E, R1, R2, E, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, E, RC, RL, RS, Tuple3<E, R1, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, E, RC, RL, RS, Tuple3<E, R1, R2>>,
            RS extends EntityQuerySortExpression4<E, R1, R2, E, Tuple3<E, R1, R2>>,
            QR extends EntityQueryRelatedFetchedExpression3FFF<E, R1, R2, E, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, E, QRC, QRL, QRS, Tuple4<E, R1, R2, E>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, E, QRC, QRL, QRS, Tuple4<E, R1, R2, E>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, E, Tuple4<E, R1, R2, E>>> RE join(
                    SerializableFunction3<E, E> propertyName);

    // ********************************************************************
    //	2
    // ********************************************************************

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
     * @return EntityQueryRelateExpression3FF
     */
    <RE extends EntityQueryRelateExpression3FF<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, Tuple3<E, R1, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, Tuple3<E, R1, R2>>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple3<E, R1, R2>>,
            QR extends EntityQueryRelatedFetchedExpression3FFF<E, R1, R2, R3, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple4<E, R1, R2, R3>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple4<E, R1, R2, R3>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple4<E, R1, R2, R3>>, R3,
            J> RE join2(SerializableFunction1<R1, J> propertyName, Class<R3> joinType);

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
     * @return EntityQueryRelateExpression3FF
     */
    <RE extends EntityQueryRelateExpression3FF<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, Tuple3<E, R1, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, Tuple3<E, R1, R2>>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple3<E, R1, R2>>,
            QR extends EntityQueryRelatedFetchedExpression3FFF<E, R1, R2, R3, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple4<E, R1, R2, R3>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple4<E, R1, R2, R3>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple4<E, R1, R2, R3>>, R3,
            J> RE join2(SerializableFunction1<R1, J> propertyName, SerializableFunction1<R3, J> joinTypePropertyName);

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
     * @return EntityQueryRelateExpression3FF
     */
    <RE extends EntityQueryRelateExpression3FF<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, Tuple3<E, R1, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, Tuple3<E, R1, R2>>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple3<E, R1, R2>>,
            QR extends EntityQueryRelatedFetchedExpression3FFF<E, R1, R2, R3, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple4<E, R1, R2, R3>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple4<E, R1, R2, R3>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple4<E, R1, R2, R3>>, R3,
            J> RE join2(SerializableFunction4<R3, J> joinTypePropertyName);

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
     * @return EntityQueryRelateExpression3FF
     */
    <RE extends EntityQueryRelateExpression3FF<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, Tuple3<E, R1, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, Tuple3<E, R1, R2>>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple3<E, R1, R2>>,
            QR extends EntityQueryRelatedFetchedExpression3FFF<E, R1, R2, R3, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple4<E, R1, R2, R3>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple4<E, R1, R2, R3>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple4<E, R1, R2, R3>>,
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
     * @param <R3>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelateExpression3FF
     */
    <RE extends EntityQueryRelateExpression3FF<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, Tuple3<E, R1, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, Tuple3<E, R1, R2>>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple3<E, R1, R2>>,
            QR extends EntityQueryRelatedFetchedExpression3FFF<E, R1, R2, R3, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple4<E, R1, R2, R3>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple4<E, R1, R2, R3>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple4<E, R1, R2, R3>>,
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
     * @param propertyName find type object property name
     * @return EntityQueryRelateExpression3FF
     */
    <RE extends EntityQueryRelateExpression3FF<E, R1, R2, R1, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R1, RC, RL, RS, Tuple3<E, R1, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R1, RC, RL, RS, Tuple3<E, R1, R2>>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R1, Tuple3<E, R1, R2>>,
            QR extends EntityQueryRelatedFetchedExpression3FFF<E, R1, R2, R1, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R1, QRC, QRL, QRS, Tuple4<E, R1, R2, R1>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R1, QRC, QRL, QRS, Tuple4<E, R1, R2, R1>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R1, Tuple4<E, R1, R2, R1>>> RE join2(
                    SerializableFunction3<R1, R1> propertyName);

    // ********************************************************************
    // 3
    // ********************************************************************

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
     * @return EntityQueryRelateExpression3FF
     */
    <RE extends EntityQueryRelateExpression3FF<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, Tuple3<E, R1, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, Tuple3<E, R1, R2>>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple3<E, R1, R2>>,
            QR extends EntityQueryRelatedFetchedExpression3FFF<E, R1, R2, R3, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple4<E, R1, R2, R3>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple4<E, R1, R2, R3>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple4<E, R1, R2, R3>>, R3,
            J> RE join3(SerializableFunction1<R2, J> propertyName, Class<R3> joinType);

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
     * @return EntityQueryRelateExpression3FF
     */
    <RE extends EntityQueryRelateExpression3FF<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, Tuple3<E, R1, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, Tuple3<E, R1, R2>>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple3<E, R1, R2>>,
            QR extends EntityQueryRelatedFetchedExpression3FFF<E, R1, R2, R3, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple4<E, R1, R2, R3>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple4<E, R1, R2, R3>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple4<E, R1, R2, R3>>, R3,
            J> RE join3(SerializableFunction1<R2, J> propertyName, SerializableFunction1<R3, J> joinTypePropertyName);

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
     * @return EntityQueryRelateExpression3FF
     */
    <RE extends EntityQueryRelateExpression3FF<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, Tuple3<E, R1, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, Tuple3<E, R1, R2>>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple3<E, R1, R2>>,
            QR extends EntityQueryRelatedFetchedExpression3FFF<E, R1, R2, R3, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple4<E, R1, R2, R3>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple4<E, R1, R2, R3>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple4<E, R1, R2, R3>>, R3,
            J> RE join3(SerializableFunction4<R3, J> joinTypePropertyName);

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
     * @return EntityQueryRelateExpression3FF
     */
    <RE extends EntityQueryRelateExpression3FF<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, Tuple3<E, R1, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, Tuple3<E, R1, R2>>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple3<E, R1, R2>>,
            QR extends EntityQueryRelatedFetchedExpression3FFF<E, R1, R2, R3, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple4<E, R1, R2, R3>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple4<E, R1, R2, R3>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple4<E, R1, R2, R3>>,
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
     * @param <R3>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelateExpression3FF
     */
    <RE extends EntityQueryRelateExpression3FF<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, Tuple3<E, R1, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, Tuple3<E, R1, R2>>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple3<E, R1, R2>>,
            QR extends EntityQueryRelatedFetchedExpression3FFF<E, R1, R2, R3, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple4<E, R1, R2, R3>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple4<E, R1, R2, R3>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple4<E, R1, R2, R3>>,
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
     * @param propertyName find type object property name
     * @return EntityQueryRelateExpression3FF
     */
    <RE extends EntityQueryRelateExpression3FF<E, R1, R2, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R2, RC, RL, RS, Tuple3<E, R1, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R2, RC, RL, RS, Tuple3<E, R1, R2>>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R2, Tuple3<E, R1, R2>>,
            QR extends EntityQueryRelatedFetchedExpression3FFF<E, R1, R2, R2, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R2, QRC, QRL, QRS, Tuple4<E, R1, R2, R2>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R2, QRC, QRL, QRS, Tuple4<E, R1, R2, R2>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R2, Tuple4<E, R1, R2, R2>>> RE join3(
                    SerializableFunction3<R2, R2> propertyName);

}
