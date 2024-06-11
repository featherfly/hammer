
package cn.featherfly.hammer.expression.condition.gt;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableDateSupplier;
import cn.featherfly.common.function.serializable.SerializableDoubleSupplier;
import cn.featherfly.common.function.serializable.SerializableEnumSupplier;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableIntSupplier;
import cn.featherfly.common.function.serializable.SerializableLocalDateSupplier;
import cn.featherfly.common.function.serializable.SerializableLocalDateTimeSupplier;
import cn.featherfly.common.function.serializable.SerializableLocalTimeSupplier;
import cn.featherfly.common.function.serializable.SerializableLongSupplier;
import cn.featherfly.common.function.serializable.SerializableNumberSupplier;
import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.function.serializable.SerializableToDoubleFunction;
import cn.featherfly.common.function.serializable.SerializableToIntFunction;
import cn.featherfly.common.function.serializable.SerializableToLongFunction;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.AliasField;
import cn.featherfly.common.repository.Field;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * muliti great than expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface MulitiGreatThanExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends ConditionExpression {

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L gt(int index, String name, int value);

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(int index, String name, int value, IntPredicate ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L gt(int index, String name, long value);

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(int index, String name, long value, LongPredicate ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L gt(int index, String name, double value);

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(int index, String name, double value, DoublePredicate ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param <N> number type
     * @param index the index
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    <N extends Number> L gt(int index, String name, N value);

    /**
     * great than. 大于.
     *
     * @param <N> number type
     * @param index the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L gt(int index, String name, N value, Predicate<N> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param <E> the element type
     * @param index the index
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    <E extends Enum<E>> L gt(int index, String name, E value);

    /**
     * great than. 大于.
     *
     * @param <E> the element type
     * @param index the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E extends Enum<E>> L gt(int index, String name, E value, Predicate<E> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param <D> date type
     * @param index the index
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    <D extends Date> L gt(int index, String name, D value);

    /**
     * great than. 大于.
     *
     * @param <D> date type
     * @param index the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L gt(int index, String name, D value, Predicate<D> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L gt(int index, String name, LocalTime value);

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(int index, String name, LocalTime value, Predicate<LocalTime> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L gt(int index, String name, LocalDate value);

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(int index, String name, LocalDate value, Predicate<LocalDate> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    L gt(int index, String name, LocalDateTime value);

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(int index, String name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    default L gt(int index, String name, String value) {
        return gt(index, name, value, MatchStrategy.AUTO);
    }

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(int index, String name, String value, Predicate<String> ignoreStrategy) {
        return gt(index, name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param name the name
     * @param value the value
     * @param mathMatchStrategy the math match strategy
     * @return LogicExpression
     */
    L gt(int index, String name, String value, MatchStrategy mathMatchStrategy);

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param name the name
     * @param value the value
     * @param mathMatchStrategy the math match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(int index, String name, String value, MatchStrategy mathMatchStrategy, Predicate<String> ignoreStrategy);

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L gt(int index, Field field, int value) {
        return gt(index, field.name(), value);
    }

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(int index, Field field, int value, IntPredicate ignoreStrategy) {
        return gt(index, field.name(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L gt(int index, Field field, long value) {
        return gt(index, field.name(), value);
    }

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(int index, Field field, long value, LongPredicate ignoreStrategy) {
        return gt(index, field.name(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L gt(int index, Field field, double value) {
        return gt(index, field.name(), value);
    }

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(int index, Field field, double value, DoublePredicate ignoreStrategy) {
        return gt(index, field.name(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param <N> number type
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <N extends Number> L gt(int index, Field field, N value) {
        return gt(index, field.name(), value);
    }

    /**
     * great than. 大于.
     *
     * @param <N> number type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L gt(int index, Field field, N value, Predicate<N> ignoreStrategy) {
        return gt(index, field.name(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param <E> the element type
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <E extends Enum<E>> L gt(int index, Field field, E value) {
        return gt(index, field.name(), value);
    }

    /**
     * great than. 大于.
     *
     * @param <E> the element type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E extends Enum<E>> L gt(int index, Field field, E value, Predicate<E> ignoreStrategy) {
        return gt(index, field.name(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param <D> date type
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <D extends Date> L gt(int index, Field field, D value) {
        return gt(index, field.name(), value);
    }

    /**
     * great than. 大于.
     *
     * @param <D> date type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L gt(int index, Field field, D value, Predicate<D> ignoreStrategy) {
        return gt(index, field.name(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L gt(int index, Field field, LocalTime value) {
        return gt(index, field.name(), value);
    }

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(int index, Field field, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return gt(index, field.name(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L gt(int index, Field field, LocalDate value) {
        return gt(index, field.name(), value);
    }

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(int index, Field field, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return gt(index, field.name(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L gt(int index, Field field, LocalDateTime value) {
        return gt(index, field.name(), value);
    }

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(int index, Field field, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return gt(index, field.name(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L gt(int index, Field field, String value) {
        return gt(index, field, value, MatchStrategy.AUTO);
    }

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(int index, Field field, String value, Predicate<String> ignoreStrategy) {
        return gt(index, field.name(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param mathMatchStrategy the math match strategy
     * @return LogicExpression
     */
    default L gt(int index, Field field, String value, MatchStrategy mathMatchStrategy) {
        return gt(index, field.name(), value, mathMatchStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param mathMatchStrategy the math match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(int index, Field field, String value, MatchStrategy mathMatchStrategy,
        Predicate<String> ignoreStrategy) {
        return gt(index, field.name(), value, ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L gt(int index, AliasField field, int value) {
        return gt(index, field.getAliasOrName(), value);
    }

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(int index, AliasField field, int value, IntPredicate ignoreStrategy) {
        return gt(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L gt(int index, AliasField field, long value) {
        return gt(index, field.getAliasOrName(), value);
    }

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(int index, AliasField field, long value, LongPredicate ignoreStrategy) {
        return gt(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L gt(int index, AliasField field, double value) {
        return gt(index, field.getAliasOrName(), value);
    }

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(int index, AliasField field, double value, DoublePredicate ignoreStrategy) {
        return gt(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param <N> number type
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <N extends Number> L gt(int index, AliasField field, N value) {
        return gt(index, field.getAliasOrName(), value);
    }

    /**
     * great than. 大于.
     *
     * @param <N> number type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <N extends Number> L gt(int index, AliasField field, N value, Predicate<N> ignoreStrategy) {
        return gt(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param <E> the element type
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <E extends Enum<E>> L gt(int index, AliasField field, E value) {
        return gt(index, field.getAliasOrName(), value);
    }

    /**
     * great than. 大于.
     *
     * @param <E> the element type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E extends Enum<E>> L gt(int index, AliasField field, E value, Predicate<E> ignoreStrategy) {
        return gt(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param <D> date type
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <D extends Date> L gt(int index, AliasField field, D value) {
        return gt(index, field.getAliasOrName(), value);
    }

    /**
     * great than. 大于.
     *
     * @param <D> date type
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <D extends Date> L gt(int index, AliasField field, D value, Predicate<D> ignoreStrategy) {
        return gt(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L gt(int index, AliasField field, LocalTime value) {
        return gt(index, field.getAliasOrName(), value);
    }

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(int index, AliasField field, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        return gt(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L gt(int index, AliasField field, LocalDate value) {
        return gt(index, field.getAliasOrName(), value);
    }

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(int index, AliasField field, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        return gt(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L gt(int index, AliasField field, LocalDateTime value) {
        return gt(index, field.getAliasOrName(), value);
    }

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(int index, AliasField field, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return gt(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L gt(int index, AliasField field, String value) {
        return gt(index, field, value, MatchStrategy.AUTO);
    }

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(int index, AliasField field, String value, Predicate<String> ignoreStrategy) {
        return gt(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param mathMatchStrategy the math match strategy
     * @return LogicExpression
     */
    default L gt(int index, AliasField field, String value, MatchStrategy mathMatchStrategy) {
        return gt(index, field.getAliasOrName(), value, mathMatchStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param field the field
     * @param value the value
     * @param mathMatchStrategy the math match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(int index, AliasField field, String value, MatchStrategy mathMatchStrategy,
        Predicate<String> ignoreStrategy) {
        return gt(index, field.getAliasOrName(), value, ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * great than. 大于.
     *
     * @param <E> the element type
     * @param index the index
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    <E> L gt(int index, SerializableToIntFunction<E> name, int value);

    /**
     * great than. 大于.
     *
     * @param <E> the element type
     * @param index the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L gt(int index, SerializableToIntFunction<E> name, int value, IntPredicate ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param <E> the element type
     * @param index the index
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    <E> L gt(int index, SerializableToLongFunction<E> name, long value);

    /**
     * great than. 大于.
     *
     * @param <E> the element type
     * @param index the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L gt(int index, SerializableToLongFunction<E> name, long value, LongPredicate ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param <E> the element type
     * @param index the index
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    <E> L gt(int index, SerializableToDoubleFunction<E> name, double value);

    /**
     * great than. 大于.
     *
     * @param <E> the element type
     * @param index the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L gt(int index, SerializableToDoubleFunction<E> name, double value, DoublePredicate ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param <E> the element type
     * @param <N> number type
     * @param index the index
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    <E, N extends Number> L gt(int index, SerializableFunction<E, N> name, N value);

    /**
     * great than. 大于.
     *
     * @param <E> the element type
     * @param <N> number type
     * @param index the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E, N extends Number> L gt(int index, SerializableFunction<E, N> name, N value, Predicate<N> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param <T> the generic type
     * @param <E> the element type
     * @param index the index
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    <T, E extends Enum<E>> L gt(int index, SerializableFunction<T, E> name, E value);

    /**
     * great than. 大于.
     *
     * @param <T> the generic type
     * @param <E> the element type
     * @param index the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <T, E extends Enum<E>> L gt(int index, SerializableFunction<T, E> name, E value, Predicate<E> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param <E> the element type
     * @param <D> date type
     * @param index the index
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    <E, D extends Date> L gt(int index, SerializableFunction<E, D> name, D value);

    /**
     * great than. 大于.
     *
     * @param <E> the element type
     * @param <D> date type
     * @param index the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E, D extends Date> L gt(int index, SerializableFunction<E, D> name, D value, Predicate<D> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param <E> the element type
     * @param index the index
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    <E> L gt(int index, SerializableFunction<E, LocalTime> name, LocalTime value);

    /**
     * great than. 大于.
     *
     * @param <E> the element type
     * @param index the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L gt(int index, SerializableFunction<E, LocalTime> name, LocalTime value, Predicate<LocalTime> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param <E> the element type
     * @param index the index
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    <E> L gt(int index, SerializableFunction<E, LocalDate> name, LocalDate value);

    /**
     * great than. 大于.
     *
     * @param <E> the element type
     * @param index the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L gt(int index, SerializableFunction<E, LocalDate> name, LocalDate value, Predicate<LocalDate> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param <E> the element type
     * @param index the index
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    <E> L gt(int index, SerializableFunction<E, LocalDateTime> name, LocalDateTime value);

    /**
     * great than. 大于.
     *
     * @param <E> the element type
     * @param index the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L gt(int index, SerializableFunction<E, LocalDateTime> name, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param <E> the element type
     * @param index the index
     * @param name the name
     * @param value the value
     * @return LogicExpression
     */
    default <E> L gt(int index, SerializableFunction<E, String> name, String value) {
        return gt(index, name, value, MatchStrategy.AUTO);
    }

    /**
     * great than. 大于.
     *
     * @param <E> the element type
     * @param index the index
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E> L gt(int index, SerializableFunction<E, String> name, String value, Predicate<String> ignoreStrategy) {
        return gt(index, name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param <E> the element type
     * @param index the index
     * @param name the name
     * @param value the value
     * @param mathMatchStrategy the math match strategy
     * @return LogicExpression
     */
    <E> L gt(int index, SerializableFunction<E, String> name, String value, MatchStrategy mathMatchStrategy);

    /**
     * great than. 大于.
     *
     * @param <E> the element type
     * @param index the index
     * @param name the name
     * @param value the value
     * @param mathMatchStrategy the math match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E> L gt(int index, SerializableFunction<E, String> name, String value, MatchStrategy mathMatchStrategy,
        Predicate<String> ignoreStrategy);

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param property bean property
     * @return LogicExpression
     */
    default L gt(int index, SerializableIntSupplier property) {
        return gt(index, property, property.get());
    }

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(int index, SerializableIntSupplier property, IntPredicate ignoreStrategy) {
        return gt(index, property, property.get(), ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param property bean property
     * @return LogicExpression
     */
    default L gt(int index, SerializableLongSupplier property) {
        return gt(index, property, property.get());
    }

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(int index, SerializableLongSupplier property, LongPredicate ignoreStrategy) {
        return gt(index, property, property.get(), ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param property bean property
     * @return LogicExpression
     */
    default L gt(int index, SerializableDoubleSupplier property) {
        return gt(index, property, property.get());
    }

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(int index, SerializableDoubleSupplier property, DoublePredicate ignoreStrategy) {
        return gt(index, property, property.get(), ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param <R> the generic type
     * @param index the index
     * @param property bean property
     * @return LogicExpression
     */
    default <R extends Date> L gt(int index, SerializableDateSupplier<R> property) {
        return gt(index, property, property.get());
    }

    /**
     * great than. 大于.
     *
     * @param <R> the generic type
     * @param index the index
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R extends Date> L gt(int index, SerializableDateSupplier<R> property, Predicate<R> ignoreStrategy) {
        return gt(index, property, property.get(), ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param <R> the generic type
     * @param index the index
     * @param property bean property
     * @return LogicExpression
     */
    default <R extends Number> L gt(int index, SerializableNumberSupplier<R> property) {
        return gt(index, property, property.get());
    }

    /**
     * great than. 大于.
     *
     * @param <R> the generic type
     * @param index the index
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R extends Number> L gt(int index, SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy) {
        return gt(index, property, property.get(), ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param <E> the element type
     * @param index the index
     * @param property bean property
     * @return LogicExpression
     */
    default <E extends Enum<E>> L gt(int index, SerializableEnumSupplier<E> property) {
        return gt(index, property, property.get());
    }

    /**
     * great than. 大于.
     *
     * @param <E> the element type
     * @param index the index
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E extends Enum<E>> L gt(int index, SerializableEnumSupplier<E> property, Predicate<E> ignoreStrategy) {
        return gt(index, property, property.get(), ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param property bean property
     * @return LogicExpression
     */
    default L gt(int index, SerializableLocalDateSupplier property) {
        return gt(index, property, property.get());
    }

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(int index, SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        return gt(index, property, property.get(), ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param property bean property
     * @return LogicExpression
     */
    default L gt(int index, SerializableLocalTimeSupplier property) {
        return gt(index, property, property.get());
    }

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(int index, SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        return gt(index, property, property.get(), ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param property bean property
     * @return LogicExpression
     */
    default L gt(int index, SerializableLocalDateTimeSupplier property) {
        return gt(index, property, property.get());
    }

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(int index, SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        return gt(index, property, property.get(), ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param property bean property
     * @return LogicExpression
     */
    default L gt(int index, SerializableStringSupplier property) {
        return gt(index, property, property.get());
    }

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(int index, SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return gt(index, property, property.get(), ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param property bean property
     * @param mathMatchStrategy the math match strategy
     * @return LogicExpression
     */
    default L gt(int index, SerializableStringSupplier property, MatchStrategy mathMatchStrategy) {
        return gt(index, property, property.get(), mathMatchStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param property bean property
     * @param mathMatchStrategy the math match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(int index, SerializableStringSupplier property, MatchStrategy mathMatchStrategy,
        Predicate<String> ignoreStrategy) {
        return gt(index, property, property.get(), mathMatchStrategy, ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    L gt(int index, SerializableIntSupplier property, int value);

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(int index, SerializableIntSupplier property, int value, IntPredicate ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    L gt(int index, SerializableLongSupplier property, long value);

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(int index, SerializableLongSupplier property, long value, LongPredicate ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    L gt(int index, SerializableDoubleSupplier property, double value);

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(int index, SerializableDoubleSupplier property, double value, DoublePredicate ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param <D> the generic type
     * @param index the index
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    <D extends Date> L gt(int index, SerializableDateSupplier<D> property, D value);

    /**
     * great than. 大于.
     *
     * @param <D> the generic type
     * @param index the index
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L gt(int index, SerializableDateSupplier<D> property, D value, Predicate<D> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param <N> the number type
     * @param index the index
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    <N extends Number> L gt(int index, SerializableNumberSupplier<N> property, N value);

    /**
     * great than. 大于.
     *
     * @param <N> the generic type
     * @param index the index
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L gt(int index, SerializableNumberSupplier<N> property, N value, Predicate<N> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param <E> the element type
     * @param index the index
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    <E extends Enum<E>> L gt(int index, SerializableEnumSupplier<E> property, E value);

    /**
     * great than. 大于.
     *
     * @param <E> the element type
     * @param index the index
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <E extends Enum<E>> L gt(int index, SerializableEnumSupplier<E> property, E value, Predicate<E> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    L gt(int index, SerializableLocalDateSupplier property, LocalDate value);

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(int index, SerializableLocalDateSupplier property, LocalDate value, Predicate<LocalDate> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    L gt(int index, SerializableLocalTimeSupplier property, LocalTime value);

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(int index, SerializableLocalTimeSupplier property, LocalTime value, Predicate<LocalTime> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    L gt(int index, SerializableLocalDateTimeSupplier property, LocalDateTime value);

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(int index, SerializableLocalDateTimeSupplier property, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy);

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    default L gt(int index, SerializableStringSupplier property, String value) {
        return gt(index, property, value, MatchStrategy.AUTO);
    }

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L gt(int index, SerializableStringSupplier property, String value, Predicate<String> ignoreStrategy) {
        return gt(index, property, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param property bean property
     * @param value the value
     * @param mathMatchStrategy the math match strategy
     * @return LogicExpression
     */
    L gt(int index, SerializableStringSupplier property, String value, MatchStrategy mathMatchStrategy);

    /**
     * great than. 大于.
     *
     * @param index the index
     * @param property bean property
     * @param value the value
     * @param mathMatchStrategy the math match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L gt(int index, SerializableStringSupplier property, String value, MatchStrategy mathMatchStrategy,
        Predicate<String> ignoreStrategy);
}