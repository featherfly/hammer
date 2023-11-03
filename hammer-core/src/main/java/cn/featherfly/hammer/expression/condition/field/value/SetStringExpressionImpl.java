
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
import cn.featherfly.common.function.ThreeArgusConsumer;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.mapping.PropertyMapping;

/**
 * set String expression implements.
 *
 * @author zhongj
 */
public class SetStringExpressionImpl implements SetStringExpression {

    private Function<String, PropertyMapping<?>> propertyMapping;

    private Predicate<?> ignoreStrategy;

    private FourArgusConsumer<String, MatchStrategy, Predicate<String>, PropertyMapping<?>> setValue;

    private ThreeArgusConsumer<String, MatchStrategy, Predicate<String>> setValue0;

    /**
     * Instantiates a new sets the string expression impl.
     *
     * @param ignoreStrategy the ignore strategy
     * @param setValue       the set value
     */
    public SetStringExpressionImpl(Predicate<?> ignoreStrategy,
            ThreeArgusConsumer<String, MatchStrategy, Predicate<String>> setValue) {
        this.ignoreStrategy = ignoreStrategy;
        setValue0 = setValue;
    }

    /**
     * Instantiates a new sets the string expression impl.
     *
     * @param propertyMapping the property mapping
     * @param ignoreStrategy  the ignore strategy
     * @param setValue        the set value
     */
    public SetStringExpressionImpl(Function<String, PropertyMapping<?>> propertyMapping, Predicate<?> ignoreStrategy,
            FourArgusConsumer<String, MatchStrategy, Predicate<String>, PropertyMapping<?>> setValue) {
        this.propertyMapping = propertyMapping;
        this.ignoreStrategy = ignoreStrategy;
        this.setValue = setValue;
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
        if (setValue0 != null) {
            setValue0.accept(value, matchStrategy, ignoreStrategy);
        } else {
            setValue.accept(value, matchStrategy, ignoreStrategy, propertyMapping.apply(value));
        }
    }
}
