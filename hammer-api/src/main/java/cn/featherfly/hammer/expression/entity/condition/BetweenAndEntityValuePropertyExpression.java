
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

    // ****************************************************************************************************************
    //	value
    // ****************************************************************************************************************

    //    /**
    //     * min and max value.
    //     *
    //     * @param min the min
    //     * @param max the max
    //     * @return LogicExpression
    //     */
    //    void value(int min, int max);
    //
    //    /**
    //     * min and max value.
    //     *
    //     * @param min            the min
    //     * @param max            the max
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    void value(int min, int max, BiPredicate<Integer, Integer> ignoreStrategy);
    //
    //    /**
    //     * min and max value.
    //     *
    //     * @param min the min
    //     * @param max the max
    //     * @return LogicExpression
    //     */
    //    void value(long min, long max);
    //
    //    /**
    //     * min and max value.
    //     *
    //     * @param min            the min
    //     * @param max            the max
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    void value(long min, long max, BiPredicate<Long, Long> ignoreStrategy);
    //
    //    /**
    //     * min and max value.
    //     *
    //     * @param min the min
    //     * @param max the max
    //     * @return LogicExpression
    //     */
    //    void value(double min, double max);
    //
    //    /**
    //     * min and max value.
    //     *
    //     * @param min            the min
    //     * @param max            the max
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    void value(double min, double max, BiPredicate<Double, Double> ignoreStrategy);
    //
    //    /**
    //     * min and max value.
    //     *
    //     * @param <N> number type
    //     * @param min the min
    //     * @param max the max
    //     * @return LogicExpression
    //     */
    //    <N extends Number> void value(N min, N max);
    //
    //    /**
    //     * min and max value.
    //     *
    //     * @param <N>            number type
    //     * @param min            the min
    //     * @param max            the max
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    <N extends Number> void value(N min, N max, BiPredicate<N, N> ignoreStrategy);
    //
    //    /**
    //     * min and max value.
    //     *
    //     * @param <D> date type
    //     * @param min the min
    //     * @param max the max
    //     * @return LogicExpression
    //     */
    //    <D extends Date> void value(D min, D max);
    //
    //    /**
    //     * min and max value.
    //     *
    //     * @param <D>            date type
    //     * @param min            the min
    //     * @param max            the max
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    <D extends Date> void value(D min, D max, BiPredicate<D, D> ignoreStrategy);
    //
    //    /**
    //     * min and max value.
    //     *
    //     * @param min the min
    //     * @param max the max
    //     * @return LogicExpression
    //     */
    //    void value(LocalTime min, LocalTime max);
    //
    //    /**
    //     * min and max value.
    //     *
    //     * @param min            the min
    //     * @param max            the max
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    void value(LocalTime min, LocalTime max, BiPredicate<LocalTime, LocalTime> ignoreStrategy);
    //
    //    /**
    //     * min and max value.
    //     *
    //     * @param min the min
    //     * @param max the max
    //     * @return LogicExpression
    //     */
    //    void value(LocalDate min, LocalDate max);
    //
    //    /**
    //     * min and max value.
    //     *
    //     * @param min            the min
    //     * @param max            the max
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    void value(LocalDate min, LocalDate max, BiPredicate<LocalDate, LocalDate> ignoreStrategy);
    //
    //    /**
    //     * min and max value.
    //     *
    //     * @param min the min
    //     * @param max the max
    //     * @return LogicExpression
    //     */
    //    void value(LocalDateTime min, LocalDateTime max);
    //
    //    /**
    //     * min and max value.
    //     *
    //     * @param min            the min
    //     * @param max            the max
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    void value(LocalDateTime min, LocalDateTime max, BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy);
    //
    //    /**
    //     * min and max value.
    //     *
    //     * @param min the min
    //     * @param max the max
    //     * @return LogicExpression
    //     */
    //    void value(String min, String max);
    //
    //    /**
    //     * min and max value.
    //     *
    //     * @param min            the min
    //     * @param max            the max
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    void value(String min, String max, BiPredicate<String, String> ignoreStrategy);
}
