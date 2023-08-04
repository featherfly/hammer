
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
 * The Interface EntityQueryRelateExpression1P.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 * @param <S>  the generic type
 * @param <F>  the generic type
 */
public interface EntityQueryRelateExpression1P<E, R1, C extends EntityQueryConditionGroupExpression2<E, R1, C, L, S, E>,
        L extends EntityQueryConditionGroupLogicExpression2<E, R1, C, L, S, E>,
        S extends EntityQuerySortExpression2<E, R1, E>, F extends EntityQueryRelatedFetchedExpression1P<E, R1, C, L, S>>
        extends EntityQueryExpression2<E, R1, C, L, S, E>, EntityQueryRelate<F> {

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
    <RE extends EntityQueryRelateExpression2P<E, R1, R2, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
            QR extends EntityQueryRelatedFetchedExpression2PP<E, R1, R2, RC, RL, RS>,
            R2> RE join(SerializableFunction1<E, R2> propertyName);

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
    <RE extends EntityQueryRelateExpression2P<E, R1, R2, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
            QR extends EntityQueryRelatedFetchedExpression2PP<E, R1, R2, RC, RL, RS>,
            R2> RE join(SerializableFunction2<R2, E> propertyName);

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
    <RE extends EntityQueryRelateExpression2P<E, R1, E, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, E, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, E, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression3<E, R1, E, E>,
            QR extends EntityQueryRelatedFetchedExpression2PP<E, R1, E, RC, RL, RS>> RE join(
                    SerializableFunction3<E, E> propertyName);

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
     * @param <QR>         the generic type
     * @param <R2>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryRelateExpression2P
     */
    <RE extends EntityQueryRelateExpression2P<E, R1, R2, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
            QR extends EntityQueryRelatedFetchedExpression2PP<E, R1, R2, RC, RL, RS>,
            R2> RE join2(SerializableFunction1<R1, R2> propertyName);

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
    <RE extends EntityQueryRelateExpression2P<E, R1, R2, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
            QR extends EntityQueryRelatedFetchedExpression2PP<E, R1, R2, RC, RL, RS>,
            R2> RE join2(SerializableFunction2<R2, R1> propertyName);

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
    <RE extends EntityQueryRelateExpression2P<E, R1, R1, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R1, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R1, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression3<E, R1, R1, E>,
            QR extends EntityQueryRelatedFetchedExpression2PP<E, R1, R1, RC, RL, RS>> RE join2(
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
     * @param <QR>         the generic type
     * @param <R2>         the generic type
     * @param entities     the entities
     * @param propertyName find type object property name
     * @return EntityQueryRelateExpression2P
     */
    <RE extends EntityQueryRelateExpression2P<E, R1, R2, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
            QR extends EntityQueryRelatedFetchedExpression2PP<E, R1, R2, RC, RL, RS>, R2> RE join(Function<
                    Tuple2<QueryEntityRepository<E>, QueryEntityRepository<R1>>, QueryEntityRepository<E>> entities,
                    SerializableFunction1<E, R2> propertyName);

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <RC>         the generic type
     * @param <RL>         the generic type
     * @param <RS>         the generic type
     * @param <QR>         the generic type
     * @param <R2>         the generic type
     * @param entities     the entities
     * @param propertyName find type object property name
     * @return EntityQueryRelateExpression2P
     */
    <RE extends EntityQueryRelateExpression2P<E, R1, R2, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
            QR extends EntityQueryRelatedFetchedExpression2PP<E, R1, R2, RC, RL, RS>, R2> RE join(Function<
                    Tuple2<QueryEntityRepository<E>, QueryEntityRepository<R1>>, QueryEntityRepository<E>> entities,
                    SerializableFunction2<R2, E> propertyName);

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <RC>         the generic type
     * @param <RL>         the generic type
     * @param <RS>         the generic type
     * @param <QR>         the generic type
     * @param entities     the entities
     * @param propertyName find type object property name
     * @return EntityQueryRelateExpression2P
     */
    <RE extends EntityQueryRelateExpression2P<E, R1, E, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, E, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, E, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression3<E, R1, E, E>,
            QR extends EntityQueryRelatedFetchedExpression2PP<E, R1, E, RC, RL, RS>> RE join(Function<
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
     * @param <QR>         the generic type
     * @param <R2>         the generic type
     * @param entities     the entities
     * @param propertyName find type object property name
     * @return EntityQueryRelateExpression2P
     */
    <RE extends EntityQueryRelateExpression2P<E, R1, R2, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
            QR extends EntityQueryRelatedFetchedExpression2PP<E, R1, R2, RC, RL, RS>, R2> RE join(Function<
                    Tuple2<QueryEntityRepository<E>, QueryEntityRepository<R1>>, QueryEntityRepository<R1>> entities,
                    SerializableFunction4<R1, R2> propertyName);

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <RC>         the generic type
     * @param <RL>         the generic type
     * @param <RS>         the generic type
     * @param <QR>         the generic type
     * @param <R2>         the generic type
     * @param entities     the entities
     * @param propertyName find type object property name
     * @return EntityQueryRelateExpression2P
     */
    <RE extends EntityQueryRelateExpression2P<E, R1, R2, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
            QR extends EntityQueryRelatedFetchedExpression2PP<E, R1, R2, RC, RL, RS>, R2> RE join(Function<
                    Tuple2<QueryEntityRepository<E>, QueryEntityRepository<R1>>, QueryEntityRepository<R1>> entities,
                    SerializableFunction5<R2, R1> propertyName);

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <RC>         the generic type
     * @param <RL>         the generic type
     * @param <RS>         the generic type
     * @param <QR>         the generic type
     * @param entities     the entities
     * @param propertyName find type object property name
     * @return EntityQueryRelateExpression2P
     */
    <RE extends EntityQueryRelateExpression2P<E, R1, R1, RC, RL, RS, QR>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R1, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R1, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression3<E, R1, R1, E>,
            QR extends EntityQueryRelatedFetchedExpression2PP<E, R1, R1, RC, RL, RS>> RE join(Function<
                    Tuple2<QueryEntityRepository<E>, QueryEntityRepository<R1>>, QueryEntityRepository<R1>> entities,
                    SerializableFunction6<R1, R1> propertyName);

}
