
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-09-21 17:46:21
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.condition.field.value;

import java.time.LocalTime;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;

import cn.featherfly.common.function.ThreeArgusConsumer;
import cn.featherfly.common.repository.mapping.PropertyMapping;

/**
 * set LocalTime expression implements.
 *
 * @author zhongj
 */
public class SetLocalTimeExpressionImpl extends SetValueExpressionImpl<LocalTime> implements SetLocalTimeExpression {

    /**
     * Instantiates a new sets the local time expression impl.
     *
     * @param ignoreStrategy the ignore strategy
     * @param setValue       the set value
     */
    public SetLocalTimeExpressionImpl(Predicate<?> ignoreStrategy,
            BiConsumer<LocalTime, Predicate<LocalTime>> setValue) {
        super(ignoreStrategy, setValue);
    }

    /**
     * Instantiates a new condition entity expression local time property
     * expression impl.
     *
     * @param propertyMapping the property mapping
     * @param ignoreStrategy  the ignore strategy
     * @param setValue        the set value
     */
    public SetLocalTimeExpressionImpl(Function<LocalTime, PropertyMapping<?>> propertyMapping,
            Predicate<?> ignoreStrategy,
            ThreeArgusConsumer<LocalTime, Predicate<LocalTime>, PropertyMapping<?>> setValue) {
        super(propertyMapping, ignoreStrategy, setValue);
    }

}
