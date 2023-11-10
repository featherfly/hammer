
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-09-21 17:46:21
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.condition.field.value;

import java.util.function.BiConsumer;
import java.util.function.DoublePredicate;
import java.util.function.Function;
import java.util.function.Predicate;

import cn.featherfly.common.function.ThreeArgusConsumer;
import cn.featherfly.common.repository.mapping.PropertyMapping;

/**
 * set double expression implements.
 *
 * @author zhongj
 */
public class SetDoubleExpressionImpl implements SetDoubleExpression {

    private Function<Double, PropertyMapping<?>> propertyMapping;

    private Predicate<?> ignoreStrategy;

    private ThreeArgusConsumer<Double, DoublePredicate, PropertyMapping<?>> setValue;

    private BiConsumer<Double, DoublePredicate> setValue0;

    /**
     * Instantiates a new condition entity expression property expression 2
     * proxy.
     *
     * @param ignoreStrategy the ignore strategy
     * @param setValue       the set value
     */
    public SetDoubleExpressionImpl(Predicate<?> ignoreStrategy, BiConsumer<Double, DoublePredicate> setValue) {
        super();
        this.ignoreStrategy = ignoreStrategy;
        setValue0 = setValue;
    }

    /**
     * Instantiates a new condition entity expression property expression 2
     * proxy.
     *
     * @param propertyMapping the property mapping
     * @param ignoreStrategy  the ignore strategy
     * @param setValue        the set value
     */
    public SetDoubleExpressionImpl(Function<Double, PropertyMapping<?>> propertyMapping, Predicate<?> ignoreStrategy,
            ThreeArgusConsumer<Double, DoublePredicate, PropertyMapping<?>> setValue) {
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
    public void value(double value, DoublePredicate ignoreStrategy) {
        if (setValue0 != null) {
            setValue0.accept(value, ignoreStrategy);
        } else {
            setValue.accept(value, ignoreStrategy, propertyMapping.apply(value));
        }
    }
}
