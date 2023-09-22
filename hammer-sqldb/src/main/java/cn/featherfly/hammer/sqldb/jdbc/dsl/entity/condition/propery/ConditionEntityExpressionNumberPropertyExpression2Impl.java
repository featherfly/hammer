
/*
 * All rights Reserved, Designed By zhongj
 * @Title: ConditionEntityExpressionLongProperty2Proxy.java
 * @Description: ConditionEntityExpressionLongProperty2Proxy
 * @author: zhongj
 * @date: 2023-09-21 17:46:21
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery;

import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

import cn.featherfly.common.function.FourArgusConsumer;
import cn.featherfly.common.repository.mapping.PropertyMapping;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionNumberPropertyExpression2;

/**
 * The Class ConditionEntityExpressionNumberPropertyExpression2Impl.
 *
 * @author zhongj
 * @param <N> the number type
 */
public class ConditionEntityExpressionNumberPropertyExpression2Impl<N extends Number>
        extends ConditionEntityExpressionPropertyExpression2Impl<N>
        implements ConditionEntityExpressionNumberPropertyExpression2<N> {

    /**
     * Instantiates a new condition entity expression number property expression
     * 2 impl.
     *
     * @param propertyMapping the property mapping
     * @param ignoreStrategy  the ignore strategy
     * @param setValue        the set value
     */
    public ConditionEntityExpressionNumberPropertyExpression2Impl(Function<N, PropertyMapping<?>> propertyMapping,
            Predicate<?> ignoreStrategy, FourArgusConsumer<N, N, BiPredicate<N, N>, PropertyMapping<?>> setValue) {
        super(propertyMapping, ignoreStrategy, setValue);
    }

}
