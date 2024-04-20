
package cn.featherfly.hammer.dsl.entity.execute;

import java.util.function.Consumer;
import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.execute.EntityUpdateSetExpression;
import cn.featherfly.hammer.expression.execute.UpdateValueExpression;

/**
 * EntityUpdateValueImpl.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <T> the generic type
 * @param <U> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class EntityUpdateValueImpl<E, T, U, C extends ConditionExpression, L extends LogicExpression<C, L>>
    implements UpdateValueExpression<T, U, C, L> {

    private SerializableFunction<E, T> property;

    private EntityUpdateSetExpression<E, U, C, L> update;

    /**
     * Instantiates a new entity update value impl.
     *
     * @param property the property
     * @param update   the update
     */
    public EntityUpdateValueImpl(SerializableFunction<E, T> property, EntityUpdateSetExpression<E, U, C, L> update) {
        super();
        this.property = property;
        this.update = update;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public U set(T value) {
        return update.set(property, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public U set(T value, Predicate<T> ignoreStrategy) {
        return update.set(property, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public U set(Consumer<UpdateValueExpression<T, U, C, L>> consumer) {
        consumer.accept(this);
        return (U) update;
    }

}
