
/*
 * All rights Reserved, Designed By zhongj
 * @Title: MulitiEntityContainsExpressionImpl.java
 * @Package cn.featherfly.hammer.expression.entity.swndition.sw
 * @Description: MulitiEntityContainsExpressionImpl
 * @author: zhongj
 * @date: 2023-07-28 16:58:28
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition;

import java.util.function.Predicate;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableSupplier;
import cn.featherfly.common.operator.QueryOperator.QueryPolicy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.sw.MulitiEntityStartWithExpression;

/**
 * MulitiEntityContainsExpressionImpl.
 *
 * @author zhongj
 * @param <E>
 */
public class MulitiEntityStartWithExpressionImpl<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends MulitiEntityConditionExpressionProxy<C, L> implements MulitiEntityStartWithExpression<C, L> {

    /**
     * Instantiates a new muliti entity swntains expression impl.
     *
     * @param proxy the proxy
     */
    public MulitiEntityStartWithExpressionImpl(AbstractMulitiEntityConditionExpression<C, L> proxy) {
        super(proxy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L sw(int index, SerializableFunction<E, String> name, String value, QueryPolicy queryPolicy) {
        return proxy.sw0(index, name, value, queryPolicy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> L sw(int index, SerializableFunction<E, String> name, String value, QueryPolicy queryPolicy,
            Predicate<String> ignoreStrategy) {
        return proxy.sw0(index, name, value, queryPolicy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw(int index, SerializableSupplier<String> property, QueryPolicy queryPolicy) {
        return proxy.sw0(index, property, queryPolicy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw(int index, SerializableSupplier<String> property, QueryPolicy queryPolicy,
            Predicate<String> ignoreStrategy) {
        return proxy.sw0(index, property, queryPolicy, ignoreStrategy);
    }
}
