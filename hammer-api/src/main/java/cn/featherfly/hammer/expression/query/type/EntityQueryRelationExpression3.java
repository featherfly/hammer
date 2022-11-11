
package cn.featherfly.hammer.expression.query.type;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableFunction2;
import cn.featherfly.common.lang.function.SerializableFunction3;
import cn.featherfly.hammer.expression.EntityConditionGroupExpression;
import cn.featherfly.hammer.expression.EntityConditionGroupLogicExpression;

/**
 * The Interface TypeQueryWithExpression.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> relate from type
 * @param <R2> relate to type
 * @param <R3> the generic type
 * @param <Q>  the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityQueryRelationExpression3<E, R1, R2, R3,
        Q extends EntityQueryEntityPropertiesExpression<E, Q, C, L>, C extends EntityConditionGroupExpression<E, C, L>,
        L extends EntityConditionGroupLogicExpression<E, C, L>> extends EntityQueryExpression<E, Q, C, L> {

    /**
     * relate to.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param <R4>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    default <RE extends EntityQueryRelationEntityExpression4<E, R1, R2, R3, R4, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression4<E, R1, R2, R3, R4, Q, C, L>,
            R4> RE relate(SerializableFunction<E, R4> propertyName) {
        return join(propertyName);
    }

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param <R4>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    <RE extends EntityQueryRelationEntityExpression4<E, R1, R2, R3, R4, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression4<E, R1, R2, R3, R4, Q, C, L>,
            R4> RE join(SerializableFunction<E, R4> propertyName);

    /**
     * relate to.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param <R4>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    default <RE extends EntityQueryRelationEntityExpression4<E, R1, R2, R3, R4, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression4<E, R1, R2, R3, R4, Q, C, L>,
            R4> RE relate(SerializableFunction2<R4, E> propertyName) {
        return join(propertyName);
    }

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param <R4>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    <RE extends EntityQueryRelationEntityExpression4<E, R1, R2, R3, R4, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression4<E, R1, R2, R3, R4, Q, C, L>,
            R4> RE join(SerializableFunction2<R4, E> propertyName);

    /**
     * relate to.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    default <RE extends EntityQueryRelationEntityExpression4<E, R1, R2, R3, E, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression4<E, R1, R2, R3, E, Q, C, L>> RE relate(
                    SerializableFunction3<E, E> propertyName) {
        return join(propertyName);
    }

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    <RE extends EntityQueryRelationEntityExpression4<E, R1, R2, R3, E, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression4<E, R1, R2, R3, E, Q, C, L>> RE join(
                    SerializableFunction3<E, E> propertyName);

    // ********************************************************************
    //	1
    // ********************************************************************

    /**
     * relate to.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param <R4>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    default <RE extends EntityQueryRelationEntityExpression4<E, R1, R2, R3, R4, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression4<E, R1, R2, R3, R4, Q, C, L>,
            R4> RE relate1(SerializableFunction<R1, R4> propertyName) {
        return join1(propertyName);
    }

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param <R4>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    <RE extends EntityQueryRelationEntityExpression4<E, R1, R2, R3, R4, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression4<E, R1, R2, R3, R4, Q, C, L>,
            R4> RE join1(SerializableFunction<R1, R4> propertyName);

    /**
     * relate to.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param <R4>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    default <RE extends EntityQueryRelationEntityExpression4<E, R1, R2, R3, R4, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression4<E, R1, R2, R3, R4, Q, C, L>,
            R4> RE relate1(SerializableFunction2<R4, R1> propertyName) {
        return join1(propertyName);
    }

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param <R4>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    <RE extends EntityQueryRelationEntityExpression4<E, R1, R2, R3, R4, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression4<E, R1, R2, R3, R4, Q, C, L>,
            R4> RE join1(SerializableFunction2<R4, R1> propertyName);

    /**
     * relate to.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    default <RE extends EntityQueryRelationEntityExpression4<E, R1, R2, R3, R1, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression4<E, R1, R2, R3, R1, Q, C, L>> RE relate1(
                    SerializableFunction3<R1, R1> propertyName) {
        return join1(propertyName);
    }

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    <RE extends EntityQueryRelationEntityExpression4<E, R1, R2, R3, R1, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression4<E, R1, R2, R3, R1, Q, C, L>> RE join1(
                    SerializableFunction3<R1, R1> propertyName);

    // ********************************************************************
    //	2
    // ********************************************************************

    /**
     * relate to.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param <R4>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    default <RE extends EntityQueryRelationEntityExpression4<E, R1, R2, R3, R4, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression4<E, R1, R2, R3, R4, Q, C, L>,
            R4> RE relate2(SerializableFunction<R2, R4> propertyName) {
        return join2(propertyName);
    }

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param <R4>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    <RE extends EntityQueryRelationEntityExpression4<E, R1, R2, R3, R4, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression4<E, R1, R2, R3, R4, Q, C, L>,
            R4> RE join2(SerializableFunction<R2, R4> propertyName);

    /**
     * relate to.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param <R4>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    default <RE extends EntityQueryRelationEntityExpression4<E, R1, R2, R3, R4, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression4<E, R1, R2, R3, R4, Q, C, L>,
            R4> RE relate2(SerializableFunction2<R4, R2> propertyName) {
        return join2(propertyName);
    }

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param <R4>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    <RE extends EntityQueryRelationEntityExpression4<E, R1, R2, R3, R4, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression4<E, R1, R2, R3, R4, Q, C, L>,
            R4> RE join2(SerializableFunction2<R4, R2> propertyName);

    /**
     * relate to.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    default <RE extends EntityQueryRelationEntityExpression4<E, R1, R2, R3, R2, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression4<E, R1, R2, R3, R2, Q, C, L>> RE relate2(
                    SerializableFunction3<R2, R2> propertyName) {
        return join2(propertyName);
    }

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    <RE extends EntityQueryRelationEntityExpression4<E, R1, R2, R3, R2, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression4<E, R1, R2, R3, R2, Q, C, L>> RE join2(
                    SerializableFunction3<R2, R2> propertyName);

    // ********************************************************************
    //	3
    // ********************************************************************

    /**
     * relate to.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param <R4>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    default <RE extends EntityQueryRelationEntityExpression4<E, R1, R2, R3, R4, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression4<E, R1, R2, R3, R4, Q, C, L>,
            R4> RE relate3(SerializableFunction<R3, R4> propertyName) {
        return join3(propertyName);
    }

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param <R4>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    <RE extends EntityQueryRelationEntityExpression4<E, R1, R2, R3, R4, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression4<E, R1, R2, R3, R4, Q, C, L>,
            R4> RE join3(SerializableFunction<R3, R4> propertyName);

    /**
     * relate to.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param <R4>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    default <RE extends EntityQueryRelationEntityExpression4<E, R1, R2, R3, R4, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression4<E, R1, R2, R3, R4, Q, C, L>,
            R4> RE relate3(SerializableFunction2<R4, R3> propertyName) {
        return join3(propertyName);
    }

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param <R4>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    <RE extends EntityQueryRelationEntityExpression4<E, R1, R2, R3, R4, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression4<E, R1, R2, R3, R4, Q, C, L>,
            R4> RE join3(SerializableFunction2<R4, R3> propertyName);

    /**
     * relate to.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    default <RE extends EntityQueryRelationEntityExpression4<E, R1, R2, R3, R3, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression4<E, R1, R2, R3, R3, Q, C, L>> RE relate3(
                    SerializableFunction3<R3, R3> propertyName) {
        return join3(propertyName);
    }

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    <RE extends EntityQueryRelationEntityExpression4<E, R1, R2, R3, R3, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression4<E, R1, R2, R3, R3, Q, C, L>> RE join3(
                    SerializableFunction3<R3, R3> propertyName);
}
