
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
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
 * set long expression2 implements.
 *
 * @author zhongj
 */
public class SetLongExpression2Impl implements SetLongExpression2 {

    private Function<Long, PropertyMapping<?>> propertyMapping;

    private Predicate<?> ignoreStrategy;

    private FourArgusConsumer<Long, Long, BiPredicate<Long, Long>, PropertyMapping<?>> setValue;

    /**
     * Instantiates a new condition entity expression long property expression 2
     * impl.
     *
     * @param propertyMapping the property mapping
     * @param ignoreStrategy  the ignore strategy
     * @param setValue        the set value
     */
    public SetLongExpression2Impl(Function<Long, PropertyMapping<?>> propertyMapping, Predicate<?> ignoreStrategy,
            FourArgusConsumer<Long, Long, BiPredicate<Long, Long>, PropertyMapping<?>> setValue) {
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
    public void value(long min, long max) {
        value(min, max, (s, l) -> ((Predicate<Object>) ignoreStrategy).test(new Object[] { s, l }));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void value(long min, long max, BiPredicate<Long, Long> ignoreStrategy) {
        setValue.accept(min, max, ignoreStrategy, propertyMapping.apply(Lang.pick(min, max)));
    }
}
