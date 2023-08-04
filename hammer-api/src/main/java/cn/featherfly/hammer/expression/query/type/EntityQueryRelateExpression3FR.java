
package cn.featherfly.hammer.expression.query.type;

import com.speedment.common.tuple.Tuple2;
import com.speedment.common.tuple.Tuple3;

import cn.featherfly.common.lang.function.SerializableFunction1;
import cn.featherfly.common.lang.function.SerializableFunction2;
import cn.featherfly.common.lang.function.SerializableFunction3;
import cn.featherfly.common.lang.function.SerializableFunction4;
import cn.featherfly.hammer.expression.api.entity.EntityQueryRelate;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression4;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression5;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression4;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression5;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression4;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression5;

/**
 * The Interface EntityQueryRelateExpression3FR.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 * @param <R2> the generic type
 * @param <R3> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 * @param <S>  the generic type
 * @param <F>  the generic type
 * @param <FC> the generic type
 * @param <FL> the generic type
 * @param <FS> the generic type
 */
public interface EntityQueryRelateExpression3FR<E, R1, R2, R3,
        C extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, C, L, S, Tuple2<E, R1>>,
        L extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, C, L, S, Tuple2<E, R1>>,
        S extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R1>>,
        F extends EntityQueryRelatedFetchedExpression3FRF<E, R1, R2, R3, FC, FL, FS>,
        FC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, FC, FL, FS, Tuple3<E, R1, R3>>,
        FL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, FC, FL, FS, Tuple3<E, R1, R3>>,
        FS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple3<E, R1, R3>>>
        extends EntityQueryExpression4<E, R1, R2, R3, C, L, S, Tuple2<E, R1>>, EntityQueryRelate<F> {

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
     * @param <J>          the generic type
     * @param propertyName find type object property name
     * @param joinType     the join type
     * @return EntityQueryRelateExpression4FRR
     */
    <RE extends EntityQueryRelateExpression4FRR<E, R1, R2, R3, R4, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple2<E, R1>>,
            QR extends EntityQueryRelatedFetchedExpression4FRRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple3<E, R1, R4>>, R4,
            J> RE join(SerializableFunction1<E, J> propertyName, Class<R4> joinType);

    /**
     * join on.
     *
     * @param <RE>                 the generic type
     * @param <RC>                 the generic type
     * @param <RL>                 the generic type
     * @param <RS>                 the generic type
     * @param <QR>                 the generic type
     * @param <QRC>                the generic type
     * @param <QRL>                the generic type
     * @param <QRS>                the generic type
     * @param <R4>                 the generic type
     * @param <J>                  the generic type
     * @param propertyName         find type object property name
     * @param joinTypePropertyName the join type property name
     * @return EntityQueryRelateExpression4FRR
     */
    <RE extends EntityQueryRelateExpression4FRR<E, R1, R2, R3, R4, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple2<E, R1>>,
            QR extends EntityQueryRelatedFetchedExpression4FRRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple3<E, R1, R4>>, R4,
            J> RE join(SerializableFunction1<E, J> propertyName, SerializableFunction1<R4, J> joinTypePropertyName);

    /**
     * join on.
     *
     * @param <RE>                 the generic type
     * @param <RC>                 the generic type
     * @param <RL>                 the generic type
     * @param <RS>                 the generic type
     * @param <QR>                 the generic type
     * @param <QRC>                the generic type
     * @param <QRL>                the generic type
     * @param <QRS>                the generic type
     * @param <R4>                 the generic type
     * @param <J>                  the generic type
     * @param joinTypePropertyName the join type property name
     * @return EntityQueryRelateExpression4FRR
     */
    <RE extends EntityQueryRelateExpression4FRR<E, R1, R2, R3, R4, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple2<E, R1>>,
            QR extends EntityQueryRelatedFetchedExpression4FRRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple3<E, R1, R4>>, R4,
            J> RE join(SerializableFunction4<R4, J> joinTypePropertyName);

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
     * @return EntityQueryRelateExpression4FRR
     */
    <RE extends EntityQueryRelateExpression4FRR<E, R1, R2, R3, R4, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple2<E, R1>>,
            QR extends EntityQueryRelatedFetchedExpression4FRRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple3<E, R1, R4>>,
            R4> RE join(SerializableFunction1<E, R4> propertyName);

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
     * @return EntityQueryRelateExpression4FRR
     */
    <RE extends EntityQueryRelateExpression4FRR<E, R1, R2, R3, R4, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple2<E, R1>>,
            QR extends EntityQueryRelatedFetchedExpression4FRRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple3<E, R1, R4>>,
            R4> RE join(SerializableFunction2<R4, E> propertyName);

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
     * @return EntityQueryRelateExpression4FRR
     */
    <RE extends EntityQueryRelateExpression4FRR<E, R1, R2, R3, E, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, E, RC, RL, RS, Tuple2<E, R1>>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, E, RC, RL, RS, Tuple2<E, R1>>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, E, Tuple2<E, R1>>,
            QR extends EntityQueryRelatedFetchedExpression4FRRF<E, R1, R2, R3, E, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, E, QRC, QRL, QRS, Tuple3<E, R1, E>>,
            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, E, QRC, QRL, QRS, Tuple3<E, R1, E>>,
            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, E, Tuple3<E, R1, E>>> RE join(
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
     * @param <R4>         the generic type
     * @param <J>          the generic type
     * @param propertyName find type object property name
     * @param joinType     the join type
     * @return EntityQueryRelateExpression4FRR
     */
    <RE extends EntityQueryRelateExpression4FRR<E, R1, R2, R3, R4, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple2<E, R1>>,
            QR extends EntityQueryRelatedFetchedExpression4FRRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple3<E, R1, R4>>, R4,
            J> RE join2(SerializableFunction1<R1, J> propertyName, Class<R4> joinType);

    /**
     * join on.
     *
     * @param <RE>                 the generic type
     * @param <RC>                 the generic type
     * @param <RL>                 the generic type
     * @param <RS>                 the generic type
     * @param <QR>                 the generic type
     * @param <QRC>                the generic type
     * @param <QRL>                the generic type
     * @param <QRS>                the generic type
     * @param <R4>                 the generic type
     * @param <J>                  the generic type
     * @param propertyName         find type object property name
     * @param joinTypePropertyName the join type property name
     * @return EntityQueryRelateExpression4FRR
     */
    <RE extends EntityQueryRelateExpression4FRR<E, R1, R2, R3, R4, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple2<E, R1>>,
            QR extends EntityQueryRelatedFetchedExpression4FRRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple3<E, R1, R4>>, R4,
            J> RE join2(SerializableFunction1<R1, J> propertyName, SerializableFunction1<R4, J> joinTypePropertyName);

    /**
     * join on.
     *
     * @param <RE>                 the generic type
     * @param <RC>                 the generic type
     * @param <RL>                 the generic type
     * @param <RS>                 the generic type
     * @param <QR>                 the generic type
     * @param <QRC>                the generic type
     * @param <QRL>                the generic type
     * @param <QRS>                the generic type
     * @param <R4>                 the generic type
     * @param <J>                  the generic type
     * @param joinTypePropertyName the join type property name
     * @return EntityQueryRelateExpression4FRR
     */
    <RE extends EntityQueryRelateExpression4FRR<E, R1, R2, R3, R4, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple2<E, R1>>,
            QR extends EntityQueryRelatedFetchedExpression4FRRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple3<E, R1, R4>>, R4,
            J> RE join2(SerializableFunction4<R4, J> joinTypePropertyName);

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
     * @return EntityQueryRelateExpression4FRR
     */
    <RE extends EntityQueryRelateExpression4FRR<E, R1, R2, R3, R4, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple2<E, R1>>,
            QR extends EntityQueryRelatedFetchedExpression4FRRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple3<E, R1, R4>>,
            R4> RE join2(SerializableFunction1<R1, R4> propertyName);

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
     * @return EntityQueryRelateExpression4FRR
     */
    <RE extends EntityQueryRelateExpression4FRR<E, R1, R2, R3, R4, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple2<E, R1>>,
            QR extends EntityQueryRelatedFetchedExpression4FRRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple3<E, R1, R4>>,
            R4> RE join2(SerializableFunction2<R4, R1> propertyName);

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
     * @return EntityQueryRelateExpression4FRR
     */
    <RE extends EntityQueryRelateExpression4FRR<E, R1, R2, R3, R1, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R1, RC, RL, RS, Tuple2<E, R1>>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R1, RC, RL, RS, Tuple2<E, R1>>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R1, Tuple2<E, R1>>,
            QR extends EntityQueryRelatedFetchedExpression4FRRF<E, R1, R2, R3, R1, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R1, QRC, QRL, QRS, Tuple3<E, R1, R1>>,
            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R1, QRC, QRL, QRS, Tuple3<E, R1, R1>>,
            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R1, Tuple3<E, R1, R1>>> RE join2(
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
     * @param <R4>         the generic type
     * @param <J>          the generic type
     * @param propertyName find type object property name
     * @param joinType     the join type
     * @return EntityQueryRelateExpression4FRR
     */
    <RE extends EntityQueryRelateExpression4FRR<E, R1, R2, R3, R4, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple2<E, R1>>,
            QR extends EntityQueryRelatedFetchedExpression4FRRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple3<E, R1, R4>>, R4,
            J> RE join3(SerializableFunction1<R2, J> propertyName, Class<R4> joinType);

    /**
     * join on.
     *
     * @param <RE>                 the generic type
     * @param <RC>                 the generic type
     * @param <RL>                 the generic type
     * @param <RS>                 the generic type
     * @param <QR>                 the generic type
     * @param <QRC>                the generic type
     * @param <QRL>                the generic type
     * @param <QRS>                the generic type
     * @param <R4>                 the generic type
     * @param <J>                  the generic type
     * @param propertyName         find type object property name
     * @param joinTypePropertyName the join type property name
     * @return EntityQueryRelateExpression4FRR
     */
    <RE extends EntityQueryRelateExpression4FRR<E, R1, R2, R3, R4, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple2<E, R1>>,
            QR extends EntityQueryRelatedFetchedExpression4FRRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple3<E, R1, R4>>, R4,
            J> RE join3(SerializableFunction1<R2, J> propertyName, SerializableFunction1<R4, J> joinTypePropertyName);

    /**
     * join on.
     *
     * @param <RE>                 the generic type
     * @param <RC>                 the generic type
     * @param <RL>                 the generic type
     * @param <RS>                 the generic type
     * @param <QR>                 the generic type
     * @param <QRC>                the generic type
     * @param <QRL>                the generic type
     * @param <QRS>                the generic type
     * @param <R4>                 the generic type
     * @param <J>                  the generic type
     * @param joinTypePropertyName the join type property name
     * @return EntityQueryRelateExpression4FRR
     */
    <RE extends EntityQueryRelateExpression4FRR<E, R1, R2, R3, R4, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple2<E, R1>>,
            QR extends EntityQueryRelatedFetchedExpression4FRRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple3<E, R1, R4>>, R4,
            J> RE join3(SerializableFunction4<R4, J> joinTypePropertyName);

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
     * @return EntityQueryRelateExpression4FRR
     */
    <RE extends EntityQueryRelateExpression4FRR<E, R1, R2, R3, R4, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple2<E, R1>>,
            QR extends EntityQueryRelatedFetchedExpression4FRRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple3<E, R1, R4>>,
            R4> RE join3(SerializableFunction1<R2, R4> propertyName);

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
     * @return EntityQueryRelateExpression4FRR
     */
    <RE extends EntityQueryRelateExpression4FRR<E, R1, R2, R3, R4, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple2<E, R1>>,
            QR extends EntityQueryRelatedFetchedExpression4FRRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple3<E, R1, R4>>,
            R4> RE join3(SerializableFunction2<R4, R2> propertyName);

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
     * @return EntityQueryRelateExpression4FRR
     */
    <RE extends EntityQueryRelateExpression4FRR<E, R1, R2, R3, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R2, RC, RL, RS, Tuple2<E, R1>>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R2, RC, RL, RS, Tuple2<E, R1>>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R2, Tuple2<E, R1>>,
            QR extends EntityQueryRelatedFetchedExpression4FRRF<E, R1, R2, R3, R2, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R2, QRC, QRL, QRS, Tuple3<E, R1, R2>>,
            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R2, QRC, QRL, QRS, Tuple3<E, R1, R2>>,
            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R2, Tuple3<E, R1, R2>>> RE join3(
                    SerializableFunction3<R2, R2> propertyName);

    // ********************************************************************
    // 4
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
     * @param <R4>         the generic type
     * @param <J>          the generic type
     * @param propertyName find type object property name
     * @param joinType     the join type
     * @return EntityQueryRelateExpression4FRR
     */
    <RE extends EntityQueryRelateExpression4FRR<E, R1, R2, R3, R4, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple2<E, R1>>,
            QR extends EntityQueryRelatedFetchedExpression4FRRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple3<E, R1, R4>>, R4,
            J> RE join4(SerializableFunction1<R3, J> propertyName, Class<R4> joinType);

    /**
     * join on.
     *
     * @param <RE>                 the generic type
     * @param <RC>                 the generic type
     * @param <RL>                 the generic type
     * @param <RS>                 the generic type
     * @param <QR>                 the generic type
     * @param <QRC>                the generic type
     * @param <QRL>                the generic type
     * @param <QRS>                the generic type
     * @param <R4>                 the generic type
     * @param <J>                  the generic type
     * @param propertyName         find type object property name
     * @param joinTypePropertyName the join type property name
     * @return EntityQueryRelateExpression4FRR
     */
    <RE extends EntityQueryRelateExpression4FRR<E, R1, R2, R3, R4, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple2<E, R1>>,
            QR extends EntityQueryRelatedFetchedExpression4FRRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple3<E, R1, R4>>, R4,
            J> RE join4(SerializableFunction1<R3, J> propertyName, SerializableFunction1<R4, J> joinTypePropertyName);

    /**
     * join on.
     *
     * @param <RE>                 the generic type
     * @param <RC>                 the generic type
     * @param <RL>                 the generic type
     * @param <RS>                 the generic type
     * @param <QR>                 the generic type
     * @param <QRC>                the generic type
     * @param <QRL>                the generic type
     * @param <QRS>                the generic type
     * @param <R4>                 the generic type
     * @param <J>                  the generic type
     * @param joinTypePropertyName the join type property name
     * @return EntityQueryRelateExpression4FRR
     */
    <RE extends EntityQueryRelateExpression4FRR<E, R1, R2, R3, R4, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple2<E, R1>>,
            QR extends EntityQueryRelatedFetchedExpression4FRRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple3<E, R1, R4>>, R4,
            J> RE join4(SerializableFunction4<R4, J> joinTypePropertyName);

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
     * @return EntityQueryRelateExpression4FRR
     */
    <RE extends EntityQueryRelateExpression4FRR<E, R1, R2, R3, R4, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple2<E, R1>>,
            QR extends EntityQueryRelatedFetchedExpression4FRRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple3<E, R1, R4>>,
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
     * @param <R4>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelateExpression4FRR
     */
    <RE extends EntityQueryRelateExpression4FRR<E, R1, R2, R3, R4, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, RC, RL, RS, Tuple2<E, R1>>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple2<E, R1>>,
            QR extends EntityQueryRelatedFetchedExpression4FRRF<E, R1, R2, R3, R4, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R4, QRC, QRL, QRS, Tuple3<E, R1, R4>>,
            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R4, Tuple3<E, R1, R4>>,
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
     * @param propertyName find type object property name
     * @return EntityQueryRelateExpression4FRR
     */
    <RE extends EntityQueryRelateExpression4FRR<E, R1, R2, R3, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R3, RC, RL, RS, Tuple2<E, R1>>,
            RL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R3, RC, RL, RS, Tuple2<E, R1>>,
            RS extends EntityQuerySortExpression5<E, R1, R2, R3, R3, Tuple2<E, R1>>,
            QR extends EntityQueryRelatedFetchedExpression4FRRF<E, R1, R2, R3, R3, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression5<E, R1, R2, R3, R3, QRC, QRL, QRS, Tuple3<E, R1, R3>>,
            QRL extends EntityQueryConditionGroupLogicExpression5<E, R1, R2, R3, R3, QRC, QRL, QRS, Tuple3<E, R1, R3>>,
            QRS extends EntityQuerySortExpression5<E, R1, R2, R3, R3, Tuple3<E, R1, R3>>> RE join4(
                    SerializableFunction3<R3, R3> propertyName);
}
