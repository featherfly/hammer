
package cn.featherfly.hammer.expression.entity.condition.nin;

import java.util.Collection;
import java.util.Date;

import cn.featherfly.common.lang.function.ReturnDateFunction;
import cn.featherfly.common.lang.function.ReturnEnumFunction;
import cn.featherfly.common.lang.function.ReturnLocalDateFunction;
import cn.featherfly.common.lang.function.ReturnLocalDateTimeFunction;
import cn.featherfly.common.lang.function.ReturnLocalTimeFunction;
import cn.featherfly.common.lang.function.ReturnNumberFunction;
import cn.featherfly.common.lang.function.ReturnStringFunction;
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
            ReturnNumberFunction<E, R> name);

    /**
     * entity not in function property expression.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return entity not in function property expression.
     */
    <R extends Date> ConditionEntityExpressionDateAndArrayPropertyExpression<R> property(ReturnDateFunction<E, R> name);

    /**
     * entity not in function property expression.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return entity not in function property expression.
     */
    <R extends Enum<R>> ConditionEntityExpressionEnumAndArrayPropertyExpression<R> property(
            ReturnEnumFunction<E, R> name);

    /**
     * entity not in function property expression.
     *
     * @param name the name
     * @return entity not in function property expression.
     */
    ConditionEntityExpressionLocalDateTimeAndArrayPropertyExpression property(ReturnLocalDateTimeFunction<E> name);

    /**
     * entity not in function property expression.
     *
     * @param name the name
     * @return entity not in function property expression.
     */
    ConditionEntityExpressionLocalDateAndArrayPropertyExpression property(ReturnLocalDateFunction<E> name);

    /**
     * entity not in function property expression.
     *
     * @param name the name
     * @return entity not in function property expression.
     */
    ConditionEntityExpressionLocalTimeAndArrayPropertyExpression property(ReturnLocalTimeFunction<E> name);

    /**
     * entity not in function property expression.
     *
     * @param name the name
     * @return entity not in function property expression.
     */
    ConditionEntityExpressionStringAndArrayPropertyExpression property(ReturnStringFunction<E> name);

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
