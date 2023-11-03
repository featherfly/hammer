/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-16 16:37:16
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.condition;

import java.util.function.Predicate;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.Expression;
import cn.featherfly.hammer.expression.condition.IgnorableExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Class AbstractInternalMulitiConditionHolder.
 *
 * @author zhongj
 * @param <I> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class AbstractInternalMulitiConditionHolder<I extends InternalMulitiCondition<L>, C extends ConditionExpression,
        L extends LogicExpression<C, L>>
        implements Expression, IgnorableExpression, InternalMulitiConditionHolder<I, L> {

    /** The hold. */
    protected I hold;

    /**
     * Instantiates a new muliti entity contains expression impl.
     *
     * @param hold the hold
     */
    protected AbstractInternalMulitiConditionHolder(I hold) {
        this.hold = hold;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String expression() {
        return hold.expression();
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <R> L eqOrNe(AtomicInteger index, ComparisonOperator comparisonOperator, PropertyMapping<?> pm, R value,
    //            MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
    //        return proxy.eqOrNe(index, comparisonOperator, pm, value, matchStrategy, ignoreStrategy);
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    protected <R> L eq_ne(int index, ComparisonOperator comparisonOperator, List<PropertyMapping<?>> pms, R value,
    //            MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
    //        return proxy.eq_ne(index, comparisonOperator, pms, value, matchStrategy, ignoreStrategy);
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public String getAlias(int index) {
    //        return proxy.getAlias(index);
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Predicate<Object> getIgnoreStrategy() {
        return hold.getIgnoreStrategy();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public I getHold() {
        return hold;
    }
}
