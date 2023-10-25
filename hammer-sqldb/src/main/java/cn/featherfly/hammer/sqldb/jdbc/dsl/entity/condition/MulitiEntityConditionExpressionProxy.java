
/*
 * All rights Reserved, Designed By zhongj
 * @Title: MulitiEntityContainsExpressionImpl.java
 * @Package cn.featherfly.hammer.expression.entity.condition.co
 * @Description: MulitiEntityContainsExpressionImpl
 * @author: zhongj
 * @date: 2023-07-28 16:58:28
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

import cn.featherfly.common.db.dialect.Dialect;
import cn.featherfly.common.operator.ComparisonOperator;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.mapping.ClassMapping;
import cn.featherfly.common.repository.mapping.PropertyMapping;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.Expression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Class AbstractMulitiEntityConditionExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class MulitiEntityConditionExpressionProxy<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends AbstractMulitiEntityConditionExpression<C, L> {

    protected AbstractMulitiEntityConditionExpression<C, L> proxy;

    /**
     * Instantiates a new muliti entity contains expression impl.
     *
     * @param proxy the proxy
     */
    protected MulitiEntityConditionExpressionProxy(AbstractMulitiEntityConditionExpression<C, L> proxy) {
        super(proxy.getConditionConfig());
        this.proxy = proxy;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String expression() {
        return proxy.expression();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected <R> L eq_ne(AtomicInteger index, ComparisonOperator comparisonOperator, PropertyMapping<?> pm, R value,
            MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
        return proxy.eq_ne(index, comparisonOperator, pm, value, matchStrategy, ignoreStrategy);
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    protected <R> L eq_ne(int index, ComparisonOperator comparisonOperator, List<PropertyMapping<?>> pms, R value,
    //            MatchStrategy matchStrategy, Predicate<?> ignoreStrategy) {
    //        return proxy.eq_ne(index, comparisonOperator, pms, value, matchStrategy, ignoreStrategy);
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Dialect getDialect() {
        return proxy.getDialect();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getAlias(int index) {
        return proxy.getAlias(index);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <M extends ClassMapping<T, P>, T, P extends PropertyMapping<P>> M getClassMapping(int index) {
        return (M) proxy.getClassMapping(index);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Expression addCondition(Expression condition) {
        return proxy.addCondition(condition);
    }
}
