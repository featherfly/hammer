/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-13 18:45:13
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.condition.field.value;

import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

import cn.featherfly.common.function.ThreeArgusConsumer;
import cn.featherfly.common.repository.mapping.PropertyMapping;

/**
 * set int expression2 implements.
 *
 * @author zhongj
 */
public class SetIntExpressionImpl implements SetIntExpression {

    private Function<Integer, PropertyMapping<?>> propertyMapping;

    private Predicate<?> ignoreStrategy;

    private ThreeArgusConsumer<Integer, IntPredicate, PropertyMapping<?>> setValue;

    private BiConsumer<Integer, IntPredicate> setValue0;

    /**
     * Instantiates a new condition entity expression int property expression
     * impl.
     *
     * @param ignoreStrategy the ignore strategy
     * @param setValue       the set value
     */
    public SetIntExpressionImpl(Predicate<?> ignoreStrategy, BiConsumer<Integer, IntPredicate> setValue) {
        super();
        this.ignoreStrategy = ignoreStrategy;
        setValue0 = setValue;
    }

    /**
     * Instantiates a new condition entity expression int property expression
     * impl.
     *
     * @param propertyMapping the property mapping
     * @param ignoreStrategy  the ignore strategy
     * @param setValue        the set value
     */
    public SetIntExpressionImpl(Function<Integer, PropertyMapping<?>> propertyMapping, Predicate<?> ignoreStrategy,
            ThreeArgusConsumer<Integer, IntPredicate, PropertyMapping<?>> setValue) {
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
    public void value(int value) {
        value(value, v -> ((Predicate<Object>) ignoreStrategy).test(v));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void value(int value, IntPredicate ignoreStrategy) {
        if (setValue0 != null) {
            setValue0.accept(value, ignoreStrategy);
        } else {
            setValue.accept(value, ignoreStrategy, propertyMapping.apply(value));
        }
    }
}
