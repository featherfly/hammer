
package cn.featherfly.hammer.expression.entity.condition;

import java.util.Date;

import cn.featherfly.common.lang.function.SerializableToDateFunction;
import cn.featherfly.common.lang.function.SerializableToEnumFunction;
import cn.featherfly.common.lang.function.SerializableToLocalDateFunction;
import cn.featherfly.common.lang.function.SerializableToLocalDateTimeFunction;
import cn.featherfly.common.lang.function.SerializableToLocalTimeFunction;
import cn.featherfly.common.lang.function.SerializableToNumberFunction;
import cn.featherfly.common.lang.function.SerializableToStringFunction;
import cn.featherfly.common.lang.function.SerializableToDoubleFunction;
import cn.featherfly.common.lang.function.SerializableToIntFunction;
import cn.featherfly.common.lang.function.SerializableToLongFunction;

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
    <R> ConditionEntityExpressionIntPropertyExpression property(SerializableToIntFunction<E> name);

    /**
     * entity great than function property expression.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return entity great than function property expression.
     */
    <R> ConditionEntityExpressionLongPropertyExpression property(SerializableToLongFunction<E> name);

    /**
     * entity great than function property expression.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return entity great than function property expression.
     */
    <R> ConditionEntityExpressionDoublePropertyExpression property(SerializableToDoubleFunction<E> name);

    /**
     * entity great than function property expression.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return entity great than function property expression.
     */
    <R extends Date> ConditionEntityExpressionDatePropertyExpression<R> property(SerializableToDateFunction<E, R> name);

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
     * @param <R>  the generic type
     * @param name the name
     * @return entity great than function property expression.
     */
    <R extends Number> ConditionEntityExpressionNumberPropertyExpression<R> property(SerializableToNumberFunction<E, R> name);

    /**
     * entity great than function property expression.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return entity great than function property expression.
     */
    <R extends Enum<R>> ConditionEntityExpressionEnumPropertyExpression<R> property(SerializableToEnumFunction<E, R> name);

    /**
     * entity great than function property expression.
     *
     * @param name the name
     * @return entity great than function property expression.
     */
    ConditionEntityExpressionStringPropertyExpression property(SerializableToStringFunction<E> name);
}
