
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-09-21 17:46:21
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.condition.field.value;

import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

import cn.featherfly.common.function.ThreeArgusConsumer;
import cn.featherfly.common.repository.mapping.PropertyMapping;

/**
 * set long expression implements.
 *
 * @author zhongj
 */
public class SetLongExpressionImpl implements SetLongExpression {

    private Function<Long, PropertyMapping<?>> propertyMapping;

    private ThreeArgusConsumer<Long, LongPredicate, PropertyMapping<?>> setValue;

    private Predicate<?> ignoreStrategy;

    private BiConsumer<Long, LongPredicate> setValue0;

    /**
     * Instantiates a new condition entity expression long property expression
     * impl.
     *
     * @param setValue the set value
     */
    public SetLongExpressionImpl(Predicate<?> ignoreStrategy, BiConsumer<Long, LongPredicate> setValue) {
        super();
        this.ignoreStrategy = ignoreStrategy;
        setValue0 = setValue;
    }

    /**
     * Instantiates a new condition entity expression long property expression
     * impl.
     *
     * @param propertyMapping the property mapping
     * @param ignoreStrategy  the ignore strategy
     * @param setValue        the set value
     */
    public SetLongExpressionImpl(Function<Long, PropertyMapping<?>> propertyMapping, Predicate<?> ignoreStrategy,
            ThreeArgusConsumer<Long, LongPredicate, PropertyMapping<?>> setValue) {
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
    public void value(long value) {
        value(value, v -> ((Predicate<Object>) ignoreStrategy).test(v));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void value(long value, LongPredicate ignoreStrategy) {
        if (setValue0 != null) {
            setValue0.accept(value, ignoreStrategy);
        } else {
            setValue.accept(value, ignoreStrategy, propertyMapping.apply(value));
        }
    }
}
