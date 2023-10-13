
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

import cn.featherfly.common.function.FourArgusConsumer;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.mapping.PropertyMapping;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionStringPropertyExpression;

/**
 * The Class ConditionEntityExpressionStringPropertyExpressionImpl.
 *
 * @author zhongj
 */
public class ConditionEntityExpressionStringPropertyExpressionImpl
        implements ConditionEntityExpressionStringPropertyExpression {

    private Function<String, PropertyMapping<?>> propertyMapping;

    private Predicate<?> ignoreStrategy;

    private FourArgusConsumer<String, MatchStrategy, Predicate<String>, PropertyMapping<?>> setValue;

    /**
     * @param propertyMapping the property mapping
     * @param ignoreStrategy  the ignore strategy
     * @param setValue        the set value
     */
    public ConditionEntityExpressionStringPropertyExpressionImpl(Function<String, PropertyMapping<?>> propertyMapping,
            Predicate<?> ignoreStrategy,
            FourArgusConsumer<String, MatchStrategy, Predicate<String>, PropertyMapping<?>> setValue) {
        this.propertyMapping = propertyMapping;
        this.ignoreStrategy = ignoreStrategy;
        this.setValue = setValue;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public void value(String value, MatchStrategy matchStrategy) {
        value(value, matchStrategy, v -> ((Predicate<Object>) ignoreStrategy).test(value));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void value(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        setValue.accept(value, matchStrategy, ignoreStrategy, propertyMapping.apply(value));
    }
}
