
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-14 18:26:14
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.repository.condition.ne;

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
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableIntSupplier;
import cn.featherfly.common.function.serializable.SerializableLocalDateSupplier;
import cn.featherfly.common.function.serializable.SerializableLocalDateTimeSupplier;
import cn.featherfly.common.function.serializable.SerializableLocalTimeSupplier;
import cn.featherfly.common.function.serializable.SerializableLongSupplier;
import cn.featherfly.common.function.serializable.SerializableNumberSupplier;
import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.function.serializable.SerializableToDateFunction;
import cn.featherfly.common.function.serializable.SerializableToDoubleFunction;
import cn.featherfly.common.function.serializable.SerializableToIntFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalDateFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalDateTimeFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalTimeFunction;
import cn.featherfly.common.function.serializable.SerializableToLongFunction;
import cn.featherfly.common.function.serializable.SerializableToNumberFunction;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetDateExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetDateExpressionImpl;
import cn.featherfly.hammer.expression.condition.field.value.SetDoubleExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetDoubleExpressionImpl;
import cn.featherfly.hammer.expression.condition.field.value.SetEnumExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetEnumExpressionImpl;
import cn.featherfly.hammer.expression.condition.field.value.SetIntExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetIntExpressionImpl;
import cn.featherfly.hammer.expression.condition.field.value.SetLocalDateExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetLocalDateExpressionImpl;
import cn.featherfly.hammer.expression.condition.field.value.SetLocalDateTimeExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetLocalDateTimeExpressionImpl;
import cn.featherfly.hammer.expression.condition.field.value.SetLocalTimeExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetLocalTimeExpressionImpl;
import cn.featherfly.hammer.expression.condition.field.value.SetLongExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetLongExpressionImpl;
import cn.featherfly.hammer.expression.condition.field.value.SetNumberExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetNumberExpressionImpl;
import cn.featherfly.hammer.expression.condition.field.value.SetStringExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetStringExpressionImpl;
import cn.featherfly.hammer.expression.condition.field.value.SetValueMatchStrategyExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetValueMatchStrategyExpressionImpl;
import cn.featherfly.hammer.expression.condition.ne.MulitiNotEqualsExpression;
import cn.featherfly.hammer.expression.repository.condition.AbstractRepositoryIndexableConditionExpression;

