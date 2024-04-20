
package cn.featherfly.hammer.dsl.entity.execute;

import java.util.function.Consumer;
import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.execute.EntityUpdateSetExpression;
import cn.featherfly.hammer.expression.execute.UpdateNumberValueExpression;

/**
 * EntityUpdateNumberValueImpl.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <N> the number type
 * @param <U> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class EntityUpdateNumberValueImpl<E, N extends Number, U, C extends ConditionExpression,
    L extends LogicExpression<C, L>> implements UpdateNumberValueExpression<N, U, C, L> {

    private SerializableFunction<E, N> property;

    private EntityUpdateSetExpression<E, U, C, L> update;

    /**
     * Instantiates a new entity update value impl.
     *
     * @param property the property
     * @param update   the update
     */
    public EntityUpdateNumberValueImpl(SerializableFunction<E, N> property,
        EntityUpdateSetExpression<E, U, C, L> update) {
        super();
        this.property = property;
        this.update = update;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public U set(N value) {
        return update.set(property, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public U set(N value, Predicate<N> ignoreStrategy) {
        return update.set(property, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public U increase(N value) {
        return update.increase(property, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public U increase(N value, Predicate<N> ignoreStrategy) {
        return update.increase(property, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public U increase(Consumer<UpdateNumberValueExpression<N, U, C, L>> consumer) {
        consumer.accept(this);
        return (U) update;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public U set(Consumer<UpdateNumberValueExpression<N, U, C, L>> consumer) {
        consumer.accept(this);
        return (U) update;
    }
}
