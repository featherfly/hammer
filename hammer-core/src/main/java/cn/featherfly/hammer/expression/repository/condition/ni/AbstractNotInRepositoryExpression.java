
package cn.featherfly.hammer.expression.repository.condition.ni;

import java.util.Collection;
import java.util.Date;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetDateArrayExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetDateArrayExpressionImpl;
import cn.featherfly.hammer.expression.condition.field.value.SetDoubleArrayExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetDoubleArrayExpressionImpl;
import cn.featherfly.hammer.expression.condition.field.value.SetEnumArrayExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetEnumArrayExpressionImpl;
import cn.featherfly.hammer.expression.condition.field.value.SetIntArrayExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetIntArrayExpressionImpl;
import cn.featherfly.hammer.expression.condition.field.value.SetLocalDateArrayExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetLocalDateArrayExpressionImpl;
import cn.featherfly.hammer.expression.condition.field.value.SetLocalDateTimeArrayExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetLocalDateTimeArrayExpressionImpl;
import cn.featherfly.hammer.expression.condition.field.value.SetLocalTimeArrayExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetLocalTimeArrayExpressionImpl;
import cn.featherfly.hammer.expression.condition.field.value.SetLongArrayExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetLongArrayExpressionImpl;
import cn.featherfly.hammer.expression.condition.field.value.SetNumberArrayExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetNumberArrayExpressionImpl;
import cn.featherfly.hammer.expression.condition.field.value.SetStringArrayExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetStringArrayExpressionImpl;
import cn.featherfly.hammer.expression.condition.ni.MulitiNotInExpression;
import cn.featherfly.hammer.expression.repository.condition.AbstractRepositoryIndexableConditionExpression;

/**
 * The Class AbstractInRepositoryExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public abstract class AbstractNotInRepositoryExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends AbstractRepositoryIndexableConditionExpression<MulitiNotInExpression<C, L>>
    implements NotInRepositoryExpression {

    /**
     * Instantiates a new abstract in repository expression.
     *
     * @param index          the index
     * @param expression     the expression
     * @param ignoreStrategy the ignore strategy
     */
    protected AbstractNotInRepositoryExpression(int index, MulitiNotInExpression<C, L> expression,
        Predicate<Object> ignoreStrategy) {
        super(index, expression, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> void accept(String name, R value) {
        expression.ni(index, name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> void accept(String name, R value, Predicate<R> ignoreStrategy) {
        expression.ni(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(String name, int value) {
        expression.ni(index, name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(String name, int value, IntPredicate ignoreStrategy) {
        expression.ni(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(String name, long value) {
        expression.ni(index, name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(String name, long value, LongPredicate ignoreStrategy) {
        expression.ni(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(String name, double value) {
        expression.ni(index, name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(String name, double value, DoublePredicate ignoreStrategy) {
        expression.ni(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> void accept(String name, @SuppressWarnings("unchecked") R... value) {
        expression.ni(index, name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(String name, int... value) {
        expression.ni(index, name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(String name, long... value) {
        expression.ni(index, name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> void accept(String name, R[] value, Predicate<R[]> ignoreStrategy) {
        expression.ni(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(String name, int[] value, Predicate<int[]> ignoreStrategy) {
        expression.ni(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(String name, long[] value, Predicate<long[]> ignoreStrategy) {
        expression.ni(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> void accept(String name, Collection<R> value) {
        expression.ni(index, name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> void accept(String name, Collection<R> value, Predicate<Collection<R>> ignoreStrategy) {
        expression.ni(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(String name, String value, MatchStrategy matchStrategy) {
        expression.ni(index, name, value, matchStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        expression.ni(index, name, value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(String name, String[] value, MatchStrategy matchStrategy) {
        expression.ni(index, name, value, matchStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(String name, String[] value, MatchStrategy matchStrategy, Predicate<String[]> ignoreStrategy) {
        expression.ni(index, name, value, matchStrategy, ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public SetIntArrayExpression fieldAsInt(String name) {
        return new SetIntArrayExpressionImpl(v -> null, ignoreStrategy,
            (value, ignore, pm) -> expression.ni(index, name, value, ignore), v -> null,
            array -> ignoreStrategy.test(array), (value, ignore, pm) -> expression.ni(index, name, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SetLongArrayExpression fieldAsLong(String name) {
        return new SetLongArrayExpressionImpl(v -> null, ignoreStrategy,
            (value, ignore, pm) -> expression.ni(index, name, value, ignore), v -> null,
            array -> ignoreStrategy.test(array), (value, ignore, pm) -> expression.ni(index, name, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SetDoubleArrayExpression fieldAsDouble(String name) {
        return new SetDoubleArrayExpressionImpl(v -> null, ignoreStrategy,
            (value, ignore, pm) -> expression.ni(index, name, value, ignore), v -> null,
            array -> ignoreStrategy.test(array), (value, ignore, pm) -> expression.ni(index, name, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> SetNumberArrayExpression<N> fieldAsNumber(String name) {
        return new SetNumberArrayExpressionImpl<>(v -> null, ignoreStrategy,
            (value, ignore, pm) -> expression.ni(index, name, value, ignore), v -> null,
            array -> ignoreStrategy.test(array), (value, ignore, pm) -> expression.ni(index, name, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> SetDateArrayExpression<D> fieldAsDate(String name) {
        return new SetDateArrayExpressionImpl<>(v -> null, ignoreStrategy,
            (value, ignore, pm) -> expression.ni(index, name, value, ignore), v -> null,
            array -> ignoreStrategy.test(array), (value, ignore, pm) -> expression.ni(index, name, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> SetEnumArrayExpression<E> fieldAsEnum(String name) {
        return new SetEnumArrayExpressionImpl<>(v -> null, ignoreStrategy,
            (value, ignore, pm) -> expression.ni(index, name, value, ignore), v -> null,
            array -> ignoreStrategy.test(array), (value, ignore, pm) -> expression.ni(index, name, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SetLocalDateTimeArrayExpression fieldAsLocalDateTime(String name) {
        return new SetLocalDateTimeArrayExpressionImpl(v -> null, ignoreStrategy,
            (value, ignore, pm) -> expression.ni(index, name, value, ignore), v -> null,
            array -> ignoreStrategy.test(array), (value, ignore, pm) -> expression.ni(index, name, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SetLocalDateArrayExpression fieldAsLocalDate(String name) {
        return new SetLocalDateArrayExpressionImpl(v -> null, ignoreStrategy,
            (value, ignore, pm) -> expression.ni(index, name, value, ignore), v -> null,
            array -> ignoreStrategy.test(array), (value, ignore, pm) -> expression.ni(index, name, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SetLocalTimeArrayExpression fieldAsLocalTime(String name) {
        return new SetLocalTimeArrayExpressionImpl(v -> null, ignoreStrategy,
            (value, ignore, pm) -> expression.ni(index, name, value, ignore), v -> null,
            array -> ignoreStrategy.test(array), (value, ignore, pm) -> expression.ni(index, name, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SetStringArrayExpression fieldAsString(String name) {
        return new SetStringArrayExpressionImpl(v -> null, ignoreStrategy,
            (value, match, ignore, pm) -> expression.ni(index, name, value, match, ignore), v -> null,
            array -> ignoreStrategy.test(array),
            (value, match, ignore, pm) -> expression.ni(index, name, value, match, ignore));
    }
}