/**
 * abstract not equals repository expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public abstract class AbstractNotEqualsRepositoryExpression<C extends ConditionExpression,
        L extends LogicExpression<C, L>>
        extends AbstractRepositoryIndexableConditionExpression<MulitiNotEqualsExpression<C, L>>
        implements NotEqualsRepositoryExpression {

    /**
     * Instantiates a new abstract equals entity expression.
     *
     * @param index          the index
     * @param expression     the expression
     * @param ignoreStrategy the ignore strategy
     */
    protected AbstractNotEqualsRepositoryExpression(int index, MulitiNotEqualsExpression<C, L> expression,
            Predicate<Object> ignoreStrategy) {
        super(index, expression, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, V> void accept(SerializableFunction<T, V> name, V value, Predicate<V> ignoreStrategy) {
        expression.ne(index, name, value, ignoreStrategy);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> void accept(SerializableSupplier<R> property, Predicate<R> ignoreStrategy) {
        expression.ne(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> void accept(SerializableToIntFunction<T> name, int value, IntPredicate ignoreStrategy) {
        expression.ne(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> void accept(SerializableToLongFunction<T> name, long value, LongPredicate ignoreStrategy) {
        expression.ne(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> void accept(SerializableToDoubleFunction<T> name, double value, DoublePredicate ignoreStrategy) {
        expression.ne(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, N extends Number> void accept(SerializableToNumberFunction<T, N> name, N value,
            Predicate<N> ignoreStrategy) {
        expression.ne(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, D extends Date> void accept(SerializableToDateFunction<T, D> name, D value,
            Predicate<D> ignoreStrategy) {
        expression.ne(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> void accept(SerializableToLocalTimeFunction<T> name, LocalTime value,
            Predicate<LocalTime> ignoreStrategy) {
        expression.ne(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> void accept(SerializableToLocalDateFunction<T> name, LocalDate value,
            Predicate<LocalDate> ignoreStrategy) {
        expression.ne(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> void accept(SerializableToLocalDateTimeFunction<T> name, LocalDateTime value,
            Predicate<LocalDateTime> ignoreStrategy) {
        expression.ne(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> void accept(SerializableToStringFunction<T> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        expression.ne(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(String name, int value, IntPredicate ignoreStrategy) {
        expression.ne(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(String name, long value, LongPredicate ignoreStrategy) {
        expression.ne(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(String name, double value, DoublePredicate ignoreStrategy) {
        expression.ne(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> void accept(String name, N value, Predicate<N> ignoreStrategy) {
        expression.ne(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> void accept(String name, D value, Predicate<D> ignoreStrategy) {
        expression.ne(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> void accept(String name, E value, Predicate<E> ignoreStrategy) {
        expression.ne(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(String name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
        expression.ne(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(String name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
        expression.ne(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(String name, LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        expression.ne(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        expression.ne(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableIntSupplier property, IntPredicate ignoreStrategy) {
        expression.ne(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableLongSupplier property, LongPredicate ignoreStrategy) {
        expression.ne(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableDoubleSupplier property, DoublePredicate ignoreStrategy) {
        expression.ne(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> void accept(SerializableDateSupplier<D> property, Predicate<D> ignoreStrategy) {
        expression.ne(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> void accept(SerializableNumberSupplier<R> property, Predicate<R> ignoreStrategy) {
        expression.ne(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableLocalDateSupplier property, Predicate<LocalDate> ignoreStrategy) {
        expression.ne(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableLocalTimeSupplier property, Predicate<LocalTime> ignoreStrategy) {
        expression.ne(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableLocalDateTimeSupplier property, Predicate<LocalDateTime> ignoreStrategy) {
        expression.ne(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableStringSupplier property, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        expression.ne(index, property, ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public <V> SetValueMatchStrategyExpression<V> field(String name) {
        return new SetValueMatchStrategyExpressionImpl<>(ignoreStrategy,
                (value, match, ignore) -> expression.ne(index, name, value, match, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SetIntExpression fieldAsInt(final String name) {
        return new SetIntExpressionImpl(ignoreStrategy, (value, ignore) -> expression.ne(index, name, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SetLongExpression fieldAsLong(String name) {
        return new SetLongExpressionImpl(ignoreStrategy, (value, ignore) -> expression.ne(index, name, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SetDoubleExpression fieldAsDouble(String name) {
        return new SetDoubleExpressionImpl(ignoreStrategy,
                (value, ignore) -> expression.ne(index, name, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> SetNumberExpression<N> fieldAsNumber(String name) {
        return new SetNumberExpressionImpl<>(ignoreStrategy,
                (value, ignore) -> expression.ne(index, name, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> SetNumberExpression<N> fieldAsNumber(String name, Class<N> type) {
        return new SetNumberExpressionImpl<>(ignoreStrategy,
                (value, ignore) -> expression.ne(index, name, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> SetEnumExpression<E> fieldAsEnum(String name) {
        return new SetEnumExpressionImpl<>(ignoreStrategy,
                (value, ignore) -> expression.ne(index, name, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> SetEnumExpression<E> fieldAsEnum(String name, Class<E> type) {
        return new SetEnumExpressionImpl<>(ignoreStrategy,
                (value, ignore) -> expression.ne(index, name, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> SetDateExpression<D> fieldAsDate(String name) {
        return new SetDateExpressionImpl<>(ignoreStrategy,
                (value, ignore) -> expression.ne(index, name, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> SetDateExpression<D> fieldAsDate(String name, Class<D> type) {
        return new SetDateExpressionImpl<>(ignoreStrategy,
                (value, ignore) -> expression.ne(index, name, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SetLocalDateExpression fieldAsLocalDate(String name) {
        return new SetLocalDateExpressionImpl(ignoreStrategy,
                (value, ignore) -> expression.ne(index, name, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SetLocalTimeExpression fieldAsLocalTime(String name) {
        return new SetLocalTimeExpressionImpl(ignoreStrategy,
                (value, ignore) -> expression.ne(index, name, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SetLocalDateTimeExpression fieldAsLocalDateTime(String name) {
        return new SetLocalDateTimeExpressionImpl(ignoreStrategy,
                (value, ignore) -> expression.ne(index, name, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SetStringExpression fieldAsString(String name) {
        return new SetStringExpressionImpl(ignoreStrategy,
                (value, match, ignore) -> expression.ne(index, name, value, match, ignore));
    }
}
