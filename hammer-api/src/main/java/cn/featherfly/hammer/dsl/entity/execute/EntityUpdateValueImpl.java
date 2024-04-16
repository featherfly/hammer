
package cn.featherfly.hammer.dsl.entity.execute;

import java.util.function.Consumer;
import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.expression.entity.execute.EntityUpdateValueExpression;

/**
 * EntityUpdateValueImpl.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <T> the generic type
 */
public class EntityUpdateValueImpl<E, T> implements EntityUpdateValue<E, T> {

    private SerializableFunction<E, T> property;

    private EntityExecutableUpdate<E> update;

    /**
     * Instantiates a new entity update value impl.
     *
     * @param property the property
     * @param update   the update
     */
    public EntityUpdateValueImpl(SerializableFunction<E, T> property, EntityExecutableUpdate<E> update) {
        super();
        this.property = property;
        this.update = update;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityExecutableUpdate<E> set(T value) {
        return update.set(property, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityExecutableUpdate<E> set(T value, Predicate<T> ignoreStrategy) {
        return update.set(property, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityExecutableUpdate<E> set(Consumer<EntityUpdateValueExpression<E, T, EntityExecutableUpdate<E>,
        EntityExecutableConditionGroup<E, UpdateConditionConfig>,
        EntityExecutableConditionGroupLogic<E, UpdateConditionConfig>>> consumer) {
        consumer.accept(this);
        return update;
    }

}
