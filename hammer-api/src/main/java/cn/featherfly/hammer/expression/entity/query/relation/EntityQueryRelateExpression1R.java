
package cn.featherfly.hammer.expression.entity.query.relation;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.hammer.expression.api.entity.QueryRelate;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression2;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression2;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression2;

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
public interface EntityQueryRelateExpression1R<E, R1, C extends EntityQueryConditionGroupExpression2<E, R1, C, L, S, E>,
        L extends EntityQueryConditionGroupLogicExpression2<E, R1, C, L, S, E>,
        S extends EntityQuerySortExpression2<E, R1, E>,
        F extends EntityQueryRelatedFetchedExpression1F<E, R1, FC, FL, FS>,
        FC extends EntityQueryConditionGroupExpression2<E, R1, FC, FL, FS, Tuple2<E, R1>>,
        FL extends EntityQueryConditionGroupLogicExpression2<E, R1, FC, FL, FS, Tuple2<E, R1>>,
        FS extends EntityQuerySortExpression2<E, R1, Tuple2<E, R1>>>
        extends EntityQueryRelateExpression1XBase<E, R1, C, L, S>, QueryRelate<F> {

    //    /**
    //     * join on.
    //     *
    //     * @param <RE>         the generic type
    //     * @param <RC>         the generic type
    //     * @param <RL>         the generic type
    //     * @param <RS>         the generic type
    //     * @param <QRC>        the generic type
    //     * @param <QRL>        the generic type
    //     * @param <QRS>        the generic type
    //     * @param <QR>         the generic type
    //     * @param <R2>         the generic type
    //     * @param entities     the entities
    //     * @param propertyName find type object property name
    //     * @return EntityQueryRelateExpression2R
    //     */
    //    <RE extends EntityQueryRelateExpression2RR<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
    //            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
    //            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>, R2> RE join(
    //                    BiFunction<QueryEntityRepository<E>, QueryEntityRepository<R1>, QueryEntityRepository<E>> entities,
    //                    SerializableFunction1<E, R2> propertyName);
    //
    //    //    /**
    //    //     * join on.
    //    //     *
    //    //     * @param <RE>         the generic type
    //    //     * @param <RC>         the generic type
    //    //     * @param <RL>         the generic type
    //    //     * @param <RS>         the generic type
    //    //     * @param <QRC>        the generic type
    //    //     * @param <QRL>        the generic type
    //    //     * @param <QRS>        the generic type
    //    //     * @param <QR>         the generic type
    //    //     * @param <R2>         the generic type
    //    //     * @param entities     the entities
    //    //     * @param propertyName find type object property name
    //    //     * @return EntityQueryRelateExpression2R
    //    //     */
    //    //    <RE extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
    //    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
    //    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
    //    //            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
    //    //            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //    //            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //    //            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
    //    //            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>, R2> RE join(Function<
    //    //                    Tuple2<QueryEntityRepository<E>, QueryEntityRepository<R1>>, QueryEntityRepository<E>> entities,
    //    //                    SerializableFunction1<E, R2> propertyName);
    //
    //    /**
    //     * join on.
    //     *
    //     * @param <RE>         the generic type
    //     * @param <RC>         the generic type
    //     * @param <RL>         the generic type
    //     * @param <RS>         the generic type
    //     * @param <QRC>        the generic type
    //     * @param <QRL>        the generic type
    //     * @param <QRS>        the generic type
    //     * @param <QR>         the generic type
    //     * @param <R2>         the generic type
    //     * @param entities     the entities
    //     * @param propertyName find type object property name
    //     * @return EntityQueryRelateExpression2R
    //     */
    //    <RE extends EntityQueryRelateExpression2RR<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
    //            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
    //            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>, R2> RE join(
    //                    BiFunction<QueryEntityRepository<E>, QueryEntityRepository<R1>, QueryEntityRepository<E>> entities,
    //                    SerializableFunction2<R2, E> propertyName);
    //
    //    //    /**
    //    //     * join on.
    //    //     *
    //    //     * @param <RE>         the generic type
    //    //     * @param <RC>         the generic type
    //    //     * @param <RL>         the generic type
    //    //     * @param <RS>         the generic type
    //    //     * @param <QRC>        the generic type
    //    //     * @param <QRL>        the generic type
    //    //     * @param <QRS>        the generic type
    //    //     * @param <QR>         the generic type
    //    //     * @param <R2>         the generic type
    //    //     * @param entities     the entities
    //    //     * @param propertyName find type object property name
    //    //     * @return EntityQueryRelateExpression2R
    //    //     */
    //    //    <RE extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
    //    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
    //    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
    //    //            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
    //    //            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //    //            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //    //            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
    //    //            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>, R2> RE join(Function<
    //    //                    Tuple2<QueryEntityRepository<E>, QueryEntityRepository<R1>>, QueryEntityRepository<E>> entities,
    //    //                    SerializableFunction2<R2, E> propertyName);
    //
    //    /**
    //     * join on.
    //     *
    //     * @param <RE>         the generic type
    //     * @param <RC>         the generic type
    //     * @param <RL>         the generic type
    //     * @param <RS>         the generic type
    //     * @param <QRC>        the generic type
    //     * @param <QRL>        the generic type
    //     * @param <QRS>        the generic type
    //     * @param <QR>         the generic type
    //     * @param entities     the entities
    //     * @param propertyName find type object property name
    //     * @return EntityQueryRelateExpression2R
    //     */
    //    <RE extends EntityQueryRelateExpression2RR<E, R1, E, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression3<E, R1, E, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, E, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression3<E, R1, E, E>,
    //            QRC extends EntityQueryConditionGroupExpression3<E, R1, E, QRC, QRL, QRS, Tuple2<E, E>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, E, QRC, QRL, QRS, Tuple2<E, E>>,
    //            QRS extends EntityQuerySortExpression3<E, R1, E, Tuple2<E, E>>,
    //            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, E, QRC, QRL, QRS>> RE join(
    //                    BiFunction<QueryEntityRepository<E>, QueryEntityRepository<R1>, QueryEntityRepository<E>> entities,
    //                    SerializableUnaryOperator1<E> propertyName);
    //
    //    //    /**
    //    //     * join on.
    //    //     *
    //    //     * @param <RE>         the generic type
    //    //     * @param <RC>         the generic type
    //    //     * @param <RL>         the generic type
    //    //     * @param <RS>         the generic type
    //    //     * @param <QRC>        the generic type
    //    //     * @param <QRL>        the generic type
    //    //     * @param <QRS>        the generic type
    //    //     * @param <QR>         the generic type
    //    //     * @param entities     the entities
    //    //     * @param propertyName find type object property name
    //    //     * @return EntityQueryRelateExpression2R
    //    //     */
    //    //    <RE extends EntityQueryRelateExpression2R<E, R1, E, RC, RL, RS, QR, QRC, QRL, QRS>,
    //    //            RC extends EntityQueryConditionGroupExpression3<E, R1, E, RC, RL, RS, E>,
    //    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, E, RC, RL, RS, E>,
    //    //            RS extends EntityQuerySortExpression3<E, R1, E, E>,
    //    //            QRC extends EntityQueryConditionGroupExpression3<E, R1, E, QRC, QRL, QRS, Tuple2<E, E>>,
    //    //            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, E, QRC, QRL, QRS, Tuple2<E, E>>,
    //    //            QRS extends EntityQuerySortExpression3<E, R1, E, Tuple2<E, E>>,
    //    //            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, E, QRC, QRL, QRS>> RE join(Function<
    //    //                    Tuple2<QueryEntityRepository<E>, QueryEntityRepository<R1>>, QueryEntityRepository<E>> entities,
    //    //                    SerializableUnaryOperator1<E> propertyName);
    //
    //    // ********************************************************************
    //    //	select with tuple 1
    //    // ********************************************************************
    //
    //    //    /**
    //    //     * join on.
    //    //     *
    //    //     * @param <RE>         the generic type
    //    //     * @param <RC>         the generic type
    //    //     * @param <RL>         the generic type
    //    //     * @param <RS>         the generic type
    //    //     * @param <QRC>        the generic type
    //    //     * @param <QRL>        the generic type
    //    //     * @param <QRS>        the generic type
    //    //     * @param <QR>         the generic type
    //    //     * @param <J>          the generic type
    //    //     * @param <R2>         the generic type
    //    //     * @param entities     the entities
    //    //     * @param propertyName find type object property name
    //    //     * @param joinType     the join type
    //    //     * @return EntityQueryRelateExpression2R
    //    //     */
    //    //    <RE extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
    //    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
    //    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
    //    //            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
    //    //            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //    //            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //    //            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
    //    //            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>, J, R2> RE join(
    //    //                    BiFunction<QueryEntityRepository<E>, QueryEntityRepository<R1>, QueryEntityRepository<R1>> entities,
    //    //                    SerializableFunction2<R1, J> propertyName, Class<R2> joinType);
    //
    //    //    /**
    //    //     * join on.
    //    //     *
    //    //     * @param <RE>         the generic type
    //    //     * @param <RC>         the generic type
    //    //     * @param <RL>         the generic type
    //    //     * @param <RS>         the generic type
    //    //     * @param <QRC>        the generic type
    //    //     * @param <QRL>        the generic type
    //    //     * @param <QRS>        the generic type
    //    //     * @param <QR>         the generic type
    //    //     * @param <J>          the generic type
    //    //     * @param <R2>         the generic type
    //    //     * @param entities     the entities
    //    //     * @param propertyName find type object property name
    //    //     * @param joinType     the join type
    //    //     * @return EntityQueryRelateExpression2R
    //    //     */
    //    //    <RE extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
    //    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
    //    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
    //    //            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
    //    //            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //    //            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //    //            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
    //    //            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>, J, R2> RE join(
    //    //                    Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<R1>>,
    //    //                            QueryEntityRepository<R1>> entities,
    //    //                    SerializableFunction2<R1, J> propertyName, Class<R2> joinType);
    //
    //    //    /**
    //    //     * join on.
    //    //     *
    //    //     * @param <RE>                 the generic type
    //    //     * @param <RC>                 the generic type
    //    //     * @param <RL>                 the generic type
    //    //     * @param <RS>                 the generic type
    //    //     * @param <QRC>                the generic type
    //    //     * @param <QRL>                the generic type
    //    //     * @param <QRS>                the generic type
    //    //     * @param <QR>                 the generic type
    //    //     * @param <J>                  the generic type
    //    //     * @param <R2>                 the generic type
    //    //     * @param entities             the entities
    //    //     * @param propertyName         find type object property name
    //    //     * @param joinTypePropertyName the join type property name
    //    //     * @return EntityQueryRelateExpression2R
    //    //     */
    //    //    <RE extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
    //    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
    //    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
    //    //            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
    //    //            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //    //            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //    //            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
    //    //            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>, J extends Number, R2> RE join(
    //    //                    BiFunction<QueryEntityRepository<E>, QueryEntityRepository<R1>, QueryEntityRepository<R1>> entities,
    //    //                    SerializableToNumberFunction2<R1, J> propertyName,
    //    //                    SerializableToNumberFunction2<R2, J> joinTypePropertyName);
    //    //
    //    //    /**
    //    //     * join on.
    //    //     *
    //    //     * @param <RE>                 the generic type
    //    //     * @param <RC>                 the generic type
    //    //     * @param <RL>                 the generic type
    //    //     * @param <RS>                 the generic type
    //    //     * @param <QRC>                the generic type
    //    //     * @param <QRL>                the generic type
    //    //     * @param <QRS>                the generic type
    //    //     * @param <QR>                 the generic type
    //    //     * @param <J>                  the generic type
    //    //     * @param <R2>                 the generic type
    //    //     * @param entities             the entities
    //    //     * @param propertyName         find type object property name
    //    //     * @param joinTypePropertyName the join type property name
    //    //     * @return EntityQueryRelateExpression2R
    //    //     */
    //    //    <RE extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
    //    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
    //    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
    //    //            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
    //    //            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //    //            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //    //            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
    //    //            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>, R2> RE join(
    //    //                    BiFunction<QueryEntityRepository<E>, QueryEntityRepository<R1>, QueryEntityRepository<R1>> entities,
    //    //                    SerializableToStringFunction2<R1> propertyName,
    //    //                    SerializableToStringFunction2<R2> joinTypePropertyName);
    //
    //    //    /**
    //    //     * join on.
    //    //     *
    //    //     * @param <RE>                 the generic type
    //    //     * @param <RC>                 the generic type
    //    //     * @param <RL>                 the generic type
    //    //     * @param <RS>                 the generic type
    //    //     * @param <QRC>                the generic type
    //    //     * @param <QRL>                the generic type
    //    //     * @param <QRS>                the generic type
    //    //     * @param <QR>                 the generic type
    //    //     * @param <J>                  the generic type
    //    //     * @param <R2>                 the generic type
    //    //     * @param entities             the entities
    //    //     * @param propertyName         find type object property name
    //    //     * @param joinTypePropertyName the join type property name
    //    //     * @return EntityQueryRelateExpression2R
    //    //     */
    //    //    <RE extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
    //    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
    //    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
    //    //            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
    //    //            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //    //            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //    //            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
    //    //            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>, J extends Number, R2> RE join(
    //    //                    Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<R1>>,
    //    //                            QueryEntityRepository<R1>> entities,
    //    //                    SerializableToNumberFunction2<R1, J> propertyName,
    //    //                    SerializableToNumberFunction2<R2, J> joinTypePropertyName);
    //
    //    //    /**
    //    //     * join on.
    //    //     *
    //    //     * @param <RE>                 the generic type
    //    //     * @param <RC>                 the generic type
    //    //     * @param <RL>                 the generic type
    //    //     * @param <RS>                 the generic type
    //    //     * @param <QRC>                the generic type
    //    //     * @param <QRL>                the generic type
    //    //     * @param <QRS>                the generic type
    //    //     * @param <QR>                 the generic type
    //    //     * @param <J>                  the generic type
    //    //     * @param <R2>                 the generic type
    //    //     * @param entities             the entities
    //    //     * @param propertyName         find type object property name
    //    //     * @param joinTypePropertyName the join type property name
    //    //     * @return EntityQueryRelateExpression2R
    //    //     */
    //    //    <RE extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
    //    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
    //    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
    //    //            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
    //    //            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //    //            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //    //            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
    //    //            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>, R2> RE join(
    //    //                    Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<R1>>,
    //    //                            QueryEntityRepository<R1>> entities,
    //    //                    SerializableToStringFunction2<R1> propertyName,
    //    //                    SerializableToStringFunction2<R2> joinTypePropertyName);
    //
    //    //    /**
    //    //     * join on.
    //    //     *
    //    //     * @param <RE>                 the generic type
    //    //     * @param <RC>                 the generic type
    //    //     * @param <RL>                 the generic type
    //    //     * @param <RS>                 the generic type
    //    //     * @param <QRC>                the generic type
    //    //     * @param <QRL>                the generic type
    //    //     * @param <QRS>                the generic type
    //    //     * @param <QR>                 the generic type
    //    //     * @param <J>                  the generic type
    //    //     * @param <R2>                 the generic type
    //    //     * @param entities             the entities
    //    //     * @param joinTypePropertyName the join type property name
    //    //     * @return EntityQueryRelateExpression2R
    //    //     */
    //    //    <RE extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
    //    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
    //    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
    //    //            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
    //    //            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //    //            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //    //            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
    //    //            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>, J extends Number, R2> RE join(
    //    //                    BiFunction<QueryEntityRepository<E>, QueryEntityRepository<R1>, QueryEntityRepository<R1>> entities,
    //    //                    SerializableToNumberFunction2<R2, J> joinTypePropertyName);
    //    //
    //    //    /**
    //    //     * join on.
    //    //     *
    //    //     * @param <RE>                 the generic type
    //    //     * @param <RC>                 the generic type
    //    //     * @param <RL>                 the generic type
    //    //     * @param <RS>                 the generic type
    //    //     * @param <QRC>                the generic type
    //    //     * @param <QRL>                the generic type
    //    //     * @param <QRS>                the generic type
    //    //     * @param <QR>                 the generic type
    //    //     * @param <J>                  the generic type
    //    //     * @param <R2>                 the generic type
    //    //     * @param entities             the entities
    //    //     * @param joinTypePropertyName the join type property name
    //    //     * @return EntityQueryRelateExpression2R
    //    //     */
    //    //    <RE extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
    //    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
    //    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
    //    //            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
    //    //            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //    //            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //    //            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
    //    //            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>, R2> RE join(
    //    //                    BiFunction<QueryEntityRepository<E>, QueryEntityRepository<R1>, QueryEntityRepository<R1>> entities,
    //    //                    SerializableToStringFunction2<R2> joinTypePropertyName);
    //
    //    //    /**
    //    //     * join on.
    //    //     *
    //    //     * @param <RE>                 the generic type
    //    //     * @param <RC>                 the generic type
    //    //     * @param <RL>                 the generic type
    //    //     * @param <RS>                 the generic type
    //    //     * @param <QRC>                the generic type
    //    //     * @param <QRL>                the generic type
    //    //     * @param <QRS>                the generic type
    //    //     * @param <QR>                 the generic type
    //    //     * @param <J>                  the generic type
    //    //     * @param <R2>                 the generic type
    //    //     * @param entities             the entities
    //    //     * @param joinTypePropertyName the join type property name
    //    //     * @return EntityQueryRelateExpression2R
    //    //     */
    //    //    <RE extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
    //    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
    //    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
    //    //            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
    //    //            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //    //            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //    //            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
    //    //            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>, J extends Number, R2> RE join(
    //    //                    Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<R1>>,
    //    //                            QueryEntityRepository<R1>> entities,
    //    //                    SerializableToNumberFunction2<R2, J> joinTypePropertyName);
    //
    //    //    /**
    //    //     * join on.
    //    //     *
    //    //     * @param <RE>                 the generic type
    //    //     * @param <RC>                 the generic type
    //    //     * @param <RL>                 the generic type
    //    //     * @param <RS>                 the generic type
    //    //     * @param <QRC>                the generic type
    //    //     * @param <QRL>                the generic type
    //    //     * @param <QRS>                the generic type
    //    //     * @param <QR>                 the generic type
    //    //     * @param <J>                  the generic type
    //    //     * @param <R2>                 the generic type
    //    //     * @param entities             the entities
    //    //     * @param joinTypePropertyName the join type property name
    //    //     * @return EntityQueryRelateExpression2R
    //    //     */
    //    //    <RE extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
    //    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
    //    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
    //    //            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
    //    //            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //    //            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //    //            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
    //    //            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>, R2> RE join(
    //    //                    Function<Tuple2<QueryEntityRepository<E>, QueryEntityRepository<R1>>,
    //    //                            QueryEntityRepository<R1>> entities,
    //    //                    SerializableToStringFunction2<R2> joinTypePropertyName);
    //
    //    /**
    //     * join on.
    //     *
    //     * @param <RE>         the generic type
    //     * @param <RC>         the generic type
    //     * @param <RL>         the generic type
    //     * @param <RS>         the generic type
    //     * @param <QRC>        the generic type
    //     * @param <QRL>        the generic type
    //     * @param <QRS>        the generic type
    //     * @param <QR>         the generic type
    //     * @param <R2>         the generic type
    //     * @param entities     the entities
    //     * @param propertyName find type object property name
    //     * @return EntityQueryRelateExpression2R
    //     */
    //    <RE extends EntityQueryRelateExpression2RR<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
    //            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
    //            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>, R2> RE join(
    //                    BiFunction<QueryEntityRepository<E>, QueryEntityRepository<R1>, QueryEntityRepository<R1>> entities,
    //                    SerializableFunction4<R1, R2> propertyName);
    //
    //    //    /**
    //    //     * join on.
    //    //     *
    //    //     * @param <RE>         the generic type
    //    //     * @param <RC>         the generic type
    //    //     * @param <RL>         the generic type
    //    //     * @param <RS>         the generic type
    //    //     * @param <QRC>        the generic type
    //    //     * @param <QRL>        the generic type
    //    //     * @param <QRS>        the generic type
    //    //     * @param <QR>         the generic type
    //    //     * @param <R2>         the generic type
    //    //     * @param entities     the entities
    //    //     * @param propertyName find type object property name
    //    //     * @return EntityQueryRelateExpression2R
    //    //     */
    //    //    <RE extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
    //    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
    //    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
    //    //            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
    //    //            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //    //            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //    //            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
    //    //            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>, R2> RE join(Function<
    //    //                    Tuple2<QueryEntityRepository<E>, QueryEntityRepository<R1>>, QueryEntityRepository<R1>> entities,
    //    //                    SerializableFunction4<R1, R2> propertyName);
    //
    //    /**
    //     * join on.
    //     *
    //     * @param <RE>         the generic type
    //     * @param <RC>         the generic type
    //     * @param <RL>         the generic type
    //     * @param <RS>         the generic type
    //     * @param <QRC>        the generic type
    //     * @param <QRL>        the generic type
    //     * @param <QRS>        the generic type
    //     * @param <QR>         the generic type
    //     * @param <R2>         the generic type
    //     * @param entities     the entities
    //     * @param propertyName find type object property name
    //     * @return EntityQueryRelateExpression2R
    //     */
    //    <RE extends EntityQueryRelateExpression2RR<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
    //            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
    //            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>, R2> RE join(
    //                    BiFunction<QueryEntityRepository<E>, QueryEntityRepository<R1>, QueryEntityRepository<R1>> entities,
    //                    SerializableFunction5<R2, R1> propertyName);
    //
    //    //    /**
    //    //     * join on.
    //    //     *
    //    //     * @param <RE>         the generic type
    //    //     * @param <RC>         the generic type
    //    //     * @param <RL>         the generic type
    //    //     * @param <RS>         the generic type
    //    //     * @param <QRC>        the generic type
    //    //     * @param <QRL>        the generic type
    //    //     * @param <QRS>        the generic type
    //    //     * @param <QR>         the generic type
    //    //     * @param <R2>         the generic type
    //    //     * @param entities     the entities
    //    //     * @param propertyName find type object property name
    //    //     * @return EntityQueryRelateExpression2R
    //    //     */
    //    //    <RE extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
    //    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
    //    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
    //    //            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
    //    //            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //    //            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
    //    //            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
    //    //            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>, R2> RE join(Function<
    //    //                    Tuple2<QueryEntityRepository<E>, QueryEntityRepository<R1>>, QueryEntityRepository<R1>> entities,
    //    //                    SerializableFunction5<R2, R1> propertyName);
    //
    //    /**
    //     * join on.
    //     *
    //     * @param <RE>         the generic type
    //     * @param <RC>         the generic type
    //     * @param <RL>         the generic type
    //     * @param <RS>         the generic type
    //     * @param <QRC>        the generic type
    //     * @param <QRL>        the generic type
    //     * @param <QRS>        the generic type
    //     * @param <QR>         the generic type
    //     * @param entities     the entities
    //     * @param propertyName find type object property name
    //     * @return EntityQueryRelateExpression2R
    //     */
    //    <RE extends EntityQueryRelateExpression2RR<E, R1, R1, RC, RL, RS, QR, QRC, QRL, QRS>,
    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R1, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R1, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression3<E, R1, R1, E>,
    //            QRC extends EntityQueryConditionGroupExpression3<E, R1, R1, QRC, QRL, QRS, Tuple2<E, R1>>,
    //            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R1, QRC, QRL, QRS, Tuple2<E, R1>>,
    //            QRS extends EntityQuerySortExpression3<E, R1, R1, Tuple2<E, R1>>,
    //            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R1, QRC, QRL, QRS>> RE join(
    //                    BiFunction<QueryEntityRepository<E>, QueryEntityRepository<R1>, QueryEntityRepository<R1>> entities,
    //                    SerializableFunction6<R1, R1> propertyName);
    //
    //    //    /**
    //    //     * join on.
    //    //     *
    //    //     * @param <RE>         the generic type
    //    //     * @param <RC>         the generic type
    //    //     * @param <RL>         the generic type
    //    //     * @param <RS>         the generic type
    //    //     * @param <QRC>        the generic type
    //    //     * @param <QRL>        the generic type
    //    //     * @param <QRS>        the generic type
    //    //     * @param <QR>         the generic type
    //    //     * @param entities     the entities
    //    //     * @param propertyName find type object property name
    //    //     * @return EntityQueryRelateExpression2R
    //    //     */
    //    //    <RE extends EntityQueryRelateExpression2R<E, R1, R1, RC, RL, RS, QR, QRC, QRL, QRS>,
    //    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R1, RC, RL, RS, E>,
    //    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R1, RC, RL, RS, E>,
    //    //            RS extends EntityQuerySortExpression3<E, R1, R1, E>,
    //    //            QRC extends EntityQueryConditionGroupExpression3<E, R1, R1, QRC, QRL, QRS, Tuple2<E, R1>>,
    //    //            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R1, QRC, QRL, QRS, Tuple2<E, R1>>,
    //    //            QRS extends EntityQuerySortExpression3<E, R1, R1, Tuple2<E, R1>>,
    //    //            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R1, QRC, QRL, QRS>> RE join(Function<
    //    //                    Tuple2<QueryEntityRepository<E>, QueryEntityRepository<R1>>, QueryEntityRepository<R1>> entities,
    //    //                    SerializableFunction6<R1, R1> propertyName);

}
