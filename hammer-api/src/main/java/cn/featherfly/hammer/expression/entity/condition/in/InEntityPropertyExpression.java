
package cn.featherfly.hammer.expression.entity.condition.in;

import java.util.Collection;
import java.util.Date;

import cn.featherfly.common.function.serializable.SerializableToDateFunction;
import cn.featherfly.common.function.serializable.SerializableToEnumFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalDateFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalDateTimeFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalTimeFunction;
import cn.featherfly.common.function.serializable.SerializableToNumberFunction;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableToCollectionFunction;
import cn.featherfly.common.function.serializable.SerializableToDoubleFunction;
import cn.featherfly.common.function.serializable.SerializableToIntFunction;
import cn.featherfly.common.function.serializable.SerializableToLongFunction;
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
 * The Interface InEntityPropertyExpression.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface InEntityPropertyExpression<E> {

    /**
     * entity in function int and int array property expression.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return entity in function property expression.
     */
    <R> ConditionEntityExpressionIntAndArrayPropertyExpression property(SerializableToIntFunction<E> name);

    /**
     * entity in function property expression.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return entity in function property expression.
     */
    <R> ConditionEntityExpressionLongAndArrayPropertyExpression property(SerializableToLongFunction<E> name);

    /**
     * entity in function property expression.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return entity in function property expression.
     */
    <R> ConditionEntityExpressionDoubleAndArrayPropertyExpression property(SerializableToDoubleFunction<E> name);

    /**
     * entity in function property expression.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return entity in function property expression.
     */
    <R extends Number> ConditionEntityExpressionNumberAndArrayPropertyExpression<R> property(
            SerializableToNumberFunction<E, R> name);

    /**
     * entity in function property expression.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return entity in function property expression.
     */
    <R extends Date> ConditionEntityExpressionDateAndArrayPropertyExpression<R> property(SerializableToDateFunction<E, R> name);

    /**
     * entity in function property expression.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return entity in function property expression.
     */
    <R extends Enum<R>> ConditionEntityExpressionEnumAndArrayPropertyExpression<R> property(
            SerializableToEnumFunction<E, R> name);

    /**
     * entity in function property expression.
     *
     * @param name the name
     * @return entity in function property expression.
     */
    ConditionEntityExpressionLocalDateTimeAndArrayPropertyExpression property(SerializableToLocalDateTimeFunction<E> name);

    /**
     * entity in function property expression.
     *
     * @param name the name
     * @return entity in function property expression.
     */
    ConditionEntityExpressionLocalDateAndArrayPropertyExpression property(SerializableToLocalDateFunction<E> name);

    /**
     * entity in function property expression.
     *
     * @param name the name
     * @return entity in function property expression.
     */
    ConditionEntityExpressionLocalTimeAndArrayPropertyExpression property(SerializableToLocalTimeFunction<E> name);

    /**
     * entity in function property expression.
     *
     * @param name the name
     * @return entity in function property expression.
     */
    ConditionEntityExpressionStringAndArrayPropertyExpression property(SerializableToStringFunction<E> name);

    /**
     * entity in function property expression.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return entity in function property expression.
     */
    <R> InEntityPropertyExpression<R> property(SerializableFunction<E, R> name);

    /**
     * entity in function property expression.
     *
     * @param <R>  the generic type
     * @param <RE> the generic type
     * @param name the name
     * @return entity in function property expression.
     */
    <R extends Collection<RE>,
            RE> InEntityPropertyExpression<RE> property(SerializableToCollectionFunction<E, R, RE> name);

}
