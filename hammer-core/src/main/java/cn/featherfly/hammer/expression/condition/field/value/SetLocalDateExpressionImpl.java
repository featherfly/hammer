
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-09-21 17:46:21
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.condition.field.value;

import java.time.LocalDate;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;

import cn.featherfly.common.function.ThreeArgusConsumer;
import cn.featherfly.common.repository.mapping.PropertyMapping;

/**
 * set LocalDateExpression implements.
 *
 * @author zhongj
 */
public class SetLocalDateExpressionImpl extends SetValueExpressionImpl<LocalDate> implements SetLocalDateExpression {

    /**
     * Instantiates a new sets the local date expression impl.
     *
     * @param ignoreStrategy the ignore strategy
     * @param setValue       the set value
     */
    public SetLocalDateExpressionImpl(Predicate<?> ignoreStrategy,
            BiConsumer<LocalDate, Predicate<LocalDate>> setValue) {
        super(ignoreStrategy, setValue);
    }

    /**
     * Instantiates a new condition entity expression local date property
     * expression impl.
     *
     * @param propertyMapping the property mapping
     * @param ignoreStrategy  the ignore strategy
     * @param setValue        the set value
     */
    public SetLocalDateExpressionImpl(Function<LocalDate, PropertyMapping<?>> propertyMapping,
            Predicate<?> ignoreStrategy,
            ThreeArgusConsumer<LocalDate, Predicate<LocalDate>, PropertyMapping<?>> setValue) {
        super(propertyMapping, ignoreStrategy, setValue);
    }

}
