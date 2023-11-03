
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-09-21 17:46:21
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.condition.field.value;

import java.time.LocalTime;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

import cn.featherfly.common.function.FourArgusConsumer;
import cn.featherfly.common.repository.mapping.PropertyMapping;

/**
 * set LocalTime expression2 implements.
 *
 * @author zhongj
 */
public class SetLocalTimeExpression2Impl extends SetValueExpression2Impl<LocalTime> implements SetLocalTimeExpression2 {

    /**
     * Instantiates a new condition entity expression local time property
     * expression 2 impl.
     *
     * @param propertyMapping the property mapping
     * @param ignoreStrategy  the ignore strategy
     * @param setValue        the set value
     */
    public SetLocalTimeExpression2Impl(Function<LocalTime, PropertyMapping<?>> propertyMapping,
            Predicate<?> ignoreStrategy,
            FourArgusConsumer<LocalTime, LocalTime, BiPredicate<LocalTime, LocalTime>, PropertyMapping<?>> setValue) {
        super(propertyMapping, ignoreStrategy, setValue);
    }

}
