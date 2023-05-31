
package cn.featherfly.hammer.expression.query.type;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableFunction1;
import cn.featherfly.common.lang.function.SerializableFunction2;
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
 */
// TODO 关联查询实现后重命名为EntityQueryRalatedExpression
public interface EntityQueryRelateExpression<E, R1, C extends EntityQueryConditionGroupExpression2<E, R1, C, L, S, E>,
        L extends EntityQueryConditionGroupLogicExpression2<E, R1, C, L, S, E>,
        S extends EntityQuerySortExpression2<E, R1, E>,
        F extends EntityQueryRelatedFetchedExpression<E, R1, FC, FL, FS>,
        FC extends EntityQueryConditionGroupExpression2<E, R1, FC, FL, FS, Tuple2<E, R1>>,
        FL extends EntityQueryConditionGroupLogicExpression2<E, R1, FC, FL, FS, Tuple2<E, R1>>,
        FS extends EntityQuerySortExpression2<E, R1, Tuple2<E, R1>>>
        //        extends EntityQueryRelationExpression<E, R1, C, L, S, E>, EntityQueryRelate<QR> {
        extends EntityQueryExpression2<E, R1, C, L, S, E>, EntityQueryRelate<F> {

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
     * @param <QRC>        the generic type
     * @param <QRL>        the generic type
     * @param <QRS>        the generic type
     * @param <QR>         the generic type
     * @param <R2>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    <RE extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>,
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
     * @param <QRC>        the generic type
     * @param <QRL>        the generic type
     * @param <QRS>        the generic type
     * @param <QR>         the generic type
     * @param <R2>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
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
     * @param <QRC>        the generic type
     * @param <QRL>        the generic type
     * @param <QRS>        the generic type
     * @param <QR>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    <RE extends EntityQueryRelateExpression2R<E, R1, E, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, E, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, E, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression3<E, R1, E, E>,
            QRC extends EntityQueryConditionGroupExpression3<E, R1, E, QRC, QRL, QRS, Tuple2<E, E>>,
            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, E, QRC, QRL, QRS, Tuple2<E, E>>,
            QRS extends EntityQuerySortExpression3<E, R1, E, Tuple2<E, E>>,
            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, E, QRC, QRL, QRS>> RE join(
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
     * @param <QRC>        the generic type
     * @param <QRL>        the generic type
     * @param <QRS>        the generic type
     * @param <QR>         the generic type
     * @param <R2>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    <RE extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>,
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
     * @param <QRC>        the generic type
     * @param <QRL>        the generic type
     * @param <QRS>        the generic type
     * @param <QR>         the generic type
     * @param <R2>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    <RE extends EntityQueryRelateExpression2R<E, R1, R2, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R2, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression3<E, R1, R2, E>,
            QRC extends EntityQueryConditionGroupExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R2, QRC, QRL, QRS, Tuple2<E, R2>>,
            QRS extends EntityQuerySortExpression3<E, R1, R2, Tuple2<E, R2>>,
            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R2, QRC, QRL, QRS>,
            R2> RE join1(SerializableFunction2<R2, R1> propertyName);

    //    /**
    //     * relate to.
    //     *
    //     * @param <RE>         the generic type
    //     * @param <QR>         the generic type
    //     * @param propertyName find type object property name
    //     * @return TypeQueryWithOnExpression
    //     */
    //    default <RE extends EntityQueryRelationEntityExpression2<E, R1, R1, QR, RC, RL, RS, R>,
    //            RC extends EntityQueryConditionGroupExpression3<E, R1, R1, RC, RL, RS, R>,
    //            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R1, RC, RL, RS, R>,
    //            QR extends EntityQueryRelatedFetchedExpression2<E, R1, R1, RC, RL, RS, R>> RE relate1(
    //                    SerializableFunction1<R1, R1> propertyName) {
    //        return join1(propertyName);
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
     * @return TypeQueryWithOnExpression
     */
    <RE extends EntityQueryRelateExpression2R<E, R1, R1, RC, RL, RS, QR, QRC, QRL, QRS>,
            RC extends EntityQueryConditionGroupExpression3<E, R1, R1, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression3<E, R1, R1, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression3<E, R1, R1, E>,
            QRC extends EntityQueryConditionGroupExpression3<E, R1, R1, QRC, QRL, QRS, Tuple2<E, R1>>,
            QRL extends EntityQueryConditionGroupLogicExpression3<E, R1, R1, QRC, QRL, QRS, Tuple2<E, R1>>,
            QRS extends EntityQuerySortExpression3<E, R1, R1, Tuple2<E, R1>>,
            QR extends EntityQueryRelatedFetchedExpression2RF<E, R1, R1, QRC, QRL, QRS>> RE join1(
                    SerializableFunction1<R1, R1> propertyName);

}
