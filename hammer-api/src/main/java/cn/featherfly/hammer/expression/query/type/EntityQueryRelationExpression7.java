
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
 * @param <R4> the generic type
 * @param <R5> the generic type
 * @param <R6> the generic type
 * @param <R7> the generic type
 * @param <Q>  the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityQueryRelationExpression7<E, R1, R2, R3, R4, R5, R6, R7,
        Q extends EntityQueryEntityPropertiesExpression<E, Q, C, L>, C extends EntityConditionGroupExpression<E, C, L>,
        L extends EntityConditionGroupLogicExpression<E, C, L>> extends EntityQueryExpression<E, Q, C, L> {

    /**
     * relate to.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param <R8>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    default <RE extends EntityQueryRelationEntityExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, Q, C, L>,
            R8> RE relate(SerializableFunction<E, R8> propertyName) {
        return join(propertyName);
    }

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param <R8>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    <RE extends EntityQueryRelationEntityExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, Q, C, L>,
            R8> RE join(SerializableFunction<E, R8> propertyName);

    /**
     * relate to.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param <R8>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    default <RE extends EntityQueryRelationEntityExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, Q, C, L>,
            R8> RE relate(SerializableFunction2<R8, E> propertyName) {
        return join(propertyName);
    }

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param <R8>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    <RE extends EntityQueryRelationEntityExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, Q, C, L>,
            R8> RE join(SerializableFunction2<R8, E> propertyName);

    /**
     * relate to.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    default <RE extends EntityQueryRelationEntityExpression8<E, R1, R2, R3, R4, R5, R6, R7, E, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression8<E, R1, R2, R3, R4, R5, R6, R7, E, Q, C, L>> RE relate(
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
    <RE extends EntityQueryRelationEntityExpression8<E, R1, R2, R3, R4, R5, R6, R7, E, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression8<E, R1, R2, R3, R4, R5, R6, R7, E, Q, C, L>> RE join(
                    SerializableFunction3<E, E> propertyName);

    // ********************************************************************
    // 1
    // ********************************************************************

    /**
     * relate to.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param <R8>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    default <RE extends EntityQueryRelationEntityExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, Q, C, L>,
            R8> RE relate1(SerializableFunction<R1, R8> propertyName) {
        return join1(propertyName);
    }

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param <R8>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    <RE extends EntityQueryRelationEntityExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, Q, C, L>,
            R8> RE join1(SerializableFunction<R1, R8> propertyName);

    /**
     * relate to.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param <R8>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    default <RE extends EntityQueryRelationEntityExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, Q, C, L>,
            R8> RE relate1(SerializableFunction2<R8, R1> propertyName) {
        return join1(propertyName);
    }

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param <R8>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    <RE extends EntityQueryRelationEntityExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, Q, C, L>,
            R8> RE join1(SerializableFunction2<R8, R1> propertyName);

    /**
     * relate to.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    default <RE extends EntityQueryRelationEntityExpression8<E, R1, R2, R3, R4, R5, R6, R7, R1, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression8<E, R1, R2, R3, R4, R5, R6, R7, R1, Q, C, L>> RE relate1(
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
    <RE extends EntityQueryRelationEntityExpression8<E, R1, R2, R3, R4, R5, R6, R7, R1, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression8<E, R1, R2, R3, R4, R5, R6, R7, R1, Q, C, L>> RE join1(
                    SerializableFunction3<R1, R1> propertyName);

    // ********************************************************************
    // 2
    // ********************************************************************

    /**
     * relate to.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param <R8>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    default <RE extends EntityQueryRelationEntityExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, Q, C, L>,
            R8> RE relate2(SerializableFunction<R2, R8> propertyName) {
        return join2(propertyName);
    }

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param <R8>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    <RE extends EntityQueryRelationEntityExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, Q, C, L>,
            R8> RE join2(SerializableFunction<R2, R8> propertyName);

    /**
     * relate to.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param <R8>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    default <RE extends EntityQueryRelationEntityExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, Q, C, L>,
            R8> RE relate2(SerializableFunction2<R8, R2> propertyName) {
        return join2(propertyName);
    }

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param <R8>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    <RE extends EntityQueryRelationEntityExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, Q, C, L>,
            R8> RE join2(SerializableFunction2<R8, R2> propertyName);

    /**
     * relate to.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    default <RE extends EntityQueryRelationEntityExpression8<E, R1, R2, R3, R4, R5, R6, R7, R2, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression8<E, R1, R2, R3, R4, R5, R6, R7, R2, Q, C, L>> RE relate2(
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
    <RE extends EntityQueryRelationEntityExpression8<E, R1, R2, R3, R4, R5, R6, R7, R2, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression8<E, R1, R2, R3, R4, R5, R6, R7, R2, Q, C, L>> RE join2(
                    SerializableFunction3<R2, R2> propertyName);

    // ********************************************************************
    // 3
    // ********************************************************************

    /**
     * relate to.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param <R8>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    default <RE extends EntityQueryRelationEntityExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, Q, C, L>,
            R8> RE relate3(SerializableFunction<R3, R8> propertyName) {
        return join3(propertyName);
    }

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param <R8>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    <RE extends EntityQueryRelationEntityExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, Q, C, L>,
            R8> RE join3(SerializableFunction<R3, R8> propertyName);

    /**
     * relate to.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param <R8>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    default <RE extends EntityQueryRelationEntityExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, Q, C, L>,
            R8> RE relate3(SerializableFunction2<R8, R3> propertyName) {
        return join3(propertyName);
    }

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param <R8>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    <RE extends EntityQueryRelationEntityExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, Q, C, L>,
            R8> RE join3(SerializableFunction2<R8, R3> propertyName);

    /**
     * relate to.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    default <RE extends EntityQueryRelationEntityExpression8<E, R1, R2, R3, R4, R5, R6, R7, R3, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression8<E, R1, R2, R3, R4, R5, R6, R7, R3, Q, C, L>> RE relate3(
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
    <RE extends EntityQueryRelationEntityExpression8<E, R1, R2, R3, R4, R5, R6, R7, R3, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression8<E, R1, R2, R3, R4, R5, R6, R7, R3, Q, C, L>> RE join3(
                    SerializableFunction3<R3, R3> propertyName);

    // ********************************************************************
    // 4
    // ********************************************************************

    /**
     * relate to.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param <R8>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    default <RE extends EntityQueryRelationEntityExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, Q, C, L>,
            R8> RE relate4(SerializableFunction<R4, R8> propertyName) {
        return join4(propertyName);
    }

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param <R8>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    <RE extends EntityQueryRelationEntityExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, Q, C, L>,
            R8> RE join4(SerializableFunction<R4, R8> propertyName);

    /**
     * relate to.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param <R8>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    default <RE extends EntityQueryRelationEntityExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, Q, C, L>,
            R8> RE relate4(SerializableFunction2<R8, R4> propertyName) {
        return join4(propertyName);
    }

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param <R8>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    <RE extends EntityQueryRelationEntityExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, Q, C, L>,
            R8> RE join4(SerializableFunction2<R8, R4> propertyName);

    /**
     * relate to.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    default <RE extends EntityQueryRelationEntityExpression8<E, R1, R2, R3, R4, R5, R6, R7, R4, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression8<E, R1, R2, R3, R4, R5, R6, R7, R4, Q, C, L>> RE relate4(
                    SerializableFunction3<R4, R4> propertyName) {
        return join4(propertyName);
    }

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    <RE extends EntityQueryRelationEntityExpression8<E, R1, R2, R3, R4, R5, R6, R7, R4, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression8<E, R1, R2, R3, R4, R5, R6, R7, R4, Q, C, L>> RE join4(
                    SerializableFunction3<R4, R4> propertyName);

    // ********************************************************************
    // 5
    // ********************************************************************

    /**
     * relate to.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param <R8>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    default <RE extends EntityQueryRelationEntityExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, Q, C, L>,
            R8> RE relate5(SerializableFunction<R5, R8> propertyName) {
        return join5(propertyName);
    }

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param <R8>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    <RE extends EntityQueryRelationEntityExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, Q, C, L>,
            R8> RE join5(SerializableFunction<R5, R8> propertyName);

    /**
     * relate to.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param <R8>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    default <RE extends EntityQueryRelationEntityExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, Q, C, L>,
            R8> RE relate5(SerializableFunction2<R8, R5> propertyName) {
        return join5(propertyName);
    }

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param <R8>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    <RE extends EntityQueryRelationEntityExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, Q, C, L>,
            R8> RE join5(SerializableFunction2<R8, R5> propertyName);

    /**
     * relate to.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    default <RE extends EntityQueryRelationEntityExpression8<E, R1, R2, R3, R4, R5, R6, R7, R5, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression8<E, R1, R2, R3, R4, R5, R6, R7, R5, Q, C, L>> RE relate5(
                    SerializableFunction3<R5, R5> propertyName) {
        return join5(propertyName);
    }

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    <RE extends EntityQueryRelationEntityExpression8<E, R1, R2, R3, R4, R5, R6, R7, R5, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression8<E, R1, R2, R3, R4, R5, R6, R7, R5, Q, C, L>> RE join5(
                    SerializableFunction3<R5, R5> propertyName);

    // ********************************************************************
    // 6
    // ********************************************************************

    /**
     * relate to.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param <R8>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    default <RE extends EntityQueryRelationEntityExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, Q, C, L>,
            R8> RE relate6(SerializableFunction<R6, R8> propertyName) {
        return join6(propertyName);
    }

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param <R8>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    <RE extends EntityQueryRelationEntityExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, Q, C, L>,
            R8> RE join6(SerializableFunction<R6, R8> propertyName);

    /**
     * relate to.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param <R8>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    default <RE extends EntityQueryRelationEntityExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, Q, C, L>,
            R8> RE relate6(SerializableFunction2<R8, R6> propertyName) {
        return join6(propertyName);
    }

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param <R8>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    <RE extends EntityQueryRelationEntityExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, Q, C, L>,
            R8> RE join6(SerializableFunction2<R8, R6> propertyName);

    /**
     * relate to.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    default <RE extends EntityQueryRelationEntityExpression8<E, R1, R2, R3, R4, R5, R6, R7, R6, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression8<E, R1, R2, R3, R4, R5, R6, R7, R6, Q, C, L>> RE relate6(
                    SerializableFunction3<R6, R6> propertyName) {
        return join6(propertyName);
    }

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    <RE extends EntityQueryRelationEntityExpression8<E, R1, R2, R3, R4, R5, R6, R7, R6, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression8<E, R1, R2, R3, R4, R5, R6, R7, R6, Q, C, L>> RE join6(
                    SerializableFunction3<R6, R6> propertyName);

    // ********************************************************************
    // 7
    // ********************************************************************

    /**
     * relate to.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param <R8>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    default <RE extends EntityQueryRelationEntityExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, Q, C, L>,
            R8> RE relate7(SerializableFunction<R7, R8> propertyName) {
        return join7(propertyName);
    }

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param <R8>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    <RE extends EntityQueryRelationEntityExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, Q, C, L>,
            R8> RE join7(SerializableFunction<R7, R8> propertyName);

    /**
     * relate to.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param <R8>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    default <RE extends EntityQueryRelationEntityExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, Q, C, L>,
            R8> RE relate7(SerializableFunction2<R8, R7> propertyName) {
        return join7(propertyName);
    }

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param <R8>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    <RE extends EntityQueryRelationEntityExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression8<E, R1, R2, R3, R4, R5, R6, R7, R8, Q, C, L>,
            R8> RE join7(SerializableFunction2<R8, R7> propertyName);

    /**
     * relate to.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    default <RE extends EntityQueryRelationEntityExpression8<E, R1, R2, R3, R4, R5, R6, R7, R7, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression8<E, R1, R2, R3, R4, R5, R6, R7, R7, Q, C, L>> RE relate7(
                    SerializableFunction3<R7, R7> propertyName) {
        return join7(propertyName);
    }

    /**
     * join on.
     *
     * @param <RE>         the generic type
     * @param <QR>         the generic type
     * @param propertyName find type object property name
     * @return TypeQueryWithOnExpression
     */
    <RE extends EntityQueryRelationEntityExpression8<E, R1, R2, R3, R4, R5, R6, R7, R7, Q, QR, C, L>,
            QR extends EntityQueryRelationExpression8<E, R1, R2, R3, R4, R5, R6, R7, R7, Q, C, L>> RE join7(
                    SerializableFunction3<R7, R7> propertyName);

}
