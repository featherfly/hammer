
/*
 * All rights Reserved, Designed By zhongj
 * @Title: ConditionEntityExpressionLongProperty2Proxy.java
 * @Description: ConditionEntityExpressionLongProperty2Proxy
 * @author: zhongj
 * @date: 2023-09-21 17:46:21
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery;

import java.time.LocalDate;
import java.util.function.Function;
import java.util.function.Predicate;

import cn.featherfly.common.function.ThreeArgusConsumer;
import cn.featherfly.common.repository.mapping.PropertyMapping;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionLocalDatePropertyExpression;

/**
 * The Class ConditionEntityExpressionLocalDatePropertyExpressionImpl.
 *
 * @author zhongj
 */
public class ConditionEntityExpressionLocalDatePropertyExpressionImpl
        extends ConditionEntityExpressionPropertyExpressionImpl<LocalDate>
        implements ConditionEntityExpressionLocalDatePropertyExpression {

    /**
     * Instantiates a new condition entity expression local date property
     * expression impl.
     *
     * @param propertyMapping the property mapping
     * @param ignoreStrategy  the ignore strategy
     * @param setValue        the set value
     */
    public ConditionEntityExpressionLocalDatePropertyExpressionImpl(
            Function<LocalDate, PropertyMapping<?>> propertyMapping, Predicate<?> ignoreStrategy,
            ThreeArgusConsumer<LocalDate, Predicate<LocalDate>, PropertyMapping<?>> setValue) {
        super(propertyMapping, ignoreStrategy, setValue);
    }

}
