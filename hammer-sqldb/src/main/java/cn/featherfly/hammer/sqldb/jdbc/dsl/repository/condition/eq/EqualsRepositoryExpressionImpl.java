
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.eq;

import java.util.Date;
import java.util.function.Predicate;

import cn.featherfly.common.exception.NotImplementedException;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.eq.MulitiEqualsExpression;
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
import cn.featherfly.hammer.expression.repository.condition.eq.AbstractEqualsRepositoryExpression;
import cn.featherfly.hammer.expression.repository.condition.eq.EqualsRepositoryExpression;

/**
 * The Class EqualsEntityExpressionImpl.
 *
 * @author zhongj
 * @param <T> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class EqualsRepositoryExpressionImpl<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends AbstractEqualsRepositoryExpression<C, L> implements EqualsRepositoryExpression {

    /**
     * Instantiates a new equals entity expression impl.
     *
     * @param index         the index
     * @param expression    the expression
     * @param factory       the factory
     * @param queryRelation the query relation
     */
    public EqualsRepositoryExpressionImpl(int index, MulitiEqualsExpression<C, L> expression,
            Predicate<Object> ignorepPredicate) {
        super(index, expression, ignorepPredicate);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <V> SetValueMatchStrategyExpression<V> field(String name) {
        // IMPLSOON 未实现
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, V> SetValueMatchStrategyExpression<V> field(SerializableFunction<T, V> name) {
        // IMPLSOON 未实现
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SetIntExpression fieldAsInt(final String name) {
        return new SetIntExpressionImpl(ignoreStrategy, (value, ignore) -> expression.eq(index, name, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SetLongExpression fieldAsLong(String name) {
        return new SetLongExpressionImpl(ignoreStrategy, (value, ignore) -> expression.eq(index, name, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SetDoubleExpression fieldAsDouble(String name) {
        return new SetDoubleExpressionImpl(ignoreStrategy,
                (value, ignore) -> expression.eq(index, name, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> SetNumberExpression<N> fieldAsNumber(String name) {
        return new SetNumberExpressionImpl<>(ignoreStrategy,
                (value, ignore) -> expression.eq(index, name, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> SetNumberExpression<N> fieldAsNumber(String name, Class<N> type) {
        return new SetNumberExpressionImpl<>(ignoreStrategy,
                (value, ignore) -> expression.eq(index, name, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> SetEnumExpression<E> fieldAsEnum(String name) {
        return new SetEnumExpressionImpl<>(ignoreStrategy,
                (value, ignore) -> expression.eq(index, name, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> SetEnumExpression<E> fieldAsEnum(String name, Class<E> type) {
        return new SetEnumExpressionImpl<>(ignoreStrategy,
                (value, ignore) -> expression.eq(index, name, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> SetDateExpression<D> fieldAsDate(String name) {
        return new SetDateExpressionImpl<>(ignoreStrategy,
                (value, ignore) -> expression.eq(index, name, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> SetDateExpression<D> fieldAsDate(String name, Class<D> type) {
        return new SetDateExpressionImpl<>(ignoreStrategy,
                (value, ignore) -> expression.eq(index, name, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SetLocalDateExpression fieldAsLocalDate(String name) {
        return new SetLocalDateExpressionImpl(ignoreStrategy,
                (value, ignore) -> expression.eq(index, name, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SetLocalTimeExpression fieldAsLocalTime(String name) {
        return new SetLocalTimeExpressionImpl(ignoreStrategy,
                (value, ignore) -> expression.eq(index, name, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SetLocalDateTimeExpression fieldAsLocalDateTime(String name) {
        return new SetLocalDateTimeExpressionImpl(ignoreStrategy,
                (value, ignore) -> expression.eq(index, name, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SetStringExpression fieldAsString(String name) {
        return new SetStringExpressionImpl(ignoreStrategy,
                (value, match, ignore) -> expression.eq(index, name, value, match, ignore));
    }

}
