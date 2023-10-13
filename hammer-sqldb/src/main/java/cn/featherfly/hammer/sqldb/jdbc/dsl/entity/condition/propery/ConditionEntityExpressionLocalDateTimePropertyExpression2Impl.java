
/*
 * All rights Reserved, Designed By zhongj
 * @Title: ConditionEntityExpressionLongProperty2Proxy.java
 * @Description: ConditionEntityExpressionLongProperty2Proxy
 * @author: zhongj
 * @date: 2023-09-21 17:46:21
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery;

import java.time.LocalDateTime;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

import cn.featherfly.common.function.FourArgusConsumer;
import cn.featherfly.common.repository.mapping.PropertyMapping;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionLocalDateTimePropertyExpression2;

/**
 * The Class ConditionEntityExpressionLocalDateTimePropertyExpression2Impl.
 *
 * @author zhongj
 */
public class ConditionEntityExpressionLocalDateTimePropertyExpression2Impl
        extends ConditionEntityExpressionPropertyExpression2Impl<LocalDateTime>
        implements ConditionEntityExpressionLocalDateTimePropertyExpression2 {

    /**
     * Instantiates a new condition entity expression local date time property
     * expression 2 impl.
     *
     * @param propertyMapping the property mapping
     * @param ignoreStrategy  the ignore strategy
     * @param setValue        the set value
     */
    public ConditionEntityExpressionLocalDateTimePropertyExpression2Impl(
            Function<LocalDateTime, PropertyMapping<?>> propertyMapping, Predicate<?> ignoreStrategy,
            FourArgusConsumer<LocalDateTime, LocalDateTime, BiPredicate<LocalDateTime, LocalDateTime>,
                    PropertyMapping<?>> setValue) {
        super(propertyMapping, ignoreStrategy, setValue);
    }

}
