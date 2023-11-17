
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-09-21 17:46:21
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.condition.field.value;

import java.time.LocalDateTime;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;

import cn.featherfly.common.function.ThreeArgusConsumer;
import cn.featherfly.common.repository.mapping.PropertyMapping;

/**
 * set LocalDateTime expression implements.
 *
 * @author zhongj
 */
public class SetLocalDateTimeExpressionImpl extends SetValueExpressionImpl<LocalDateTime>
        implements SetLocalDateTimeExpression {

    /**
     * Instantiates a new sets the local date time expression impl.
     *
     * @param ignoreStrategy the ignore strategy
     * @param setValue       the set value
     */
    public SetLocalDateTimeExpressionImpl(Predicate<?> ignoreStrategy,
            BiConsumer<LocalDateTime, Predicate<LocalDateTime>> setValue) {
        super(ignoreStrategy, setValue);
    }

    /**
     * Instantiates a new condition entity expression local date time property
     * expression impl.
     *
     * @param propertyMapping the property mapping
     * @param ignoreStrategy  the ignore strategy
     * @param setValue        the set value
     */
    public SetLocalDateTimeExpressionImpl(Function<LocalDateTime, PropertyMapping<?>> propertyMapping,
            Predicate<?> ignoreStrategy,
            ThreeArgusConsumer<LocalDateTime, Predicate<LocalDateTime>, PropertyMapping<?>> setValue) {
        super(propertyMapping, ignoreStrategy, setValue);
    }

}
