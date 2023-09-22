
package cn.featherfly.hammer.expression.entity.condition;

import java.util.Date;

import cn.featherfly.common.function.serializable.SerializableToDateFunction;
import cn.featherfly.common.function.serializable.SerializableToDoubleFunction;
import cn.featherfly.common.function.serializable.SerializableToIntFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalDateFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalDateTimeFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalTimeFunction;
import cn.featherfly.common.function.serializable.SerializableToLongFunction;
import cn.featherfly.common.function.serializable.SerializableToNumberFunction;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;

/**
 * The Interface CompareEntityValuePropertyExpression.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface CompareEntityValuePropertyExpression<E> {

    /**
     * entity great than function property expression.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return entity great than function property expression.
     */
    ConditionEntityExpressionIntPropertyExpression property(SerializableToIntFunction<E> name);

    /**
     * entity great than function property expression.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return entity great than function property expression.
     */
    ConditionEntityExpressionLongPropertyExpression property(SerializableToLongFunction<E> name);

    /**
     * entity great than function property expression.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return entity great than function property expression.
     */
    ConditionEntityExpressionDoublePropertyExpression property(SerializableToDoubleFunction<E> name);

    /**
     * entity great than function property expression.
     *
     * @param <D>  the generic type
     * @param name the name
     * @return entity great than function property expression.
     */
    <D extends Date> ConditionEntityExpressionDatePropertyExpression<D> property(SerializableToDateFunction<E, D> name);

    /**
     * entity great than function property expression.
     *
     * @param name the name
     * @return entity great than function property expression.
     */
    ConditionEntityExpressionLocalDatePropertyExpression property(SerializableToLocalDateFunction<E> name);

    /**
     * entity great than function property expression.
     *
     * @param name the name
     * @return entity great than function property expression.
     */
    ConditionEntityExpressionLocalTimePropertyExpression property(SerializableToLocalTimeFunction<E> name);

    /**
     * entity great than function property expression.
     *
     * @param name the name
     * @return entity great than function property expression.
     */
    ConditionEntityExpressionLocalDateTimePropertyExpression property(SerializableToLocalDateTimeFunction<E> name);

    /**
     * entity great than function property expression.
     *
     * @param <N>  the generic type
     * @param name the name
     * @return entity great than function property expression.
     */
    <N extends Number> ConditionEntityExpressionNumberPropertyExpression<N> property(
            SerializableToNumberFunction<E, N> name);

    //    /**
    //     * entity great than function property expression.
    //     *
    //     * @param <R>  the generic type
    //     * @param name the name
    //     * @return entity great than function property expression.
    //     */
    //    <R extends Enum<R>> ConditionEntityExpressionEnumPropertyExpression<R> property(
    //            SerializableToEnumFunction<E, R> name);

    /**
     * entity great than function property expression.
     *
     * @param name the name
     * @return entity great than function property expression.
     */
    ConditionEntityExpressionStringPropertyExpression property(SerializableToStringFunction<E> name);
}
