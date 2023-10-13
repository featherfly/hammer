
/*
 * All rights Reserved, Designed By zhongj
 * @Title: MulitiEntityContainsExpressionImpl.java
 * @Package cn.featherfly.hammer.expression.entity.condition.co
 * @Description: MulitiEntityContainsExpressionImpl
 * @author: zhongj
 * @date: 2023-07-28 16:58:28
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.condition;

import cn.featherfly.common.repository.mapping.ClassMapping;
import cn.featherfly.common.repository.mapping.PropertyMapping;

/**
 * The Class AbstractMulitiConditionExpression.
 *
 * @author zhongj
 */
public class MulitiConditionExpressionProxy implements MulitiConditionExpression {

    protected MulitiConditionExpression proxy;

    /**
     * Instantiates a new muliti entity contains expression impl.
     *
     * @param proxy the proxy
     */
    protected MulitiConditionExpressionProxy(MulitiConditionExpression proxy) {
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
