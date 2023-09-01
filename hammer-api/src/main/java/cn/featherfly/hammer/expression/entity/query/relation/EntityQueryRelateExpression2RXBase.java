
package cn.featherfly.hammer.expression.entity.query.relation;

import com.speedment.common.tuple.Tuple2;

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
 * The Interface EntityQueryRelateExpression2RXBase.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 * @param <R2> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 * @param <S>  the generic type
 */
public interface EntityQueryRelateExpression2RXBase<E, R1, R2,
        C extends EntityQueryConditionGroupExpression3<E, R1, R2, C, L, S, E>,
        L extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, C, L, S, E>,
        S extends EntityQuerySortExpression3<E, R1, R2, E>> extends EntityQueryExpression3<E, R1, R2, C, L, S, E> {

    /**
     * join.
     *
     * @param <QR>     the generic type
     * @param <RC>     the generic type
     * @param <RL>     the generic type
     * @param <RS>     the generic type
     * @param <QRF>    the generic type
     * @param <FC>     the generic type
     * @param <FL>     the generic type
     * @param <FS>     the generic type
     * @param <R3>     the generic type
     * @param joinType the join type
     * @return EntityQueryRelateExpression3RRR
     */
    <QR extends EntityQueryRelateExpression3RRR<E, R1, R2, R3, RC, RL, RS, QRF, FC, FL, FS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, E>,
            QRF extends EntityQueryRelatedFetchedExpression3RRF<E, R1, R2, R3, FC, FL, FS>,
            FC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, FC, FL, FS, Tuple2<E, R3>>,
            FL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, FC, FL, FS, Tuple2<E, R3>>,
            FS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R3>>,
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
     * @return TypeQueryWithOnExpression
     */
    <RE extends EntityQueryRelateExpression3RRR<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, E>,
            QR extends EntityQueryRelatedFetchedExpression3RRF<E, R1, R2, R3, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R3>>,
            R3> RE join(SerializableFunction2<R3, E> propertyName);

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <RC>         the generic type
     * @param <RL>         the generic type
     * @param <RS>         the generic type
     * @param <QR>         the generic type
     * @param <R3>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    <RE extends EntityQueryRelateExpression3RRP<E, R1, R2, R3, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, E>,
            QR extends EntityQueryRelatedFetchedExpression3RRP<E, R1, R2, R3, RC, RL, RS>,
            R3> RE join(SerializableFunction1<E, R3> propertyName);

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <RC>         the generic type
     * @param <RL>         the generic type
     * @param <RS>         the generic type
     * @param <QR>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    <RE extends EntityQueryRelateExpression3RRP<E, R1, R2, E, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, E, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, E, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression4<E, R1, R2, E, E>,
            QR extends EntityQueryRelatedFetchedExpression3RRP<E, R1, R2, E, RC, RL, RS>> RE join(
                    SerializableUnaryOperator1<E> propertyName);

    // ****************************************************************************************************************
    //	join 2
    // ****************************************************************************************************************

    /**
     * join.
     *
     * @param <QR>     the generic type
     * @param <RC>     the generic type
     * @param <RL>     the generic type
     * @param <RS>     the generic type
     * @param <QRF>    the generic type
     * @param <FC>     the generic type
     * @param <FL>     the generic type
     * @param <FS>     the generic type
     * @param <R3>     the generic type
     * @param joinType the join type
     * @return EntityQueryRelateExpression3RRR
     */
    <QR extends EntityQueryRelateExpression3RRR<E, R1, R2, R3, RC, RL, RS, QRF, FC, FL, FS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, E>,
            QRF extends EntityQueryRelatedFetchedExpression3RRF<E, R1, R2, R3, FC, FL, FS>,
            FC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, FC, FL, FS, Tuple2<E, R3>>,
            FL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, FC, FL, FS, Tuple2<E, R3>>,
            FS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R3>>,
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
     * @return TypeQueryWithOnExpression
     */
    <RE extends EntityQueryRelateExpression3RRR<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, E>,
            QR extends EntityQueryRelatedFetchedExpression3RRF<E, R1, R2, R3, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R3>>,
            R3> RE join2(SerializableFunction2<R3, R1> propertyName);

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <RC>         the generic type
     * @param <RL>         the generic type
     * @param <RS>         the generic type
     * @param <QR>         the generic type
     * @param <R3>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    <RE extends EntityQueryRelateExpression3RRP<E, R1, R2, R3, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, E>,
            QR extends EntityQueryRelatedFetchedExpression3RRP<E, R1, R2, R3, RC, RL, RS>,
            R3> RE join2(SerializableFunction1<R1, R3> propertyName);

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <RC>         the generic type
     * @param <RL>         the generic type
     * @param <RS>         the generic type
     * @param <QR>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    <RE extends EntityQueryRelateExpression3RRP<E, R1, R2, R1, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R1, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R1, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R1, E>,
            QR extends EntityQueryRelatedFetchedExpression3RRP<E, R1, R2, R1, RC, RL, RS>> RE join2(
                    SerializableUnaryOperator1<R1> propertyName);

    // ********************************************************************
    // join 3
    // ********************************************************************

    /**
     * join.
     *
     * @param <QR>     the generic type
     * @param <RC>     the generic type
     * @param <RL>     the generic type
     * @param <RS>     the generic type
     * @param <QRF>    the generic type
     * @param <FC>     the generic type
     * @param <FL>     the generic type
     * @param <FS>     the generic type
     * @param <R3>     the generic type
     * @param joinType the join type
     * @return EntityQueryRelateExpression3RRR
     */
    <QR extends EntityQueryRelateExpression3RRR<E, R1, R2, R3, RC, RL, RS, QRF, FC, FL, FS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, E>,
            QRF extends EntityQueryRelatedFetchedExpression3RRF<E, R1, R2, R3, FC, FL, FS>,
            FC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, FC, FL, FS, Tuple2<E, R3>>,
            FL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, FC, FL, FS, Tuple2<E, R3>>,
            FS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R3>>,
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
     * @return TypeQueryWithOnExpression
     */
    <RE extends EntityQueryRelateExpression3RRR<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, E>,
            QR extends EntityQueryRelatedFetchedExpression3RRF<E, R1, R2, R3, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R3>>,
            R3> RE join3(SerializableFunction2<R3, R2> propertyName);

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <RC>         the generic type
     * @param <RL>         the generic type
     * @param <RS>         the generic type
     * @param <QR>         the generic type
     * @param <R3>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    <RE extends EntityQueryRelateExpression3RRP<E, R1, R2, R3, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, E>,
            QR extends EntityQueryRelatedFetchedExpression3RRP<E, R1, R2, R3, RC, RL, RS>,
            R3> RE join3(SerializableFunction1<R2, R3> propertyName);

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <RC>         the generic type
     * @param <RL>         the generic type
     * @param <RS>         the generic type
     * @param <QR>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    <RE extends EntityQueryRelateExpression3RRP<E, R1, R2, R2, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R2, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R2, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R2, E>,
            QR extends EntityQueryRelatedFetchedExpression3RRP<E, R1, R2, R2, RC, RL, RS>> RE join3(
                    SerializableUnaryOperator1<R2> propertyName);

}
