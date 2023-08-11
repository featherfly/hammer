
package cn.featherfly.hammer.expression.entity.query.relation;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.common.lang.function.SerializableFunction1;
import cn.featherfly.common.lang.function.SerializableFunction2;
import cn.featherfly.common.lang.function.SerializableFunction3;
import cn.featherfly.hammer.expression.api.entity.EntityQueryRelate;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression3;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression4;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression3;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression4;
import cn.featherfly.hammer.expression.entity.query.EntityQueryExpression3;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression3;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression4;

/**
 * The Interface EntityQueryRelateExpression2R.
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
     * @return EntityQueryRelateExpression3RR
     */
    <QR extends EntityQueryRelateExpression3RR<E, R1, R2, R3, RC, RL, RS, QRF, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, E>,
            QRF extends EntityQueryRelatedFetchedExpression3RRF<E, R1, R2, R3, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R3>>,
            R3> EntityQueryRelatedExpression<E, R3, QR, QRF> join(Class<R3> joinType);

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
    //     * @param <R3>         the generic type
    //     * @param <J>          the generic type
    //     * @param propertyName find type object property name
    //     * @param joinType     the join type
    //     * @return EntityQueryRelateExpression3RR
    //     */
    //    <RE extends EntityQueryRelateExpression3RR<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression4<E, R1, R2, R3, E>,
    //            QR extends EntityQueryRelatedFetchedExpression3RRF<E, R1, R2, R3, QRC, QRL, QRS>,
    //            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
    //            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R3>>, R3,
    //            J> RE join(SerializableFunction1<E, J> propertyName, Class<R3> joinType);
    //
    //    /**
    //     * join on.
    //     *
    //     * @param <RE>                 the generic type
    //     * @param <RC>                 the generic type
    //     * @param <RL>                 the generic type
    //     * @param <RS>                 the generic type
    //     * @param <QR>                 the generic type
    //     * @param <QRC>                the generic type
    //     * @param <QRL>                the generic type
    //     * @param <QRS>                the generic type
    //     * @param <R3>                 the generic type
    //     * @param <J>                  the generic type
    //     * @param propertyName         find type object property name
    //     * @param joinTypePropertyName the join type property name
    //     * @return EntityQueryRelateExpression3RR
    //     */
    //    <RE extends EntityQueryRelateExpression3RR<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression4<E, R1, R2, R3, E>,
    //            QR extends EntityQueryRelatedFetchedExpression3RRF<E, R1, R2, R3, QRC, QRL, QRS>,
    //            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
    //            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R3>>, R3,
    //            J> RE join(SerializableFunction1<E, J> propertyName, SerializableFunction1<R3, J> joinTypePropertyName);
    //
    //    /**
    //     * join on.
    //     *
    //     * @param <RE>                 the generic type
    //     * @param <RC>                 the generic type
    //     * @param <RL>                 the generic type
    //     * @param <RS>                 the generic type
    //     * @param <QR>                 the generic type
    //     * @param <QRC>                the generic type
    //     * @param <QRL>                the generic type
    //     * @param <QRS>                the generic type
    //     * @param <R3>                 the generic type
    //     * @param <J>                  the generic type
    //     * @param joinTypePropertyName the join type property name
    //     * @return EntityQueryRelateExpression3RR
    //     */
    //    <RE extends EntityQueryRelateExpression3RR<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression4<E, R1, R2, R3, E>,
    //            QR extends EntityQueryRelatedFetchedExpression3RRF<E, R1, R2, R3, QRC, QRL, QRS>,
    //            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
    //            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R3>>, R3,
    //            J> RE join(SerializableFunction4<R3, J> joinTypePropertyName);

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
     * @return EntityQueryRelateExpression3RR
     */
    <RE extends EntityQueryRelateExpression3RR<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, E>,
            QR extends EntityQueryRelatedFetchedExpression3RRF<E, R1, R2, R3, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R3>>,
            R3> RE join(SerializableFunction1<E, R3> propertyName);

    //    /**
    //     * relate to.
    //     *
    //     * @param <RE>         the generic type
    //     * @param <QR>         the generic type
    //     * @param <R3>         the generic type
    //     * @param propertyName find type object property name
    //     * @return EntityQueryRelateExpression3RR
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
     * @return EntityQueryRelateExpression3RR
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
    //     * @return EntityQueryRelateExpression3RR
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
     * @return EntityQueryRelateExpression3RR
     */
    <RE extends EntityQueryRelateExpression3RR<E, R1, R2, E, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, E, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, E, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression4<E, R1, R2, E, E>,
            QR extends EntityQueryRelatedFetchedExpression3RRF<E, R1, R2, E, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, E, QRC, QRL, QRS, Tuple2<E, E>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, E, QRC, QRL, QRS, Tuple2<E, E>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, E, Tuple2<E, E>>> RE join(
                    SerializableFunction3<E, E> propertyName);

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
     * @param <QRC>    the generic type
     * @param <QRL>    the generic type
     * @param <QRS>    the generic type
     * @param <R3>     the generic type
     * @param joinType the join type
     * @return EntityQueryRelateExpression3RR
     */
    <QR extends EntityQueryRelateExpression3RR<E, R1, R2, R3, RC, RL, RS, QRF, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, E>,
            QRF extends EntityQueryRelatedFetchedExpression3RRF<E, R1, R2, R3, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R3>>,
            R3> EntityQueryRelatedExpression<R1, R3, QR, QRF> join2(Class<R3> joinType);

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
    //     * @param <R3>         the generic type
    //     * @param <J>          the generic type
    //     * @param propertyName find type object property name
    //     * @param joinType     the join type
    //     * @return EntityQueryRelateExpression3RR
    //     */
    //    <RE extends EntityQueryRelateExpression3RR<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression4<E, R1, R2, R3, E>,
    //            QR extends EntityQueryRelatedFetchedExpression3RRF<E, R1, R2, R3, QRC, QRL, QRS>,
    //            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
    //            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R3>>, R3,
    //            J> RE join2(SerializableFunction1<R1, J> propertyName, Class<R3> joinType);
    //
    //    /**
    //     * join on.
    //     *
    //     * @param <RE>                 the generic type
    //     * @param <RC>                 the generic type
    //     * @param <RL>                 the generic type
    //     * @param <RS>                 the generic type
    //     * @param <QR>                 the generic type
    //     * @param <QRC>                the generic type
    //     * @param <QRL>                the generic type
    //     * @param <QRS>                the generic type
    //     * @param <R3>                 the generic type
    //     * @param <J>                  the generic type
    //     * @param propertyName         find type object property name
    //     * @param joinTypePropertyName the join type property name
    //     * @return EntityQueryRelateExpression3RR
    //     */
    //    <RE extends EntityQueryRelateExpression3RR<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression4<E, R1, R2, R3, E>,
    //            QR extends EntityQueryRelatedFetchedExpression3RRF<E, R1, R2, R3, QRC, QRL, QRS>,
    //            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
    //            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R3>>, R3,
    //            J> RE join2(SerializableFunction1<R1, J> propertyName, SerializableFunction1<R3, J> joinTypePropertyName);
    //
    //    /**
    //     * join on.
    //     *
    //     * @param <RE>                 the generic type
    //     * @param <RC>                 the generic type
    //     * @param <RL>                 the generic type
    //     * @param <RS>                 the generic type
    //     * @param <QR>                 the generic type
    //     * @param <QRC>                the generic type
    //     * @param <QRL>                the generic type
    //     * @param <QRS>                the generic type
    //     * @param <R3>                 the generic type
    //     * @param <J>                  the generic type
    //     * @param joinTypePropertyName the join type property name
    //     * @return EntityQueryRelateExpression3RR
    //     */
    //    <RE extends EntityQueryRelateExpression3RR<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression4<E, R1, R2, R3, E>,
    //            QR extends EntityQueryRelatedFetchedExpression3RRF<E, R1, R2, R3, QRC, QRL, QRS>,
    //            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
    //            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R3>>, R3,
    //            J> RE join2(SerializableFunction4<R3, J> joinTypePropertyName);

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
     * @return EntityQueryRelateExpression3RR
     */
    <RE extends EntityQueryRelateExpression3RR<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, E>,
            QR extends EntityQueryRelatedFetchedExpression3RRF<E, R1, R2, R3, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R3>>,
            R3> RE join2(SerializableFunction1<R1, R3> propertyName);

    //    /**
    //     * relate to.
    //     *
    //     * @param <RE>         the generic type
    //     * @param <QR>         the generic type
    //     * @param <R3>         the generic type
    //     * @param propertyName find type object property name
    //     * @return EntityQueryRelateExpression3RR
    //     */
    //    default <RE extends EntityQueryRelateExpression3<E, R1, R2, R3, RC,RL,RS, QR, QRC, QRL, QRS, R>,
    //            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS>,
    //            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS>,
    //            QR extends EntityQueryRelatedFetchedExpression3RRF<E, R1, R2, R3, QRC, QRL, QRS>,
    //            QRS extends EntitySortExpression4<E, R1, R2, R3, QRS>,
    //            R3> RE relate2(SerializableFunction2<R3, R1> propertyName) {
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
     * @return EntityQueryRelateExpression3RR
     */
    <RE extends EntityQueryRelateExpression3RR<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, E>,
            QR extends EntityQueryRelatedFetchedExpression3RRF<E, R1, R2, R3, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R3>>,
            R3> RE join2(SerializableFunction2<R3, R1> propertyName);

    //    /**
    //     * relate to.
    //     *
    //     * @param <RE>         the generic type
    //     * @param <QR>         the generic type
    //     * @param propertyName find type object property name
    //     * @return EntityQueryRelateExpression3RR
    //     */
    //    default <RE extends EntityQueryRelateExpression3<E, R1, R2, R1, QR, QRC, QRL, QRS, R>,
    //            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R1, QRC, QRL, QRS, R>,
    //            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R1, QRC, QRL, QRS, R>,
    //            QR extends EntityQueryRelatedFetchedExpression3<E, R1, R2, R1, QRC, QRL, QRS, R>> RE relate2(
    //                    SerializableFunction1<R1, R1> propertyName) {
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
     * @return EntityQueryRelateExpression3RR
     */
    <RE extends EntityQueryRelateExpression3RR<E, R1, R2, R1, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R1, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R1, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R1, E>,
            QR extends EntityQueryRelatedFetchedExpression3RRF<E, R1, R2, R1, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R1, QRC, QRL, QRS, Tuple2<E, R1>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R1, QRC, QRL, QRS, Tuple2<E, R1>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R1, Tuple2<E, R1>>> RE join2(
                    SerializableFunction3<R1, R1> propertyName);

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
     * @param <R3>     the generic type
     * @param joinType the join type
     * @return EntityQueryRelateExpression3RR
     */
    <QR extends EntityQueryRelateExpression3RR<E, R1, R2, R3, RC, RL, RS, QRF, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, E>,
            QRF extends EntityQueryRelatedFetchedExpression3RRF<E, R1, R2, R3, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R3>>,
            R3> EntityQueryRelatedExpression<R2, R3, QR, QRF> join3(Class<R3> joinType);

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
    //     * @param <R3>         the generic type
    //     * @param <J>          the generic type
    //     * @param propertyName find type object property name
    //     * @param joinType     the join type
    //     * @return EntityQueryRelateExpression3RR
    //     */
    //    <RE extends EntityQueryRelateExpression3RR<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression4<E, R1, R2, R3, E>,
    //            QR extends EntityQueryRelatedFetchedExpression3RRF<E, R1, R2, R3, QRC, QRL, QRS>,
    //            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
    //            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R3>>, R3,
    //            J> RE join3(SerializableFunction1<R2, J> propertyName, Class<R3> joinType);
    //
    //    /**
    //     * join on.
    //     *
    //     * @param <RE>                 the generic type
    //     * @param <RC>                 the generic type
    //     * @param <RL>                 the generic type
    //     * @param <RS>                 the generic type
    //     * @param <QR>                 the generic type
    //     * @param <QRC>                the generic type
    //     * @param <QRL>                the generic type
    //     * @param <QRS>                the generic type
    //     * @param <R3>                 the generic type
    //     * @param <J>                  the generic type
    //     * @param propertyName         find type object property name
    //     * @param joinTypePropertyName the join type property name
    //     * @return EntityQueryRelateExpression3RR
    //     */
    //    <RE extends EntityQueryRelateExpression3RR<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression4<E, R1, R2, R3, E>,
    //            QR extends EntityQueryRelatedFetchedExpression3RRF<E, R1, R2, R3, QRC, QRL, QRS>,
    //            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
    //            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R3>>, R3,
    //            J> RE join3(SerializableFunction1<R2, J> propertyName, SerializableFunction1<R3, J> joinTypePropertyName);
    //
    //    /**
    //     * join on.
    //     *
    //     * @param <RE>                 the generic type
    //     * @param <RC>                 the generic type
    //     * @param <RL>                 the generic type
    //     * @param <RS>                 the generic type
    //     * @param <QR>                 the generic type
    //     * @param <QRC>                the generic type
    //     * @param <QRL>                the generic type
    //     * @param <QRS>                the generic type
    //     * @param <R3>                 the generic type
    //     * @param <J>                  the generic type
    //     * @param joinTypePropertyName the join type property name
    //     * @return EntityQueryRelateExpression3RR
    //     */
    //    <RE extends EntityQueryRelateExpression3RR<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression4<E, R1, R2, R3, E>,
    //            QR extends EntityQueryRelatedFetchedExpression3RRF<E, R1, R2, R3, QRC, QRL, QRS>,
    //            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
    //            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R3>>, R3,
    //            J> RE join3(SerializableFunction4<R3, J> joinTypePropertyName);

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
     * @return EntityQueryRelateExpression3RR
     */
    <RE extends EntityQueryRelateExpression3RR<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, E>,
            QR extends EntityQueryRelatedFetchedExpression3RRF<E, R1, R2, R3, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R3>>,
            R3> RE join3(SerializableFunction1<R2, R3> propertyName);

    //    /**
    //     * relate to.
    //     *
    //     * @param <RE>         the generic type
    //     * @param <QR>         the generic type
    //     * @param <R3>         the generic type
    //     * @param propertyName find type object property name
    //     * @return EntityQueryRelateExpression3RR
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
     * @return EntityQueryRelateExpression3RR
     */
    <RE extends EntityQueryRelateExpression3RR<E, R1, R2, R3, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R3, E>,
            QR extends EntityQueryRelatedFetchedExpression3RRF<E, R1, R2, R3, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R3, QRC, QRL, QRS, Tuple2<E, R3>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R3, Tuple2<E, R3>>,
            R3> RE join3(SerializableFunction2<R3, R2> propertyName);

    //    /**
    //     * relate to.
    //     *
    //     * @param <RE>         the generic type
    //     * @param <QR>         the generic type
    //     * @param propertyName find type object property name
    //     * @return EntityQueryRelateExpression3RR
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
     * @return EntityQueryRelateExpression3RR
     */
    <RE extends EntityQueryRelateExpression3RR<E, R1, R2, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression4<E, R1, R2, R2, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R2, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression4<E, R1, R2, R2, E>,
            QR extends EntityQueryRelatedFetchedExpression3RRF<E, R1, R2, R2, QRC, QRL, QRS>,
            QRC extends EntityQueryConditionGroupExpression4<E, R1, R2, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
            QRL extends EntityQueryConditionGroupLogicExpression4<E, R1, R2, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
            QRS extends EntityQuerySortExpression4<E, R1, R2, R2, Tuple2<E, R2>>> RE join3(
                    SerializableFunction3<R2, R2> propertyName);

}
