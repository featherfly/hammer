
package cn.featherfly.hammer.expression.query.type;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableFunction2;
import cn.featherfly.common.lang.function.SerializableFunction3;
import cn.featherfly.hammer.expression.EntityConditionGroupExpression;
import cn.featherfly.hammer.expression.EntityConditionGroupLogicExpression;

/**
 * EntityQueryEntityExpression .
 *
 * @author zhongj
 * @param <E> the query type
 * @param <Q> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityQueryEntityExpression<E, Q extends EntityQueryEntityPropertiesExpression<E, Q, C, L>,
        C extends EntityConditionGroupExpression<E, C, L>, L extends EntityConditionGroupLogicExpression<E, C, L>>
        extends EntityQueryExpression<E, Q, C, L>, EntityQueryPropertiesExpression<E, Q> {

    /**
     * relate to .
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param <R>          the generic type
     * @param propertyName find type object property name
     * @return EntityQueryWithOnExpression
     */
    default <RE extends EntityQueryRelationEntityExpression<E, R, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression<E, R, Q, C, L>,
            R> RE relate(SerializableFunction<E, R> propertyName) {
        return join(propertyName);
    }

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param <R>          the generic type
     * @param propertyName find type object property name
     * @return EntityQueryWithOnExpression
     */
    <RE extends EntityQueryRelationEntityExpression<E, R, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression<E, R, Q, C, L>,
            R> RE join(SerializableFunction<E, R> propertyName);

    /**
     * relate to.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param <R>          the generic type
     * @param propertyName find type object property name
     * @return EntityQueryWithOnExpression
     */
    default <RE extends EntityQueryRelationEntityExpression<E, R, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression<E, R, Q, C, L>,
            R> RE relate(SerializableFunction2<R, E> propertyName) {
        return join(propertyName);
    }

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param <R>          the generic type
     * @param propertyName find type object property name
     * @return EntityQueryWithOnExpression
     */
    <RE extends EntityQueryRelationEntityExpression<E, R, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression<E, R, Q, C, L>,
            R> RE join(SerializableFunction2<R, E> propertyName);

    /**
     * relate to.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryWithOnExpression
     */
    default <RE extends EntityQueryRelationEntityExpression<E, E, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression<E, E, Q, C, L>> RE relate(
                    SerializableFunction3<E, E> propertyName) {
        return join(propertyName);
    }

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param propertyName find type object property name
     * @return EntityQueryWithOnExpression
     */
    <RE extends EntityQueryRelationEntityExpression<E, E, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression<E, E, Q, C, L>> RE join(SerializableFunction3<E, E> propertyName);

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
