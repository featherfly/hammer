
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-03-19 14:53:19
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.condition.field.value;

import java.util.function.Function;
import java.util.function.Predicate;

import cn.featherfly.common.function.FourArgusConsumer;
import cn.featherfly.common.function.ThreeArgusConsumer;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.mapping.PropertyMapping;

/**
 * SetValueMatchStrategyExpressionImpl.
 *
 * @author zhongj
 */
public class SetValueMatchStrategyExpressionImpl<V> implements SetValueMatchStrategyExpression<V> {

    private Function<V, PropertyMapping<?>> propertyMapping;

    private Predicate<?> ignoreStrategy;

    private FourArgusConsumer<V, MatchStrategy, Predicate<V>, PropertyMapping<?>> setValue;

    private ThreeArgusConsumer<V, MatchStrategy, Predicate<V>> setValue0;

    /**
     * Instantiates a new sets the string expression impl.
     *
     * @param ignoreStrategy the ignore strategy
     * @param setValue       the set value
     */
    public SetValueMatchStrategyExpressionImpl(Predicate<?> ignoreStrategy,
            ThreeArgusConsumer<V, MatchStrategy, Predicate<V>> setValue) {
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
    public SetValueMatchStrategyExpressionImpl(Function<V, PropertyMapping<?>> propertyMapping,
            Predicate<?> ignoreStrategy,
            FourArgusConsumer<V, MatchStrategy, Predicate<V>, PropertyMapping<?>> setValue) {
        this.propertyMapping = propertyMapping;
        this.ignoreStrategy = ignoreStrategy;
        this.setValue = setValue;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public void value(V value, MatchStrategy matchStrategy) {
        value(value, matchStrategy, v -> ((Predicate<Object>) ignoreStrategy).test(value));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void value(V value, MatchStrategy matchStrategy, Predicate<V> ignoreStrategy) {
        if (setValue0 != null) {
            setValue0.accept(value, matchStrategy, ignoreStrategy);
        } else {
            setValue.accept(value, matchStrategy, ignoreStrategy, propertyMapping.apply(value));
        }
    }
}
