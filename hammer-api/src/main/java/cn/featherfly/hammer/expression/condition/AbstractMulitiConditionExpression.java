
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

import java.io.Serializable;
import java.util.function.Predicate;

import cn.featherfly.common.lang.AssertIllegalArgument;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableToDoubleFunction;
import cn.featherfly.common.lang.function.SerializableToIntFunction;
import cn.featherfly.common.lang.function.SerializableToLongFunction;
import cn.featherfly.common.repository.mapping.PropertyMapping;

/**
 * The Class AbstractMulitiConditionExpression.
 *
 * @author zhongj
 */
public abstract class AbstractMulitiConditionExpression implements MulitiConditionExpression {

    protected Predicate<?> ignoreStrategy;

    /**
     * Instantiates a new abstract muliti condition expression.
     *
     * @param ignoreStrategy the ignore strategy
     */
    protected AbstractMulitiConditionExpression(Predicate<?> ignoreStrategy) {
        AssertIllegalArgument.isNotNull(ignoreStrategy, "ignoreStrategy");
        this.ignoreStrategy = ignoreStrategy;
    }

    /**
     * Gets the property name.
     *
     * @param <T>  the generic type
     * @param <R>  the generic type
     * @param name the name
     * @return the property name
     */
    protected <T, R> String getPropertyName(Serializable name) {
        return LambdaUtils.getLambdaPropertyName(name);
    }

    /**
     * Gets the property name.
     *
     * @param <T>  the generic type
     * @param <R>  the generic type
     * @param name the name
     * @return the property name
     */
    protected <T, R> String getPropertyName(SerializableFunction<T, R> name) {
        return LambdaUtils.getLambdaPropertyName(name);
    }

    /**
     * Gets the property name.
     *
     * @param <T>  the generic type
     * @param name the name
     * @return the property name
     */
    protected <T> String getPropertyName(SerializableToIntFunction<T> name) {
        return LambdaUtils.getLambdaPropertyName(name);
    }

    /**
     * Gets the property name.
     *
     * @param <T>  the generic type
     * @param name the name
     * @return the property name
     */
    protected <T> String getPropertyName(SerializableToLongFunction<T> name) {
        return LambdaUtils.getLambdaPropertyName(name);
    }

    /**
     * Gets the property name.
     *
     * @param <T>  the generic type
     * @param name the name
     * @return the property name
     */
    protected <T> String getPropertyName(SerializableToDoubleFunction<T> name) {
        return LambdaUtils.getLambdaPropertyName(name);
    }

    /**
     * Gets the in param.
     *
     * @param pm    the pm
     * @param value the value
     * @return the in param
     */
    protected abstract Object getInParam(PropertyMapping<?> pm, Object value);

    /**
     * get ignoreStrategy value
     *
     * @return ignoreStrategy
     */
    public Predicate<?> getIgnoreStrategy() {
        return ignoreStrategy;
    }
}
