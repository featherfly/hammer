
/*
 * All rights Reserved, Designed By zhongj
 * @Title: MulitiEntityEndWithExpressionImpl.java
 * @Package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition
 * @Description: MulitiEntityEndWithExpressionImpl
 * @author: zhongj
 * @date: 2023-07-28 16:58:28
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.dsl.condition.newv;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.newv.MulitiNotEndWithExpression;
import cn.featherfly.hammer.sqldb.dsl.condition.AbstractInternalMulitiConditionHolder;
import cn.featherfly.hammer.sqldb.dsl.condition.InternalMulitiCondition;

/**
 * abstract muliti not end with expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public abstract class AbstractMulitiNotEndWithExpression<I extends InternalMulitiCondition<L>,
        C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends AbstractInternalMulitiConditionHolder<I, C, L> implements MulitiNotEndWithExpression<C, L> {

    /**
     * Instantiates a new muliti not end with expression impl.
     *
     * @param internalMulitiCondition the internal muliti condition
     */
    protected AbstractMulitiNotEndWithExpression(I internalMulitiCondition) {
        super(internalMulitiCondition);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L newv(int index, SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy) {
        return hold.newv(new AtomicInteger(index), name, value, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L newv(int index, SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        return hold.newv(new AtomicInteger(index), name, value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L newv(int index, SerializableSupplier<String> property, MatchStrategy matchStrategy) {
        return hold.newv(new AtomicInteger(index), property, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L newv(int index, SerializableSupplier<String> property, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        return hold.newv(new AtomicInteger(index), property, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L newv(int index, String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return hold.newv(new AtomicInteger(index), name, value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L newv(int index, String name, String value, MatchStrategy matchStrategy) {
        return hold.newv(new AtomicInteger(index), name, value, matchStrategy, getIgnoreStrategy());
    }
}
