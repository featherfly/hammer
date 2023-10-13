
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
 * The Interface CompareEntityValuePropertyExpression.
 *
 * @author zhongj
 * @param <T> the element type
 */
public interface CompareEntityValuePropertyExpression<T> {

    /**
     * entity compare function property expression.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return entity compare function property expression.
     */
    ConditionEntityExpressionIntPropertyExpression property(SerializableToIntFunction<T> name);

    /**
     * entity compare function property expression.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return entity compare function property expression.
     */
    ConditionEntityExpressionLongPropertyExpression property(SerializableToLongFunction<T> name);

    /**
     * entity compare function property expression.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return entity compare function property expression.
     */
    ConditionEntityExpressionDoublePropertyExpression property(SerializableToDoubleFunction<T> name);

    /**
     * entity compare function property expression.
     *
     * @param <D>  the generic type
     * @param name the name
     * @return entity compare function property expression.
     */
    <D extends Date> ConditionEntityExpressionDatePropertyExpression<D> property(SerializableToDateFunction<T, D> name);

    /**
     * entity compare function property expression.
     *
     * @param name the name
     * @return entity compare function property expression.
     */
    ConditionEntityExpressionLocalDatePropertyExpression property(SerializableToLocalDateFunction<T> name);

    /**
     * entity compare function property expression.
     *
     * @param name the name
     * @return entity compare function property expression.
     */
    ConditionEntityExpressionLocalTimePropertyExpression property(SerializableToLocalTimeFunction<T> name);

    /**
     * entity compare function property expression.
     *
     * @param name the name
     * @return entity compare function property expression.
     */
    ConditionEntityExpressionLocalDateTimePropertyExpression property(SerializableToLocalDateTimeFunction<T> name);

    /**
     * entity compare function property expression.
     *
     * @param <N>  the generic type
     * @param name the name
     * @return entity compare function property expression.
     */
    <N extends Number> ConditionEntityExpressionNumberPropertyExpression<N> property(
            SerializableToNumberFunction<T, N> name);

    /**
     * entity compare function property expression.
     *
     * @param <N>  the generic type
     * @param name the name
     * @return entity compare function property expression.
     */
    <E extends Enum<E>> ConditionEntityExpressionEnumPropertyExpression<E> property(
            SerializableToEnumFunction<T, E> name);

    /**
     * entity compare function property expression.
     *
     * @param name the name
     * @return entity compare function property expression.
     */
    ConditionEntityExpressionStringPropertyExpression property(SerializableToStringFunction<T> name);
}
