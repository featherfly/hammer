
package cn.featherfly.hammer.expression.query.type;

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
 * @param <R8> the generic type
 * @param <R9> the generic type
 * @param <Q>  the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityQueryRelationExpression9<E, R1, R2, R3, R4, R5, R6, R7, R8, R9,
        Q extends EntityQueryEntityPropertiesExpression<E, Q, C, L>, C extends EntityConditionGroupExpression<E, C, L>,
        L extends EntityConditionGroupLogicExpression<E, C, L>> extends EntityQueryExpression<E, Q, C, L> {

    //    /**
    //     * relate to.
    //     *
    //     * @param propertyName find type object property name
    //     * @return TypeQueryWithOnExpression
    //     */
    //    default void relate(SerializableFunction<E, R9> propertyName) {
    //        join(propertyName);
    //    }
    //
    //    /**
    //     * join on.
    //     *
    //     * @param propertyName find type object property name
    //     * @return TypeQueryWithOnExpression
    //     */
    //    default void join(SerializableFunction<E, R9> propertyName) {
    //        throw new UnsupportedException();
    //    }
    //
    //    /**
    //     * relate to.
    //     *
    //     * @param propertyName find type object property name
    //     * @return TypeQueryWithOnExpression
    //     */
    //    default void relate(SerializableFunction2<R9, E> propertyName) {
    //        join(propertyName);
    //    }
    //
    //    /**
    //     * join on.
    //     *
    //     * @param propertyName find type object property name
    //     * @return TypeQueryWithOnExpression
    //     */
    //    default void join(SerializableFunction2<R9, E> propertyName) {
    //        throw new UnsupportedException();
    //    }
    //
    //    /**
    //     * relate to.
    //     *
    //     * @param propertyName find type object property name
    //     * @return TypeQueryWithOnExpression
    //     */
    //    default void relate(SerializableFunction1<E, E> propertyName) {
    //        join(propertyName);
    //    }
    //
    //    /**
    //     * join on.
    //     *
    //     * @param propertyName find type object property name
    //     * @return TypeQueryWithOnExpression
    //     */
    //    default void join(SerializableFunction1<E, E> propertyName) {
    //        throw new UnsupportedException();
    //    }
    //
    //    /**
    //     * relate to.
    //     *
    //     * @param propertyName with type object property name
    //     * @param index        with index
    //     * @return TypeQueryWithOnExpression
    //     */
    //    default void relate(SerializableFunction<E, R9> propertyName, int index) {
    //        join(propertyName, index);
    //    }
    //
    //    /**
    //     * join on.
    //     *
    //     * @param propertyName with type object property name
    //     * @param index        with index
    //     * @return TypeQueryWithOnExpression
    //     */
    //    default void join(SerializableFunction<E, R9> propertyName, int index) {
    //        throw new UnsupportedException();
    //    }

}
