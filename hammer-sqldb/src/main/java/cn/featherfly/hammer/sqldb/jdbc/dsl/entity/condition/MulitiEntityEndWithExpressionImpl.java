
/*
 * All rights Reserved, Designed By zhongj
 * @Title: MulitiEntityEndWithExpressionImpl.java
 * @Package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition
 * @Description: MulitiEntityEndWithExpressionImpl
 * @author: zhongj
 * @date: 2023-07-28 16:58:28
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.ew.MulitiEntityEndWithExpression;

/**
 * MulitiEntityContainsExpressionImpl.
 *
 * @author zhongj
 * @param <E>
 */
public class MulitiEntityEndWithExpressionImpl<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends MulitiEntityConditionExpressionProxy<C, L> implements MulitiEntityEndWithExpression<C, L> {

    /**
     * Instantiates a new muliti entity ewntains expression impl.
     *
     * @param proxy the proxy
     */
    public MulitiEntityEndWithExpressionImpl(AbstractMulitiEntityConditionExpression<C, L> proxy) {
        super(proxy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L ew(int index, SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy) {
        return proxy.ew0(new AtomicInteger(index), name, value, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L ew(int index, SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        return proxy.ew0(new AtomicInteger(index), name, value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(int index, SerializableSupplier<String> property, MatchStrategy matchStrategy) {
        return proxy.ew0(new AtomicInteger(index), property, matchStrategy, getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(int index, SerializableSupplier<String> property, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        return proxy.ew0(new AtomicInteger(index), property, matchStrategy, ignoreStrategy);
    }
}
