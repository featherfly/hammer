
/*
 * All rights Reserved, Designed By zhongj
 * @Title: ConditionEntityExpressionDoubleProperty2Proxy.java
 * @Description: ConditionEntityExpressionDoubleProperty2Proxy
 * @author: zhongj
 * @date: 2023-09-21 17:46:21
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery;

import java.util.function.Function;
import java.util.function.Predicate;

import cn.featherfly.common.function.ThreeArgusConsumer;
import cn.featherfly.common.repository.mapping.PropertyMapping;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionDoublePropertyExpression;

/**
 * ConditionEntityExpressionDoublePropertyExpression2Proxy.
 *
 * @author zhongj
 */
public class ConditionEntityExpressionDoublePropertyExpressionImpl
        implements ConditionEntityExpressionDoublePropertyExpression {

    private Function<Double, PropertyMapping<?>> propertyMapping;

    private Predicate<?> ignoreStrategy;

    private ThreeArgusConsumer<Double, Predicate<Double>, PropertyMapping<?>> setValue;

    /**
     * Instantiates a new condition entity expression property expression 2
     * proxy.
     *
     * @param propertyMapping the property mapping
     * @param ignoreStrategy  the ignore strategy
     * @param setValue        the set value
     */
    public ConditionEntityExpressionDoublePropertyExpressionImpl(Function<Double, PropertyMapping<?>> propertyMapping,
            Predicate<?> ignoreStrategy, ThreeArgusConsumer<Double, Predicate<Double>, PropertyMapping<?>> setValue) {
        super();
        this.propertyMapping = propertyMapping;
        this.ignoreStrategy = ignoreStrategy;
        this.setValue = setValue;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public void value(double value) {
        value(value, v -> ((Predicate<Object>) ignoreStrategy).test(v));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void value(double value, Predicate<Double> ignoreStrategy) {
        setValue.accept(value, ignoreStrategy, propertyMapping.apply(value));
    }
}
