
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-09-21 17:46:21
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.condition.field.value;

import java.util.function.Function;
import java.util.function.Predicate;

import cn.featherfly.common.function.ThreeArgusConsumer;
import cn.featherfly.common.repository.mapping.PropertyMapping;

/**
 * set array expression implements.
 *
 * @author zhongj
 * @param <V> the value type
 */
public class SetArrayExpressionImpl<V> implements SetArrayExpression<V> {

    private Function<V, PropertyMapping<?>> getPropertyMapping;

    private Predicate<?> ignoreStrategy;

    private ThreeArgusConsumer<V, Predicate<V>, PropertyMapping<?>> setValue;

    private Function<V[], PropertyMapping<?>> getArrayPropertyMapping;

    private Predicate<?> ignoreArrayStrategy;

    private ThreeArgusConsumer<V[], Predicate<V[]>, PropertyMapping<?>> setArrayValue;

    /**
     * Instantiates a new condition entity expression array property expression
     * impl.
     *
     * @param getPropertyMapping      the get property mapping
     * @param ignoreStrategy          the ignore strategy
     * @param setValue                the set value
     * @param getArrayPropertyMapping the get array property mapping
     * @param ignoreArrayStrategy     the ignore array strategy
     * @param setArrayValue           the set array value
     */
    public SetArrayExpressionImpl(Function<V, PropertyMapping<?>> getPropertyMapping, Predicate<?> ignoreStrategy,
            ThreeArgusConsumer<V, Predicate<V>, PropertyMapping<?>> setValue,
            Function<V[], PropertyMapping<?>> getArrayPropertyMapping, Predicate<V[]> ignoreArrayStrategy,
            ThreeArgusConsumer<V[], Predicate<V[]>, PropertyMapping<?>> setArrayValue) {
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
    public void value(V value) {
        value(value, v -> ((Predicate<Object>) ignoreStrategy).test(value));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void value(V value, Predicate<V> ignoreStrategy) {
        setValue.accept(value, ignoreStrategy, getPropertyMapping.apply(value));
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public void value(V... value) {
        value(value, v -> ((Predicate<Object>) ignoreArrayStrategy).test(value));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void value(V[] value, Predicate<V[]> ignoreStrategy) {
        setArrayValue.accept(value, ignoreStrategy, getArrayPropertyMapping.apply(value));
    }
}
