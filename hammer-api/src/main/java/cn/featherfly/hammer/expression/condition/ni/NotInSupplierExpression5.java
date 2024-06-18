
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
 * not in supplier expression5 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface NotInSupplierExpression5<C extends ConditionExpression, L extends LogicExpression<C, L>> {

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <R> the generic type
     * @param property bean property
     * @return LogicExpression
     */
    default <R extends Serializable> L ni5(SerializableSupplier<R> property) {
        return ni5(property, property.get());
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <R> the generic type
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R extends Serializable> L ni5(SerializableSupplier<R> property, IgnoreStrategy ignoreStrategy) {
        return ni5(property, property.get(), ignoreStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <R> the generic type
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R extends Serializable> L ni5(SerializableSupplier<R> property, Predicate<R> ignoreStrategy) {
        return ni5(property, property.get(), ignoreStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @return LogicExpression
     */
    default L ni5(SerializableIntSupplier property) {
        return ni5(property, property.get());
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni5(SerializableIntSupplier property, IntPredicate ignoreStrategy) {
        return ni5(property, property.get(), ignoreStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @return LogicExpression
     */
    default L ni5(SerializableLongSupplier property) {
        return ni5(property, property.get());
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni5(SerializableLongSupplier property, LongPredicate ignoreStrategy) {
        return ni5(property, property.get(), ignoreStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @return LogicExpression
     */
    default L ni5(SerializableDoubleSupplier property) {
        return ni5(property, property.get());
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni5(SerializableDoubleSupplier property, DoublePredicate ignoreStrategy) {
        return ni5(property, property.get(), ignoreStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @return LogicExpression
     */
    default L ni5(SerializableStringSupplier property) {
        return ni5(property, property.get());
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni5(SerializableStringSupplier property, IgnoreStrategy ignoreStrategy) {
        return ni5(property, property.get(), ignoreStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni5(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return ni5(property, property.get(), ignoreStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L ni5(SerializableStringSupplier property, MatchStrategy matchStrategy) {
        return ni5(property, property.get(), matchStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni5(SerializableStringSupplier property, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return ni5(property, property.get(), matchStrategy, ignoreStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni5(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return ni5(property, property.get(), matchStrategy, ignoreStrategy);
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
    <R extends Serializable> L ni5(SerializableSupplier<R> property, R value);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <R> the generic type
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    <R extends Serializable> L ni5(SerializableSupplier<R> property, @SuppressWarnings("unchecked") R... value);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <R> the generic type
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R extends Serializable> L ni5(SerializableSupplier<R> property, R value, IgnoreStrategy ignoreStrategy) {
        return ni5(property, value, ignoreStrategy::test);
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
    <R extends Serializable> L ni5(SerializableSupplier<R> property, R value, Predicate<R> ignoreStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <R> the generic type
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R extends Serializable> L ni5(SerializableSupplier<R> property, R[] value, Predicate<R[]> ignoreStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    L ni5(SerializableIntSupplier property, int value);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    L ni5(SerializableIntSupplier property, int... value);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni5(SerializableIntSupplier property, int value, IntPredicate ignoreStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni5(SerializableIntSupplier property, int[] value, Predicate<int[]> ignoreStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    L ni5(SerializableLongSupplier property, long value);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    L ni5(SerializableLongSupplier property, long... value);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni5(SerializableLongSupplier property, long value, LongPredicate ignoreStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni5(SerializableLongSupplier property, long[] value, Predicate<long[]> ignoreStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    L ni5(SerializableDoubleSupplier property, double value);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    L ni5(SerializableDoubleSupplier property, double... value);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni5(SerializableDoubleSupplier property, double value, DoublePredicate ignoreStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni5(SerializableDoubleSupplier property, double[] value, Predicate<double[]> ignoreStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    default L ni5(SerializableStringSupplier property, String value) {
        return ni5(property, value, MatchStrategy.AUTO);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @param value the value
     * @return LogicExpression
     */
    default L ni5(SerializableStringSupplier property, String... value) {
        return ni5(property, value, MatchStrategy.AUTO);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni5(SerializableStringSupplier property, String value, IgnoreStrategy ignoreStrategy) {
        return ni5(property, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni5(SerializableStringSupplier property, String[] value, IgnoreStrategy ignoreStrategy) {
        return ni5(property, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni5(SerializableStringSupplier property, String value, Predicate<String> ignoreStrategy) {
        return ni5(property, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni5(SerializableStringSupplier property, String[] value, Predicate<String[]> ignoreStrategy) {
        return ni5(property, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @param value the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L ni5(SerializableStringSupplier property, String value, MatchStrategy matchStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @param value the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L ni5(SerializableStringSupplier property, String[] value, MatchStrategy matchStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni5(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        IgnoreStrategy ignoreStrategy) {
        return ni5(property, value, matchStrategy, (Predicate<String>) ignoreStrategy::test);
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
    default L ni5(SerializableStringSupplier property, String[] value, MatchStrategy matchStrategy,
        IgnoreStrategy ignoreStrategy) {
        return ni5(property, value, matchStrategy, (Predicate<String[]>) ignoreStrategy::test);
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
    L ni5(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
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
    L ni5(SerializableStringSupplier property, String[] value, MatchStrategy matchStrategy,
        Predicate<String[]> ignoreStrategy);
}