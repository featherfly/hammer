
package cn.featherfly.hammer.expression.query.type;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableFunction2;
import cn.featherfly.common.lang.function.SerializableFunction3;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupExpression2;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionGroupLogicExpression2;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression;
import cn.featherfly.hammer.expression.entity.query.EntityQuerySortExpression2;

/**
 * EntityQueryEntityExpression .
 *
 * @author zhongj
 * @param <E> the query type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityQueryEntityExpression<E, C extends EntityQueryConditionGroupExpression<E, C, L, S>,
        L extends EntityQueryConditionGroupLogicExpression<E, C, L, S>, S extends EntityQuerySortExpression<E>>
        extends EntityQueryExpression<E, C, L, S> {

    //    /**
    //     * relate to .
    //     *
    //     * @param <RE>         the generic type
    //     * @param <QR>         the generic type
    //     * @param <R>          the generic type
    //     * @param propertyName find type object property name
    //     * @return EntityQueryWithOnExpression
    //     */
    //    default <RE extends EntityQueryRelateExpression<E, R, QR, RC, RL, RS, R>,
    //            RC extends EntityQueryConditionGroupExpression2<E, R, RC, RL, RS, R>,
    //            RL extends EntityQueryConditionGroupLogicExpression2<E, R, RC, RL, RS, R>,
    //            RS extends EntityQuerySortExpression2<E, R1, R>,
    //            QR extends EntityQueryRelatedFetchedExpression<E, R, RC, RL, RS>, R1,
    //            R> RE relate(SerializableFunction<E, R1> propertyName) {
    //        return join(propertyName);
    //    }

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param <R>          the generic type
     * @param propertyName find type object property name
     * @return EntityQueryWithOnExpression
     */
    <RE extends EntityQueryRelateExpression<E, R, RC, RL, RS, QR, FC, FL, FS>,
            RC extends EntityQueryConditionGroupExpression2<E, R, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression2<E, R, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression2<E, R, E>,
            QR extends EntityQueryRelatedFetchedExpression<E, R, FC, FL, FS>,
            FC extends EntityQueryConditionGroupExpression2<E, R, FC, FL, FS, Tuple2<E, R>>,
            FL extends EntityQueryConditionGroupLogicExpression2<E, R, FC, FL, FS, Tuple2<E, R>>,
            FS extends EntityQuerySortExpression2<E, R, Tuple2<E, R>>,
            R> RE join(SerializableFunction<E, R> propertyName);

    //    /**
    //     * relate to.
    //     *
    //     * @param <RE>         the generic type
    //     * @param <QR>         the generic type
    //     * @param <R>          the generic type
    //     * @param propertyName find type object property name
    //     * @return EntityQueryWithOnExpression
    //     */
    //    default <RE extends EntityQueryRelateExpression<E, R, QR, RC, RL, RS>,
    //            RC extends EntityQueryConditionGroupExpression2<E, R, RC, RL, RS>,
    //            RL extends EntityQueryConditionGroupLogicExpression2<E, R, RC, RL, RS>,
    //            RS extends EntitySortExpression2<E, R, RS>,
    //            QR extends EntityQueryRelatedFetchedExpression<E, R, RC, RL, RS>,
    //            R> RE relate(SerializableFunction2<R, E> propertyName) {
    //        return join(propertyName);
    //    }

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param <R>          the generic type
     * @param propertyName find type object property name
     * @return EntityQueryWithOnExpression
     */
    <RE extends EntityQueryRelateExpression<E, R, RC, RL, RS, QR, FC, FL, FS>,
            RC extends EntityQueryConditionGroupExpression2<E, R, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression2<E, R, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression2<E, R, E>,
            QR extends EntityQueryRelatedFetchedExpression<E, R, FC, FL, FS>,
            FC extends EntityQueryConditionGroupExpression2<E, R, FC, FL, FS, Tuple2<E, R>>,
            FL extends EntityQueryConditionGroupLogicExpression2<E, R, FC, FL, FS, Tuple2<E, R>>,
            FS extends EntityQuerySortExpression2<E, R, Tuple2<E, R>>,
            R> RE join(SerializableFunction2<R, E> propertyName);

    //    /**
    //     * relate to.
    //     *
    //     * @param <RE>         the generic type
    //     * @param <QR>         the generic type
    //     * @param propertyName find type object property name
    //     * @return EntityQueryWithOnExpression
    //     */
    //    default <RE extends EntityQueryRelateExpression<E, E, QR, RC, RL, RS, FC, FL, FS>,
    //            RC extends EntityQueryConditionGroupExpression2<E, E, RC, RL, RS, E>,
    //            RL extends EntityQueryConditionGroupLogicExpression2<E, E, RC, RL, RS, E>,
    //            RS extends EntityQuerySortExpression2<E, E, E>,
    //            FC extends EntityQueryConditionGroupExpression2<E, E, FC, FL, FS, Tuple2<E, E>>,
    //            FL extends EntityQueryConditionGroupLogicExpression2<E, E, FC, FL, FS, Tuple2<E, E>>,
    //            FS extends EntityQuerySortExpression2<E, E, Tuple2<E, E>>,
    //            QR extends EntityQueryRelatedFetchedExpression<E, E, FC, FL, FS>> RE relate(
    //                    SerializableFunction3<E, E> propertyName) {
    //        return join(propertyName);
    //    }

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryWithOnExpression
     */
    <RE extends EntityQueryRelateExpression<E, E, RC, RL, RS, QR, FC, FL, FS>,
            RC extends EntityQueryConditionGroupExpression2<E, E, RC, RL, RS, E>,
            RL extends EntityQueryConditionGroupLogicExpression2<E, E, RC, RL, RS, E>,
            RS extends EntityQuerySortExpression2<E, E, E>,
            QR extends EntityQueryRelatedFetchedExpression<E, E, FC, FL, FS>,
            FC extends EntityQueryConditionGroupExpression2<E, E, FC, FL, FS, Tuple2<E, E>>,
            FL extends EntityQueryConditionGroupLogicExpression2<E, E, FC, FL, FS, Tuple2<E, E>>,
            FS extends EntityQuerySortExpression2<E, E, Tuple2<E, E>>> RE join(
                    SerializableFunction3<E, E> propertyName);

    //    /**
    //     * relate to.
    //     *
    //     * @param <R>           the generic type
    //     * @param propertyValue find type object property value
    //     * @return EntityQueryWithOnExpression
    //     */
    //    default <RE extends EntityQueryRelationEntityExpression<E, R, QR, C, L>,
    //            QR extends EntityQueryRelationExpression<E, R, C, L>, R> RE relate(SerializableSupplier<R> propertyValue) {
    //        return join(propertyValue);
    //    }

    //    /**
    //     * join on.
    //     *
    //     * @param <R>           the generic type
    //     * @param propertyValue find type object property value
    //     * @return EntityQueryWithOnExpression
    //     */
    //    <RE extends EntityQueryRelationEntityExpression<E, R, QR, C, L>,
    //            QR extends EntityQueryRelationExpression<E, R, C, L>, R> RE join(SerializableSupplier<R> propertyValue);

    //    /**
    //     * join on.
    //     *
    //     * @param <R>          the generic type
    //     * @param propertyName with type object property name
    //     * @param index        with index, the first is 1
    //     * @return EntityQueryWithOnExpression
    //     */
    //    <RE extends EntityQueryRelationEntityExpression<E, R, C, L>, R> RE join(SerializableFunction<E, R> propertyName,
    //            int index);
}
