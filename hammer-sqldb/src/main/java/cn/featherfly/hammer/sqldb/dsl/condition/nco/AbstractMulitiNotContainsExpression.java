/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-16 16:49:16
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.dsl.condition.nco;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.nco.MulitiNotContainsExpression;
import cn.featherfly.hammer.sqldb.dsl.condition.AbstractInternalMulitiConditionHolder;
import cn.featherfly.hammer.sqldb.dsl.condition.InternalMulitiCondition;

/**
 * abstract muliti not contains expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public abstract class AbstractMulitiNotContainsExpression<I extends InternalMulitiCondition<L>,
        C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends AbstractInternalMulitiConditionHolder<I, C, L> implements MulitiNotContainsExpression<C, L> {

    /**
     * Instantiates a new muliti not contains expression impl.
     *
     * @param internalMulitiCondition the internal muliti condition
     */
    protected AbstractMulitiNotContainsExpression(I internalMulitiCondition) {
        super(internalMulitiCondition);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L nco(int index, SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy) {
        return hold.nco(new AtomicInteger(index), name, value, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L nco(int index, SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        return hold.nco(new AtomicInteger(index), name, value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nco(int index, SerializableSupplier<String> property, MatchStrategy matchStrategy) {
        return hold.nco(new AtomicInteger(index), property, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nco(int index, SerializableSupplier<String> property, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        return hold.nco(new AtomicInteger(index), property, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nco(int index, String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return hold.nco(new AtomicInteger(index), name, value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nco(int index, String name, String value, MatchStrategy matchStrategy) {
        return hold.nco(new AtomicInteger(index), name, value, matchStrategy, getIgnoreStrategy());
    }
}
