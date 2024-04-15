
package cn.featherfly.hammer.expression.repository.condition.ne;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

import cn.featherfly.common.function.CharPredicate;
import cn.featherfly.common.function.serializable.SerializableBoolSupplier;
import cn.featherfly.common.function.serializable.SerializableBooleanSupplier;
import cn.featherfly.common.function.serializable.SerializableCharSupplier;
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
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.function.serializable.SerializableToDoubleFunction;
import cn.featherfly.common.function.serializable.SerializableToLongFunction;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.ne.NotEqualsExpression;
import cn.featherfly.hammer.expression.condition.ne.NotEqualsSupplierExpression;

/**
 * repository not equals expression .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryNotEqualsExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends NotEqualsExpression<C, L>, NotEqualsSupplierExpression<C, L> {

    /**
     * not equals. 不等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default <T> L ne(SerializableToLongFunction<T> name, boolean value) {
        return ne(LambdaUtils.getLambdaPropertyName(name), value);
    }

    /**
     * not equals. 不等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ne(SerializableToLongFunction<T> name, char value) {
        return ne(LambdaUtils.getLambdaPropertyName(name), value);
    }

    /**
     * not equals. 不等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ne(SerializableToLongFunction<T> name, char value, CharPredicate ignoreStrategy) {
        return ne(LambdaUtils.getLambdaPropertyName(name), value, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ne(SerializableToLongFunction<T> name, int value) {
        return ne(LambdaUtils.getLambdaPropertyName(name), value);
    }

    /**
     * not equals. 不等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ne(SerializableToLongFunction<T> name, int value, IntPredicate ignoreStrategy) {
        return ne(LambdaUtils.getLambdaPropertyName(name), value, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ne(SerializableToLongFunction<T> name, long value) {
        return ne(LambdaUtils.getLambdaPropertyName(name), value);
    }

    /**
     * not equals. 不等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ne(SerializableToLongFunction<T> name, long value, LongPredicate ignoreStrategy) {
        return ne(LambdaUtils.getLambdaPropertyName(name), value, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ne(SerializableToDoubleFunction<T> name, double value) {
        return ne(LambdaUtils.getLambdaPropertyName(name), value);
    }

    /**
     * not equals. 不等于.
     *
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ne(SerializableToDoubleFunction<T> name, double value, DoublePredicate ignoreStrategy) {
        return ne(LambdaUtils.getLambdaPropertyName(name), value, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param <T>   the generic type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default <T, R extends Serializable> L ne(SerializableFunction<T, R> name, R value) {
        return ne(LambdaUtils.getLambdaPropertyName(name), value);
    }

    /**
     * not equals. 不等于.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T, R extends Serializable> L ne(SerializableFunction<T, R> name, R value, IgnoreStrategy ignoreStrategy) {
        return ne(LambdaUtils.getLambdaPropertyName(name), value, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T, R extends Serializable> L ne(SerializableFunction<T, R> name, R value, Predicate<R> ignoreStrategy) {
        return ne(LambdaUtils.getLambdaPropertyName(name), value, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param <T>   the generic type
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default <T> L ne(SerializableToStringFunction<T> name, String value) {
        return ne(name, value, MatchStrategy.AUTO);
    }

    /**
     * not equals. 不等于.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ne(SerializableToStringFunction<T> name, String value, IgnoreStrategy ignoreStrategy) {
        return ne(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ne(SerializableToStringFunction<T> name, String value, Predicate<String> ignoreStrategy) {
        return ne(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param <T>           the generic type
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default <T> L ne(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy) {
        return ne(LambdaUtils.getLambdaPropertyName(name), value, matchStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ne(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy,
        IgnoreStrategy ignoreStrategy) {
        return ne(LambdaUtils.getLambdaPropertyName(name), value, matchStrategy, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param <T>            the generic type
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <T> L ne(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return ne(LambdaUtils.getLambdaPropertyName(name), value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ne(SerializableBooleanSupplier propertyValue) {
        return ne(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.getAsBoolean());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ne(SerializableCharSupplier propertyValue) {
        return ne(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ne(SerializableCharSupplier propertyValue, CharPredicate ignoreStrategy) {
        return ne(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ne(SerializableIntSupplier propertyValue) {
        return ne(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ne(SerializableIntSupplier propertyValue, IntPredicate ignoreStrategy) {
        return ne(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ne(SerializableLongSupplier propertyValue) {
        return ne(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ne(SerializableLongSupplier propertyValue, LongPredicate ignoreStrategy) {
        return ne(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ne(SerializableDoubleSupplier propertyValue) {
        return ne(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ne(SerializableDoubleSupplier propertyValue, DoublePredicate ignoreStrategy) {
        return ne(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ne(SerializableBoolSupplier propertyValue) {
        return ne(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ne(SerializableBoolSupplier propertyValue, Predicate<Boolean> ignoreStrategy) {
        return ne(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <N extends Number> L ne(SerializableNumberSupplier<N> propertyValue) {
        return ne(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <N extends Number> L ne(SerializableNumberSupplier<N> propertyValue, Predicate<N> ignoreStrategy) {
        return ne(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <D extends Date> L ne(SerializableDateSupplier<D> propertyValue) {
        return ne(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <R extends Date> L ne(SerializableDateSupplier<R> propertyValue, Predicate<R> ignoreStrategy) {
        return ne(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <E extends Enum<E>> L ne(SerializableEnumSupplier<E> propertyValue) {
        return ne(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <E extends Enum<E>> L ne(SerializableEnumSupplier<E> propertyValue, Predicate<E> ignoreStrategy) {
        return ne(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ne(SerializableLocalDateSupplier propertyValue) {
        return ne(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ne(SerializableLocalDateSupplier propertyValue, Predicate<LocalDate> ignoreStrategy) {
        return ne(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ne(SerializableLocalTimeSupplier propertyValue) {
        return ne(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ne(SerializableLocalTimeSupplier propertyValue, Predicate<LocalTime> ignoreStrategy) {
        return ne(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ne(SerializableLocalDateTimeSupplier propertyValue) {
        return ne(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ne(SerializableLocalDateTimeSupplier propertyValue, Predicate<LocalDateTime> ignoreStrategy) {
        return ne(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get(), ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ne(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy) {
        return ne(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get(), matchStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default L ne(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        return ne(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get(), matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <R extends Serializable> L ne(SerializableSupplier<R> propertyValue) {
        return ne(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default <R extends Serializable> L ne(SerializableSupplier<R> propertyValue, Predicate<R> ignoreStrategy) {
        return ne(LambdaUtils.getLambdaPropertyName(propertyValue), propertyValue.get(), ignoreStrategy);
    }
}