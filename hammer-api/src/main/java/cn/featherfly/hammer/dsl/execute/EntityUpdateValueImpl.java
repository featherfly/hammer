
package cn.featherfly.hammer.dsl.execute;

import java.util.function.Consumer;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.hammer.expression.execute.EntityUpdateValueExpression;

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
     * @param name   the name
     * @param update the update
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
    public EntityExecutableUpdate<E> set(
            Consumer<EntityUpdateValueExpression<E, T, EntityExecutableUpdate<E>, EntityExecutableConditionGroupExpression<E>, EntityExecutableConditionGroupLogicExpression<E>>> consumer) {
        consumer.accept(this);
        return update;
    }

}
