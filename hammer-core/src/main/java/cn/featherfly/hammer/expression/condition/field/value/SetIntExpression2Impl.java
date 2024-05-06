
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-13 18:44:13
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
 * set int expression2 implements.
 *
 * @author zhongj
 */
public class SetIntExpression2Impl implements SetIntExpression2 {

    private Function<Integer, PropertyMapping<?>> propertyMapping;

    private Predicate<?> ignoreStrategy;

    private FourArgusConsumer<Integer, Integer, BiPredicate<Integer, Integer>, PropertyMapping<?>> setValue;

    /**
     * Instantiates a new condition entity expression int property expression 2 impl.
     *
     * @param propertyMapping the property mapping
     * @param ignoreStrategy  the ignore strategy
     * @param setValue        the set value
     */
    public SetIntExpression2Impl(Function<Integer, PropertyMapping<?>> propertyMapping, Predicate<?> ignoreStrategy,
            FourArgusConsumer<Integer, Integer, BiPredicate<Integer, Integer>, PropertyMapping<?>> setValue) {
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
    public void value(int min, int max) {
        value(min, max, (s, l) -> ((Predicate<Object>) ignoreStrategy).test(new Object[] { s, l }));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void value(int min, int max, BiPredicate<Integer, Integer> ignoreStrategy) {
        setValue.accept(min, max, ignoreStrategy, propertyMapping.apply(Lang.ifNull(min, max)));
    }
}
