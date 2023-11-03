
/*
 * All rights Reserved, Designed By zhongj
 * @Title: ConditionEntityExpressionLongProperty2Proxy.java
 * @Description: ConditionEntityExpressionLongProperty2Proxy
 * @author: zhongj
 * @date: 2023-09-21 17:46:21
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.condition.field.value;

import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;

import cn.featherfly.common.function.ThreeArgusConsumer;
import cn.featherfly.common.repository.mapping.PropertyMapping;

/**
 * set value expression implements.
 *
 * @author zhongj
 * @param <V> the value type
 */
public class SetValueExpressionImpl<V> implements SetValueExpression<V> {

    private Function<V, PropertyMapping<?>> getPropertyMapping;

    private Predicate<?> ignoreStrategy;

    private ThreeArgusConsumer<V, Predicate<V>, PropertyMapping<?>> setValue;

    private BiConsumer<V, Predicate<V>> setValue0;

    /**
     * Instantiates a new condition entity expression property expression impl.
     *
     * @param ignoreStrategy the ignore strategy
     * @param setValue       the set value
     */
    public SetValueExpressionImpl(Predicate<?> ignoreStrategy, BiConsumer<V, Predicate<V>> setValue) {
        super();
        this.ignoreStrategy = ignoreStrategy;
        setValue0 = setValue;
    }

    /**
     * Instantiates a new condition entity expression property expression impl.
     *
     * @param getPropertyMapping the get property mapping
     * @param ignoreStrategy     the ignore strategy
     * @param setValue           the set value
     */
    public SetValueExpressionImpl(Function<V, PropertyMapping<?>> getPropertyMapping, Predicate<?> ignoreStrategy,
            ThreeArgusConsumer<V, Predicate<V>, PropertyMapping<?>> setValue) {
        super();
        this.getPropertyMapping = getPropertyMapping;
        this.ignoreStrategy = ignoreStrategy;
        this.setValue = setValue;
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
        if (setValue0 != null) {
            setValue0.accept(value, ignoreStrategy);
        } else {
            setValue.accept(value, ignoreStrategy, getPropertyMapping.apply(value));
        }
    }
}
