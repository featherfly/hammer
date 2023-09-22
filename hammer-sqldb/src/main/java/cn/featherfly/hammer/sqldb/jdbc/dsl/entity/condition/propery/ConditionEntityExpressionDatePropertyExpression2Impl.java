
/*
 * All rights Reserved, Designed By zhongj
 * @Title: ConditionEntityExpressionLongProperty2Proxy.java
 * @Description: ConditionEntityExpressionLongProperty2Proxy
 * @author: zhongj
 * @date: 2023-09-21 17:46:21
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery;

import java.util.Date;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

import cn.featherfly.common.function.FourArgusConsumer;
import cn.featherfly.common.repository.mapping.PropertyMapping;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionDatePropertyExpression2;

/**
 * The Class ConditionEntityExpressionDatePropertyExpression2Impl.
 *
 * @author zhongj
 * @param <D> the generic type
 */
public class ConditionEntityExpressionDatePropertyExpression2Impl<D extends Date>
        extends ConditionEntityExpressionPropertyExpression2Impl<D>
        implements ConditionEntityExpressionDatePropertyExpression2<D> {

    /**
     * Instantiates a new condition entity expression date property expression 2
     * impl.
     *
     * @param propertyMapping the property mapping
     * @param ignoreStrategy  the ignore strategy
     * @param setValue        the set value
     */
    public ConditionEntityExpressionDatePropertyExpression2Impl(Function<D, PropertyMapping<?>> propertyMapping,
            Predicate<?> ignoreStrategy, FourArgusConsumer<D, D, BiPredicate<D, D>, PropertyMapping<?>> setValue) {
        super(propertyMapping, ignoreStrategy, setValue);
    }

}
