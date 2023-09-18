
package cn.featherfly.hammer.expression.entity.condition;

import java.util.Date;

import cn.featherfly.common.function.serializable.SerializableToDateFunction;
import cn.featherfly.common.function.serializable.SerializableToDoubleFunction;
import cn.featherfly.common.function.serializable.SerializableToEnumFunction;
import cn.featherfly.common.function.serializable.SerializableToIntFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalDateFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalDateTimeFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalTimeFunction;
import cn.featherfly.common.function.serializable.SerializableToLongFunction;
import cn.featherfly.common.function.serializable.SerializableToNumberFunction;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;

/**
 * The Interface BetweenAndEntityValuePropertyExpression.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface BetweenAndEntityValuePropertyExpression<E> {

    /**
     * entity great than function property expression.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return entity great than function property expression.
     */
    <R> ConditionEntityExpressionIntPropertyExpression2 property(SerializableToIntFunction<E> name);

    /**
     * entity great than function property expression.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return entity great than function property expression.
     */
    <R> ConditionEntityExpressionLongPropertyExpression2 property(SerializableToLongFunction<E> name);

    /**
     * entity great than function property expression.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return entity great than function property expression.
     */
    <R> ConditionEntityExpressionDoublePropertyExpression2 property(SerializableToDoubleFunction<E> name);

    /**
     * entity great than function property expression.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return entity great than function property expression.
     */
    <R extends Date> ConditionEntityExpressionDatePropertyExpression2<R> property(
            SerializableToDateFunction<E, R> name);

    /**
     * entity great than function property expression.
     *
     * @param name the name
     * @return entity great than function property expression.
     */
    ConditionEntityExpressionLocalDatePropertyExpression2 property(SerializableToLocalDateFunction<E> name);

    /**
     * entity great than function property expression.
     *
     * @param name the name
     * @return entity great than function property expression.
     */
    ConditionEntityExpressionLocalTimePropertyExpression2 property(SerializableToLocalTimeFunction<E> name);

    /**
     * entity great than function property expression.
     *
     * @param name the name
     * @return entity great than function property expression.
     */
    ConditionEntityExpressionLocalDateTimePropertyExpression2 property(SerializableToLocalDateTimeFunction<E> name);

    /**
     * entity great than function property expression.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return entity great than function property expression.
     */
    <R extends Number> ConditionEntityExpressionNumberPropertyExpression2<R> property(
            SerializableToNumberFunction<E, R> name);

    /**
     * entity great than function property expression.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return entity great than function property expression.
     */
    <R extends Enum<R>> ConditionEntityExpressionEnumPropertyExpression2<R> property(
            SerializableToEnumFunction<E, R> name);

    /**
     * entity great than function property expression.
     *
     * @param name the name
     * @return entity great than function property expression.
     */
    ConditionEntityExpressionStringPropertyExpression2 property(SerializableToStringFunction<E> name);
}
