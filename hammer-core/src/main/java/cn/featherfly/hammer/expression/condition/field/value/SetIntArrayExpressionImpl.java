/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-13 18:45:13
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.condition.field.value;

import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

import cn.featherfly.common.function.ThreeArgusConsumer;
import cn.featherfly.common.repository.mapping.PropertyMapping;

/**
 * set int array expression2 implements.
 *
 * @author zhongj
 */
public class SetIntArrayExpressionImpl extends SetIntExpressionImpl implements SetIntArrayExpression {

    private Function<int[], PropertyMapping<?>> getArrayPropertyMapping;

    private Predicate<?> ignoreArrayStrategy;

    private ThreeArgusConsumer<int[], Predicate<int[]>, PropertyMapping<?>> setArrayValue;

    /**
     * Instantiates a new condition entity expression integer array property
     * expression impl.
     *
     * @param getPropertyMapping      the get property mapping
     * @param ignoreStrategy          the ignore strategy
     * @param setValue                the set value
     * @param getArrayPropertyMapping the get array property mapping
     * @param ignoreArrayStrategy     the ignore array strategy
     * @param setArrayValue           the set array value
     */
    public SetIntArrayExpressionImpl(Function<Integer, PropertyMapping<?>> getPropertyMapping,
            Predicate<?> ignoreStrategy, ThreeArgusConsumer<Integer, IntPredicate, PropertyMapping<?>> setValue,
            Function<int[], PropertyMapping<?>> getArrayPropertyMapping, Predicate<?> ignoreArrayStrategy,
            ThreeArgusConsumer<int[], Predicate<int[]>, PropertyMapping<?>> setArrayValue) {
        super(getPropertyMapping, ignoreStrategy, setValue);
        this.getArrayPropertyMapping = getArrayPropertyMapping;
        this.ignoreArrayStrategy = ignoreArrayStrategy;
        this.setArrayValue = setArrayValue;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public void value(int... value) {
        value(value, v -> ((Predicate<Object>) ignoreArrayStrategy).test(v));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void value(int[] value, Predicate<int[]> ignoreStrategy) {
        setArrayValue.accept(value, ignoreStrategy, getArrayPropertyMapping.apply(value));
    }
}
