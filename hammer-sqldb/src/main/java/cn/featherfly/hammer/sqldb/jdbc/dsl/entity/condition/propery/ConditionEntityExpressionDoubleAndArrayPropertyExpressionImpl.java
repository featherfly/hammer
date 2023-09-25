
/*
 * All rights Reserved, Designed By zhongj
 * @Title: ConditionEntityExpressionLongProperty2Proxy.java
 * @Description: ConditionEntityExpressionLongProperty2Proxy
 * @author: zhongj
 * @date: 2023-09-21 17:46:21
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery;

import java.util.function.DoublePredicate;
import java.util.function.Function;
import java.util.function.Predicate;

import cn.featherfly.common.function.ThreeArgusConsumer;
import cn.featherfly.common.repository.mapping.PropertyMapping;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionDoubleAndArrayPropertyExpression;

/**
 * The Class ConditionEntityExpressionLongAndArrayPropertyExpressionImpl.
 *
 * @author zhongj
 */
public class ConditionEntityExpressionDoubleAndArrayPropertyExpressionImpl
        extends ConditionEntityExpressionDoublePropertyExpressionImpl
        implements ConditionEntityExpressionDoubleAndArrayPropertyExpression {

    private Function<double[], PropertyMapping<?>> getArrayPropertyMapping;

    private Predicate<?> ignoreArrayStrategy;

    private ThreeArgusConsumer<double[], Predicate<double[]>, PropertyMapping<?>> setArrayValue;

    /**
     * Instantiates a new condition entity expression long and array property
     * expression impl.
     *
     * @param getPropertyMapping      the get property mapping
     * @param ignoreStrategy          the ignore strategy
     * @param setValue                the set value
     * @param getArrayPropertyMapping the get array property mapping
     * @param ignoreArrayStrategy     the ignore array strategy
     * @param setArrayValue           the set array value
     */
    public ConditionEntityExpressionDoubleAndArrayPropertyExpressionImpl(
            Function<Double, PropertyMapping<?>> getPropertyMapping, Predicate<?> ignoreStrategy,
            ThreeArgusConsumer<Double, DoublePredicate, PropertyMapping<?>> setValue,
            Function<double[], PropertyMapping<?>> getArrayPropertyMapping, Predicate<?> ignoreArrayStrategy,
            ThreeArgusConsumer<double[], Predicate<double[]>, PropertyMapping<?>> setArrayValue) {
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
    public void value(double... value) {
        value(value, v -> ((Predicate<Object>) ignoreArrayStrategy).test(v));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void value(double[] value, Predicate<double[]> ignoreStrategy) {
        setArrayValue.accept(value, ignoreStrategy, getArrayPropertyMapping.apply(value));
    }
}
