package cn.featherfly.hammer.expression.entity.query.relation;

import com.speedment.common.tuple.Tuple2;
import com.speedment.common.tuple.Tuple3;

import cn.featherfly.common.lang.function.SerializableFunction1;
import cn.featherfly.common.lang.function.SerializableFunction2;
import cn.featherfly.common.lang.function.SerializableFunction3;
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

public interface EntityQueryRelatedFetchedExpression2PP<E, R1, R2,
        C extends EntityQueryConditionGroupExpression3<E, R1, R2, C, L, S, E>,
        L extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, C, L, S, E>,
        S extends EntityQuerySortExpression3<E, R1, R2, E>> extends EntityQueryExpression3<E, R1, R2, C, L, S, E> {

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
    <RE extends EntityQueryRelateExpression3RF<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R2>>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R2>>,
            QR extends EntityQueryRelatedFetchedExpression3RFF<E, R1, R2, R3, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple3<E, R2, R3>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple3<E, R2, R3>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple3<E, R2, R3>>,
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
     * @return TypeQueryWithOnExpression
     */
    <RE extends EntityQueryRelateExpression3RF<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
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
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    <RE extends EntityQueryRelateExpression3RF<E, R1, R2, E, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, E, RC, RL, RS, Tuple2<E, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, E, RC, RL, RS, Tuple2<E, R2>>,
            RS extends EntityQuerySortExpression4<E, R1, R2, E, Tuple2<E, R2>>,
            QR extends EntityQueryRelatedFetchedExpression3RFF<E, R1, R2, E, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, E, QRC, QRL, QRS, Tuple3<E, R2, E>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, E, QRC, QRL, QRS, Tuple3<E, R2, E>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, E, Tuple3<E, R2, E>>> RE join(
                    SerializableFunction3<E, E> propertyName);

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
    <RE extends EntityQueryRelateExpression3RF<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R2>>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R2>>,
            QR extends EntityQueryRelatedFetchedExpression3RFF<E, R1, R2, R3, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple3<E, R2, R3>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple3<E, R2, R3>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple3<E, R2, R3>>,
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
     * @return TypeQueryWithOnExpression
     */
    <RE extends EntityQueryRelateExpression3RF<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
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
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    <RE extends EntityQueryRelateExpression3RF<E, R1, R2, R1, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R1, RC, RL, RS, Tuple2<E, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R1, RC, RL, RS, Tuple2<E, R2>>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R1, Tuple2<E, R2>>,
            QR extends EntityQueryRelatedFetchedExpression3RFF<E, R1, R2, R1, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R1, QRC, QRL, QRS, Tuple3<E, R2, R1>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R1, QRC, QRL, QRS, Tuple3<E, R2, R1>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R1, Tuple3<E, R2, R1>>> RE join2(
                    SerializableFunction3<R1, R1> propertyName);

    // ********************************************************************
    // 2
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
     * @return TypeQueryWithOnExpression
     */
    <RE extends EntityQueryRelateExpression3RF<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, Tuple2<E, R2>>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R2>>,
            QR extends EntityQueryRelatedFetchedExpression3RFF<E, R1, R2, R3, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple3<E, R2, R3>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple3<E, R2, R3>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple3<E, R2, R3>>,
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
     * @return TypeQueryWithOnExpression
     */
    <RE extends EntityQueryRelateExpression3RF<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
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
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    <RE extends EntityQueryRelateExpression3RF<E, R1, R2, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R2, RC, RL, RS, Tuple2<E, R2>>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R2, RC, RL, RS, Tuple2<E, R2>>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R2, Tuple2<E, R2>>,
            QR extends EntityQueryRelatedFetchedExpression3RFF<E, R1, R2, R2, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R2, QRC, QRL, QRS, Tuple3<E, R2, R2>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R2, QRC, QRL, QRS, Tuple3<E, R2, R2>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R2, Tuple3<E, R2, R2>>> RE join3(
                    SerializableFunction3<R2, R2> propertyName);

}
