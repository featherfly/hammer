
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition;

import java.util.Collection;
import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableIntSupplier;
import cn.featherfly.common.function.serializable.SerializableLongSupplier;
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.function.serializable.SerializableToIntFunction;
import cn.featherfly.common.function.serializable.SerializableToLongFunction;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.nin.MulitiEntityNotInExpression;

/**
 * The Class MulitiEntityIsNullExpressionImpl.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class MulitiEntityNotInExpressionImpl<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends MulitiEntityConditionExpressionProxy<C, L> implements MulitiEntityNotInExpression<C, L> {

    /**
     * Instantiates a new muliti entity equals expression impl.
     *
     * @param proxy the proxy
     */
    public MulitiEntityNotInExpressionImpl(AbstractMulitiEntityConditionExpression<C, L> proxy) {
        super(proxy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E, R> L nin(int index, SerializableFunction<E, R> name, R value) {
        return proxy.nin0(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E, R> L nin(int index, SerializableFunction<E, R> name, R value, Predicate<R> ignoreStrategy) {
        return proxy.nin0(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L nin(int index, SerializableToIntFunction<E> name, int value) {
        return proxy.nin0(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L nin(int index, SerializableToIntFunction<E> name, int value, Predicate<Integer> ignoreStrategy) {
        return proxy.nin0(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L nin(int index, SerializableToLongFunction<E> name, long value) {
        return proxy.nin0(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L nin(int index, SerializableToLongFunction<E> name, long value, Predicate<Long> ignoreStrategy) {
        return proxy.nin0(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E, R> L nin(int index, SerializableFunction<E, R> name, @SuppressWarnings("unchecked") R... value) {
        return proxy.nin0(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L nin(int index, SerializableToIntFunction<E> name, int... value) {
        return proxy.nin0(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L nin(int index, SerializableToLongFunction<E> name, long... value) {
        return proxy.nin0(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E, R> L nin(int index, SerializableFunction<E, R> name, R[] value, Predicate<R[]> ignoreStrategy) {
        return proxy.nin0(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L nin(int index, SerializableToIntFunction<E> name, int[] value, Predicate<int[]> ignoreStrategy) {
        return proxy.nin0(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L nin(int index, SerializableToLongFunction<E> name, long[] value, Predicate<long[]> ignoreStrategy) {
        return proxy.nin0(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E, R> L nin(int index, SerializableFunction<E, R> name, Collection<R> value) {
        return proxy.nin0(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E, R> L nin(int index, SerializableFunction<E, R> name, Collection<R> value,
            Predicate<Collection<R>> ignoreStrategy) {
        return proxy.nin0(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E, R> L nin(int index, SerializableSupplier<R> property) {
        return proxy.nin0(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E, R> L nin(int index, SerializableSupplier<R> property, Predicate<R> ignoreStrategy) {
        return proxy.nin0(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E, R> L nin(int index, SerializableIntSupplier property) {
        return proxy.nin0(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E, R> L nin(int index, SerializableIntSupplier property, Predicate<Integer> ignoreStrategy) {
        return proxy.nin0(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E, R> L nin(int index, SerializableLongSupplier property) {
        return proxy.nin0(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E, R> L nin(int index, SerializableLongSupplier property, Predicate<Long> ignoreStrategy) {
        return proxy.nin0(index, property, ignoreStrategy);
    }

}
