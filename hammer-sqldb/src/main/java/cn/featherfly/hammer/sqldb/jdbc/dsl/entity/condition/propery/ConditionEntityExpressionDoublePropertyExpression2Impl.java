
/*
 * All rights Reserved, Designed By zhongj
 * @Title: ConditionEntityExpressionDoubleProperty2Proxy.java
 * @Description: ConditionEntityExpressionDoubleProperty2Proxy
 * @author: zhongj
 * @date: 2023-09-21 17:46:21
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery;

import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

import cn.featherfly.common.function.FourArgusConsumer;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.repository.mapping.PropertyMapping;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionDoublePropertyExpression2;

/**
 * ConditionEntityExpressionDoublePropertyExpression2Proxy.
 *
 * @author zhongj
 */
public class ConditionEntityExpressionDoublePropertyExpression2Impl
        implements ConditionEntityExpressionDoublePropertyExpression2 {

    private Function<Double, PropertyMapping<?>> propertyMapping;

    private Predicate<?> ignoreStrategy;

    private FourArgusConsumer<Double, Double, BiPredicate<Double, Double>, PropertyMapping<?>> setValue;

    /**
     * Instantiates a new condition entity expression property expression 2
     * proxy.
     *
     * @param propertyMapping the property mapping
     * @param ignoreStrategy  the ignore strategy
     * @param setValue        the set value
     */
    public ConditionEntityExpressionDoublePropertyExpression2Impl(Function<Double, PropertyMapping<?>> propertyMapping,
            Predicate<?> ignoreStrategy,
            FourArgusConsumer<Double, Double, BiPredicate<Double, Double>, PropertyMapping<?>> setValue) {
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
    public void value(double min, double max) {
        value(min, max, (s, l) -> ((Predicate<Object>) ignoreStrategy).test(new Object[] { s, l }));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void value(double min, double max, BiPredicate<Double, Double> ignoreStrategy) {
        setValue.accept(min, max, ignoreStrategy, propertyMapping.apply(Lang.pick(min, max)));
    }
}
