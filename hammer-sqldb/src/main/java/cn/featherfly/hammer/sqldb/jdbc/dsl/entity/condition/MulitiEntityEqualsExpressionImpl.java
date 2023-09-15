
/*
 * All rights Reserved, Designed By zhongj
 * @Title: MulitiEntityEqualsExpressionImpl.java
 * @Description: MulitiEntityEqualsExpressionImpl
 * @author: zhongj
 * @date: 2023-08-07 17:52:07
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.eq.MulitiEntityEqualsExpression;

/**
 * MulitiEntityEqualsExpressionImpl.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class MulitiEntityEqualsExpressionImpl<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends MulitiEntityConditionExpressionProxy<C, L> implements MulitiEntityEqualsExpression<C, L> {

    /**
     * Instantiates a new muliti entity equals expression impl.
     *
     * @param proxy the proxy
     */
    public MulitiEntityEqualsExpressionImpl(AbstractMulitiEntityConditionExpression<C, L> proxy) {
        super(proxy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E, R> L eq(int index, SerializableFunction<E, R> name, R value, MatchStrategy matchStrategy) {
        return proxy.eq0(index, name, value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E, R> L eq(int index, SerializableFunction<E, R> name, R value, MatchStrategy matchStrategy,
            Predicate<R> ignoreStrategy) {
        return proxy.eq0(index, name, value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L eq(int index, SerializableSupplier<R> property, MatchStrategy matchStrategy) {
        return proxy.eq0(index, property, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L eq(int index, SerializableSupplier<R> property, MatchStrategy matchStrategy,
            Predicate<R> ignoreStrategy) {
        return proxy.eq0(index, property, matchStrategy, ignoreStrategy);
    }

}
