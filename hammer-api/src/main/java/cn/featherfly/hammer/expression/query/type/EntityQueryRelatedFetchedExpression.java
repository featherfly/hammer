package cn.featherfly.hammer.expression.query.type;

import com.speedment.common.tuple.Tuple2;
import com.speedment.common.tuple.Tuple3;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableFunction1;
import cn.featherfly.common.lang.function.SerializableFunction2;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression2;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression3;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression2;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression3;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression2;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression3;

/**
 * The Interface EntityQueryRelationFetchExpression.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> relate from type
 * @param <C>  the generic type
 * @param <L>  the generic type
 * @param <S>  the generic type
 */

public interface EntityQueryRelatedFetchedExpression<E, R1,
        C extends EntityQueryConditionGroupExpression2<E, R1, C, L, S, Tuple2<E, R1>>,
        L extends EntityQueryConditionGroupLogicExpression2<E, R1, C, L, S, Tuple2<E, R1>>,
        S extends EntityQuerySortExpression2<E, R1, Tuple2<E, R1>>>
        //        extends EntityQueryRelationExpression<E, R1, C, L, S, Tuple2<E, R1>> {
        extends EntityQueryExpression2<E, R1, C, L, S, Tuple2<E, R1>> {

    //  /**
    //     * relate to.
    //     *
    //     * @param <RE>         the generic type
    //     * @param <QR>         the generic type
    //     * @param <R2>         the generic type
    //     * @param propertyName find type object property name
    //     * @return TypeQueryWithOnExpression
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
     * @param <QR>         the generic type
     * @param <FC>         the generic type
     * @param <FL>         the generic type
     * @param <FS>         the generic type
     * @param <R2>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    <RE extends EntityQueryRelateExpression2F<E, R1, R2, RC, RL, RS, QR, FC, FL, FS>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, Tuple2<E, R1>>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, Tuple2<E, R1>>,
            RS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R1>>,
            QR extends EntityQueryRelatedFetchedExpression2FF<E, R1, R2, FC, FL, FS>,
            FC extends EntityQueryConditionGroupExpression3<E, R1, R2, FC, FL, FS, Tuple3<E, R1, R2>>,
            FL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, FC, FL, FS, Tuple3<E, R1, R2>>,
            FS extends EntityQuerySortExpression3<E, R1, R2, Tuple3<E, R1, R2>>,
            R2> RE join(SerializableFunction<E, R2> propertyName);

    //    /**
    //     * relate to.
    //     *
    //     * @param <RE>         the generic type
    //     * @param <QR>         the generic type
    //     * @param <R2>         the generic type
    //     * @param propertyName find type object property name
    //     * @return TypeQueryWithOnExpression
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
     * @param <QR>         the generic type
     * @param <FC>         the generic type
     * @param <FL>         the generic type
     * @param <FS>         the generic type
     * @param <R2>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    <RE extends EntityQueryRelateExpression2F<E, R1, R2, RC, RL, RS, QR, FC, FL, FS>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, Tuple2<E, R1>>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, Tuple2<E, R1>>,
            RS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R1>>,
            QR extends EntityQueryRelatedFetchedExpression2FF<E, R1, R2, FC, FL, FS>,
            FC extends EntityQueryConditionGroupExpression3<E, R1, R2, FC, FL, FS, Tuple3<E, R1, R2>>,
            FL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, FC, FL, FS, Tuple3<E, R1, R2>>,
            FS extends EntityQuerySortExpression3<E, R1, R2, Tuple3<E, R1, R2>>,
            R2> RE join(SerializableFunction2<R2, E> propertyName);

    //    /**
    //     * relate to.
    //     *
    //     * @param <RE>         the generic type
    //     * @param <QR>         the generic type
    //     * @param propertyName find type object property name
    //     * @return TypeQueryWithOnExpression
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
     * @param <QR>         the generic type
     * @param <FC>         the generic type
     * @param <FL>         the generic type
     * @param <FS>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    <RE extends EntityQueryRelateExpression2F<E, R1, E, RC, RL, RS, QR, FC, FL, FS>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, E, RC, RL, RS, Tuple2<E, R1>>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, E, RC, RL, RS, Tuple2<E, R1>>,
            RS extends EntityQuerySortExpression3<E, R1, E, Tuple2<E, R1>>,
            QR extends EntityQueryRelatedFetchedExpression2FF<E, R1, E, FC, FL, FS>,
            FC extends EntityQueryConditionGroupExpression3<E, R1, E, FC, FL, FS, Tuple3<E, R1, E>>,
            FL extends EntityQueryConditionGroupLogicExpression3<E, R1, E, FC, FL, FS, Tuple3<E, R1, E>>,
            FS extends EntityQuerySortExpression3<E, R1, E, Tuple3<E, R1, E>>> RE join(
                    SerializableFunction1<E, E> propertyName);

    //    /**
    //     * relate to.
    //     *
    //     * @param <RE>         the generic type
    //     * @param <QR>         the generic type
    //     * @param <R2>         the generic type
    //     * @param propertyName find type object property name
    //     * @return TypeQueryWithOnExpression
    //     */
    //    default <RE extends EntityQueryRelateExpression2<E, R1, R2, QR, RC, RL, RS, R>,
    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS>,
    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS>,
    //            QR extends EntityQueryRelatedFetchedExpression2<E, R1, R2, RC, RL, RS>,
    //            RS extends EntitySortExpression3<E, R1, R2, RS>, R2> RE relate1(SerializableFunction<R1, R2> propertyName) {
    //        return join1(propertyName);
    //    }

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
     * @return TypeQueryWithOnExpression
     */
    <RE extends EntityQueryRelateExpression2F<E, R1, R2, RC, RL, RS, QR, FC, FL, FS>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, Tuple2<E, R1>>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, Tuple2<E, R1>>,
            RS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R1>>,
            QR extends EntityQueryRelatedFetchedExpression2FF<E, R1, R2, FC, FL, FS>,
            FC extends EntityQueryConditionGroupExpression3<E, R1, R2, FC, FL, FS, Tuple3<E, R1, R2>>,
            FL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, FC, FL, FS, Tuple3<E, R1, R2>>,
            FS extends EntityQuerySortExpression3<E, R1, R2, Tuple3<E, R1, R2>>,
            R2> RE join1(SerializableFunction<R1, R2> propertyName);

    //    /**
    //     * relate to.
    //     *
    //     * @param <RE>         the generic type
    //     * @param <QR>         the generic type
    //     * @param <R2>         the generic type
    //     * @param propertyName find type object property name
    //     * @return TypeQueryWithOnExpression
    //     */
    //    default <RE extends EntityQueryRelateExpression2<E, R1, R2, QR, RC, RL, RS, R>,
    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS>,
    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS>,
    //            QR extends EntityQueryRelatedFetchedExpression2<E, R1, R2, RC, RL, RS>,
    //            RS extends EntitySortExpression3<E, R1, R2, RS>,
    //            R2> RE relate1(SerializableFunction2<R2, R1> propertyName) {
    //        return join1(propertyName);
    //    }

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
     * @return TypeQueryWithOnExpression
     */
    <RE extends EntityQueryRelateExpression2F<E, R1, R2, RC, RL, RS, QR, FC, FL, FS>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, Tuple2<E, R1>>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, Tuple2<E, R1>>,
            RS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R1>>,
            QR extends EntityQueryRelatedFetchedExpression2FF<E, R1, R2, FC, FL, FS>,
            FC extends EntityQueryConditionGroupExpression3<E, R1, R2, FC, FL, FS, Tuple3<E, R1, R2>>,
            FL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, FC, FL, FS, Tuple3<E, R1, R2>>,
            FS extends EntityQuerySortExpression3<E, R1, R2, Tuple3<E, R1, R2>>,
            R2> RE join1(SerializableFunction2<R2, R1> propertyName);

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
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    <RE extends EntityQueryRelateExpression2F<E, R1, R1, RC, RL, RS, QR, FC, FL, FS>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R1, RC, RL, RS, Tuple2<E, R1>>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R1, RC, RL, RS, Tuple2<E, R1>>,
            RS extends EntityQuerySortExpression3<E, R1, R1, Tuple2<E, R1>>,
            QR extends EntityQueryRelatedFetchedExpression2FF<E, R1, R1, FC, FL, FS>,
            FC extends EntityQueryConditionGroupExpression3<E, R1, R1, FC, FL, FS, Tuple3<E, R1, R1>>,
            FL extends EntityQueryConditionGroupLogicExpression3<E, R1, R1, FC, FL, FS, Tuple3<E, R1, R1>>,
            FS extends EntityQuerySortExpression3<E, R1, R1, Tuple3<E, R1, R1>>> RE join1(
                    SerializableFunction1<R1, R1> propertyName);

}
