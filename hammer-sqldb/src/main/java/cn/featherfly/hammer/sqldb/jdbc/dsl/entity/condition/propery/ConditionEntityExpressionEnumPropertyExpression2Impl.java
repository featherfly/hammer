
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
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionEnumPropertyExpression2;

/**
 * The Class ConditionEntityExpressionEnumPropertyExpression2Impl.
 *
 * @author zhongj
 * @param <E> the element type
 */
public class ConditionEntityExpressionEnumPropertyExpression2Impl<E extends Enum<E>>
        extends ConditionEntityExpressionPropertyExpression2Impl<E>
        implements ConditionEntityExpressionEnumPropertyExpression2<E> {

    /**
     * Instantiates a new condition entity expression enum property expression 2
     * impl.
     *
     * @param propertyMapping the property mapping
     * @param ignoreStrategy  the ignore strategy
     * @param setValue        the set value
     */
    public ConditionEntityExpressionEnumPropertyExpression2Impl(Function<E, PropertyMapping<?>> propertyMapping,
            Predicate<?> ignoreStrategy, FourArgusConsumer<E, E, BiPredicate<E, E>, PropertyMapping<?>> setValue) {
        super(propertyMapping, ignoreStrategy, setValue);
    }

}
