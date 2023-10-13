
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
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionIntPropertyExpression;

/**
 * The Class ConditionEntityExpressionIntPropertyExpressionImpl.
 *
 * @author zhongj
 */
public class ConditionEntityExpressionIntPropertyExpressionImpl
        implements ConditionEntityExpressionIntPropertyExpression {

    private Function<Integer, PropertyMapping<?>> propertyMapping;

    private Predicate<?> ignoreStrategy;

    private ThreeArgusConsumer<Integer, IntPredicate, PropertyMapping<?>> setValue;

    /**
     * Instantiates a new condition entity expression int property expression
     * impl.
     *
     * @param propertyMapping the property mapping
     * @param ignoreStrategy  the ignore strategy
     * @param setValue        the set value
     */
    public ConditionEntityExpressionIntPropertyExpressionImpl(Function<Integer, PropertyMapping<?>> propertyMapping,
            Predicate<?> ignoreStrategy, ThreeArgusConsumer<Integer, IntPredicate, PropertyMapping<?>> setValue) {
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
    public void value(int value) {
        value(value, v -> ((Predicate<Object>) ignoreStrategy).test(v));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void value(int value, IntPredicate ignoreStrategy) {
        setValue.accept(value, ignoreStrategy, propertyMapping.apply(value));
    }
}