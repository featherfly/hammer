
package cn.featherfly.hammer.expression.entity.condition;

import java.util.Date;

import cn.featherfly.common.lang.function.ReturnDateFunction;
import cn.featherfly.common.lang.function.ReturnEnumFunction;
import cn.featherfly.common.lang.function.ReturnLocalDateFunction;
import cn.featherfly.common.lang.function.ReturnLocalDateTimeFunction;
import cn.featherfly.common.lang.function.ReturnLocalTimeFunction;
import cn.featherfly.common.lang.function.ReturnNumberFunction;
import cn.featherfly.common.lang.function.ReturnStringFunction;
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
    <R extends Date> ConditionEntityExpressionDatePropertyExpression<R> property(ReturnDateFunction<E, R> name);

    /**
     * entity great than function property expression.
     *
     * @param name the name
     * @return entity great than function property expression.
     */
    ConditionEntityExpressionLocalDatePropertyExpression property(ReturnLocalDateFunction<E> name);

    /**
     * entity great than function property expression.
     *
     * @param name the name
     * @return entity great than function property expression.
     */
    ConditionEntityExpressionLocalTimePropertyExpression property(ReturnLocalTimeFunction<E> name);

    /**
     * entity great than function property expression.
     *
     * @param name the name
     * @return entity great than function property expression.
     */
    ConditionEntityExpressionLocalDateTimePropertyExpression property(ReturnLocalDateTimeFunction<E> name);

    /**
     * entity great than function property expression.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return entity great than function property expression.
     */
    <R extends Number> ConditionEntityExpressionNumberPropertyExpression<R> property(ReturnNumberFunction<E, R> name);

    /**
     * entity great than function property expression.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return entity great than function property expression.
     */
    <R extends Enum<R>> ConditionEntityExpressionEnumPropertyExpression<R> property(ReturnEnumFunction<E, R> name);

    /**
     * entity great than function property expression.
     *
     * @param name the name
     * @return entity great than function property expression.
     */
    ConditionEntityExpressionStringPropertyExpression property(ReturnStringFunction<E> name);
}
