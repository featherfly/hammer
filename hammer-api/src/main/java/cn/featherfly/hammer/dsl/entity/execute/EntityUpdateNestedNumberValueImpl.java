
package cn.featherfly.hammer.dsl.entity.execute;

import java.util.function.Consumer;
import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.execute.EntityUpdateSetExpression;
import cn.featherfly.hammer.expression.execute.UpdateNumberValueExpression;

/**
 * EntityUpdateNestedValueImpl.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <O> the element property type
 * @param <V> the value type
 * @param <U> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class EntityUpdateNestedNumberValueImpl<E, O, V extends Number, U, C extends ConditionExpression,
    L extends LogicExpression<C, L>> implements UpdateNumberValueExpression<V, U, C, L> {

    private SerializableFunction<E, O> property;

    private SerializableFunction<O, V> nestedProperty;

    private EntityUpdateSetExpression<E, U, C, L> update;

    /**
     * Instantiates a new entity update value impl.
     *
     * @param property the property
     * @param nestedProperty the nested property
     * @param update the update
     */
    public EntityUpdateNestedNumberValueImpl(SerializableFunction<E, O> property,
        SerializableFunction<O, V> nestedProperty, EntityUpdateSetExpression<E, U, C, L> update) {
        super();
        this.property = property;
        this.nestedProperty = nestedProperty;
        this.update = update;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public U set(V value) {
        return update.set(property, nestedProperty, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public U set(V value, Predicate<V> ignoreStrategy) {
        return update.set(property, nestedProperty, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public U increase(V value) {
        return update.increase(property, nestedProperty, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public U increase(V value, Predicate<V> ignoreStrategy) {
        return update.increase(property, nestedProperty, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public U increase(Consumer<UpdateNumberValueExpression<V, U, C, L>> consumer) {
        return set(consumer);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public U set(Consumer<UpdateNumberValueExpression<V, U, C, L>> consumer) {
        consumer.accept(this);
        return (U) update;
    }
}
