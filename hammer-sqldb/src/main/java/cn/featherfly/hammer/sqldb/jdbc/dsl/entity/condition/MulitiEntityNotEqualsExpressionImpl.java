
/*
 * All rights Reserved, Designed By zhongj
 * @Title: MulitiEntityNotEqualsExpressionImpl.java
 * @Description: MulitiEntityNotEqualsExpressionImpl
 * @author: zhongj
 * @date: 2023-08-07 17:52:07
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition;

import java.util.function.Predicate;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableSupplier;
import cn.featherfly.common.operator.QueryOperator.QueryPolicy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.ne.MulitiEntityNotEqualsExpression;

/**
 * The Class MulitiEntityNotEqualsExpressionImpl.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class MulitiEntityNotEqualsExpressionImpl<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends MulitiEntityConditionExpressionProxy<C, L> implements MulitiEntityNotEqualsExpression<C, L> {

    /**
     * Instantiates a new muliti entity neuals expression impl.
     *
     * @param proxy the proxy
     */
    public MulitiEntityNotEqualsExpressionImpl(AbstractMulitiEntityConditionExpression<C, L> proxy) {
        super(proxy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E, R> L ne(int index, SerializableFunction<E, R> name, R value, QueryPolicy queryPolicy) {
        return proxy.ne0(index, name, value, queryPolicy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E, R> L ne(int index, SerializableFunction<E, R> name, R value, QueryPolicy queryPolicy,
            Predicate<R> ignoreStrategy) {
        return proxy.ne0(index, name, value, queryPolicy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ne(int index, SerializableSupplier<R> property, QueryPolicy queryPolicy) {
        return proxy.ne0(index, property, queryPolicy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> L ne(int index, SerializableSupplier<R> property, QueryPolicy queryPolicy, Predicate<R> ignoreStrategy) {
        return proxy.ne0(index, property, queryPolicy, ignoreStrategy);
    }

}
