
package cn.featherfly.hammer.expression.condition.in;

import java.io.Serializable;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableDoubleSupplier;
import cn.featherfly.common.function.serializable.SerializableIntSupplier;
import cn.featherfly.common.function.serializable.SerializableLongSupplier;
import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * in supplier expression4 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface InSupplierExpression4<C extends ConditionExpression, L extends LogicExpression<C, L>> {

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R> the generic type
     * @param property bean property
     * @return LogicExpression
     */
    default <R extends Serializable> L in4(SerializableSupplier<R> property) {
        return in4(property, property.get());
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R> the generic type
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R extends Serializable> L in4(SerializableSupplier<R> property, IgnoreStrategy ignoreStrategy) {
        return in4(property, property.get(), ignoreStrategy);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R> the generic type
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R extends Serializable> L in4(SerializableSupplier<R> property, Predicate<R> ignoreStrategy) {
        return in4(property, property.get(), ignoreStrategy);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param property bean property
     * @return LogicExpression
     */
    default L in4(SerializableIntSupplier property) {
        return in4(property, property.get());
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L in4(SerializableIntSupplier property, IntPredicate ignoreStrategy) {
        return in4(property, property.get(), ignoreStrategy);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param property bean property
     * @return LogicExpression
     */
    default L in4(SerializableLongSupplier property) {
        return in4(property, property.get());
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L in4(SerializableLongSupplier property, LongPredicate ignoreStrategy) {
        return in4(property, property.get(), ignoreStrategy);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param property bean property
     * @return LogicExpression
     */
    default L in4(SerializableDoubleSupplier property) {
        return in4(property, property.get());
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L in4(SerializableDoubleSupplier property, DoublePredicate ignoreStrategy) {
        return in4(property, property.get(), ignoreStrategy);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param property bean property
     * @return LogicExpression
     */
    default L in4(SerializableStringSupplier property) {
        return in4(property, property.get());
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L in4(SerializableStringSupplier property, IgnoreStrategy ignoreStrategy) {
        return in4(property, property.get(), ignoreStrategy);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L in4(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return in4(property, property.get(), ignoreStrategy);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param property bean property
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L in4(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return in4(property, property.get(), matchStrategy);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param property bean property
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L in4(SerializableStringSupplier property, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return in4(property, property.get(), matchStrategy, ignoreStrategy);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param property bean property
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L in4(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return in4(property, property.get(), matchStrategy, ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R> the generic type
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    <R extends Serializable> L in4(SerializableSupplier<R> property, R value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R> the generic type
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    <R extends Serializable> L in4(SerializableSupplier<R> property, @SuppressWarnings("unchecked") R... value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R> the generic type
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R extends Serializable> L in4(SerializableSupplier<R> property, R value, IgnoreStrategy ignoreStrategy) {
        return in4(property, value, ignoreStrategy::test);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R> the generic type
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R extends Serializable> L in4(SerializableSupplier<R> property, R value, Predicate<R> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R> the generic type
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R extends Serializable> L in4(SerializableSupplier<R> property, R[] value, Predicate<R[]> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    L in4(SerializableIntSupplier property, int value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    L in4(SerializableIntSupplier property, int... value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in4(SerializableIntSupplier property, int value, IntPredicate ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in4(SerializableIntSupplier property, int[] value, Predicate<int[]> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    L in4(SerializableLongSupplier property, long value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    L in4(SerializableLongSupplier property, long... value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in4(SerializableLongSupplier property, long value, LongPredicate ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in4(SerializableLongSupplier property, long[] value, Predicate<long[]> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    L in4(SerializableDoubleSupplier property, double value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    L in4(SerializableDoubleSupplier property, double... value);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in4(SerializableDoubleSupplier property, double value, DoublePredicate ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in4(SerializableDoubleSupplier property, double[] value, Predicate<double[]> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    default L in4(SerializableStringSupplier property, String value) {
        return in4(property, value, MatchStrategy.AUTO);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    default L in4(SerializableStringSupplier property, String... value) {
        return in4(property, value, MatchStrategy.AUTO);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L in4(SerializableStringSupplier property, String value, IgnoreStrategy ignoreStrategy) {
        return in4(property, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L in4(SerializableStringSupplier property, String[] value, IgnoreStrategy ignoreStrategy) {
        return in4(property, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L in4(SerializableStringSupplier property, String value, Predicate<String> ignoreStrategy) {
        return in4(property, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L in4(SerializableStringSupplier property, String[] value, Predicate<String[]> ignoreStrategy) {
        return in4(property, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param property bean property
     * @param value the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L in4(SerializableStringSupplier property, String value, MatchStrategy matchStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param property bean property
     * @param value the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L in4(SerializableStringSupplier property, String[] value, MatchStrategy matchStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param property bean property
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L in4(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        IgnoreStrategy ignoreStrategy) {
        return in4(property, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param property bean property
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L in4(SerializableStringSupplier property, String[] value, MatchStrategy matchStrategy,
        IgnoreStrategy ignoreStrategy) {
        return in4(property, value, matchStrategy, (Predicate<String[]>) ignoreStrategy::test);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param property bean property
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in4(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param property bean property
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in4(SerializableStringSupplier property, String[] value, MatchStrategy matchStrategy,
        Predicate<String[]> ignoreStrategy);
}