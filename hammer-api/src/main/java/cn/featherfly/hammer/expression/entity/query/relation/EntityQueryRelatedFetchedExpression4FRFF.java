/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntityQueryRelatedFetchedExpression4FRFF.java
 * @Package cn.featherfly.hammer.expression.entity.query.relation
 * @Description: todo (用一句话描述该文件做什么)
 * @author: zhongj
 * @date: 2023年8月31日 下午3:43:57
 * @version V1.0
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.query.relation;

import com.speedment.common.tuple.Tuple4;
import com.speedment.common.tuple.Tuple5;

import cn.featherfly.common.function.serializable.SerializableFunction1;
import cn.featherfly.common.function.serializable.SerializableFunction2;
import cn.featherfly.common.function.serializable.SerializableUnaryOperator1;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression5;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression6;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression5;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression6;
import cn.featherfly.hammer.expression.entity.query.EntityQueryExpression5;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression5;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression6;

/**
 * The Interface EntityQueryRelatedFetchedExpression4FRFF.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the relate type
 * @param <R2> the relate type
 * @param <R3> the relate type
 * @param <R4> the relate type
 * @param <C>  the generic type
 * @param <L>  the generic type
 * @param <S>  the generic type
 */

public interface EntityQueryRelatedFetchedExpression4FRFF<E, R1, R2, R3, R4,
        C extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, C, L, S, Tuple4<E, R1, R3, R4>>,
        L extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, C, L, S, Tuple4<E, R1, R3, R4>>,
        S extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple4<E, R1, R3, R4>>>
        extends EntityQueryExpression5<E, R1, R2, R3, R4, C, L, S, Tuple4<E, R1, R3, R4>> {
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
     * @param <R5>     the generic type
     * @param joinType the join type
     * @return EntityQueryRelateExpression5FRFFR
     */
    <QR extends EntityQueryRelateExpression5FRFFR<E, R1, R2, R3, R4, R5, RC, RL, RS, QRF, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple4<E, R1, R3, R4>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS,
                    Tuple4<E, R1, R3, R4>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple4<E, R1, R3, R4>>,
            QRF extends EntityQueryRelatedFetchedExpression5FRFFF<E, R1, R2, R3, R4, R5, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple5<E, R1, R3, R4, R5>>,
            QRL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple5<E, R1, R3, R4, R5>>,
            QRS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple5<E, R1, R3, R4, R5>>,
            R5> EntityQueryRelatedExpression<E, R5, QR, QRF> join(Class<R5> joinType);

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
     * @param <R5>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelateExpression5FRFFR
     */
    <RE extends EntityQueryRelateExpression5FRFFR<E, R1, R2, R3, R4, R5, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple4<E, R1, R3, R4>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS,
                    Tuple4<E, R1, R3, R4>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple4<E, R1, R3, R4>>,
            QR extends EntityQueryRelatedFetchedExpression5FRFFF<E, R1, R2, R3, R4, R5, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple5<E, R1, R3, R4, R5>>,
            QRL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple5<E, R1, R3, R4, R5>>,
            QRS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple5<E, R1, R3, R4, R5>>,
            R5> RE join(SerializableFunction2<R5, E> propertyName);

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <RC>         the generic type
     * @param <RL>         the generic type
     * @param <RS>         the generic type
     * @param <QR>         the generic type
     * @param <R5>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelateExpression5FRFFP
     */
    <RE extends EntityQueryRelateExpression5FRFFP<E, R1, R2, R3, R4, R5, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple4<E, R1, R3, R4>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS,
                    Tuple4<E, R1, R3, R4>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple4<E, R1, R3, R4>>,
            QR extends EntityQueryRelatedFetchedExpression5FRFFP<E, R1, R2, R3, R4, R5, RC, RL, RS>,
            R5> RE join(SerializableFunction1<E, R5> propertyName);

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <RC>         the generic type
     * @param <RL>         the generic type
     * @param <RS>         the generic type
     * @param <QR>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelateExpression5FRFFP
     */
    <RE extends EntityQueryRelateExpression5FRFFP<E, R1, R2, R3, R4, E, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, E, RC, RL, RS, Tuple4<E, R1, R3, R4>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, E, RC, RL, RS,
                    Tuple4<E, R1, R3, R4>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, E, Tuple4<E, R1, R3, R4>>,
            QR extends EntityQueryRelatedFetchedExpression5FRFFP<E, R1, R2, R3, R4, E, RC, RL, RS>> RE join(
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
     * @param <R5>     the generic type
     * @param joinType the join type
     * @return EntityQueryRelateExpression5FRFFR
     */
    <QR extends EntityQueryRelateExpression5FRFFR<E, R1, R2, R3, R4, R5, RC, RL, RS, QRF, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple4<E, R1, R3, R4>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS,
                    Tuple4<E, R1, R3, R4>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple4<E, R1, R3, R4>>,
            QRF extends EntityQueryRelatedFetchedExpression5FRFFF<E, R1, R2, R3, R4, R5, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple5<E, R1, R3, R4, R5>>,
            QRL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple5<E, R1, R3, R4, R5>>,
            QRS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple5<E, R1, R3, R4, R5>>,
            R5> EntityQueryRelatedExpression<R1, R5, QR, QRF> join2(Class<R5> joinType);

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
     * @param <R5>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelateExpression5FRFFR
     */
    <RE extends EntityQueryRelateExpression5FRFFR<E, R1, R2, R3, R4, R5, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple4<E, R1, R3, R4>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS,
                    Tuple4<E, R1, R3, R4>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple4<E, R1, R3, R4>>,
            QR extends EntityQueryRelatedFetchedExpression5FRFFF<E, R1, R2, R3, R4, R5, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple5<E, R1, R3, R4, R5>>,
            QRL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple5<E, R1, R3, R4, R5>>,
            QRS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple5<E, R1, R3, R4, R5>>,
            R5> RE join2(SerializableFunction2<R5, R1> propertyName);

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <RC>         the generic type
     * @param <RL>         the generic type
     * @param <RS>         the generic type
     * @param <QR>         the generic type
     * @param <R5>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelateExpression5FRFFP
     */
    <RE extends EntityQueryRelateExpression5FRFFP<E, R1, R2, R3, R4, R5, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple4<E, R1, R3, R4>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS,
                    Tuple4<E, R1, R3, R4>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple4<E, R1, R3, R4>>,
            QR extends EntityQueryRelatedFetchedExpression5FRFFP<E, R1, R2, R3, R4, R5, RC, RL, RS>,
            R5> RE join2(SerializableFunction1<R1, R5> propertyName);

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <RC>         the generic type
     * @param <RL>         the generic type
     * @param <RS>         the generic type
     * @param <QR>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelateExpression5FRFFP
     */
    <RE extends EntityQueryRelateExpression5FRFFP<E, R1, R2, R3, R4, R1, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R1, RC, RL, RS, Tuple4<E, R1, R3, R4>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R1, RC, RL, RS,
                    Tuple4<E, R1, R3, R4>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R1, Tuple4<E, R1, R3, R4>>,
            QR extends EntityQueryRelatedFetchedExpression5FRFFP<E, R1, R2, R3, R4, R1, RC, RL, RS>> RE join2(
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
     * @param <R5>     the generic type
     * @param joinType the join type
     * @return EntityQueryRelateExpression5FRFFR
     */
    <QR extends EntityQueryRelateExpression5FRFFR<E, R1, R2, R3, R4, R5, RC, RL, RS, QRF, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple4<E, R1, R3, R4>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS,
                    Tuple4<E, R1, R3, R4>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple4<E, R1, R3, R4>>,
            QRF extends EntityQueryRelatedFetchedExpression5FRFFF<E, R1, R2, R3, R4, R5, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple5<E, R1, R3, R4, R5>>,
            QRL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple5<E, R1, R3, R4, R5>>,
            QRS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple5<E, R1, R3, R4, R5>>,
            R5> EntityQueryRelatedExpression<R2, R5, QR, QRF> join3(Class<R5> joinType);

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
     * @param <R5>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelateExpression5FRFFR
     */
    <RE extends EntityQueryRelateExpression5FRFFR<E, R1, R2, R3, R4, R5, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple4<E, R1, R3, R4>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS,
                    Tuple4<E, R1, R3, R4>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple4<E, R1, R3, R4>>,
            QR extends EntityQueryRelatedFetchedExpression5FRFFF<E, R1, R2, R3, R4, R5, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple5<E, R1, R3, R4, R5>>,
            QRL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple5<E, R1, R3, R4, R5>>,
            QRS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple5<E, R1, R3, R4, R5>>,
            R5> RE join3(SerializableFunction2<R5, R2> propertyName);

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <RC>         the generic type
     * @param <RL>         the generic type
     * @param <RS>         the generic type
     * @param <QR>         the generic type
     * @param <R5>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelateExpression5FRFFP
     */
    <RE extends EntityQueryRelateExpression5FRFFP<E, R1, R2, R3, R4, R5, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple4<E, R1, R3, R4>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS,
                    Tuple4<E, R1, R3, R4>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple4<E, R1, R3, R4>>,
            QR extends EntityQueryRelatedFetchedExpression5FRFFP<E, R1, R2, R3, R4, R5, RC, RL, RS>,
            R5> RE join3(SerializableFunction1<R2, R5> propertyName);

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <RC>         the generic type
     * @param <RL>         the generic type
     * @param <RS>         the generic type
     * @param <QR>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelateExpression5FRFFP
     */
    <RE extends EntityQueryRelateExpression5FRFFP<E, R1, R2, R3, R4, R2, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R2, RC, RL, RS, Tuple4<E, R1, R3, R4>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R2, RC, RL, RS,
                    Tuple4<E, R1, R3, R4>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R2, Tuple4<E, R1, R3, R4>>,
            QR extends EntityQueryRelatedFetchedExpression5FRFFP<E, R1, R2, R3, R4, R2, RC, RL, RS>> RE join3(
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
     * @param <R5>     the generic type
     * @param joinType the join type
     * @return EntityQueryRelateExpression5FRFFR
     */
    <QR extends EntityQueryRelateExpression5FRFFR<E, R1, R2, R3, R4, R5, RC, RL, RS, QRF, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple4<E, R1, R3, R4>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS,
                    Tuple4<E, R1, R3, R4>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple4<E, R1, R3, R4>>,
            QRF extends EntityQueryRelatedFetchedExpression5FRFFF<E, R1, R2, R3, R4, R5, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple5<E, R1, R3, R4, R5>>,
            QRL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple5<E, R1, R3, R4, R5>>,
            QRS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple5<E, R1, R3, R4, R5>>,
            R5> EntityQueryRelatedExpression<R3, R5, QR, QRF> join4(Class<R5> joinType);

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
     * @param <R5>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelateExpression5FRFFR
     */
    <RE extends EntityQueryRelateExpression5FRFFR<E, R1, R2, R3, R4, R5, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple4<E, R1, R3, R4>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS,
                    Tuple4<E, R1, R3, R4>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple4<E, R1, R3, R4>>,
            QR extends EntityQueryRelatedFetchedExpression5FRFFF<E, R1, R2, R3, R4, R5, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple5<E, R1, R3, R4, R5>>,
            QRL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple5<E, R1, R3, R4, R5>>,
            QRS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple5<E, R1, R3, R4, R5>>,
            R5> RE join4(SerializableFunction2<R5, R3> propertyName);

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <RC>         the generic type
     * @param <RL>         the generic type
     * @param <RS>         the generic type
     * @param <QR>         the generic type
     * @param <R5>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelateExpression5FRFFP
     */
    <RE extends EntityQueryRelateExpression5FRFFP<E, R1, R2, R3, R4, R5, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple4<E, R1, R3, R4>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS,
                    Tuple4<E, R1, R3, R4>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple4<E, R1, R3, R4>>,
            QR extends EntityQueryRelatedFetchedExpression5FRFFP<E, R1, R2, R3, R4, R5, RC, RL, RS>,
            R5> RE join4(SerializableFunction1<R3, R5> propertyName);

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <RC>         the generic type
     * @param <RL>         the generic type
     * @param <RS>         the generic type
     * @param <QR>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelateExpression5FRFFP
     */
    <RE extends EntityQueryRelateExpression5FRFFP<E, R1, R2, R3, R4, R3, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R3, RC, RL, RS, Tuple4<E, R1, R3, R4>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R3, RC, RL, RS,
                    Tuple4<E, R1, R3, R4>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R3, Tuple4<E, R1, R3, R4>>,
            QR extends EntityQueryRelatedFetchedExpression5FRFFP<E, R1, R2, R3, R4, R3, RC, RL, RS>> RE join4(
                    SerializableUnaryOperator1<R3> propertyName);

    // ********************************************************************
    // 5
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
     * @param <R5>     the generic type
     * @param joinType the join type
     * @return EntityQueryRelateExpression5FRFFR
     */
    <QR extends EntityQueryRelateExpression5FRFFR<E, R1, R2, R3, R4, R5, RC, RL, RS, QRF, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple4<E, R1, R3, R4>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS,
                    Tuple4<E, R1, R3, R4>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple4<E, R1, R3, R4>>,
            QRF extends EntityQueryRelatedFetchedExpression5FRFFF<E, R1, R2, R3, R4, R5, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple5<E, R1, R3, R4, R5>>,
            QRL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple5<E, R1, R3, R4, R5>>,
            QRS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple5<E, R1, R3, R4, R5>>,
            R5> EntityQueryRelatedExpression<R4, R5, QR, QRF> join5(Class<R5> joinType);

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
     * @param <R5>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelateExpression5FRFFR
     */
    <RE extends EntityQueryRelateExpression5FRFFR<E, R1, R2, R3, R4, R5, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple4<E, R1, R3, R4>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS,
                    Tuple4<E, R1, R3, R4>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple4<E, R1, R3, R4>>,
            QR extends EntityQueryRelatedFetchedExpression5FRFFF<E, R1, R2, R3, R4, R5, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple5<E, R1, R3, R4, R5>>,
            QRL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, QRC, QRL, QRS,
                    Tuple5<E, R1, R3, R4, R5>>,
            QRS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple5<E, R1, R3, R4, R5>>,
            R5> RE join5(SerializableFunction2<R5, R4> propertyName);

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <RC>         the generic type
     * @param <RL>         the generic type
     * @param <RS>         the generic type
     * @param <QR>         the generic type
     * @param <R5>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelateExpression5FRFFP
     */
    <RE extends EntityQueryRelateExpression5FRFFP<E, R1, R2, R3, R4, R5, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS, Tuple4<E, R1, R3, R4>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R5, RC, RL, RS,
                    Tuple4<E, R1, R3, R4>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R5, Tuple4<E, R1, R3, R4>>,
            QR extends EntityQueryRelatedFetchedExpression5FRFFP<E, R1, R2, R3, R4, R5, RC, RL, RS>,
            R5> RE join5(SerializableFunction1<R4, R5> propertyName);

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <RC>         the generic type
     * @param <RL>         the generic type
     * @param <RS>         the generic type
     * @param <QR>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelateExpression5FRFFP
     */
    <RE extends EntityQueryRelateExpression5FRFFP<E, R1, R2, R3, R4, R4, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression6<E, R1, R2, R3, R4, R4, RC, RL, RS, Tuple4<E, R1, R3, R4>>,
            RL extends EntityQueryConditionGroupLogicExpression6<E, R1, R2, R3, R4, R4, RC, RL, RS,
                    Tuple4<E, R1, R3, R4>>,
            RS extends EntityQuerySortExpression6<E, R1, R2, R3, R4, R4, Tuple4<E, R1, R3, R4>>,
            QR extends EntityQueryRelatedFetchedExpression5FRFFP<E, R1, R2, R3, R4, R4, RC, RL, RS>> RE join5(
                    SerializableUnaryOperator1<R4> propertyName);
}
