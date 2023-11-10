
/*
 * All rights Reserved, Designed By zhongj
 * @Title: ConditionEntityExpressionLongProperty2Proxy.java
 * @Description: ConditionEntityExpressionLongProperty2Proxy
 * @author: zhongj
 * @date: 2023-09-21 17:46:21
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.condition.field.value;

import java.util.function.Function;
import java.util.function.Predicate;

import cn.featherfly.common.function.FourArgusConsumer;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.mapping.PropertyMapping;

/**
 * set String array expression implements.
 *
 * @author zhongj
 */
public class SetStringArrayExpressionImpl implements SetStringArrayExpression {

    /** The get property mapping. */
    private Function<String, PropertyMapping<?>> getPropertyMapping;

    /** The ignore strategy. */
    private Predicate<?> ignoreStrategy;

    /** The set value. */
    private FourArgusConsumer<String, MatchStrategy, Predicate<String>, PropertyMapping<?>> setValue;

    /** The get array property mapping. */
    private Function<String[], PropertyMapping<?>> getArrayPropertyMapping;

    /** The ignore array strategy. */
    private Predicate<?> ignoreArrayStrategy;

    /** The set array value. */
    private FourArgusConsumer<String[], MatchStrategy, Predicate<String[]>, PropertyMapping<?>> setArrayValue;

    /**
     * Instantiates a new condition entity expression string and array property
     * expression impl.
     *
     * @param getPropertyMapping      the get property mapping
     * @param ignoreStrategy          the ignore strategy
     * @param setValue                the set value
     * @param getArrayPropertyMapping the get array property mapping
     * @param ignoreArrayStrategy     the ignore array strategy
     * @param setArrayValue           the set array value
     */
    public SetStringArrayExpressionImpl(Function<String, PropertyMapping<?>> getPropertyMapping,
            Predicate<?> ignoreStrategy,
            FourArgusConsumer<String, MatchStrategy, Predicate<String>, PropertyMapping<?>> setValue,
            Function<String[], PropertyMapping<?>> getArrayPropertyMapping, Predicate<String[]> ignoreArrayStrategy,
            FourArgusConsumer<String[], MatchStrategy, Predicate<String[]>, PropertyMapping<?>> setArrayValue) {
        this.getPropertyMapping = getPropertyMapping;
        this.ignoreStrategy = ignoreStrategy;
        this.setValue = setValue;

        this.getArrayPropertyMapping = getArrayPropertyMapping;
        this.ignoreArrayStrategy = ignoreArrayStrategy;
        this.setArrayValue = setArrayValue;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public void value(String value, MatchStrategy matchStrategy) {
        value(value, matchStrategy, v -> ((Predicate<Object>) ignoreStrategy).test(value));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void value(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        setValue.accept(value, matchStrategy, ignoreStrategy, getPropertyMapping.apply(value));
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public void value(String[] value, MatchStrategy matchStrategy) {
        value(value, matchStrategy, v -> ((Predicate<Object>) ignoreArrayStrategy).test(value));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void value(String[] value, MatchStrategy matchStrategy, Predicate<String[]> ignoreStrategy) {
        setArrayValue.accept(value, matchStrategy, ignoreStrategy, getArrayPropertyMapping.apply(value));
    }
}
