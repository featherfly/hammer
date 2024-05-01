
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-15 16:07:15
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.condition;

import java.io.Serializable;
import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableBooleanSupplier;
import cn.featherfly.common.function.serializable.SerializableDoubleSupplier;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableIntSupplier;
import cn.featherfly.common.function.serializable.SerializableLongSupplier;
import cn.featherfly.common.function.serializable.SerializablePredicate;
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.function.serializable.SerializableToDoubleFunction;
import cn.featherfly.common.function.serializable.SerializableToIntFunction;
import cn.featherfly.common.function.serializable.SerializableToLongFunction;
import cn.featherfly.common.lang.AssertIllegalArgument;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.repository.mapping.PropertyMapping;
import cn.featherfly.hammer.config.dsl.ConditionConfig;

/**
 * abstract condition expression.
 *
 * @author zhongj
 * @param <C> the generic type
 */
public abstract class AbstractConditionExpression<C extends ConditionConfig<C>> implements IgnorableExpression {

    /** The condition config. */
    protected final C conditionConfig;

    /**
     * Instantiates a new abstract muliti condition expression.
     *
     * @param conditionConfig the condition config
     */
    protected AbstractConditionExpression(C conditionConfig) {
        AssertIllegalArgument.isNotNull(conditionConfig, "conditionConfig");
        this.conditionConfig = conditionConfig;
    }

    /**
     * Gets the property name.
     *
     * @param name the name
     * @return the property name
     */
    protected String getPropertyName(Serializable name) {
        return LambdaUtils.getLambdaPropertyName(name);
    }

    /**
     * Gets the property name.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return the property name
     */
    protected <R> String getPropertyName(SerializableSupplier<R> name) {
        return LambdaUtils.getLambdaPropertyName(name);
    }

    /**
     * Gets the property name.
     *
     * @param name the name
     * @return the property name
     */
    protected String getPropertyName(SerializableIntSupplier name) {
        return LambdaUtils.getLambdaPropertyName(name);
    }

    /**
     * Gets the property name.
     *
     * @param name the name
     * @return the property name
     */
    protected String getPropertyName(SerializableLongSupplier name) {
        return LambdaUtils.getLambdaPropertyName(name);
    }

    /**
     * Gets the property name.
     *
     * @param name the name
     * @return the property name
     */
    protected String getPropertyName(SerializableDoubleSupplier name) {
        return LambdaUtils.getLambdaPropertyName(name);
    }

    /**
     * Gets the property name.
     *
     * @param name the name
     * @return the property name
     */
    protected String getPropertyName(SerializableBooleanSupplier name) {
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
     * Gets the property name.
     *
     * @param <T>  the generic type
     * @param name the name
     * @return the property name
     */
    protected <T> String getPropertyName(SerializablePredicate<T> name) {
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
     * Gets the in param.
     *
     * @param value the value
     * @return the in param
     */
    protected abstract Object getInParam(Object value);

    /**
     * {@inheritDoc}
     */
    @Override
    public Predicate<Object> getIgnoreStrategy() {
        return conditionConfig.getIgnoreStrategy();
    }

    /**
     * Gets the condition config.
     *
     * @return the condition config
     */
    public C getConditionConfig() {
        return conditionConfig;
    }

    /**
     * Adds the condition.
     *
     * @param condition the condition
     * @return the object
     */
    public abstract Expression addCondition(Expression condition);
}
