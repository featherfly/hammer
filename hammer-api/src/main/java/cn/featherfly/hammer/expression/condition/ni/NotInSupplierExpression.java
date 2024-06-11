
package cn.featherfly.hammer.expression.condition.ni;

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
 * not in supplier expression .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface NotInSupplierExpression<C extends ConditionExpression, L extends LogicExpression<C, L>> {

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <R> the generic type
     * @param property bean property
     * @return LogicExpression
     */
    default <R extends Serializable> L ni(SerializableSupplier<R> property) {
        return ni(property, property.get());
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <R> the generic type
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R extends Serializable> L ni(SerializableSupplier<R> property, IgnoreStrategy ignoreStrategy) {
        return ni(property, property.get(), ignoreStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <R> the generic type
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R extends Serializable> L ni(SerializableSupplier<R> property, Predicate<R> ignoreStrategy) {
        return ni(property, property.get(), ignoreStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @return LogicExpression
     */
    default L ni(SerializableIntSupplier property) {
        return ni(property, property.get());
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni(SerializableIntSupplier property, IntPredicate ignoreStrategy) {
        return ni(property, property.get(), ignoreStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @return LogicExpression
     */
    default L ni(SerializableLongSupplier property) {
        return ni(property, property.get());
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni(SerializableLongSupplier property, LongPredicate ignoreStrategy) {
        return ni(property, property.get(), ignoreStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @return LogicExpression
     */
    default L ni(SerializableDoubleSupplier property) {
        return ni(property, property.get());
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni(SerializableDoubleSupplier property, DoublePredicate ignoreStrategy) {
        return ni(property, property.get(), ignoreStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @return LogicExpression
     */
    default L ni(SerializableStringSupplier property) {
        return ni(property, property.get());
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni(SerializableStringSupplier property, IgnoreStrategy ignoreStrategy) {
        return ni(property, property.get(), ignoreStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return ni(property, property.get(), ignoreStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L ni(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return ni(property, property.get(), matchStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni(SerializableStringSupplier property, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return ni(property, property.get(), matchStrategy, ignoreStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return ni(property, property.get(), matchStrategy, ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <R> the generic type
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    <R extends Serializable> L ni(SerializableSupplier<R> property, R value);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <R> the generic type
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    <R extends Serializable> L ni(SerializableSupplier<R> property, @SuppressWarnings("unchecked") R... value);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <R> the generic type
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R extends Serializable> L ni(SerializableSupplier<R> property, R value, IgnoreStrategy ignoreStrategy) {
        return ni(property, value, ignoreStrategy::test);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <R> the generic type
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R extends Serializable> L ni(SerializableSupplier<R> property, R value, Predicate<R> ignoreStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <R> the generic type
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R extends Serializable> L ni(SerializableSupplier<R> property, R[] value, Predicate<R[]> ignoreStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    L ni(SerializableIntSupplier property, int value);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    L ni(SerializableIntSupplier property, int... value);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni(SerializableIntSupplier property, int value, IntPredicate ignoreStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni(SerializableIntSupplier property, int[] value, Predicate<int[]> ignoreStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    L ni(SerializableLongSupplier property, long value);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    L ni(SerializableLongSupplier property, long... value);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni(SerializableLongSupplier property, long value, LongPredicate ignoreStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni(SerializableLongSupplier property, long[] value, Predicate<long[]> ignoreStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    L ni(SerializableDoubleSupplier property, double value);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    L ni(SerializableDoubleSupplier property, double... value);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni(SerializableDoubleSupplier property, double value, DoublePredicate ignoreStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni(SerializableDoubleSupplier property, double[] value, Predicate<double[]> ignoreStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    default L ni(SerializableStringSupplier property, String value) {
        return ni(property, value, MatchStrategy.AUTO);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    default L ni(SerializableStringSupplier property, String... value) {
        return ni(property, value, MatchStrategy.AUTO);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni(SerializableStringSupplier property, String value, IgnoreStrategy ignoreStrategy) {
        return ni(property, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni(SerializableStringSupplier property, String[] value, IgnoreStrategy ignoreStrategy) {
        return ni(property, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni(SerializableStringSupplier property, String value, Predicate<String> ignoreStrategy) {
        return ni(property, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni(SerializableStringSupplier property, String[] value, Predicate<String[]> ignoreStrategy) {
        return ni(property, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @param value the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L ni(SerializableStringSupplier property, String value, MatchStrategy matchStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @param value the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L ni(SerializableStringSupplier property, String[] value, MatchStrategy matchStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        IgnoreStrategy ignoreStrategy) {
        return ni(property, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni(SerializableStringSupplier property, String[] value, MatchStrategy matchStrategy,
        IgnoreStrategy ignoreStrategy) {
        return ni(property, value, matchStrategy, (Predicate<String[]>) ignoreStrategy::test);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni(SerializableStringSupplier property, String[] value, MatchStrategy matchStrategy,
        Predicate<String[]> ignoreStrategy);
}