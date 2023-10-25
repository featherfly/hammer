
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

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableToDoubleFunction;
import cn.featherfly.common.function.serializable.SerializableToIntFunction;
import cn.featherfly.common.function.serializable.SerializableToLongFunction;
import cn.featherfly.common.lang.AssertIllegalArgument;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.repository.mapping.PropertyMapping;
import cn.featherfly.hammer.config.dsl.ConditionConfig;

/**
 * The Class AbstractMulitiConditionExpression.
 *
 * @author zhongj
 */
public abstract class AbstractMulitiConditionExpression implements MulitiConditionExpression {

    /** The condition config. */
    protected ConditionConfig<?> conditionConfig;

    /**
     * Instantiates a new abstract muliti condition expression.
     *
     * @param conditionConfig the condition config
     */
    protected AbstractMulitiConditionExpression(ConditionConfig<?> conditionConfig) {
        AssertIllegalArgument.isNotNull(conditionConfig, "conditionConfig");
        this.conditionConfig = conditionConfig;
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
     * get ignoreStrategy value.
     *
     * @return ignoreStrategy
     */
    public Predicate<?> getIgnoreStrategy() {
        return conditionConfig.getIgnoreStrategy();
    }

    /**
     * Gets the condition config.
     *
     * @return the condition config
     */
    public ConditionConfig<?> getConditionConfig() {
        return conditionConfig;
    }

}
