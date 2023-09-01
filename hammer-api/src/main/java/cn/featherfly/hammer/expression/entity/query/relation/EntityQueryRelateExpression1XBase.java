
package cn.featherfly.hammer.expression.entity.query.relation;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.common.function.serializable.SerializableFunction1;
import cn.featherfly.common.function.serializable.SerializableFunction2;
import cn.featherfly.common.function.serializable.SerializableUnaryOperator1;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression2;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression3;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression2;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression3;
import cn.featherfly.hammer.expression.entity.query.EntityQueryExpression2;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression2;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression3;

/**
 * The Interface EntityQueryRelateExpression1XBase.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 * @param <S>  the generic type
 */
public interface EntityQueryRelateExpression1XBase<E, R1,
        C extends EntityQueryConditionGroupExpression2<E, R1, C, L, S, E>,
        L extends EntityQueryConditionGroupLogicExpression2<E, R1, C, L, S, E>,
        S extends EntityQuerySortExpression2<E, R1, E>> extends EntityQueryExpression2<E, R1, C, L, S, E> {

    /**
     * Join.
     *
     * @param <QR>     the generic type
     * @param <RC>     the generic type
     * @param <RL>     the generic type
     * @param <RS>     the generic type
     * @param <QRC>    the generic type
     * @param <QRL>    the generic type
     * @param <QRS>    the generic type
     * @param <QRF>    the generic type
     * @param <R2>     the generic type
     * @param joinType the join type
     * @return the entity query related expression
     */
    <QR extends EntityQueryRelateExpression2RR<E, R1, R2, RC, RL, RS, QRF, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
            QRF extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>,
            R2> EntityQueryRelatedExpression<E, R2, QR, QRF> join(Class<R2> joinType);

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <RC>         the generic type
     * @param <RL>         the generic type
     * @param <RS>         the generic type
     * @param <QR>         the generic type
     * @param <FC>         the generic type
     * @param <FL>         the generic type
     * @param <FS>         the generic type
     * @param <R2>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelateExpression2P
     */
    <RE extends EntityQueryRelateExpression2RR<E, R1, R2, RC, RL, RS, QR, FC, FL, FS>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, FC, FL, FS>,
            FC extends EntityQueryConditionGroupExpression3<E, R1, R2, FC, FL, FS, Tuple2<E, R2>>,
            FL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, FC, FL, FS, Tuple2<E, R2>>,
            FS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
            R2> RE join(SerializableFunction2<R2, E> propertyName);

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <RC>         the generic type
     * @param <RL>         the generic type
     * @param <RS>         the generic type
     * @param <QR>         the generic type
     * @param <R2>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelateExpression2P
     */
    <RE extends EntityQueryRelateExpression2RP<E, R1, R2, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
            QR extends EntityQueryRelatedFetchedExpression2RP<E, R1, R2, RC, RL, RS>,
            R2> RE join(SerializableFunction1<E, R2> propertyName);

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <RC>         the generic type
     * @param <RL>         the generic type
     * @param <RS>         the generic type
     * @param <QR>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelateExpression2P
     */
    <RE extends EntityQueryRelateExpression2RP<E, R1, E, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, E, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, E, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression3<E, R1, E, E>,
            QR extends EntityQueryRelatedFetchedExpression2RP<E, R1, E, RC, RL, RS>> RE join(
                    SerializableUnaryOperator1<E> propertyName);

    // ********************************************************************
    //	join 2
    // ********************************************************************

    /**
     * Join.
     *
     * @param <QR>     the generic type
     * @param <RC>     the generic type
     * @param <RL>     the generic type
     * @param <RS>     the generic type
     * @param <QRC>    the generic type
     * @param <QRL>    the generic type
     * @param <QRS>    the generic type
     * @param <QRF>    the generic type
     * @param <R2>     the generic type
     * @param joinType the join type
     * @return the entity query related expression
     */
    <QR extends EntityQueryRelateExpression2RR<E, R1, R2, RC, RL, RS, QRF, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
            QRF extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>,
            R2> EntityQueryRelatedExpression<R1, R2, QR, QRF> join2(Class<R2> joinType);

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <RC>         the generic type
     * @param <RL>         the generic type
     * @param <RS>         the generic type
     * @param <QR>         the generic type
     * @param <FC>         the generic type
     * @param <FL>         the generic type
     * @param <FS>         the generic type
     * @param <R2>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelateExpression2P
     */
    <RE extends EntityQueryRelateExpression2RR<E, R1, R2, RC, RL, RS, QR, FC, FL, FS>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, FC, FL, FS>,
            FC extends EntityQueryConditionGroupExpression3<E, R1, R2, FC, FL, FS, Tuple2<E, R2>>,
            FL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, FC, FL, FS, Tuple2<E, R2>>,
            FS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
            R2> RE join2(SerializableFunction2<R2, R1> propertyName);

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <RC>         the generic type
     * @param <RL>         the generic type
     * @param <RS>         the generic type
     * @param <QR>         the generic type
     * @param <R2>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelateExpression2P
     */
    <RE extends EntityQueryRelateExpression2RP<E, R1, R2, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
            QR extends EntityQueryRelatedFetchedExpression2RP<E, R1, R2, RC, RL, RS>,
            R2> RE join2(SerializableFunction1<R1, R2> propertyName);

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <RC>         the generic type
     * @param <RL>         the generic type
     * @param <RS>         the generic type
     * @param <QR>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelateExpression2P
     */
    <RE extends EntityQueryRelateExpression2RP<E, R1, R1, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R1, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R1, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression3<E, R1, R1, E>,
            QR extends EntityQueryRelatedFetchedExpression2RP<E, R1, R1, RC, RL, RS>> RE join2(
                    SerializableUnaryOperator1<R1> propertyName);

    // ********************************************************************
    // select with tuple
    // ********************************************************************

    //    /**
    //     * join on.
    //     *
    //     * @param <RE>         the generic type
    //     * @param <RC>         the generic type
    //     * @param <RL>         the generic type
    //     * @param <RS>         the generic type
    //     * @param <QR>         the generic type
    //     * @param <R2>         the generic type
    //     * @param entities     the entities
    //     * @param propertyName find type object property name
    //     * @return EntityQueryRelateExpression2P
    //     */
    //    <RE extends EntityQueryRelateExpression2P<E, R1, R2, RC, RL, RS, QR>,
    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
    //            QR extends EntityQueryRelatedFetchedExpression2RP<E, R1, R2, RC, RL, RS>, R2> RE join(Function<
    //                    Tuple2<QueryEntityRepository<E>, QueryEntityRepository<R1>>, QueryEntityRepository<E>> entities,
    //                    SerializableFunction1<E, R2> propertyName);
    //
    //    /**
    //     * join on.
    //     *
    //     * @param <RE>         the generic type
    //     * @param <RC>         the generic type
    //     * @param <RL>         the generic type
    //     * @param <RS>         the generic type
    //     * @param <QR>         the generic type
    //     * @param <R2>         the generic type
    //     * @param entities     the entities
    //     * @param propertyName find type object property name
    //     * @return EntityQueryRelateExpression2P
    //     */
    //    <RE extends EntityQueryRelateExpression2P<E, R1, R2, RC, RL, RS, QR>,
    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
    //            QR extends EntityQueryRelatedFetchedExpression2RP<E, R1, R2, RC, RL, RS>, R2> RE join(Function<
    //                    Tuple2<QueryEntityRepository<E>, QueryEntityRepository<R1>>, QueryEntityRepository<E>> entities,
    //                    SerializableFunction2<R2, E> propertyName);
    //
    //    /**
    //     * join on.
    //     *
    //     * @param <RE>         the generic type
    //     * @param <RC>         the generic type
    //     * @param <RL>         the generic type
    //     * @param <RS>         the generic type
    //     * @param <QR>         the generic type
    //     * @param entities     the entities
    //     * @param propertyName find type object property name
    //     * @return EntityQueryRelateExpression2P
    //     */
    //    <RE extends EntityQueryRelateExpression2P<E, R1, E, RC, RL, RS, QR>,
    //            RC extends EntityQueryConditionGroupExpression3<E, R1, E, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, E, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression3<E, R1, E, E>,
    //            QR extends EntityQueryRelatedFetchedExpression2RP<E, R1, E, RC, RL, RS>> RE join(Function<
    //                    Tuple2<QueryEntityRepository<E>, QueryEntityRepository<R1>>, QueryEntityRepository<E>> entities,
    //                    SerializableUnaryOperator1<E> propertyName);
    //
    //    // ********************************************************************
    //    //	select with tuple 1
    //    // ********************************************************************
    //
    //    /**
    //     * join on.
    //     *
    //     * @param <RE>         the generic type
    //     * @param <RC>         the generic type
    //     * @param <RL>         the generic type
    //     * @param <RS>         the generic type
    //     * @param <QR>         the generic type
    //     * @param <R2>         the generic type
    //     * @param entities     the entities
    //     * @param propertyName find type object property name
    //     * @return EntityQueryRelateExpression2P
    //     */
    //    <RE extends EntityQueryRelateExpression2P<E, R1, R2, RC, RL, RS, QR>,
    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
    //            QR extends EntityQueryRelatedFetchedExpression2RP<E, R1, R2, RC, RL, RS>, R2> RE join(Function<
    //                    Tuple2<QueryEntityRepository<E>, QueryEntityRepository<R1>>, QueryEntityRepository<R1>> entities,
    //                    SerializableFunction4<R1, R2> propertyName);
    //
    //    /**
    //     * join on.
    //     *
    //     * @param <RE>         the generic type
    //     * @param <RC>         the generic type
    //     * @param <RL>         the generic type
    //     * @param <RS>         the generic type
    //     * @param <QR>         the generic type
    //     * @param <R2>         the generic type
    //     * @param entities     the entities
    //     * @param propertyName find type object property name
    //     * @return EntityQueryRelateExpression2P
    //     */
    //    <RE extends EntityQueryRelateExpression2P<E, R1, R2, RC, RL, RS, QR>,
    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
    //            QR extends EntityQueryRelatedFetchedExpression2RP<E, R1, R2, RC, RL, RS>, R2> RE join(Function<
    //                    Tuple2<QueryEntityRepository<E>, QueryEntityRepository<R1>>, QueryEntityRepository<R1>> entities,
    //                    SerializableFunction5<R2, R1> propertyName);
    //
    //    /**
    //     * join on.
    //     *
    //     * @param <RE>         the generic type
    //     * @param <RC>         the generic type
    //     * @param <RL>         the generic type
    //     * @param <RS>         the generic type
    //     * @param <QR>         the generic type
    //     * @param entities     the entities
    //     * @param propertyName find type object property name
    //     * @return EntityQueryRelateExpression2P
    //     */
    //    <RE extends EntityQueryRelateExpression2P<E, R1, R1, RC, RL, RS, QR>,
    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R1, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R1, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression3<E, R1, R1, E>,
    //            QR extends EntityQueryRelatedFetchedExpression2RP<E, R1, R1, RC, RL, RS>> RE join(Function<
    //                    Tuple2<QueryEntityRepository<E>, QueryEntityRepository<R1>>, QueryEntityRepository<R1>> entities,
    //                    SerializableFunction6<R1, R1> propertyName);

}
