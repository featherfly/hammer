
package cn.featherfly.hammer.dsl.entity;

import cn.featherfly.common.function.serializable.SerializableFunction1;
import cn.featherfly.common.function.serializable.SerializableFunction2;

/**
 * entity join on expression.
 *
 * @author zhongj
 * @param <E> the query type
 * @param <J> the join type
 * @param <R> the after on expression type
 */
public interface EntityOnExpression<E, J, R> {

    /**
     * On.
     *
     * @param <P>          the generic type
     * @param propertyName the property name
     * @return the re
     */
    <P> R on(SerializableFunction1<E, P> propertyName);

    /**
     * On.
     *
     * @param <P>                  the generic type
     * @param joinTypePropertyName the join type property name
     * @return the re
     */
    <P> R on(SerializableFunction2<J, P> joinTypePropertyName);

    /**
     * On.
     *
     * @param <P>                  the generic type
     * @param propertyName         the property name
     * @param joinTypePropertyName the join type property name
     * @return the re
     */
    <P> R on(SerializableFunction1<E, P> propertyName, SerializableFunction2<J, P> joinTypePropertyName);

}
