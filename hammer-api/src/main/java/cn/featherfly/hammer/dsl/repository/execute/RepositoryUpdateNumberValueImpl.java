
package cn.featherfly.hammer.dsl.repository.execute;

import java.util.function.Consumer;
import java.util.function.Predicate;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.execute.UpdateNumberValueExpression;
import cn.featherfly.hammer.expression.repository.execute.RepositoryUpdateSetExpression;

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
public class RepositoryUpdateNumberValueImpl<E, N extends Number, U, C extends ConditionExpression,
    L extends LogicExpression<C, L>> implements UpdateNumberValueExpression<N, U, C, L> {

    private final String name;

    private final RepositoryUpdateSetExpression<U, C, L> update;

    /**
     * Instantiates a new repository update number value impl.
     *
     * @param name   the name
     * @param update the update
     */
    public RepositoryUpdateNumberValueImpl(String name, RepositoryUpdateSetExpression<U, C, L> update) {
        super();
        this.name = name;
        this.update = update;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public U set(N value) {
        return update.set(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public U set(N value, Predicate<N> ignoreStrategy) {
        return update.set(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public U increase(N value) {
        return update.increase(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public U increase(N value, Predicate<N> ignoreStrategy) {
        return update.increase(name, value, ignoreStrategy);
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
