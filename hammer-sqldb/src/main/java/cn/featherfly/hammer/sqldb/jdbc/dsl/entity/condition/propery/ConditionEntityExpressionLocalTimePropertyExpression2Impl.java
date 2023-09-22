
/*
 * All rights Reserved, Designed By zhongj
 * @Title: ConditionEntityExpressionLongProperty2Proxy.java
 * @Description: ConditionEntityExpressionLongProperty2Proxy
 * @author: zhongj
 * @date: 2023-09-21 17:46:21
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery;

import java.time.LocalTime;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

import cn.featherfly.common.function.FourArgusConsumer;
import cn.featherfly.common.repository.mapping.PropertyMapping;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionLocalTimePropertyExpression2;

/**
 * The Class ConditionEntityExpressionLocalTimePropertyExpression2Impl.
 *
 * @author zhongj
 */
public class ConditionEntityExpressionLocalTimePropertyExpression2Impl
        extends ConditionEntityExpressionPropertyExpression2Impl<LocalTime>
        implements ConditionEntityExpressionLocalTimePropertyExpression2 {

    /**
     * Instantiates a new condition entity expression local time property
     * expression 2 impl.
     *
     * @param propertyMapping the property mapping
     * @param ignoreStrategy  the ignore strategy
     * @param setValue        the set value
     */
    public ConditionEntityExpressionLocalTimePropertyExpression2Impl(
            Function<LocalTime, PropertyMapping<?>> propertyMapping, Predicate<?> ignoreStrategy,
            FourArgusConsumer<LocalTime, LocalTime, BiPredicate<LocalTime, LocalTime>, PropertyMapping<?>> setValue) {
        super(propertyMapping, ignoreStrategy, setValue);
    }

}
