
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
import java.util.function.Function;
import java.util.function.Predicate;

import cn.featherfly.common.function.ThreeArgusConsumer;
import cn.featherfly.common.repository.mapping.PropertyMapping;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionLocalTimeAndArrayPropertyExpression;

/**
 * The Class ConditionEntityExpressionLocalTimeAndArrayPropertyExpressionImpl.
 *
 * @author zhongj
 */
public class ConditionEntityExpressionLocalTimeAndArrayPropertyExpressionImpl
        extends ConditionEntityExpressionArrayPropertyExpressionImpl<LocalTime>
        implements ConditionEntityExpressionLocalTimeAndArrayPropertyExpression {

    /**
     * Instantiates a new condition entity expression local time and array
     * property expression impl.
     *
     * @param getPropertyMapping      the get property mapping
     * @param ignoreStrategy          the ignore strategy
     * @param setValue                the set value
     * @param getArrayPropertyMapping the get array property mapping
     * @param ignoreArrayStrategy     the ignore array strategy
     * @param setArrayValue           the set array value
     */
    public ConditionEntityExpressionLocalTimeAndArrayPropertyExpressionImpl(
            Function<LocalTime, PropertyMapping<?>> getPropertyMapping, Predicate<?> ignoreStrategy,
            ThreeArgusConsumer<LocalTime, Predicate<LocalTime>, PropertyMapping<?>> setValue,
            Function<LocalTime[], PropertyMapping<?>> getArrayPropertyMapping,
            Predicate<LocalTime[]> ignoreArrayStrategy,
            ThreeArgusConsumer<LocalTime[], Predicate<LocalTime[]>, PropertyMapping<?>> setArrayValue) {
        super(getPropertyMapping, ignoreStrategy, setValue, getArrayPropertyMapping, ignoreArrayStrategy,
                setArrayValue);
    }

}
