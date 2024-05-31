
package cn.featherfly.hammer.dsl.repository.execute;

import java.io.Serializable;
import java.util.function.Consumer;
import java.util.function.Predicate;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.execute.UpdateValueExpression;
import cn.featherfly.hammer.expression.repository.execute.RepositoryUpdateSetExpression;

/**
 * RepositoryUpdateValueImpl.
 *
 * @author zhongj
 * @param <T> the generic type
 * @param <U> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class RepositoryUpdateValueImpl<T extends Serializable, U, C extends ConditionExpression,
    L extends LogicExpression<C, L>> implements UpdateValueExpression<T, U, C, L> {

    private final String name;

    private final RepositoryUpdateSetExpression<U, C, L> update;

    /**
     * Instantiates a new repository update value impl.
     *
     * @param name the name
     * @param update the update
     */
    public RepositoryUpdateValueImpl(String name, RepositoryUpdateSetExpression<U, C, L> update) {
        super();
        this.name = name;
        this.update = update;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public U set(T value) {
        return update.set(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public U set(T value, Predicate<T> ignoreStrategy) {
        return update.set(name, value, ignoreStrategy);
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
