
/*
 * All rights Reserved, Designed By zhongj
 * @Title: ConditionEntityExpressionLongProperty2Proxy.java
 * @Description: ConditionEntityExpressionLongProperty2Proxy
 * @author: zhongj
 * @date: 2023-09-21 17:46:21
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.condition.field.value;

import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

import cn.featherfly.common.function.FourArgusConsumer;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.repository.mapping.PropertyMapping;

/**
 * set value expression2 implements.
 *
 * @author zhongj
 * @param <V> the value type
 */
public class SetValueExpression2Impl<V> implements SetValueExpression2<V> {

    private Function<V, PropertyMapping<?>> propertyMapping;

    private Predicate<?> ignoreStrategy;

    private FourArgusConsumer<V, V, BiPredicate<V, V>, PropertyMapping<?>> setValue;

    /**
     * Instantiates a new condition entity expression property expression 2
     * impl.
     *
     * @param propertyMapping the property mapping
     * @param ignoreStrategy  the ignore strategy
     * @param setValue        the set value
     */
    public SetValueExpression2Impl(Function<V, PropertyMapping<?>> propertyMapping, Predicate<?> ignoreStrategy,
            FourArgusConsumer<V, V, BiPredicate<V, V>, PropertyMapping<?>> setValue) {
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
    public void value(V min, V max) {
        value(min, max, (s, l) -> ((Predicate<Object>) ignoreStrategy).test(new Object[] { s, l }));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void value(V min, V max, BiPredicate<V, V> ignoreStrategy) {
        setValue.accept(min, max, ignoreStrategy, propertyMapping.apply(Lang.pick(min, max)));
    }
}
