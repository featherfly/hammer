
package cn.featherfly.hammer.expression.query.type;

import java.util.function.Function;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.common.lang.function.SerializableFunction1;
import cn.featherfly.common.lang.function.SerializableFunction2;
import cn.featherfly.common.lang.function.SerializableFunction3;
import cn.featherfly.common.lang.function.SerializableFunction4;
import cn.featherfly.common.lang.function.SerializableFunction5;
import cn.featherfly.common.lang.function.SerializableFunction6;
import cn.featherfly.hammer.dsl.QueryEntityRepository;
import cn.featherfly.hammer.expression.api.entity.EntityQueryRelate;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression2;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression3;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression2;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression3;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression2;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression3;

/**
 * type query relation entity expression.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 * @param <S>  the generic type
 * @param <F>  the generic type
 * @param <FC> the generic type
 * @param <FL> the generic type
 * @param <FS> the generic type
 */
public interface EntityQueryRelateExpression<E, R1, C extends EntityQueryConditionGroupExpression2<E, R1, C, L, S, E>,
        L extends EntityQueryConditionGroupLogicExpression2<E, R1, C, L, S, E>,
        S extends EntityQuerySortExpression2<E, R1, E>,
        F extends EntityQueryRelatedFetchedExpression<E, R1, FC, FL, FS>,
        FC extends EntityQueryConditionGroupExpression2<E, R1, FC, FL, FS, Tuple2<E, R1>>,
        FL extends EntityQueryConditionGroupLogicExpression2<E, R1, FC, FL, FS, Tuple2<E, R1>>,
        FS extends EntityQuerySortExpression2<E, R1, Tuple2<E, R1>>>
        extends EntityQueryExpression2<E, R1, C, L, S, E>, EntityQueryRelate<F> {

    //  /**
    //     * relate to.
    //     *
    //     * @param <RE>         the generic type
    //     * @param <QR>         the generic type
    //     * @param <R2>         the generic type
    //     * @param propertyName find type object property name
    //     * @return EntityQueryRelateExpression2R
    //     */
    //    default <RE extends EntityQueryRelateExpression2<E, R1, R2, QR, RC, RL, RS, R>,
    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS>,
    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS>,
    //            QR extends EntityQueryRelatedFetchedExpression2<E, R1, R2, RC, RL, RS>,
    //            RS extends EntitySortExpression3<E, R1, R2, RS>, R2> RE relate(SerializableFunction<E, R2> propertyName) {
    //        return join(propertyName);
    //    }

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <RC>         the generic type
     * @param <RL>         the generic type
     * @param <RS>         the generic type
     * @param <QRC>        the generic type
     * @param <QRL>        the generic type
     * @param <QRS>        the generic type
     * @param <QR>         the generic type
     * @param <R2>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelateExpression2R
     */
    <RE extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>,
            R2> RE join(SerializableFunction1<E, R2> propertyName);

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <RC>         the generic type
     * @param <RL>         the generic type
     * @param <RS>         the generic type
     * @param <QRC>        the generic type
     * @param <QRL>        the generic type
     * @param <QRS>        the generic type
     * @param <QR>         the generic type
     * @param <R2>         the generic type
     * @param <J>          the generic type
     * @param propertyName find type object property name
     * @param joinType     the join type
     * @return EntityQueryRelateExpression2R
     */
    <RE extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>, R2,
            J> RE join(SerializableFunction1<E, J> propertyName, Class<R2> joinType);

    /**
     * join on.
     *
     * @param <RE>                 the generic type
     * @param <RC>                 the generic type
     * @param <RL>                 the generic type
     * @param <RS>                 the generic type
     * @param <QRC>                the generic type
     * @param <QRL>                the generic type
     * @param <QRS>                the generic type
     * @param <QR>                 the generic type
     * @param <R2>                 the generic type
     * @param <J>                  the generic type
     * @param propertyName         find type object property name
     * @param joinTypePropertyName the join type property name
     * @return EntityQueryRelateExpression2R
     */
    <RE extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>, R2,
            J> RE join(SerializableFunction1<E, J> propertyName, SerializableFunction1<E, J> joinTypePropertyName);

    /**
     * join on.
     *
     * @param <RE>                 the generic type
     * @param <RC>                 the generic type
     * @param <RL>                 the generic type
     * @param <RS>                 the generic type
     * @param <QRC>                the generic type
     * @param <QRL>                the generic type
     * @param <QRS>                the generic type
     * @param <QR>                 the generic type
     * @param <R2>                 the generic type
     * @param <J>                  the generic type
     * @param joinTypePropertyName the join type property name
     * @return EntityQueryRelateExpression2R
     */
    <RE extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>, R2,
            J> RE join(SerializableFunction4<R2, J> joinTypePropertyName);

    //    /**
    //     * relate to.
    //     *
    //     * @param <RE>         the generic type
    //     * @param <QR>         the generic type
    //     * @param <R2>         the generic type
    //     * @param propertyName find type object property name
    //     * @return EntityQueryRelateExpression2R
    //     */
    //    default <RE extends EntityQueryRelateExpression2<E, R1, R2, QR, RC, RL, RS, R>,
    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS>,
    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS>,
    //            QR extends EntityQueryRelatedFetchedExpression2<E, R1, R2, RC, RL, RS>,
    //            RS extends EntitySortExpression3<E, R1, R2, RS>, R2> RE relate(SerializableFunction2<R2, E> propertyName) {
    //        return join(propertyName);
    //    }

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <RC>         the generic type
     * @param <RL>         the generic type
     * @param <RS>         the generic type
     * @param <QRC>        the generic type
     * @param <QRL>        the generic type
     * @param <QRS>        the generic type
     * @param <QR>         the generic type
     * @param <R2>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelateExpression2R
     */
    <RE extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>,
            R2> RE join(SerializableFunction2<R2, E> propertyName);

    //    /**
    //     * relate to.
    //     *
    //     * @param <RE>         the generic type
    //     * @param <QR>         the generic type
    //     * @param propertyName find type object property name
    //     * @return EntityQueryRelateExpression2R
    //     */
    //    default <RE extends EntityQueryRelateExpression2<E, R1, E, QR, RC, RL, RS, R>,
    //            RC extends EntityQueryConditionGroupExpression3<E, R1, E, RC, RL, RS>,
    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, E, RC, RL, RS>,
    //            QR extends EntityQueryRelatedFetchedExpression2<E, R1, E, RC, RL, RS>,
    //            RS extends EntitySortExpression3<E, R1, E, RS>> RE relate(SerializableFunction1<E, E> propertyName) {
    //        return join(propertyName);
    //    }

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <RC>         the generic type
     * @param <RL>         the generic type
     * @param <RS>         the generic type
     * @param <QRC>        the generic type
     * @param <QRL>        the generic type
     * @param <QRS>        the generic type
     * @param <QR>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelateExpression2R
     */
    <RE extends EntityQueryRelateExpression2R<E, R1, E, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, E, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, E, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression3<E, R1, E, E>,
            QRC extends EntityQueryConditionGroupExpression3<E, R1, E, QRC, QRL, QRS, Tuple2<E, E>>,
            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, E, QRC, QRL, QRS, Tuple2<E, E>>,
            QRS extends EntityQuerySortExpression3<E, R1, E, Tuple2<E, E>>,
            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, E, QRC, QRL, QRS>> RE join(
                    SerializableFunction3<E, E> propertyName);

    //    /**
    //     * relate to.
    //     *
    //     * @param <RE>         the generic type
    //     * @param <QR>         the generic type
    //     * @param <R2>         the generic type
    //     * @param propertyName find type object property name
    //     * @return EntityQueryRelateExpression2R
    //     */
    //    default <RE extends EntityQueryRelateExpression2<E, R1, R2, QR, RC, RL, RS, R>,
    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS>,
    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS>,
    //            QR extends EntityQueryRelatedFetchedExpression2<E, R1, R2, RC, RL, RS>,
    //            RS extends EntitySortExpression3<E, R1, R2, RS>, R2> RE relate2(SerializableFunction<R1, R2> propertyName) {
    //        return join2(propertyName);
    //    }

    // ********************************************************************
    //	1
    // ********************************************************************

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <RC>         the generic type
     * @param <RL>         the generic type
     * @param <RS>         the generic type
     * @param <QRC>        the generic type
     * @param <QRL>        the generic type
     * @param <QRS>        the generic type
     * @param <QR>         the generic type
     * @param <R2>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelateExpression2R
     */
    <RE extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>,
            R2> RE join2(SerializableFunction1<R1, R2> propertyName);

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <RC>         the generic type
     * @param <RL>         the generic type
     * @param <RS>         the generic type
     * @param <QRC>        the generic type
     * @param <QRL>        the generic type
     * @param <QRS>        the generic type
     * @param <QR>         the generic type
     * @param <R2>         the generic type
     * @param <J>          the generic type
     * @param propertyName find type object property name
     * @param joinType     the join type
     * @return EntityQueryRelateExpression2R
     */
    <RE extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>, R2,
            J> RE join2(SerializableFunction1<R1, J> propertyName, Class<R2> joinType);

    /**
     * join on.
     *
     * @param <RE>                 the generic type
     * @param <RC>                 the generic type
     * @param <RL>                 the generic type
     * @param <RS>                 the generic type
     * @param <QRC>                the generic type
     * @param <QRL>                the generic type
     * @param <QRS>                the generic type
     * @param <QR>                 the generic type
     * @param <R2>                 the generic type
     * @param <J>                  the generic type
     * @param propertyName         find type object property name
     * @param joinTypePropertyName the join type property name
     * @return EntityQueryRelateExpression2R
     */
    <RE extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>, R2,
            J> RE join2(SerializableFunction1<R1, J> propertyName, SerializableFunction1<E, J> joinTypePropertyName);

    /**
     * join on.
     *
     * @param <RE>                 the generic type
     * @param <RC>                 the generic type
     * @param <RL>                 the generic type
     * @param <RS>                 the generic type
     * @param <QRC>                the generic type
     * @param <QRL>                the generic type
     * @param <QRS>                the generic type
     * @param <QR>                 the generic type
     * @param <R2>                 the generic type
     * @param <J>                  the generic type
     * @param joinTypePropertyName the join type property name
     * @return EntityQueryRelateExpression2R
     */
    <RE extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>, R2,
            J> RE join2(SerializableFunction4<R2, J> joinTypePropertyName);

    //    /**
    //     * relate to.
    //     *
    //     * @param <RE>         the generic type
    //     * @param <QR>         the generic type
    //     * @param <R2>         the generic type
    //     * @param propertyName find type object property name
    //     * @return EntityQueryRelateExpression2R
    //     */
    //    default <RE extends EntityQueryRelateExpression2<E, R1, R2, QR, RC, RL, RS, R>,
    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS>,
    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS>,
    //            QR extends EntityQueryRelatedFetchedExpression2<E, R1, R2, RC, RL, RS>,
    //            RS extends EntitySortExpression3<E, R1, R2, RS>,
    //            R2> RE relate2(SerializableFunction2<R2, R1> propertyName) {
    //        return join2(propertyName);
    //    }

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <RC>         the generic type
     * @param <RL>         the generic type
     * @param <RS>         the generic type
     * @param <QRC>        the generic type
     * @param <QRL>        the generic type
     * @param <QRS>        the generic type
     * @param <QR>         the generic type
     * @param <R2>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelateExpression2R
     */
    <RE extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>,
            R2> RE join2(SerializableFunction2<R2, R1> propertyName);

    //    /**
    //     * relate to.
    //     *
    //     * @param <RE>         the generic type
    //     * @param <QR>         the generic type
    //     * @param propertyName find type object property name
    //     * @return EntityQueryRelateExpression2R
    //     */
    //    default <RE extends EntityQueryRelationEntityExpression2<E, R1, R1, QR, RC, RL, RS, R>,
    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R1, RC, RL, RS, R>,
    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R1, RC, RL, RS, R>,
    //            QR extends EntityQueryRelatedFetchedExpression2<E, R1, R1, RC, RL, RS, R>> RE relate2(
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
     * @param <QRC>        the generic type
     * @param <QRL>        the generic type
     * @param <QRS>        the generic type
     * @param <QR>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelateExpression2R
     */
    <RE extends EntityQueryRelateExpression2R<E, R1, R1, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R1, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R1, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression3<E, R1, R1, E>,
            QRC extends EntityQueryConditionGroupExpression3<E, R1, R1, QRC, QRL, QRS, Tuple2<E, R1>>,
            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R1, QRC, QRL, QRS, Tuple2<E, R1>>,
            QRS extends EntityQuerySortExpression3<E, R1, R1, Tuple2<E, R1>>,
            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R1, QRC, QRL, QRS>> RE join2(
                    SerializableFunction3<R1, R1> propertyName);

    // ********************************************************************
    // select with tuple
    // ********************************************************************

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <RC>         the generic type
     * @param <RL>         the generic type
     * @param <RS>         the generic type
     * @param <QRC>        the generic type
     * @param <QRL>        the generic type
     * @param <QRS>        the generic type
     * @param <QR>         the generic type
     * @param <R2>         the generic type
     * @param entities     the entities
     * @param propertyName find type object property name
     * @return EntityQueryRelateExpression2R
     */
    <RE extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>, R2> RE join(Function<
                    Tuple2<QueryEntityRepository<E>, QueryEntityRepository<R1>>, QueryEntityRepository<E>> entities,
                    SerializableFunction1<E, R2> propertyName);

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <RC>         the generic type
     * @param <RL>         the generic type
     * @param <RS>         the generic type
     * @param <QRC>        the generic type
     * @param <QRL>        the generic type
     * @param <QRS>        the generic type
     * @param <QR>         the generic type
     * @param <R2>         the generic type
     * @param entities     the entities
     * @param propertyName find type object property name
     * @return EntityQueryRelateExpression2R
     */
    <RE extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>, R2> RE join(Function<
                    Tuple2<QueryEntityRepository<E>, QueryEntityRepository<R1>>, QueryEntityRepository<E>> entities,
                    SerializableFunction2<R2, E> propertyName);

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <RC>         the generic type
     * @param <RL>         the generic type
     * @param <RS>         the generic type
     * @param <QRC>        the generic type
     * @param <QRL>        the generic type
     * @param <QRS>        the generic type
     * @param <QR>         the generic type
     * @param entities     the entities
     * @param propertyName find type object property name
     * @return EntityQueryRelateExpression2R
     */
    <RE extends EntityQueryRelateExpression2R<E, R1, E, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, E, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, E, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression3<E, R1, E, E>,
            QRC extends EntityQueryConditionGroupExpression3<E, R1, E, QRC, QRL, QRS, Tuple2<E, E>>,
            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, E, QRC, QRL, QRS, Tuple2<E, E>>,
            QRS extends EntityQuerySortExpression3<E, R1, E, Tuple2<E, E>>,
            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, E, QRC, QRL, QRS>> RE join(Function<
                    Tuple2<QueryEntityRepository<E>, QueryEntityRepository<R1>>, QueryEntityRepository<E>> entities,
                    SerializableFunction3<E, E> propertyName);

    // ********************************************************************
    //	select with tuple 1
    // ********************************************************************

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <RC>         the generic type
     * @param <RL>         the generic type
     * @param <RS>         the generic type
     * @param <QRC>        the generic type
     * @param <QRL>        the generic type
     * @param <QRS>        the generic type
     * @param <QR>         the generic type
     * @param <R2>         the generic type
     * @param entities     the entities
     * @param propertyName find type object property name
     * @return EntityQueryRelateExpression2R
     */
    <RE extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>, R2> RE join(Function<
                    Tuple2<QueryEntityRepository<E>, QueryEntityRepository<R1>>, QueryEntityRepository<R1>> entities,
                    SerializableFunction4<R1, R2> propertyName);

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <RC>         the generic type
     * @param <RL>         the generic type
     * @param <RS>         the generic type
     * @param <QRC>        the generic type
     * @param <QRL>        the generic type
     * @param <QRS>        the generic type
     * @param <QR>         the generic type
     * @param <R2>         the generic type
     * @param entities     the entities
     * @param propertyName find type object property name
     * @return EntityQueryRelateExpression2R
     */
    <RE extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>, R2> RE join(Function<
                    Tuple2<QueryEntityRepository<E>, QueryEntityRepository<R1>>, QueryEntityRepository<R1>> entities,
                    SerializableFunction5<R2, R1> propertyName);

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <RC>         the generic type
     * @param <RL>         the generic type
     * @param <RS>         the generic type
     * @param <QRC>        the generic type
     * @param <QRL>        the generic type
     * @param <QRS>        the generic type
     * @param <QR>         the generic type
     * @param entities     the entities
     * @param propertyName find type object property name
     * @return EntityQueryRelateExpression2R
     */
    <RE extends EntityQueryRelateExpression2R<E, R1, R1, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R1, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R1, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression3<E, R1, R1, E>,
            QRC extends EntityQueryConditionGroupExpression3<E, R1, R1, QRC, QRL, QRS, Tuple2<E, R1>>,
            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R1, QRC, QRL, QRS, Tuple2<E, R1>>,
            QRS extends EntityQuerySortExpression3<E, R1, R1, Tuple2<E, R1>>,
            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R1, QRC, QRL, QRS>> RE join(Function<
                    Tuple2<QueryEntityRepository<E>, QueryEntityRepository<R1>>, QueryEntityRepository<R1>> entities,
                    SerializableFunction6<R1, R1> propertyName);

}
