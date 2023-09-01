
package cn.featherfly.hammer.dsl.entity.execute;

import java.util.function.Consumer;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.hammer.expression.entity.execute.EntityUpdateValueExpression;

/**
 * EntityUpdateValueImpl.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <T> the generic type
 * @param <O> the generic type
 */
public class EntityUpdateNestedValueImpl<E, T, O> implements EntityUpdateValue<E, O> {

    private SerializableFunction<E, T> property;

    private SerializableFunction<T, O> nestedProperty;

    private EntityExecutableUpdate<E> update;

    /**
     * Instantiates a new entity update value impl.
     *
     * @param property       the property
     * @param nestedProperty the nested property
     * @param update         the update
     */
    public EntityUpdateNestedValueImpl(SerializableFunction<E, T> property, SerializableFunction<T, O> nestedProperty,
            EntityExecutableUpdate<E> update) {
        super();
        this.property = property;
        this.nestedProperty = nestedProperty;
        this.update = update;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityExecutableUpdate<E> set(O value) {
        return update.set(property, nestedProperty, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityExecutableUpdate<E> set(Consumer<EntityUpdateValueExpression<E, O, EntityExecutableUpdate<E>,
            EntityExecutableConditionGroup<E>, EntityExecutableConditionGroupLogic<E>>> consumer) {
        consumer.accept(this);
        return update;
    }

}
