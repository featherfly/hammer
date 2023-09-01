
/*
 * All rights Reserved, Designed By zhongj
 * @Title: MulitiEntityContainsExpressionImpl.java
 * @Package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition
 * @Description: MulitiEntityContainsExpressionImpl
 * @author: zhongj
 * @date: 2023-07-28 16:58:28
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.co.MulitiEntityContainsExpression;

/**
 * MulitiEntityContainsExpressionImpl.
 *
 * @author zhongj
 * @param <E>
 */
public class MulitiEntityContainsExpressionImpl<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends MulitiEntityConditionExpressionProxy<C, L> implements MulitiEntityContainsExpression<C, L> {

    /**
     * Instantiates a new muliti entity contains expression impl.
     *
     * @param proxy the proxy
     */
    public MulitiEntityContainsExpressionImpl(AbstractMulitiEntityConditionExpression<C, L> proxy) {
        super(proxy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L co(int index, SerializableFunction<E, String> name, String value, MatchStrategy queryPolicy) {
        return proxy.co0(index, name, value, queryPolicy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L co(int index, SerializableFunction<E, String> name, String value, MatchStrategy queryPolicy,
            Predicate<String> ignoreStrategy) {
        return proxy.co0(index, name, value, queryPolicy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(int index, SerializableSupplier<String> property, MatchStrategy queryPolicy) {
        return proxy.co0(index, property, queryPolicy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(int index, SerializableSupplier<String> property, MatchStrategy queryPolicy,
            Predicate<String> ignoreStrategy) {
        return proxy.co0(index, property, queryPolicy, ignoreStrategy);
    }
}
