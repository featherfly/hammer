
/*
 * All rights Reserved, Designed By zhongj
 * @Title: ConditionEntityExpressionLongProperty2Proxy.java
 * @Description: ConditionEntityExpressionLongProperty2Proxy
 * @author: zhongj
 * @date: 2023-09-21 17:46:21
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery;

import java.util.function.Function;
import java.util.function.Predicate;

import cn.featherfly.common.function.ThreeArgusConsumer;
import cn.featherfly.common.repository.mapping.PropertyMapping;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionPropertyExpression;

/**
 * The Class ConditionEntityExpressionPropertyExpressionImpl.
 *
 * @author zhongj
 * @param <V> the value type
 */
public class ConditionEntityExpressionPropertyExpressionImpl<V>
        implements ConditionEntityExpressionPropertyExpression<V> {

    private Function<V, PropertyMapping<?>> propertyMapping;

    private Predicate<?> ignoreStrategy;

    private ThreeArgusConsumer<V, Predicate<V>, PropertyMapping<?>> setValue;

    /**
     * Instantiates a new condition entity expression property expression impl.
     *
     * @param propertyMapping the property mapping
     * @param ignoreStrategy  the ignore strategy
     * @param setValue        the set value
     */
    public ConditionEntityExpressionPropertyExpressionImpl(Function<V, PropertyMapping<?>> propertyMapping,
            Predicate<?> ignoreStrategy, ThreeArgusConsumer<V, Predicate<V>, PropertyMapping<?>> setValue) {
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
    public void value(V value) {
        value(value, v -> ((Predicate<Object>) ignoreStrategy).test(value));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void value(V value, Predicate<V> ignoreStrategy) {
        setValue.accept(value, ignoreStrategy, propertyMapping.apply(value));
    }
}
