
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-16 20:35:16
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.dsl.condition.nsw;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.nsw.MulitiNotStartWithExpression;
import cn.featherfly.hammer.sqldb.dsl.condition.AbstractInternalMulitiConditionHolder;
import cn.featherfly.hammer.sqldb.dsl.condition.InternalMulitiCondition;

/**
 * abstract muliti not start with expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class AbstractMulitiNotStartWithExpression<I extends InternalMulitiCondition<L>, C extends ConditionExpression,
        L extends LogicExpression<C, L>> extends AbstractInternalMulitiConditionHolder<I, C, L>
        implements MulitiNotStartWithExpression<C, L> {

    /**
     * Instantiates a new muliti entity not start with expression impl.
     *
     * @param internalMulitiCondition the internal muliti condition
     */
    protected AbstractMulitiNotStartWithExpression(I internalMulitiCondition) {
        super(internalMulitiCondition);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L nsw(int index, SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy) {
        return hold.nsw(new AtomicInteger(index), name, value, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L nsw(int index, SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        return hold.nsw(new AtomicInteger(index), name, value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nsw(int index, SerializableSupplier<String> property, MatchStrategy matchStrategy) {
        return hold.nsw(new AtomicInteger(index), property, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nsw(int index, SerializableSupplier<String> property, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        return hold.nsw(new AtomicInteger(index), property, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nsw(int index, String name, String value, MatchStrategy matchStrategy) {
        return hold.nsw(new AtomicInteger(index), name, value, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nsw(int index, String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return hold.nsw(new AtomicInteger(index), name, value, matchStrategy, ignoreStrategy);
    }
}
