
package cn.featherfly.hammer.expression.entity.condition.nin;

import java.util.Collection;
import java.util.Date;

import cn.featherfly.common.lang.function.SerializableToDateFunction;
import cn.featherfly.common.lang.function.SerializableToEnumFunction;
import cn.featherfly.common.lang.function.SerializableToLocalDateFunction;
import cn.featherfly.common.lang.function.SerializableToLocalDateTimeFunction;
import cn.featherfly.common.lang.function.SerializableToLocalTimeFunction;
import cn.featherfly.common.lang.function.SerializableToNumberFunction;
import cn.featherfly.common.lang.function.SerializableToStringFunction;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableToCollectionFunction;
import cn.featherfly.common.lang.function.SerializableToDoubleFunction;
import cn.featherfly.common.lang.function.SerializableToIntFunction;
import cn.featherfly.common.lang.function.SerializableToLongFunction;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionDateAndArrayPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionDoubleAndArrayPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionEnumAndArrayPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionIntAndArrayPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionLocalDateAndArrayPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionLocalDateTimeAndArrayPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionLocalTimeAndArrayPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionLongAndArrayPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionNumberAndArrayPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionStringAndArrayPropertyExpression;

/**
 * The Interface NotInEntityPropertyExpression.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface NotInEntityPropertyExpression<E> {

    /**
     * entity not in function int and int array property expression.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return entity not in function property expression.
     */
    <R> ConditionEntityExpressionIntAndArrayPropertyExpression property(SerializableToIntFunction<E> name);

    /**
     * entity not in function property expression.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return entity not in function property expression.
     */
    <R> ConditionEntityExpressionLongAndArrayPropertyExpression property(SerializableToLongFunction<E> name);

    /**
     * entity not in function property expression.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return entity not in function property expression.
     */
    <R> ConditionEntityExpressionDoubleAndArrayPropertyExpression property(SerializableToDoubleFunction<E> name);

    /**
     * entity not in function property expression.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return entity not in function property expression.
     */
    <R extends Number> ConditionEntityExpressionNumberAndArrayPropertyExpression<R> property(
            SerializableToNumberFunction<E, R> name);

    /**
     * entity not in function property expression.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return entity not in function property expression.
     */
    <R extends Date> ConditionEntityExpressionDateAndArrayPropertyExpression<R> property(SerializableToDateFunction<E, R> name);

    /**
     * entity not in function property expression.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return entity not in function property expression.
     */
    <R extends Enum<R>> ConditionEntityExpressionEnumAndArrayPropertyExpression<R> property(
            SerializableToEnumFunction<E, R> name);

    /**
     * entity not in function property expression.
     *
     * @param name the name
     * @return entity not in function property expression.
     */
    ConditionEntityExpressionLocalDateTimeAndArrayPropertyExpression property(SerializableToLocalDateTimeFunction<E> name);

    /**
     * entity not in function property expression.
     *
     * @param name the name
     * @return entity not in function property expression.
     */
    ConditionEntityExpressionLocalDateAndArrayPropertyExpression property(SerializableToLocalDateFunction<E> name);

    /**
     * entity not in function property expression.
     *
     * @param name the name
     * @return entity not in function property expression.
     */
    ConditionEntityExpressionLocalTimeAndArrayPropertyExpression property(SerializableToLocalTimeFunction<E> name);

    /**
     * entity not in function property expression.
     *
     * @param name the name
     * @return entity not in function property expression.
     */
    ConditionEntityExpressionStringAndArrayPropertyExpression property(SerializableToStringFunction<E> name);

    /**
     * entity not in function property expression.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return entity not in function property expression.
     */
    <R> NotInEntityPropertyExpression<R> property(SerializableFunction<E, R> name);

    /**
     * entity not in function property expression.
     *
     * @param <R>  the generic type
     * @param <RE> the generic type
     * @param name the name
     * @return entity not in function property expression.
     */
    <R extends Collection<RE>,
            RE> NotInEntityPropertyExpression<RE> property(SerializableToCollectionFunction<E, R, RE> name);
}
