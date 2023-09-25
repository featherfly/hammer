
/*
 * All rights Reserved, Designed By zhongj
 * @Title: ConditionEntityExpressionIntegerProperty2Proxy.java
 * @Description: ConditionEntityExpressionIntegerProperty2Proxy
 * @author: zhongj
 * @date: 2023-09-21 17:46:21
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery;

import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

import cn.featherfly.common.function.ThreeArgusConsumer;
import cn.featherfly.common.repository.mapping.PropertyMapping;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionIntAndArrayPropertyExpression;

/**
 * The Class ConditionEntityExpressionIntegerArrayPropertyExpressionImpl.
 *
 * @author zhongj
 */
public class ConditionEntityExpressionIntAndArrayPropertyExpressionImpl
        extends ConditionEntityExpressionIntPropertyExpressionImpl
        implements ConditionEntityExpressionIntAndArrayPropertyExpression {

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
    public ConditionEntityExpressionIntAndArrayPropertyExpressionImpl(
            Function<Integer, PropertyMapping<?>> getPropertyMapping, Predicate<?> ignoreStrategy,
            ThreeArgusConsumer<Integer, IntPredicate, PropertyMapping<?>> setValue,
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
