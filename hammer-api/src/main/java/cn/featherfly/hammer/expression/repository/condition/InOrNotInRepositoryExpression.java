package cn.featherfly.hammer.expression.repository.condition;

import java.util.Collection;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.Field;

/**
 * The Interface InNotInRepositoryExpression.
 *
 * @author zhongj
 */
public interface InOrNotInRepositoryExpression extends InOrNotInRepositoryFieldExpression {

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param <R>   the generic type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <R> void accept(String name, R value);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param <R>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> void accept(String name, R value, Predicate<R> ignoreStrategy);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    void accept(String name, String value, MatchStrategy matchStrategy);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    void accept(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    void accept(String name, int value);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    void accept(String name, int value, IntPredicate ignoreStrategy);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    void accept(String name, long value);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    void accept(String name, long value, LongPredicate ignoreStrategy);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    void accept(String name, double value);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    void accept(String name, double value, DoublePredicate ignoreStrategy);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param <R>   the generic type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <R> void accept(String name, @SuppressWarnings("unchecked") R... value);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    void accept(String name, String[] value, MatchStrategy matchStrategy);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    void accept(String name, String[] value, MatchStrategy matchStrategy, Predicate<String[]> ignoreStrategy);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    void accept(String name, int... value);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    void accept(String name, long... value);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param <R>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> void accept(String name, R[] value, Predicate<R[]> ignoreStrategy);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    void accept(String name, int[] value, Predicate<int[]> ignoreStrategy);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    void accept(String name, long[] value, Predicate<long[]> ignoreStrategy);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param <R>   the generic type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    <R> void accept(String name, Collection<R> value);

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param <R>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> void accept(String name, Collection<R> value, Predicate<Collection<R>> ignoreStrategy);

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param <R>   the generic type
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <R> void accept(Field field, R value) {
        accept(field.name(), value);
    }

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param <R>            the generic type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R> void accept(Field field, R value, Predicate<R> ignoreStrategy) {
        accept(field.name(), value, ignoreStrategy);
    }

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param field         the field
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default void accept(Field field, String value, MatchStrategy matchStrategy) {
        accept(field.name(), value, matchStrategy);
    }

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default void accept(Field field, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        accept(field.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default void accept(Field field, int value) {
        accept(field.name(), value);
    }

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default void accept(Field field, int value, IntPredicate ignoreStrategy) {
        accept(field.name(), value, ignoreStrategy);
    }

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default void accept(Field field, long value) {
        accept(field.name(), value);
    }

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default void accept(Field field, long value, LongPredicate ignoreStrategy) {
        accept(field.name(), value, ignoreStrategy);
    }

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default void accept(Field field, double value) {
        accept(field.name(), value);
    }

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default void accept(Field field, double value, DoublePredicate ignoreStrategy) {
        accept(field.name(), value, ignoreStrategy);
    }

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param <R>   the generic type
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <R> void accept(Field field, @SuppressWarnings("unchecked") R... value) {
        accept(field.name(), value);
    }

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param field         the field
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default void accept(Field field, String[] value, MatchStrategy matchStrategy) {
        accept(field.name(), value, matchStrategy);
    }

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default void accept(Field field, String[] value, MatchStrategy matchStrategy, Predicate<String[]> ignoreStrategy) {
        accept(field.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default void accept(Field field, int... value) {
        accept(field.name(), value);
    }

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default void accept(Field field, long... value) {
        accept(field.name(), value);
    }

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param <R>            the generic type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R> void accept(Field field, R[] value, Predicate<R[]> ignoreStrategy) {
        accept(field.name(), value, ignoreStrategy);
    }

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default void accept(Field field, int[] value, Predicate<int[]> ignoreStrategy) {
        accept(field.name(), value, ignoreStrategy);
    }

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default void accept(Field field, long[] value, Predicate<long[]> ignoreStrategy) {
        accept(field.name(), value, ignoreStrategy);
    }

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param <R>   the generic type
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default <R> void accept(Field field, Collection<R> value) {
        accept(field.name(), value);
    }

    /**
     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
     *
     * @param <R>            the generic type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R> void accept(Field field, Collection<R> value, Predicate<Collection<R>> ignoreStrategy) {
        accept(field.name(), value, ignoreStrategy);
    }

    //    /**
    //     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
    //     *
    //     * @param <R>      the generic type
    //     * @param property bean property
    //     * @return LogicExpression
    //     */
    //    <R> void accept(SerializableSupplier<R> property);
    //
    //    /**
    //     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
    //     *
    //     * @param <R>            the generic type
    //     * @param property       bean property
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    <R> void accept(SerializableSupplier<R> property, Predicate<R> ignoreStrategy);
    //
    //    /**
    //     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
    //     *
    //     * @param property      the property
    //     * @param matchStrategy the match strategy
    //     * @return LogicExpression
    //     */
    //    void accept(SerializableStringSupplier property, MatchStrategy matchStrategy);
    //
    //    /**
    //     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
    //     *
    //     * @param property       the property
    //     * @param matchStrategy  the match strategy
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    void accept(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);
    //
    //    /**
    //     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
    //     *
    //     * @param property bean property
    //     * @return LogicExpression
    //     */
    //    void accept(SerializableIntSupplier property);
    //
    //    /**
    //     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
    //     *
    //     * @param property       bean property
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    void accept(SerializableIntSupplier property, IntPredicate ignoreStrategy);
    //
    //    /**
    //     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
    //     *
    //     * @param property bean property
    //     * @return LogicExpression
    //     */
    //    void accept(SerializableLongSupplier property);
    //
    //    /**
    //     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
    //     *
    //     * @param property       bean property
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    void accept(SerializableLongSupplier property, LongPredicate ignoreStrategy);
    //
    //    /**
    //     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
    //     *
    //     * @param property bean property
    //     * @return LogicExpression
    //     */
    //    void accept(SerializableDoubleSupplier property);
    //
    //    /**
    //     * values in or not values in. 包含指定，sql中的in或者不包含指定，sql中的not in.
    //     *
    //     * @param property       bean property
    //     * @param ignoreStrategy the ignore strategy
    //     * @return LogicExpression
    //     */
    //    void accept(SerializableDoubleSupplier property, DoublePredicate ignoreStrategy);
}
