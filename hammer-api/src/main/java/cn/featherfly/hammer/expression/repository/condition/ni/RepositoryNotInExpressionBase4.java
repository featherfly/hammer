
package cn.featherfly.hammer.expression.repository.condition.ni;

import java.io.Serializable;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableDoubleSupplier;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableIntSupplier;
import cn.featherfly.common.function.serializable.SerializableLongSupplier;
import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.function.serializable.SerializableToDoubleFunction;
import cn.featherfly.common.function.serializable.SerializableToIntFunction;
import cn.featherfly.common.function.serializable.SerializableToLongFunction;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.ni.NotInExpression4;
import cn.featherfly.hammer.expression.condition.ni.NotInSupplierExpression4;

/**
 * repository not in expression4 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryNotInExpressionBase4<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryNotInExpressionBase3<C, L>, NotInExpression4<C, L>, NotInSupplierExpression4<C, L> {

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <T> the generic type
     * @param name the name
     * @param values the values
     * @return LogicExpression
     */
    default <T> L ni4(SerializableToIntFunction<T> name, int... values) {
        return ni4(LambdaUtils.getLambdaPropertyName(name), values);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <T> the generic type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ni4(SerializableToIntFunction<T> name, int value, IntPredicate ignoreStrategy) {
        return ni4(name, new int[] { value }, v -> ignoreStrategy.test(v[0]));
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <T> the generic type
     * @param name the name
     * @param values the values
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ni4(SerializableToIntFunction<T> name, int[] values, Predicate<int[]> ignoreStrategy) {
        return ni4(LambdaUtils.getLambdaPropertyName(name), values, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <T> the generic type
     * @param name the name
     * @param values the values
     * @return LogicExpression
     */
    default <T> L ni4(SerializableToLongFunction<T> name, long... values) {
        return ni4(LambdaUtils.getLambdaPropertyName(name), values);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <T> the generic type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ni4(SerializableToLongFunction<T> name, long value, LongPredicate ignoreStrategy) {
        return ni4(name, new long[] { value }, v -> ignoreStrategy.test(v[0]));
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <T> the generic type
     * @param name the name
     * @param values the values
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ni4(SerializableToLongFunction<T> name, long[] values, Predicate<long[]> ignoreStrategy) {
        return ni4(LambdaUtils.getLambdaPropertyName(name), values, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <T> the generic type
     * @param name the name
     * @param values the values
     * @return LogicExpression
     */
    default <T> L ni4(SerializableToDoubleFunction<T> name, double... values) {
        return ni4(LambdaUtils.getLambdaPropertyName(name), values);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <T> the generic type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ni4(SerializableToDoubleFunction<T> name, double value, DoublePredicate ignoreStrategy) {
        return ni4(name, new double[] { value }, v -> ignoreStrategy.test(v[0]));
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <T> the generic type
     * @param name the name
     * @param values the values
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ni4(SerializableToDoubleFunction<T> name, double[] values, Predicate<double[]> ignoreStrategy) {
        return ni4(LambdaUtils.getLambdaPropertyName(name), values, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <T> the generic type
     * @param name the name
     * @param values the values
     * @return LogicExpression
     */
    default <T> L ni4(SerializableToStringFunction<T> name, String... values) {
        return ni4(name, values, MatchStrategy.AUTO);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <T> the generic type
     * @param name the name
     * @param values the values
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default <T> L ni4(SerializableToStringFunction<T> name, String[] values, MatchStrategy matchStrategy) {
        return ni4(LambdaUtils.getLambdaPropertyName(name), values, matchStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <T> the generic type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ni4(SerializableToStringFunction<T> name, String value, Predicate<String> ignoreStrategy) {
        return ni4(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <T> the generic type
     * @param name the name
     * @param value the value
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ni4(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return ni4(name, new String[] { value }, matchStrategy, v -> ignoreStrategy.test(v[0]));
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <T> the generic type
     * @param name the name
     * @param values the values
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ni4(SerializableToStringFunction<T> name, String[] values, Predicate<String[]> ignoreStrategy) {
        return ni4(name, values, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <T> the generic type
     * @param name the name
     * @param values the values
     * @param matchStrategy the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ni4(SerializableToStringFunction<T> name, String[] values, MatchStrategy matchStrategy,
        Predicate<String[]> ignoreStrategy) {
        return ni4(LambdaUtils.getLambdaPropertyName(name), values, matchStrategy, ignoreStrategy);
    }

    // ****************************************************************************************************************

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <T> the generic type
     * @param <R> the generic type
     * @param name the name
     * @param values the values
     * @return LogicExpression
     */
    @SuppressWarnings("unchecked")
    default <T, R extends Serializable> L ni4(SerializableFunction<T, R> name, R... values) {
        return ni4(LambdaUtils.getLambdaPropertyName(name), values);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <T> the generic type
     * @param <R> the generic type
     * @param name the name
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    @SuppressWarnings("unchecked")
    default <T, R extends Serializable> L ni4(SerializableFunction<T, R> name, R value, Predicate<R> ignoreStrategy) {
        return ni4(name, Lang.array(value), v -> ignoreStrategy.test(v[0]));
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <T> the generic type
     * @param <R> the generic type
     * @param name the name
     * @param values the values
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T, R extends Serializable> L ni4(SerializableFunction<T, R> name, R[] values,
        Predicate<R[]> ignoreStrategy) {
        return ni4(LambdaUtils.getLambdaPropertyName(name), values, ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    default <R extends Serializable> L ni4(SerializableSupplier<R> property, R value) {
        return ni4(LambdaUtils.getLambdaPropertyName(property), value);
    }

    @Override
    default <R extends Serializable> L ni4(SerializableSupplier<R> property,
        @SuppressWarnings("unchecked") R... value) {
        return ni4(LambdaUtils.getLambdaPropertyName(property), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <R extends Serializable> L ni4(SerializableSupplier<R> property, R value, Predicate<R> ignoreStrategy) {
        return ni4(LambdaUtils.getLambdaPropertyName(property), value, ignoreStrategy);
    }

    @Override
    default <R extends Serializable> L ni4(SerializableSupplier<R> property, R[] value, Predicate<R[]> ignoreStrategy) {
        return ni4(LambdaUtils.getLambdaPropertyName(property), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ni4(SerializableIntSupplier property, int value) {
        return ni4(LambdaUtils.getLambdaPropertyName(property), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ni4(SerializableIntSupplier property, int... value) {
        return ni4(LambdaUtils.getLambdaPropertyName(property), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ni4(SerializableIntSupplier property, int value, IntPredicate ignoreStrategy) {
        return ni4(LambdaUtils.getLambdaPropertyName(property), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ni4(SerializableIntSupplier property, int[] value, Predicate<int[]> ignoreStrategy) {
        return ni4(LambdaUtils.getLambdaPropertyName(property), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ni4(SerializableLongSupplier property, long value) {
        return ni4(LambdaUtils.getLambdaPropertyName(property), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ni4(SerializableLongSupplier property, long... value) {
        return ni4(LambdaUtils.getLambdaPropertyName(property), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ni4(SerializableLongSupplier property, long value, LongPredicate ignoreStrategy) {
        return ni4(LambdaUtils.getLambdaPropertyName(property), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ni4(SerializableLongSupplier property, long[] value, Predicate<long[]> ignoreStrategy) {
        return ni4(LambdaUtils.getLambdaPropertyName(property), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ni4(SerializableDoubleSupplier property, double value) {
        return ni4(LambdaUtils.getLambdaPropertyName(property), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ni4(SerializableDoubleSupplier property, double... value) {
        return ni4(LambdaUtils.getLambdaPropertyName(property), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ni4(SerializableDoubleSupplier property, double value, DoublePredicate ignoreStrategy) {
        return ni4(LambdaUtils.getLambdaPropertyName(property), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ni4(SerializableDoubleSupplier property, double[] value, Predicate<double[]> ignoreStrategy) {
        return ni4(LambdaUtils.getLambdaPropertyName(property), value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ni4(SerializableStringSupplier property, String value, MatchStrategy matchStrategy) {
        return ni4(LambdaUtils.getLambdaPropertyName(property), value, matchStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ni4(SerializableStringSupplier property, String[] value, MatchStrategy matchStrategy) {
        return ni4(LambdaUtils.getLambdaPropertyName(property), value, matchStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ni4(SerializableStringSupplier property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return ni4(LambdaUtils.getLambdaPropertyName(property), value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ni4(SerializableStringSupplier property, String[] value, MatchStrategy matchStrategy,
        Predicate<String[]> ignoreStrategy) {
        return ni4(LambdaUtils.getLambdaPropertyName(property), value, matchStrategy, ignoreStrategy);
    }
}